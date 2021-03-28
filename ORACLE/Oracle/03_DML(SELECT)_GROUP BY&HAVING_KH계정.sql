/*
    < GROUP BY 절 >
    직접 그룹기준을 제시할 수 있는 구문 (해당 그룹기준별로 그룹을 묶어줄 수 있음!!
*/

-- 전체 사원의 총 급여합
SELECT SUM(SALARY)
FROM EMPLOYEE; --> 전체 사원들을 하나의 그룹으로 묶어서 총합을 구한 결과 (그룹 한개)

-- 각 부서별 급여합
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 전체 사원 수
SELECT COUNT(*)
FROM EMPLOYEE;

-- 각 부서별 사원수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 각 부서별 급여합을 부서코드별 오름차순 정렬해서 조회
SELECT DEPT_CODE, SUM(SALARY)   -- 3. SELECT절
FROM EMPLOYEE                   -- 1. FROM절
GROUP BY DEPT_CODE              -- 2. GROUP BY절
ORDER BY DEPT_CODE;             -- 4. ORDER BY절

SELECT DEPT_CODE, SUM(SALARY), COUNT(*)
FROM EMPLOYEE                   
GROUP BY DEPT_CODE              
ORDER BY DEPT_CODE;

-- 각 직급별 직급코드, 급여합, 사원수, 보너스를 받는 수, 평균급여, 최고급여, 최저급여
SELECT 
       JOB_CODE "직급"
     , SUM(SALARY) "급여합"
     , COUNT(*) "사원수"
     , COUNT(BONUS) "보너스받는사원수"
     , ROUND(AVG(SALARY)) "급여평균"
     , MAX(SALARY)"최고급여" 
     , MIN(SALARY) "최저급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY 직급;

-- * 여러 칼럼을 그룹기준으로 제시 가능
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY),COUNT(*)
  FROM EMPLOYEE
 GROUP BY DEPT_CODE, JOB_CODE;
 
 -- * 함수식을 그룹기준으로 제시 가능
 -- 성별별 사원수, 급여합
 SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') "성별", COUNT(*) "사원수", SUM(SALARY) "급여합"
   FROM EMPLOYEE
  GROUP BY (SUBSTR(EMP_NO, 8, 1));

-- 입사년도별 입사년도, 사원수 (입사년도별 오름차순)
SELECT EXTRACT(YEAR FROM HIRE_DATE) "입사년도", COUNT(*)
FROM EMPLOYEE
GROUP BY EXTRACT(YEAR FROM HIRE_DATE)   -- TO_CHAR(HIRE_DATE, 'YYYY') 단, SELECT절에도 동일하게 기술
ORDER BY 1;

--------------------------------------------------------------------------------


/*
    < HAVING 절 >
    그룹에 대한 조건을 제시할 때 사용되는 구문 (주로 그룹함수를 가지고 조건식 작성)
*/

-- 각 부서별 평균 급여 조회 (단, 평균급여가 300만원 이상인 부서만을 조회)
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
--WHERE AVG(SALARY) >= 3000000
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;

 -- 각 직급별 급여합이 1000만원 이상인 직급만을 조회 (직급코드, 급여합)
 SELECT JOB_CODE "직급코드", SUM(SALARY) "급여합"
 FROM EMPLOYEE
 GROUP BY JOB_CODE
 HAVING SUM(SALARY) >= 10000000;
 
 -- 각 부서별 보너스를 받는 사원이 없는 부서만을 조회 (부서코드)
SELECT DEPT_CODE "부서코드"
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

 -- 입사년도별 입사한 사원수가 2명 이상인 입사년도를 조회
 SELECT EXTRACT(YEAR FROM HIRE_DATE) "입사년도", COUNT(*)
 FROM EMPLOYEE
 GROUP BY EXTRACT(YEAR FROM HIRE_DATE)
 HAVING COUNT(*) >= 2;
 
--------------------------------------------------------------------------------

/*
    < 실행 순서 >
    5 : SELECT *|조회하고자하는컬럼명|산술연산식|함수식 [AS] "별칭"
    1 : FROM 조회하고자 하는 테이블명
    2 : WHERE 조건식
    3 : GROUP BY 그룹기준으로 삼고자 하는 컬럼명|함수식
    4 : HAVING 그룹을 지은걸 가지고 조건식
    6 : ORDER BY 컬럼명|별칭|컬럼순번 [ASC|DESC]     [NULLS FIRST|NULLS LAST]
    
*/

--------------------------------------------------------------------------------

-- 각 부서별 급여합 (급여합)
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 위의 결과 집합연산자를 가지고 조회
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL
UNION
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1'
UNION
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'
UNION
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';



/*
    < 집합 연산자 (SET OPERATION)>
    여러개의 쿼리문을 가지고 하나의 쿼리문으로 만드는 연산자
    
    - UNION     : 합집합 (두 쿼리문 수행한 결과값을 더한 후 중복되는 부분 한 번 뺀 것) OR
    - INTERSECT : 교집합 (두 쿼리문 수행한 결과값에 중복된 결과값) AND
    - UNION ALL : 합집합 결과값에 교집합이 더해진 개념 (두 쿼리문 수행한 결과값을 무조건 더함 => 중복된 값이 여러번 들어갈 수 있음)
    - MINUS     : 차집합 (선행 쿼리문 결과값 빼기 후행 쿼리문 결과값)
    
*/
-- 1. UNION
-- 부서코드가 D5이거나 또는 급여가 300만원 초과인 사원들 조회 (사번, 이름, 부서코드, 급여)

-- 부서코드가 D5인 사원들만 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'; --> 6명 조회

-- 급여가 300만원 초과인 사원들만 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; --> 8명 조회 (위의 SELECT결과와 겹치는 부분이 2개 행)

-- UNION 
-- 결과 => 12행(중복된 2행 빠짐)
-- SELECT 절의 컬럼 개수 같아야함
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6행
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8행

-- 위의 UNION문 대신에 하나의 SELECT문으로도 기술가능하긴함
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
   OR SALARY > 3000000;

-- 2. UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6행
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8행

-- 3. INTERSECT
-- 부서코드가 D5이면서 그리고 급여까지도 300만원 초과인 사원
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6행
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8행

-- 아래처럼도 가능하긴함!!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

-- 4. MINUS
-- 부서코드가 D5인 사원들 중 급여가 300만원 초과인 사원을 제외해서 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; 

-- 아래처럼도 가능하긴함!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY <= 3000000;


















