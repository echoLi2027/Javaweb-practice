import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserServiceTest {

    static UserService service;
    private UserService userService;

    @BeforeAll
    public static void beforeAll() {
        service = new UserService();
    }

    /*@BeforeEach
    public void beforeEach() {
        System.out.println("before each");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each");
    }*/

    @Test
    public void ageTest() {
        Integer age = service.getAge("100000199801020010");

        Assertions.assertEquals(27, age);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100000199601020010", "100000198001020010", "100000198701020010"})
    public void ageTest2(String idCard) {
        Integer age = service.getAge(idCard);

        System.out.println(age);

        String gender = service.getGender(idCard);

        System.out.println(gender);
    }

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void getAge_NullInput_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge(null);
        });
    }

    @Test
    public void getAge_InvalidLength_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("123456789012345");
        });
    }

    @Test
    public void getAge_ValidInput_ReturnsCorrectAge() {
        String idCard = "11010519491231002X";
        LocalDate birthDate = LocalDate.parse("19491231", DateTimeFormatter.ofPattern("yyyyMMdd"));
        int expectedAge = Period.between(birthDate, LocalDate.now()).getYears();
        int actualAge = userService.getAge(idCard);
        Assertions.assertEquals(expectedAge, actualAge);
    }

    @DisplayName("getAge_InvalidDateFormat_ThrowsIllegalArgumentException")
    @Test
    public void getAge_InvalidDateFormat_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("11010519491231002X1234567890123456");
        });
    }

    @Test
    public void getGender_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }

}
