package com.jp.api.web;

import com.jp.api.ApiApplication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Root controller.
 *
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@SuppressWarnings("javadoc")
public class RootController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> index() {
		log.debug("index");
		return ResponseEntity.ok("ok");
	}
	
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public ResponseEntity<String> version() {
		log.debug("version");
		return ResponseEntity.ok(ApiApplication.getVersionString());
	}
	
}
