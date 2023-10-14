package com.deliveryBoy.Controller;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryBoy.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private  KafkaService kafkaService;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation(){
		this.kafkaService.updateLocation("( "+Math.round(Math.random()*100)+" ,"+Math.round(Math.random()*100)+""+")");
		System.out.println("It works!");
		return new ResponseEntity<>(Map.of("messsage","Success!!"),HttpStatus.OK);
		
	}
	
	@RequestMapping("/testing")
	public void getName() {
		this.logger.info("message produced");
		System.out.println("Woekin");
	}
}
