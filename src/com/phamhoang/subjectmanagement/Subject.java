package com.phamhoang.subjectmanagement;

public class Subject {
	public static int autoIDSubject = 1;
	public int subjectId;
	private int subjectCode;
	private String subjectName;
	private double coefficient;

	public void display() {
		System.out.printf("%-3d %-5d %-25s %-5.2f%n", subjectId, subjectCode, subjectName, coefficient);
	}

	public Subject(int subjectCode, String subjectName, double coefficient) {
		super();
		this.subjectId = autoIDSubject++;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.coefficient = coefficient;
	}

	public Subject() {
		super();
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
}
