package demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;



public class Test {

    public static void main(String[] args) {
        String resource="mybatis.xml";
        try {
            Reader reader= Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            List<String> ids = Arrays.asList(new String[]{"1", "s"});
            Req req=new Req();
            req.setIds(ids);
            Object one = sqlSession.selectOne("demo.UserMapper.getUser", req);
            System.out.println("((demo)one).getName() = " + ((User) one).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
