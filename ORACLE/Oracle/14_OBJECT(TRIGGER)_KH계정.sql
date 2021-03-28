/*
    < 트리거 TRIGGER >
    내가 지정한 테이블에 INSERT, UPDATE, DELETE 등의 DML문에 의해 변경될 경우 (테이블에 이벤트가 발생했을 경우)
    자동으로 매번 실행할 내용을 정의해둘 수 있는 객체
    데이터 무결성을 보장
    
    EX)
    입출고에 대한 데이터가 기록(INSERT)될 때마다 해당 상품에 대한 재고수량 매번 수정(UPDATE)해야된다거나
    회원탈퇴시 기존의 회원테이블에 데이터 DELETE 후 탈퇴된 회원들만 따로 보관하는 테이블에 자동 INSERT처리해야된다거나,
    신고횟수가 일정수를 넘었을 때 묵시적으로 블랙리스트 처리 되게끔
    
    
    * 트리거 종류
    - SQL문의 실행시기에 따른 분류
      > BEFORE TRIGGER : 내가 지정한 테이블에 이벤트가 발생되기 전에 트리거 실행 
      > AFTER TRIGGER : 내가 지정한 테이블에 이벤트가 발생한 후에 트리거 실행
      
    - SQL문에 의해 영향을 받는 각 행에 따른 분류
      > STATEMENT TRIGGER(문장트리거) : 이벤트가 발생한 SQL문에 대해 딱 한번만 트리거 실행
      > ROW TRIGGER(행트리거) : 해당 SQL문 실행할 때 마다 매번 트리거 실행
                               트리거 생성 구문 작성시 FOR EACH ROW옵션 기술해야됨
                        > :OLD   -  BEFORE UPDATE(수정전 자료), BEFORE DELETE(삭제전 자료)
                        > :NEW   -  AFTER INSERT(입력후 자료), AFTER UPDATE(수정후 자료)
    
    * 트리거 생성 구문
    
    [표현법]
                                  TRG_   
    CREATE [OR REPLACE] TRIGGER 트리거명
    BEFORE|AFTER    INSERT|UPDATE|DELETE    ON 테이블명
    [FOR EACH ROW]
    [DECLARE
        변수선언;]
    BEGIN
        실행내용; (해당 위에 지정된 이벤트 발생시 묵시적으로 자동으로 실행할 구문)
    [EXCEPTION
        예외처리구문;]
    END;
    /
    
*/

SET SERVEROUTPUT ON;
-- EMPLOYEE 테이블에 새로운 행이 INSERT 될때 마다 자동으로 메세지 출력되는 트리거 정의
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원님 환영합니다!');
END;
/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES(400, '이순신', '800618-2111111', 'D7', 'J7', SYSDATE);

INSERT 
  INTO EMPLOYEE
      (
         EMP_ID
       , EMP_NAME
       , EMP_NO
       , DEPT_CODE
       , JOB_CODE
       , HIRE_DATE
      )
VALUES
      (
         401
       , '길성춘'
       , '951009-2222222'
       , 'D5'
       , 'J7'
       , SYSDATE
      );

--------------------------------------------------------------------------------
-- * 트리거 만들지 않고 직접 해보는 과정 (번거롭고, 실수 발생가능성)
-- 상품 입고 및 출고 관련 예시
-- >> 필요한 테이블 및 시퀀스 생성

-- 1. 상품에 대한 데이터 보관할 테이블 (TB_PRODUCT)
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY,    -- 상품코드
    PNAME VARCHAR2(30) NOT NULL, -- 상품명
    BRAND VARCHAR2(30) NOT NULL, -- 브랜드명
    PRICE NUMBER,                -- 가격
    STOCK NUMBER DEFAULT 0       -- 재고수량
);

-- 상품코드 중복안되게 매번 새로운 번호 발생시키는 시퀸스 (SEQ_PCODE)
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5;


-- 샘플데이터 추가

INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시20', '샘송', 1400000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '아이폰12PRO', '사과', 1300000, 0);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '대륙폰', '샤우미', 600000, 20);


COMMIT;

-- 2. 상품 입출고 상세 이력 테이블 (TB_PRODETAIL)
--    어떤 상품이 어떤 날짜에 몇개가 입고 또는 출고가 되었는지 기록하는 테이블
CREATE TABLE TB_PRODETAIL(
    DCODE NUMBER PRIMARY KEY,           -- 상세이력코드번호
    PCODE NUMBER REFERENCES TB_PRODUCT, -- 상품코드
    PDATE DATE NOT NULL,                -- 상품입출고일
    AMOUNT NUMBER NOT NULL,             -- 입출고수량
    STATUS CHAR(6) CHECK(STATUS IN ('입고', '출고')) -- 상태(입고/출고)
);

-- 상세이력코드번호로 매번 새로운 번호 발생시켜서 들어갈 수 있게 도와주는 시퀀스 (SEQ_DCODE)
CREATE SEQUENCE SEQ_DCODE;

-- 200번 상품이 오늘날짜로 10개가 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 200, SYSDATE, 10, '입고');
-- 재고수량도 변경해야됨
UPDATE TB_PRODUCT
   SET STOCK = STOCK + 10
 WHERE PCODE = 200;
 
COMMIT;

-- 205번 상품이 오늘날짜로 20개가 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 205, SYSDATE, 20, '입고');

UPDATE TB_PRODUCT
   SET STOCK = STOCK + 20
 WHERE PCODE = 205;
 
COMMIT;

-- 200번 상품이 오늘날짜로 3개 출고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 200, SYSDATE, 3, '출고');

UPDATE TB_PRODUCT
   SET STOCK = STOCK - 3
 WHERE PCODE = 200;

COMMIT;
ROLLBACK;



-- TB_PRODETAIL 테이블에 INSERT 이벤트 발생시
-- TB_PRODUCT 테이블에 매번 자동으로 재고 수량 UPDATE 되게끔 트리거 정의
CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW
BEGIN
    -- 상품이 입고된 경우 => 재고수량 증가
    IF (:NEW.STATUS = '입고')
        THEN
            UPDATE TB_PRODUCT
               SET STOCK = STOCK + :NEW.AMOUNT
             WHERE PCODE = :NEW.PCODE;
    END IF;
    -- 상품이 출고된 경우 => 재고수량 감소
    IF (:NEW.STATUS = '출고')
        THEN
            UPDATE TB_PRODUCT
               SET STOCK = STOCK - :NEW.AMOUNT
             WHERE PCODE = :NEW.PCODE;
    END IF;
    
END;
/

-- 210번 상품이 오늘날짜로 9개 출고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 210, SYSDATE, 9, '출고');

-- 205번 상품이 오늘날짜로 100개가 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 205, SYSDATE, 100, '입고');





























