package net.devk.commons.data;

import lombok.Data;

/**
 * Filter Param Data
 */
@Data
public class FilterParamData {

	private final String field;
	private final Object filter;
	private final FilterType type;

}
