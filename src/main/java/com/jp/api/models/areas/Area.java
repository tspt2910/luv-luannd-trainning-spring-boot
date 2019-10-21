package com.jp.api.models.areas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jp.api.models.cities.City;
import com.jp.api.models.oldposts.OldPost;
import com.jp.api.models.posts.Post;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Area model.
 *
 */
@Entity
@Table(name = "tbl_area")
@Data
@NoArgsConstructor
public class Area implements Serializable {
	
	/**
	 * Area's ID
	 */
	@Id
	@Column(name = "area_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long areaId;
	
	/**
	 * Area's name kana
	 */
	@Column(name = "area_kana")
	@NotNull
	@JsonProperty("area_kana")
	private String areaKana;
	
	/**
	 * Area's name
	 */
	@Column(name = "area")
	@NotNull
	@JsonProperty("area")
	private String areaName;
	
	/**
	 * City's ID
	 */
	@ManyToOne
	@JoinColumn(name = "city_id")
	@JsonProperty("city")
	private City city;
	
	/**
	 * Chome area
	 */
	@Column(name = "chome_area")
	@JsonProperty("chome_area")
	private int chomeArea;
	
	/**
	 * Koaza area
	 */
	@Column(name = "koaza_area")
	@JsonProperty("koaza_area")
	private int koazaArea;
	
	/**
	 * Multi post area
	 */
	@Column(name = "multi_post_area")
	@JsonProperty("multi_post_area")
	private int multiPostArea;
	
	/**
	 * Post's ID
	 */
	@ManyToOne
	@JoinColumn(name = "post_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Post post;
	
	/**
	 * Old post's ID
	 */
	@ManyToOne
	@JoinColumn(name = "old_post_id")
	private OldPost oldPost;
	
	
	/**
	 * Create instance.
	 *
	 * @param areaKana area kana
	 * @param areaName area name
	 * @param city {@link City}
	 * @param chomeArea chome area
	 * @param koazaArea koaza area
	 * @param multiPostArea multi post area
	 * @param post {@link Post}
	 * @param oldPost {@link OldPost}
	 */
	public Area(String areaKana, String areaName, City city, int chomeArea, int koazaArea,
			int multiPostArea, Post post, OldPost oldPost) {
		this.areaKana = areaKana;
		this.areaName = areaName;
		this.city = city;
		this.chomeArea = chomeArea;
		this.koazaArea = koazaArea;
		this.multiPostArea = multiPostArea;
		this.post = post;
		this.oldPost = oldPost;
	}
}
