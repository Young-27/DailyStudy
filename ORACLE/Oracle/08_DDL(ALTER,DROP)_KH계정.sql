/*

        DDL(DATA DEFINITION LANGUAGE) : 데이터 정의 언어
        
        객체들을 생성(CREATE), 변경(ALTER), 삭제(DROP)하는 구문
        
        < ALTER >
        객체를 변경하는 구문
        
        >> 테이블 변경
        
        [표현식]
        ALTER TABLE 테이블명 변경할내용;
        
        - 변경할내용 -
        1) 컬럼 추가/수정/삭제
        2) 제약조건 추가/삭제   --> 수정은 불가 (수정하고자 한다면 삭제한 후 새로이 추가하면됨)
        3) 테이블명/컬럼명/제약조건명
        
*/

-- 1) 컬럼 추가/수정/삭제

-- 1_1) 컬럼 추가(ADD) : ADD 컬럼명 데이터타입
-- CNAME 컬럼 추가
ALTER TABLE DEPT_COPY ADD CNAME VARCHAR2(20);
--> 새로운 컬럼이 만들어지고 기본적으로 NULL로 채워짐

-- LNAME 컬럼 추가 (기본값을 지정한채로)
ALTER TABLE DEPT_COPY ADD LNAME VARCHAR2(40) DEFAULT '한국';
--> 새로운 컬럼이 만들어지고 내가 지정한 기본값으로 채워짐!

-- 1_2) 컬럼수정(MODIFIY)
--      > 데이터 타입 수정 : MODIFY 컬럼명 바꾸고자하는데이터타입
--      > DEFAULT값 수정 : MODIFY 컬럼명 DEFAULT 바꾸고자하는기본값

-- DEPT_ID 컬럼의 데이터 타입을 CHAR(3)로 변경
ALTER TABLE DEPT_COPY MODIFY DEPT_ID CHAR(3);
--ALTER TABLE DEPT_COPY MODIFY DEPT_ID NUMBER;
--ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR2(10);

-- DEPT_TITLE 컬럼을 VARCHAR2(40)로,
-- LOCATION_ID 컬럼을 VARCHAR2(2)로,
-- LNAME 컬럼의 기본값을 '미국'으로 변경
-- 다중 변경가능
ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE VARCHAR2(40)
MODIFY LOCATION_ID VARCHAR2(2)
MODIFY LNAME DEFAULT '미국';

ROLLBACK; -- DDL은 자동커밋,, ROLLBACK 안됨 !!

-- 1_3) 컬럼 삭제 (DROP COLUMN) : DROP COLUMN 삭제하고자하는컬럼명
DROP TABLE DEPT_COPY2 CASCADE CONSTRAINT;
CREATE TABLE DEPT_COPY2 AS SELECT * FROM DEPT_COPY;

-- DEPT_COPY2의 컬럼 지우기
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_ID;

ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_TITLE;
ALTER TABLE DEPT_COPY2 DROP COLUMN CNAME;
ALTER TABLE DEPT_COPY2 DROP COLUMN LNAME;

ALTER TABLE DEPT_COPY2 DROP COLUMN LOCATION_ID;
--> 삭제안됨 !! 최소 한개의 컬럼은 존재해야됨!!

--------------------------------------------------------------------------------

-- 2) 제약조건 추가 / 삭제

-- 2_1) 제약조건 추가
-- PRIMARY KEY : ADD PRIMARY KEY(컬럼명)
-- FOREIGN KEY : ADD FOREIGN KEY(컬럼명) REFERENCES 참조할테이블명[(컬럼명)]
-- UNIQUE      : ADD UNIQUE(컬럼명)
-- CHECK       : ADD CHECK(컬럼에 대한 조건)
-- NOT NULL    : MODIFY 컬럼명 NULL|NOT NULL

--> 제약조건명을 지어주고자 한다면 [CONSTRAINT 제약조건명] 제약조건

-- DEPT_COPY 테이블에
-- DEPT_ID에 PRIMARY KEY 제약조건 추가 ADD
-- DEPT_TITLE에 UNIQUE 제약조건 추가 ADD
-- LNAME에 NOT NULL 제약조건 추가 MODIFY
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DCOPY_PK PRIMARY KEY(DEPT_ID)
ADD CONSTRAINT DCOPY_UQ UNIQUE(DEPT_TITLE)
MODIFY LNAME CONSTRAINT DCOPY_NN NOT NULL;

-- 2_2) 제약조건 삭제 : DROP CONSTRAINT 제약조건명 / MODIFY 컬럼명 NULL (NOT NULL제약조건일경우)
ALTER TABLE DEPT_COPY DROP CONSTRAINT DCOPY_PK;

-- DCOPY_UQ 제약조건 지우기
-- LNAME NOT NULL 제약조건 지우기
ALTER TABLE DEPT_COPY
DROP CONSTRAINT DCOPY_UQ
MODIFY LNAME NULL;

--------------------------------------------------------------------------------

-- 3) 컬럼명/제약조건명/테이블명 변경 (RENAME)

-- 3_1) 컬럼명 변경 : RENAME COLUMN 기존컬럼명 TO 바꿀컬럼명

-- DEPT_TITLE => DEPT_NAME
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

-- 3_2) 제약조건명 변경 : RENAME CONSTRAINT 기존제약조건명 TO 바꿀제약조건명
-- SYS_C007237 --> DCOPY_LID_NN
ALTER TABLE DEPT_COPY RENAME CONSTRAINT SYS_C007237 TO DCOPY_LID_NN;

-- 3_3) 테이블 변경 : RENAME [기존테이블명] TO 바꿀테이블명
-- DEPT_COPY --> DEPT_TEST
ALTER TABLE DEPT_COPY RENAME TO DEPT_TEST;

--------------------------------------------------------------------------------

-- 테이블 삭제
DROP TABLE DEPT_TEST;

-- 단, 어딘가에서 참조되고 있는 부모테이블은 함부로 삭제안됨!!

-- 만약에 삭제하고자 한다면
-- 1. 자식테이블 먼저 삭제한 후 부모테이블 삭제하는 방법
-- 2. 아님 그냥 부모테이블만 삭제하는데 제약조건을 아싸리 같이 삭제하는 방법
DROP TABLE DEPT_TEST CASCADE CONSTRAINT;







