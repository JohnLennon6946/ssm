import com.dao.IProductdao;
import com.domain.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void run() throws Exception {
        InputStream in= Resources.getResourceAsStream("applicationContext.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        IProductdao iProductdao=sqlSession.getMapper(IProductdao.class);
        List<Product> all = iProductdao.findAll();
        for (Product product:all){
            System.out.println(product);
        }

    }
}
