package net.devk.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;

import net.devk.commons.data.SortParamData;

public class JpaUtils {

	private JpaUtils() {
	}

	/**
	 * suitable for situations where you apply criteria dynamically
	 * 
	 * @param root
	 * @param name Entity property name
	 * @return true if there is property with the given name
	 */
	public static boolean hasAttribute(Root<?> root, String name) {
		Set<?> attributes = root.getModel().getAttributes();
		Iterator<?> iterator = attributes.iterator();
		while (iterator.hasNext()) {
			Attribute<?, ?> attribute = (Attribute<?, ?>) iterator.next();
			if (attribute.getName().equals(name))
				return true;
		}
		return false;
	}

	/**
	 * creates List of {@link Order} from {@link SortParamData}s
	 * 
	 * @param criteriaBuilder
	 * @param root
	 * @param sorts
	 * @return
	 */
	public static List<Order> createJpaOrders(CriteriaBuilder criteriaBuilder, Root<?> root,
			List<SortParamData> sorts) {
		List<Order> orders = new ArrayList<>();
		for (SortParamData sortParamData : sorts) {
			if (JpaUtils.hasAttribute(root, sortParamData.getField())) {
				if (sortParamData.isAsc()) {
					orders.add(criteriaBuilder.asc(root.get(sortParamData.getField())));
				} else {
					orders.add(criteriaBuilder.desc(root.get(sortParamData.getField())));
				}
			}
		}
		return orders;
	}

}
