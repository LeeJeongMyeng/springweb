CREATE TABLE gamescore(
name varchar2(20),
score NUMBER,
registdate date
);

INSERT INTO gamescore VALUES('이정명',128,sysdate);

SELECT * FROM GAMESCORE;

SELECT name,score,
TO_CHAR(registdate,'YYYY/MM/DD - HH24"시"MI"분"')
FROM gamescore;