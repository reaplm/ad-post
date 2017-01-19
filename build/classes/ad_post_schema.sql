

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

-- 
-- Database: trading_post
-- 
CREATE DATABASE IF NOT EXISTS ad_post DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE ad_post;

-- -------------------------------------------------------------
-- 
-- Table structure for table user_type
-- 
DROP TABLE IF EXISTS user_type;
CREATE TABLE IF NOT EXISTS user_type (
  pk_user_type_id int(11) NOT NULL,
  user_type_name varchar(255) DEFAULT NULL,
  user_type_desc varchar(255) DEFAULT NULL,
  PRIMARY KEY PK_pk_user_type_id (pk_user_type_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert user_type
-- 

TRUNCATE TABLE user_type;
INSERT INTO user_type (pk_user_type_id, user_type_name, user_type_desc)
values(1, 'free user', 'free user'),(2, 'premium user', 'paying user');
-- -------------------------------------------------------------
-- 
-- Table structure for table advert_type
-- 
DROP TABLE IF EXISTS advert_type;
CREATE TABLE IF NOT EXISTS advert_type (
  pk_ad_type_id int(11) NOT NULL,
  ad_type_name varchar(255) DEFAULT NULL,
  ad_type_desc varchar(255) DEFAULT NULL,
  PRIMARY KEY PK_pk_ad_type_id (pk_ad_type_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert advert_type
-- 

TRUNCATE TABLE advert_type;

-- -------------------------------------------------------------
-- 
-- Table structure for table category
-- 
DROP TABLE IF EXISTS category;
CREATE TABLE IF NOT EXISTS category (
  pk_cat_id int(11) NOT NULL,
  cat_name VARCHAR(255) NOT NULL,
  cat_desc VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY PK_pk_cat_id (pk_cat_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert into category
-- 
TRUNCATE TABLE category;
INSERT INTO category(pk_cat_id, cat_name)
values(1,'automotive'),(2,'appliances and electrical');

-- 
-- Constraints for table category
-- 
-- -------------------------------------------------------------
-- 
-- Table structure for table sub_category
-- 
DROP TABLE IF EXISTS sub_category;
CREATE TABLE IF NOT EXISTS sub_category (
  pk_sub_cat_id int(11) NOT NULL,
  fk_cat_id int(11) NOT NULL,
  sub_cat_name VARCHAR(255) NOT NULL,
  sub_cat_desc VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY PK_pk_sub_cat_id (pk_sub_cat_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert into sub_category
-- 
TRUNCATE TABLE sub_category;
-- 
-- Constraints for table sub_category
-- 
ALTER TABLE sub_category
  ADD CONSTRAINT FK_sub_category_fk_cat_id FOREIGN KEY (fk_cat_id) REFERENCES category (pk_cat_id);

-- -------------------------------------------------------------
-- 
-- Table structure for table app_user
-- 
DROP TABLE IF EXISTS app_user;
CREATE TABLE IF NOT EXISTS app_user (
  pk_user_id int(11) NOT NULL,
  password VARCHAR(255) NOT NULL,
  password_used int(1) NOT NULL,
  user_status int(1) NOT NULL,
  fk_user_type_id int(11) NOT NULL,
  user_created_date datetime NOT NULL,
  password_expiry_date datetime DEFAULT NULL,
  last_login_date datetime DEFAULT NULL,
  PRIMARY KEY PK_pk_user_id (pk_user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert into app_user
-- 
TRUNCATE TABLE app_user;
INSERT INTO app_user (pk_user_id, password, password_used,
	user_status, user_created_date)
values(1,'administrator', 1,1,(select sysdate() from dual));
-- 
-- Constraints for table app_user
-- 

ALTER TABLE app_user
	ADD CONSTRAINT FK_app_user_fk_user_type_id FOREIGN KEY (fk_user_type_id) REFERENCES user_type (pk_user_type_id);
-- --------------------------------------------------------

-- 
-- Table structure for table AppUser_roles
-- 

DROP TABLE IF EXISTS AppUser_roles;
CREATE TABLE IF NOT EXISTS AppUser_roles (
  appuser_pk_user_id int(11) NOT NULL,
  role_name varchar(255) DEFAULT NULL,
  KEY PK_appuser_pk_user_id (appuser_pk_user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert AppUser_roles
-- 

TRUNCATE TABLE AppUser_roles;
INSERT INTO AppUser_roles
values
(1, 'CUST'),
(1, 'EMP'),
(1, 'ADMIN');

-- 
-- Constraints for table AppUser_roles
-- 

ALTER TABLE AppUser_roles
  ADD CONSTRAINT FK_AppUser_roles_AppUser_pk_user_id FOREIGN KEY (AppUser_pk_user_id) REFERENCES app_user (pk_user_id);

-- -------------------------------------------------------------
-- 
-- Table structure for table advert
-- 
DROP TABLE IF EXISTS advert;
CREATE TABLE IF NOT EXISTS advert (
  pk_advert_id int(11) NOT NULL,
  fk_user_id int(11) NOT NULL,
  fk_ad_type_id int(11) NOT NULL,
  fk_sub_cat_id int(11) NOT NULL,
  advert_status int(2) NOT NULL,
  ad_published_flag int(1) DEFAULT NULL,
  ad_approved_flag int(1) DEFAULT NULL,
  ad_submitted_flag int(1) DEFAULT NULL,
  ad_rejected_flag int(1) DEFAULT NULL,
  ad_published_date datetime DEFAULT NULL,
  ad_approved_date datetime DEFAULT NULL,
  ad_submitted_date datetime DEFAULT NULL,
  ad_rejected_date datetime DEFAULT NULL,
  PRIMARY KEY PK_pk_advert_id (pk_advert_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert into advert
-- 
TRUNCATE TABLE advert;
-- 
-- Constraints for table advert
-- 
ALTER TABLE advert
  ADD CONSTRAINT FK_advert_fk_user_id FOREIGN KEY (fk_user_id) REFERENCES app_user (pk_user_id);
ALTER TABLE advert
  ADD CONSTRAINT FK_advert_fk_ad_type_id FOREIGN KEY (fk_ad_type_id) REFERENCES advert_type (pk_ad_type_id);
ALTER TABLE advert
  ADD CONSTRAINT FK_advert_fk_sub_cat_id FOREIGN KEY (fk_sub_cat_id) REFERENCES sub_category (pk_sub_cat_id);
-- -------------------------------------------------------------
-- 
-- Table structure for table advert_detail
-- 
DROP TABLE IF EXISTS advert_detail;
CREATE TABLE IF NOT EXISTS advert_detail (
  pfk_advert_id int(11) NOT NULL,
  fk_user_id int(11) NOT NULL,
  advert_subject VARCHAR(255) NOT NULL,
  advert_body VARCHAR(255) NOT NULL,
  advert_location VARCHAR(255) DEFAULT NULL,
  contact_no VARCHAR(255) NOT NULL,
  contact_email VARCHAR(255) NOT NULL,
  PRIMARY KEY PK_pfk_advert_id (pfk_advert_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert into advert_detail
-- 
TRUNCATE TABLE advert_detail;
-- 
-- Constraints for table advert_detail
-- 
ALTER TABLE advert_detail
  ADD CONSTRAINT FK_advert_detail_pfk_advert_id FOREIGN KEY (pfk_advert_id) REFERENCES advert (pk_advert_id);
ALTER TABLE advert_detail
  ADD CONSTRAINT FK_advert_detail_fk_user_id FOREIGN KEY (fk_user_id) REFERENCES app_user (pk_user_id);

-- -------------------------------------------------------------
-- 
-- Table structure for table advert_like
-- 
DROP TABLE IF EXISTS advert_like;
CREATE TABLE IF NOT EXISTS advert_like (
  pk_ad_like_id int(11) NOT NULL,
  fk_advert_id int(11) NOT NULL,
  fk_user_id int(11) NOT NULL,
  PRIMARY KEY PK_pk_ad_like_id (pk_ad_like_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert into advert_like
-- 
TRUNCATE TABLE advert_like;
-- 
-- Constraints for table advert_like
-- 
ALTER TABLE advert_like
  ADD CONSTRAINT FK_advert_like_fk_user_id FOREIGN KEY (fk_user_id) REFERENCES app_user (pk_user_id);
ALTER TABLE advert_like
  ADD CONSTRAINT FK_advert_like_fk_advert_id FOREIGN KEY (fk_advert_id) REFERENCES advert (pk_advert_id);
  
-- -------------------------------------------------------------
-- 
-- Table structure for table advert_picture
-- 
DROP TABLE IF EXISTS advert_picture;
CREATE TABLE IF NOT EXISTS advert_picture (
  pk_ad_picture_id int(11) NOT NULL,
  fk_advert_id int(11) NOT NULL,
  image_url VARCHAR(255) NOT NULL,
  image_title VARCHAR(255) NOT NULL,
  image_name VARCHAR(255) NOT NULL,
  PRIMARY KEY PK_advert_picture (pk_ad_picture_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert into advert_picture
-- 
TRUNCATE TABLE advert_picture;
-- 
-- Constraints for table advert_picture
-- 
ALTER TABLE advert_picture
  ADD CONSTRAINT FK_advert_picture_fk_advert_id FOREIGN KEY (fk_advert_id) REFERENCES advert(pk_advert_id);

-- -------------------------------------------------------------
-- 
-- Table structure for table advert_share
-- 
DROP TABLE IF EXISTS advert_share;
CREATE TABLE IF NOT EXISTS advert_share (
  pk_ad_share_id int NOT NULL,
  fk_advert_id int(11) NOT NULL,
  fk_user_id int(11) NOT NULL,
  PRIMARY KEY PK_advert_share (pk_ad_share_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert advert_share
-- 
TRUNCATE TABLE advert_share;
-- 
-- Constraints for table advert_share
-- 
ALTER TABLE advert_share
  ADD CONSTRAINT FK_advert_share_fk_advert_id FOREIGN KEY (fk_advert_id) REFERENCES advert (pk_advert_id);
ALTER TABLE advert_share
  ADD CONSTRAINT FK_advert_share_fk_user_id FOREIGN KEY (fk_user_id) REFERENCES app_user (pk_user_id);
  
-- -------------------------------------------------------------
-- 
-- Table structure for table advert_comment
-- 
DROP TABLE IF EXISTS advert_comment;
CREATE TABLE IF NOT EXISTS advert_comment (
  pk_ad_comment_id int NOT NULL,
  fk_advert_id int(11) NOT NULL,
  fk_user_id int(11) NOT NULL,
  PRIMARY KEY PK_pk_ad_comment_id (pk_ad_comment_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert advert_comment
-- 
TRUNCATE TABLE advert_comment;
-- 
-- Constraints for table advert_comment
-- 
ALTER TABLE advert_comment
  ADD CONSTRAINT FK_advert_comment_fk_advert_id FOREIGN KEY (fk_advert_id) REFERENCES advert (pk_advert_id);
ALTER TABLE advert_comment
  ADD CONSTRAINT FK_advert_comment_fk_user_id FOREIGN KEY (fk_user_id) REFERENCES app_user (pk_user_id);

-- -------------------------------------------------------------
-- 
-- Table structure for table user_detail
-- 
DROP TABLE IF EXISTS user_detail;
CREATE TABLE IF NOT EXISTS user_detail (
  pfk_user_id int(11) NOT NULL,
  email varchar(255) NOT NULL,
  fax_no varchar(255) DEFAULT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  mobile_no varchar(255) DEFAULT NULL,
  office_no varchar(255) DEFAULT NULL,
  post_addr1 varchar(255) DEFAULT NULL,
  post_addr2 varchar(255) DEFAULT NULL,
  post_code varchar(255) DEFAULT NULL,
  state varchar(255) DEFAULT NULL,
  street varchar(255) DEFAULT NULL,
  surbub varchar(255) DEFAULT NULL,
  bus_name varchar(255) DEFAULT NULL,
  PRIMARY KEY PK_pfk_user_id (pfk_user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Truncate table before insert user_detail
-- 
TRUNCATE TABLE user_detail;
INSERT INTO user_detail (pfk_user_id, email, first_name)
values(1,'admin@email','administrator');

-- 
-- Constraints for table user_details
-- 
ALTER TABLE user_detail
	ADD CONSTRAINT FK_user_detail_pfk_user_id FOREIGN KEY (pfk_user_id) REFERENCES app_user (pk_user_id);
	
  COMMIT;
   SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
