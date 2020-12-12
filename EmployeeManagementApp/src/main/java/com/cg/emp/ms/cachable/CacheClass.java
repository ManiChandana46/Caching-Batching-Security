//package com.cg.emp.ms.cachable;
//
//import java.util.Arrays;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.concurrent.ConcurrentMapCache;
//import org.springframework.cache.support.SimpleCacheManager;
//import org.springframework.context.annotation.Bean;
//
//
//public class CacheClass {
//
//	public static void main(String args[])
//	{
//	CacheClass emp=new CacheClass();
//	  System.out.println("FirstTime");
//	  System.out.println(emp.relax(1));
//	  System.out.println("SecondTime");
//	  System.out.println(emp.relax(2));
//	}
//	
//	@Bean
//	public CacheManager cacheManager() {
//		SimpleCacheManager cacheManager = new SimpleCacheManager();
//		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("abc")));
//		return cacheManager;
//	}
//
//	@Cacheable(value = "abc" , condition = "#seconds > 3")
//	public String relax(int seconds) {
//		System.out.println("Relax for a while...");
//		try {
//			Thread.sleep(seconds * 1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return "DoneDonaDone";
//	}
//
//}
