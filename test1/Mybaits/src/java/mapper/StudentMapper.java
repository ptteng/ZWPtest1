package mapper;

import model.Student;
import model.Teacher;
import org.apache.ibatis.annotations.*;
import mapper.TeacherMapper;

import java.util.List;

public interface StudentMapper {
    @Select("select * from students where id= #{id} ")
    public Student get(long id);

    @Select(" select * from students ")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "teachers", javaType = List.class, column = "id", many = @Many(select = "mapper.TeacherMapper.listByStudent"))
//    })
    public List<Student> list();

    @Insert(" insert into students ( name ) values (#{name}) ")
    public long add(Student student);

    @Delete(" delete from students where id= #{id} ")
    public void delete(long id);



    @Update("update students set name=#{name} where id=#{id} ")
    public int update(Student student);


}

