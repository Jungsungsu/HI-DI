select * from T_member;
select * from T_CHECKLIST;
select * from T_DISEASE;
select * from T_raw;
select check_name from t_checklist
select * from t_hospital WHERE hos_dpt='종합' or hos_dpt = null;
select * from T_POLL;

select * from t_disease where dis_code = 'G47';



-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- t_member Table Create SQL
CREATE TABLE t_member
(
    mb_id           VARCHAR2(20)     NOT NULL, 
    mb_pw           VARCHAR2(20)     NOT NULL, 
    mb_email        VARCHAR2(50)     NOT NULL, 
    mb_name         VARCHAR2(20)     NOT NULL, 
    mb_gender       VARCHAR2(1)      NOT NULL, 
    mb_phone        VARCHAR2(20)     NOT NULL, 
    mb_birthdate    DATE             NOT NULL, 
    mb_addr         VARCHAR2(150)    NOT NULL, 
    mb_joindate     DATE             DEFAULT SYSDATE NOT NULL, 
    admin_yn        VARCHAR2(1)      NOT NULL, 
    mb_point        NUMBER(12, 0)    DEFAULT 0 NOT NULL, 
     PRIMARY KEY (mb_id)
)
/

COMMENT ON TABLE t_member IS '회원 정보'
/

COMMENT ON COLUMN t_member.mb_id IS '회원 아이디'
/

COMMENT ON COLUMN t_member.mb_pw IS '회원 비밀번호'
/

COMMENT ON COLUMN t_member.mb_email IS '회원 이메일'
/

COMMENT ON COLUMN t_member.mb_name IS '회원 이름'
/

COMMENT ON COLUMN t_member.mb_gender IS '회원 성별'
/

COMMENT ON COLUMN t_member.mb_phone IS '회원 연락처'
/

COMMENT ON COLUMN t_member.mb_birthdate IS '회원 생년월일'
/

COMMENT ON COLUMN t_member.mb_addr IS '회원 주소'
/

COMMENT ON COLUMN t_member.mb_joindate IS '회원 가입일자'
/

COMMENT ON COLUMN t_member.admin_yn IS '관리자 여부'
/

COMMENT ON COLUMN t_member.mb_point IS '회원 포인트'
/


-- t_disease Table Create SQL
CREATE TABLE t_disease
(
    dis_code       VARCHAR2(20)      NOT NULL, 
    dis_name       VARCHAR2(50)      NOT NULL, 
    dis_content    VARCHAR2(4000)    NOT NULL, 
    dis_symptom    VARCHAR2(4000)    NOT NULL, 
    dis_pic1       VARCHAR2(150)     NULL, 
    dis_pic2       VARCHAR2(150)     NULL, 
    dis_pic3       VARCHAR2(150)     NULL, 
    dis_pic4       VARCHAR2(150)     NULL, 
    reg_date       DATE              DEFAULT SYSDATE NOT NULL, 
    mb_id          VARCHAR2(20)      NOT NULL, 
     PRIMARY KEY (dis_code)
)
/

COMMENT ON TABLE t_disease IS '질병 정보'
/

COMMENT ON COLUMN t_disease.dis_code IS '질병코드'
/

COMMENT ON COLUMN t_disease.dis_name IS '질병 명'
/

COMMENT ON COLUMN t_disease.dis_content IS '질병 설명'
/

COMMENT ON COLUMN t_disease.dis_symptom IS '질병 증상'
/

COMMENT ON COLUMN t_disease.dis_pic1 IS '질병 사진1'
/

COMMENT ON COLUMN t_disease.dis_pic2 IS '질병 사진2'
/

COMMENT ON COLUMN t_disease.dis_pic3 IS '질병 사진3'
/

COMMENT ON COLUMN t_disease.dis_pic4 IS '질병 사진4'
/

COMMENT ON COLUMN t_disease.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_disease.mb_id IS '등록자 아이디'
/

ALTER TABLE t_disease
    ADD CONSTRAINT FK_t_disease_mb_id_t_member_mb FOREIGN KEY (mb_id)
        REFERENCES t_member (mb_id)
/


-- t_poll Table Create SQL
CREATE TABLE t_poll
(
    poll_seq        NUMBER(12, 0)     NOT NULL, 
    poll_title      VARCHAR2(150)     NOT NULL, 
    poll_content    VARCHAR2(4000)    NOT NULL, 
    mb_id           VARCHAR2(20)      NULL, 
    reg_date        DATE              DEFAULT SYSDATE NULL, 
     PRIMARY KEY (poll_seq)
)
/

insert into t_poll(poll_title,poll_content)
values ('코로나19 바이러스 설문지','본 설문지는 코로나19에 대해 감염여부를 판단하기 위해 실시하는 설문지 입니다.');

insert into t_poll(poll_title,poll_content)
values ('암 설문지','본 설문지는 암에 대해 진단을 하기 위해 실시하는 설문지 입니다.');

insert into t_poll(poll_title,poll_content)
values ('뇌졸중 설문지','본 설문지는 뇌졸중에 대한 설문지 양식입니다. 뇌졸중 환자에게 질문할 여러가지 사항이 설문 형식으로 구성되어 있습니다.');

CREATE SEQUENCE t_poll_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_poll_AI_TRG
BEFORE INSERT ON t_poll 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_poll_SEQ.NEXTVAL
    INTO :NEW.poll_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_poll_AI_TRG;
/

--DROP SEQUENCE t_poll_SEQ;
/

COMMENT ON TABLE t_poll IS '설문조사'
/

COMMENT ON COLUMN t_poll.poll_seq IS '설문 순번'
/

COMMENT ON COLUMN t_poll.poll_title IS '설문 제목'
/

COMMENT ON COLUMN t_poll.poll_content IS '설문 설명'
/

COMMENT ON COLUMN t_poll.mb_id IS '등록자 아이디'
/

COMMENT ON COLUMN t_poll.reg_date IS '등록 일자'
/



-- t_checklist Table Create SQL
CREATE TABLE t_checklist
(
    check_seq     NUMBER(12, 0)     NOT NULL, 
    check_age     VARCHAR2(20)      NOT NULL, 
    check_name    VARCHAR2(20)      NOT NULL, 
    dis_code      VARCHAR2(20)      NOT NULL, 
    check_item    VARCHAR2(4000)    NOT NULL, 
    check_std     NUMBER            NOT NULL, 
    reg_date      DATE              DEFAULT SYSDATE NOT NULL, 
     PRIMARY KEY (check_seq)
)
/

CREATE SEQUENCE t_checklist_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_checklist_AI_TRG
BEFORE INSERT ON t_checklist 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_checklist_SEQ.NEXTVAL
    INTO :NEW.check_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_checklist_AI_TRG;
/

--DROP SEQUENCE t_checklist_SEQ;
/

COMMENT ON TABLE t_checklist IS '질병 체크 리스트'
/

COMMENT ON COLUMN t_checklist.check_seq IS '체크 순번'
/

COMMENT ON COLUMN t_checklist.check_age IS '체크 연령'
/

COMMENT ON COLUMN t_checklist.check_name IS '체크 질병명'
/

COMMENT ON COLUMN t_checklist.dis_code IS '질병 코드'
/

COMMENT ON COLUMN t_checklist.check_item IS '체크 항목'
/

COMMENT ON COLUMN t_checklist.check_std IS '체크 기준'
/

COMMENT ON COLUMN t_checklist.reg_date IS '등록 일자'
/

ALTER TABLE t_checklist
    ADD CONSTRAINT FK_t_checklist_dis_code_t_dise FOREIGN KEY (dis_code)
        REFERENCES t_disease (dis_code)
/


-- t_disease_history Table Create SQL
CREATE TABLE t_disease_history
(
    history_seq    NUMBER(12, 0)     NOT NULL, 
    dis_name       VARCHAR2(50)      NOT NULL, 
    dis_symptom    VARCHAR2(4000)    NOT NULL, 
    reg_date       DATE              DEFAULT SYSDATE NOT NULL, 
    mb_id          VARCHAR2(20)      NOT NULL, 
     PRIMARY KEY (history_seq)
)
/

CREATE SEQUENCE t_disease_history_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_disease_history_AI_TRG
BEFORE INSERT ON t_disease_history 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_disease_history_SEQ.NEXTVAL
    INTO :NEW.history_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_disease_history_AI_TRG;
/

--DROP SEQUENCE t_disease_history_SEQ;
/

COMMENT ON TABLE t_disease_history IS '나의 질병 히스토리'
/

COMMENT ON COLUMN t_disease_history.history_seq IS '히스토리 순번'
/

COMMENT ON COLUMN t_disease_history.dis_name IS '질병 명'
/

COMMENT ON COLUMN t_disease_history.dis_symptom IS '질병 증상'
/

COMMENT ON COLUMN t_disease_history.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_disease_history.mb_id IS '회원 아이디'
/

ALTER TABLE t_disease_history
    ADD CONSTRAINT FK_t_disease_history_mb_id_t_m FOREIGN KEY (mb_id)
        REFERENCES t_member (mb_id)
/


-- t_health_food Table Create SQL
CREATE TABLE t_health_food
(
    health_food_seq           NUMBER(12, 0)     NOT NULL, 
    health_food_name          VARCHAR2(50)      NOT NULL, 
    health_food_ingredient    VARCHAR2(4000)    NOT NULL, 
    health_food_calory        NUMBER(12, 0)     NOT NULL, 
    health_food_effect        VARCHAR2(4000)    NOT NULL, 
    reg_date                  DATE              DEFAULT SYSDATE NOT NULL, 
    health_food_pic1          VARCHAR2(150)     NULL, 
    health_food_pic2          VARCHAR2(150)     NULL, 
     PRIMARY KEY (health_food_seq)
)
/

CREATE SEQUENCE t_health_food_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_health_food_AI_TRG
BEFORE INSERT ON t_health_food 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_health_food_SEQ.NEXTVAL
    INTO :NEW.health_food_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_health_food_AI_TRG;
/

--DROP SEQUENCE t_health_food_SEQ;
/

COMMENT ON TABLE t_health_food IS '건강 기능 식품'
/

COMMENT ON COLUMN t_health_food.health_food_seq IS '건강기능식품 순번'
/

COMMENT ON COLUMN t_health_food.health_food_name IS '건강기능식품 명'
/

COMMENT ON COLUMN t_health_food.health_food_ingredient IS '건강기능식품 영양소'
/

COMMENT ON COLUMN t_health_food.health_food_calory IS '건강기능식품 칼로리'
/

COMMENT ON COLUMN t_health_food.health_food_effect IS '건강기능식품 효과'
/

COMMENT ON COLUMN t_health_food.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_health_food.health_food_pic1 IS '건강기능식품 사진1'
/

COMMENT ON COLUMN t_health_food.health_food_pic2 IS '건강기능식품 사진2'
/


-- t_food Table Create SQL
CREATE TABLE t_food
(
    food_seq           NUMBER(12, 0)     NOT NULL, 
    food_name          VARCHAR2(50)      NOT NULL, 
    food_ingredient    VARCHAR2(4000)    NOT NULL, 
    food_calory        NUMBER(12, 0)     NOT NULL, 
    food_effect        VARCHAR2(4000)    NOT NULL, 
    reg_date           DATE              DEFAULT SYSDATE NOT NULL, 
    food_pic1          VARCHAR2(150)     NULL, 
    food_pic2          VARCHAR2(150)     NULL, 
     PRIMARY KEY (food_seq)
)
/

CREATE SEQUENCE t_food_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_food_AI_TRG
BEFORE INSERT ON t_food 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_food_SEQ.NEXTVAL
    INTO :NEW.food_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_food_AI_TRG;
/

--DROP SEQUENCE t_food_SEQ;
/

COMMENT ON TABLE t_food IS '식품 정보 테이블'
/

COMMENT ON COLUMN t_food.food_seq IS '식품 순번'
/

COMMENT ON COLUMN t_food.food_name IS '식품 명'
/

COMMENT ON COLUMN t_food.food_ingredient IS '식품 영양소'
/

COMMENT ON COLUMN t_food.food_calory IS '식품 칼로리'
/

COMMENT ON COLUMN t_food.food_effect IS '식품 효과'
/

COMMENT ON COLUMN t_food.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_food.food_pic1 IS '식품 사진1'
/

COMMENT ON COLUMN t_food.food_pic2 IS '식품 사진2'
/


-- t_poll_items Table Create SQL
CREATE TABLE t_poll_items
(
    item_seq        NUMBER(12, 0)     NOT NULL, 
    poll_seq        NUMBER(12, 0)     NOT NULL, 
    item_name       VARCHAR2(150)     NOT NULL, 
    item_content    VARCHAR2(4000)    NOT NULL, 
     PRIMARY KEY (item_seq)
)
/

CREATE SEQUENCE t_poll_items_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_poll_items_AI_TRG
BEFORE INSERT ON t_poll_items 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_poll_items_SEQ.NEXTVAL
    INTO :NEW.item_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_poll_items_AI_TRG;
/

--DROP SEQUENCE t_poll_items_SEQ;
/

COMMENT ON TABLE t_poll_items IS '설문 아이템'
/

COMMENT ON COLUMN t_poll_items.item_seq IS '설문 아이템 순번'
/

COMMENT ON COLUMN t_poll_items.poll_seq IS '설문 순번'
/

COMMENT ON COLUMN t_poll_items.item_name IS '아이템 항목'
/

COMMENT ON COLUMN t_poll_items.item_content IS '아이템 보충설명'
/

ALTER TABLE t_poll_items
    ADD CONSTRAINT FK_t_poll_items_poll_seq_t_pol FOREIGN KEY (poll_seq)
        REFERENCES t_poll (poll_seq)
/


-- t_mb_answer Table Create SQL
CREATE TABLE t_mb_answer
(
    answer_seq       NUMBER(12, 0)    NOT NULL, 
    item_seq         NUMBER(12, 0)    NOT NULL, 
    answer_result    VARCHAR2(20)     NOT NULL, 
    answer_date      DATE             NOT NULL, 
    mb_id            VARCHAR2(20)     NOT NULL, 
    reg_date         DATE             DEFAULT SYSDATE NULL, 
     PRIMARY KEY (answer_seq)
)
/

CREATE SEQUENCE t_mb_answer_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_mb_answer_AI_TRG
BEFORE INSERT ON t_mb_answer 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_mb_answer_SEQ.NEXTVAL
    INTO :NEW.answer_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_mb_answer_AI_TRG;
/

--DROP SEQUENCE t_mb_answer_SEQ;
/

COMMENT ON TABLE t_mb_answer IS '회원 설문 응답 조사'
/

COMMENT ON COLUMN t_mb_answer.answer_seq IS '응답 순번'
/

COMMENT ON COLUMN t_mb_answer.item_seq IS '설문 아이템 순번'
/

COMMENT ON COLUMN t_mb_answer.answer_result IS '응답 결과'
/

COMMENT ON COLUMN t_mb_answer.answer_date IS '응답 날짜'
/

COMMENT ON COLUMN t_mb_answer.mb_id IS '응답자 아이디'
/

COMMENT ON COLUMN t_mb_answer.reg_date IS '등록 날짜'
/

ALTER TABLE t_mb_answer
    ADD CONSTRAINT FK_t_mb_answer_item_seq_t_poll FOREIGN KEY (item_seq)
        REFERENCES t_poll_items (item_seq)
/

ALTER TABLE t_mb_answer
    ADD CONSTRAINT FK_t_mb_answer_mb_id_t_member_ FOREIGN KEY (mb_id)
        REFERENCES t_member (mb_id)
/


-- t_hospital Table Create SQL
CREATE TABLE t_hospital
(
    hos_seq           NUMBER(12, 0)    NOT NULL, 
    hos_name          VARCHAR2(50)     NOT NULL, 
    hos_addr          VARCHAR2(150)    NOT NULL, 
    hos_phone         VARCHAR2(20)     NOT NULL, 
    hos_latitude      NUMBER(17,14)    NOT NULL, 
    hos_longitude     NUMBER(17,14)    NOT NULL, 
    hos_facilities    VARCHAR2(150)    NOT NULL, 
    reg_date          DATE             DEFAULT SYSDATE NOT NULL, 
    mb_id             VARCHAR2(20)     NOT NULL, 
    hos_pic1          VARCHAR2(150)    NULL, 
    hos_pic2          VARCHAR2(150)    NULL, 
    hos_pic3          VARCHAR2(150)    NULL, 
     PRIMARY KEY (hos_seq)
)
/

CREATE SEQUENCE t_hospital_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_hospital_AI_TRG
BEFORE INSERT ON t_hospital 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_hospital_SEQ.NEXTVAL
    INTO :NEW.hos_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_hospital_AI_TRG;
/

--DROP SEQUENCE t_hospital_SEQ;
/

COMMENT ON TABLE t_hospital IS '병원 정보 테이블'
/

COMMENT ON COLUMN t_hospital.hos_seq IS '병원 순번'
/

COMMENT ON COLUMN t_hospital.hos_name IS '병원 명'
/

COMMENT ON COLUMN t_hospital.hos_addr IS '병원 주소'
/

COMMENT ON COLUMN t_hospital.hos_phone IS '병원 전화'
/

COMMENT ON COLUMN t_hospital.hos_latitude IS '병원 위도'
/

COMMENT ON COLUMN t_hospital.hos_longitude IS '병원 경도'
/

COMMENT ON COLUMN t_hospital.hos_facilities IS '병원 시설'
/

COMMENT ON COLUMN t_hospital.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_hospital.mb_id IS '등록자 아이디'
/

COMMENT ON COLUMN t_hospital.hos_pic1 IS '병원 사진1'
/

COMMENT ON COLUMN t_hospital.hos_pic2 IS '병원 사진2'
/

COMMENT ON COLUMN t_hospital.hos_pic3 IS '병원 사진3'
/

ALTER TABLE t_hospital
    ADD CONSTRAINT FK_t_hospital_mb_id_t_member_m FOREIGN KEY (mb_id)
        REFERENCES t_member (mb_id)
/


-- t_point Table Create SQL
CREATE TABLE t_point
(
    point_seq     NUMBER(12, 0)    NOT NULL, 
    point         NUMBER(12, 0)    DEFAULT 0 NOT NULL, 
    point_memo    VARCHAR2(150)    NOT NULL, 
    reg_date      DATE             DEFAULT SYSDATE NOT NULL, 
    mb_id         VARCHAR2(20)     NOT NULL, 
    point_kind    VARCHAR2(1)      NULL, 
     PRIMARY KEY (point_seq)
)
/

CREATE SEQUENCE t_point_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_point_AI_TRG
BEFORE INSERT ON t_point 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_point_SEQ.NEXTVAL
    INTO :NEW.point_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_point_AI_TRG;
/

--DROP SEQUENCE t_point_SEQ;
/

COMMENT ON TABLE t_point IS '포인트 지급 및 사용 정보'
/

COMMENT ON COLUMN t_point.point_seq IS '포인트 순번'
/

COMMENT ON COLUMN t_point.point IS '포인트 점수'
/

COMMENT ON COLUMN t_point.point_memo IS '포인트 사유'
/

COMMENT ON COLUMN t_point.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_point.mb_id IS '회원 아이디'
/

COMMENT ON COLUMN t_point.point_kind IS '포인트 구분'
/

ALTER TABLE t_point
    ADD CONSTRAINT FK_t_point_mb_id_t_member_mb_i FOREIGN KEY (mb_id)
        REFERENCES t_member (mb_id)
/


-- t_recommend Table Create SQL
CREATE TABLE t_recommend
(
    reco_seq           NUMBER(12, 0)    NOT NULL, 
    food_seq           NUMBER(12, 0)    NULL, 
    health_food_seq    NUMBER(12, 0)    NULL, 
    rehabi_seq         NUMBER(12, 0)    NULL, 
    reg_date           DATE             DEFAULT SYSDATE NOT NULL, 
    mb_id              VARCHAR2(20)     NOT NULL, 
    history_seq        NUMBER(12, 0)    NOT NULL, 
     PRIMARY KEY (reco_seq)
)
/

CREATE SEQUENCE t_recommend_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_recommend_AI_TRG
BEFORE INSERT ON t_recommend 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_recommend_SEQ.NEXTVAL
    INTO :NEW.reco_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_recommend_AI_TRG;
/

--DROP SEQUENCE t_recommend_SEQ;
/

COMMENT ON TABLE t_recommend IS '추천 건강 관리'
/

COMMENT ON COLUMN t_recommend.reco_seq IS '추천 순번'
/

COMMENT ON COLUMN t_recommend.food_seq IS '식품 순번'
/

COMMENT ON COLUMN t_recommend.health_food_seq IS '건강기능식품 순번'
/

COMMENT ON COLUMN t_recommend.rehabi_seq IS '재활 순번'
/

COMMENT ON COLUMN t_recommend.reg_date IS '추천 일자'
/

COMMENT ON COLUMN t_recommend.mb_id IS '회원 아이디'
/

COMMENT ON COLUMN t_recommend.history_seq IS '회원 증상 순번'
/

ALTER TABLE t_recommend
    ADD CONSTRAINT FK_t_recommend_food_seq_t_food FOREIGN KEY (food_seq)
        REFERENCES t_food (food_seq)
/

ALTER TABLE t_recommend
    ADD CONSTRAINT FK_t_recommend_health_food_seq FOREIGN KEY (health_food_seq)
        REFERENCES t_health_food (health_food_seq)
/

ALTER TABLE t_recommend
    ADD CONSTRAINT FK_t_recommend_mb_id_t_member_ FOREIGN KEY (mb_id)
        REFERENCES t_member (mb_id)
/

ALTER TABLE t_recommend
    ADD CONSTRAINT FK_t_recommend_history_seq_t_d FOREIGN KEY (history_seq)
        REFERENCES t_disease_history (history_seq)
/


-- t_user_check Table Create SQL
CREATE TABLE t_user_check
(
    user_check_seq       NUMBER(12, 0)    NOT NULL, 
    check_seq            NUMBER(12, 0)    NOT NULL, 
    user_check_result    VARCHAR2(1)      NOT NULL, 
    reg_date             DATE             DEFAULT SYSDATE NOT NULL, 
    mb_id                VARCHAR2(20)     NOT NULL, 
     PRIMARY KEY (user_check_seq)
)
/

CREATE SEQUENCE t_user_check_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER t_user_check_AI_TRG
BEFORE INSERT ON t_user_check 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_user_check_SEQ.NEXTVAL
    INTO :NEW.user_check_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_user_check_AI_TRG;
/

--DROP SEQUENCE t_user_check_SEQ;
/

COMMENT ON TABLE t_user_check IS '사용자 체크 결과'
/

COMMENT ON COLUMN t_user_check.user_check_seq IS '사용자체크 순번'
/

COMMENT ON COLUMN t_user_check.check_seq IS '체크 순번'
/

COMMENT ON COLUMN t_user_check.user_check_result IS '체크 결과'
/

COMMENT ON COLUMN t_user_check.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_user_check.mb_id IS '등록자 아이디'
/

ALTER TABLE t_user_check
    ADD CONSTRAINT FK_t_user_check_check_seq_t_ch FOREIGN KEY (check_seq)
        REFERENCES t_checklist (check_seq)
/

ALTER TABLE t_user_check
    ADD CONSTRAINT FK_t_user_check_mb_id_t_member FOREIGN KEY (mb_id)
        REFERENCES t_member (mb_id)
/




