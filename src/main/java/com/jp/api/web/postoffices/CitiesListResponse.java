package com.jp.api.web.postoffices;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jp.api.models.cities.City;
import com.jp.api.models.prefectures.Prefecture;
import com.jp.api.utils.Preconditions;

import lombok.Data;

@Data
public class CitiesListResponse {
	
	/**
	 * City's code
	 */
	@JsonProperty("code")
	private String cityCode;
	
	/**
	 * City's name
	 */
	@JsonProperty("city")
	private String cityName;
	
	/**
	 * City's name kana
	 */
	@JsonProperty("city_kana")
	private String cityKana;
	
	/**
	 * Prefecture's name
	 */
	@JsonProperty("prefecture")
	private String prefectureName;
	
	/**
	 * Prefecture's name kana
	 */
	@JsonProperty("prefecture_kana")
	private String prefectureKana;
	
	/**
	 * Prefecture's code
	 */
	@JsonProperty("prefecture_code")
	private String prefectureCode;
	
	
	/**
	 * Create instance.
	 *
	 * @param city {@link City}
	 */
	public CitiesListResponse(City city) {
		Preconditions.checkNotNull(city.getPrefecture(), "Prefecture must be not null");
		Prefecture pref = city.getPrefecture();
		this.cityName = city.getCityName();
		this.cityCode = city.getCityCode();
		this.cityKana = city.getCityKana();
		this.prefectureName = pref.getPrefectureName();
		this.prefectureKana = pref.getPrefectureKana();
		this.prefectureCode = pref.getPrefectureCode();
	}
	
}
