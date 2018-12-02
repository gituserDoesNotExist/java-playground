/*
 * Created on 29.08.2018
 *
 * Dimensions - Versionierung
 * $Workfile: %PM% $
 * $Revision: %PR% $
 * $Date: %Date% $
 * $Author: %Author% $
 * 
 * (c) Copyright SV Informatik GmbH 2010
 */

package de.any.crawl;

import org.jdom2.Element;

public abstract class RequiredBean {

	protected String beanId;

	protected RequiredBean(String beanId) {
		this.beanId = beanId;
	}

	@SuppressWarnings("javadoc")
	public abstract Element getDescriptionForXmlConfiguration();

	public String getBeanId() {
		return beanId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beanId == null) ? 0 : beanId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequiredBean other = (RequiredBean) obj;
		if (beanId == null) {
			if (other.beanId != null)
				return false;
		} else if (!beanId.equals(other.beanId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%s]", getClass().getName(), beanId);
	}
}
