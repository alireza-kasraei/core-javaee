package net.devk.commons.validation;

import net.devk.commons.exception.InvalidArgumentsException;

/**
 * this Utility class is a copy from {@link Preconditions} , it throws
 * {@link InvalidArgumentsException} instead of other types of unchecked
 * exceptions.
 */
public final class Preconditions {
	private Preconditions() {
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * @param expression
	 *            a boolean expression
	 * @throws InvalidArgumentsException
	 *             if {@code expression} is false
	 */
	public static void checkArgument(boolean expression) {
		if (!expression) {
			throw new InvalidArgumentsException();
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * @param expression
	 *            a boolean expression
	 * @param errorMessage
	 *            the exception message to use if the check fails; will be converted
	 *            to a string using {@link String#valueOf(Object)}
	 * @throws InvalidArgumentsException
	 *             if {@code expression} is false
	 */
	public static void checkArgument(boolean expression, Object errorMessage) {
		if (!expression) {
			throw new InvalidArgumentsException(String.valueOf(errorMessage));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * @param expression
	 *            a boolean expression
	 * @param errorMessageTemplate
	 *            a template for the exception message should the check fail. The
	 *            message is formed by replacing each {@code %s} placeholder in the
	 *            template with an argument. These are matched by position - the
	 *            first {@code %s} gets {@code
	 *     errorMessageArgs[0]}, etc. Unmatched arguments will be appended to the
	 *            formatted message in square braces. Unmatched placeholders will be
	 *            left as-is.
	 * @param errorMessageArgs
	 *            the arguments to be substituted into the message template.
	 *            Arguments are converted to strings using
	 *            {@link String#valueOf(Object)}.
	 * @throws InvalidArgumentsException
	 *             if {@code expression} is false
	 * @throws NullPointerException
	 *             if the check fails and either {@code errorMessageTemplate} or
	 *             {@code errorMessageArgs} is null (don't let this happen)
	 */
	public static void checkArgument(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
		if (!expression) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, errorMessageArgs));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, char p1) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, int p1) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, long p1) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, Object p1) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, char p1, char p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, char p1, int p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, char p1, long p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, char p1, Object p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, int p1, char p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, int p1, int p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, int p1, long p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, int p1, Object p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, long p1, char p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, long p1, int p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, long p1, long p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, long p1, Object p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, Object p1, char p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, Object p1, int p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, Object p1, long p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, Object p1, Object p2) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, Object p1, Object p2, Object p3) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2, p3));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters to the
	 * calling method.
	 *
	 * <p>
	 * See {@link #checkArgument(boolean, String, Object...)} for details.
	 */
	public static void checkArgument(boolean b, String errorMessageTemplate, Object p1, Object p2, Object p3,
			Object p4) {
		if (!b) {
			throw new InvalidArgumentsException(format(errorMessageTemplate, p1, p2, p3, p4));
		}
	}

	/**
	 * Substitutes each {@code %s} in {@code template} with an argument. These are
	 * matched by position: the first {@code %s} gets {@code args[0]}, etc. If there
	 * are more arguments than placeholders, the unmatched arguments will be
	 * appended to the end of the formatted message in square braces.
	 *
	 * @param template
	 *            a non-null string containing 0 or more {@code %s} placeholders.
	 * @param args
	 *            the arguments to be substituted into the message template.
	 *            Arguments are converted to strings using
	 *            {@link String#valueOf(Object)}. Arguments can be null.
	 */
	// Note that this is somewhat-improperly used from Verify.java as well.
	static String format(String template, Object... args) {
		template = String.valueOf(template); // null -> "null"

		// start substituting the arguments into the '%s' placeholders
		StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
		int templateStart = 0;
		int i = 0;
		while (i < args.length) {
			int placeholderStart = template.indexOf("%s", templateStart);
			if (placeholderStart == -1) {
				break;
			}
			builder.append(template, templateStart, placeholderStart);
			builder.append(args[i++]);
			templateStart = placeholderStart + 2;
		}
		builder.append(template, templateStart, template.length());

		// if we run out of placeholders, append the extra args in square braces
		if (i < args.length) {
			builder.append(" [");
			builder.append(args[i++]);
			while (i < args.length) {
				builder.append(", ");
				builder.append(args[i++]);
			}
			builder.append(']');
		}

		return builder.toString();
	}

}