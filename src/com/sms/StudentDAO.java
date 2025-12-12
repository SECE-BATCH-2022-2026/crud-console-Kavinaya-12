package com.sms;

import java.sql.*;
public class StudentDAO {
    public static void addStudent(Student s) {
        String sql = "INSERT INTO student(id, roll_no, name, mail_id, dept_id) VALUES(?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getId());
            ps.setInt(2, s.getRollNo());
            ps.setString(3, s.getName());
            ps.setString(4, s.getMailId());
            ps.setInt(5, s.getDeptId());
            ps.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void viewStudents() {
        String sql = "SELECT * FROM student";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID | RollNo | Name | Mail | DeptID");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getInt("roll_no") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("mail_id") + " | " +
                        rs.getInt("dept_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateStudentMail(int id, String newMail) {
        String sql = "UPDATE student SET mail_id=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newMail);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student email updated successfully.");
            else
                System.out.println("Student not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully.");
            else
                System.out.println("Student not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
