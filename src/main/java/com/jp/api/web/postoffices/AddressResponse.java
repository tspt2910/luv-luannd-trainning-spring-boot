package com.jp.api.web.postoffices;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jp.api.models.areas.Area;
import com.jp.api.models.cities.City;
import com.jp.api.models.posts.Post;
import com.jp.api.models.prefectures.Prefecture;
import com.jp.api.utils.Preconditions;
import lombok.Data;

/**
 *
 */
@Data
public class AddressResponse {
	
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
	 * Area's name
	 */
	@JsonProperty("area")
	private String areaName;
	
	/**
	 * Area's name kana
	 */
	@JsonProperty("area_kana")
	private String areaKana;
	
	/**
	 * Multi post area
	 */
	@JsonProperty("multi_post_area")
	private int multiPostArea;
	
	/**
	 * Koaza area
	 */
	@JsonProperty("koaza_area")
	private int koazaArea;
	
	/**
	 * Chome area
	 */
	@JsonProperty("chome_area")
	private int chomeArea;
	
	/**
	 * Old post's code
	 */
	@JsonProperty("old_post_code")
	private String oldPostCode;
	
	/**
	 * Post's code
	 */
	@JsonProperty("post_code")
	private String postCode;
	
	/**
	 * Multi area
	 */
	@JsonProperty("multi_area")
	private int multiArea;
	
	/**
	 * Update show
	 */
	@JsonProperty("update_show")
	private int updateShow;
	
	/**
	 * Change reason
	 */
	@JsonProperty("change_reason")
	private int changeReason;
	
	
	/**
	 * object Address for response
	 * @param area List of {@link Area}
	 */
	public AddressResponse(Area area) {
		Preconditions.checkNotNull(area.getCity(), "City must be not null");
		City city = area.getCity();
		
		Preconditions.checkNotNull(city.getPrefecture(), "Prefecture must be not null");
		Prefecture pref = city.getPrefecture();
		
		Preconditions.checkNotNull(area.getPost(), "Post must be not null");
		Post post = area.getPost();
		
		this.cityCode = city.getCityCode();
		this.cityName = city.getCityName();
		this.cityKana = city.getCityKana();
		this.prefectureName = pref.getPrefectureName();
		this.prefectureKana = pref.getPrefectureKana();
		this.prefectureCode = pref.getPrefectureCode();
		this.areaName = area.getAreaName();
		this.areaKana = area.getAreaKana();
		this.multiPostArea = area.getMultiPostArea();
		this.koazaArea = area.getKoazaArea();
		this.chomeArea = area.getChomeArea();
		this.oldPostCode = area.getOldPost().getOldPostCode();
		this.postCode = post.getPostCode();
		this.multiArea = post.getMultiArea();
		this.updateShow = post.getUpdateShow();
		this.changeReason = post.getChangeReason();
	}
	
}
