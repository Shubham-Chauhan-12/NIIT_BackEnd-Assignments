package com.restfulapi.RestfulApi.Controller;

import com.restfulapi.RestfulApi.Domain.Student;
import com.restfulapi.RestfulApi.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
   private IStudentService iStudentService;

   @Autowired
    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @PostMapping("/saveStudents")       //Post data
    public ResponseEntity<?> saveStudentData(@RequestBody Student student){
       return new ResponseEntity<>(iStudentService.saveStudents(student), HttpStatus.CREATED);
    }

    @GetMapping("/fetchStudentList")
    public ResponseEntity<?> getStudentsData(){
       return new ResponseEntity<>(iStudentService.fetchStudentList(),HttpStatus.FOUND);

    }

    @DeleteMapping("/deleteStudents/{id}")
    public ResponseEntity<?> deleteIdData(@PathVariable int id){
        iStudentService.deleteStudents(id);
       return new ResponseEntity<>("Deleted Successfully",HttpStatus.ACCEPTED);
    }

//    @PutMapping("/update")
//    public Student saveFunction2(@RequestBody Student studentObj){
//        return iStudentService.updateById(studentObj);
//    }
}
