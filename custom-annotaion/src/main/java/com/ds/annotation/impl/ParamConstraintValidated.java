package com.ds.annotation.impl;

import com.ds.annotation.Check;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xxxxx
 * @create: 2020-12-07
 */
public class ParamConstraintValidated implements ConstraintValidator<Check,Object> {
    private List<String> values;

    @Override
    public void initialize(Check constraintAnnotation) {
        values = Arrays.asList(constraintAnnotation.values());
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (values.contains(o)) {
            return true;
        }
        //不在指定的参数列表中
        return false;
    }
}
