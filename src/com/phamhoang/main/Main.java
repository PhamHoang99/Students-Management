package com.phamhoang.main;

import java.util.Scanner;

import com.phamhoang.pointmanagement.PointManagement;
import com.phamhoang.studentmanagement.student.StudentManagement;
import com.phamhoang.subjectmanagement.SubjectManagement;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\n===========Student Management Program ===========");
		System.out.println("\t1. Update student system information");
		System.out.println("\t2. Student Management");
		System.out.println("\t3. Look for information");
		System.out.println("\t0. Exit!");
		System.out.println("Select the function to manage:  ");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			UpdateSystem();
			break;
		case 2:
			StudentManagement();
			break;
		case 3:
			Lookforinformation();
			break;
		case 0:
			System.out.println("Exited the program.");
			System.exit(0);
		default:
			System.out.println("Your choice wrong!!!");
		}
		while (true);
	}

	private static void StudentManagement() {
		do {
		System.out.println("\n===== Show in points ======");
		System.out.println("\t1. Display scores for each student");
		System.out.println("\t2. Display scores by subject with students studying");
		System.out.println("\t0. Exit.");
		System.out.println("Your choice: ");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			DisplayByStdCode();
			break;
		case 2:
			DisplayBySubCode();
			break;
		case 0:
			return;
		default:
			System.out.println("Your choice wrong!!!");
		}
		}while(true);
	}

	private static void DisplayBySubCode() {
		System.out.println("Input subject code: ");
		int subCode = Integer.parseInt(sc.nextLine());
		int index = PointManagement.indexOf(subCode);
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		for (int i = 0; i < PointManagement.listPoint.size(); i++) {
			if (PointManagement.listPoint.get(i).getSubjectCode() == subCode) {
				PointManagement.listPoint.get(i).displayPoint();
			}
		}
	}

	private static void DisplayByStdCode() {
		System.out.println("Input student code: ");
		int stdCode = Integer.parseInt(sc.nextLine());
		int index = PointManagement.indexOf(stdCode);
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		for (int i = 0; i < PointManagement.listPoint.size(); i++) {
			if (PointManagement.listPoint.get(i).getStudentCode() == stdCode) {
				PointManagement.listPoint.get(i).displayPoint();
			}
		}
	}

	private static void Lookforinformation() {
		System.out.println("=========== LOOK FOR STUDENT INFORMATION =======");
		SearchByCode();
	}

	private static void SearchByCode() {
		System.out.println("Enter the student code you want to find:  ");
		int stdCode = Integer.parseInt(sc.nextLine());
		int index = StudentManagement.indexOf(stdCode);
		if (index == -1) {
			System.out.println("Not found!");
			return;
		}
		System.out.println("\n============LIST STUDENTS=========");
		System.out.printf("%-3s %-6s %-25s %-10s %-10s %-35s %n", "STT", "CODE", "NAME", "GENDER", "BIRTHDAY", "ADDRESS");
		StudentManagement.listStudents.get(index).display();
	}

	private static void UpdateSystem() {
		int choice;
		do {
			System.out.println("\n============= SYSTEM INFORMATION UPDATE FUNCTION ===========");
			System.out.println("\t1. Update student information");
			System.out.println("\t2. Update subject information");
			System.out.println("\t3. Update point information");
			System.out.println("\t0. Exit.");
			System.out.println("Your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				StudentManagement.updateStudents();
				break;
			case 2:
				SubjectManagement.UpdateSubject();
				break;
			case 3:
				PointManagement.UpdatePoints();
				break;
			case 0:
				return;
			default:
				System.out.println("Your choice wrong!!!");
			}
		} while (true);

	}
}
