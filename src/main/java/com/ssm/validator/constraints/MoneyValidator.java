package com.ssm.validator.constraints;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MoneyValidator implements ConstraintValidator<Money, Double> {

    private String moneyReg = "^\\d+(\\.\\d{1,2})?$";// 表示金额的正则表达式
    private Pattern moneyPattern = Pattern.compile(moneyReg);

    private double max;
    private double min;
    private String field;

    public void initialize(Money money) {
        max = money.max();
        min = money.min();
        field = money.field();
    }

    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        boolean mflg = moneyPattern.matcher(value.toString()).matches();
        if (!mflg) {
            return false;
        }

        if (min <= value && value <= max) {
            return true;
        }

        return false;
    }

}
