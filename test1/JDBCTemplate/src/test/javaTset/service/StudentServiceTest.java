package service;

import dao.StudentsDao;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest {
    ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src\\main\\java\\app.xml");
    StudentService studentService = (StudentService) applicationContext.getBean("StudentService");

    @org.junit.Test
    public void insert() {
        Student student = new Student();
        student.setName("赵伟鹏");
        student.setMajor("JAVA");
        student.setSchool_id("JAVA1234");
        studentService.insert(student);
    }

    @org.junit.Test
    public void update() {
        Student student = new Student();
        student.setName("田媛");
        student.setId(11);
        studentService.update(student);
    }

    @org.junit.Test
    public void delete() {
        Student student = new Student();
        student.setId(14);
        studentService.delete(student);
    }

    @org.junit.Test
    public void findAll() {
        List<Student> students = studentService.findAll();
        System.out.println(students);
    }

}