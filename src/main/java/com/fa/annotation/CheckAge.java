package com.fa.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.fa.vadilation.ValidateAge;

@Documented
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidateAge.class)
public @interface CheckAge {
	String message() default "Invalid your age";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
