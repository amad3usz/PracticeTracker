//Code by Eric Heilig
package org.perscholas.practicetracker.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TwoFieldsEqualImpl implements ConstraintValidator<TwoFieldsEqual, Object> {

    private String passwordField;

    private String passwordConfirmField;

    @Override
    public void initialize(TwoFieldsEqual constraintAnnotation) {
        passwordField = constraintAnnotation.passwordField();
        passwordConfirmField = constraintAnnotation.passwordConfirmField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        try {
            final String passwordFieldValue = BeanUtils.getProperty(value, passwordField);
            final String passwordConfirmFieldValue = BeanUtils.getProperty(value, passwordConfirmField);

            if (passwordFieldValue == null && passwordConfirmFieldValue == null) {
                return true;
            }

            if (passwordFieldValue.equals(passwordConfirmFieldValue)) {
                return true;
            }

        } catch (Exception e) {

        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode(passwordField).addConstraintViolation();

        return false;
    }

}
