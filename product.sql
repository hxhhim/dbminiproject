INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#01001', '간편식사', 'CU', '단짠불고기버거', 1900, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#01002', '간편식사', 'CU', '보성녹돈정식', 5000, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#01003', '간편식사', 'CU', '퀴노아바질샐러드', 1900, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#02001', '즉석요리', 'CU', '잔슨빌핫도그', 1800, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#02002', '즉석요리', 'CU', '베리타르트60g', 1200, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#02003', '즉석요리', 'CU', '미트스틱', 1500, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#03001', '과자류', '농심', '자갈치', 1500, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#03002', '과자류', '크라운', '죠리퐁', 1500, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#03003', '과자류', '오리온', '오뜨치즈6입', 3000, '2021-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#04001', '아이스크림', '롯데', '스크류주물러', 1200, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#04002', '아이스크림', '해태', '탱크보이', 1200, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#04003', '아이스크림', '롯데', '월드콘초코', 1800, '2021-04-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#05001', '식품', '풍림', '치즈계란말이', 2700, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#05002', '식품', '풀무원', '얇은피꽉찬교자', 5500, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#05003', '식품', 'cj', '동치미물냉면', 6000, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#06001', '음료', '동서', '스타벅스돌체병', 2900, '2020-10-31', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#06002', '음료', '롯데', '콘트라티그린', 2000, '2020-08-27', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#06003', '음료', '서울', '달고나우유', 1500, '2020-08-28', 2);

INSERT INTO product (pno, category, comp, pname, price, event)
VALUES ('#07001', '생활용품', '모나미', '일반수첩', 1100, 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#07002', '생활용품', '크리오', '치약칫솔세트', 2700, '2023-08-17', 2);

INSERT INTO product (pno, category, comp, pname, price, shelflife, event)
VALUES ('#07003', '생활용품', 'pmc', '신신파스쿨', 3900, '2021-08-17', 2);

col pno for a6
col category for a10
col comp for a6
col pname for a16
col stock for 999
col shelflife for a9
col nowtime for a9
col event for 9
col price for 99999

commit;