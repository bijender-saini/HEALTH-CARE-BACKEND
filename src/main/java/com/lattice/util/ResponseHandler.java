package com.lattice.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	private ResponseHandler() {
		// private constructor
	}

	public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean isSuccess, String message,
			Object data) {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("timestamp", new Date());
			map.put("status", status.value());
			map.put("isSucess", isSuccess);
			map.put("message", message);
			map.put("data", data);

			return new ResponseEntity<>(map, status);
		} catch (Exception e) {
			map.clear();
			map.put("timestamp", new Date());
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put("isSucess", false);
			map.put("message", e.getMessage());
			map.put("data", null);
			return new ResponseEntity<>(map, status);
		}
	}

	public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean isSuccess, String message) {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("status", status.value());
			map.put("isSucess", isSuccess);
			map.put("message", message);
			map.put("timestamp", new Date());
			return new ResponseEntity<>(map, status);
		} catch (Exception e) {
			map.clear();
			map.put("timestamp", new Date());
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put("isSucess", false);
			map.put("message", e.getMessage());
			map.put("data", null);
			return new ResponseEntity<>(map, status);
		}
	}
}
