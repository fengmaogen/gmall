package com.fmg.lombok;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @classs: AnnotationTest
 * @author: fengmg
 * @date: 2019/12/25 10:28
 * @description:
 * @version: 1.0
 */
public class AnnotationTest {

    @Getter(
            value = AccessLevel.PRIVATE,
            onMethod_={@NotNull}
    )
    private String field1;
    @Setter(

    )
    private String field2;
    private String field3;
}
