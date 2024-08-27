package com.houarizegai.library.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValidISBNValidator.class)
public @interface ValidISBN {
    String message() default "Invalid ISBN";
    Class<?>[] group() default {};
    Class<? extends Payload>[] payload() default {};
}
