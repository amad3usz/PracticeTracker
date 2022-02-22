package org.perscholas.practicetracker.registerForm;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.perscholas.practicetracker.validation.TwoFieldsEqual;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@TwoFieldsEqual(passwordField = "password", passwordConfirmField = "confirmPassword", message = "Passwords must be the same")
public class EditFormBean {

    private Integer id;

    @NotEmpty(message = "First name is required")
    //makes sure it's not null and not empty
    @Pattern(regexp = "^[A-Za-z]+$", message = "Must contain only uppercase and lowercase letters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Must contain only uppercase and lowercase letters")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^.+@.+$", message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String gender;

    @NotEmpty
    private String DOB;

    @NotEmpty
    private String skillsPracticing;

    @NotEmpty
    private String profileIcon;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    } //overrides default to string (makes it print nicer)

}

