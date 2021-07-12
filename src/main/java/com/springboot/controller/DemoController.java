package com.springboot.controller;
import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Sample;
import com.springboot.service.SampleService;

@RestController
public class DemoController {

	@Autowired
	
	private SampleService sampservice;
	
	@GetMapping("/samples")
	public List<Sample> all_sample(){
		return sampservice.getAllSampleList();
	}
	
	@GetMapping("/samples/{id}")
	public ResponseEntity<Sample> getSample(@PathVariable("id") String id){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Header", " ...");
		return new ResponseEntity<Sample>(sampservice.getSample(id),headers,HttpStatus.OK);
	}
	
	
	@DeleteMapping (value = "/samples/delete/{id}")
	public ResponseEntity<Sample> deleteSample(@PathVariable String id){
		var isRemoved = sampservice.delete(id);
		if(!isRemoved){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Sample> (HttpStatus.OK);
	}
	
	@PostMapping(value = "/samples/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Sample> createSample (@RequestBody Sample sample){
			Sample returnValue = new Sample();
			returnValue.setId("Dans");
			returnValue.setName("Renk");
			return new ResponseEntity<Sample>(returnValue,HttpStatus.OK);
	}
	
	@PutMapping(value = "/samples/put/{id}",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Sample> putSample(@PathVariable String id){
		Sample sample = new Sample();
		sample.setId("Rengarenk");
		return new ResponseEntity<Sample>(sample,HttpStatus.OK);
	}
}
