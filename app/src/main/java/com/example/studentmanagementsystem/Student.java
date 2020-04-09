package com.example.studentmanagementsystem;

public class Student {

    private String fac_num;
    private String name;
    private String course;

    public Student(String fac_num, String name, String course) {
        this.fac_num = fac_num;
        this.name = name;
        this.course = course;
    }

    public Student() {
    }

    public String getFac_num() {
        return fac_num;
    }

    public void setFac_num(String fac_num) {
        this.fac_num = fac_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
