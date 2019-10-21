package com.jp.api.models.areas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for {@link Area}s.
 */
public interface AreaRepository extends JpaRepository<Area, Integer> {
	
	/**
	 * Get list Area by post code
	 *
	 * @param postCode post code
	 * @return List of {@link Area}
	 */
	List<Area> findByPostPostCode(String postCode);
	
}
