package com.fedex.ground.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fedex.ground.cloud.beans.DateTimeModel;

@RequestMapping("/v1")
@RestController
@RefreshScope
public class CalendarController {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Value("${dateServiceUrl}")
	public String dateServiceUrl;

	@Value("${timeServiceUrl}")
	public String timeServiceUrl;

	@RequestMapping(value = "/getCalendarInfo", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<DateTimeModel> getCalendarInfo() {
		DateTimeModel dateTimeModel = new DateTimeModel();
//		String currentDate = restTemplate.getForObject("http://localhost:7002/DateService/v1/getCurrentDate", String.class);
//		String currentTime = restTemplate.getForObject("http://localhost:7003/TimeService/v1/getCurrentTime", String.class);
		
		// With @LoadBalanced, instead of giving the hostname in the URL, we can specify the service name
		String currentDate = restTemplate.getForObject(dateServiceUrl, String.class);
		String currentTime = restTemplate.getForObject(timeServiceUrl, String.class);
		System.out.println("Calendar Info :: "+currentDate +"T"+ currentTime);
		dateTimeModel.setCurrentDate(currentDate);
		dateTimeModel.setCurrentTime(currentTime);
		return new ResponseEntity<>(dateTimeModel, HttpStatus.OK);
	}

}