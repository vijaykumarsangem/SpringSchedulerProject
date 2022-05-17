package com.codingworld.multitenant.model;

import java.io.Serializable;

public class Employee implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2051867896958356256L;

	private int empid;

	private String empname;

	private String tenantId;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
