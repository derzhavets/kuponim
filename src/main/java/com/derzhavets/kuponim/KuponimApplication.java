package com.derzhavets.kuponim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableScheduling
public class KuponimApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KuponimApplication.class, args);
	}
	
	@Bean	
	public FilterRegistrationBean<CorsFilter> corsFilter() { 
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	}
	
//	@Bean
//    public TaskExecutor threadPoolTaskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(4);
//        executor.setMaxPoolSize(4);
//        executor.setThreadNamePrefix("default_task_executor_thread");
//        executor.initialize();
//        return executor;
//    }
//	
//	@Bean
//	public CommandLineRunner startCouponCheck(TaskExecutor executor) {
//		return args -> {
//			executor.execute(new CouponCheckThread());
//		};
//	}

}
