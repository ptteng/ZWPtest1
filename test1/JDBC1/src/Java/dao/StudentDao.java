package dao;
import  model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //添加方法
    public void insert(Student stu)throws SQLException;

    //更新方法
    public void update(Student stu)throws SQLException;

    //删除方法
    public void delete(long id)throws SQLException;

    //查找方法
    public Student FindById(long id)throws SQLException;

    //查找所有
    public List<Student> FindAll()throws SQLException;

}
