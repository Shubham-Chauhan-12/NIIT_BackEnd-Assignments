package com.restfulapi.RestfulApi.Service;

import com.restfulapi.RestfulApi.Domain.Student;
import com.restfulapi.RestfulApi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service // after implementation use service annotation
public class StudentServiceImpl implements IStudentService {
    @Autowired  // make repository class object and Autowired its constructor
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudents(Student student) {
        return studentRepository.save(student);     // save(data)  save the data in Repository
    }

    @Override
    public boolean deleteStudents(int studId) {
        studentRepository.deleteById(studId);   // deleteById(id)  delete that preferred id data from Student Or db
        return true;
    }

    @Override
    public List<Student> fetchStudentList() {
        return (List<Student>) studentRepository.findAll();    // findAll() fetch all data available in student
    }

//    @Override
//    public Optional<Student> fetchbyId(int studId) {
//        return studentRepository.findById(studId);
//    }


    //@Override               Update
    //    public Student updateById(Student student) {
    //        Student student1 = null;
    //       Optional<Student> std = studentRepository.findById(student.getSid());
    //
    //       if(std.isPresent()){
    //           student1 = std.get();
    //           student1.setSname(student.getSname());
    //           student1.setSadress(student.getSadress());
    //           student1.setSmarks(student.getSmarks());
    //           studentRepository.save(student1);
    //
    //       }else{
    //           return new Student();
    //       }
    //     return student1;
    //}

}
