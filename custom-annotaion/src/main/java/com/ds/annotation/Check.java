package com.ds.annotation;

import com.ds.annotation.impl.ParamConstraintValidated;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author: xxxxx
 * @create: 2020-12-07
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ParamConstraintValidated.class)
public @interface Check {
    String[] values();
    String message() default "参数不为指定值";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
