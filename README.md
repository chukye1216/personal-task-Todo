# API 명세서

## 일정 API

![img.png](img/img.png)

## 댓글 API

![img.png](img/commentimg.png)


## ERD 작성
```plaintext
Todo
---------
ID (PK)
Username
Title
Content
CreatedDate
ModifiedDate

Comment
---------
ID (PK)
TodoID (FK to Todo)
Username
Content
CreatedDate
ModifiedDate
