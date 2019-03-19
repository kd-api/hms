package com.hms.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Anil on 16-03-2019.
 */
public class DateValidator implements ConstraintValidator<CheckDateFormat, String> {

    private static final Logger LOG = LoggerFactory.getLogger(DateValidator.class);

    private String pattern;

    @Override
    public void initialize(CheckDateFormat constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext constraintContext) {
        try {
            return dateStr == null || (new SimpleDateFormat(pattern).parse(dateStr) != null);
        } catch (ParseException ex) {
            LOG.error("Exception occured in DateValidator::isValid method", ex);
        }
        return false;
    }
}
