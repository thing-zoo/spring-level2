# spring-level2
회원가입, 로그인 기능이 추가된 나만의 블로그 백엔드 서버 만들기

## Convention
### code
- setter 사용을 제한한다.
- 변수명은 CamelCase로 한다.
- 변수명이나 메서드명에 줄임말을 사용하지 않는다.
- 한 줄에 점을 2~3개 이내로 찍는다.
- 메서드와 메서드 사이에 공백 라인을 한 라인 둔다.
- 주석을 달아주자.

### commit message
[커밋 메세지 컨벤션](https://velog.io/@archivvonjang/Git-Commit-Message-Convention)을 참고하자

## ERD
<img width="743" alt="스크린샷 2023-06-29 오후 5 27 29" src="https://github.com/thing-zoo/spring-level2/assets/62596783/efc5968b-edbc-47b7-916b-339242cad8e5">

## API 명세
| Description  | Method | URI                 | Request Header | Request                                                                                                     | Response Header | Response                                                                                                                                                                                         | Status Code | 
|--------------| - |---------------------|----------------|-------------------------------------------------------------------------------------------------------------|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|
| 회원가입         | POST | `/api/users/signup` |                | {<br>"username":"aaa1",<br>"password": "AAAaaa111"<br>}                                                     |                 | "회원가입 성공"                                                                                                                                                                                        | 200         |
| 로그인          | POST | `/api/users/login`  |                | {<br>"username":"aaa1",<br>"password": "AAAaaa111"<br>}                                                     | Token           | "로그인 성공"                                                                                                                                                                                         | 200         |
| 게시글 작성       | POST | `/api/posts`        | Token          | {<br>"title": "title1",<br>"content": "content1"<br>}   |                 | {<br>"id": 1,<br>"title": "title1",<br>"content": "content1",<br>"username":"aaa1",<br>"createdAt": "2023-01-01T12:34:56.78900",<br>"modifiedAt": "2023-01-01T12:34:56.78900"<br>}               |             |
| 전체 게시글 목록 조회 | GET | `/api/posts`        |                |                                                                                                             |                 | {<br>{<br>"id": 1,<br>"title": "title1",<br>"content": "content1",<br>"username":"aaa1",<br>"createdAt": "2023-01-01T12:34:56.78900",<br>"modifiedAt": "2023-01-01T12:34:56.78900"<br>},...<br>} |             |
| 선택한 게시글 조회   | GET | `/api/posts/{id}`   |                |                                                                                                             |                 | {<br>"id": 1,<br>"title": "title11",<br>"content": "content11",<br>"username":"aaa1",<br>"createdAt": "2023-01-01T12:34:56.78900",<br>"modifiedAt": "2023-01-02T12:34:56.78900"<br>}             |             |
| 선택한 게시글 수정   | PUT | `/api/posts/{id}`   | Token          | {<br>"title": "title11",<br>"content": "content11"} |                 | {<br>"id": 1,<br>"title": "title11",<br>"content": "content11",<br>"username":"aaa1",<br>"createdAt": "2023-01-01T12:34:56.78900",<br>"modifiedAt": "2023-01-02T12:34:56.78900"<br>}             |             |
| 선택한 게시글 삭제   | DELETE | `/api/posts/{id}`   | Token          |                                                                            |                 | "게시글 삭제 성공"                                                                                                                                                                                       | 200         |
