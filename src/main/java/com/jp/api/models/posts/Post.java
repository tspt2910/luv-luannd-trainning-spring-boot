package com.jp.api.models.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Post model.
 *
 */
@Entity
@NoArgsConstructor
@Table(name = "tbl_post")
@Data
public class Post {
	
	/**
	 * Post ID
	 */
	@Id
	@Column(name = "post_id")
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	/**
	 * Post code
	 */
	@Column(name = "post_code", unique = true)
	@JsonProperty("post_code")
	@NotNull
	@Length(max = 7)
	private String postCode;
	
	/**
	 * Update show
	 */
	@Column(name = "update_show")
	@JsonProperty("update_show")
	private int updateShow;
	
	/**
	 * Change reason
	 */
	@Column(name = "change_reason")
	@JsonProperty("change_reason")
	private int changeReason;
	
	/**
	 * Multi area
	 */
	@Column(name = "multi_area")
	@JsonProperty("multi_area")
	private int multiArea;
	
	
	/**
	 * Create instance
	 *
	 * @param postCode post code
	 * @param updateShow update show
	 * @param changeReason change reason
	 * @param multiArea multi area
	 */
	public Post(String postCode, int updateShow, int changeReason, int multiArea) {
		this.postCode = postCode;
		this.updateShow = updateShow;
		this.changeReason = changeReason;
		this.multiArea = multiArea;
	}
}
