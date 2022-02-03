package org.perscholas.practicetracker.validation;

import org.apache.commons.lang3.StringUtils;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {
    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        User user = userDAO.findByEmail(value);
//        boolean passes = ! StringUtils.equals(value, "a@b.com");

        return (user == null);
    }
}
