# 실행 방법
본 Project 는 Gradle 기반에서 작동되었어요. H2 Database 를 사용하였고 해당하는 부분에 대해서
application.properties 에서 In-memory 방식 혹은 Embedded 방식을 선택하여 가동하여 주세요

* 자체적인 실행은 윈도우 기반의 IntelliJ 에서 bootRun 을 통하여 실행할 수 있어요
* 내장 톰캣을 이용한 8080 포트가 가동되면 http://localhost:8080 과 같이 사용할 수 있어요
* 원래는 Spring Security 를 사용하는 도중이였는데 살짝 문제가 생겨서 배제시켰어요
* Linux 를 사용하는 경우는 Bash 파일 내에서 jar 를 지정하고 Daemon 화 하여 실행할 수 있어요.


# 평가를 할 수 있는 API
* 댓글은 필수 옵션이 아니에요
* 좋아요나 싫어요는 반드시 있어야 하고, 한번 평가한 작품에 대해서는 평가가 불가능해요
* Query Parameter로 userId 와 contentId를 사용하고 RequestBody로는 like, unlike, comment 를 사용해요
* comment 에는 특수문자를 사용할 수 없게 정규식을 사용했어요 
* comment 는 없어도 무방해요
<code>
POST http://localhost:8080/evaluations?userId=5&contentId=2

{
  "like" : false,
  "unlike" : true
}
</code>

# 상위 좋아요 3개와 싫어요 3개를 통합한 API
<code>
GET http://localhost:8080/evaluations/top-contents
</code>

# 사용자별 로그 확인 API
<code>
GET http://localhost:8080/search-history/{id}
</code>

# 1주일간 사용자 중 성인 작품을 3작품 이상 조회한 사람을 조회하는 API
<code>
GET http://localhost:8080/user-views/adult-contents
</code>


# 요금 변경 API (무료, 유료)
* 금액은 0원에서 500원의 제한이 걸려있어요
* PUT Method를 사용해요
* 원한다면 http 폴더의 service.http 파일에서 정의해서 실험해볼 수 있어요

<code>
PUT http://localhost:8080/contents/{contentId}/fee
Content-Type : application/Json
</code>

# 유저 기록 삭제 API
* 유저가 존재하지 않을 때의 예외 로직을 추가 했어요
<code>
DELETE http://localhost:8080/users/{userId}
</code>

# Entity 의 예시 데이터를 삽입해주세요
### User Entity 의 예제 데이터는 아래와 같은 예시 코드로 삽입할 수 있어요
<code>
INSERT INTO APP_USER (user_name, user_email, gender, type, register_date) 
VALUES 
('john_doe', 'john.doe@example.com', 'male', 'normal', '2022-01-01'),
('jane_doe', 'jane.doe@example.com', 'female', 'normal', '2022-02-01'),
('sam_smith', 'sam.smith@example.com', 'male', 'adult', '2022-03-01'),
('lisa_ray', 'lisa.ray@example.com', 'female', 'normal', '2022-04-01'),
('alex_taylor', 'alex.taylor@example.com', 'male', 'adult', '2022-05-01');
</code>


### 다음 차례로는 Content Entity 의 데이터를 삽입해야 해요
<code>
INSERT INTO CONTENT (CONTENTS_NAME , author, coin, OPEN_DATE, ADULT) VALUES
('Content 1', 'Author A', 100, '2022-01-01', true),
('Content 2', 'Author B', 200, '2022-02-01', true),
('Content 3', 'Author C', 150, '2022-03-01', false),
('Content 4', 'Author D', 250, '2022-04-01', false),
('Content 5', 'Author E', 300, '2022-05-01', true);
</code>

### 다음 차례로 Episode Entity 의 데이터를 삽입해주세요
* Episode Entity 는 Content Entity 와 Constraint 를 가지고 있기 때문에 반드시 위의 순서를 지켜야해요

<code>
INSERT INTO EPISODE (CONTENT_ID , EPISODE_NUMBER , EPISODE_TITLE , RELEASE_DATE ) VALUES
(1, 1, 'Episode 1 of Content 1', '2022-01-10'),
(1, 2, 'Episode 2 of Content 1', '2022-01-17'),
(2, 1, 'Episode 1 of Content 2', '2022-02-10'),
(2, 2, 'Episode 2 of Content 2', '2022-02-17'),
(3, 1, 'Episode 1 of Content 3', '2022-03-10'),
(3, 2, 'Episode 2 of Content 3', '2022-03-17'),
(4, 1, 'Episode 1 of Content 4', '2022-04-10'),
(4, 2, 'Episode 2 of Content 4', '2022-04-17'),
(5, 1, 'Episode 1 of Content 5', '2022-05-10'),
(5, 2, 'Episode 2 of Content 5', '2022-05-17');
</code>