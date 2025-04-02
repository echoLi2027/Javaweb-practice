import domain.User;
import org.junit.jupiter.api.Test;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.List;

public class UserDao {

    @Test
    public void userDao() {
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
