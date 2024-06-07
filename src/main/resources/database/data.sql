INSERT INTO place (work_place, address) VALUES ('더샾','서울 영등포구 가마산로');

INSERT INTO emp (place_id, id, `password`, department, position, auth, name, phone, address, address_detail, birth) VALUES (1, 'test', '1111', '관리', '사원', 'admin', '홍길동', '010-0000-0000', '서울 금천구', '303동', '19940402');

INSERT INTO lost_item (emp_id, title, content, note, status, name, insert_date, update_date) VALUES (1, '잃어버린 가방을 찾습니다.', '가방 잃어버리신분은 관리실에 와서 찾아가시면 됩니다.', '', '분실', '홍길동', '20240520', null);

INSERT INTO event (emp_id, date_time, title, content, note, name, insert_date, update_date) VALUES (1, '2024-06-06 19:00:00', '야간 장터', '행사 상세 내용', '', '홍길동', '20240520', null);



