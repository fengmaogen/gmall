package com.fmg.validation;

import javax.validation.GroupSequence;

/**
 * @classs: ValidationGroup
 * @author: fengmg
 * @date: 2019/12/27 16:12
 * @description:
 * @version: 1.0
 */
public interface ValidationGroup {

    public interface Login{}

    public interface Register{}

    public interface Query{}

    @GroupSequence(
            value = {Register.class,
                    Login.class}
    )
    public interface Group{}

}
