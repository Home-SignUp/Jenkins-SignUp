drop table if exists products;
create table products (
  id integer generated by default as identity(start with 1) primary key,
  sku integer NOT NULL,
  name varchar(100) NOT NULL,
  price double NOT NULL,
  mrp double NOT NULL,
  description varchar(500) NOT NULL,
  packing varchar(50) NOT NULL,
  image varchar(200) DEFAULT NULL,
  category integer NOT NULL,
  stock integer NOT NULL,
  status varchar(10) NOT NULL
);

--
-- Dumping data for table `products`
--

INSERT INTO products (id, sku, name, price, mrp, description, packing, image, category, stock, status) VALUES
(138, 5053, 'Aramusk Bath Soap For Men   ', 108, 108, '', '3 X 125 g ', 'aramusk-bath-soap-for-men-3-x-125-g.png', 140, 100, 'Active'),
(248, 386, 'Adidas Deo Ice Dive Deo Body Spray   ', 199, 199, '', '150 ml ', 'adidas-adidas-body-deo-ice-dive-150-ml.png', 130, 20, 'Inactive'),
(318, 6124, 'Baba Ramdev Patanjali Anti Bacterial Herbal Hand Wash Refill   ', 40, 40, '', '200 ml ', 'baba-ramdev-patanjali-anti-bacterial-herbal-hand-wash-refill-200-ml.png', 160, 50, 'Inactive'),
(432, 5625, 'Adidas Ice Dive Shower Gel   ', 150, 150, '', '250 ml ', 'adidas-ice-dive-shower-gel-250-ml.png', 170, 0, 'Active'),
(448, 2298, 'Axe Denim Cologne Talc   ', 115, 115, '', '300 g ', '1327941212-Jan30-1147.png', 180, 0, 'Active'),
(490, 8909, 'All Out Off Family Insect Repellent Lotion   ', 39, 39, '', '50 ml ', 'missingimagegr200.png', 190, 0, 'Active'),
(589, 4202, 'Baba Ramdev Patanjali Gulab Jal   ', 25, 25, '', '120 ml ', 'patanjali-gulab-jal-120-ml.png', 220, 0, 'Active'),
(722, 8068, 'Areev Melon &amp; Peach Mild Shampoo   ', 275, 275, '', '300 ml ', 'areev-melon-peach-mild-shampoo-v-300-ml-3.png', 200, 0, 'Active'),
(769, 8152, '18 Herbs K-Oil 100% Herbal Care   ', 275, 275, 'Hair Oil', '100 ml ', '18-herbs-18-herbs-k-oil-100-herbal-care-100-ml-1.png', 210, 100, 'Active'),
(797, 8273, 'Baba Ramdev Patanjali Kesh Kanti Anti Dandruff Hair Cleanser With Natural Conditioner   ', 110, 110, 'Anti Dandruff Shampoo', '200 ml ', 'baba-ramdev-patanjali-kesh-kanti-hair-cleanser-with-natural-conditioner-200-ml.png', 230, 22, 'Active'),
(901, 3936, 'Roots Hair Brush 2011   ', 175, 175, 'Hair Brush', '1 pc ', 'roots-hair-brush-2011-1-pc.png', 240, 5, 'Active'),
(918, 4273, 'Biotique Bio Henna Fresh Powder Hair Color   ', 199, 199, 'Powder', '90 g ', 'biotique-bio-henna-fresh-powder-hair-color-90-g.png', 250, 50, 'Active'),
(943, 7904, 'Brylcreem Anti Dandruff Aqua Oxy Hair Gel   ', 400, 40, 'Hair Gel', '50 g ', 'brylcreem-brylcreem-anti-dandruff-aqua-oxy-hair-gel-50-g.png', 260, 15, 'Active'),
(949, 5848, 'Ayur Natural Rajasthani Heena Mehendi   ', 11, 25, 'Mehendi.', '100 gm', 'ayur-natural-rajasthani-heena-mehendi-100-g.png', 270, 150, 'Active');



DROP TABLE IF EXISTS tomcat_users;
CREATE TABLE tomcat_users (
  user_name varchar(20) not null primary key,
  user_pass varchar(32) NOT NULL,
  user_fio varchar(250) DEFAULT NULL,
  user_ldap varchar(16) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  group_name varchar(20) DEFAULT NULL,
  ip varchar(16) DEFAULT NULL,
  regdate date DEFAULT NULL,
  update_ip varchar(16) DEFAULT NULL,
  update_regdate date DEFAULT NULL,
  status varchar(16) DEFAULT 'Inactive'
);

DROP TABLE IF EXISTS tomcat_roles;
CREATE TABLE tomcat_roles (
  role_name varchar(20) not null primary key,
  role_description varchar(256) NULL
);

DROP TABLE IF EXISTS tomcat_users_roles;
CREATE TABLE tomcat_users_roles (
  user_name varchar(20) NOT NULL,
  role_name varchar(20) NOT NULL,
  PRIMARY KEY (user_name, role_name)
);

DROP TABLE IF EXISTS tomcat_users_group;
CREATE TABLE tomcat_users_group (
  group_name varchar(20) not null primary key,
  group_description varchar(256) NULL,
  color varchar(7) DEFAULT '#BBBBBB'
);

--
-- Dumping data for table `tomcat_users_group`
--

INSERT INTO tomcat_users_group VALUES ('admin','Use for Administrators Jenkins','#FF0000'),('Aktopus','','#00FFFF'),('Biplane-Admin','','#0000FF'),('Biplane-Buh','','#000000'),('Biplane-Cashier','','#0000A0'),('Biplane-Dept','','#FFA500'),('Biplane-WebCashier','','#800080'),('Irbis','Use only Irbis department','#008000'),('Reports','','#808000'),('Test','','#3B3131'),('Tickets','','#5E5A80'),('undefined','Use for Defoult Group','#25383C'),('Vitrina','PrivatBank of project','#B9C795');

--
-- Dumping data for table `tomcat_roles`
--

INSERT INTO tomcat_roles VALUES ('manager-status','позволяет получить доступ только к странице состояния'),('tomcat',''),('manager-jmx','предоставляет доступ к JMX-прокси и к странице состояния'),('admin-script','позволяет получить доступ к текстовым интерфейсам и к страницам состояния'),('manager-script','позволяет получить доступ к текстовым интерфейсам и к страницам состояния'),('manager-gui','предоставляет доступ к JMX-прокси и к странице состояния'),('manager',''),('admin-gui','предоставляет доступ к JMX-прокси и к странице состояния'),('admin','');

--
-- Dumping data for table `tomcat_users`
--

INSERT INTO tomcat_users (user_name, user_pass, user_fio, user_ldap, email, group_name, ip, regdate) VALUES ('diver','b18da2b5c42b5f136d754d5ad9c8241e','Великоцкий Вячеслав Андреевич','dn120187vva',NULL,NULL,NULL,NULL),('dmitry','25d55ad283aa400af464c76d713c07ad','Белый Дмитрий Николаевич','nk310182bdn',NULL,NULL,NULL,NULL),('dn010190gma','45f70ebb449ca05e63d1f2f8f5d77005','Гладий Мария Алексеевна','dn010190gma',NULL,NULL,NULL,NULL),('dn021190saj','02eaa5d4a69f441a32750ff7a0122e45','Шумский Александр Юрьевич','dn021190saj',NULL,NULL,NULL,NULL),('dn030681gae','d5a7f14ba0044a04583f68264b0187a8','Горбенко Александр Евгеньевич','dn030681gae',NULL,NULL,NULL,NULL),('dn041189lvs','c20ae6e613882ee07dffa7ff99cacc99','Лущан Владислав Сергеевич','dn041189lvs',NULL,NULL,NULL,NULL),('dn060988mav','29572b8f8435211767d3fd2d9f8ea5f8','Манякин Александр Валериевич','dn060988mav',NULL,NULL,NULL,NULL),('dn080692zaa','74df8a04506d4d30431cb06f7afd67b8','Жмурков Александр Александрович','dn080692zaa',NULL,NULL,NULL,NULL),('dn090880vas','7534aea4414a62ce2c6822be69ce389b','Вознюк Андрей Сергеевич','dn090880vas',NULL,NULL,NULL,NULL),('dn100192pja','ea84dbe0abc548e5451a2c84ed8c1d64','Полинкевич Юлия Александровна','dn100192pja',NULL,NULL,NULL,NULL),('dn101188lvv','4098d61c71dc24b25423781734d79404','Лысенко Владимир Викторович','dn101188lvv',NULL,NULL,NULL,NULL),('dn110793tas','e673a4380e9acb0eab8afda928f60479','Теленко Андрей Сергеевич','dn110793tas',NULL,NULL,NULL,NULL),('dn130490tnv','eb1ce0d91d5b27c8bf5a974ba07233ff','Танаев Николай Викторович','dn130490tnv',NULL,NULL,NULL,NULL),('dn130591bav','f3c48548e8099cbe523793b7475cd01e','Бондаренко Александр Вячеславович','dn130591bav',NULL,NULL,NULL,NULL),('dn150190kad','719aa68685119189b88351e624a166e0','Козуб Алексей Дмитриевич','dn150190kad',NULL,NULL,NULL,NULL),('dn160588bai','e10adc3949ba59abbe56e057f20f883e','Белоусов Артур Игоревич','dn160588bai','artur.belousov@privatbank.ua','admin','10.13.71.46','2013-11-28'),('dn160889gas','51115093833f5e604535fafae6bb091d','Головацкий Андрей Сергеевич','dn160889gas',NULL,NULL,'',NULL),('dn170684sra','454136d655b755a86947060e9d2eb3a7','Штепа Роман Анатольевич','dn170684sra',NULL,NULL,NULL,NULL),('dn180989mis','ea270884adc57775492f10d7c1d03823','Малый Игорь Семенович','dn180989mis',NULL,NULL,NULL,NULL),('dn190491kmg','701a561acf52a1023648bb48b8496eea','Кругликова Марина Геннадьевна','dn190491kmg',NULL,NULL,NULL,NULL),('dn200978lak','273910799eacaacec06aba83c9d54906','Лазарчук Александр Константинович','dn200978lak','DN200978LAK@pbank.com.ua','admin','10.13.71.153','2013-11-29'),('dn220989lms','f9ba3f6b60f8c8771dbd63e0c111ad46','Лаушкина Марина Сергеевна','dn220989lms',NULL,NULL,'',NULL),('dn221290kea','3fd6f1ec303ba765e1bf7ab1649bbcd0','Кондратенко Евгений Александрович','dn221290kea',NULL,NULL,NULL,NULL),('dn230892gmg','a6aa1e1535086627ad5e0040cabcce2f','Галич Максим Геннадьевич','dn230892gmg',NULL,NULL,NULL,NULL),('dn250480tsa','7e8aab1a8900ad5be26385517638ee56','Терещенко Сергей Александрович','dn250480tsa',NULL,NULL,NULL,NULL),('dn250790kva','a7f920f1324e5edb3695d5f42611be0e','Касьяненко Виталий Александрович','dn250790kva',NULL,NULL,NULL,NULL),('dn300189mis','9b763f6da80326d0dff02abac99a7b35',NULL,'dn300189mis',NULL,NULL,NULL,NULL),('dn310784nvv','9910ff29f8c4b13954b6d34427bc83a1','Виктор Никулин Викторович','dn310784nvv',NULL,NULL,NULL,NULL),('dp310588kja','42e214ec593bb64a7cbcd0fe6e8a6c03','Коргут Юля','dp310588kja',NULL,NULL,NULL,NULL),('nk061183cvj','c1d4f351eaf2b4bf115ab322f8cce097','Чумак Владимир Юрьевич','nk061183cvj',NULL,NULL,NULL,NULL),('nk070281sjv','ed80e1fd5d2ed87bce237383bccab330','Шевцов Юрий Викторович','nk070281sjv',NULL,NULL,NULL,NULL),('roma','454136d655b755a86947060e9d2eb3a7','Штепа Роман Анатольевич','dn170684sra',NULL,NULL,NULL,NULL),('Seric','5d0eeac16e1635e8fbdce26684a6771d','Серик Александр Анатольевич','dn050690saa',NULL,NULL,NULL,NULL),('sniper89','51115093833f5e604535fafae6bb091d','Головацкий Андрей Сергеевич','dn160889gas',NULL,NULL,NULL,NULL),('yura','25d55ad283aa400af464c76d713c07ad','Решетник Юрий Владимирович','nk021077rjv',NULL,'admin',NULL,NULL);

--
-- Dumping data for table `tomcat_users_roles`
--

INSERT INTO tomcat_users_roles VALUES ('diver','admin'),('dmitry','admin'),('dn010190gma','admin'),('dn021190saj','admin'),('dn030681gae','admin'),('dn041189lvs','admin'),('dn060988mav','admin'),('dn080692zaa','admin'),('dn100192pja','admin'),('dn101188lvv','admin'),('dn110793tas','admin'),('dn130490tnv','admin'),('dn130591bav','admin'),('dn150190kad','admin'),('dn160588bai','admin'),('dn160889gas','admin'),('dn170684sra','admin'),('dn180989mis','admin'),('dn190491kmg','admin'),('dn200978lak','admin'),('dn220989lms','admin'),('dn221290kea','admin'),('dn230892gmg','admin'),('dn250480tsa','admin'),('dn250790kva','admin'),('dn300189mis','admin'),('dn310784nvv','admin'),('dp310588kja','admin'),('nk061183cvj','admin'),('nk070281sjv','admin'),('roma','admin'),('Seric','admin'),('sniper89','admin'),('yura','admin'),('diver','admin-gui'),('dmitry','admin-gui'),('dn010190gma','admin-gui'),('dn021190saj','admin-gui'),('dn030681gae','admin-gui'),('dn041189lvs','admin-gui'),('dn060988mav','admin-gui'),('dn080692zaa','admin-gui'),('dn100192pja','admin-gui'),('dn101188lvv','admin-gui'),('dn110793tas','admin-gui'),('dn130490tnv','admin-gui'),('dn130591bav','admin-gui'),('dn160588bai','admin-gui'),('dn160889gas','admin-gui'),('dn170684sra','admin-gui'),('dn180989mis','admin-gui'),('dn190491kmg','admin-gui'),('dn200978lak','admin-gui'),('dn220989lms','admin-gui'),('dn221290kea','admin-gui'),('dn230892gmg','admin-gui'),('dn250480tsa','admin-gui'),('dn250790kva','admin-gui'),('dn300189mis','admin-gui'),('dn310784nvv','admin-gui'),('dp310588kja','admin-gui'),('nk061183cvj','admin-gui'),('nk070281sjv','admin-gui'),('roma','admin-gui'),('Seric','admin-gui'),('sniper89','admin-gui'),('yura','admin-gui'),('diver','admin-script'),('dmitry','admin-script'),('dn010190gma','admin-script'),('dn021190saj','admin-script'),('dn030681gae','admin-script'),('dn041189lvs','admin-script'),('dn060988mav','admin-script'),('dn080692zaa','admin-script'),('dn100192pja','admin-script'),('dn101188lvv','admin-script'),('dn110793tas','admin-script'),('dn130490tnv','admin-script'),('dn130591bav','admin-script'),('dn150190kad','admin-script'),('dn160588bai','admin-script'),('dn160889gas','admin-script'),('dn170684sra','admin-script'),('dn180989mis','admin-script'),('dn190491kmg','admin-script'),('dn200978lak','admin-script'),('dn220989lms','admin-script'),('dn221290kea','admin-script'),('dn230892gmg','admin-script'),('dn250480tsa','admin-script'),('dn250790kva','admin-script'),('dn300189mis','admin-script'),('dn310784nvv','admin-script'),('dp310588kja','admin-script'),('nk061183cvj','admin-script'),('nk070281sjv','admin-script'),('roma','admin-script'),('Seric','admin-script'),('sniper89','admin-script'),('yura','admin-script'),('diver','manager'),('dn021190saj','manager'),('dn030681gae','manager'),('dn041189lvs','manager'),('dn080692zaa','manager'),('dn100192pja','manager'),('dn110793tas','manager'),('dn130490tnv','manager'),('dn130591bav','manager'),('dn160588bai','manager'),('dn160889gas','manager'),('dn200978lak','manager'),('dn230892gmg','manager'),('dn250480tsa','manager'),('dn300189mis','manager'),('dn310784nvv','manager'),('sniper89','manager'),('yura','manager'),('diver','manager-gui'),('dn021190saj','manager-gui'),('dn030681gae','manager-gui'),('dn041189lvs','manager-gui'),('dn080692zaa','manager-gui'),('dn100192pja','manager-gui'),('dn110793tas','manager-gui'),('dn130490tnv','manager-gui'),('dn130591bav','manager-gui'),('dn160588bai','manager-gui'),('dn160889gas','manager-gui'),('dn200978lak','manager-gui'),('dn230892gmg','manager-gui'),('dn250480tsa','manager-gui'),('dn300189mis','manager-gui'),('dn310784nvv','manager-gui'),('sniper89','manager-gui'),('yura','manager-gui'),('diver','manager-jmx'),('dmitry','manager-jmx'),('dn010190gma','manager-jmx'),('dn021190saj','manager-jmx'),('dn030681gae','manager-jmx'),('dn041189lvs','manager-jmx'),('dn060988mav','manager-jmx'),('dn080692zaa','manager-jmx'),('dn100192pja','manager-jmx'),('dn101188lvv','manager-jmx'),('dn110793tas','manager-jmx'),('dn130490tnv','manager-jmx'),('dn130591bav','manager-jmx'),('dn150190kad','manager-jmx'),('dn160588bai','manager-jmx'),('dn160889gas','manager-jmx'),('dn170684sra','manager-jmx'),('dn180989mis','manager-jmx'),('dn190491kmg','manager-jmx'),('dn200978lak','manager-jmx'),('dn220989lms','manager-jmx'),('dn221290kea','manager-jmx'),('dn230892gmg','manager-jmx'),('dn250480tsa','manager-jmx'),('dn250790kva','manager-jmx'),('dn300189mis','manager-jmx'),('dn310784nvv','manager-jmx'),('dp310588kja','manager-jmx'),('nk061183cvj','manager-jmx'),('nk070281sjv','manager-jmx'),('roma','manager-jmx'),('Seric','manager-jmx'),('sniper89','manager-jmx'),('yura','manager-jmx'),('diver','manager-script'),('dmitry','manager-script'),('dn010190gma','manager-script'),('dn021190saj','manager-script'),('dn030681gae','manager-script'),('dn041189lvs','manager-script'),('dn060988mav','manager-script'),('dn080692zaa','manager-script'),('dn100192pja','manager-script'),('dn101188lvv','manager-script'),('dn110793tas','manager-script'),('dn130490tnv','manager-script'),('dn130591bav','manager-script'),('dn160588bai','manager-script'),('dn160889gas','manager-script'),('dn170684sra','manager-script'),('dn180989mis','manager-script'),('dn190491kmg','manager-script'),('dn200978lak','manager-script'),('dn220989lms','manager-script'),('dn221290kea','manager-script'),('dn230892gmg','manager-script'),('dn250480tsa','manager-script'),('dn250790kva','manager-script'),('dn300189mis','manager-script'),('dn310784nvv','manager-script'),('dp310588kja','manager-script'),('nk061183cvj','manager-script'),('nk070281sjv','manager-script'),('roma','manager-script'),('Seric','manager-script'),('sniper89','manager-script'),('yura','manager-script'),('diver','manager-status'),('dmitry','manager-status'),('dn010190gma','manager-status'),('dn021190saj','manager-status'),('dn030681gae','manager-status'),('dn041189lvs','manager-status'),('dn060988mav','manager-status'),('dn080692zaa','manager-status'),('dn100192pja','manager-status'),('dn101188lvv','manager-status'),('dn110793tas','manager-status'),('dn130490tnv','manager-status'),('dn130591bav','manager-status'),('dn150190kad','manager-status'),('dn160588bai','manager-status'),('dn160889gas','manager-status'),('dn170684sra','manager-status'),('dn180989mis','manager-status'),('dn190491kmg','manager-status'),('dn200978lak','manager-status'),('dn220989lms','manager-status'),('dn221290kea','manager-status'),('dn230892gmg','manager-status'),('dn250480tsa','manager-status'),('dn250790kva','manager-status'),('dn300189mis','manager-status'),('dn310784nvv','manager-status'),('dp310588kja','manager-status'),('nk061183cvj','manager-status'),('nk070281sjv','manager-status'),('roma','manager-status'),('Seric','manager-status'),('sniper89','manager-status'),('yura','manager-status'),('diver','tomcat'),('dmitry','tomcat'),('dn010190gma','tomcat'),('dn021190saj','tomcat'),('dn030681gae','tomcat'),('dn041189lvs','tomcat'),('dn060988mav','tomcat'),('dn080692zaa','tomcat'),('dn100192pja','tomcat'),('dn101188lvv','tomcat'),('dn110793tas','tomcat'),('dn130490tnv','tomcat'),('dn130591bav','tomcat'),('dn150190kad','tomcat'),('dn160588bai','tomcat'),('dn160889gas','tomcat'),('dn170684sra','tomcat'),('dn180989mis','tomcat'),('dn190491kmg','tomcat'),('dn200978lak','tomcat'),('dn220989lms','tomcat'),('dn221290kea','tomcat'),('dn230892gmg','tomcat'),('dn250480tsa','tomcat'),('dn250790kva','tomcat'),('dn300189mis','tomcat'),('dn310784nvv','tomcat'),('dp310588kja','tomcat'),('nk061183cvj','tomcat'),('nk070281sjv','tomcat'),('roma','tomcat'),('Seric','tomcat'),('sniper89','tomcat'),('yura','tomcat');
