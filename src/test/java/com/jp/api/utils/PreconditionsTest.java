package com.jp.api.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link Preconditions}.
 *
 */
class PreconditionsTest {

	/**
	 * Test for method replaceData
	 */
	@Test
	public void replaceDataTest() {
		String dataActual = "aa-bb";
		String resultExpect = "aabb";
		String resultActual = Preconditions.replaceData(dataActual);
		Assertions.assertEquals(resultExpect, resultActual);
	}
}
