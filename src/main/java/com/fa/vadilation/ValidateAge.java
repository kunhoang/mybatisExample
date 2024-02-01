package com.fa.vadilation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.fa.annotation.CheckAge;

public class ValidateAge implements ConstraintValidator<CheckAge, Integer> {

	@Override
	public void initialize(CheckAge checkAge) {
    }
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		if(age > 0 && age < 100) {
			return true;
		}
		return false;
	}

}
