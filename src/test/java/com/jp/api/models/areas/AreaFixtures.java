package com.jp.api.models.areas;

import com.jp.api.models.cities.City;
import com.jp.api.models.oldposts.OldPost;
import com.jp.api.models.posts.Post;
import com.jp.api.models.prefectures.Prefecture;

/**
 * Fixtures for {@link Area}.
 *
 */
public class AreaFixtures {
	
	public static Area createArea() {
		
		return new Area("ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱ", "以下に掲載がない場合",
				new City("01102", "city_kana413134", "city413134",
						new Prefecture(2288,"ﾎｯｶｲﾄﾞｳ", "北海道", "01")),
				0, 0, 0,
				new Post("0010000", 0, 0, 0), new OldPost("001"));
	}
}
