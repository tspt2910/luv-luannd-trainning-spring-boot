CREATE TABLE `tbl_prefecture`  (
  `prefecture_id` int(11) NOT NULL AUTO_INCREMENT,
  `prefecture_kana` varchar(100)  NOT NULL,
  `prefecture` varchar(100)  NOT NULL,
  `prefecture_code` varchar(2)  NOT NULL,
  PRIMARY KEY (`prefecture_id`) USING BTREE,
  UNIQUE INDEX `prefecture_code`(`prefecture_code`) USING BTREE,
  UNIQUE INDEX `prefecture`(`prefecture_kana`, `prefecture`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
