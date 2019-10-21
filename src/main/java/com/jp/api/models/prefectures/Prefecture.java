package com.jp.api.models.prefectures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jp.api.models.cities.City;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Prefecture model
 */
@Entity
@Table(name = "tbl_prefecture")
@NoArgsConstructor
@Data
public class Prefecture {
	
	/**
	 * Prefecture's ID
	 */
	@Id
	@Column(name = "prefecture_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prefectureId;
	
	/**
	 * Prefecture's name kana
	 */
	@Column(name = "prefecture_kana")
	@JsonProperty("prefecture_kana")
	@NotNull
	private String prefectureKana;
	
	/**
	 * Prefecture's name
	 */
	@Column(name = "prefecture")
	@JsonProperty("prefecture")
	@NotNull
	private String prefectureName;
	
	/**
	 * Prefecture's code
	 */
	@Column(name = "prefecture_code", unique = true)
	@JsonProperty("prefecture_code")
	@NotNull
	private String prefectureCode;
	
	
	/**
	 * @param prefectureId Prefecture's ID
	 * @param prefectureKana Prefecture's name kana
	 * @param prefectureName Prefecture's name
	 * @param prefectureCode Prefecture's code
	 */
	public Prefecture(int prefectureId, String prefectureKana, String prefectureName, String prefectureCode) {
		this.prefectureId = prefectureId;
		this.prefectureKana = prefectureKana;
		this.prefectureName = prefectureName;
		this.prefectureCode = prefectureCode;
	}
}
