package com.jp.api.models.cities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jp.api.models.prefectures.Prefecture;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * City model.
 */
@Entity
@Table(name = "tbl_city")
@Data
@NoArgsConstructor
public class City {
	
	/**
	 * City's ID
	 */
	@Id
	@GeneratedValue
	@Column(name = "city_id")
	@JsonIgnore
	private long cityId;
	
	/**
	 * Code of City
	 */
	@Column(name = "code")
	@JsonProperty("code")
	@NotNull
	private String cityCode;
	
	/**
	 * Name Kana of City
	 */
	@Column(name = "city_kana")
	@JsonProperty("city_kana")
	@NotNull
	private String cityKana;
	
	/**
	 * City's name
	 */
	@Column(name = "city")
	@JsonProperty("city")
	@NotNull
	private String cityName;
	
	/**
	 * Prefecture ID
	 */
	@ManyToOne
	@JoinColumn(name = "prefecture_id")
	@JsonProperty("prefecture")
	@NotNull
	private Prefecture prefecture;
	
	
	/**
	 * Create instance.
	 *
	 * @param cityCode  code of City
	 * @param cityKana  name Kana of City
	 * @param cityName City's Name
	 * @param prefecture {@link Prefecture}
	 */
	public City(String cityCode, String cityKana, String cityName, Prefecture prefecture) {
		this.cityCode = cityCode;
		this.cityKana = cityKana;
		this.cityName = cityName;
		this.prefecture = prefecture;
	}
}
