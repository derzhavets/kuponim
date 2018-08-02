package com.derzhavets.kuponim.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.derzhavets.kuponim.helpers.IncomeType;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportIncome {
	
	IncomeType type();
	
}
