package com.ssm.validator.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.ssm.validator.constraints.Money;

public class UserAnno {

    private String userName;

    private String password;

    private int age;

    private double money;

    /**
     * @Null 限制只能为null
     * @NotNull 限制必须不为null
     * @AssertFalse 限制必须为false
     * @AssertTrue 限制必须为true
     * @DecimalMax(value) 限制必须为一个不大于指定值的数字
     * @DecimalMin(value) 限制必须为一个不小于指定值的数字
     * @Digits(integer,fraction) 限制必须为一个小数，且整数部分的位数不能超过integer，
     *                           小数部分的位数不能超过fraction
     * @Future 限制必须是一个将来的日期
     * @Max(value) 限制必须为一个不大于指定值的数字
     * @Min(value) 限制必须为一个不小于指定值的数字
     * @Past 限制必须是一个过去的日期
     * @Pattern(value) 限制必须符合指定的正则表达式
     * @Size(max,min) 限制字符长度必须在min到max之间
     */
    @NotBlank(message = "用户名不能为空")
    @Length(min = 5, max = 20, message = "用户名长度必须在5-20之间")
    @Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "用户名必须以字母下划线开头，可由字母数字下划线组成")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotNull(message = "密码不能为null")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Min(value = 10, message = "年龄的最小值为10")
    @Max(value = 50, message = "年龄的最大值为50")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // @Money(min = 10, max = 50, field = "{money}", message = "金额在10到50之间,金额形式为xxx.xx")
    @Money(min = 10, max = 50, field = "金额A", message = "{between.error}")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}