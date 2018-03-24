package dao;

import model.Student;

import java.util.List;

public interface StudentMapper {
    Student getStudentById(long id) ;
    void addStudent(Student student);
    void updateStudent(Student student);
    void delete(Student student);
    List<Student> listAll();

}
