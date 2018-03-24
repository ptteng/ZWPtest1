

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mapper.TeacherMapper;
import mapper.StudentMapper;
import model.Teacher;
import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {


    public static void main(String[] args) throws IOException {
        //讲mybatis.xml文件存储在resource中
        String resource = "tools/mybatis.xml";
        //读取 mybatis文件.
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //初始化mybatis.创建Sqlsession工厂,也就是 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession实例,相当于 JDBC中connection的作用
        SqlSession session = sqlSessionFactory.openSession();
        //不创建SQL.xml  直接使用注解方式存在接口中,就需要读取一下接口文件,相当于读取一下 sql语句
        StudentMapper mapper = session.getMapper(StudentMapper.class);

       // add(mapper);
//        delete(mapper);
//        get(mapper);
//        update(mapper);
   //     listAll(mapper);

        session.commit();
        session.close();

    }

    private static void update(StudentMapper mapper) {
        Student c= mapper.get(8);
        c.setName("田媛");
        mapper.update(c);
        listAll(mapper);
    }

    private static void get(StudentMapper mapper) {
        Student c= mapper.get(8);
        System.out.println(c.getName());
    }

    private static void delete(StudentMapper mapper) {
        mapper.delete(2);
        listAll(mapper);
    }

    private static void add(StudentMapper mapper) {
        Student c = new Student();
        c.setName("赵伟鹏");
        mapper.add(c);
        listAll(mapper);
    }

    private static void listAll(StudentMapper mapper) {
        List<Student> cs = mapper.list();
        for (Student c : cs) {
            System.out.println(c.getName());
        }
    }
}