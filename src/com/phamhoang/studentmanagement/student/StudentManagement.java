package com.phamhoang.studentmanagement.student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.phamhoang.pointmanagement.PointManagement;

public class StudentManagement {
	public static ArrayList<Students> listStudents = new ArrayList<Students>();
	static Scanner sc = new Scanner(System.in);

	public static void updateStudents() {
		int choose;
		do {
			System.out.println("+++++++++UPDATE STUDENT INFORMATION++++++++++");
			System.out.println("===========MENU===========");
			System.out.println("1. Add student information");
			System.out.println("2. Update student information");
			System.out.println("3. Delete student information");
			System.out.println("4. Display all student information.");
			System.out.println("0. Exit!");
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				AddStudent();
				break;
			case 2:
				UpdateStudent();
				break;
			case 3:
				DeleteStudent();
				break;
			case 4:
				DisplayAllStudent();
				break;
			case 0:
				return;
			default:
				System.out.println("your choice is wrong!!!");
			}

		} while (true);
	}

	public static String getName() {
		String name;
		Pattern p = Pattern.compile("^[a-zA-Z ]{10,25}$");
		while (true) {
			System.out.println("Input name: ");
			name = sc.nextLine();
			if (p.matcher(name).find()) {
				break;
			} else {
				System.out.println("Ivalid name, please input again!");
			}
		}
		return name;
	}

	public static int getCode() {
		int code;
		System.out.println("Input code: ");
		code = Integer.parseInt(sc.nextLine());
		return code;

	}

	public static String getGender() {
		String gender;
		Pattern p = Pattern.compile("^[a-zA-Z ]{2,6}$");
		while (true) {
			System.out.println("Input gender: ");
			gender = sc.nextLine();
			if (p.matcher(gender).find()) {
				break;
			} else {
				System.out.println("Ivalid gender, please input again!");
			}
		}
		return gender;
	}

	public static String getBirthday() {
		String birthday;
		Pattern p = Pattern.compile("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/[12]\\d{3})$");
		while (true) {
			System.out.println("Input birthday: ");
			birthday = sc.nextLine();
			if (p.matcher(birthday).find()) {
				break;
			} else {
				System.out.println("Ivalid birthday, please input again!");
			}
		}
		return birthday;
	}

	public static String getAddress() {
		String address;
		Pattern p = Pattern.compile("^[a-zA-Z ]{10,35}$");
		while (true) {
			System.out.println("Input address: ");
			address = sc.nextLine();
			if (p.matcher(address).find()) {
				break;
			} else {
				System.out.println("Ivalid name, please input again!");
			}
		}
		return address;
	}

	private static void AddStudent() {
		System.out.println("========== ADD student information =========");
		int code = getCode();
		String name = getName();
		String gender = getGender();
		String birthday = getBirthday();
		String address = getAddress();
		Students student = new Students(code, name, gender, birthday, address);
		listStudents.add(student);
		System.out.println("Add student informaiton successful!");
	}

	private static void UpdateStudent() {
		System.out.println("============ UPDATE STUDENT INFORMATION ===========");
		System.out.println("Please input code: ");
		int code = Integer.parseInt(sc.nextLine());
		int index = indexOf(code);
		if (index == -1) {
			System.out.println("Not found this code!!!");
			return;
		}
		do {
			System.out.println("\t1. Update student code ");
			System.out.println("\t2. Update student name");
			System.out.println("\t3. Update student gender");
			System.out.println("\t4. Update student birthday");
			System.out.println("\t5. Update student address");
			System.out.println("\t0. Exit");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				UpdateCode(index);
				break;
			case 2:
				UpdateName(index);
				break;
			case 3:
				UpdateGender(index);
				break;
			case 4:
				UpdateBirthday(index);
				break;
			case 5:
				UpdateAddress(index);
				break;
			case 0:
				return;
			default:
				System.out.println("\tYour choice is wrong!!!!");
			}
		} while (true);
	}

	private static void UpdateCode(int index) {
		int newCode;
		System.out.println("Input new code (please input number): ");
		newCode = getCode();
		listStudents.get(index).setCode(newCode);
		System.out.println("update code successful!");
	}

	private static void UpdateName(int index) {
		System.out.println("Input new name: ");
		String newName = getName();
		listStudents.get(index).setName(newName);
		System.out.println("update name successful!");
	}

	private static void UpdateGender(int index) {
		System.out.println("Input new gender: ");
		String newGender = getGender();
		listStudents.get(index).setGender(newGender);
		System.out.println("update gender successful!");
	}

	private static void UpdateBirthday(int index) {
		System.out.println("Input new birthday: ");
		String newBirthday = getBirthday();
		listStudents.get(index).setBirthday(newBirthday);
		System.out.println("update birthday successful!");
	}

	private static void UpdateAddress(int index) {
		System.out.println("Input new address: ");
		String newAddress = getAddress();
		listStudents.get(index).setAddress(newAddress);
		System.out.println("update address successful!");
	}

	private static void DeleteStudent() {
		System.out.println("========== DELETE STUDENT =========");
		System.out.println("Input student code: ");
		int stdCode = Integer.parseInt(sc.nextLine());
		int index = indexOf(stdCode);
		if (index == -1) {
			System.out.println("Not found this student!!!");
		}
		int i = 0;
		while (i < PointManagement.listPoint.size() && PointManagement.listPoint.get(i).getStudentCode() != stdCode) {
			i++;
		}
		if (i < PointManagement.listPoint.size()) {
			System.out.println("Student is studying, can't delete!!!");
			return;
		}
		listStudents.remove(index);
		System.out.println("Deleted.");
	}

	private static void DisplayAllStudent() {
		System.out.println("\n============LIST STUDENTS=========");
		System.out.printf("%-3s %-6s %-25s %-10s %-10s %-35s %n", "STT", "CODE", "NAME", "GENDER", "BIRTHDAY",
				"ADDRESS");
		for (Students students : listStudents) {
			students.display();
		}
		System.out.println("===================================================");
	}

	public static int indexOf(int code) {
		for (int i = 0; i < listStudents.size(); i++) {
			if (listStudents.get(i).getCode() == code) {
				return i;
			}
		}
		return -1;
	}
}
