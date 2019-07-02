# 개인용 프로젝트

## 프로젝트 설명
 - 사용자가 로그인 및 지도정보를 통하여 장소검색 및 상세조회 , 과거 검색이력 , 실시간 검색순위 확인 기능 이 있는 웹 어플리케이션 입니다.


## 사용한 라이브러리
- Spring Boot : 백엔드 서버 구성
- Spring Security : 로그인 처리
- React.js : 프론트 구성
- lodash : json 데이터을 손쉽게 핸들링
- Semantic UI React : 화면 구성

## 테스트 방법
 - application.yml 을 열고 kakao 항목에 api_key 부분을 수정합니다.

```yml
kakao:
  local_api_url: https://dapi.kakao.com/v2/local/search/keyword.json
  api_key: <KAKAO API KEYS>
```

- testApp 폴더에서 다음 명령어를 실행
```
$ mvn spring-boot:run
```
- front-end/ 폴더에서 다음 명령어를 실행
```
$ npm install
$ npm start
```
-  자동으로 인메모리에 계정정보가 입력이 되며 계정정보는 다음과 같습니다.<br>
id : test, pwd : 1234

## 빌드 방법
1. front-end 폴더로 이동하여 다음 명령어를 실행합니다.
```
$ npm run build
```

2. front-end/build 폴더안의 있는 html 파일을 src/resource/templates 폴더에 삽입

3. front-end/build/static 폴더를 src/resource/static 에 복사.

4. testApp 폴더에서 다음 명령어를 실행
```
$ mvn clean package
```

## 동작 및 기능

- 로그인 화면
![ex_screenshot](./img/img1.png)

- 지도 검색화면
![ex_screenshot](./img/img2.png)

- 지도 검색 결과에서 이미지 클릭시 지도상으로 커스텀 오버레이 표시
![ex_screenshot](./img/img3.png)

- 마우스 오버시 상세정보가 출력되며 지도상세보기 링크 활성화
![ex_screenshot](./img/img4.png)

- 회원가입창
![ex_screenshot](./img/img5.png)