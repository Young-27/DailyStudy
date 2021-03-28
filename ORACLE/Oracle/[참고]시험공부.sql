/*
    사원테이블에서 사원명, 직급코드, 보너스를 받는 사원수 조회
    직급코드별 오름차순 정렬하는 구문을 작성하고 싶음
*/
SELECT
        EMP_NAME
      , JOB_CODE
      , COUNT(*) AS "사원수"
FROM EMPLOYEE
WHERE BONUS != NULL
GROUP BY JOB_CODE
ORDER BY JOB_CODE;
-- * 문제점 2개
-- 문제점1. BONUS가 NULL이 아닌이라는 조건이 제대로 수행 안됨
-- 조치1. BONUS IS NOT NULL로 조건 수정

-- 문제점2. SELECT절에 그룹함수를 제외한 모든 컬럼을 GROUP BY절에 기술해야 하는데 그렇게 되지 않음
-- 조치2. GROUP BY절을 EMP_NAME, JOB_CODE로 제시해야됨

SELECT
        EMP_NAME
      , JOB_CODE
      , COUNT(*) AS "사원수"
FROM EMPLOYEE
WHERE BONUS IS NOT NULL
GROUP BY EMP_NAME, JOB_CODE
ORDER BY JOB_CODE;

--------------------------------------------------------------------------------

-- 사원 테이블에서 부서별 그룹을 짓고
-- 부서코드, 부서별급여합, 부서별평균급여(정수처리), 부서별사원수 조회 후 부서코드별로 정렬
-- 단, 평균급여가 2800000 초과인 부서만을 조회
SELECT
        DEPT_CODE
      , SUM(SALARY) "합계"
      , FLOOR(AVG(SALARY)) "평균"
      , COUNT(*) "사원수"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

--> 평균급여가 2800000 초과인 부서에 대해서만 조회하도록 하는 조건 누락
--> HAVING절을 이용해서 추가해야됨
SELECT
        DEPT_CODE
      , SUM(SALARY) 합계
      , FLOOR(AVG(SALARY)) 평균
      , COUNT(*) 사원수
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) > 2800000
ORDER BY DEPT_CODE;

--------------------------------------------------------------------------------

-- 데이터베이스 특징

-- GROUP BY / HAVING 절

-- 직원들의 급여를 인상시켜서 조회
-- 직급코드가 J7인 사원은 급여를 10% 인상해서 조회
--           J6인 사원은 급여를 15% 인상해서 조회
--           J5인 사원은 급여를 20% 인상해서 조회
-- 그 외의 직급 사원들은 급여를 5%로만 인상해서 조회
SELECT EMP_NAME, JOB_CODE, SALARY "기존급여", 
       DECODE(JOB_CODE, 'J7', SALARY*1.1, 
                        'J6', SALARY*1.15, 
                        'J5', SALARY*1.2,
                              SALARY*1.05) "인상된급여"
FROM EMPLOYEE;

--> CASE WHEN THEN 구문으로 변경
SELECT EMP_NAME, JOB_CODE, SALARY "기존급여",
        CASE WHEN JOB_CODE = 'J7' THEN SALARY*1.1
             WHEN JOB_CODE = 'J6' THEN SALARY*1.15
             WHEN JOB_CODE = 'J5' THEN SALARY*1.2
             ELSE SALARY*1.05
        END "인상된급여"
FROM EMPLOYEE;

SELECT GRADE "등급", AVG(SCORE) "평점"
FROM STUDENT
GROUP BY GRADE;

SELECT DEPT_CODE "등급", AVG(SALARY) "평균"
FROM EMPLOYEE
GROUP BY DEPT_CODE;
        
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY)>9000000;

SELECT DEPT "부서명", SUM(SALARY) "급여합"
FROM EMP
GROUP BY DPET
HAVING SUM(SALARY) > 9000000;

SELECT MERIT_RATING,
       SALARY,
       CASE WHEN MERIT_RATING = 'A' THEN SALARY * 0.2
            WHEN MERIT_RATING = 'B' THEN SALARY * 0.15
            WHEN MERIT_RATING = 'C' THEN SALARY * 0.1
            ELSE 0
        END "BONUS"
FROM EMPLOYEE;

        







