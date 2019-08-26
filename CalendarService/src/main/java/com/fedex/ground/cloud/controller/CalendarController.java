package com.fedex.ground.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.ground.cloud.beans.DateTimeModel;
import com.fedex.ground.cloud.service.CalendarService;

@RequestMapping("/v1")
@RestController
public class CalendarController {

	@Autowired
	private CalendarService calendarService;

	@RequestMapping(value = "/getCalendarInfo", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<DateTimeModel> getCalendarInfo(@RequestHeader("Host") String hostName) {
		DateTimeModel dateTimeModel = calendarService.getCalendarDetails(hostName);
		return new ResponseEntity<>(dateTimeModel, HttpStatus.OK);
	}
	
}