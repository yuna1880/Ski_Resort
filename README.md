#### ⛷ Java + JDBC + (Oracle) 
######스키장 예약 프로그램 (자바 콘솔 프로젝트)
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

### More details about this project 🔽 please have a look !
---
[👉🏻 click here 👈🏻](https://www.notion.so/Java-JDBC-Oracle-e382ea417ea3496ca0742f650fc187cd)
