CREATE TABLE `tbl_city`  (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100)  NOT NULL,
  `city_kana` varchar(100)  NOT NULL,
  `city` varchar(100)  NOT NULL,
  `prefecture_id` int(11) NOT NULL,
  PRIMARY KEY (`city_id`) USING BTREE,
  UNIQUE INDEX `city`(`city_kana`, `city`, `prefecture_id`) USING BTREE,
  UNIQUE INDEX `city_code`(`code`) USING BTREE,
  INDEX `prefecture_id`(`prefecture_id`) USING BTREE,
  CONSTRAINT `tbl_city_ibfk_1` FOREIGN KEY (`prefecture_id`) REFERENCES `tbl_prefecture` (`prefecture_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
