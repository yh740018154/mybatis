import User.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.misc.Resource;

import java.io.IOException;
import java.io.Reader;

public class Test {

    public static void main(String[] args) {
        String resource="mybatis.xml";
        try {
            Reader reader= Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Object one = sqlSession.selectOne("UserMapper.getUser", "1");
            System.out.println("((User)one).getName() = " + ((User) one).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
