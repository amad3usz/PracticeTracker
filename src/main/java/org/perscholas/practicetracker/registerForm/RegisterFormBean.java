package org.perscholas.practicetracker.registerForm;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.perscholas.practicetracker.validation.EmailUnique;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
//@TwoFieldsEqual(passwordField = "password", passwordConfirmField = "confirmPassword", message = "Passwords must be the same")
public class RegisterFormBean {

    private Integer id;

    @NotEmpty(message = "First name is required")
    //makes sure it's not null and not empty
    @Pattern(regexp = "^[A-Za-z]+$" , message = "Must contain only uppercase and lowercase letters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]+$" , message = "Must contain only uppercase and lowercase letters")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^.+@.+$" , message = "Invalid email format")
    @EmailUnique(message = "Email must be unique")
    private String email;

    @NotEmpty (message = "Username is required")
    @Length(min =1, max = 15, message = "Username must include at least one character and no more than 15")
    @Pattern(regexp = "^[A-Za-z0-9]{1,15}$" , message = "Must contain only letters and numbers")
    private String username;

    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String gender;

    @NotEmpty
    private String DOB;

    private String skillsPracticing;

    @NotEmpty
    private String profileImage;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    } //overrides default to string (makes it print nicer)

}
