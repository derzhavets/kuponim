package com.derzhavets.kuponim.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.derzhavets.kuponim.helpers.IncomeType;

/**
 * Annotation to mark business logic methods that produce system income 
 * @param type of income to be registered
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportIncome {
	
	IncomeType type();
	
}
