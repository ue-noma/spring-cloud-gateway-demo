package com.gatewaysample.red;

import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UpdateController {
	
	@GetMapping("/red/update")
	public Response update() {
		Response res = new Response();
		res.setStatusCode(200);
		return res;
	}

	@Data
	class Response {
		private int statusCode;
	}
}
