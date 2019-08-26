package com.fedex.ground.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.ground.cloud.beans.HealthCheck;

@RestController
@RequestMapping("/v1")
@RefreshScope
public class SpringCloudController {
	
	@Value("${spring.profiles.active}")
	private String level;
	
	@Value("${sampleKey1}")
	public String configFromCfgServer;
	
	
	@RequestMapping("/sampleKey")
	public String sampleMethod() {
		return configFromCfgServer;
	}
	
	@RequestMapping(value = "/healthCheck", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<HealthCheck> healthCheck() {
		HealthCheck healthCheck = new HealthCheck();
		healthCheck.setLevel(this.level);
		healthCheck.setServerStatus("Available");
		healthCheck.setMessage("UP");
		return new ResponseEntity<>(healthCheck, HttpStatus.OK);
	}
	
}
