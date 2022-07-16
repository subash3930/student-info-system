package com.techbook.test;

import java.util.Scanner;

import com.techbook.controller.StudentController;

public class StudentTest {

	public static void main(String[] args) {
		StudentController controller=new StudentController();
		 Scanner input=new Scanner(System.in);
		 controller.saveStudentInfo(input);
	}

}
