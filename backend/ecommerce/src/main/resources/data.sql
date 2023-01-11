--Spring 기본값으로 classpath 루트에 schema.sql 파일이 있다면 서버 시작시 스크립트를 실행한다.
-- 보통 schema.sql은 DDL 스크립트를 명시해두고, 데이터를 위한 DML문은 data.sql 파일로 작성해두면 역시 자동으로 실행한다.

-- ================ Root 카테고리
insert into category(name, parent_id) values ('men', 0);
insert into category(name, parent_id) values ('women', 0);
insert into category(name, parent_id) values ('kids', 0);


-- =============== Level 1 카테고리
--
insert into category(name, parent_id) values ('men_hat', 1l);
insert into category(name, parent_id) values ('men_shirts', 1l);
insert into category(name, parent_id) values ('men_pants', 1l);

insert into category(name, parent_id) values ('women_hat', 2l);
insert into category(name, parent_id) values ('women_shirts', 2l);
insert into category(name, parent_id) values ('women_pants', 2l);

insert into category(name, parent_id) values ('kids_hat', 3l);
insert into category(name, parent_id) values ('kids_shirts', 3l);
insert into category(name, parent_id) values ('kids_pants', 3l);

---- 가전
--insert into category(name, parent_id) values ('컴퓨터', 2l);
--insert into category(name, parent_id) values ('냉장고', 2l);
--insert into category(name, parent_id) values ('청소기', 2l);
--insert into category(name, parent_id) values ('세탁기/건조기', 2l);
--
---- 도서
--insert into category(name, parent_id) values ('여행', 3l);
--insert into category(name, parent_id) values ('역사', 3l);
--insert into category(name, parent_id) values ('예술', 3l);
--insert into category(name, parent_id) values ('공학/과학', 3l);
--
---- 식품
--insert into category(name, parent_id) values ('과일', 4l);
--insert into category(name, parent_id) values ('채소', 4l);
--insert into category(name, parent_id) values ('생수/음료', 4l);
--insert into category(name, parent_id) values ('수산물', 4l);
--insert into category(name, parent_id) values ('축산', 4l);

---- =============== Level 3 카테고리행
---- === 패션
---- 여성
--insert into category(name, parent_id) values ('티', 5l);
--insert into category(name, parent_id) values ('원피스', 5l);
--insert into category(name, parent_id) values ('블라우스', 5l);
--insert into category(name, parent_id) values ('바지/레깅스', 5l);
--
---- 남성
--insert into category(name, parent_id) values ('티', 6l);
--insert into category(name, parent_id) values ('맨투맨/후드', 6l);
--insert into category(name, parent_id) values ('셔츠', 6l);
--insert into category(name, parent_id) values ('바지/청바지', 6l);
--
---- 아동
--insert into category(name, parent_id) values ('여아', 7l);
--insert into category(name, parent_id) values ('남아', 7l);
--insert into category(name, parent_id) values ('공용', 7l);
--
---- 스포츠
--insert into category(name, parent_id) values ('여성', 8l);
--insert into category(name, parent_id) values ('남성', 8l);
--insert into category(name, parent_id) values ('유아', 8l);
--
---- 신발/가방/잡화
--insert into category(name, parent_id) values ('시계', 9l);
--insert into category(name, parent_id) values ('신발', 9l);
--insert into category(name, parent_id) values ('가방', 9l);
--insert into category(name, parent_id) values ('모자', 9l);
--
---- === 가전
---- 컴퓨터
--insert into category(name, parent_id) values ('노트북', 10l);
--insert into category(name, parent_id) values ('데스크탑', 10l);
--insert into category(name, parent_id) values ('모니터', 10l);
--insert into category(name, parent_id) values ('키보드/마우스', 10l);
--
---- 냉장고
--insert into category(name, parent_id) values ('양문형냉장고', 11l);
--insert into category(name, parent_id) values ('3/4도어냉장고', 11l);
--insert into category(name, parent_id) values ('미니냉장고', 11l);
--insert into category(name, parent_id) values ('김치냉장고', 11l);
--
---- 청소기
--insert into category(name, parent_id) values ('무선/스틱청소기', 12l);
--insert into category(name, parent_id) values ('진공청소기', 12l);
--insert into category(name, parent_id) values ('로봇청소기', 12l);
--insert into category(name, parent_id) values ('스팀청소기', 12l);
--
---- 세탁기/건조기
--insert into category(name, parent_id) values ('세탁기', 13l);
--insert into category(name, parent_id) values ('건조기', 13l);
--insert into category(name, parent_id) values ('탈수기', 13l);
--
--
---- === 도서
---- 여행
--insert into category(name, parent_id) values ('국내여행', 14l);
--insert into category(name, parent_id) values ('해외여행', 14l);
--
---- 역사
--insert into category(name, parent_id) values ('한국사', 15l);
--insert into category(name, parent_id) values ('중국사', 15l);
--insert into category(name, parent_id) values ('서양사', 15l);
--
---- 예술
--insert into category(name, parent_id) values ('건축', 16l);
--insert into category(name, parent_id) values ('미술', 16l);
--insert into category(name, parent_id) values ('음악', 16l);
--insert into category(name, parent_id) values ('무용', 16l);
--
---- 공학/과학
--insert into category(name, parent_id) values ('화학', 17l);
--insert into category(name, parent_id) values ('수학', 17l);
--insert into category(name, parent_id) values ('물리', 17l);
--insert into category(name, parent_id) values ('공학', 17l);
--
---- === 식품
---- 과일
--insert into category(name, parent_id) values ('사과/배', 18l);
--insert into category(name, parent_id) values ('귤/감', 18l);
--insert into category(name, parent_id) values ('수박', 18l);
--insert into category(name, parent_id) values ('딸기', 18l);
--
---- 채소
--insert into category(name, parent_id) values ('콩나물', 19l);
--insert into category(name, parent_id) values ('두부', 19l);
--insert into category(name, parent_id) values ('당근', 19l);
--insert into category(name, parent_id) values ('오이', 19l);
--
---- 생수/음료
--insert into category(name, parent_id) values ('생수/탄산수', 20l);
--insert into category(name, parent_id) values ('과일음료', 20l);
--insert into category(name, parent_id) values ('커피', 20l);
--insert into category(name, parent_id) values ('탄산/스포츠음료', 20l);
--
---- 수산물
--insert into category(name, parent_id) values ('생선', 21l);
--insert into category(name, parent_id) values ('오징어', 21l);
--insert into category(name, parent_id) values ('새우', 21l);
--insert into category(name, parent_id) values ('멸치', 21l);
--
---- 축산
--insert into category(name, parent_id) values ('소고기', 22l);
--insert into category(name, parent_id) values ('돼지고기', 22l);
--insert into category(name, parent_id) values ('닭/오리고기', 22l);
--insert into category(name, parent_id) values ('양고기', 22l);