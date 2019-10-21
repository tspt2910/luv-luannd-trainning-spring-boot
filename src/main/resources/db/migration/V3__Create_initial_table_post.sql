CREATE TABLE `tbl_post`  (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_code` varchar(7)  NOT NULL,
  `update_show` int(11) NOT NULL DEFAULT 0,
  `change_reason` int(11) NOT NULL DEFAULT 0,
  `multi_area` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`post_id`) USING BTREE,
  UNIQUE INDEX `post_code`(`post_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

