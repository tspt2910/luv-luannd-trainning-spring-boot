package com.jp.api.web.postoffices;

import com.jp.api.models.areas.Area;

/**
 * Fixtures for find by post code
 *
 */
public class AddressResponseFixtures {
	
	static AddressResponse createResponse(Area tblArea) {
		return new AddressResponse(tblArea);
	}
}
