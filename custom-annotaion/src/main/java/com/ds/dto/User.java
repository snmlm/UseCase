package com.ds.dto;

import com.ds.annotation.Check;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author: xxxxx
 * @create: 2020-12-07
 */
@Data
public class User {
    @NotEmpty
    private String name;
    @Check(values = {"man","woman"},message = "11111")
    private String sex;
}
