package de.any.crawl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequiredBeanContainer {

	private Set<RequiredBean> requiredBeans = new HashSet<>();

	public void addIfNotPresent(RequiredBean requiredBean) {
		this.requiredBeans.add(requiredBean);
	}

	public void addAllIfNotPresent(List<RequiredBean> requiredBeans) {
		this.requiredBeans.addAll(requiredBeans);
	}

	public List<RequiredBean> getRequiredBeans() {
		return new ArrayList<>(requiredBeans);
	}

}
