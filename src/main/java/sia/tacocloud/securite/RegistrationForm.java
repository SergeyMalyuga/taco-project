package sia.tacocloud.securite;

import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import sia.tacocloud.entyties.UserM;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public UserM toUser(PasswordEncoder passwordEncoder) {
        return new UserM(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}