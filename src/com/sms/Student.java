package com.sms;

public class Student {
    private int id;
    private int rollNo;
    private String name;
    private String mailId;
    private int deptId;

    public Student(int id, int rollNo, String name, String mailId, int deptId) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.mailId = mailId;
        this.deptId = deptId;
    }

    public int getId() { return id; }
    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getMailId() { return mailId; }
    public int getDeptId() { return deptId; }
}
