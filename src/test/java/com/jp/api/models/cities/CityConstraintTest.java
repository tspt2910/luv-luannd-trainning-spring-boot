package com.jp.api.models.cities;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link City}
 *
 */
@Slf4j
public class CityConstraintTest {
	
	final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	
	/**
	 * Test not null constraint.
	 *
	 */
	@Test
	public void testNotNullConstraints() {
		// setup
		City sut = new City();
		// exercise
		Set<ConstraintViolation<City>> actual = validator.validate(sut);
		// verify
		Set<String> errorExpression = actual.stream()
			.map(violation -> violation.getPropertyPath().toString() + " " + violation.getMessage())
			.collect(Collectors.toSet());
		assertThat(errorExpression).containsExactlyInAnyOrder(
				"cityCode must not be null",
				"cityKana must not be null",
				"cityName must not be null",
				"prefecture must not be null");
		assertThat(actual).hasSize(4);
	}
	
}
