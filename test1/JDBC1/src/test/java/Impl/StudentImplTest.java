package Impl;

import dao.StudentDao;
import model.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentImplTest {

    @Test
    public void insert() throws SQLException {
        StudentDao dao = new StudentImpl();
        dao.insert(new Student("赵伟鹏", "JAVA", "JAVA-5551"));
    }

    @Test
    public void update() throws SQLException {
        StudentDao dao = new StudentImpl();
        dao.update(new Student("田媛", "WEB", "WEB-5421", 2));
    }

    @Test
    public void delete() throws SQLException {
        StudentDao dao = new StudentImpl();
        dao.delete(1);
    }

    @Test
    public void FindById() throws SQLException {
        StudentDao dao = new StudentImpl();
        Student stu = dao.FindById(3);
        System.out.println(stu);
    }

    @Test
    public void FindAll() throws SQLException {
        StudentDao dao = new StudentImpl();
        List<Student> students = dao.FindAll();
        System.out.println(students);
    }
}