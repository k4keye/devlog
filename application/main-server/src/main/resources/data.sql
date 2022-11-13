INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD, NICK_NAME,EMAIL)  VALUES ('admin', '$2a$10$c2VT5PblS4HYEdeeLIc5t.y17pTePRHorrWPt2YeGTYB81J2.kPLu', 'adminNickName', 'admin@admin.com');
INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD, NICK_NAME,EMAIL)  VALUES ('user', '$2a$10$0ajkgQCOdO5gIheng00pc.0sX84W8qFW.8hDEdsRsh32B/3pOHPly', 'userNickName', 'user@user.com');
--
INSERT INTO tb_authority (AUTHORITY_NAME) values ('ROLE_USER');
INSERT INTO tb_authority (AUTHORITY_NAME) values ('ROLE_ADMIN');
--
INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('admin', 'ROLE_ADMIN');
INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('user', 'ROLE_USER');



--  dummy member
-- INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD,EMAIL,NICK_NAME)  VALUES ('wjsi231', '$2a$10$0ajkgQCOdO5gIheng00pc.0sX84W8qFW.8hDEdsRsh32B/3pOHPly',  'swt234@naver.com','딸기wjsi231');
-- INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD,EMAIL,NICK_NAME)  VALUES ('olol227', '$2a$10$0ajkgQCOdO5gIheng00pc.0sX84W8qFW.8hDEdsRsh32B/3pOHPly', 'blublu@naver.com','바나나olol227');
-- INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD,EMAIL,NICK_NAME)  VALUES ('qwnem01', '$2a$10$0ajkgQCOdO5gIheng00pc.0sX84W8qFW.8hDEdsRsh32B/3pOHPly',  'q01@naver.com','멜론qwnem01');
-- INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD,EMAIL,NICK_NAME)  VALUES ('zzzuv34', '$2a$10$0ajkgQCOdO5gIheng00pc.0sX84W8qFW.8hDEdsRsh32B/3pOHPly', 'zzzUN@naver.com','키위zzzuv34');
-- INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD,EMAIL,NICK_NAME)  VALUES ('iaiaiai9001', '$2a$10$0ajkgQCOdO5gIheng00pc.0sX84W8qFW.8hDEdsRsh32B/3pOHPly','lalalal@naver.com','포테이토iaiaiai9001');
--
-- INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('wjsi231', 'ROLE_USER');
-- INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('olol227', 'ROLE_USER');
-- INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('qwnem01', 'ROLE_USER');
-- INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('zzzuv34', 'ROLE_USER');
-- INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('iaiaiai9001', 'ROLE_USER');



-- INSERT INTO tb_product (name, price, stock_quantity)  VALUES ('몸에 좋은 비타민', 20000, 100);
-- INSERT INTO tb_product (name, price, stock_quantity)  VALUES ('맛이 좋은 양념장', 5000, 350);
-- INSERT INTO tb_product (name, price, stock_quantity)  VALUES ('머리 쑥쑥 아몬드', 1000, 30);
-- INSERT INTO tb_product (name, price, stock_quantity)  VALUES ('밝은 형광등', 72000, 5);
