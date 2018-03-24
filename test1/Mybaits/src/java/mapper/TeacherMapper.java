package mapper;

//import model.Student;
import model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherMapper {
    @Select(" select * from teacher ")
    @Results({
            @Result(property="student",column="id",one=@One(select="mapper.StudentMapper.get"))
    })
    public List<Teacher> list();
    @Insert(" insert into teacher ( name ) values (#{name}) ")
    public long add(Teacher teacher);

    @Delete(" delete from teacher where id= #{id} ")
    public void delete(long id);

    @Select("select * from teacher where id= #{id} ")
    public Teacher get(long id);

    @Update("update teacher set name=#{name} where id=#{id} ")
    public int update(Teacher teacher);



}
