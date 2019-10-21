package com.jp.api.models.cities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test fo {@link City}.
 *
 */
class CityTest {
	
	JacksonTester<City> json;
	
	private ObjectMapper mapper;
	
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	
	@BeforeEach
	void setUp() {
		mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		JacksonTester.initFields(this, mapper);
		assert json != null; // required for FindBugs NP_UNWRITTEN_FIELD
	}
	
	@Test
	public void testOK() {
		// setup
		City sut = CityFixtures.createCity();
		// exercise
		Set<ConstraintViolation<City>> actual = validator.validate(sut);
		// verify
		assertThat(actual).hasSize(0);
	}
	
	@Test
	public void testNotNullConstraints() {
		// setup
		City sut = new City();
		// exercise
		Set<ConstraintViolation<City>> actual = validator.validate(sut);
		// verify
		assertThat(actual).hasSize(4);
	}

	@Test
	public void testValueToJson() throws Exception {
		// setup
		City tblCity = CityFixtures.createCity();
		// exercise
		JsonContent<City> actual = json.write(tblCity);
		// verify
		assertThat(actual).extractingJsonPathStringValue("@.code").isEqualTo("01102");
		assertThat(actual).extractingJsonPathStringValue("@.city_kana").isEqualTo("city_kana413134");
		assertThat(actual).extractingJsonPathStringValue("@.city").isEqualTo("city413134");
		assertThat(actual).extractingJsonPathStringValue("@.prefecture.prefecture_kana").isEqualTo("ﾎｯｶｲﾄﾞｳ");
		assertThat(actual).extractingJsonPathStringValue("@.prefecture.prefecture").isEqualTo("北海道");
		assertThat(actual).extractingJsonPathStringValue("@.prefecture.prefecture_code").isEqualTo("01");
	}

	@Test
	public void testValueToTree() {
		// setup
		City tblCity = CityFixtures.createCity();
		// exercise: Value to Tree
		JsonNode actualNode = mapper.valueToTree(tblCity);
		assertThat(actualNode.path("code").isTextual()).isTrue();
		assertThat(actualNode.path("code").textValue()).isEqualTo("01102");
		assertThat(actualNode.path("city_kana").isTextual()).isTrue();
		assertThat(actualNode.path("city_kana").textValue()).isEqualTo("city_kana413134");
		assertThat(actualNode.path("city").isTextual()).isTrue();
		assertThat(actualNode.path("city").textValue()).isEqualTo("city413134");
		assertThat(actualNode.path("prefecture").path("prefecture_kana").isTextual()).isTrue();
		assertThat(actualNode.path("prefecture").path("prefecture_kana").textValue()).isEqualTo("ﾎｯｶｲﾄﾞｳ");
		assertThat(actualNode.path("prefecture").path("prefecture").isTextual()).isTrue();
		assertThat(actualNode.path("prefecture").path("prefecture").textValue()).isEqualTo("北海道");
		assertThat(actualNode.path("prefecture").path("prefecture_code").isTextual()).isTrue();
		assertThat(actualNode.path("prefecture").path("prefecture_code").textValue()).isEqualTo("01");
	}
}
