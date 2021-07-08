package com.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.model.Sample;
@Component
@Service
public class SampleService {
	private List<Sample> sampleList = new ArrayList<>(Arrays.asList(

            new Sample("123", "Elif"),
            new Sample("456", "Zeynep"),
            new Sample("789", "Elif")

    ));

	public List<Sample> getAllSampleList() {
		
		return sampleList;
	}
	
	public Sample getSample(String id) {
		return sampleList.stream().filter(sample -> sample.getId().equals(id)).findFirst().get();
	}
}
