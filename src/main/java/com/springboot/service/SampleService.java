package com.springboot.service;

import java.util.*;

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
	
	public boolean delete(String id) {
		var isRemoved = this.sampleList.removeIf(Sample -> Sample.getId().equals(id));
		return isRemoved;
	}
}
