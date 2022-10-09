package com.sojern.compare.versions.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sojern.compare.versions.model.CompareResult;
import com.sojern.compare.versions.util.CompareVersionsUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
	
@RestController
@RequestMapping
public class CompareController {
	private static final String regex = "^[0-9]+(\\.[0-9]+)*$";
	Pattern p = Pattern.compile(regex);

	@Operation(summary = "Get the comperasion result", description = "Compare given version and resturn result")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Result of comperasion. Result attribute shows the util response and message shows the human readable response  ", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CompareResult.class)) }),

			@ApiResponse(responseCode = "400", description = "Versions are not in vaild format. "),
			@ApiResponse(responseCode = "500", description = "Compare util return an unexpected result.") })
	@GetMapping("/compare")
	public ResponseEntity<CompareResult> compareVersions(@RequestParam(required = true) String v1,
			@RequestParam(required = true) String v2) {

		if (!isValidVersion(v1)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new CompareResult(null, "v1 is not valid version"));
		} else if (!isValidVersion(v2)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new CompareResult(null, "v2 is not valid version"));
		}

		int result = CompareVersionsUtil.compare(v1, v2);

		String resultString = "";
		if (result == 0) {
			resultString = "==";
		} else if (result == 1) {
			resultString = ">";
		} else if (result == -1) {
			resultString = "<";
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new CompareResult(null, "Some thing went wrong :("));
		}

		return ResponseEntity.ok(new CompareResult(result, String.format("%s %s %s", v1, resultString, v2)));
	}

	/**
	 * Check valid version
	 * 
	 * @param version
	 * @return
	 */
	private boolean isValidVersion(String version) {
		Matcher m = p.matcher(version);
		// Return if the identifier
		// matched the ReGex
		return m.matches();
	}

}
