package com.jp.api.utils;

public class Preconditions {
	
	/**
	 * Ensures that an object reference passed as a parameter to the calling method is not null.
	 *
	 * @param reference an object reference
	 * @param errorMessage the exception message to use if the check fails; will be converted to a
	 *     string using {@link String#valueOf(Object)}
	 * @return the non-null reference that was validated
	 * @throws NullPointerException if {@code reference} is null
	 *
	 */
	public static <T> T checkNotNull(T reference, Object errorMessage) {
		if (reference == null || reference.toString().isEmpty()) {
			throw new NullPointerException(String.valueOf(errorMessage));
		}
		return reference;
	}
	
	/**
	 * @param reference an object reference
	 * @param errorMessage Message when check false
	 */
	public static void checkHalfSize(String reference, Object errorMessage) {
		if (replaceData(reference).matches("^[0-9]+$") == false) {
			throw new IllegalArgumentException(String.valueOf(errorMessage));
		}
	}
	
	/**
	 * Remove space and "-" from input.
	 *
	 * @param input string requires processing
	 * @return string after processing
	 */
	public static String replaceData(String input) {
		if (input != null) {
			input = input.replace("\\s+", "");
			input = input.replace("-", "");
		}
		
		return input;
	}
}
