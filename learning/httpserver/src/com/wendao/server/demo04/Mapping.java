package com.wendao.server.demo04;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <servlet-mapping>
		<servlet-name>login</servlet-name>
		<url-pattern>/login</url-pattern>
	</servlet-mapping>
	<servlet-mapping>
		<servlet-name>login</servlet-name>
		<url-pattern>/log</url-pattern>
	</servlet-mapping>
 * 
 * @author china
 *
 */
public class Mapping {
	private String name;
	private List<String> urlPattern;
	
	public Mapping() {
		this.urlPattern = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(List<String> urlPattern) {
		this.urlPattern = urlPattern;
	}
	
	
}
