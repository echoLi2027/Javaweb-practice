import dao.UserDao;
import domain.User;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testUserLogin() {
        User user = new User();
        user.setUsername("Sheldon");
        user.setPassword("123");

        UserDao userdao = new UserDao();

        System.out.println(userdao);
        User user1 = userdao.userLogin(user);
        System.out.println(user1);
    }
}
