package com.sojern.compare.versions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sojern.compare.versions.util.CompareVersionsUtil;

@SpringBootTest
@DisplayName("Version Control Test")
class CompareVersionsApplicationTests {

	@Test
	@DisplayName("Check Equal Version")
	void equalVersionTest() {
		assertEquals(CompareVersionsUtil.compare("0.1", "0.1"), 0);
		assertEquals(CompareVersionsUtil.compare("0.1.0", "0.1"), 0);
		assertEquals(CompareVersionsUtil.compare("0.1.7", "0.1.7"), 0);
		assertEquals(CompareVersionsUtil.compare("0.1.6", "0.1.6"), 0);
		assertEquals(CompareVersionsUtil.compare("0.1.6", "0.1.6.0"), 0);
		assertEquals(CompareVersionsUtil.compare("10.7.86", "10.7.86"), 0);
		assertNotEquals(CompareVersionsUtil.compare("10.7.861", "10.7.86"), 0);
	}

	@Test
	@DisplayName("Check Greater Than Version")
	void greaterVersionTest() {
		assertEquals(CompareVersionsUtil.compare("0.11", "0.1"), 1);
		assertEquals(CompareVersionsUtil.compare("0.1.7.1", "0.1.7"), 1);
		assertEquals(CompareVersionsUtil.compare("0.1.6.1", "0.1.5"), 1);
		assertEquals(CompareVersionsUtil.compare("10.7.96", "10.7.86"), 1);
		assertNotEquals(CompareVersionsUtil.compare("10.7.96", "10.7.96.1"), 1);
		assertEquals(CompareVersionsUtil.compare("10.7.97", "10.7.96.1"), 1);
	}

	@Test
	@DisplayName("Check Less Than Version")
	void lessVersionTest() {
		assertEquals(CompareVersionsUtil.compare("0.10", "0.11"), -1);
		assertEquals(CompareVersionsUtil.compare("0.1.7", "0.1.7.1"), -1);
		assertEquals(CompareVersionsUtil.compare("0.1.6.1", "0.1.6.2"), -1);
		assertEquals(CompareVersionsUtil.compare("10.6.96", "10.7.96"), -1);
		assertNotEquals(CompareVersionsUtil.compare("10.7.96", "10.6.96"), -1);
		assertEquals(CompareVersionsUtil.compare("10.6.977777", "10.7.0"), -1);
	}

}
