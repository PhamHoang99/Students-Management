package com.phamhoang.studentmanagement.student;

public class Students {
	public static int autoID = 1;
	private int id;
	private int code;
	private String name;
	private String gender;
	private String birthday;
	private String address;

	public Students(int code, String name, String gender, String birthday, String address) {
		super();
		this.id = autoID++;
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}

	public void display() {
		System.out.printf("%-3d %-6d %-25s %-7s %-10s %-25s %n", id, code, name, gender, birthday, address);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Students() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
