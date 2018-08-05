package com.karthik.webservice.filtering;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicController {

	@GetMapping("/dynamic-only-one-field")
	public MappingJacksonValue filteringOneField() {
		Set<String> properties = new HashSet<>(Arrays.asList("field1"));
		return mapping(properties);

	}
	
	
	@GetMapping("/dynamic-only-two-field")
	public MappingJacksonValue filteringTwoField() {
		Set<String> properties = new HashSet<>(Arrays.asList("field1", "field2"));
		return mapping(properties);

	}

	private MappingJacksonValue mapping(Set<String> properties) {
		DynamicFilteringBean dynamicFilteringBean = new DynamicFilteringBean("Field1", "Field2", "Field3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);
		FilterProvider fp = new SimpleFilterProvider().addFilter("id1", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(dynamicFilteringBean);
		mapping.setFilters(fp);

		return mapping;
	}

}
