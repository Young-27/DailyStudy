/*
    < VIEW 뷰 >
    
    SELECT문(쿼리문)을 저장해둘 수 있는 객체
    (자주 쓰는 긴 SELECT문을 저장해두면 그 긴 SELECT문을 매번 다시 기술할 필요없음!!)
    임시테이블 같은 존재 (실제 데이터가 담겨있는건 아님!! => 논리적인 테이블)
    
*/

-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회하시오
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
 WHERE NATIONAL_NAME = '한국';

-- '러시아'에서 근무하는 사원들 조회 
 SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
 WHERE NATIONAL_NAME = '러시아';
 
-- '일본'에서 근무하는 사원들 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
 WHERE NATIONAL_NAME = '일본';
 
 
--------------------------------------------------------------------------------
 
 /*
    1. VIEW 생성 방법
    
    [표현법]
    CREATE [OR REPLACE] VIEW 뷰명
    AS 서브쿼리;
    
    [OR REPLACE] : 뷰 생성이 기존에 중복된 이름의 뷰가 없다면 새로이 뷰를 생성하고,
                            기존에 중복된 이름의 뷰가 있다면 해당 뷰를 변경(갱신)하는 키워드
 */
 
CREATE OR REPLACE VIEW VW_EMPLOYEE
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS
     FROM EMPLOYEE E
     JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
     JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
     JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE);
 
GRANT CREATE VIEW TO KH; --> 관리자계정에서 실행할 것
 
SELECT *
FROM VW_EMPLOYEE; 
 
SELECT *
FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
        FROM EMPLOYEE E
        JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
        JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
        JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE));
 
-- 한국에서 근무하는 사원 사번, 이름, 부서명, 급여, 근무국가명
SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '한국';

-- 러시아에서 근무하는 사원들은?
SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '러시아';

-- 뷰는 논리적인 가상테이블 --> 실질적으로 데이터를 저장하고 있지 않음!! (단순히 쿼리문이 TEXT문구로 저장되어 있는것일 뿐!)

-- [참고]
SELECT * FROM USER_VIEWS;


--------------------------------------------------------------------------------

/*
    * 뷰 컬럼에 별칭 부여
      서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술되어있는 경우 반드시 별칭 지정 해야됨!
*/
-- 전체사원의 사번, 이름, 직급명, 성별(남/여), 근무년수를 조회할 수 있는 SELECT문을 뷰로 정의
CREATE OR REPLACE VIEW VW_EMP_JOB
AS SELECT EMP_ID, EMP_NAME, JOB_NAME,
          DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') "성별", 
          EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "근무년수"
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);

SELECT * FROM VW_EMP_JOB;

-- 아래와 같은 방식으로도 별칭부여가능 (단, 모든 컬럼에 대한 별칭을 부여해야됨!)
CREATE OR REPLACE VIEW VW_EMP_JOB(사번, 이름, 직급명, 성별, 근무년수)
AS SELECT EMP_ID, EMP_NAME, JOB_NAME,
          DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여'), 
          EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);

SELECT * 
FROM VW_EMP_JOB;

SELECT 이름, 직급명
FROM VW_EMP_JOB
WHERE 성별 = '여';

SELECT *
FROM VW_EMP_JOB
WHERE 근무년수 >= 20;

-- 뷰 삭제 하고자 한다면
DROP VIEW VW_EMP_JOB;

--------------------------------------------------------------------------------

-- 생성된 뷰를 이용해서 DML(INSERT, UPDATE, DELETE) 사용가능
-- 뷰를 통해서 조작하게 되면 실제 데이터가 담겨있는 베이스테이블에 적용됨

CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME
     FROM JOB;

SELECT * FROM VW_JOB;   -- 논리적인테이블(실제데이터가 담겨있지 않음)
SELECT * FROM JOB;      -- 베이스테이블(실제데이터가 담겨있는)

-- 뷰에 INSERT
INSERT INTO VW_JOB VALUES('J8', '인턴'); --> 베이스테이블에 값 INSERT

-- 뷰에 UPDATE
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8';

-- 뷰에 DELETE
DELETE FROM VW_JOB
WHERE JOB_CODE = 'J8';

--------------------------------------------------------------------------------

/*
    * 하지만 DML 명령어로 조작이 불가능한 경우가 더 많음
    
    1) 뷰에 정의되어있지 않은 컬럼을 조작하려고 하는 경우
    2) 뷰에 정의되어있지 않은 컬럼 중에 베이스테이블 상에 NOT NULL제약조건이 지정되어있는 경우
    3) 산술연산식 또는 함수식으로 정의된 경우
    4) 그룹함수나 GROUP BY절이 포함된 경우
    5) DISTINCT 구문이 포함된 경우
    6) JOIN을 이용해서 여러 테이블을 연결시켜놓은 경우
    
*/
-- 1) 뷰에 정의되어있지 않은 컬럼을 조작하려고 하는 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE
     FROM JOB;

SELECT * FROM VW_JOB;

INSERT INTO VW_JOB(JOB_CODE, JOB_NAME) VALUES('J8', '인턴'); --> 에러

-- J7 직급명을 인턴으로 변경
UPDATE VW_JOB
SET JOB_NAME = '인턴'
WHERE JOB_CODE = 'J7'; --> 에러

-- 사원 직급 지우기
DELETE FROM VW_JOB
WHERE JOB_NAME = '사원';


-- 2) 뷰에 정의되어있지 않은 컬럼 중에서 베이스테이블에 NOT NULL 제약조건이 지정된 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_NAME
     FROM JOB;

SELECT * FROM VW_JOB;

INSERT INTO VW_JOB VALUES('인턴'); -- 실제 베이스테이블에 INSERT시 (NULL, '인턴') -- 에러

-- 사원을 알바로 변경
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_NAME = '사원'; -- 성공

SELECT * FROM VW_JOB;
ROLLBACK;

-- 사원직급 지우기
DELETE FROM VW_JOB
WHERE JOB_NAME = '사원'; -- 이 데이터를 쓰고있는 자식데이터가 있기 때문에 삭제제한 / 단, 없다면 삭제 됨!


-- 3) 함수식 또는 산술연산식으로 정의된 경우

-- 사번, 사원명, 급여, 연봉에 대해서 조회하는 뷰
CREATE OR REPLACE VIEW VW_EMP_SAL
AS SELECT EMP_ID, EMP_NAME, SALARY, SALARY*12 "연봉"
     FROM EMPLOYEE;
     
SELECT * FROM VW_EMP_SAL;

INSERT INTO VW_EMP_SAL VALUES(400, '정진훈', 3000000, 36000000); -- 에러
INSERT INTO VW_EMP_SAL(EMP_ID, EMP_NAME, SALARY) VALUES(400, '정진훈', 3000000); -- 성공할수도 있는 구문이 맞긴하되, 뷰에 정의되어있지 않은 컬럼중 베이스테이블에 NOT NULL제약조건이 있어서 안됨

-- 200번 사원의 연봉을 8000만원으로
UPDATE VW_EMP_SAL
SET 연봉 = 80000000
WHERE EMP_ID = 200; -- 에러

-- 200번 사원의 급여를 700만원으로
UPDATE VW_EMP_SAL
SET SALARY = 7000000
WHERE EMP_ID = 200;

SELECT * FROM EMPLOYEE;

ROLLBACK;

-- 연봉이 7200만원인 사원 지우기
DELETE FROM VW_EMP_SAL
WHERE 연봉 = 72000000; -- 성공

ROLLBACK;

-- 4) 그룹함수 또는 GROUP BY절을 포함하는 경우
-- 부서별 급여합, 평균급여 조회하는 뷰
CREATE OR REPLACE VIEW VW_GROUPDEPT
AS SELECT DEPT_CODE, SUM(SALARY) "합계", FLOOR(AVG(SALARY)) "평균"
     FROM EMPLOYEE
     GROUP BY DEPT_CODE;

SELECT * FROM VW_GROUPDEPT;

INSERT INTO VW_GROUPDEPT VALUES('D0', 8000000, 4000000); -- 에러

-- D1을 D0으로 변경
UPDATE VW_GROUPDEPT
SET DEPT_CODE = 'D0'
WHERE DEPT_CODE = 'D1'; -- 에러

DELETE FROM VW_GROUPDEPT
WHERE DEPT_CODE = 'D1'; -- 에러

-- 5) DISTINCT 가 포함된 경우
CREATE OR REPLACE VIEW VW_DT_JOB
AS SELECT DISTINCT JOB_CODE
     FROM EMPLOYEE;
     
SELECT * FROM VW_DT_JOB;

INSERT INTO VW_DT_JOB VALUES('J8'); -- 에러

UPDATE VW_DT_JOB
SET JOB_CODE = 'J8'
WHERE JOB_CODE = 'J7'; -- 에러

DELETE FROM VW_DT_JOB
WHERE JOB_CODE = 'J2'; -- 에러


-- 6) JOIN을 이용해 여러 테이블을 연결한 경우
CREATE OR REPLACE VIEW VW_JOINEMP
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
     FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
     
SELECT * FROM VW_JOINEMP; 

INSERT INTO VW_JOINEMP VALUES(888, '조세오', '총무부'); -- 에러

-- 200번 사원의 이름을 서동일로 변경
UPDATE VW_JOINEMP
SET EMP_NAME = '서동일'
WHERE EMP_ID = 200; -- 성공

SELECT * FROM EMPLOYEE;

-- 200번 사원의 부서명을 회계부로 변경
UPDATE VW_JOINEMP
SET DEPT_TITLE = '회계부'
WHERE EMP_ID = 200; -- 에러

-- 200번 사원 지우기
DELETE FROM VW_JOINEMP
WHERE EMP_ID = 200; -- 성공

ROLLBACK;

--------------------------------------------------------------------------------

/*
    * VIEW 옵션
    
    [상세표현법]
    CREATE [OR REPLACE] [FORCE|"NOFORCE"] VIEW 뷰명
    AS 서브쿼리
    [WITH CHECK OPTION]
    [WITH READ ONLY];
    
    1) OR REPLACE : 기존에 동일한 뷰가 있을 경우 덮어씌우고, 존재하지 않으면 새로이 생성시켜주는
    2) FORCE / NOFORCE
       > FORCE   : 서브쿼리에 기술된 테이블이 존재하지 않아도 뷰가 생성되는 
       > NOFORCE : 서브쿼리에 기술된 테이블이 존재하는 테이블이여야만 뷰가 생성되게 하는 (생략시 기본값)
    3) WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합하지 않은 값으로 수정하는 경우 오류 발생
    4) WITH READ ONLY : 뷰에 대해 조회만 가능 (DML 수행불가)
*/

-- 2) FORCE/NOFORCE
-- NOFORCE : 서브쿼리에 기술된 테이블이 존재해야만 뷰가 생성 (생략시 기본값)
CREATE OR REPLACE /*NOFORCE*/ VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
     FROM TT;

-- FORCE : 서브쿼리에 기술된 테이블이 존재하지 않아도 뷰가 우선은 생성이 가능
CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
     FROM TT; --> 컴파일오류와 함께 뷰가 생성되었습니다.

SELECT * FROM VW_EMP;

--> TT테이블을 생성해야만 그때부터 VIEW 조회 가능
CREATE TABLE TT(
    TCODE NUMBER,
    TNAME VARCHAR2(30),
    TCONTENT VARCHAR2(50)
);

-- 3) WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합되지 않은 값으로 수정시 오류 발생
-- 급여가 300만원 이상인 사원
CREATE OR REPLACE VIEW VW_EMP
AS SELECT *
     FROM EMPLOYEE
    WHERE SALARY >= 3000000;
    
SELECT * FROM VW_EMP; --> 8명 조회

-- 200번 사원의 급여를 200만원으로 변경 --> 서브쿼리의 조건에 부합되지 않은 값으로 변경시도!
UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;

SELECT * FROM EMPLOYEE;
SELECT * FROM VW_EMP; --> 7명 조회

ROLLBACK;

CREATE OR REPLACE VIEW VW_EMP
AS SELECT *
     FROM EMPLOYEE
    WHERE SALARY >= 3000000
WITH CHECK OPTION;


UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200; --> 오류

UPDATE VW_EMP
SET SALARY = 4000000
WHERE EMP_ID = 200; --> 서브쿼리에 기술한 조건에 부합되기 때문에 변경 가능

ROLLBACK;

-- 4) WITH READ ONLY : 뷰에 대해 조회만 가능 (DML수행불가)
CREATE OR REPLACE VIEW VW_EMPBONUS
AS SELECT EMP_ID, EMP_NAME, BONUS
     FROM EMPLOYEE
    WHERE BONUS IS NOT NULL
WITH READ ONLY;

SELECT * FROM VW_EMPBONUS;

DELETE FROM VW_EMPBONUS
WHERE EMP_ID = 200;

-- 춘대학 04 SQL_DDL 문제 10번 ~ 14번
-- FINALWORKSHOP 13번










 
 
 
 
 
 
 
 
 