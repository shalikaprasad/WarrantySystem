package com.sarc.bean;

import javax.persistence.*;

/**
 * @author Sarc
 * @since 24-03-2019
 */

@Entity
@Table(name="company_info")
public class Company{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "branch_id", nullable = false)
	private int branchId;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "email")
	private String email;

	@Column(name = "password1")
	private String password1;

	@Column(name = "password2")
	private String password2;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "web")
	private String web;

	public int getBranchId() { return branchId; }

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword1() { return password1; }

	public void setPassword1(String password1) { this.password1 = password1; }

	public String getPassword2() { return password2; }

	public void setPassword2(String password2) { this.password2 = password2; }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Override
	public String toString() {
		return "Company{" +
				"branchId=" + branchId +
				", branchName='" + branchName + '\'' +
				", companyName='" + companyName + '\'' +
				", email='" + email + '\'' +
				", password1='" + password1 + '\'' +
				", password2='" + password2 + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", web='" + web + '\'' +
				'}';
	}


	}
