package com.in28Min.learn_spring_aop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.in28Min.learn_spring_aop.aopexample.custom_annotations.Tracktime;
import com.in28Min.learn_spring_aop.aopexample.data.DataService1;

@Service
public class BusinessService1 {
	
	private DataService1 dataService1;
	
	public BusinessService1(DataService1 dataService1) {
		this.dataService1 = dataService1;
	}

	@Tracktime
	public int calculateMax() {
		int data[] = dataService1.retrieveData();
//		throw new RuntimeException("Something went wrong");
		return Arrays.stream(data).max().orElse(0);
	}
	

}
