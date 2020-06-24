                    use barber_database;

insert into `user` (`first_name`, `last_name`,`phone`,`login`, `password`, `role`) values
('Андрій', 'Мирний','11234567','admin@g.com', 'admin', 'ADMIN'),
('Макау', 'Вільям', '11234569','master1@g.com', 'master1', 'MASTER'),
('Ден', 'Джекі', '11234569','master2@g.com', 'master2', 'MASTER'),
('Лука', 'Лука', '11234569','master3@g.com', 'master3', 'MASTER'),
('Рона', 'Дана', '11234569','master4@g.com', 'master4', 'MASTER'),
('Володимир', 'Нестеренко', '11234560','user1@g.com', 'password', 'CUSTOMER'),
('Володимир','Чернявий', '11234571','user2@g.com', 'password', 'CUSTOMER'),
('Сергій', 'Чебрик', '11234572','user3@g.com', 'password', 'CUSTOMER'),
('Джастін', 'Дей', '11234573','user4@g.com', 'password', 'CUSTOMER');




insert into `feedback` (`date`, `feedback`, `userId`)
		values ('2019-08-30 19:30:00','Дуже задоволений сервiсом та якiстю стрижки! Буду рекомендувати знайомим та звертатися повторно!',5),
		 ('2019-08-27 13:30:00','Якісні стрижки хоч і дорого, але воно того коштує, рекомендую',4),
		 	 ('2019-08-27 13:30:00','Просто кашмар,приїхав в город, зайшов пастригтись, питають як стригти. Я кажу просто постригти, вони не понімають. Потім таку цену задвінули,шо кашмар. Лучче я не заходив би.',2),
		('2019-09-05 15:35:00','Дуже якісні стрижки і хороші майстри!',6);

insert into `service` (`service_name`, `price`)
values('Men’s Facial',15),
('Clean Cut',15),
('Close Shave',15),
('Razor Cut',15),
('Face Massage',15),
('Classic haircut',15),
('Haircut and shampoo',15),
('Hair treatment',15),
('Beard trimming',15),
('Beard and moustache',15);

insert into `master`(`userId`,`photo`)
values(2,'static/img/team/1.png'),
(3,'static/img/team/2.png'),
(4,'static/img/team/3.png'),
(5,'static/img/team/4.png');

 insert into `skills`(`masterId`, `serviceId`)
 values
(1,1),
(1,3),
(1,2),
(2,3),
(2,4),
(2,6),
(2,7),
(3,5),
(3,6),
(3,7),
(4,2),
(4,8),
(4,9),
(4,10);

insert into `schedule`(`userId`,`datetime`,`status`,`masterId`)
values(6,'2020-06-30 15:50:53','BOOKED',1),
(7,'2020-06-24 15:50:53','BOOKED',2),
(8,'2020-06-10 15:50:53','BOOKED',3);


