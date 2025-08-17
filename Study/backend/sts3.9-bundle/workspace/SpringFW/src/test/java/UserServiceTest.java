import mylab.user.di.annot.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import static org.junit.jupiter.api.Assertions.*;
@SpringJUnitConfig(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testUserService() {
        String userId = "testUser";
        String name = "테스트 사용자";
        String password = "password123";

        assertNotNull(userService);

        assertNotNull(userService.getUserRepository());

        assertEquals("MySQL", userService.getUserRepository().getDbType());

        assertNotNull(userService.getSecurityService());


        boolean result = userService.registerUser(userId, name, password);
        assertTrue(result);
    }

}
