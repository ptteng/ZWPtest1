package service;

import dao.StudentsDao;
import model.Student;

import java.util.List;

public class StudentService {
    // 加入userDao作为成员变变量
    private StudentsDao studentsDao;

    // 注意这里要增加get和set方法
    public StudentsDao getStudentsDao() {
        return studentsDao;
    }

    public void setStudentsDao(StudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }

    public void insert(Student student) {
        studentsDao.insert(student);
    }
    public void update(Student student) {
        studentsDao.update(student);
    }
    public void delete(Student student) {
        studentsDao.delete(student);
    }

    public List<Student> findAll() {
        return studentsDao.findAll();
    }



//
}