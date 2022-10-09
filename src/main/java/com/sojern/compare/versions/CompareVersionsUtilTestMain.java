package com.sojern.compare.versions;

import org.apache.commons.lang3.StringUtils;

import com.sojern.compare.versions.util.CompareVersionsUtil;

public class CompareVersionsUtilTestMain {

	public static void main(String[] args) {
		// Read parameters
		String v1 = args[0];
		String v2 = args[1];
		String resultString = "";
		if (StringUtils.isBlank(v1) || StringUtils.isBlank(v2)) {
			throw new IllegalArgumentException("v1 and v2 values are required!!");
		}
		System.out.println("v1:     " + v1);
		System.out.println("v2:     " + v2);

		int result = CompareVersionsUtil.compare(v1, v2);
		if (result == 0) {
			resultString = "==";
		} else if (result == 1) {
			resultString = ">";
		} else if (result == -1) {
			resultString = "<";
		}
		System.out.println("");
		System.out.println(String.format("Result: %s %s %s", v1, resultString, v2));
	}

}
