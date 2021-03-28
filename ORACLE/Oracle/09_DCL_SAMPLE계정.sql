


-- CREATE TABLE 할 수 있는 권한이 없어서 문제 발생
-- 오류 발생 "privileges" -> 권한에 관한 오류
-- 3_1. CREATE TABLE 권한 부여받기
-- 3_2. TABLESPACE 할당 받기
CREATE TABLE TEST(
    TEST_ID NUMBER,
    TEST_NAME VARCHAR2(20)
);

-- CREATE TABLE 권한 부여받는 순간부터 테이블들 바로 조작 가능
SELECT * FROM TEST;
INSERT INTO TEST VALUES(10, '안녕');

-- 뷰 객체를 생성할 수 있는 CREATE VIEW 권한이 없어서 문제 발생
-- 4. CREATE VIEW 권한 부여받기
CREATE VIEW VW_TEST
AS SELECT * FROM TEST;

SELECT * FROM VW_TEST;
--SELECT * FROM (SELECT * FROM TEST);

--------------------------------------------------------------------------------

-- KH계정의 EMPLOYEE테이블에 접근해서 조회할 수 있는 권한 없음
-- 5. SELECT ON KH.EMPLOYEE
SELECT * FROM KH.EMPLOYEE;

-- 6. INSERT ON KH.DEPARTMENT 권한 부여받기
INSERT INTO KH.DEPARTMENT
VALUES('D0', '회계부', 'L1');

ROLLBACK;












