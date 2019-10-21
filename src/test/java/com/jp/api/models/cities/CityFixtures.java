package com.jp.api.models.cities;

import com.jp.api.models.prefectures.Prefecture;

/**
 * Fixtures for {@link City}.
 *
 */
public class CityFixtures {
	
	public static City createCity() {
		City city = new City("01102", "city_kana413134", "city413134",
				new Prefecture(1, "ﾎｯｶｲﾄﾞｳ", "北海道", "01"));
		city.setCityId(13265);

		return city;
	}
}
