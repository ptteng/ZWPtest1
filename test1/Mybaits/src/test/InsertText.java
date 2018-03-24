import mapper.StudentMapper;
import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class InsertText {
    public static void main(String[] args) throws IOException, SQLException {
        //讲mybatis.xml文件存储在resource中
        String resource = "tools/mybatis.xml";
        //读取 mybatis文件.
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //初始化mybatis.创建Sqlsession工厂,也就是 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession实例,相当于 JDBC中connection的作用
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false/*下面两条说明*/);
        //新获取一个模式为BATCH，自动提交为false的session
        //如果自动提交设置为true,将无法控制提交的条数，改为最后统一提交，可能导致内存溢出
        //不创建SQL.xml  直接使用注解方式存在接口中,就需要读取一下接口文件,相当于读取一下 sql语句
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        session.getConnection().setAutoCommit(false);
        long y = System.currentTimeMillis();
        try {

            for (int i = 1; i < 1000000; i++) {
                Student c = new Student();
                c.setName("赵伟鹏");
                mapper.add(c);
                if (i % 500000 == 0) {
                    //手动每1000个一提交，提交后无法回滚
                    session.commit();
                    //清理缓存，防止溢出
                    session.clearCache();
                }

            }

        } catch (Exception e) {
            //没有提交的数据可以回滚
            session.rollback();
        } finally {
            session.close();
        }

//        for (int x = 1; x < 100000; x++) {
//            add(mapper);
//        }
//        session.commit();
//        session.close();
        long z = System.currentTimeMillis();
        System.out.println("插入100000数据耗时:" + (z - y));
//    }
//
//    private static void add(StudentMapper mapper) {
//        long y = System.currentTimeMillis();
//
//        Student c = new Student();
//        c.setName("赵伟鹏");
//        mapper.add(c);
////        listAll(mapper);
//        long z = System.currentTimeMillis();
////        System.out.println("耗时:"+(z-y));
//    }
    }
}
