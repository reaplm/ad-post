INSERT INTO user_type (pk_user_type_id, user_type_name, user_type_desc)
	values(1, 'free user', 'free user'),(2, 'premium user', 'paying user');
--INITIALIZE MENUS
INSERT INTO menu(pk_menu_id, menu_name, menu_desc, menu_type, icon, menu_status)
	values(1,'Vehicles','cars/trucks for sale','CATEGORY','ic_airport_shuttle_black_48dp.png', 'ACTIVE'),
	(2,'Property','property for sale/wanted','CATEGORY','ic_business_black_48dp.png', 'ACTIVE'),
	(3,'Accomodation','travel,hotels','CATEGORY','ic_hotel_black_48dp.png', 'ACTIVE'),
	(4,'Home',null,'ADMIN',null, 'ACTIVE'),
	(5,'My Account',null,'ADMIN',null, 'ACTIVE'),
	(6,'Site Preferences',null,'ADMIN',null, 'ACTIVE'),
	(7,'Manage',null,'ADMIN',null, 'ACTIVE'),
	(8,'Site Activity',null,'ADMIN',null, 'ACTIVE'),
	(9,'Reports',null,'ADMIN',null, 'ACTIVE');
INSERT INTO sub_menu(pk_sub_menu_id, sub_menu_name, fk_menu_id, menu_status, url)
	values(null, 'Dashboard', 4, 'ACTIVE', '/AdPost/dashboard'),
		(null, 'Personal Information', 5, 'ACTIVE',null),
		(null, 'Messages', 5,null,null),
		(null, 'Communication Preferences', 5, null,null),
		(null, 'Alerts', 5, 'ACTIVE',null),
		(null, 'Feedback', 5, null,null),
		(null, 'Users', 7, 'ACTIVE', '/AdPost/admin/users'),
		(null, 'Posts', 7, 'ACTIVE',null),
		(null, 'Menus', 7, 'ACTIVE','/AdPost/menus'),
		(null, 'Permissions', 7, 'ACTIVE','/AdPost/permissions'),
		(null, 'My Posts', 8, null,null),
		(null, 'Favourites', 8, null,null),
		(null, 'Buses', 1, null, null);
--INITIALIZE ADMIN USER AND ROLES
INSERT INTO app_user (pk_user_id, email, password, password_used,
	user_status, user_created_date)
	values(null,'admin@email', 'administrator', 1,1,(select sysdate() from dual));
INSERT INTO AppUser_roles
	values(1, 'ROLE_USER'),(1, 'ROLE_ADMIN');
INSERT INTO user_detail (pfk_user_id, first_name)
	values(null,'administrator');
