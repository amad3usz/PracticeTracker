//Code by Eric Heilig
package org.perscholas.practicetracker.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TwoFieldsEqualImpl.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TwoFieldsEqual {

    String passwordField();

    String passwordConfirmField();

    String message() default "{TwoFieldsEqual}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
