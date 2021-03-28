
/*
    < DCL : DATA CONTROLL LANGUAGE >
    데이터 제어 언어
    
    계정에게 시스템권한 또는 객체접근권한을 부여(GRANT)하거나 회수(REVOKE)하는 언어
    
    > 시스템권한 : DB에 접근하는 권한, 객체들을 생성할 수 있는 권한
    > 객체접근권한 : 특정 객체를 조작할 수 있는 권한
    
    
    > 시스템권한 종류 <
    - CREATE SESSION : 접속할 수 있는 권한
    - CREATE TABLE : 테이블을 생성할 수 있는 권한
    - CREATE VIEW : 뷰 생성할 수 있는 권한
    - CREATE SEQUENCE : 시퀀스 생성할 수 있는 권한
    - CREATE USER : 계정 생성할 수 있는 권한
    ...
    
    
*/

-- 1. SAMPLE/SAMPLE 계정 생성
CREATE USER SAMPLE IDENTIFIED BY SAMPLE;
-- 2. 접속하기 위해서 CREATE SESSION 권한 부여
GRANT CREATE SESSION TO SAMPLE;

-- 3_1. 테이블을 생성할 수 있는 CREATE TABLE 권한 부여
GRANT CREATE TABLE TO SAMPLE;
-- 3_2. TABLESPACE 할당! (SAMPLE계정 변경)
ALTER USER SAMPLE QUOTA 2M ON SYSTEM;

-- 4. CREATE VIEW 권한 부여하기
GRANT CREATE VIEW TO SAMPLE;

--------------------------------------------------------------------------------

/*
    > 객체 접근 권한 종류 <
    특정 객체에 접근해서 조작할 수 있는 권한
    
    권한종류        특정객체
    SELECT    TABLE, VIEW, SEQUENCE
    INSERT    TABLE, VIEW
    UPDATE    TABLE, VIEW
    DELETE    TABLE, VIEW
    ..
    
    [표현법]
    GRANT 권한종류 ON 특정객체 TO 계정명;
    
*/

-- 5. KH.EMPLOYEE테이블에 조회(SELECT)할 수 있는 권한 부여하기
GRANT SELECT ON KH.EMPLOYEE TO SAMPLE;

-- 6.
GRANT INSERT ON KH.DEPARTMENT TO SAMPLE;

--------------------------------------------------------------------------------

GRANT CONNECT, RESOURCE TO 계정명;

/*
    < 롤 ROLE >
    특정 권한들을 하나의 집합으로 모아놓은 것
    
    CONNECT : CREATE SESSION (접속할 수 있는 권한)
    RESOURCE : CREATE TABLE, CREATE SEQUENCE, ... (특정 객체들을 생성할 수 있는 권한)
*/

SELECT * 
FROM ROLE_SYS_PRIVS
WHERE ROLE IN ('CONNECT', 'RESOURCE')
ORDER BY ROLE; 












