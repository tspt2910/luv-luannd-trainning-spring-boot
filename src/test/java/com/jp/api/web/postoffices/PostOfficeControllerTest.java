package com.jp.api.web.postoffices;

import com.jp.api.models.areas.Area;
import com.jp.api.models.areas.AreaFixtures;
import com.jp.api.models.areas.AreaService;
import com.jp.api.models.cities.City;
import com.jp.api.models.cities.CityFixtures;
import com.jp.api.models.cities.CityService;
import jp.xet.sparwings.spring.web.httpexceptions.HttpNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test for {@link PostOfficeController}.
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PostOfficeController.class)
class PostOfficeControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private AreaService areaService;
	
	@MockBean
	private CityService cityService;
	
	
	@Test
	void testSearchByPrefectureCode() throws Exception {
		// setup
		City city = CityFixtures.createCity();
		CitiesListResponse cityCitiesListResponse = new CitiesListResponse(city);
		List<CitiesListResponse> cityCitiesListResponseList = new ArrayList<>();
		cityCitiesListResponseList.add(cityCitiesListResponse);
		
		when(cityService.findByPrefectureCode(anyString())).thenReturn(cityCitiesListResponseList);
		
		// exercise
		mvc.perform(get("/post_offices/prefectures/{prefecturesCode}",
				city.getPrefecture().getPrefectureCode()).contentType(MediaType.APPLICATION_JSON))
			// verify
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.data[0].code", is(city.getCityCode())))
			.andExpect(jsonPath("$.data[0].city", is(city.getCityName())))
			.andExpect(jsonPath("$.data[0].city_kana", is(city.getCityKana())))
			.andExpect(jsonPath("$.data[0].prefecture_code", is(city.getPrefecture().getPrefectureCode())));
	}
	
	/**
	 * Test GET "/post_offices/prefectures/{prefecturesCode}".
	 *
	 * @throws IllegalArgumentException exceptions
	 */
	@Test
	public void testSearchByPrefectureCodeThrowIAE() throws Exception {
		// setup
		City city = CityFixtures.createCity();
		doThrow(IllegalArgumentException.class).when(cityService).findByPrefectureCode(anyString());
		
		// exercise
		mvc.perform(get("/post_offices/prefectures/{prefectures_code}",
				city.getPrefecture().getPrefectureCode()).contentType(MediaType.APPLICATION_JSON))
			// verify
			.andExpect(status().isBadRequest());
	}
	
	/**
	 * Test GET "/post_offices/prefectures/{prefecturesCode}"
	 *
	 * @throws HttpNotFoundException exceptions
	 */
	@Test
	public void searchByPrefectureCodeThrowNFE() throws Exception {
		// setup
		City city = CityFixtures.createCity();
		doThrow(HttpNotFoundException.class).when(cityService).findByPrefectureCode(anyString());
		
		// exercise
		mvc.perform(get("/post_offices/prefectures/{prefectures_code}",
				city.getPrefecture().getPrefectureCode()).contentType(MediaType.APPLICATION_JSON))
			// verify
			.andExpect(status().isNotFound());
	}
	
	/**
	 * Test GET "post_offices/posts/{postCode}"
	 *
	 */
	@Test
	public void testSearchAddressByPostCode() throws Exception {
		// setup
		Area tblArea = AreaFixtures.createArea();
		AddressResponse response = new AddressResponse(tblArea);
		List<AddressResponse> responseList = new ArrayList<>();
		responseList.add(response);
		
		when(areaService.findByPostCode(anyString())).thenReturn(responseList);
		
		// exercise
		mvc.perform(get("/post_offices/posts/{postCode}",
				tblArea.getPost().getPostCode())
					.contentType(MediaType.APPLICATION_JSON))
			// verify
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.data[0].area", is(tblArea.getAreaName())))
			.andExpect(jsonPath("$.data[0].area_kana", is(tblArea.getAreaKana())))
			.andExpect(jsonPath("$.data[0].city", is(tblArea.getCity().getCityName())))
			.andExpect(jsonPath("$.data[0].city_kana", is(tblArea.getCity().getCityKana())));
	}
	
	/**
	 * Test GET "post_offices/posts/{postCode}"
	 *
	 * @throws IllegalArgumentException exceptions
	 */
	@Test
	public void testSearchAddressByPostCodeThrowIAE() throws Exception {
		// setup
		Area tblArea = AreaFixtures.createArea();
		doThrow(IllegalArgumentException.class).when(areaService).findByPostCode(anyString());
		
		// exercise
		mvc.perform(get("/post_offices/posts/{postCode}",
				tblArea.getPost().getPostCode())
					.contentType(MediaType.APPLICATION_JSON))
			// verify
			.andExpect(status().isBadRequest());
	}
	
	/**
	 * Test GET "post_offices/posts/{postCode}"
	 *
	 * @throws HttpNotFoundException exceptions
	 */
	@Test
	public void testSearchAddressByPostCodeThrowNFE() throws Exception {
		// setup
		Area tblArea = AreaFixtures.createArea();
		doThrow(HttpNotFoundException.class).when(areaService).findByPostCode(anyString());
		
		// exercise
		mvc.perform(get("/posts_offices/posts/{postCode}",
				tblArea.getPost().getPostCode())
					.contentType(MediaType.APPLICATION_JSON))
			// verify
			.andExpect(status().isNotFound());
	}
}
