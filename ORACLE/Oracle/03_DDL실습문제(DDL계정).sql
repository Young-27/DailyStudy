-- 실습문제 --
-- 도서관리 프로그램을 만들기 위한 테이블들 만들기 --
-- 이때, 제약조건에 이름을 부여할 것 
--      각 컬럼에 주석달기



-- 1. 출판사들에 대한 데이터를 담기위한 출판사 테이블(TB_PUBLISHER) 
-- 컬럼 : PUB_NO(출판사번호) -- 기본키(PUBLISHER_PK)
--         PUB_NAME(출판사명) -- NOT NULL(PUBLISHER_NN)
--         PHONE(출판사전화번호) -- 제약조건 없음

CREATE TABLE TB_PUBLISHER(
    PUB_NO NUMBER CONSTRAINT PUBLISHER_PK PRIMARY KEY,
    PUB_NAME VARCHAR2(10) CONSTRAINT PUBLISHER_NN NOT NULL,
    PHONE VARCHAR2(20)
);

-- 3개 정도의 샘플 데이터 추가하기

INSERT INTO TB_PUBLISHER VALUES(1, '이선영', '010-1111-2222');
INSERT INTO TB_PUBLISHER VALUES(2, '홍길동', '010-3333-4444');
INSERT INTO TB_PUBLISHER VALUES(3, '이상해', NULL);


-- 2. 도서들에 대한 데이터를 담기위한 도서 테이블(TB_BOOK)
-- 컬럼 : BK_NO (도서번호) -- 기본키(BOOK_PK)
--         BK_TITLE (도서명) -- NOT NULL(BOOK_NN_TITLE)
--         BK_AUTHOR(저자명) -- NOT NULL(BOOK_NN_AUTHOR)
--         BK_PRICE(가격)
--         BK_PUB_NO(출판사번호) -- 외래키(BOOK_FK) (TB_PUBLISHER 테이블을 참조하도록)
--                                           이때 참조하고 있는 부모데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정

CREATE TABLE TB_BOOK(
    BK_NO NUMBER CONSTRAINT BOOK_PK PRIMARY KEY,
    BK_TITLE VARCHAR2(30) CONSTRAINT BOOK_NN_TITLE NOT NULL,
    BK_AUTHOR VARCHAR2(20) CONSTRAINT BOOK_NN_AUTHOR NOT NULL,
    BK_PRICE NUMBER,
    BK_PUB_NO NUMBER,
    CONSTRAINT BOOK_FK FOREIGN KEY (BK_PUB_NO) REFERENCES TB_PUBLISHER
    ON DELETE CASCADE
);

-- 5개 정도의 샘플 데이터 추가하기
INSERT INTO TB_BOOK VALUES(1, '자바', '어렵당', 20000, 2);
INSERT INTO TB_BOOK VALUES(2, '오라클', '김수경', 30000, 3);
INSERT INTO TB_BOOK VALUES(3, '심리학', 'SU', 20000, 1);
INSERT INTO TB_BOOK VALUES(4, '세계사', '이선영', 20000, NULL);
INSERT INTO TB_BOOK VALUES(5, '시집시켰당', '알라딘에서', 20000, NULL);




-- 3. 회원에 대한 데이터를 담기위한 회원 테이블 (TB_MEMBER)
-- 컬럼명 : MEMBER_NO(회원번호) -- 기본키(MEMBER_PK)
--            MEMBER_ID(아이디)   -- 중복금지(MEMBER_UQ)
--            MEMBER_PWD(비밀번호) -- NOT NULL(MEMBER_NN_PWD)
--            MEMBER_NAME(회원명) -- NOT NULL(MEMBER_NN_NAME)
--            GENDER(성별)        -- 'M' 또는 'F'로 입력되도록 제한(MEMBER_CK_GEN)
--            ADDRESS(주소)       
--            PHONE(연락처)       
--            STATUS(탈퇴여부)     -- 기본값으로 'N' 으로 지정, 그리고 'Y' 혹은 'N'으로만 입력되도록 제약조건(MEMBER_CK_STA)
--            ENROLL_DATE(가입일)  -- 기본값으로 SYSDATE, NOT NULL 제약조건(MEMBER_NN_EN)
CREATE TABLE TB_MEMBER(
    MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) CONSTRAINT MEMBER_UQ UNIQUE,
    MEMBER_PWD VARCHAR2(20) CONSTRAINT MEMBER_NN_PWD NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_NN_NAME NOT NULL,
    GENDER CHAR(1) CONSTRAINT MEMBER_CK_GEN CHECK(GENDER IN('M', 'F')),
    ADDRESS VARCHAR2(50), 
    PHONE VARCHAR2(50),
    STATUS CHAR(1) DEFAULT 'N' CHECK(STATUS IN ('Y', 'N')),
    ENROLL_DATE DATE DEFAULT SYSDATE CONSTRAINT MEMBER_NN_EN NOT NULL
);

SELECT * FROM TB_MEMBER;


-- 5개 정도의 샘플 데이터 추가하기
INSERT INTO TB_MEMBER VALUES(1, 'user01', 'pass01', '강하다', 'F', '경기도 화성시 진안동', '010-1234-5678', 'N', SYSDATE);
INSERT INTO TB_MEMBER VALUES(2, 'user02', 'pass02', '강한나', 'F', '경기도 수원시 진안동', '010-5234-5478', 'N', SYSDATE);
INSERT INTO TB_MEMBER VALUES(3, 'user03', 'pass03', '박보검', 'M', '서울', '010-5555-3678', 'N', SYSDATE);
INSERT INTO TB_MEMBER VALUES(4, 'user04', 'pass04', '현빈', 'M', '서울특별시 강남', '010-2344-1658', 'N', SYSDATE);
INSERT INTO TB_MEMBER VALUES(5, 'user05', 'pass05', '송강', 'M', '경기도 화성시 진안동', '010-1232-5321', 'N', SYSDATE);


-- 4. 어떤 회원이 어떤 도서를 대여했는지에 대한  대여목록 테이블(TB_RENT)
-- 컬럼 : RENT_NO(대여번호) -- 기본키(RENT_PK)
--         RENT_MEM_NO(대여회원번호) -- 외래키(RENT_FK_MEM)  TB_MEMBER와 참조하도록
--                                     이때 부모 데이터 삭제시 자식 데이터 값이 NULL이 되도록 옵션 설정
--         RENT_BOOK_NO(대여도서번호) -- 외래키(RENT_FK_BOOK)  TB_BOOK와 참조하도록
--                                      이때 부모 데이터 삭제시 자식 데이터 값이 NULL값이 되도록 옵션 설정
--         RENT_DATE(대여일) -- 기본값 SYSDATE

-- 샘플데이터 3개 정도  추가하기

CREATE TABLE TB_RENT(
    RENT_NO NUMBER CONSTRAINT RENT_PK PRIMARY KEY,
    RENT_MEM_NO NUMBER, 
    CONSTRAINT RENT_FK_MEM FOREIGN KEY (RENT_MEM_NO) REFERENCES TB_MEMBER ON DELETE SET NULL,
    RENT_BOOK_NO NUMBER,
    CONSTRAINT RENT_FK_BOOK FOREIGN KEY (RENT_BOOK_NO) REFERENCES TB_BOOK ON DELETE SET NULL,
    RENT_DATE DATE DEFAULT SYSDATE
);

DROP TABLE TB_RENT;

INSERT INTO TB_RENT VALUES(1, 2, 2, SYSDATE);
INSERT INTO TB_RENT VALUES(2, 3, 2, SYSDATE);
INSERT INTO TB_RENT VALUES(3, 4, 3, SYSDATE);

SELECT * FROM TB_RENT;

SELECT MEMBER_NAME, MEMBER_ID, RENT_DATE, RENT_DATE + 7 반납예정일
FROM TB_MEMBER
JOIN TB_RENT ON(RENT_MEM_NO = MEMBER_NO)
WHERE RENT_BOOK_NO = 2;

SELECT BK_TITLE, PUB_NAME, RENT_DATE, RENT_DATE + 7 반납예정일
FROM TB_RENT
JOIN TB_BOOK ON(RENT_BOOK_NO = BK_NO)
JOIN TB_PUBLISHER ON(BK_PUB_NO = PUB_NO)
WHERE RENT_MEM_NO = 2;





 