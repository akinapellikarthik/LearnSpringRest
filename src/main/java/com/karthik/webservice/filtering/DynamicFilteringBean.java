package com.karthik.webservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("id1")
public class DynamicFilteringBean {
	
	private String field1;
	
	private String field2;
	
	private String field3;

	public DynamicFilteringBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public DynamicFilteringBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}
	
	
	
	

}
