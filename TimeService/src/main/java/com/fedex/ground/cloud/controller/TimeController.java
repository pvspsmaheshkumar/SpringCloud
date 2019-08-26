package com.fedex.ground.cloud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class TimeController {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@RequestMapping(value = "/getCurrentTime", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> getCurrentTime() {
		Date dateObject = new Date();
		return new ResponseEntity<>(sdf.format(dateObject).split("T")[1], HttpStatus.OK);
	}
	
}