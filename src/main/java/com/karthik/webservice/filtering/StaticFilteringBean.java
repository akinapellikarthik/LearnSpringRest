package com.karthik.webservice.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StaticFilteringBean {
	
	@JsonIgnore
	private String field1;
	
	@JsonIgnore
	private String field2;
	
	private String field3;

	public StaticFilteringBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public StaticFilteringBean() {
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
