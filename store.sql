DROP TABLE grade;
DROP TABLE buy;
DROP TABLE purchase_list;
DROP TABLE pos;
DROP TABLE hq;
DROP TABLE store;
DROP TABLE product;
DROP TABLE member;

commit;

CREATE TABLE member
(
name VARCHAR2(16) CONSTRAINT member_name_NN NOT NULL,
phone VARCHAR2(20) CONSTRAINT member_phone_NN NOT NULL,
reserves NUMBER DEFAULT 0 CONSTRAINT member_reserves_NN NOT NULL,
mno NUMBER,
CONSTRAINT member_mno_PK PRIMARY KEY(mno),
CONSTRAINT member_name_CK CHECK (LENGTH(name)<=5),
CONSTRAINT member_phone_CK CHECK (REGEXP_LIKE (phone, '010-[0-9]{4}-[0-9]{4}'))
);

CREATE TABLE PRODUCT
(      
pno VARCHAR2(8),      
category VARCHAR2(20) CONSTRAINT product_category_nu NOT NULL,      
comp VARCHAR2(20) CONSTRAINT product_comp_nu NOT NULL,      
pname VARCHAR2(50) CONSTRAINT product_pname_nu NOT NULL,      
price NUMBER CONSTRAINT product_price_nu NOT NULL,      
stock NUMBER CONSTRAINT product_stock_nu NOT NULL, CONSTRAINT stock_plus check (stock>0),       
shelflife DATE , 
nowtime DATE DEFAULT SYSDATE,
event NUMBER,
CONSTRAINT product_shelflife_CK CHECK (shelflife > nowtime),     
CONSTRAINT product_pno_pk PRIMARY KEY(pno)
);

CREATE TABLE store
(
sno VARCHAR2(10),
mno NUMBER,
pno VARCHAR2(8),
sname VARCHAR2(18) CONSTRAINT store_store_name_NN NOT NULL,
address VARCHAR2(18) CONSTRAINT store_address_NN NOT NULL,
admin VARCHAR2(16) CONSTRAINT store_admin_NN NOT NULL,
CONSTRAINT store_sno_PK PRIMARY KEY(sno),
CONSTRAINT store_mno_FK FOREIGN KEY(mno) references member(mno),
CONSTRAINT store_pno_FK FOREIGN KEY(pno) references product(pno),
CONSTRAINT store_sname_UK UNIQUE (sname),
CONSTRAINT store_address_CK CHECK (address LIKE '%시 %구 %동')
);

CREATE TABLE hq
(
mno NUMBER,
sno VARCHAR2(10),
CONSTRAINT hq_mno_FK FOREIGN KEY(mno) references member(mno),
CONSTRAINT hq_sno_FK FOREIGN KEY(sno) references store(sno)
);

CREATE TABLE pos
(
pos_num VARCHAR2(20) CONSTRAINT store_pos_num_NN NOT NULL,
sno VARCHAR2(10),
CONSTRAINT store_pos_num_CK CHECK (REGEXP_LIKE (pos_num, 'POS-[0-9]{2}')),
CONSTRAINT pos_sno_FK FOREIGN KEY(sno) references store(sno)
);

CREATE TABLE purchase_list 
(
barcode VARCHAR2(20),
totalpay NUMBER CONSTRAINT purchase_list_payment_nu NOT NULL, 
posno NUMBER CONSTRAINT purchase_list_posno NOT NULL,
paytime DATE CONSTRAINT purchase_list_paytime_nu NOT NULL,
buyloc VARCHAR2(20) CONSTRAINT purchase_list_buyloc_nu NOT NULL,
payway VARCHAR2(10) CONSTRAINT purchase_list_payway_nu NOT NULL,
mno NUMBER,
CONSTRAINT purchase_list_barcode_pk PRIMARY KEY(barcode),
CONSTRAINT purchase_list_mno_fk FOREIGN KEY(mno) 
REFERENCES member(mno),
CONSTRAINT purchase_list_posno_ch CHECK (REGEXP_LIKE (posno, 'POS-[0-9]{2}'))
);

CREATE TABLE buy
(
productname VARCHAR2(20) CONSTRAINT buy_payproduct_NN NOT NULL,
paysum NUMBER CONSTRAINT buy_payment_NN NOT NULL ,
ordercount NUMBER CONSTRAINT buy_ordercount_NN NOT NULL,
barcode VARCHAR2(20) CONSTRAINT buy_barcode_NN NOT NULL,
CONSTRAINT buy_barcode_FK FOREIGN KEY (barcode) REFERENCES purchase_list(barcode)
); 

CREATE TABLE grade
(
rank VARCHAR2(12) DEFAULT 'Bronze' CONSTRAINT grade_rank_NN NOT NULL,
lowervalue NUMBER CONSTRAINT grade_lowervalue_NN  NOT NULL,
uppervalue NUMBER CONSTRAINT grade_uppervalue_NN  NOT NULL,
mileage NUMBER CONSTRAINT grade_mileage_NN NOT NULL
);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#01001', '간편식사', 'CU', '단짠불고기버거', 1900, 15, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#01002', '간편식사', 'CU', '보성녹돈정식', 5000, 15, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#01003', '간편식사', 'CU', '퀴노아바질샐러드', 1900, 15, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#02001', '즉석요리', 'CU', '잔슨빌핫도그', 1800, 20, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#02002', '즉석요리', 'CU', '베리타르트60g', 1200, 10, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#02003', '즉석요리', 'CU', '미트스틱', 1500, 10, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#03001', '과자류', '농심', '자갈치', 1500, 30, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#03002', '과자류', '크라운', '죠리퐁', 1500, 30, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#03003', '과자류', '오리온', '오뜨치즈6입', 3000, 20, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#04001', '아이스크림', '롯데', '스크류주물러', 1200, 50, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#04002', '아이스크림', '해태', '탱크보이', 1200, 50, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#04003', '아이스크림', '롯데', '월드콘초코', 1800, 50, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#05001', '식품', '풍림', '치즈계란말이', 2700, 15, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#05002', '식품', '풀무원', '얇은피꽉찬교자', 5500, 10, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#05003', '식품', 'cj', '동치미물냉면', 6000, 10, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#06001', '음료', '동서', '스타벅스돌체병', 2900, 30, '2020-10-31', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#06002', '음료', '롯데', '콘트라티그린', 2000, 15, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#06003', '음료', '서울', '달고나우유', 1500, 30, '2020-08-28', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, event)
VALUES ('#07001', '생활용품', '모나미', '일반수첩', 1100, 5, 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#07002', '생활용품', '크리오', '치약칫솔세트', 2700, 10, '2023-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, stock, shelflife, event)
VALUES ('#07003', '생활용품', 'pmc', '신신파스쿨', 3900, 10, '2021-08-17', 2);

col pno for a6
col category for a10
col comp for a6
col pname for a16
col stock for 999
col shelflife for a9
col nowtime for a9
col event for 9
col price for 99999









