# ⛷ Java + JDBC + (Oracle) 
스키장 예약 프로그램 (자바 콘솔 프로젝트)
---

### 💡 프로젝트 목표

- 객체지향 설계 및 구현 연습
- 명명규칙, 데이터 입력과 선택 연습
- 사용자의 관점과 편의를 생각하고 고민.
- CRUD에 대한 이해와 연습

---

🎿 스키장 회원관리, 로그인, 물품예약, 간식예약 총 4가지 서비스 구현.

![image description](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e12da500-b1e6-456e-bf63-ae1823ba664b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210116%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210116T164120Z&X-Amz-Expires=86400&X-Amz-Signature=ae84265d2f50c32747960efdee45c31f9aa54099e31ff7c61521409263d49b31&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

### 📊 Project Diagram
---
![image description](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5de29c74-c068-4881-81f3-1de9af26ce44/Untitled_Diagram-3.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210116%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210116T164223Z&X-Amz-Expires=86400&X-Amz-Signature=d93dafd06ef4688c9d4b9e3f8c9031c6df5c30238cc1e850475aad7b0af6bb6f&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled_Diagram-3.png%22)

### 📊 DB Table
---
![image description](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/28a2c6cc-d288-480c-8574-0cfaedd98ad5/KakaoTalk_Photo_2021-01-03-3-00-20_pm.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210116%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210116T164330Z&X-Amz-Expires=86400&X-Amz-Signature=8211d3c55df695a1bbcb10a04ecc4f03d20a143c58eb53dd30956f88addbefa0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22KakaoTalk_Photo_2021-01-03-3-00-20_pm.jpeg%22)

- **회원 테이블의 `아이디` 를 `PK` 값으로 준 뒤, `물품 예약`, `간식 주문`   테이블의   `회원 아이디` 를 `FK` 로 연결해 주었다.**
- **`물품 예약`, `간식 주문` 테이블의 `주문번호` 에는 `시퀀스` 설정.**
- 각 테이블의 **`FK`** 에 제약조건 `ON DELETE CASCADE`설정.

### 📃 Java Class Diagram (VO 제외)
---
![image description](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5d90107e-7934-47e5-a5fd-cbb335232676/KakaoTalk_Photo_2020-12-30-3-40-32_pm.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210116%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210116T164436Z&X-Amz-Expires=86400&X-Amz-Signature=bca5160ab245a23a266dd01b47b98e08afdf750191b532b0039bfe88bf59a087&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22KakaoTalk_Photo_2020-12-30-3-40-32_pm.png%22)

- 회원 관리 - `MemberVO`, `MemberDao`, `MemberDaoImpl`, `Memberinfo`
- 로그인 - `LoginDao`, `LoginDaoImpl`
- 물품 예약 - `ReservVO`, `ReservDao`, `ReservDaoImpl`
- 간식 예약 - `SnackVO`, `SnackDao`, `SnackDaoImpl`

### 📌 프로젝트 진행중 문제점 - 해결방안

---
![image description](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9768aefd-9617-426d-be35-665b5231c9fe/Screenshot_2020-12-29_at_11.40.09_pm.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210116%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210116T164628Z&X-Amz-Expires=86400&X-Amz-Signature=befed3292630ab3edb0fe0a0fd49199c0f1287d2fe9d190d41c4398b0b9493a4&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_2020-12-29_at_11.40.09_pm.png%22)

### [ 문제점 ]

- **회원탈퇴 시, 회원 테이블 (MEMBER)와 FK로 연결된 (물품, 간식) 테이블에 저장된 데이터가 있으면 회원 탈퇴( 회원 데이터 삭제) 가 불가능했다.**

### [ 해결방안 ]

- 테이블 생성 전, 해당 FK 값에 on delete cascade 제약조건 붙여주기.
- 테이블 생성 후에는

- [ ]  1) 일단 기존 제약조건 삭제하기.

    ```sql
    ALTER TABLE RESERV DROP CONSTRAINT FK_RESERV_MEM_ID_MEMBER_ID;
    ```

- [ ]  2) on delete cascade 붙여서 제약조건 걸어주기.

    ```sql
    ALTER TABLE RESERV ADD CONSTRAINT FK_RESERV_MEM_ID_MEMBER_ID 
    FOREIGN KEY (MEM_ID)
    REFERENCES MEMBER(ID) on delete cascade;
    ```

    ### 📑 프로젝트 리뷰 및 개선방향

    ---

    - 효율적인 전체 구조 및 흐름에 대한 고민
    - 중복되는 코드 정리
    - 메소드 네이밍에 대한 고민
    - 처음 설계시, 보다 명확한 설계를 하지않는다면 완성 후 발생하는 문제점이 치명적일 수 있으니 보다 튼튼하게 할 필요가 있다.


### More details about this project 🔽 please have a look !
---
[👉🏻 click here 👈🏻](https://www.notion.so/Java-JDBC-Oracle-e382ea417ea3496ca0742f650fc187cd)
