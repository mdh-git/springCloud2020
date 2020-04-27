package com.mdh.springcloud.dao;

import com.mdh.springcloud.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 14:39
 **/
@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

    List<Student> findByNameIn(List<String> names);

    List<Student> findStudentsByName(String name);

    List<Student> queryStudentsByName(String name);

    List<Student> getStudentsByName(String name);
}
