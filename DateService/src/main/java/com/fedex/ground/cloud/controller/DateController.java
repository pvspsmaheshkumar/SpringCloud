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
public class DateController {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@RequestMapping(value = "/getCurrentDate", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> getCurrentDate() {
		Date dateObject = new Date();
		return new ResponseEntity<>(sdf.format(dateObject).split("T")[0], HttpStatus.OK);
	}
	
}