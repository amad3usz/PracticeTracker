package org.perscholas.practicetracker.registerForm;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class RegisterFormBean {

    @NotEmpty(message = "First name is required")
    @Length(min =1, max = 25, message = "First Name must include at least one character and no more than 25")//makes sure it's not null and not empty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String DOB;
    private String skillsPracticing;
    @NotEmpty
    private String profileImage;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    } //overrides default to string (makes it print nicer)

}
