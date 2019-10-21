package com.jp.api.models.areas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link AreaRepository}.
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class AreaRepositoryTest {

	@Autowired
	AreaRepository sut;
	
	
	/**
	 * Test find by post code.
	 *
	 */
	@Test
	public void findByPostPostCode() {
		// setup
		Area area = AreaFixtures.createArea();
		// exercise
		List<Area> actual = sut.findByPostPostCode(area.getPost().getPostCode());
		// verify
		assertThat(actual.size()).isEqualTo(1);
		Area areaActual = actual.get(0);
		assertThat(areaActual.getPost().getPostCode()).isEqualTo(area.getPost().getPostCode());
	}
}
