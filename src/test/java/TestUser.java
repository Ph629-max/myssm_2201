import com.bigdata.dao.UserDao;
import com.bigdata.entity.User;
import com.bigdata.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        try {
            List<User> users = userDao.selectList();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect2() {
        try {
            List<User> users = userService.queryUsers();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            int result = userService.regist("13520551442", "123456aa", 1);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
