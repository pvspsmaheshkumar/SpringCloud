package com.fedex.ground.cloud.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fedex.ground.cloud.beans.DateTimeModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CalendarService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${calendarServiceUrl}")
	public String calendarServiceUrl;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@HystrixCommand(fallbackMethod = "defaultCalendarDetails")
	public DateTimeModel getCalendarDetails() {
		DateTimeModel dateTimeModel = new DateTimeModel();
//		String currentDate = restTemplate.getForObject("http://localhost:7002/DateService/v1/getCurrentDate", String.class);
//		String currentTime = restTemplate.getForObject("http://localhost:7003/TimeService/v1/getCurrentTime", String.class);

		// With @LoadBalanced, instead of giving the hostname in the URL, we can specify the service name
		dateTimeModel = restTemplate.getForObject(calendarServiceUrl, DateTimeModel.class);
		return dateTimeModel;
	}
	
	public DateTimeModel defaultCalendarDetails() {
		DateTimeModel dateTimeModel = new DateTimeModel();
		Date dateObject = new Date();
		dateTimeModel.setCurrentDate(sdf.format(dateObject).split("T")[0]);
		dateTimeModel.setCurrentTime(sdf.format(dateObject).split("T")[1]);
		dateTimeModel.setMessage("Returning data from fallback method due to unavailability of date/time microservices");	
		return dateTimeModel;
	}

}
