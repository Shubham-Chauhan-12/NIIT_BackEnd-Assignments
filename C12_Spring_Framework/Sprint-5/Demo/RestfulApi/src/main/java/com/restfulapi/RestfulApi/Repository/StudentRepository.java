package com.restfulapi.RestfulApi.Repository;

import com.restfulapi.RestfulApi.Domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  // extend Crud repository took Domain class and Primary key data type (Integer or .....)
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
