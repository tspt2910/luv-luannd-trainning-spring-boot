package com.jp.api.models.oldposts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jp.api.models.areas.Area;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * OldPost model
 *
 */
@Entity
@Table(name = "tbl_old_post")
@NoArgsConstructor
@Data
public class OldPost {

	/**
	 * Old post's ID
	 */
	@Id
	@Column(name = "old_post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long oldPostId;

	/**
	 * Old post's code
	 */
	@Column(name = "old_post_code", nullable = false)
	@JsonProperty("old_post_code")
	@NotNull
	@Length(max = 5)
	private String oldPostCode;

	/**
	 * Instance of Area
	 */
	@OneToMany(mappedBy = "oldPost")
	@JsonProperty("areas")
	private Collection<Area> areas;
	
	
	/**
	 * Create instance
	 *
	 * @param oldPostCode old post code
	 */
	public OldPost(String oldPostCode) {
		this.oldPostCode = oldPostCode;
	}
}
