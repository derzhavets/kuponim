package com.derzhavets.kuponim.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derzhavets.kuponim.entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>{
	
	List<Coupon> findAll();
	
	<C extends Coupon> Coupon save(Coupon c);
	
	Optional<Coupon> findById(Long id);
	
	void deleteById(Long id);
}
