package com.jp.api.web.postoffices;

import com.jp.api.models.areas.AreaService;
import com.jp.api.models.cities.CityService;
import com.jp.api.utils.RestData;
import javassist.NotFoundException;
import jp.xet.sparwings.spring.web.httpexceptions.HttpBadRequestException;
import jp.xet.sparwings.spring.web.httpexceptions.HttpNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Post Office Controller
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@SuppressWarnings("javadoc")
@RequestMapping(value = "/post_offices")
public class PostOfficeController {

	/**
	 * Area's service
	 */
	private final AreaService areaService;

	/**
	 * City's service
	 */
	private final CityService cityService;

	
	/**
	 * Search address by post code
	 * @param postCode post code
	 * @return List of {@link AddressResponse} found
	 * 
	 */
	@RequestMapping(value = "/posts/{postCode}", method = RequestMethod.GET)
	public ResponseEntity searchByPostCode(@PathVariable("postCode") String postCode) {
		try {
		List<AddressResponse> addressList = areaService.findByPostCode(postCode);
		RestData resource = new RestData<>(addressList);
		return ResponseEntity.ok(resource);
		} catch (IllegalArgumentException e) {
			throw new HttpBadRequestException(e.getMessage(), e);
		} catch (NotFoundException e) {
			throw new HttpNotFoundException(e.getMessage(), e);
		}
		
	}

	/**
	 * Search cities by prefecture code
	 * @param prefectureCode prefecture code
	 * @return List of {@link CitiesListResponse} found.
	 */
	@RequestMapping(value = "/prefectures/{prefectureCode}", method = RequestMethod.GET)
	public ResponseEntity searchByPrefectureCode(
			@PathVariable("prefectureCode") String prefectureCode) {
		try {
			log.debug(prefectureCode);
			List<CitiesListResponse> cities = cityService.findByPrefectureCode(prefectureCode);
			log.debug(String.valueOf(cities));
		RestData resource = new RestData<>(cities);
		return ResponseEntity.ok(resource);
	} catch (IllegalArgumentException e) {
		throw new HttpBadRequestException(e.getMessage(), e);
	} catch (NotFoundException e) {
		throw new HttpNotFoundException(e.getMessage(), e);
	}
	}
	
}
