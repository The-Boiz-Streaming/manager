INSERT INTO artist (id, name) VALUES
('6dc198aa-3ec6-11f0-9fe2-0242ac120002', 'MACAN'),
('8a80713c-3ec6-11f0-9fe2-0242ac120002', 'Kunteynir'),
('a32839cc-3ec6-11f0-9fe2-0242ac120002', 'Oxxxymiron')
ON CONFLICT (id) DO NOTHING;

INSERT INTO release (id, artist_id, release_type, name, release_year) VALUES
('35676506-3ec7-11f0-9fe2-0242ac120002', '6dc198aa-3ec6-11f0-9fe2-0242ac120002', 'single', 'Asphalt 8', 1967),
('7e96c69a-3ec7-11f0-9fe2-0242ac120002', '8a80713c-3ec6-11f0-9fe2-0242ac120002', 'EP', 'XANAX', 2016),
('aceade00-3ec7-11f0-9fe2-0242ac120002', 'a32839cc-3ec6-11f0-9fe2-0242ac120002', 'LP', 'Горгород', 2015)
ON CONFLICT (id) DO NOTHING;

-- MACAN
INSERT INTO track (id, release_id, name, duration, track_number, file_id) VALUES
('d8f5e5ee-3ec7-11f0-9fe2-0242ac120002', '35676506-3ec7-11f0-9fe2-0242ac120002', 'Asphalt 8', 136, 1, '21f7f654-e699-4b1b-8707-a58761e86bfc')
ON CONFLICT (id) DO NOTHING;

-- Kunteynir
INSERT INTO track (id, release_id, name, duration, track_number, file_id) VALUES
('af63c110-3ed1-11f0-9fe2-0242ac120002', '7e96c69a-3ec7-11f0-9fe2-0242ac120002', 'Нужен XANAX', 230, 1, '119168e6-1d72-45f3-b936-101d63bbe0cf'),
('d83da1aa-3ed1-11f0-9fe2-0242ac120002', '7e96c69a-3ec7-11f0-9fe2-0242ac120002', 'Аквапарк', 281, 2, 'fe6a392e-0675-44a7-b4ce-2015736bfb10'),
('ed58f4ea-3ed1-11f0-9fe2-0242ac120002', '7e96c69a-3ec7-11f0-9fe2-0242ac120002', 'В трусах', 271, 3, 'e56f4508-c1e5-46f1-9680-4023fbb59c24')
ON CONFLICT (id) DO NOTHING;

-- Oxxxymiron
INSERT INTO track (id, release_id, name, duration, track_number, file_id) VALUES
('2b288600-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Не с начала', 125, 1, '0491216f-afcd-4981-8ae4-8e119ba64a26'),
('61d4e11c-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Кем ты стал', 236, 2, '200cd3bf-e324-4564-98f4-03a88b5659ce'),
('ca3fff20-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Всего лишь писатель', 209, 3, '0491216f-afcd-4981-8ae4-8e119ba64a26'),
('d1d300d4-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Девочка ******', 164, 4, '25e37abd-b607-4251-9239-82a3054cf426'),
('d689cd10-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Переплетено', 291, 5, '6226c4e0-c718-49d1-962e-823f8af1bdc1'),
('d992b2ec-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Колыбельная', 198, 6, '5fcc9724-c33c-4191-9d5e-af486f7360d4'),
('dc69a836-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Полигон', 220, 7, 'cf676eda-e833-4548-a5de-737f2485b7cd'),
('dec21280-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Накануне', 222, 8, 'ab9a1e01-37fa-4715-999b-d5a9b772c153'),
('e1695688-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Слово мэра', 241, 9, '0964c489-0296-44c2-9f36-1a2b96565d62'),
('e3c3f320-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Башня из слоновой кости', 205, 10, '4223aa8a-6a6d-4ed0-a3ba-17910438ba79'),
('e5ea087e-3ed2-11f0-9fe2-0242ac120002', 'aceade00-3ec7-11f0-9fe2-0242ac120002', 'Где нас нет', 266, 11, '31018492-754c-4c96-8ead-98e5f73dee9d')
ON CONFLICT (id) DO NOTHING;

