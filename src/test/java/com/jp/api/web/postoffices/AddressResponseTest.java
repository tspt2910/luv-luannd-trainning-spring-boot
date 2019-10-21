package com.jp.api.web.postoffices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.api.models.areas.Area;
import com.jp.api.models.areas.AreaFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Assertions.assertThat;

class AddressResponseTest {
	JacksonTester<AddressResponse> json;

	private ObjectMapper mapper;

	@BeforeEach
	public void setUp() {
		mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		JacksonTester.initFields(this, mapper);
		assert json != null; // required for FindBugs NP_UNWRITTEN_FIELD
	}

	@Test
	public void testValueToJson() throws Exception {
		// setup
		Area tblArea = AreaFixtures.createArea();
		AddressResponse sut = AddressResponseFixtures.createResponse(tblArea);
		// exercise
		JsonContent<AddressResponse> actual = json.write(sut);
		// verify
		assertThat(actual).extractingJsonPathStringValue("@.code").isEqualTo(sut.getCityCode());
		assertThat(actual).extractingJsonPathStringValue("@.city").isEqualTo(sut.getCityName());
		assertThat(actual).extractingJsonPathStringValue("@.city_kana").isEqualTo(sut.getCityKana());
		assertThat(actual).extractingJsonPathStringValue("@.prefecture").isEqualTo(sut.getPrefectureName());
		assertThat(actual).extractingJsonPathStringValue("@.prefecture_kana").isEqualTo(sut.getPrefectureKana());
		assertThat(actual).extractingJsonPathStringValue("@.prefecture_code").isEqualTo(sut.getPrefectureCode());
		assertThat(actual).extractingJsonPathStringValue("@.area").isEqualTo(sut.getAreaName());
		assertThat(actual).extractingJsonPathStringValue("@.area_kana").isEqualTo(sut.getAreaKana());
		assertThat(actual).extractingJsonPathNumberValue("@.multi_post_area").isEqualTo(sut.getMultiPostArea());
		assertThat(actual).extractingJsonPathNumberValue("@.koaza_area").isEqualTo(sut.getKoazaArea());
		assertThat(actual).extractingJsonPathNumberValue("@.chome_area").isEqualTo(sut.getChomeArea());
		assertThat(actual).extractingJsonPathStringValue("@.old_post_code").isEqualTo(sut.getOldPostCode());
		assertThat(actual).extractingJsonPathStringValue("@.post_code").isEqualTo(sut.getPostCode());
		assertThat(actual).extractingJsonPathNumberValue("@.multi_area").isEqualTo(sut.getMultiArea());
		assertThat(actual).extractingJsonPathNumberValue("@.update_show").isEqualTo(sut.getUpdateShow());
		assertThat(actual).extractingJsonPathNumberValue("@.change_reason").isEqualTo(sut.getChangeReason());
	}


	@Test
	public void testJsonToTreeToValue() throws Exception {
		// setup
		String areaJson = createAreaJson();

		// exercise
		JsonNode actualNode = mapper.readTree(areaJson);
		// verify
		assertThat(actualNode.path("code").isTextual()).isTrue();
		assertThat(actualNode.path("code").textValue()).isEqualTo("01102");
		assertThat(actualNode.path("city").isTextual()).isTrue();
		assertThat(actualNode.path("city").textValue()).isEqualTo("city413134");
		assertThat(actualNode.path("city_kana").isTextual()).isTrue();
		assertThat(actualNode.path("city_kana").textValue()).isEqualTo("city_kana413134");
		assertThat(actualNode.path("prefecture").isTextual()).isTrue();
		assertThat(actualNode.path("prefecture").textValue()).isEqualTo("北海道");
		assertThat(actualNode.path("prefecture_kana").isTextual()).isTrue();
		assertThat(actualNode.path("prefecture_kana").textValue()).isEqualTo("ﾎｯｶｲﾄﾞｳ");
		assertThat(actualNode.path("prefecture_code").isTextual()).isTrue();
		assertThat(actualNode.path("prefecture_code").textValue()).isEqualTo("01");
		assertThat(actualNode.path("area").isTextual()).isTrue();
		assertThat(actualNode.path("area").textValue()).isEqualTo("北三十四条西");
		assertThat(actualNode.path("area_kana").isTextual()).isTrue();
		assertThat(actualNode.path("area_kana").textValue()).isEqualTo("ｷﾀ34ｼﾞｮｳﾆｼ");
	}

	private String createAreaJson() {
		return ""
				+ "{"
				+ "  'code':'01102',"
				+ "  'city':'city413134',"
				+ "  'city_kana':'city_kana413134',"
				+ "  'prefecture':'北海道',"
				+ "  'prefecture_kana':'ﾎｯｶｲﾄﾞｳ',"
				+ "  'prefecture_code':'01',"
				+ "  'area':'北三十四条西',"
				+ "  'area_kana':'ｷﾀ34ｼﾞｮｳﾆｼ',"
				+ "  'multi_post_area':0,"
				+ "  'koaza_area':0,"
				+ "  'chome_area':1,"
				+ "  'old_post_code':'001',"
				+ "  'post_code':'0010034',"
				+ "  'multi_area':0,"
				+ "  'update_show':0,"
				+ "  'change_reason':0"
				+ "}";
	}

}