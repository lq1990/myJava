package com.wendao.atcrowdfunding.bean;

import java.util.ArrayList;
import java.util.List;

public class Permission {
	private Integer id;
	private String name;
	private Integer pid;
	private String url;
	private String icon;
	private boolean open = true; // 默认是否打开菜单
	private List<Permission> children = new ArrayList<Permission>();
	private boolean checked = false;
	

	public boolean isChecked() {
		return checked;
	}


	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	public Permission() {
		// TODO Auto-generated constructor stub
	}

	
	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public List<Permission> getChildren() {
		return children;
	}
	
	public void setChildren(List<Permission> children) {
		this.children = children;
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
