package io.github.themoddedchicken.WebConnect.lib.annotations.sql;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE})
public @interface Table {
	String value();
}