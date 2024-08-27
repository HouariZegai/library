package com.houarizegai.library.validator;

import org.apache.commons.validator.routines.ISBNValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ValidISBNValidator implements ConstraintValidator<ValidISBN, String> {

    private ISBNValidator isbnValidator;

    @Override
    public void initialize(ValidISBN constraintAnnotation) {
        isbnValidator = new ISBNValidator();
    }

    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext constraintValidatorContext) {
        return Objects.isNull(isbn) || isbnValidator.isValid(isbn);
    }
}
