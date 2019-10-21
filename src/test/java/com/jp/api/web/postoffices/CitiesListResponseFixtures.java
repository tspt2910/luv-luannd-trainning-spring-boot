package com.jp.api.web.postoffices;

import com.jp.api.models.cities.City;

/**
 * Fixtures for search by prefecture code
 */
class CitiesListResponseFixtures {
	
	static CitiesListResponse createResponse(City city) {
		return new CitiesListResponse(city);
	}
}
