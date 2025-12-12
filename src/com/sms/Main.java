package com.sms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Email");
            System.out.println("4. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Mail ID: ");
                    String mail = sc.nextLine();
                    System.out.print("Dept ID: ");
                    int deptId = sc.nextInt();
                    Student s = new Student(id, roll, name, mail, deptId);
                    StudentDAO.addStudent(s);
                    break;

                case 2:
                    StudentDAO.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to update email: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Email: ");
                    String newMail = sc.nextLine();
                    StudentDAO.updateStudentMail(updateId, newMail);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    StudentDAO.deleteStudent(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

}
