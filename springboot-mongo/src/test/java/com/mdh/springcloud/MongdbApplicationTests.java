package com.mdh.springcloud;

import com.mdh.springcloud.dao.StudentDao;
import com.mdh.springcloud.dao.StudentRepository;
import com.mdh.springcloud.entities.Fruit;
import com.mdh.springcloud.entities.Student;
import com.mdh.springcloud.service.FruitService;
import com.mdh.springcloud.util.ResourceTransferFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 13:58
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongdbApplicationTests {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentRepository studentRepository;


    /**
     * 查询所有信息
     */
    @Test
    public void findAll() {
        List<Student> all = studentDao.findAll();
        System.out.println(all.size());
    }

    /**
     * 新增信息
     */
    @Test
    public void save() {
        Student student = new Student();
        student.setId(2l);
        student.setName("盲僧");
        student.setAge("21");
        student.setSex("女");
        student.setIntroduce("瞎子");
        studentDao.save(student);
    }

    @Test
    public void save1() {
        Student student = new Student();
        student.setId(2l);
        student.setName("盲僧222");
        studentRepository.save(student);
    }


    /**
     * 修改信息
     */
    @Test
    public void update() {
        Student student = new Student();
        student.setId(2l);
        student.setName("瞎子");
        studentDao.update(student);
    }

    /**
     * 删除信息
     */
    @Test
    public void delete() {
        studentDao.delete(2);
    }

    @Test
    public void findByName() {
        Student student = studentDao.findStudentByName("石头人");
        System.out.println(student);
    }

    @Test
    public void get() {
        String name = "厄加特";
        List<Student> list1 = studentRepository.findStudentsByName(name);
        List<Student> list2 = studentRepository.queryStudentsByName(name);
        List<Student> list3 = studentRepository.getStudentsByName(name);


        System.out.println(list1);
        System.out.println("----------------");
        System.out.println(list2);
        System.out.println("----------------");
        System.out.println(list3);
    }


    @Test
    public void findByNameIn() {
        List<String> names = Arrays.asList("石头人", "厄加特");
        List<Student> byNameIn = studentRepository.findByNameIn(names);
        System.out.println(byNameIn);
    }


    @Autowired
    ResourceTransferFactory resourceTransferFactory;

    @Test
    public void getList(){
        Integer type = 3;
        FruitService service = resourceTransferFactory.getService(type);
        System.out.println(service.getList());
    }

}
