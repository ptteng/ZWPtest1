



import dao.StudentMapper;
import model.Student;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class StudentServiceImplTest {
    private Student entityTemp;
    private static Logger logger = Logger.getLogger(StudentServiceImplTest.class);
    @BeforeClass
    public static void begin(){

    }
    @AfterClass
    public static void end(){
        System.out.println("测试结束");
    }
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void testAdd() {
        Student student = new Student();
        student.setName("赵伟鹏");
        studentMapper.addStudent(student);
    }
    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setName("田媛");
        student.setId(18);
        student.setMajor("web");
        studentMapper.updateStudent(student);
    }
    @Test
    public void testdelete() {
        Student student = new Student();
        student.setId(21);
        studentMapper.delete(student);
    }
    @Test
    public void testSelect() {
        Student a = studentMapper.getStudentById(10);
        System.out.println(a);
    }
    @Test
    public void testListAll() {
        List<Student> listAll = studentMapper.listAll();
        System.out.println(listAll);


    }
}
