package com.sadad.web.rest.param;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.devk.commons.data.SortParamData;

/**
 * Indicates Sort parameters for JAX-RS end points.it converts JSON array to
 * desired {@link SortParamData} Objects.
 */
public class SortParam {

	private static final Logger logger = LoggerFactory.getLogger(SortParam.class);

	private List<SortParamData> sortParamList;

	// TODO FIXME check if replace it with a global one
	private static ObjectMapper objectMapper = new ObjectMapper();

	public SortParam(String json) {

		try {
			sortParamList = objectMapper.readValue(json, new TypeReference<List<SortParamData>>() {
			});
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			//just for avoiding null returns
			sortParamList = new ArrayList<>();
		}

	}

	/**
	 * @return immutable List of {@link SortParamData}
	 */
	public List<SortParamData> getSortParamsList() {
		return Collections.unmodifiableList(sortParamList);
	}

}