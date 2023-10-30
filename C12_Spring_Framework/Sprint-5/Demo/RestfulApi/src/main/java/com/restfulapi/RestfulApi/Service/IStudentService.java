package com.restfulapi.RestfulApi.Service;

import com.restfulapi.RestfulApi.Domain.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Student saveStudents(Student student);
    boolean deleteStudents(int studId);
    List<Student> fetchStudentList();

//    Optional<Student> fetchbyId(int studId);
}
