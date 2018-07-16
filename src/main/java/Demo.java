import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class Demo {
    @Test
    public void test() {
        //读取配置文件
        Configuration conf = new Configuration().configure();
        //根据配置创建factory
        SessionFactory sessionfactory = conf.buildSessionFactory();
        //获得操作数据库的session对象
        Session session = sessionfactory.openSession();
        //创建对象
        User u = new User();
        u.setName("张三");
        u.setPassword("123456");
        //将对象保存到数据库
        session.save(u);
        //关闭资源
        session.close();
        sessionfactory.close();
    }

}

