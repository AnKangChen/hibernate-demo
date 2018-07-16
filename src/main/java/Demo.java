import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


public class Demo {
    public  SessionFactory sessionFactory;

    @Before
    public void before() {
        //读取配置文件
        Configuration conf = new Configuration().configure();
        //根据配置创建factory
        sessionFactory = conf.buildSessionFactory();
    }
    @Test
    public void testUser() {

        //获得操作数据库的session对象
        Session session = sessionFactory.openSession();
        //创建对象
        User u = new User();
        u.setName("张三");
        u.setPassword("123456");
        //将对象保存到数据库
        session.save(u);
        //关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testEmployee() {
        //获得操作数据库的session对象
        Session session = sessionFactory.openSession();
        Employee employee = new Employee();
        employee.name = "李四";
        employee.password = "3333";
        session.save(employee);
        session.close();
        sessionFactory.close();
    }

}

