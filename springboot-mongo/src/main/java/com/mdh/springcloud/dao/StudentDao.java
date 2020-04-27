package com.mdh.springcloud.dao;

import com.mdh.springcloud.entities.Student;

import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 13:48
 **/
public interface StudentDao {

    void save(Student student);

    void update(Student student);

    List<Student> findAll();

    void delete(Integer id);

    Student findStudentByName(String name);
}
