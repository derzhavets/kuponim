package com.derzhavets.kuponim.dao.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.derzhavets.kuponim.entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>{
	
	/**
	 * Retrieve all the coupon entities from the database
	 * 
	 * @return list of found coupons
	 */
	List<Coupon> findAll();
	
	/**
	 * Get all the coupon entities from the database based on their end date comparing
	 * it against date passed in the parameters
	 * 
	 * @param date to compare
	 * @return list of found coupons
	 */
	@Query("SELECT c from Coupon c where c.endDate < :date")
	List<Coupon> getExpiredFrom(@Param("date") LocalDate date);
	
}
