# SGMA

### Team _Spring-Cooler_
> 스프링을 더 멋지게

## 목차
1. [팀 소개](#팀-소개)
2. [기술 스택](#기술-스택)
   - [Backend](#1-backend)
   - [Database](#2-database)
   - [Tool](#3-tool)
3. [프로젝트 개요](#프로젝트-개요)
   - [배경](#1-배경)
   - [서비스 목표](#2-서비스-목표)
   - [차별점](#3-차별점)
   - [핵심 기능](#4-핵심-기능)
   - [기대 효과](#5-기대-효과)
4. [설계 문서](#설계-문서)
   - [System Architecture](#system-architecture)
   - [요구사항 정의서](#요구사항-정의서)
   - [WBS](#wbs)
   - [주요 기능 FLOW CHART](#주요-기능-flow-chart)
   - [DDD](#ddd)
     - [Event Storming](#1-event-storming)
     - [Bounded Context](#2-bounded-context)
   - [DB 모델링](#db-모델링)
     - [개념 모델링](#1-개념-모델링)
     - [논리 모델링](#2-논리-모델링)
     - [물리 모델링](#3-물리-모델링)
   - [동료 평가](#동료평가)

---

| <img src="https://github.com/user-attachments/assets/00ef7243-5ac8-4f3a-8b43-2271ee79665c" height=100/>  | <img src="https://github.com/user-attachments/assets/018f5c1c-7b3e-4767-a8b7-415c871e1e63" height=100/> | <img src="https://github.com/3-Minutes-Query/choleeTest/assets/102345450/1046b24a-5d40-4dc1-a747-cb65f20dc764" height=100/> | <img src="https://github.com/user-attachments/assets/3459263f-3864-4d69-a427-1578eaa984ce" height=100 width=100/> | <img src="https://github.com/user-attachments/assets/8bdf1acd-d774-426f-8257-d28bd1e37056" height=100/> |
| -------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| 조창욱                                                                                                      | 김서현                                                                                                     | 김민석                                                                                                                         | 전기범                                                                                                               | 김소리                                                                                                     |
| [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/Chochanguk) | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/1etterh)   | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/minseokKim6823)                | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/woodart8)            | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/sorrri)    |
| ESTJ                                                                                                     | ISTP                                                                                                    | ESTP                                                                                                                        | INFJ                                                                                                              | ESTJ                                                                                                    |


---
## 기술 스택 <a id="기술-스택"></a>

### 1. Backend <a id="1-backend"></a>

| Java 17                                                                           | Spring Boot                                                                                              | Spring Data JPA                                                                                   | MyBatis                                                                                                 | Hibernate                                                                       | Spring Security                                                                                                   | JWT                                                                                      | Gradle                                                                 | JUnit5                                                                                             | Spring Batch                                                           |
| --------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------- |
| ![Java](https://img.shields.io/badge/Java-17-007396.svg?&logo=java&color=red)| ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F.svg?&logo=spring-boot&color=lightgreen) | ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F.svg?&logo=spring-data-JPA) | ![MyBatis](https://img.shields.io/badge/MyBatis-FE6602.svg?&logo=mybatis5&logoColor=white&color=FE6602) | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C.svg?&logo=hibernate) | ![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F.svg?&logo=spring-security&logoColor=white) | ![JWT](https://img.shields.io/badge/JWT-F60055.svg?&logo=json-web-token&logoColor=white) | ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?&logo=gradle) | ![JUnit5](https://img.shields.io/badge/JUnit5-25A162.svg?&logo=junit5&logoColor=white&color=green) |![Spring Batch](https://img.shields.io/badge/Spring_Batch-6CB33E?style=flat&logo=springbatch&logoColor=white)  |




### 2. Database <a id="2-database"></a>

| MariaDB                                                                   | Redis                                                                               | AWS S3 Bucket                                                                                              |
| ------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| ![MariaDB](https://img.shields.io/badge/MariaDB-003545.svg?&logo=mariadb) | ![Redis](https://img.shields.io/badge/Redis-DC382D.svg?&logo=redis&logoColor=white) | ![AWS](https://img.shields.io/badge/AWS_S3-569A31?style=flat&logo=amazons3&logoColor=white)|

### 3. Tool <a id="3-tool"></a>

| <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&logoColor=white"> &nbsp; | <img src="https://img.shields.io/badge/DA%23-0B6121.svg?style=flat&logo=draw.io&logoColor=white"> &nbsp; | ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=flat&logo=intellij-idea&logoColor=white) | ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=flat&logo=visual-studio-code&logoColor=white) |
| ----------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |

## 프로젝트 개요 <a id="프로젝트-개요"></a>
---
### 1. 배경 <a id="1-배경"></a>
1. 팀 스터디의 효율성을 향상시킬 수 있는 도구가 필요함
2. 일정 관리, 학습 진도 파악 등 스터디의 정보를 한 곳에서 모아볼 수 있는 서비스가 없음
### 2. 서비스 목표 <a id="2-서비스-목표"></a>
> 팀 스터디의 모든 과정을 쉽게 관리 및 각 멤버가 자신의 학습 목표를 달성할 수 있도록 도움

### 3. 차별점 <a id="3-차별점"></a>
|         | 팀원모집 | 일정관리 | 문제 출제 | 일정관리 |
| ------- | ---- | ---- | ----- | ---- |
| Studyin | ㅇ    | ㅇ    |       | ㅇ    |
| 맞추다     |      |      | ㅇ     |      |
| 공작소     | ㅇ    | ㅇ    |       | ㅇ    |
| SGMA    | ㅇ    | ㅇ    | ㅇ     | ㅇ    |

### 4. 핵심 기능 <a id="4-핵심-기능"></a>
1. 스터디 그룹 생성 및 모집
2. 학습 내용 확인 및 공유
3. 학습 성취도 시각화
### 5. 기대 효과 <a id="5-기대-효과"></a>
> 단순한 학습의 장을 넘어, 체계적이고 효과적인 학습 플랫폼으로 발전할 수 있을 것으로 기대


## 설계 문서 <a id="설계-문서"></a>
---

#### System Architecture <a id="system-architecture"></a>
![image](https://github.com/user-attachments/assets/88199112-1940-4cba-96ea-cd7031117c78)


#### 요구사항 정의서 <a id="요구사항-정의서"></a>
[요구사항 정의서 바로가기](https://docs.google.com/spreadsheets/d/1XVX6lAse2VZzDybUvryL8GyeM3-PO_EZMFG10hMVJSk/edit?gid=0#gid=0)

![image](https://github.com/user-attachments/assets/ad2a9474-3dd2-4e5c-bdf4-fa0e48cb4d55)

### WBS <a id="wbs"></a>
[WBS 바로가기](https://docs.google.com/spreadsheets/d/1XVX6lAse2VZzDybUvryL8GyeM3-PO_EZMFG10hMVJSk/edit?gid=1079017783#gid=1079017783)

![image](https://github.com/user-attachments/assets/a5f97514-d78e-476b-a472-b76dd4a22eee)


### 주요 기능 FLOW CHART <a id="주요-기능-flow-chart"></a>
![문제관련 drawio (1)](https://github.com/user-attachments/assets/59625632-7ce8-4300-b085-945d176620f8)

### DDD <a id="ddd"></a>
#### 1. Event Storming <a id="1-event-storming"></a>
![image](https://github.com/user-attachments/assets/b11ddb78-7874-4dfd-a8c0-ebfdbd41e238)
#### 2. Bounded Context <a id="2-bounded-context"></a>
![image](https://github.com/user-attachments/assets/3efdd6c0-09bb-4ac0-ae83-d0e399f39ccd)
### DB 모델링 <a id="db-모델링"></a>
#### 1. 개념 모델링 <a id="1-개념-모델링"></a>
![image](https://github.com/user-attachments/assets/e6dea257-6429-4be1-91f4-fa653914148e)
#### 2. 논리 모델링 <a id="2-논리-모델링"></a>
![image](https://github.com/user-attachments/assets/d75544e3-92d9-4e47-b33료b-5f595c5c4fcb)
#### 3. 물리 모델링 <a id="3-물리-모델링"></a>
![image](https://github.com/user-attachments/assets/7d0b0f43-37e2-40f4-b0ad-dcbae3119718)


### 📜 동료평가 <a id="동료평가"></a>

|Team Member| 조창욱 동료평가 |
| :--------------------------------------: | ------ |
|  조창욱  |  |
|  김서현  |  |
|  전기범  |  |
|  김민석  |  |
|  김소리  |  |


|Team Member| 김소리 동료평가 |
| :--------------------------------------: | ------ |
|  조창욱  |  |
|  김서현  |  |
|  전기범  |  |
|  김민석  |  |
|  김소리  |  |



|Team Member| 전기범 동료평가 |
| :--------------------------------------: | ------ |
|  조창욱  |  |
|  김서현  |  |
|  전기범  |  |
|  김민석  |  |
|  김소리  |  |


|Team Member| 김민석 동료평가 |
| :--------------------------------------: | ------ |
|  조창욱  |  |
|  김서현  |  |
|  전기범  |  |
|  김민석  |  |
|  김소리  |  |


|Team Member| 김소리 동료평가 |
| :--------------------------------------: | ------ |
|  조창욱  |  |
|  김서현  |  |
|  전기범  |  |
|  김민석  |  |
|  김소리  |  |


