package com.mdh.springcloud.dao.impl;

import com.mdh.springcloud.dao.StudentDao;
import com.mdh.springcloud.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 13:54
 **/
@Component
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Student student) {
        mongoTemplate.save(student);
    }

    @Override
    public void update(Student student) {
        //修改的条件
        Query query = new Query(Criteria.where("id").is(student.getId()));

        //修改的内容
        Update update = new Update();
        update.set("name",student.getName());

        mongoTemplate.updateFirst(query,update,Student.class);
    }

    @Override
    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public void delete(Integer id) {
        Student byId = mongoTemplate.findById(id, Student.class);
        mongoTemplate.remove(byId);
    }

    @Override
    public Student findStudentByName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        Student one = mongoTemplate.findOne(query, Student.class);
        return one;
    }
}
