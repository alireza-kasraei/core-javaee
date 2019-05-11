package net.devk.infrastructure.validator;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import net.devk.commons.exception.InvalidArgumentsException;


/**
 * CDI Interceptor for validating method arguments automatically if there were
 * annotated with {@link Valid} annotation.
 * 
 * it will throws {@link InvalidRestArgumentException} if it encounters first
 * invalid item.
 * 
 * @version 1 , we may return all invalid information to client
 */
@Interceptor
@Validated
public class ValidatorInterceptor implements Serializable {

	private static final String MESSAGE_TEMPLATE = "Model : %s , Property : %s , Reason : %s";

	private static final long serialVersionUID = 1L;

	@Inject
	private Validator validator;

	@AroundInvoke
	public Object intercept(InvocationContext invocationContext) throws Exception {
		Method method = invocationContext.getMethod();
		Annotation[][] annotations = method.getParameterAnnotations();
		if (annotations.length > 0) {
			Object[] parameterValues = invocationContext.getParameters();
			for (int i = 0; i < annotations.length; i++) {
				Annotation[] mainAnnotation = annotations[i];
				for (int j = 0; j < mainAnnotation.length; j++) {
					if (Valid.class.equals(mainAnnotation[j].annotationType())) {
						Set<ConstraintViolation<Object>> constraints = validator.validate(parameterValues[i]);
						if (!constraints.isEmpty()) {
							ConstraintViolation<Object> constraintViolation = constraints.iterator().next();
							throw new InvalidArgumentsException(constraintViolation.getPropertyPath().toString(),
									String.format(MESSAGE_TEMPLATE, constraintViolation.getLeafBean(),
											constraintViolation.getPropertyPath(), constraintViolation.getMessage()));
						}
					}
				}
			}
		}
		return invocationContext.proceed();
	}

}