CREATE TABLE `tbl_old_post`  (
  `old_post_id` int(11) NOT NULL AUTO_INCREMENT,
  `old_post_code` varchar(5)  NOT NULL,
  PRIMARY KEY (`old_post_id`) USING BTREE,
  UNIQUE INDEX `old_post_code`(`old_post_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
