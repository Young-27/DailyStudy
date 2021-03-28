/*
    < SELECT >
    데이터를 조회할 때 사용되는 언어 (DML,DQL)
    
    >> RESULT SET : SELECT문을 통해 조회된 결과물
    
    [표현법]
    SELECT 조회하고자하는컬럼명, 컬럼명, 컬럼명, ...
    FROM 테이블명;
    
*/

-- EMPLOYEE 테이블로부터 전체 사원의 모든 컬럼을 조회
SELECT *
FROM EMPLOYEE;

-- EMPLOYEE 테이블로부터 전체 사원의 사번, 사원명, 급여 컬럼만을 조회
SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE; 


select emp_id, emp_name, salary
from employee;
-- oracle 관련 키워드 또는 컬럼명, 테이블명 같은 경우 대소문자 가리지 않음! (맨 위 오른쪽에 있는 버튼 누르면 직접 입력하지 않고 바꿀 수 있다.)

-- DEPARTNENT 테이블로부터 전체 부서의 모든 컬럼(*) 조회
SELECT *
FROM DEPARTMENT;

-- JOB 테이블로부터 전체 직급의 모든 컬럼 조회
SELECT * FROM JOB;

--------------------- 실습문제 ------------------------------
-- 1. DEPARTMENT 테이블로부터 부서아이디, 부서명 컬럼만을 조회
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;

-- 2. JOB 테이블로부터 직급명 컬럼만을 조회
SELECT JOB_NAME
FROM JOB;

-- 3. EMPLOYEE 테이블로부터 사원명, 이메일, 전화번호, 입사일 컬럼만을 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;

--------------------------------------------------------------------------------

 /*
    < 컬럼값을 통한 산술연산 >
    
    SELECT 절에 산술연산자(+-/*) 기입해서 산술연산된 결과도 조회 가능
    
 */
 
 -- EMPLOYEE 테이블로부터 사원명, 급여, 연봉(급여*12) 조회
 SELECT EMP_NAME, SALARY, SALARY*12
 FROM EMPLOYEE;
 
 -- EMPLOYEE 테이블로부터 사원명, 급여, 보너스, 연봉, 보너스가 포함된 연봉((급여+보너스*급여)*12)
 SELECT EMP_NAME, SALARY, BONUS, SALARY*12, (SALARY + BONUS*SALARY)*12
 FROM EMPLOYEE;
 --> 산술연산 중에 NULL값이 존재할 경우 산술연산한 결과마저도 무조건 NULL값으로 조회됨!
 
 -- EMPLOYEE 테이블로부터 사원명, 입사일, 근무일수(오늘날짜 - 입사일)
 -- DATE 형식끼리도 연산 가능 (DATE형식 == 년월일시분초)
 -- 오늘날짜 : SYSDATE
 SELECT EMP_NAME, HIRE_DATE, FLOOR(SYSDATE-HIRE_DATE)
 FROM EMPLOYEE;
 
 -------------------------------------------------------------------------------
 
 /*
    < 컬럼명에 별칭 부여하기>
    
    [표현법]
    컬럼명 별칭, 컬럼명 "별칭", 컬럼명 AS 별칭, 컬럼명 AS "별칭"
    
    AS를 붙이든 안붙이든 간에
    부여하고자하는 별칭에 특수문자 또는 띄어쓰기가 포함될 경우 반드시 쌍따옴표로 묶어서 표현해야됨!!
  
 */
 
 -- EMPLOYEE테이블로부터 사원명, 급여, 연봉, 보너스포함연봉
 SELECT EMP_NAME 사원명
        , SALARY AS 급여
        , SALARY*12 연봉
        , (SALARY + (SALARY*BONUS))*12 AS "총 소득"
 FROM EMPLOYEE;
 
 -------------------------------------------------------------------------------
 
 
 
 /*
    < 리터럴 >
    임의로 지정한 문자열(' ')을 SELECT절에 기술하면
    마치 그 테이블에 존재하는 컬럼처럼 조회 가능
    
 */
 --EMPLOYEE 테이블로부터 사번, 사원명, 급여, 단위('원') 조회
 SELECT EMP_ID, EMP_NAME, SALARY, '원' "단위"
 FROM EMPLOYEE;
 --> SELECT절에 제시한 리터럴 값은 조회결과의 모든 행에 반복적으로 출력됨
 
 /*
    
        < 연결연산자 ||>
        여러 컬럼값들을 마치 하나의 컬럼인것처럼 연결시켜주는 연산자
        컬럼값과 리터럴 (임의의 문자열)을 연결해서 조회를 할 수도 있다!
        
        System.out.println("num : " + num) --> 자바에서의 느낌
 */
 SELECT EMP_ID, EMP_NAME, SALARY || '원' "급여" 
 FROM EMPLOYEE;
 
 -- XXX번 XXX의 월급은 XXXXXX원 입니다.
 SELECT EMP_ID || '번 ' || EMP_NAME || '의 월급은 ' || SALARY || '원 입니다.' "급여정보"
 FROM EMPLOYEE;
 
 -------------------------------------------------------------------------------
 
 /*
    < DISTINCT >
    컬럼에 포함된 중복값을 단 한번씩만 조회하고자 할 때 사용
    
    유의사항 : DISTINCT 키워드는 SELECT절에 단 한번만 기입 가능
 */
 -- EMPLOYEE테이블로부터 부서코드만 조회
 SELECT DISTINCT DEPT_CODE
 FROM EMPLOYEE;
 
 -- EMPLOYEE테이블로부터 직급코드만 조회
 SELECT DISTINCT JOB_CODE
 FROM EMPLOYEE;
 
 SELECT DISTINCT DEPT_CODE, JOB_CODE
 FROM EMPLOYEE;
 --> DEPT_CODE값이랑 JOB_CODE값이랑 세트로 묶여서 중복판별
 
 -------------------------------------------------------------------------------
 
 
 /*
    < WHERE 절 >
    조회하고자 하는 테이블에서
    내가 제시한 특정 조건에 만족하는 데이터들만을 조회하고자 할 때 기술하는 구문
    
    [표현법]
    SELECT 조회하고자하는컬럼명, 컬럼명, ... | *
    FROM 테이블명
    WHERE 조건식;
    
    * 조건식에 다양한 연산자들 사용 가능
    
 */
 
 /*
    < 비교 연산자 >
    >, <, >=, <=
          = 
     !=, ^=, <>
    
 */
 
-- EMPLOYEE 테이블로부터 급여가 4000000원 이상인 사원들만 조회 (모든 컬럼)
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE 테이블에서 부서코드가 D9인 사원들만 조회 (사원명, 부서코드, 급여)
SELECT EMP_NAME, DEPT_CODE, SALARY      -- 3
FROM EMPLOYEE                           -- (실행순서)1
WHERE DEPT_CODE = 'D9';                 -- 2
 
-- EMPLOYEE 테이블에서 부서코드가 D9가 아닌 사원들만 조회 (사원명, 부서코드, 급여)
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE != 'D9';
--WHERE DEPT_CODE ^= 'D9';
WHERE DEPT_CODE <> 'D9';


-------------------------- 실습문제 ---------------------------------------------
-- 1. EMPLOYEE 테이블로부터 급여가 300만원 이상인 사원들의 사원명, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. EMPLOYEE 테이블로부터 직급코드가 J2인 사원들의 사원명, 급여, 보너스 조회
SELECT EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE JOB_CODE = 'J2';

-- 3. EMPLOYEE 테이블로부터 현재 재직중인 사원들의 사번, 이름, 입사일, 퇴사여부 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, ENT_YN
FROM EMPLOYEE
WHERE ENT_YN='N';

-- 4. EMPLOYEE 테이블로부터 연봉이 5000만원 이상인 사원들의 사원명, 급여, 연봉(별칭), 입사일 조회
SELECT EMP_NAME, SALARY, SALARY*12 "연봉", HIRE_DATE  -- 3
FROM EMPLOYEE                    -- 1
--WHERE 연봉 >= 50000000          -- 2 (*순서때문에 연봉 사용불가)
WHERE SALARY*12 >= 50000000;
 --> WHERE 절에서는 SELECT절에 부여한 별칭 쓸 수 없음!!
 
 -------------------------------------------------------------------------------
 
 /*
    < 논리 연산자 >
    여러개의 조건을 엮을 때 사용
    
    AND(~이면서, 그리고), OR(~이거나, 또는)
    
 */
-- 부서코드가 'D9'이면서 급여값이 500만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' AND SALARY >= 5000000;

-- 부서코드가 'D6'이거나 아니면 급여가 300만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY >= 3000000;

-- 급여가 350만원 이상이고 600만원 이하인 사원들의 사원명, 급여, 직급코드
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;
 
 /*
    < BETWEEN AND >
    한 컬럼에 대해 몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 사용
    
    [표현법]
    비교대상컬럼명 BETWEEN 하한값 AND 상한값

 */
 
-- 급여가 350만원 이상이고 600만원 이하인 사원들의 사원명, 급여, 직급코드 조회
SELECT EMP_NAME, SALARY, JOB_CODE
FROM EMPLOYEE
--WHERE SALARY >= 3500000 AND SALARY <= 6000000;
WHERE SALARY BETWEEN 3500000 AND 6000000;


-- 급여가 350만원 이상 600만원 이하가 아닌 사람들 ~~~ (350만 미만이거나 600만 초과)
SELECT EMP_NAME, SALARY, JOB_CODE
FROM EMPLOYEE
--WHERE SALARY >= 3500000 AND SALARY <= 6000000;
--WHERE NOT SALARY BETWEEN 3500000 AND 6000000; -- NOT을 붙이면 해당 조건의 반대되는 조건
WHERE SALARY NOT BETWEEN 3500000 AND 6000000; --> 17행

-- DATE 형식간에도 사용 가능
-- 입사일이 '90/01/01' ~ '01/01/01'
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01'; --> 10행

--------------------------------------------------------------------------------

/*

    < IN >
    비교대상컬럼값에 내가 제시한 목록들 중에 일치하는 값이 하나라도 있을 경우
    
    
    [표현법]
    비교대상컬럼명 IN (값, 값, 값, ....)
*/
-- 부서코드가 D6이거나 D8이거나 D5인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D9' OR DEPT_CODE = 'D5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5'); --> 12행

-- 그 외의 사원들
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE NOT DEPT_CODE IN ('D6', 'D8', 'D5'); --> 9행
WHERE DEPT_CODE NOT IN ('D6', 'D8', 'D5');

--------------------------------------------------------------------------------

/*
    < IS NULL/ IS NOT NULL >
    
    NULL값 비교에 있어서는 일반비교연산자로 비교 불가!!
    
    [표현법]
    비교대상컬럼명 IS NULL : 해당 컬럼값이 NULL일 경우
    비교대상컬럼명 IS NOT NULL : 해당 컬럼값이 NULL이 아닐 경우
*/ 

SELECT * FROM EMPLOYEE;

-- 보너스를 받지 않는 사원(BONUSS컬럼값이 NULL인)들의 사번, 이름, 급여, 보너스
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS = NULL; -- 제대로 조회 안됨
WHERE BONUS IS NULL;

-- 보너스를 받는 사원(BONUS컬럼값이 NULL이 아닌)들의 사번, 이름, 급여, 보너스
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 사수가 없는 사원들의 사원명, 사수사번, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- 사수가 있는 사원들의 사원명, 사수사번, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

-- 사수도 없고 부서배치도 받지 않은 사원 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 부서배치를 받진 않았지만 보너스는 받는 사원 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

--------------------------------------------------------------------------------

/*
    < LIKE '특정패턴' >
    비교하려는 컬럼값이 내가 제시한 특정패턴에 만족될 경우 조회
    
    [표현법]
    비교대상컬럼명 LIKE '특정패턴'
    
    - 특정패턴에 '%', '_'를 와일드 카드로 사용할 수 있음
    > % : 0글자 이상
    EX) 비교대상컬럼명 LIKE '문자%' => 컬럼값 중에 '문자'로 "시작"되는걸 조회
        비교대상컬럼명 LIKE '%문자' => 컬럼값 중에 '문자'로 "끝"나는걸 조회
        비교대상컬럼명 LIKE '%문자%' => 컬럼값 중에 '문자'가 "포함"되는걸 조회
        
    > '_' : 1글자
    EX) 비교대상컬럼명 LIKE '_문자' => 컬럼값 중에 '문자'앞에 무조건 한글자가 올 경우 조회
        비교대상컬럼명 LIKE '__문자' => 컬럼값 중에 '문자'앞에 무조건 두글자가 올 경우 조회
        
*/

-- 성이 '전'씨인 사원들의 사원명, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- 이름 중에 '하'가 포함된 사원들의 사원명, 급여, 주민번호, 부서코드 조회
SELECT EMP_NAME, SALARY, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

SELECT * FROM EMPLOYEE; 
-- 전화번호 4번째 자리가 9인 사원들의 사번, 사원명, 주민번호, 부서코드 조회
SELECT EMP_ID, EMP_NAMEM, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- 이메일 컬럼값 중 _ 앞글자가 3글자인 이메일 주소를 가진 사원들 모든 컬럼 조회 => 이메일 4번째 자리가 _인 사원
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____%'; -- 제대로 조회안됨
-- 와일드카드로 사용되는 문자와 실제담겨있는 데이터값이 동일할 경우 문제 발생!! (와일드 카드로 해석돼버림!!)
-- 어떤게 와일드 카드고, 어떤게 데이터 값인지 구분 지어주면 됨!

-- 데이터값으로 인식시키고자하는 값 앞에 임의로 나만의 와일드 카드를 제시하고 나만의 와일드 카드를 ESCAPE 옵션으로 등록!
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '___!_%' ESCAPE '!';

/*
    [참고]
    SUBSTR 함수
    문자열로부터 특정 문자열을 추출해서 반환 (자바로 치면 문자열.substring(시작인덱스) / 문자열.substring(시작인덱스, 끝인덱스)
    
    SUBSTR(STRING, POSITION[, LENGTH])
    
    > STRING : 문자타입컬럼
    > POSITION : 문자열을 추출할 시작위치 값
    > LENGTH : 추출할 문자 개수 (생략시 끝까지 의미)
    
*/
SELECT EMP_NAME, PHONE, SUBSTR(PHONE, 4, 1)
FROM EMPLOYEE
WHERE SUBSTR(PHONE, 4, 1) = '9';

-- 이메일 4번째 자리가 _인 사원들
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE SUBSTR(EMAIL, 4, 1) = '_';

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) "성별"
FROM EMPLOYEE;

-- 남자사원들의 사원명, 급여, 보너스 조회
SELECT EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1';

--------------------------------------------------------------------------------

/*
    < 연산자 우선순위 >
    0. ()
    1. 산술연산자
    2. 연결연산자
    3. 비교연산자
    4. IS NULL   LIKE   IN
    5. BETWEEN AND
    6. NOT
    7. AND
    8. OR
*/
-- OR보다 AND가 먼저 수행됨!

-- 직급코드가 J7이거나 또는 J2인 사원들 중에서 급여가 200만원 이상인 사원들만 조회(모든 컬럼)  => 4개행이 조회되어야만함!!
SELECT *
FROM EMPLOYEE
WHERE  SALARY >= 2000000 AND (JOB_CODE = 'J7' OR JOB_CODE = 'J2'); -- 직급코드가 J2이면서 급여가 200만원이상인 애들 + 직급코드가 그냥 J7인 애들


------------------------------- 시험공부 ----------------------------------------

-- 직급코드가 J7이거나 또는 J2인 사원들 중에서
-- SALARY가 200만원이상이고
-- BONUS가 존재하지 않고
-- 남자이면서
-- 이메일 주소에 _문구 앞에 2두글자가 존재하는 사원의
-- EMP_NAME, EMP_NO, DEPT_CODE, SALARY, BONUS를 조회하시오.

SELECT EMP_NAME, EMP_NO, DEPT_CODE, SALARY, BONUS
FROM EMPLOYEE
WHERE JOB_CODE = 'J7' OR JOB_CODE = 'J2' AND SALARY > 2000000
     AND EMAIL LIKE '___&' AND BONUS IS NOT NULL;

-- 5가지의 문제점 찾아보기 => 해결
-- 문제점1. OR 연산이 먼저 수행되지 않음!
-- 문제점2. SALARY값에 대한 비교연산자가 잘못 제시되어있음 ("이상"이 아닌 "초과"로 되어있음)
-- 문제점3. 남자사원을 조회하는 조건이 누락되어있음
-- 문제점4. EMAIL값 비교에 있어서 패턴에 문제있음
-- 문제점5. "BONUS가 존재하지 않은" 인데 IS NOT NULL로 비교하고 있음
SELECT EMP_NAME, EMP_NO, DEPT_CODE, SALARY, BONUS
FROM EMPLOYEE
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') AND SALARY >= 2000000 
        AND SUBSTR(EMP_NO, 8, 1) = '1'
        AND EMAIL LIKE '__$_%' ESCAPE '$' 
        AND BONUS IS NULL;



-- 선**
-- 송**
-- ...
SELECT SUBSTR(EMP_NAME, 1, 1) || '**'
FROM EMPLOYEE; 

-- 사원명과 주민번호(951009-2****** 형식으로 조회)
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8) || '******' "주민번호"
FROM EMPLOYEE;


--시험 테스트
SELECT EMP_NAME, EMP_NO, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE='D9' OR DEPT_CODE='D6') AND SALARY>=3000000
        AND EMAIL LIKE '___!_%' ESCAPE '!' AND BONUS IS NOT NULL;
/*
    문제점1. OR 구문이 먼저 실행되지 않음
    문제점2. 300만원 이상인데 초과로 표시
    문제점3. 남자사원을 조회하는 조건이 누락되어있음
    문제점4. EMAIL값 비교에 있어서 패턴에 문제있음
    문제점5. 'BONUS가 존재하는'인데 IS NULL로 표기함
*/

SELECT * 
FROM EMPLOYEE 
WHERE BONUS IS NULL AND MANAGER_ID IS NOT NULL;
--1. SELECT 오타
--2. NULL값은 IS NULL / IS NOT NULL

SELECT DISTINCT SUBSTR(EMP_NAME, 1, 1)
FROM EMPLOYEE;

SELECT EMP_NAME "ENAME 사원명", SUBSTR(EMP_NO, 1, 8) || '******' "주민번호"
FROM EMPLOYEE;

--------------------------------------------------------------------------------
/*
    < ORDER BY 절 >
    SELECT문 가장 마지막에 기입하는 구문 (실행되는 순서 또한 마지막)
    
    [표현법]
    SELECT * | 컬럼명 [AS] "별칭", 컬럼명, 산술식, 함수식, ...
    FROM 조회할테이블명
    WHERE 조건식
    ORDER BY 정렬기준으로삼고자하는컬럼명|별칭|컬럼순번     [ASC|DESC] [NULLS FIRST|NULLS lAST];
    
    - ASC : 오름차순 정렬(생략시 기본값)
    - DESC : 내림차순 정렬
    
    -NULLS FIRST : 정렬하고자 하는 컬럼값에 NULL이 존재할 경우 해당 NULL들을 맨 앞쪽에 배치
    -NULLS LAST : 정렬하고자 하는 컬럼값에 NULL이 존재할 경우 해당 NULL들을 맨 뒤쪽에 배치
    
*/

--
SELECT *
FROM EMPLOYEE
--ORDER BY EMP_NAME; -- ASC 또는 DESC 생략시 기본값이 ASC(오름차순 정렬)
--ORDER BY BONUS ASC; -- ASC일 경우 기본적으로 NULLS LAST임
--ORDER BY BONUS ASC NULLS FIRST;
--ORDER BY BONUS DESC; -- DESC일 경우 기본적으로 NULLS FIRST임
ORDER BY BONUS DESC, SALARY ASC; --> 첫번째 제시한 정렬컬럼값이 동일 할 경우 두번째 제시한 정렬기준을 가지고 정렬



-- 전체 사원의 사원명, 연봉 조회 (연봉별 내림차순 정렬)
SELECT EMP_NAME, SALARY*12 "연봉"
FROM EMPLOYEE
--ORDER BY SALARY*12 DESC;
--ORDER BY 연봉 DESC; -- 별칭 사용 가능
ORDER BY 2 DESC, 1; -- 컬럼 순번 사용 가능
















