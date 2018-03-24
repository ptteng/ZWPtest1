package Impl;

import DBUtils.DBUtil;
import dao.StudentDao;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements StudentDao{

    /**
     * 实现添加方法
     */
    @Override
    public void insert(Student stu) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into students(name,create_time,update_time,major,school_id)values(?,now(),sysdate(),?,?)";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, stu.getName());
            ps.setString(2, stu.getMajor());
            ps.setString(3, stu.getSchool_id());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("添加数据失败");
        }finally{
            DBUtil.close(null, ps, conn);
        }
    }

    /**
     * 更新方法
     */
    @Override
    public void update(Student stu) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update students set name=?,major=?,school_id=? where id=?";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, stu.getName());
            ps.setString(2, stu.getMajor());
            ps.setString(3, stu.getSchool_id());
            ps.setLong(4, stu.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("更新数据失败");
        }finally{
            DBUtil.close(null, ps, conn);
        }
    }

    /**
     * 删除方法
     */
    @Override
    public void delete(long id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from students where id=?";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException(" 删除数据失败");
        }finally{
            DBUtil.close(null, ps, conn);
        }
    }

    /**
     * 根据ID查询一个对象
     */
    @Override
    public Student FindById(long id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student stu = null;
        String sql = "select name,major,school_id from students where id=?";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                stu = new Student();
                stu.setId(id);
                stu.setName(rs.getString(1));
                stu.setMajor(rs.getString(2));
                stu.setSchool_id(rs.getString(3));
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("根据ID查询数据失败");
        }finally{
            DBUtil.close(rs, ps, conn);
        }
        return stu;
    }

    /**
     * 查询所有数据
     */
    @Override
    public List<Student> FindAll() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student stu = null;
        List<Student> students = new ArrayList<Student>();
        String sql = "select id,name,major,school_id from students";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                stu = new Student();
                stu.setId(rs.getLong(1));
                stu.setName(rs.getString(2));
                stu.setMajor(rs.getString(3));
                stu.setSchool_id(rs.getString(4));
                students.add(stu);
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("查询所有数据失败");
        }finally{
            DBUtil.close(rs, ps, conn);
        }
        return students;
    }

}