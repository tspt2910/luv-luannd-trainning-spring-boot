package com.jp.api.models.cities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for {@link City}s.
 */
public interface CityRepository extends JpaRepository<City, Integer> {
	
	/**
	 * Get list cities by prefecture Code
	 *
	 * @param prefectureCode prefecture Code
	 * @return list of {@link City}
	 */
	List<City> findByPrefecturePrefectureCode(String prefectureCode);
}
