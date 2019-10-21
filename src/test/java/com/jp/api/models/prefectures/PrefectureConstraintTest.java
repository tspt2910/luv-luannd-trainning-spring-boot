package com.jp.api.models.prefectures;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link Prefecture}
 *
 */
@Slf4j
public class PrefectureConstraintTest {
	
	final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	
	/**
	 * Test not null constraint.
	 *
	 */
	@Test
	public void testNotNullConstraints() {
		// setup
		Prefecture sut = new Prefecture();
		// exercise
		Set<ConstraintViolation<Prefecture>> actual = validator.validate(sut);
		// verify
		Set<String> errorExpression = actual.stream()
			.map(violation -> violation.getPropertyPath().toString() + " " + violation.getMessage())
			.collect(Collectors.toSet());
		assertThat(errorExpression).containsExactlyInAnyOrder(
				"prefectureCode must not be null",
				"prefectureName must not be null",
				"prefectureKana must not be null");
		assertThat(actual).hasSize(3);
	}
	
}
