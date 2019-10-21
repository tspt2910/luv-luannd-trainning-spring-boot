package com.jp.api.models.cities;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Slf4j
class CityRepositoryTest {
	
	@Autowired
	CityRepository sut;


	/**
	 * Test find cities by prefecture code.
	 *
	 */
	@Test
	void findByPrefecturePrefectureCode() {
		// setup
		City city = CityFixtures.createCity();
		// exercise
		List<City> actual = sut.findByPrefecturePrefectureCode(city.getPrefecture().getPrefectureCode());
		// verify
		assertThat(actual.size()).isEqualTo(2);
		City cityActual = actual.get(0);
		log.debug(cityActual.getCityKana());
		log.debug(city.getCityKana());
		System.out.println(cityActual.getCityKana());
		System.out.println(city.getCityKana());
		assertThat(cityActual.getCityKana()).isEqualTo(city.getCityKana());
		assertThat(cityActual.getCityName()).isEqualTo(city.getCityName());
		assertThat(cityActual.getCityCode()).isEqualTo(city.getCityCode());
	}
}
