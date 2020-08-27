DROP TABLE grade;
DROP TABLE buy;
DROP TABLE purchase_list;
DROP TABLE pos;
DROP TABLE hq;
DROP TABLE stock;
DROP TABLE store;
DROP TABLE product;
DROP TABLE member;

commit;

CREATE TABLE member
(
mno NUMBER,
name VARCHAR2(16) CONSTRAINT member_name_NN NOT NULL,
phone VARCHAR2(20) CONSTRAINT member_phone_NN NOT NULL,
reserves NUMBER DEFAULT 0 CONSTRAINT member_reserves_NN NOT NULL,
CONSTRAINT member_mno_PK PRIMARY KEY(mno),
CONSTRAINT member_name_CK CHECK (LENGTH(name)<=5),
CONSTRAINT member_phone_CK CHECK (REGEXP_LIKE (phone, '010-[0-9]{4}-[0-9]{4}'))
);

CREATE TABLE product
(      
pno VARCHAR2(8),      
category VARCHAR2(20) CONSTRAINT product_category_NN NOT NULL,      
comp VARCHAR2(20) CONSTRAINT product_comp_NN NOT NULL,      
pname VARCHAR2(50) CONSTRAINT product_pname_NN NOT NULL,      
price NUMBER CONSTRAINT product_price_NN NOT NULL,         
shelflife DATE , 
nowtime DATE DEFAULT SYSDATE,
event NUMBER,
CONSTRAINT product_pno_PK PRIMARY KEY(pno),
CONSTRAINT product_shelflife_CK CHECK (shelflife > nowtime)
);

CREATE TABLE store
(
sno VARCHAR2(10),
sname VARCHAR2(30) CONSTRAINT store_store_name_NN NOT NULL,
address VARCHAR2(30) CONSTRAINT store_address_NN NOT NULL,
admin VARCHAR2(16) CONSTRAINT store_admin_NN NOT NULL,
CONSTRAINT store_sno_PK PRIMARY KEY(sno),
CONSTRAINT store_sname_UK UNIQUE (sname),
CONSTRAINT store_address_CK CHECK (address LIKE '%시 %구 %동')
);

CREATE TABLE stock
(
sno VARCHAR2(10) CONSTRAINT stock_sno_NN NOT NULL,
pno VARCHAR2(8),
stock NUMBER CONSTRAINT product_stock_NN NOT NULL,
CONSTRAINT stock_sno_FK FOREIGN KEY(sno) REFERENCES store(sno),
CONSTRAINT stock_pno_FK FOREIGN KEY(pno) REFERENCES product(pno),
CONSTRAINT stock_stock_CK CHECK (stock>0)
);

CREATE TABLE hq
(
mno NUMBER,
sno VARCHAR2(10),
CONSTRAINT hq_mno_FK FOREIGN KEY(mno) REFERENCES member(mno),
CONSTRAINT hq_sno_FK FOREIGN KEY(sno) REFERENCES store(sno)
);

CREATE TABLE pos
(
pos_num VARCHAR2(20) CONSTRAINT store_pos_num_NN NOT NULL,
sno VARCHAR2(10),
CONSTRAINT store_pos_num_CK CHECK (REGEXP_LIKE (pos_num, 'POS-[0-9]{2}')),
CONSTRAINT pos_sno_FK FOREIGN KEY(sno) REFERENCES store(sno)
);

CREATE TABLE purchase_list 
(
barcode VARCHAR2(20),
ploc VARCHAR2(50) CONSTRAINT purchase_list_ploc_NN NOT NULL,
totalpay NUMBER CONSTRAINT purchase_list_payment_NN NOT NULL, 
pos_num VARCHAR2(20) CONSTRAINT purchase_list_posno_NN NOT NULL,
paytime VARCHAR2(30) CONSTRAINT purchase_list_paytime_NN NOT NULL,
payway VARCHAR2(10) CONSTRAINT purchase_list_payway_NN NOT NULL,
mno NUMBER,
CONSTRAINT purchase_list_barcode_PK PRIMARY KEY(barcode),
CONSTRAINT purchase_list_mno_FK FOREIGN KEY(mno) REFERENCES member(mno),
CONSTRAINT purchase_list_posno_CK CHECK (REGEXP_LIKE (pos_num, 'POS-[0-9]{2}'))
);

CREATE TABLE buy
(
productname VARCHAR2(30) CONSTRAINT buy_payproduct_NN NOT NULL,
paysum NUMBER CONSTRAINT buy_payment_NN NOT NULL ,
ordercount NUMBER CONSTRAINT buy_ordercount_NN NOT NULL,
barcode VARCHAR2(20) CONSTRAINT buy_barcode_NN NOT NULL
); 

CREATE TABLE grade
(
rank VARCHAR2(12) DEFAULT 'Bronze' CONSTRAINT grade_rank_NN NOT NULL,
lowervalue NUMBER CONSTRAINT grade_lowervalue_NN  NOT NULL,
uppervalue NUMBER CONSTRAINT grade_uppervalue_NN  NOT NULL,
mileage NUMBER CONSTRAINT grade_mileage_NN NOT NULL
);

INSERT INTO member VALUES(1, '비회원', '010-0000-0000', 0);
INSERT INTO member VALUES(2, '김길', '010-4444-5555', 10000);
INSERT INTO member VALUES(3, '강동', '010-2233-4455', 30000);
INSERT INTO member VALUES(4, '김동', '010-4444-5555', 500);
INSERT INTO member VALUES(5, '김동', '010-4444-5555', 15000);

INSERT INTO store
VALUES ('CU01', '강남대로점', '서울시 강남구 서초동', '김지현');

INSERT INTO store
VALUES ('CU02', '상도점', '서울시 동작구 상도동', '로다주');

INSERT INTO store
VALUES ('CU03', '서초유앤아이점', '서울시 서초구 서초동', '홍길동');

INSERT INTO store
VALUES ('CU04', '서초캐슬점', '서울시 서초구 서초동', '이순신');

INSERT INTO store
VALUES ('CU05', '반포진우점', '서울시 서초구 반포동', '유관순');

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#01001', '간편식사', 'CU', '단짠불고기버거', 1900, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#01002', '간편식사', 'CU', '보성녹돈정식', 5000, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#01003', '간편식사', 'CU', '퀴노아바질샐러드', 1900, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#01004', '간편식사', 'CU', '족발비빔면', 3900, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#01005', '간편식사', 'CU', '플랫브레드풀드포크', 4500, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#02001', '즉석요리', 'CU', '잔슨빌핫도그', 1800, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#02002', '즉석요리', 'CU', '베리타르트60g', 1200, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#02003', '즉석요리', 'CU', '미트스틱', 1500, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#02004', '즉석요리', 'CU', '마늘바케트볼', 2200, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#02005', '즉석요리', 'CU', '치즈볼(3ea)', 1500, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#03001', '과자류', '농심', '자갈치', 1500, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#03002', '과자류', '크라운', '죠리퐁', 1500, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#03003', '과자류', '오리온', '오뜨치즈6입', 3000, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#03004', '과자류', '해태', '칸츄리콘', 1500, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#03005', '과자류', 'CU', 'HEYROO크리미어니언칩', 1000, '2021-08-17', 1);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#04001', '아이스크림', '롯데', '스크류주물러', 1200, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#04002', '아이스크림', '해태', '탱크보이', 1200, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#04003', '아이스크림', '롯데', '월드콘초코', 1800, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#04004', '아이스크림', '삼우', '삼육두유콘', 1800, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#04005', '아이스크림', '해태', '누가바', 1000, '2021-04-17', 1);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#05001', '식품', '풍림', '치즈계란말이', 2700, '2020-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#05002', '식품', '풀무원', '얇은피꽉찬교자', 5500, '2021-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#05003', '식품', 'cj', '동치미물냉면', 6000, '2021-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#05004', '식품', '동원', '양반왕갈비탕', 5900, '2021-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#05005', '식품', '삼양', '까르보불닭닭강정', 5200, '2021-09-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#06001', '음료', '동서', '스타벅스돌체병', 2900, '2020-10-31', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#06002', '음료', '롯데', '콘트라티그린', 2000, '2020-10-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#06003', '음료', '서울', '달고나우유', 1500, '2020-09-28', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#06004', '음료', '매일', '커피속모카', 1500, '2020-09-28', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#06005', '음료', '코카', '제로콜라', 1300, '2020-09-28', 2);

INSERT INTO product (pno, category, comp, pname, price, event)
VALUES ('#07001', '생활용품', '모나미', '일반수첩', 1100, 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#07002', '생활용품', '크리오', '치약칫솔세트', 2700, '2023-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#07003', '생활용품', 'pmc', '신신파스쿨', 3900, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#07004', '생활용품', '원단', '장우산블랙70', 13500, '2025-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#07005', '생활용품', '동화', '부채표알프스B4', 1000, '2022-08-17', 2);

INSERT INTO stock
VALUES ('CU01', '#01001', 15);

INSERT INTO stock
VALUES ('CU01', '#01002', 15);

INSERT INTO stock
VALUES ('CU01', '#01003', 15);

INSERT INTO stock
VALUES ('CU01', '#02001', 10);

INSERT INTO stock
VALUES ('CU01', '#02002', 15);

INSERT INTO stock
VALUES ('CU01', '#02003', 12);

INSERT INTO stock
VALUES ('CU01', '#03001', 50);

INSERT INTO stock
VALUES ('CU01', '#03002', 50);

INSERT INTO stock
VALUES ('CU01', '#03003', 50);

INSERT INTO stock
VALUES ('CU01', '#04001', 100);

INSERT INTO stock
VALUES ('CU01', '#04002', 100);

INSERT INTO stock
VALUES ('CU01', '#04003', 100);

INSERT INTO stock
VALUES ('CU01', '#05001', 30);

INSERT INTO stock
VALUES ('CU01', '#05002', 30);

INSERT INTO stock
VALUES ('CU01', '#05003', 30);

INSERT INTO stock
VALUES ('CU01', '#06001', 50);

INSERT INTO stock
VALUES ('CU01', '#06002', 15);

INSERT INTO stock
VALUES ('CU01', '#06003', 15);

INSERT INTO stock
VALUES ('CU01', '#07001', 5);

INSERT INTO stock
VALUES ('CU01', '#07002', 10);

INSERT INTO stock
VALUES ('CU01', '#07003', 15);

INSERT INTO stock
VALUES ('CU02', '#01001', 30);

INSERT INTO stock
VALUES ('CU02', '#01002', 30);

INSERT INTO stock
VALUES ('CU02', '#01003', 30);

INSERT INTO stock
VALUES ('CU02', '#02001', 30);

INSERT INTO stock
VALUES ('CU02', '#02002', 30);

INSERT INTO stock
VALUES ('CU02', '#02003', 30);

INSERT INTO stock
VALUES ('CU02', '#03001', 50);

INSERT INTO stock
VALUES ('CU02', '#03002', 50);

INSERT INTO stock
VALUES ('CU02', '#03003', 50);

INSERT INTO stock
VALUES ('CU02', '#04001', 100);

INSERT INTO stock
VALUES ('CU02', '#04002', 100);

INSERT INTO stock
VALUES ('CU02', '#04003', 100);

INSERT INTO stock
VALUES ('CU02', '#05001', 30);

INSERT INTO stock
VALUES ('CU02', '#05002', 30);

INSERT INTO stock
VALUES ('CU02', '#05003', 30);

INSERT INTO stock
VALUES ('CU02', '#06001', 50);

INSERT INTO stock
VALUES ('CU02', '#06002', 30);

INSERT INTO stock
VALUES ('CU02', '#06003', 30);

INSERT INTO stock
VALUES ('CU02', '#07001', 30);

INSERT INTO stock
VALUES ('CU02', '#07002', 30);

INSERT INTO stock
VALUES ('CU02', '#07003', 30);

INSERT INTO stock
VALUES ('CU03', '#01001', 30);

INSERT INTO stock
VALUES ('CU03', '#01002', 30);

INSERT INTO stock
VALUES ('CU03', '#01003', 30);

INSERT INTO stock
VALUES ('CU03', '#02001', 30);

INSERT INTO stock
VALUES ('CU03', '#02002', 30);

INSERT INTO stock
VALUES ('CU03', '#02003', 30);

INSERT INTO stock
VALUES ('CU03', '#03001', 50);

INSERT INTO stock
VALUES ('CU03', '#03002', 50);

INSERT INTO stock
VALUES ('CU03', '#03003', 50);

INSERT INTO stock
VALUES ('CU03', '#04001', 100);

INSERT INTO stock
VALUES ('CU03', '#04002', 100);

INSERT INTO stock
VALUES ('CU03', '#04003', 100);

INSERT INTO stock
VALUES ('CU03', '#05001', 30);

INSERT INTO stock
VALUES ('CU03', '#05002', 30);

INSERT INTO stock
VALUES ('CU03', '#05003', 30);

INSERT INTO stock
VALUES ('CU03', '#06001', 50);

INSERT INTO stock
VALUES ('CU03', '#06002', 30);

INSERT INTO stock
VALUES ('CU03', '#06003', 30);

INSERT INTO stock
VALUES ('CU03', '#07001', 30);

INSERT INTO stock
VALUES ('CU03', '#07002', 30);

INSERT INTO stock
VALUES ('CU03', '#07003', 30);

INSERT INTO stock
VALUES ('CU04', '#01001', 30);

INSERT INTO stock
VALUES ('CU04', '#01002', 30);

INSERT INTO stock
VALUES ('CU04', '#01003', 30);

INSERT INTO stock
VALUES ('CU04', '#02001', 30);

INSERT INTO stock
VALUES ('CU04', '#02002', 30);

INSERT INTO stock
VALUES ('CU04', '#02003', 30);

INSERT INTO stock
VALUES ('CU04', '#03001', 50);

INSERT INTO stock
VALUES ('CU04', '#03002', 50);

INSERT INTO stock
VALUES ('CU04', '#03003', 50);

INSERT INTO stock
VALUES ('CU04', '#04001', 100);

INSERT INTO stock
VALUES ('CU04', '#04002', 100);

INSERT INTO stock
VALUES ('CU04', '#04003', 100);

INSERT INTO stock
VALUES ('CU04', '#05001', 30);

INSERT INTO stock
VALUES ('CU04', '#05002', 30);

INSERT INTO stock
VALUES ('CU04', '#05003', 30);

INSERT INTO stock
VALUES ('CU04', '#06001', 50);

INSERT INTO stock
VALUES ('CU04', '#06002', 30);

INSERT INTO stock
VALUES ('CU04', '#06003', 30);

INSERT INTO stock
VALUES ('CU04', '#07001', 30);

INSERT INTO stock
VALUES ('CU04', '#07002', 30);

INSERT INTO stock
VALUES ('CU04', '#07003', 30);

INSERT INTO stock
VALUES ('CU05', '#01001', 30);

INSERT INTO stock
VALUES ('CU05', '#01002', 30);

INSERT INTO stock
VALUES ('CU05', '#01003', 30);

INSERT INTO stock
VALUES ('CU05', '#02001', 30);

INSERT INTO stock
VALUES ('CU05', '#02002', 30);

INSERT INTO stock
VALUES ('CU05', '#02003', 30);

INSERT INTO stock
VALUES ('CU05', '#03001', 50);

INSERT INTO stock
VALUES ('CU05', '#03002', 50);

INSERT INTO stock
VALUES ('CU05', '#03003', 50);

INSERT INTO stock
VALUES ('CU05', '#04001', 100);

INSERT INTO stock
VALUES ('CU05', '#04002', 100);

INSERT INTO stock
VALUES ('CU05', '#04003', 100);

INSERT INTO stock
VALUES ('CU05', '#05001', 30);

INSERT INTO stock
VALUES ('CU05', '#05002', 30);

INSERT INTO stock
VALUES ('CU05', '#05003', 30);

INSERT INTO stock
VALUES ('CU05', '#06001', 50);

INSERT INTO stock
VALUES ('CU05', '#06002', 30);

INSERT INTO stock
VALUES ('CU05', '#06003', 30);

INSERT INTO stock
VALUES ('CU05', '#07001', 30);

INSERT INTO stock
VALUES ('CU05', '#07002', 30);

INSERT INTO stock
VALUES ('CU05', '#07003', 30);


INSERT INTO stock
VALUES ('CU01', '#01004', 30);

INSERT INTO stock
VALUES ('CU01', '#01005', 30);

INSERT INTO stock
VALUES ('CU01', '#02004', 30);

INSERT INTO stock
VALUES ('CU01', '#02005', 30);

INSERT INTO stock
VALUES ('CU01', '#03004', 30);

INSERT INTO stock
VALUES ('CU01', '#03005', 30);

INSERT INTO stock
VALUES ('CU01', '#04004', 30);

INSERT INTO stock
VALUES ('CU01', '#04005', 30);

INSERT INTO stock
VALUES ('CU01', '#05004', 30);

INSERT INTO stock
VALUES ('CU01', '#05005', 30);

INSERT INTO stock
VALUES ('CU01', '#06004', 30);

INSERT INTO stock
VALUES ('CU01', '#06005', 30); 

INSERT INTO stock
VALUES ('CU01', '#07004', 30);

INSERT INTO stock
VALUES ('CU01', '#07005', 30);

INSERT INTO stock
VALUES ('CU02', '#01004', 30);

INSERT INTO stock
VALUES ('CU02', '#01005', 30);

INSERT INTO stock
VALUES ('CU02', '#02004', 30);

INSERT INTO stock
VALUES ('CU02', '#02005', 30);

INSERT INTO stock
VALUES ('CU02', '#03004', 30);

INSERT INTO stock
VALUES ('CU02', '#03005', 30);

INSERT INTO stock
VALUES ('CU02', '#04004', 30);

INSERT INTO stock
VALUES ('CU02', '#04005', 30);

INSERT INTO stock
VALUES ('CU02', '#05004', 30);

INSERT INTO stock
VALUES ('CU02', '#05005', 30);

INSERT INTO stock
VALUES ('CU02', '#06004', 30);

INSERT INTO stock
VALUES ('CU02', '#06005', 30); 

INSERT INTO stock
VALUES ('CU02', '#07004', 30);

INSERT INTO stock
VALUES ('CU02', '#07005', 30);

INSERT INTO stock
VALUES ('CU03', '#01004', 30);

INSERT INTO stock
VALUES ('CU03', '#01005', 30);

INSERT INTO stock
VALUES ('CU03', '#02004', 30);

INSERT INTO stock
VALUES ('CU03', '#02005', 30);

INSERT INTO stock
VALUES ('CU03', '#03004', 30);

INSERT INTO stock
VALUES ('CU03', '#03005', 30);

INSERT INTO stock
VALUES ('CU03', '#04004', 30);

INSERT INTO stock
VALUES ('CU03', '#04005', 30);

INSERT INTO stock
VALUES ('CU03', '#05004', 30);

INSERT INTO stock
VALUES ('CU03', '#05005', 30);

INSERT INTO stock
VALUES ('CU03', '#06004', 30);

INSERT INTO stock
VALUES ('CU03', '#06005', 30); 

INSERT INTO stock
VALUES ('CU03', '#07004', 30);

INSERT INTO stock
VALUES ('CU03', '#07005', 30);

INSERT INTO stock
VALUES ('CU04', '#01004', 30);

INSERT INTO stock
VALUES ('CU04', '#01005', 30);

INSERT INTO stock
VALUES ('CU04', '#02004', 30);

INSERT INTO stock
VALUES ('CU04', '#02005', 30);

INSERT INTO stock
VALUES ('CU04', '#03004', 30);

INSERT INTO stock
VALUES ('CU04', '#03005', 30);

INSERT INTO stock
VALUES ('CU04', '#04004', 30);

INSERT INTO stock
VALUES ('CU04', '#04005', 30);

INSERT INTO stock
VALUES ('CU04', '#05004', 30);

INSERT INTO stock
VALUES ('CU04', '#05005', 30);

INSERT INTO stock
VALUES ('CU04', '#06004', 30);

INSERT INTO stock
VALUES ('CU04', '#06005', 30); 

INSERT INTO stock
VALUES ('CU04', '#07004', 30);

INSERT INTO stock
VALUES ('CU04', '#07005', 30);

INSERT INTO stock
VALUES ('CU05', '#01004', 30);

INSERT INTO stock
VALUES ('CU05', '#01005', 30);

INSERT INTO stock
VALUES ('CU05', '#02004', 30);

INSERT INTO stock
VALUES ('CU05', '#02005', 30);

INSERT INTO stock
VALUES ('CU05', '#03004', 30);

INSERT INTO stock
VALUES ('CU05', '#03005', 30);

INSERT INTO stock
VALUES ('CU05', '#04004', 30);

INSERT INTO stock
VALUES ('CU05', '#04005', 30);

INSERT INTO stock
VALUES ('CU05', '#05004', 30);

INSERT INTO stock
VALUES ('CU05', '#05005', 30);

INSERT INTO stock
VALUES ('CU05', '#06004', 30);

INSERT INTO stock
VALUES ('CU05', '#06005', 30); 

INSERT INTO stock
VALUES ('CU05', '#07004', 30);

INSERT INTO stock
VALUES ('CU05', '#07005', 30);

commit;

