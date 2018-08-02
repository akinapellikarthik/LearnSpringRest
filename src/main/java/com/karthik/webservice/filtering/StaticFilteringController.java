package com.karthik.webservice.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {

	@GetMapping(path = "/static-filtering")
	public StaticFilteringBean getBean() {
		StaticFilteringBean staticFilteringBean = new StaticFilteringBean("FIELD1", "FIELD2", "FIELD3");
		return staticFilteringBean;
	}

	@GetMapping(path = "/static-filtering-list")
	public List<StaticFilteringBean> getListOfBean() {
		List<StaticFilteringBean> list = new ArrayList<>();
		StaticFilteringBean staticFilteringBean1 = new StaticFilteringBean("FIELD11", "FIELD12", "FIELD13");
		StaticFilteringBean staticFilteringBean2 = new StaticFilteringBean("FIELD21", "FIELD22", "FIELD23");
		StaticFilteringBean staticFilteringBean3 = new StaticFilteringBean("FIELD31", "FIELD32", "FIELD33");
		StaticFilteringBean staticFilteringBean4 = new StaticFilteringBean("FIELD41", "FIELD42", "FIELD43");

		list.add(staticFilteringBean1);
		list.add(staticFilteringBean2);
		list.add(staticFilteringBean3);
		list.add(staticFilteringBean4);

		return list;
	}
}
