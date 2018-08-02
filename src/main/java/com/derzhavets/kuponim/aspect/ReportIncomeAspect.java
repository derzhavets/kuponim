package com.derzhavets.kuponim.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.derzhavets.kuponim.dao.CustomerDao;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.entities.Income;
import com.derzhavets.kuponim.helpers.IncomeType;
import com.derzhavets.kuponim.services.api.IncomeConnectorService;

@Aspect
@Component
public class ReportIncomeAspect {
	
//	@Around("@annotation(ReportIncome)")
//	public void doShit() {
//		System.err.println("THIS IS ME DOING SHET");
//	}
	@Autowired
	private IncomeConnectorService incomeService;
	
	@Autowired
	private CustomerDao customerDao;
	
	@AfterReturning(pointcut = "@annotation(ReportIncome)", returning = "retVal")
	public void sayHo(JoinPoint joinPoint, Object retVal) {
		
		ReportIncome reportIncomeAnno = getAnnotation(joinPoint);
		
		switch (reportIncomeAnno.type()) {
			case COMPANY_NEW_COUPON:
				Income income = new Income(((Coupon)retVal).getCompany().getEmail(), 
						IncomeType.COMPANY_NEW_COUPON, 100.0);
				incomeService.sendIncome(income);
				break;
			case COMPANY_UPDATE_COUPON:
				Income income2 = new Income(((Coupon)retVal).getCompany().getEmail(), 
						IncomeType.COMPANY_UPDATE_COUPON, 10.0);
				incomeService.sendIncome(income2);
				break;
			case CUSTOMER_PURCHASE:
				Income income3 = new Income(
						customerDao.getById((Long)joinPoint.getArgs()[0]).getEmail(), 
						IncomeType.CUSTOMER_PURCHASE, 
						((Coupon)retVal).getPrice());
				incomeService.sendIncome(income3);
				break;
			default:
				break;
		}
		
	}
	
	private ReportIncome getAnnotation(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getMethod().getAnnotation(ReportIncome.class);
	}
}
