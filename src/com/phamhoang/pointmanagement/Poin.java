package com.phamhoang.pointmanagement;

import com.phamhoang.studentmanagement.student.StudentManagement;
import com.phamhoang.subjectmanagement.SubjectManagement;

public class Poin {
	private int studentCode;
	private int subjectCode;
	private double point;

	public void displayPoint() {
		int indexStudent = StudentManagement.indexOf(studentCode);
		if (indexStudent == -1) {
			return;
		}

		int indexSubject = SubjectManagement.indexOf(subjectCode);
		if (indexSubject == -1) {
			return;
		}
		String studentName = StudentManagement.listStudents.get(indexStudent).getName();
		String subjectName = SubjectManagement.listSubject.get(indexSubject).getSubjectName();
		double coefficient = SubjectManagement.listSubject.get(indexSubject).getCoefficient();
		System.out.printf("%-25s %-25s %-10.2f  %-5.2f %n", studentName, subjectName, coefficient, point);
	}

	public Poin(int studentCode, int subjectCode, double point) {
		super();
		this.studentCode = studentCode;
		this.subjectCode = subjectCode;
		this.point = point;
	}

	public Poin() {
		super();
	}

	public int getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
}
