/*
    * SUBQUERY (서브쿼리)
    - 어떤 SQL문(SELECT, INSERT, UPDATE, DELETE, CREATE, ...) 안에 포함되어있는 또하나의 SELECT문
    - 메인 SQL문을 보조 역할 하는 SELECT문(쿼리문)
*/

-- 간단 서브쿼리 예시1. 노옹철 사원과 같은 부서에 있는 사원들의 이름 조회
-- 1) 먼저 노옹철 사원의 부서코드 조회
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'; --> D9부서구나!!

-- 2) 부서코드가 D9인 사원들 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

---> 위의 2단계를 하나의 쿼리문으로 합쳐보자!! (서브쿼리 적용 예시)
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '노옹철');


-- 간단 서브쿼리 예시2. 전직원의 평균급여보다 더 많은 급여를 받고 있는 사원들의 사번, 이름, 직급코드, 급여 조회
-- 1) 전체 직원의 평균 급여 조회
SELECT AVG(SALARY)
FROM EMPLOYEE; --> 대략 3047663원!

-- 2) 급여가 3047663원 이상인 사원들 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3047663;

---> 위의 2단계를 하나로 합치자!! (서브쿼리 적용)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY)
                 FROM EMPLOYEE);

---------------------------------------------------------------------------------

/*
    * 서브쿼리의 구분
      서브쿼리를 수행한 결과값이 몇행 몇열이냐에 따라 분류됨
      
      - 단일행 [단일열] 서브쿼리 : 서브쿼리의 조회 결과값의 갯수가 오로지 1개일 때 
      - 다중행 [단일열] 서브쿼리 : 서브쿼리의 조회 결과값이 여러행일 때
      - [단일행] 다중열 서브쿼리 : 서브쿼리의 조회 결과값이 한 행이되 컬럼이 여러개일 경우
      - 다중행 다중열 서브쿼리 : 서브쿼리의 조회 결과값이 여러행 여러 컬럼일 경우 
      
      > 서브쿼리의 결과값이 몇행 몇열이냐에 따라 사용가능한 연산자가 달라짐
*/

/*
    1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
       서브쿼리의 수행 결과값이 오로지 1개일 때 
       
       일반 비교연산자 사용 가능 (<, >, <=, >=, =, !=)
    
*/
-- 전 직원의 평균 급여보다 더 적게 받는 사원들의 사원명, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) --> 결과값 오로지 1개
                FROM EMPLOYEE);

-- 최저급여를 받고있는 사원의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) --> 결과값 오로지 1개
                FROM EMPLOYEE);

-- 노옹철 사원의 급여보다 더 많이 받는 사원들의 사번, 이름, 부서코드, 급여, "직급명"    조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철');

-- 전지연과 같은 부서인 사원들의 사번, 사원명, 전화번호, 부서명 조회 (단, 전지연은 제외)
SELECT EMP_ID, EMP_NAME, PHONE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
  AND DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                   WHERE EMP_NAME = '전지연')
  AND EMP_NAME != '전지연';


SELECT EMP_ID, EMP_NAME, PHONE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                   WHERE EMP_NAME = '전지연')
  AND EMP_NAME != '전지연';
  

-- 부서별 급여합이 가장 큰 부서 하나만을 조회 부서코드, 급여합 조회
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                       GROUP BY DEPT_CODE);

-- 각 부서별 급여합 중 가장 큰 값
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--------------------------------------------------------------------------------
/*
    2. 다중행 서브쿼리 (MULTI ROW SUBQUERY)
       서브쿼리를 수행한 결과값이 여러행일 때
       
       - IN 서브쿼리문 : 여러개의 결과값 중에서 한개라도 일치하는 값이 있다면
       
       - > ANY 서브쿼리문 : 여러개의 결과값 중에서 "한개라도" 클 경우 (여러개의 결과값 중에서 가장 작은값보다 클 경우)
       - < ANY 서브쿼리문 : 여러개의 결과값 중에서 "한개라도" 작을 경우 (여러개의 결과값 중에서 가장 큰 값보다 작을 경우)
        
            비교대상 > ANY (값1, 값2, 값3)
            비교대상 > 값1 OR 비교대상 > 값2 OR 비교대상 > 값3
            
            
       - > ALL 서브쿼리문 : 여러개의 결과값의 "모든" 값보다 클 경우 (여러개의 결과값 중에서 가장 큰 값보다 클 경우)
       - < ALL 서브쿼리문 : 여러개의 결과값의 "모든" 값보다 작을 경우 (여러개의 결과값 중에서 가장 작은 값보다 작을 경우)
       
        비교대상 > ALL (값1, 값2, 값3)
        비교대상 > 값1 AND 비교대상 > 값2 AND 비교대상 > 값3
       
*/

-- 유재식 또는 윤은해 사원과 같은 직급인 사원들 조회(사번, 사원명, 직급코드, 급여)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE --> 결과값 2행
                  FROM EMPLOYEE
                  WHERE EMP_NAME IN ('유재식', '윤은해'));
                  

-- 사원 => 대리 => 과장 => 차장 => 부장 => ...
-- 대리 직급임에도 불구하고 과장 직급의 급여보다 많이 받는 사원 조회 (사번, 이름, 직급명, 급여)
--SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY

-->> 과장 직급인 사원들의 급여 조회
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
  AND JOB_NAME = '과장'; -- 2200000, 2500000, 3760000
  
-->> 직급이 대리이면서 급여값이 위의 목록들 값 중에 하나라도 큰 사원
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
  AND SALARY > ANY (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '과장');
                    
                    
--> 단일행 서브쿼리로도 가능
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
  AND SALARY > ANY (SELECT MIN(SALARY) --> 결과값 오로지 한개
                    FROM EMPLOYEE
                    JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '과장');


-- 과장직급임에도 불구하고 차장 직급인 사원들의 모든 급여보다도 더 많이 받는 사원 (사번, 사원명, 직급명, 급여)
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장'
  AND SALARY > ALL (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING (JOB_CODE)
                    WHERE JOB_NAME = '차장');
                    
--------------------------------------------------------------------------------

/*
    3. 다중열 서브쿼리
       결과값은 한 행이지만 나열된 컬럼수가 여러개일 경우
*/
-- 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회 (사원명, 부서코드, 직급코드, 입사일)
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '하이유')
  AND JOB_CODE = (SELECT JOB_CODE
                  FROM EMPLOYEE
                  WHERE EMP_NAME = '하이유');

--> 다중열 서브쿼리로!
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                               FROM EMPLOYEE
                               WHERE EMP_NAME = '하이유');

-- 박나라 사원과 같은 직급코드, 같은 사수를 가지고 있는 사원들 조회(사번, 사원명, 직급코드, 사수사번)
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '박나라');
                                
--------------------------------------------------------------------------------

/*
    4. 다중행 다중열 서브쿼리
       서브쿼리 조회 결과값이 여러행 여러열일 경우
*/
-- 각 직급별 최소급여를 받는 사원 조회 (사번, 사원명, 직급코드, 급여)

-->> 각 직급별 최소급여 조회
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J2' AND SALARY = 3700000
   OR JOB_CODE = 'J7' AND SALARY = 1380000
   OR JOB_CODE = 'J3' AND SALARY = 3400000;
   
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) = ('J2', 3700000)
   OR (JOB_CODE, SALARY) = ('J7', 1380000)
   OR (JOB_CODE, SALARY) = ('J3', 3500000);

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                             FROM EMPLOYEE
                             GROUP BY JOB_CODE);
                             
-- 각 부서별 최고급여를 받는 사원들 사번, 사원명, 부서명, 급여
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE (NVL(DEPT_CODE, '없음'), SALARY) IN (SELECT NVL(DEPT_CODE, '없음'), MAX(SALARY) --> 결과값 7행 2열
                               FROM EMPLOYEE
                               LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                               GROUP BY DEPT_CODE);
                               
        -- DEPT_CODE = NULL AND SALARY = 2890000
        -- 비교대상 IN (값1, 값2) =>  비교대상 = 값1 OR 비교대상 = 값2

--------------------------------------------------------------------------------

/*
    5. 인라인 뷰 (INLINE-VIEW)
       FROM 절에 서브쿼리를 작성하는 것
       
       서브쿼리를 수행한 결과를 테이블 대신에 사용함!!
       
*/
-- 보너스포함 연봉이 3000만원 이상인 사원들의 사번, 이름, 보너스포함연봉(별칭부여), 부서코드를 조회
-- 단, 보너스포함연봉이 절대 NULL로 나오지 않도록!!
SELECT EMP_ID, EMP_NAME, (SALARY + SALARY * NVL(BONUS, 0)) * 12 "보너스포함연봉", DEPT_CODE -- 3
FROM EMPLOYEE -- 1
--WHERE 보너스포함연봉 >= 30000000; -- 2
WHERE (SALARY + SALARY * NVL(BONUS,0)) * 12 >= 30000000; 

SELECT EMP_NAME, 보너스포함연봉
FROM (SELECT EMP_ID, EMP_NAME, (SALARY + SALARY * NVL(BONUS, 0)) * 12 "보너스포함연봉", DEPT_CODE
        FROM EMPLOYEE)
WHERE 보너스포함연봉 >= 30000000;


-->> 인라인 뷰를 주로 사용하는 예 => TOP-N분석

-- 전 직원 중 급여가 가장 높은 상위 5명
-- * ROWNUM : 오라클에서 제공해주는 컬럼, 조회된 순서대로 1부터 순번을 부여해주는 컬럼
SELECT ROWNUM, EMP_NAME, SALARY -- 3
FROM EMPLOYEE           -- 1
WHERE ROWNUM <= 5       -- 2
ORDER BY SALARY DESC;   -- 4
-- => 정상적인 결과 조회되지 않음!! (정렬이 되기도 전에 5명이 추려지고 그리고 나서 정렬)

--> ORDER BY절이 다 수행된 결과를 가지고 ROWNUM부여 후 5명 추려야됨!!

SELECT ROWNUM, E.*
FROM (SELECT EMP_NAME, SALARY, DEPT_CODE
        FROM EMPLOYEE
    ORDER BY SALARY DESC) E
WHERE ROWNUM <= 5;

-- 가장 최근에 입사한 사원 5명 조회 사원명, 급여, 입사일
SELECT ROWNUM, E.*
FROM (SELECT EMP_NAME, SALARY, HIRE_DATE
        FROM EMPLOYEE
    ORDER BY HIRE_DATE DESC) E
WHERE ROWNUM <= 5;

-- 각 부서별 평균급여가 높은 3개의 부서의 부서코드, 평균 급여 조회
SELECT E.*
FROM (SELECT DEPT_CODE, FLOOR(AVG(SALARY))"평균급여"
        FROM EMPLOYEE
      GROUP BY DEPT_CODE
      ORDER BY 2 DESC) E
WHERE ROWNUM <= 3;

--------------------------------------------------------------------------------

/*
    6. 순위 매기는 함수 (WINDOW FUNCTION)
       RANK() OVER(정렬기준) / DENSE_RANK() OVER(정렬기준)
       
        - RANK() OVER(정렬기준) : 공동순위가 나왔을 경우 그 다음순위를 공동순위 개수만큼 건너띄워서 측정
                                 EX) 공동 1위가 3명이면 그 다음순위를 4위로
        - DENSE_RANK() OVER(정렬기준) : 공동순위가 몇명이 나왔던 간에 그 다음순위를 매번 1씩 증가시켜서 측정
                                       EX) 공동 1위가 3명이더라도 그 다음 순위는 2위로
                                       
                                       
       * SELECT절에서만 기입 가능                                
*/

-- 급여가 높은 순대로 순위를 매겨서 사원명, 급여, 순위 조회
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE;
--> 공동 19위 2명, 그 뒤의 순위 21위

SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE;
--> 공동 19위 2명, 그 뒤의 순위 20위

--> 상위 5명만 조회
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE
--WHERE 순위 <= 5;
WHERE RANK() OVER(ORDER BY SALARY DESC) <= 5; --> 오류 (순위매기는 함수는 SELECT절에만 사용가능)

--> 결국 인라인뷰로 조회해야됨!!
SELECT *
FROM (SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
        FROM EMPLOYEE)
WHERE 순위 <= 5;




















