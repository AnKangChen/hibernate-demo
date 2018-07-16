import inherit.Table1ForAllClasses;
import inherit.Table2ForAllClasses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


public class Demo {
    private SessionFactory sessionFactory;

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

    @Test
    public void testTableAllClasses(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Table1ForAllClasses table1 = new Table1ForAllClasses();
        Table2ForAllClasses table2 =new Table2ForAllClasses();
        table1.bonus = "table1";
        table1.name = "table1";
        //table1.id = 1;

        table2.salary = "salary";
        table2.name = "table2";
        //table2.id = 2;
        session.save(table1);
        session.save(table2);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

