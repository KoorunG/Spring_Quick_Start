-- 테이블 jsp_address 생성
create table jsp_address(address_id varchar(100) primary key not null, basic_address varchar2(1000 byte) not null, detail_address varchar2(1000 byte) not null);

-- 시퀀스 MEMBER_SEQ 생성
CREATE SEQUENCE MEMBER_SEQ START WITH 1 INCREMENT BY 1;

commit;