SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS board_img;
DROP TABLE IF EXISTS board_recomm;
DROP TABLE IF EXISTS board_reply;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS schedule_detail;
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS member;




/* Create Tables */

CREATE TABLE board
(
	bno int unsigned NOT NULL AUTO_INCREMENT,
	sno int unsigned NOT NULL,
	mno int unsigned NOT NULL,
	btitle varchar(100) NOT NULL,
	bcontent text,
	bhit int unsigned,
	brecommcount int unsigned NOT NULL,
	brdate datetime NOT NULL,
	bdelyn char(2) NOT NULL,
	PRIMARY KEY (bno)
);


CREATE TABLE board_img
(
	bino int unsigned NOT NULL AUTO_INCREMENT,
	bno int unsigned NOT NULL,
	mno int unsigned NOT NULL,
	PRIMARY KEY (bino)
);


CREATE TABLE board_recomm
(
	bno int unsigned NOT NULL,
	mno int unsigned NOT NULL
);


CREATE TABLE board_reply
(
	brno int unsigned NOT NULL AUTO_INCREMENT,
	bno int unsigned NOT NULL,
	mno int unsigned NOT NULL,
	brcontent text NOT NULL,
	brrdate datetime NOT NULL,
	brdelyn char(2) NOT NULL,
	PRIMARY KEY (brno)
);


CREATE TABLE member
(
	mno int unsigned NOT NULL AUTO_INCREMENT,
	mid varchar(20) NOT NULL,
	mpw varchar(50) NOT NULL,
	mphone char(13) NOT NULL,
	memail varchar(50) NOT NULL,
	mnick varchar(16) NOT NULL,
	mrdate datetime NOT NULL,
	mgrade char(2) NOT NULL,
	mpimg_realnm varchar(100),
	PRIMARY KEY (mno),
	UNIQUE (mid),
	UNIQUE (mnick)
);


CREATE TABLE schedule
(
	sno int unsigned NOT NULL AUTO_INCREMENT,
	stitle varchar(50) NOT NULL,
	srdate datetime NOT NULL,
	sdelyn char(2),
	mno int unsigned NOT NULL,
	PRIMARY KEY (sno)
);


CREATE TABLE schedule_detail
(
	sdno int NOT NULL AUTO_INCREMENT,
	sno int unsigned NOT NULL,
	mno int unsigned NOT NULL,
	sddate int unsigned NOT NULL,
	PRIMARY KEY (sdno),
	UNIQUE (sdno)
);



/* Create Foreign Keys */

ALTER TABLE board_img
	ADD FOREIGN KEY (bno)
	REFERENCES board (bno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board_recomm
	ADD FOREIGN KEY (bno)
	REFERENCES board (bno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board_reply
	ADD FOREIGN KEY (bno)
	REFERENCES board (bno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (mno)
	REFERENCES member (mno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board_img
	ADD FOREIGN KEY (mno)
	REFERENCES member (mno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board_recomm
	ADD FOREIGN KEY (mno)
	REFERENCES member (mno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board_reply
	ADD FOREIGN KEY (mno)
	REFERENCES member (mno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE schedule
	ADD FOREIGN KEY (mno)
	REFERENCES member (mno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE schedule_detail
	ADD FOREIGN KEY (mno)
	REFERENCES member (mno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (sno)
	REFERENCES schedule (sno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE schedule_detail
	ADD FOREIGN KEY (sno)
	REFERENCES schedule (sno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



