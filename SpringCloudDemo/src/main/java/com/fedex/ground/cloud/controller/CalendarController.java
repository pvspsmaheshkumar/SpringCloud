package com.fedex.ground.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.ground.cloud.beans.DateTimeModel;
import com.fedex.ground.cloud.service.CalendarService;

@RequestMapping("/v1")
@RestController
@RefreshScope
public class CalendarController {

	
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping(value = "/getCalendarInfo", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<DateTimeModel> getCalendarInfo() {
		DateTimeModel dateTimeModel = calendarService.getCalendarDetails();
		return new ResponseEntity<>(dateTimeModel, HttpStatus.OK);
	}

}