package com.springboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Sample;
import com.springboot.service.SampleService;
 
@RestController
public class DemoController {

	@Autowired
	
	private SampleService sampservice;
	
	@RequestMapping("/samples")
	
	public List<Sample> all_samples(){
		
		return sampservice.getAllSampleList();
	}
	@RequestMapping("/sample/{id}")
	public Sample getTopic(@PathVariable("id") String id)
	{
		return sampservice.getSample(id);
	}

}
