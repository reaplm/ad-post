INSERT INTO user_type (pk_user_type_id, user_type_name, user_type_desc)
	values(1, 'free user', 'free user'),(2, 'premium user', 'paying user');
INSERT INTO menu(pk_menu_id, menu_name, menu_desc, menu_type, icon)
	values(1,'Vehicles','cars/trucks for sale',0,'ic_airport_shuttle_black_48dp.png'),
	(2,'Property','property for sale/wanted',0,'ic_business_black_48dp.png' ),
	(3,'Accomodation','travel,hotels',0,'ic_hotel_black_48dp.png' );
INSERT INTO app_user (pk_user_id, email, password, password_used,
	user_status, user_created_date)
	values(null,'admin@email', 'administrator', 1,1,(select sysdate() from dual));
INSERT INTO AppUser_roles
	values(1, 'ROLE_USER'),(1, 'ROLE_ADMIN');
INSERT INTO user_detail (pfk_user_id, first_name)
	values(null,'administrator');
