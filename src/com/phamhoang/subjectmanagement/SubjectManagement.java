package com.phamhoang.subjectmanagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.phamhoang.pointmanagement.PointManagement;

public class SubjectManagement {
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Subject> listSubject = new ArrayList<Subject>();

	public static void UpdateSubject() {
		int choice;
		do {
			System.out.println("\n======= UPDATE SUBJECT INFORMATION =======");
			System.out.println("\t1. Add new subject");
			System.out.println("\t2. Display all subject");
			System.out.println("\t3. Update subject");
			System.out.println("\t4. Delete subject");
			System.out.println("\t0. Exit!");
			System.out.println("Your choice : ");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				AddSubjectInformation();
				break;
			case 2:
				DisplayAllInformation();
				break;
			case 3:
				UpdateSubjectInformation();
				break;
			case 4:
				DeleteSubjectInformation();
				break;
			case 0:
				return;
			default:
				System.out.println("Your choice wrong!!!");
			}
		} while (true);
	}

	public static String getsubjectName() {
		String subjectName;
		Pattern p = Pattern.compile("^[a-zA-Z ]{3,25}$");
		while (true) {
			System.out.println("Input subject name: ");
			subjectName = sc.nextLine();
			if (p.matcher(subjectName).find()) {
				break;
			} else {
				System.out.println("Ivalid subject name, please input again!");
			}
		}
		return subjectName;
	}

	private static void AddSubjectInformation() {
		System.out.println("============= Update list subjects ==============");
		System.out.println("Input subject code (Please input only number): ");
		int subCode = Integer.parseInt(sc.nextLine());
		String subName = getsubjectName();
		System.out.println("Input subject coefficient: ");
		double subCoefficient = Double.parseDouble(sc.nextLine());
		Subject sub = new Subject(subCode, subName, subCoefficient);
		listSubject.add(sub);
		System.out.println("Add data successfully!");
	}

	private static void DisplayAllInformation() {
		System.out.println("=========== List subject =========");
		if (listSubject.size() == 0) {
			System.out.println("Empty list");
			return;
		}
		System.out.printf("%-3s %-7s %-25s %-8s %n", "STT", "Subject Code", "Subject Name", "Coefficient");
		for (Subject subject : listSubject) {
			subject.display();
		}
	}

	private static void UpdateSubjectInformation() {
		System.out.println("========= UPDATE SUBJECT ========");
		System.out.println("Input subject code: ");
		int subCode = Integer.parseInt(sc.nextLine());
		int index = indexOf(subCode);
		if (index == -1) {
			System.out.println("Not found subject code!!!");
			return;
		}
		int choice;
		System.out.println("You want to update about");
		System.out.println("\t1. Subject name");
		System.out.println("\t2. Subject coefficient");
		System.out.println("\t0. Exit.");
		System.out.println("Your choice: ");
		choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			UpdateSubName(index);
			break;
		case 2:
			UpdateSubCoefficient(index);
			break;
		case 0:
			return;
		default:
			System.out.println("Your choice is wrong!!!!");
		}
		while (true);
	}

	private static void UpdateSubName(int index) {

		System.out.println("Input new subject name: ");
		String subName = sc.nextLine();
		if (subName.trim().length() == 0) {
			System.out.println("The subject name cannot be left blank!");
			return;
		}
		System.out.println(listSubject.size());
		listSubject.get(index).setSubjectName(subName);
		System.out.println("Update subject name successful.");
	}

	private static void UpdateSubCoefficient(int index) {
		System.out.println("Input subject coeficient: ");
		double subCoeficient = Double.parseDouble(sc.nextLine());
		if (subCoeficient < 0.0 | subCoeficient > 10.0) {
			System.out.println("Wrong format");
		}
		listSubject.get(index).setCoefficient(subCoeficient);
		System.out.println("Update subject corfficient successfyl.");
	}

	private static void DeleteSubjectInformation() {
		System.out.println("========== DELETE SUBJECT =========");
		System.out.println("Input subject code: ");
		int subCode = Integer.parseInt(sc.nextLine());
		int index = indexOf(subCode);
		if (index == -1) {
			System.out.println("Not found this subject!!!");
		}
		int i = 0;
		while (i < PointManagement.listPoint.size() && PointManagement.listPoint.get(i).getSubjectCode() != subCode) {
			i++;
		}
		if (i < PointManagement.listPoint.size()) {
			System.out.println("There are already students studying, can't delete!!!");
			return;
		}
		listSubject.remove(index);
		System.out.println("Deleted.");
	}

	public static int indexOf(int subjectCode) {
		for (int i = 0; i < listSubject.size(); i++) {
			if (listSubject.get(i).getSubjectCode() == subjectCode) {
				return i;
			}
		}
		return -1;
	}
}
