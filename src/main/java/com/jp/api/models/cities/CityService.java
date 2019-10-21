package com.jp.api.models.cities;

import com.amazonaws.util.CollectionUtils;
import com.jp.api.utils.ErrorTranslator;
import com.jp.api.utils.Preconditions;
import com.jp.api.web.postoffices.CitiesListResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for {@link City}
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CityService {
	
	/**
	 * {@link CityRepository}
	 */
	private final CityRepository cityRepo;
	
	/**
	 * {@link ErrorTranslator}
	 */
	private final ErrorTranslator exp;
	
	
	/**
	 * @param prefectureCode Prefecture Code
	 * @return List of {@link City} found.
	 */
	public List<CitiesListResponse> findByPrefectureCode(String prefectureCode) throws NotFoundException {
		Preconditions.checkNotNull(prefectureCode, exp.translate("controller.city.get.not_null", prefectureCode));
		Preconditions.checkHalfSize(prefectureCode,
				exp.translate("controller.city.get.halfsize_number", prefectureCode));
		
		List<CitiesListResponse> cityList = cityRepo.findByPrefecturePrefectureCode(prefectureCode).stream()
			.map(CitiesListResponse::new).collect(Collectors.toList());
		if (CollectionUtils.isNullOrEmpty(cityList)) {
			throw new NotFoundException(exp.translate("controller.city.get.pref_code_not_found", prefectureCode));
		}
		return cityList;
	}
	
}
