package com.gatewaysample.red;

import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DetailController {

	@GetMapping("/red/detail")
	public Response detail() {

		Response res = new Response();
		res.setStatusCode(200);
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "red");
		data.put("type", "color");
		data.put("value", "#ff0000");
		res.setData(data);
		return res;
	}

	@Data
	class Response {
		private int statusCode;
		private Map<String, String> data;
	}
}
