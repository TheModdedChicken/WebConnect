package io.github.themoddedchicken.WebConnect.lib.annotations.sql;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Field {
	String value() default "";
}
