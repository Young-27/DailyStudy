/*
    < 시퀀스 SEQUENCE >
    자동으로 번호 발생시켜주는 역할을 하는 객체
    정수값을 자동으로 순차적으로 일정값씩 증가시키면서 생성해줌
  
    EX) 회원번호, 사원번호, 학번, ...    
*/

/*
    1. 시퀀스 객체 생성 구문
    
    [표현법]
    CREATE SEQUENCE 시퀀스명;
    [START WITH 시작숫자]       --> 처음 발생시킬 시작값 지정 (기본값 1)
    [INCREMENT BY 숫자]        --> 몇씩 증가시킬 건지        (기본값 1)
    [MAXVALUE 숫자]            --> 최대값 지정              (기본값 겁나큼)
    [MINVALUE 숫자]            --> 최소값 지정              (기본값 1)
    [CYCLE|NOCYCLE]            --> 값 순환 여부 지정        (기본값 NOCYCLE)
    [NOCACHE|CACHE 바이트크기]  --> 캐시메모리 할당          (기본값 CACHE 20)
    
    * 캐시메모리 : 미리 발생될 값들을 생성해서 저장해둠
                  매번 호출될 때마다 새로이 번호를 생성한는게 아니라
                  캐시메모리 공간에 미리 생성된 값들을 가져다 쓰게 됨!! 속도가 빠름
                  접속이 해제되면 => 캐시메모리에 만들어 둔 번호는 날라감

    테이블명 : TB_
    시퀀스명 : SEQ_
    뷰명     : VW_
    트리거명 : TRG_
*/

CREATE SEQUENCE SEQ_TEST;

-- [참고] 현재 계정이 소유하고 있는 시퀀스들의 구조를 보고자 할 때
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

--------------------------------------------------------------------------------

/*
    2. SEQUENCE 사용 구문
    
    시퀀스명.CURRVAL : 현재 시퀀스의 값 (마지막으로 수행된 NEXTVAL의 값)
    시퀀스명.NEXTVAL : 시퀀스값을 증가시켜서 증가된 시퀀스 값
                      현재 시퀀스 값에서 INCREMENT BY값 만큼 증가된 값
                      == 시퀀스명.CURRVAL + INCREMENT BY값
                      

*/

SELECT SEQ_EMPNO.CURRVAL FROM DUAL;
-- NEXTVAL를 단 한번도 수행하지 않는 이상 CURRVAL를 할 수 없음!!
--> 왜? : CURRVAL은 마지막으로 성공적으로 수행된 NEXTVAL의 값을 저장해서 보여주는 임시값

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 300

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; --> 지정한 MAXVALUE값을 초과했기 때문에 오류 발생!! (실패!!)
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 310

--------------------------------------------------------------------------------

/*
    3. SEQUENCE 구조 변경
    
    [표현법]
    ALTER SEQUENCCE 시퀀스명
    [INCREMENT BY 숫자]
    [MAXVALUE 최대값]
    [MINVALUE 최소값]
    [CYCLE|NOCYCLE]
    [NOCACHE|CACHE 바이트수]
    
    * START WITH는 변경불가 !!
    
*/

ALTER SEQUENCE SEQ_EMPNO
INCREMENT BY 10
MAXVALUE 400;

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 320

-- SEQUENCE 삭제하기
DROP SEQUENCE SEQ_EMPNO;

--------------------------------------------------------------------------------


-- 매번 새로운 사번이 발생되게끔 시퀀스 생성
CREATE SEQUENCE SEQ_EID
START WITH 300;

INSERT 
  INTO EMPLOYEE
       (
        EMP_ID
      , EMP_NAME
      , EMP_NO
      , JOB_CODE
      , HIRE_DATE
      ) 
VALUES
      ( 
      SEQ_EID.NEXTVAL
    , '홍길동'
    , '111111-1111111'
    , 'J1'
    , SYSDATE 
    );

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE) 
VALUES( SEQ_EID.NEXTVAL, '김말똥', '111111-2222222', 'J2', SYSDATE );


























