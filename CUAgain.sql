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
ploc VARCHAR2(20) CONSTRAINT purchase_list_ploc_NN NOT NULL,
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

commit;