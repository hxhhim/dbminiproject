INSERT INTO grade VALUES('diamond', 30000, 1000000, 4);
INSERT INTO grade VALUES('gold', 15000, 30000, 3);
INSERT INTO grade VALUES('silver', 5000, 15000, 2);
INSERT INTO grade VALUES('bronze', 0, 5000, 1);

commit;

col rank for a10
col lowervalue for 99999
col uppervalue for 9999999
col mileage for 9
commit;

SELECT mno, name, rank, mileage FROM grade, member 
WHERE reserves >= LOWERVALUE AND reserves < UPPERVALUE;