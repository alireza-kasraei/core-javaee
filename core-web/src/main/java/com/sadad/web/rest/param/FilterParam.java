package com.sadad.web.rest.param;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.devk.commons.data.FilterParamData;

/**
 * Indicates Filter parameters for JAX-RS end points.it converts JSON array to
 * desired {@link FilterParamData} Objects.
 */
public class FilterParam {

	private static final Logger logger = LoggerFactory.getLogger(FilterParam.class);

	private List<FilterParamData> filterParamList;

	// TODO FIXME check if replace it with a global one
	private static ObjectMapper objectMapper = new ObjectMapper();

	public FilterParam(String json) {

		try {
			// deserialize with jackson
			filterParamList = objectMapper.readValue(json, new TypeReference<List<FilterParamData>>() {
			});
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// just for avoiding null return
			filterParamList = new ArrayList<>();
		}

	}

	/**
	 * @return immutable List of {@link FilterParamData}
	 */
	public List<FilterParamData> getFilterParamsList() {
		return Collections.unmodifiableList(filterParamList);
	}

}
