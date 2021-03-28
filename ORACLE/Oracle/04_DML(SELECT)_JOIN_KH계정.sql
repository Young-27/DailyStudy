/*
    < JOIN >
    두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용되는 구문
    조회 결과는 하나의 결과물(RESULT SET)로 나옴
    
    관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고있음 (중복을 최소화하기 위해서)
    => JOIN 구문을 이용해서 여러개의 테이블 간 "관계"를 맺어서 조회해야됨!!
    
    무작정 JOIN을 해서 같이 조회하는게 아니라
    테이블 "연결고리"의 컬럼 데이터를 "매칭" 시켜서 조회해야됨!!
    
                        JOIN은 크게 "오라클 전용 구문"과 "ANSI(미국국립표준협회)구문"
                                        
                                        [ JOIN 용어 정리 ]
                                        
                    오라클 전용구문(오라클에서만)     |   ANSI 구문 (오라클+다른DBMS)
     ---------------------------------------------------------------------------------------------------
                        등가 조인                  |        내부 조인 (INNER JOIN)      --> JOIN USING|ON
                      (EQUAL JOIN)                |        자연 조인 (NATURAL JOIN)    --> JOIN USING
     ---------------------------------------------------------------------------------------------------
                        포괄 조인                  |        왼쪽 외부 조인 (LEFT OUTER JOIN)
                      (LEFT OUTER)                |      오른쪽 외부 조인 (RIGHT OUTER JOIN)
                      (RIGHT OUTER)               |        전체 외부 조인 (FULL OUTER JOIN)
     ---------------------------------------------------------------------------------------------------
                카테시안 곱 (CARTESIAN PRODUCT)    |             교차 조인 (CROSS JOIN)
     ---------------------------------------------------------------------------------------------------
     자체조인(SELF JOIN), 비등가조인(NON EQUAL JOIN) |               JOIN ON
   
*/

-- 각 사원들의 사번, 사원명, 부서코드, 부서명까지도 같이 알아내고자 한다면?
SELECT EMP_NO, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;

SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;

-- 각 사원들의 사번, 이름, 직급코드, 직급명도 같이 보고자한다면?
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE;

SELECT *
FROM JOB;

-- JOIN구문을 통해서 연결고리에 해당하는 컬럼값만 제대로 매칭만 해주면 하나의 결과물로 조회가능함!!!

/*
    1. 등가조인(EQUAL JOIN) / 내부조인(INNER JOIN)
       연결시키는 컬럼의 값이 일치하는 행들만 조인돼서 조회 (== 일치하는 값이 없는 행은 조회 X)
*/
-->> 오라클 전용 구문
--   FROM 절에 조회하고자 하는 테이블들을 나열 (, 구분자로)
--   WHERE 절에 매칭시킬 컬럼명(연결고리)에 대한 조건을 제시함

-- 사번, 사원명, 부서코드, 부서명 조회
-- 1) 연결시킬 두 컬럼명이 다른 경우 (EMPLOYEE:DEPT_CODE     /   DEPARTMENT:DEPT_ID)
SELECT EMP_NO, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;
--> 일치하지 않는 값들은 조회에서 제외된 것 확인 가능
--  (DEPT_CODE가 NULL인 2명의 사원데이터 조회안됨, DEPT_ID가 D3, D4, D7인 부서데이터 조회안됨)


-- 사번, 사원명, 직급코드, 직급명
-- 2) 연결시킬 두 컬럼명이 같은 경우 (EMPLOYEE:JOB_CODE  / JOB:JOB_CODE)
SELECT EMP_NO, EMP_NAME, JOB_CODE, JOB_NAME ---> 오류남
FROM EMPLOYEE, JOB
WHERE JOB_CODE = JOB_CODE;
--> ambiguously: 애매하다, 모호하다

--     해결방법1) 테이블명을 이용하는 방법
SELECT EMP_NO, EMP_NAME, EMPLOYEE.JOB_CODE, JOB_NAME 
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;

--     해결방법2) 별칭 사용 (각 테이블마다 별칭 부여가능)
SELECT EMP_NO, EMP_NAME, E.JOB_CODE, JOB_NAME 
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

-->> ANSI 구문
--   FROM절에 기준 테이블을 하나만 기술한 뒤
--   그 뒤에 JOIN절에서 같이 조회하고자 하는 테이블 기술 (또한 매칭시킬 컬럼에 대한 조건도 같이 기술)
--   => USING구문, ON 구문

-- 사번, 사원명, 부서코드, 부서명
-- 1) 연결할 두 컬럼명이 다른 경우 (EMPLOYEE:DEPT_CODE / DEPARTMENT:DEPT_ID)
--    => JOIN ON 구문만 사용가능!!!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
/*INNER*/JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 사번, 사원명, 직급코드, 직급명
-- 2) 연결할 두 컬럼명이 같은 경우 (EMPLOYEEE:JOB_CODE  /  JOB:JOB_CODE)
--    => JOIN ON구문, JOIN USING구문

--> ON구문 : ambiguously 발생가능
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);

--> USING 구문  : ambiguously 발생X
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

-- [참고] 위의 예시는 NATURAL JOIN(자연조인) 으로도 가능
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
NATURAL JOIN JOB;

-- * 추가적인 조건도 제시가능!!
-- 직급이 대리인 사원의 사번, 사원명, 급여 조회

-->> 오라클 구문 (FROM절에 조회할 테이블들 다 기술, WHERE절에 매칭시킬 컬럼에 대한 조건 기술
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
  AND JOB_NAME = '대리'
  AND SALARY >= 2500000;

--> ANSI 구문 (FROM절에 테이블 하나만 기술, JOIN절에 추가로 조회하고자 하는 테이블 및 매칭시킬 컬럼에 대한 조건 기술)
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';

----------------------------------- < 실습문제 > --------------------------------
-- 1. 부서가 인사관리부인 사원들의 사번, 사원명, 보너스를 조회
-->> 오라클 구문
SELECT EMP_NO, EMP_NAME, BONUS
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
  AND DEPT_TITLE = '인사관리부';

-->> ANSI 구문
SELECT EMP_NO, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '인사관리부';


-- 2. 부서가 총무부가 아닌 사원들의 사원명, 급여, 입사일 조회
-->> 오라클 구문
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
  AND DEPT_TITLE != '총무부';

-->> ANSI 구문
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE != '총무부';


-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명을 조회
-->> 오라클 구문
SELECT EMP_NO, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
  AND BONUS IS NOT NULL;

-->> ANSI 구문
SELECT EMP_NO, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL;

-- 4. DEPARTMENT와 LOCATION 테이블을 참고해서
--      각 부서의 부서코드, 부서명, 지역코드, 지역명
-->> 오라클 구문
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;

-->> ANSI 구문
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);

-- [응용] 사번, 사원명, 부서명, 직급명 조회
-->> 오라클 구문
SELECT EMP_NO, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE DEPT_CODE = DEPT_ID
  AND E.JOB_CODE = J.JOB_CODE;    

-->> ANSI 구문
SELECT EMP_NO, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

--------------------------------------------------------------------------------

/*
    2. 포괄조인 / 외부조인 (OUTER JOIN)
    
    테이블간에 JOIN시 일치하지 않은 행도 포함시켜서 조회 가능
    단, 반드시 어떤 테이블을 기준으로 해서 JOIN을 할건지 LEFT/RIGHT를 지정해야만 함
    
*/

-- 사원명, 급여, 부서명 조회
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- => 내부조인 (DEPT_CODE가 NULL인 2명의 사원 조회X, 부서에 배정된 사원이 없는 부서(D3, D4, D7) 조회X)


-- 1) LEFT OUTER JOIN : 두 테이블 중 왼편에 기술된 테이블 기준으로 JOIN
-->> ANSI구문

-- 사원명, 급여, 부서명 조회
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
LEFT /*OUTER*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
--> DEPT_CODE가 NULL이었던 사원 (이오리, 하동운)의 데이터 조회됨


-->> 오라클 구문 -- 기준으로 삼고자하는 테이블의 반대편 테이블의 컬럼에 (+)를 붙임
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);


-- 2) RIGHT [OUTER] JOIN : 두 테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
-->> ANSI 구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-->> 오라클 구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;


-- 3) FULL [OUTER] JOIN : 두 테이블이 가진 모든 행을 조회할 수 있음 (단, 오라클 구문으로는 안됨)
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);



--------------------------------------------------------------------------------

/*
    3. 비등가 조인 (NON EQUAL JOIN)
    '='(등호)를 사용하지 않는 조인문
    
    지정한 컬럼값이 일치하는 경우가 아닌, 값의 "범위"에 포함되는 경우 매칭
    
*/

-- 사원명, 급여, 급여등급(SAL_LEVEL)
SELECT EMP_NAME, SALARY
FROM EMPLOYEE;

SELECT *
FROM SAL_GRADE;

-->> 오라클 구문
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE, SAL_GRADE
--WHERE SALARY >= MIN_SAL AND SALARY <= MAX_SAL;
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

-->> ANSI 구문 (JOIN ON구문으로만 가능!!)
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);

--------------------------------------------------------------------------------

/*
    < 다중 JOIN >
*/

-- 사번, 사원명, 부서명, 근무지역명(LOCAL_NAME)

-->> 오라클 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID
  AND LOCATION_ID = LOCAL_CODE;

-->> ANSI구문
SELECT EMP_NO, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);




------------------------------ [ 숙제 ]------------------------------------------
-- 컴퓨터 강제종료 때문에 다 날라갔네........


-- 1. 직급이 대리이면서 ASIA지역에 근무하는 직원들의
--    사번, 사원명, 직급명, 부서명, 근무지역명, 급여를 조회하시오
-- 오라클 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE, JOB, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID
  AND LOCAL_CODE = LOCATION_ID
  AND JOB_NAME = '대리'
  AND LOCAL_NAME IN ('ASIA1', 'ASIA2', 'ASIA3');
  
  --왜 2행밖에 안나오지?>
  -- ANSI 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
  AND LOCAL_NAME IN ('ASIA1', 'ASIA2', 'ASIA3');


-- 2. 70년대생이면서 여자이고, 성이 전씨인 직원들의
--    사원명, 주민번호, 부서명, 직급명을 조회하시오
-- 오라클 구문
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT D, JOB J
WHERE DEPT_CODE = DEPT_ID
  AND E.JOB_CODE = J.JOB_CODE
  AND SUBSTR(EMP_NO, 1, 1) = '7'
  AND SUBSTR(EMP_NAME, 1, 1) = '전';
  
-- ANSI 구문
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE SUBSTR(EMP_NO, 1, 1) = '7'
  AND SUBSTR(EMP_NAME, 1, 1) = '전';
  

-- 3. 이름에 '형'자가 들어있는 직원들의
--    사번, 사원명, 직급명을 조회하시오
-- 오라클구문



-- ANSI구문


-- 4. 해외영업팀에 근무하는 직원들의
--    사원명, 직급명, 부서코드, 부서명을 조회하시오

-- 5. 보너스를 받는 직원들의
--    사원명, 보너스, 연봉, 부서명, 근무지역명을 조회하시오

-- 6. 부서가 있는 직원들의
--    사원명, 직급명, 부서명, 근무지역명을 조회하시오

-- 7. '한국'과 '일본'에 근무하는 직원들의 
--    사원명, 부서명, 근무지역명, 근무국가명을 조회하시오

-- 8. 보너스를 받지 않는 직원들 중 직급코드가 J4 또는 J7인 직원들의
--    사원명, 직급명, 급여를 조회하시오

-- 9. 사번, 사원명, 직급명, 급여등급, 구분을 조회하는데
--    이때 구분에 해당하는 값은
--    급여등급이 S1, S2인 경우 '고급'
--    급여등급이 S3, S4인 경우 '중급'
--    급여등급이 S5, S6인 경우 '초급' 으로 조회되게 하시오.

-- 10. 각 부서별 총 급여합을 조회하되
--     이때, 총 급여합이 1000만원 이상인 부서명, 급여합을 조회하시오

-- 11. 각 부서별 평균급여를 조회하여 부서명, 평균급여 (정수처리)로 조회하시오.
--      단, 부서배치가 안된 사원들의 평균도 같이 나오게끔 하시오.






















