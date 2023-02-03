select d.*,s.* from dept d,salgrade s;
SELECT * FROM EMP e ;
select id user99, pass password99,authority auth  from MEMBER;
SELECT * FROM dept WHERE deptno=20;

SELECT * FROM member100;

INSERT INTO member100 VALUES('aoddl56','','','',0,sysdate);

SELECT * FROM PRODUCT p ;




DROP TABLE member111;

SELECT * FROM product111;
SELECT * FROM member111;
SELECT * FROM buyinfo111;

INSERT INTO product111 values('1000','사과',2000,100);
CREATE TABLE product111(
 pid varchar2(100) PRIMARY KEY,
 name varchar2(100),
 price NUMBER,
 cnt number
);
INSERT INTO member111 values('himan','7777','홍길동','관리자');
CREATE TABLE member111(
mid varchar2(100) PRIMARY KEY,
pass varchar2(100),
name varchar2(100),
auth varchar2(100)
);
INSERT INTO buyinfo111 values('1000','himan',5,sysdate);
CREATE TABLE buyinfo111(
pid varchar2(100),
mid varchar2(100),
bcnt NUMBER,
buydate date
);

-- 0126 마지막문제
SELECT p.name pname,price,m.mid,m.pass,m.name,auth,b.bcnt 
FROM product111 p, member111 m, buyinfo111 b
WHERE p.pid = b.pid
AND m.mid=b.mid;