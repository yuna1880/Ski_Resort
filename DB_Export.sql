--------------------------------------------------------
--  ������ ������ - ������-12��-31-2020
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ORDER_NUM
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_ORDER_NUM"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_RESERV_NUM
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_RESERV_NUM"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SNACK_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SNACK_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SNACK_SEQ1
--------------------------------------------------------

   CREATE SEQUENCE  "SNACK_SEQ1"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "MEMBER"
   (	"ID" VARCHAR2(20 BYTE),
	"PW" VARCHAR2(20 BYTE),
	"NAME" VARCHAR2(20 BYTE),
	"PHONE" VARCHAR2(50 BYTE),
	"EMAIL" VARCHAR2(50 BYTE)
   ) ;

   COMMENT ON COLUMN "MEMBER"."ID" IS '���̵�';
   COMMENT ON COLUMN "MEMBER"."PW" IS '���й�ȣ';
   COMMENT ON COLUMN "MEMBER"."NAME" IS '�̸�';
   COMMENT ON COLUMN "MEMBER"."PHONE" IS '��ȭ��ȣ';
   COMMENT ON COLUMN "MEMBER"."EMAIL" IS 'EMAIL';
   COMMENT ON TABLE "MEMBER"  IS 'ȸ��';
--------------------------------------------------------
--  DDL for Table RESERV
--------------------------------------------------------

  CREATE TABLE "RESERV"
   (	"RESERV_NUM" NUMBER,
	"SHOE_SIZE" VARCHAR2(20 BYTE),
	"EQUIT" VARCHAR2(20 BYTE),
	"RIDE" VARCHAR2(20 BYTE),
	"RESERV_DATE" DATE,
	"MEM_ID" VARCHAR2(20 BYTE)
   ) ;

   COMMENT ON COLUMN "RESERV"."RESERV_NUM" IS '������ȣ';
   COMMENT ON COLUMN "RESERV"."SHOE_SIZE" IS '�Ź߻�����';
   COMMENT ON COLUMN "RESERV"."EQUIT" IS '��ȣ����';
   COMMENT ON COLUMN "RESERV"."RIDE" IS '��Ʈ/��Ű ����';
   COMMENT ON COLUMN "RESERV"."RESERV_DATE" IS '��¥';
   COMMENT ON COLUMN "RESERV"."MEM_ID" IS 'ȸ�����̵�';
   COMMENT ON TABLE "RESERV"  IS '����';
--------------------------------------------------------
--  DDL for Table SNACK
--------------------------------------------------------

  CREATE TABLE "SNACK"
   (	"ORDER_NUM" NUMBER,
	"BEVERAGE" VARCHAR2(20 BYTE),
	"SNACK" VARCHAR2(20 BYTE),
	"RAMEN" VARCHAR2(20 BYTE),
	"MEM_ID" VARCHAR2(20 BYTE)
   ) ;

   COMMENT ON COLUMN "SNACK"."ORDER_NUM" IS '�ֹ���ȣ';
   COMMENT ON COLUMN "SNACK"."BEVERAGE" IS '����';
   COMMENT ON COLUMN "SNACK"."SNACK" IS '����';
   COMMENT ON COLUMN "SNACK"."RAMEN" IS '����';
   COMMENT ON COLUMN "SNACK"."MEM_ID" IS 'ȸ�����̵�';
   COMMENT ON TABLE "SNACK"  IS '����';
REM INSERTING into MEMBER
SET DEFINE OFF;
Insert into MEMBER (ID,PW,NAME,PHONE,EMAIL) values ('yuna1880','1205','������','0100100101','yuna1880@');
REM INSERTING into RESERV
SET DEFINE OFF;
Insert into RESERV (RESERV_NUM,SHOE_SIZE,EQUIT,RIDE,RESERV_DATE,MEM_ID) values (35,'240','�尩','��Ű',to_date('21/01/01','RR/MM/DD'),'yuna1880');
REM INSERTING into SNACK
SET DEFINE OFF;
Insert into SNACK (ORDER_NUM,BEVERAGE,SNACK,RAMEN,MEM_ID) values (21,'Ŀ��','����Ĩ','�ʱ���','yuna1880');
Insert into SNACK (ORDER_NUM,BEVERAGE,SNACK,RAMEN,MEM_ID) values (17,'�������꽺','����Ĩ','�ʱ���','yuna1880');
Insert into SNACK (ORDER_NUM,BEVERAGE,SNACK,RAMEN,MEM_ID) values (18,'Ŀ��','������','�Ŷ���','yuna1880');
Insert into SNACK (ORDER_NUM,BEVERAGE,SNACK,RAMEN,MEM_ID) values (22,'�������꽺','������','�Ŷ���','yuna1880');
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MEMBER_PK" ON "MEMBER" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index RESERV_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RESERV_PK" ON "RESERV" ("RESERV_NUM")
  ;
--------------------------------------------------------
--  DDL for Index SNACK_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SNACK_PK" ON "SNACK" ("ORDER_NUM")
  ;
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MEMBER_PK" ON "MEMBER" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index RESERV_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RESERV_PK" ON "RESERV" ("RESERV_NUM")
  ;
--------------------------------------------------------
--  DDL for Index SNACK_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SNACK_PK" ON "SNACK" ("ORDER_NUM")
  ;
--------------------------------------------------------
--  DDL for Trigger SNACK_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SNACK_TRG"
BEFORE INSERT ON SNACK
FOR EACH ROW
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ORDER_NUM IS NULL THEN
      SELECT SNACK_SEQ1.NEXTVAL INTO :NEW.ORDER_NUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SNACK_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SNACK_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SNACK_TRG"
BEFORE INSERT ON SNACK
FOR EACH ROW
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ORDER_NUM IS NULL THEN
      SELECT SNACK_SEQ1.NEXTVAL INTO :NEW.ORDER_NUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SNACK_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "MEMBER" MODIFY ("PHONE" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("PW" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RESERV
--------------------------------------------------------

  ALTER TABLE "RESERV" ADD CONSTRAINT "RESERV_PK" PRIMARY KEY ("RESERV_NUM") ENABLE;
  ALTER TABLE "RESERV" MODIFY ("RESERV_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SNACK
--------------------------------------------------------

  ALTER TABLE "SNACK" ADD CONSTRAINT "SNACK_PK" PRIMARY KEY ("ORDER_NUM") ENABLE;
  ALTER TABLE "SNACK" MODIFY ("RAMEN" NOT NULL ENABLE);
  ALTER TABLE "SNACK" MODIFY ("SNACK" NOT NULL ENABLE);
  ALTER TABLE "SNACK" MODIFY ("ORDER_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table RESERV
--------------------------------------------------------

  ALTER TABLE "RESERV" ADD CONSTRAINT "FK_RESERV_MEM_ID_MEMBER_ID" FOREIGN KEY ("MEM_ID")
	  REFERENCES "MEMBER" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SNACK
--------------------------------------------------------

  ALTER TABLE "SNACK" ADD CONSTRAINT "FK_SNACK_MEM_ID_MEMBER_ID" FOREIGN KEY ("MEM_ID")
	  REFERENCES "MEMBER" ("ID") ON DELETE CASCADE ENABLE;
