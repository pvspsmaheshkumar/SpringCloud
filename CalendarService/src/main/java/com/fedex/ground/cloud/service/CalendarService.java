package com.fedex.ground.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fedex.ground.cloud.beans.DateTimeModel;

@Service
public class CalendarService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${dateServiceUrl}")
	public String dateServiceUrl;

	@Value("${timeServiceUrl}")
	public String timeServiceUrl;

	public DateTimeModel getCalendarDetails(String hostName) {
		DateTimeModel dateTimeModel = new DateTimeModel();
//		String currentDate = restTemplate.getForObject("http://localhost:7002/DateService/v1/getCurrentDate", String.class);
//		String currentTime = restTemplate.getForObject("http://localhost:7003/TimeService/v1/getCurrentTime", String.class);

		// With @LoadBalanced, instead of giving the hostname and port in the URL, we can specify the service name
		String currentDate = restTemplate.getForObject(dateServiceUrl, String.class);
		String currentTime = restTemplate.getForObject(timeServiceUrl, String.class);

		dateTimeModel.setCurrentDate(currentDate);
		dateTimeModel.setCurrentTime(currentTime);
		
		if(null != hostName) {
			dateTimeModel.setMessage("Returning from instance running on port " + hostName.split(":")[1]);
		}
		else {
			dateTimeModel.setMessage("");
		}
		return dateTimeModel;
	}

}
