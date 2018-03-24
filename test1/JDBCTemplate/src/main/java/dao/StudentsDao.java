package dao;

import model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Student student) {

        String sql = "insert into students (name, major,school_id,create_time,update_time) values (?,?,?,now(),sysdate())";

        jdbcTemplate.update(sql, student.getName(), student.getMajor(),student.getSchool_id());

    }
    public void update(Student student) {

        String sql = "update  students set name = ? where id =?";

        jdbcTemplate.update(sql, student.getName(), student.getId());

    }
    public void delete(Student student) {

        String sql = "delete  from students  where id =?";

        jdbcTemplate.update(sql,student.getId());

    }
    public List<Student> findAll(){

        String sql = "SELECT * FROM students";

        List<Student> students  = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Student.class));

        return students;
    }


//    public List<Student> findById(){
//        Student a = new Student();
//        String sql = "SELECT * FROM students where id =?";
//
//        List<Student> students  = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Student.class),a.getId());
//
//        return students;
//    }



}