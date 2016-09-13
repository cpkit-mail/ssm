package com.ssm.validator.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MoneyValidator.class)
public @interface Money {

    String message() default "{com.ssm.validator.constraints.Money.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    double max() default Double.MIN_VALUE;

    double min() default Double.MAX_VALUE;

    String field() default "";

}
