package org.perscholas.practicetracker.validation;

import org.apache.commons.lang3.StringUtils;
import org.perscholas.practicetracker.database.dao.UserDAO;
import org.perscholas.practicetracker.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqueImpl implements ConstraintValidator<UsernameUnique, String>{

    @Autowired
    private UserDAO userDao;

    @Override
    public void initialize(UsernameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // a custom validation should validate 1 and only 1 thing.
        // since a check for not null or not empty already exists
        // we want this function to return true in that case which will
        // prevent the error message for this validation from displaying
        // when the incoming value is null or empty.
        // this is a good design pattern and should be implemented as the first
        // thing in all custom validations.
        if ( StringUtils.isEmpty(value) ) {
            return true;
        }

//        boolean passes = ! StringUtils.equals(value, "a@b.com");
        User user = userDao.findByUsername(value);
//        return ( passes );
        return ( user == null );
    }

}
