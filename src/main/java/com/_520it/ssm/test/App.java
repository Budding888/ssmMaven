import com._520it.ssm.domain.User;
import com._520it.ssm.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class App {

    @Autowired
    private IUserService service;

    @Test
    public void testSave() {
        User user = new User(null, "噢噢噢", 23);
        service.save(user);
    }


    @Test
    public void testUpdate() {
        User user = new User(2L, "刷刷刷", 23);
        service.update(user);
    }


    @Test
    public void testDelete() {
        service.delete(2L);
    }


    @Test
    public void testGet() {
        User user = service.get(3L);
        System.out.println(user);
    }


    @Test
    public void testList() {
        List<User> list = service.list();
        for (User user : list) {
            System.out.println(user);
        }
    }






}
