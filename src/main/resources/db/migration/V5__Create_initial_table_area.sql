CREATE TABLE `tbl_area`  (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_kana` longtext  NOT NULL,
  `area` longtext  NOT NULL,
  `city_id` int(11) NOT NULL,
  `chome_area` int(11) NOT NULL DEFAULT 0,
  `koaza_area` int(11) NOT NULL DEFAULT 0,
  `multi_post_area` int(11) NOT NULL DEFAULT 0,
  `post_id` int(11) NOT NULL,
  `old_post_id` int(11) NOT NULL,
  PRIMARY KEY (`area_id`) USING BTREE,
  INDEX `city_id`(`city_id`) USING BTREE,
  INDEX `post_id`(`post_id`) USING BTREE,
  INDEX `old_post_id`(`old_post_id`) USING BTREE,
  CONSTRAINT `tbl_area_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `tbl_city` (`city_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbl_area_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`post_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbl_area_ibfk_3` FOREIGN KEY (`old_post_id`) REFERENCES `tbl_old_post` (`old_post_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
