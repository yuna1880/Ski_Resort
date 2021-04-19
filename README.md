# ⛷ Java + JDBC + (Oracle) 
###### 스키장 예약 프로그램 (자바 콘솔 프로젝트)


### 💡 프로젝트 목표

- 객체지향 설계 및 구현 연습
- 명명규칙, 데이터 입력과 선택 연습
- 사용자의 관점과 편의를 생각하고 고민.
- CRUD에 대한 이해와 연습

---

🎿 스키장 회원관리, 로그인, 물품예약, 간식예약 총 4가지 서비스 구현.

![Untitled](https://user-images.githubusercontent.com/72509037/115263256-3d319200-a170-11eb-8049-2284484273f3.png)
![Untitled-5](https://user-images.githubusercontent.com/72509037/115263260-3e62bf00-a170-11eb-908b-becc46a8a755.png)
![Untitled-4](https://user-images.githubusercontent.com/72509037/115263271-3f93ec00-a170-11eb-8afd-4d656299ce23.png)
![Untitled-3](https://user-images.githubusercontent.com/72509037/115263280-40c51900-a170-11eb-931a-8f8ca6edd04a.png)
![Untitled-2](https://user-images.githubusercontent.com/72509037/115263286-41f64600-a170-11eb-9b6b-59805c7508bd.png)


### 📊 Project Diagram
---


### 📊 DB Table
---


- **회원 테이블의 `아이디` 를 `PK` 값으로 준 뒤, `물품 예약`, `간식 주문`   테이블의   `회원 아이디` 를 `FK` 로 연결해 주었다.**
- **`물품 예약`, `간식 주문` 테이블의 `주문번호` 에는 `시퀀스` 설정.**
- 각 테이블의 **`FK`** 에 제약조건 `ON DELETE CASCADE`설정.

### 📃 Java Class Diagram (VO 제외)
---


- 회원 관리 - `MemberVO`, `MemberDao`, `MemberDaoImpl`, `Memberinfo`
- 로그인 - `LoginDao`, `LoginDaoImpl`
- 물품 예약 - `ReservVO`, `ReservDao`, `ReservDaoImpl`
- 간식 예약 - `SnackVO`, `SnackDao`, `SnackDaoImpl`

### 📌 프로젝트 진행중 문제점 - 해결방안

---


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

---
#### More details about this project 🔽 please have a look !

[👉🏻 click here 👈🏻](https://www.notion.so/yunakwon/Java-JDBC-Oracle-e382ea417ea3496ca0742f650fc187cd)
