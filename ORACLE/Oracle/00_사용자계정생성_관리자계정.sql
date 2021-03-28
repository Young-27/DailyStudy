-- 한 줄 주석
/*

    여러줄
    주석
    
*/

-- 사용자개발을 만들 수 있는 권한은 오로지 관리자계정(sys as sysdba)에서만 가능!!

-- 새로운 사용자계정 생성하는 구문
-- [표현법] CREATE USER 계정명 IDENTIFIED BY 비밀번호;
CREATE USER KH IDENTIFIED BY KH;
-- 위의 과정 진행후 접속하려는데 접속이 되지 않고 테이블도 생성되지 않음!!

-- 새로이 생성된 계정은 어떠한 권한도 없는 상태!! (최소한의 권한정도는 부여해야됨)
-- 권한 부여시 작성하는 구문
-- [표현법] GRANT 권한1, 권한2, ... TO 계정명;
GRANT CONNECT, RESOURCE TO KH;
-- CONNECT : 접속할 수 있는 권한
-- RESOURCE : 테이블 생성할 수 있는 권한
