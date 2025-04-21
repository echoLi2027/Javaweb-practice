import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserService {

    /**
     * Calculate the user's age based on their ID card number
     * @param idCard ID card number
     */
    public Integer getAge(String idCard){
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("Invalid ID card number");
        }
        String birthday = idCard.substring(6, 14);
        LocalDate parse = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return Period.between(parse, LocalDate.now()).getYears();
    }

    /**
     * Determine the user's gender based on their ID card number
     * @param idCard ID card number
     */
    public String getGender(String idCard){
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("Invalid ID card number");
        }
        return Integer.parseInt(idCard.substring(16,17)) % 2 == 1 ? "Male" : "Female";
    }

}