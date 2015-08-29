package com.pc.buyer.annotation;

import java.lang.annotation.*;

/**
 * @author hesin
 * @Created with： com.pc.buyer.annotation
 * @Des: TODO
 * @date 2015/8/25
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {
    public String key() default ""; //对应的KEY
    public String value() default ""; // 值
    public String method() default ""; //方法 执行的方法
    public int expire() default 7*24*60*60; // 默认有效期 7天有效期
//    public KeyMode keyMode() default KeyMode.DEFAULT;       //key的后缀模式

}
