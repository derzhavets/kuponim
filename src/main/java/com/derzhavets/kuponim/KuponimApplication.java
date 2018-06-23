package com.derzhavets.kuponim;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.derzhavets.kuponim.dao.CouponRepository;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.CouponType;

@SpringBootApplication
public class KuponimApplication {

	public static void main(String[] args) {
		SpringApplication.run(KuponimApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(CouponRepository repo) {
		return args -> {
			Coupon coupon = new Coupon();
			coupon.setAmount(10);
			coupon.setImageUrl("/no/way");
			coupon.setType(CouponType.ELECTRICITY);
			repo.save(coupon);
		};
	}
}
