package com.restfulapi.RestfulApi.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  // db Table
public class Student {

    @Id  // primary key
    private int studentId;
    private String studentName;
    private String studentClass;
    private int studentMarks;

    public Student() {
    }

    public Student(int studentId, String studentName, String studentClass, int studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentMarks = studentMarks;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(int studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentMarks=" + studentMarks +
                '}';
    }
}
