package com.techbook.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.techbook.domain.Student;
import com.techbook.service.StudentService;
import com.techbook.service.StudentServiceImpl;

public class StudentController {
	private StudentService studentservice;

	public StudentController() {
		studentservice = new StudentServiceImpl();
	}

	public void saveStudentInfo(Scanner input) {
		Student student = buildStudentInfo(input);
		int saved = studentservice.saveStudentInfo(student);
		if (saved == 1) {
			System.out.println("User info is inserted successfully in db");
		} else {
			System.out.println("Error in Db.");
		}
	}
	private Student buildStudentInfo(Scanner input) {
		Student student = new Student();
		System.out.println("Enter Studentname:");
		String studentname = input.next();
		System.out.println("Enter roll:");
		int roll = input.nextInt();
		System.out.println("Enter dob:");
		String dob = input.next();
		Date dateOfBirth = parseDate(dob);
		System.out.println("Enter phone no:");
		long mobileNo = input.nextLong();
		System.out.println("Enter email:");
		String email = input.next();
		System.out.println("Enter address:");
		String address = input.next();

		student.setStudentName(studentname);
		student.setRoll(roll);
		student.setDob(dateOfBirth);
		student.setPhoneNo(mobileNo);
		student.setEmail(email);
		student.setAddress(address);

		return student;
	}

	public Date parseDate(String dob) {
		Date dateOfBirth = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateOfBirth = sdf.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateOfBirth;

	}
}
