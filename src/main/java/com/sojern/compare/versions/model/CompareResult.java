package com.sojern.compare.versions.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Result of comperasion")
public class CompareResult {
	private Integer result;
	private String message;
}
