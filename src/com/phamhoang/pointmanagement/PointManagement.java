package com.phamhoang.pointmanagement;

import java.util.ArrayList;
import java.util.Scanner;

import com.phamhoang.studentmanagement.student.StudentManagement;
import com.phamhoang.subjectmanagement.SubjectManagement;

public class PointManagement {
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Poin> listPoint = new ArrayList<Poin>();

	public static void UpdatePoints() {
		int choice;
		do {
			System.out.println("\n=========== UPDATE POINT =========");
			System.out.println("\t1. Add point");
			System.out.println("\t2. Update point");
			System.out.println("\t3. Delete point");
			System.out.println("\t4. Display point");
			System.out.println("\t0. Exit!");
			System.out.println("Your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				AddPoint();
				break;
			case 2:
				UpdatePoint();
				break;
			case 3:
				DeletePoint();
				break;
			case 4:
				Display();
				break;
			case 0:
				return;
			default:
				System.out.println("your choice is wrong!!!");
			}
		} while (true);
	}

	private static void AddPoint() {
		System.out.println("========== POINT MANAGEMENT =========");
		System.out.println("Input student code: ");
		int studentCode = Integer.parseInt(sc.nextLine());
		int indexStudent = StudentManagement.indexOf(studentCode);
		if (indexStudent == -1) {
			System.out.println("Not found this student.");
			return;
		}
		System.out.println("Input subject code");
		int subCode = Integer.parseInt(sc.nextLine());
		int indexSub = SubjectManagement.indexOf(subCode);
		if (indexSub == -1) {
			System.out.println("Not found this subject");
			return;
		}
		System.out.println("Input point: ");
		double point = Double.parseDouble(sc.nextLine());
		if (point < 0.0 || point > 10.0) {
			System.out.println("Wrong format!!!");
		}
		Poin p = new Poin(studentCode, subCode, point);
		listPoint.add(p);
		System.out.println("Add new point successful.");
	}

	private static void UpdatePoint() {
		System.out.println("=========== UPDATE POINT =========");
		System.out.println("Input student code: ");
		int studentCode = Integer.parseInt(sc.nextLine());
		int indexStudent = StudentManagement.indexOf(studentCode);
		if (indexStudent == -1) {
			System.out.println("Not found this student.");
			return;
		}
		System.out.println("Input subject code");
		int subCode = Integer.parseInt(sc.nextLine());
		int indexSub = SubjectManagement.indexOf(subCode);
		if (indexSub == -1) {
			System.out.println("Not found this subject");
			return;
		}
		System.out.println("Update new point: ");
		double point = Double.parseDouble(sc.nextLine());
		if (point < 0.0 || point > 10.0) {
			System.out.println("Wrong format!!!");
		}
		listPoint.get(indexStudent).setPoint(point);
		System.out.println("Update point successful.");
	}

	private static void DeletePoint() {
		System.out.println("============= DELETE POINT ============");
		System.out.println("Input student code: ");
		int stdCode = Integer.parseInt(sc.nextLine());
		int index = indexOf(stdCode);
		if (index == -1) {
			System.out.println("Not found this student!");
		}
		listPoint.remove(index);
		System.out.println("Delelte. ");
	}

	private static void Display() {
		System.out.println("=========== List point of student ===========");
		System.out.printf("%-3s %-25s %-25s %-5s %-5s%n", "STT", "Student Name", "Subjct Name", "Coefficient", "Point");
		int stt = 1;
		for (Poin point : listPoint) {
			System.out.printf("%-4d", stt++);
			point.displayPoint();
		}
	}

	public static int indexOf(int code) {
		for (int i = 0; i < listPoint.size(); i++) {
			if (listPoint.get(i).getStudentCode() == code) {
				return i;
			}
		}
		return -1;
	}
}
