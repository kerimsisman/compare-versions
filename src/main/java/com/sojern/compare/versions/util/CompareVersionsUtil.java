package com.sojern.compare.versions.util;

/**
 * Compare version util include version compare methods
 * 
 * @author kerim.sisman
 *
 */
public final class CompareVersionsUtil {

	/**
	 * Hide constuctor
	 */
	private CompareVersionsUtil() {

	}

	/**
	 * Compare 2 version, check old/new or equal cases </br>
	 * if result 0 means version equals</br>
	 * if result 1 v1 is greater than v2</br>
	 * if result -1 v2 is greater than v1
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static int compare(String v1, String v2) {
		
		// vnum stores each numeric part of version
		int vnum1 = 0, vnum2 = 0;

		for (int i = 0, j = 0; (i < v1.length() || j < v2.length());) {
			// Storing numeric part of
			// version 1 in vnum1
			while (i < v1.length() && v1.charAt(i) != '.') {
				vnum1 = vnum1 * 10 + (v1.charAt(i) - '0');
				i++;
			}

			// storing numeric part
			// of version 2 in vnum2
			while (j < v2.length() && v2.charAt(j) != '.') {
				vnum2 = vnum2 * 10 + (v2.charAt(j) - '0');
				j++;
			}

			if (vnum1 > vnum2)
				return 1;
			if (vnum2 > vnum1)
				return -1;

			// if equal, reset variables and
			// go for next numeric part
			vnum1 = vnum2 = 0;
			i++;
			j++;
		}
		return 0;
		
	}
}
