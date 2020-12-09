import com.ds.dao.UserDao;
import com.ds.dao.UserDaoImpl;
import com.ds.service.UserServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xxxxx
 * @create: 2020-11-25
 */
public class MyTest implements ApplicationContextAware {


    public static void main(String[] args) {
        new UserServiceImpl().setUser(new UserDaoImpl()).getUser();
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        new UserServiceImpl().setUser((UserDao) context.getBean("userDao")).getUser();;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
