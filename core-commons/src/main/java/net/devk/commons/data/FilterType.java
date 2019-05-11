package net.devk.commons.data;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FilterType {

	EQ, GT, GTE, LT, LTE, LIKE, CONTAINS, IN, IS_NULL, IS_NOT_NULL;

	@JsonCreator
	public static FilterType forValues(String filterType) {
		return FilterType.valueOf(filterType.toUpperCase());
	}

}
