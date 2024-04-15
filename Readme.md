###  Инструкция по запуску контейнера

Все необходимые настройки описаны в docker-compose.yml. Поэтому основные манипуляции будут с docker-compose.
___
1. Процесс создания образа.
Чтобы собрать описанные сервисы в docker-compose.yml используем команду: `$ docker-compose build`
___
2. Теперь надо развернуть сервисы из docker-образа. Можно добавить `-d` для запуска в фоновом режиме: `$ docker-compose up`
___
3. При работе из терминала, в случае отсутствия логов, необходимо прописать команду с названием того контейнера, где находятся интересующие нас логи. Сделать это можно через команду  `$ docker-compose logs` с указанием название того контейнера, чьи логи нас интересуют. Узнать название контейнеров можно через команду `$ docker ps --all`
___
4. Для того, чтобы звершить работу и потушить контейнеры: `$ docker-compose down` или `docker stop $(docker ps -a -q)`
___
### Примеры запросов в REST API
TaskController могут использовать только аутентифицированные пользователи 
Отредактировать или удалить таску может только ее создатель
Оставить комментарии или назначить ответственных за ее выполнение можно при создании или при редактировании.
UserController могут использовать все пользователи.

___
`GET` Запрос `localhost:8080/tasks/current-list`  на получение добавленных тасков выведет данные в следующем формате: 

```json
[
  {
    "id": 1,
    "status": "NEW",
    "title": "CLONE - [Backend] Spring Boot: Implement data caching using Redis in Authorization Service #23",
    "text": "You need to describe the configuration and send it to QA",
    "comment": [
      "It is necessary to close the tike by June 28",
      "The task has been completed"
    ],
    "owner": {
      "id": 1,
      "role": "USER",
      "username": "nesquik",
      "firstname": "Dean",
      "lastname": "Winchester"
    },
    "usernames": [
      "Mercy Links (QA)",
      "John Colt (Java)"
    ],
    "createdAt": "2024-04-14T20:45:45.840418",
    "updatedAt": "2024-04-14T20:45:45.840418"
  }
]
```

___
`POST` Запрос `localhost:8080/tasks` на добавление таска:

```json
{
  "title":"[Backend] Implement data caching using Redis in Authorization Service #23",
  "text": "You need to describe the configuration and send it to QA",
  "comments": [ "It is necessary to close the tike by June 28",
    "The task has been completed" ],
  "usernames": [
    "John Colt (Java)", "Mercy Links (QA)"
  ]
}
```

___
`POST` Запрос `localhost:8080/tasks/update{id}` на изменение данных в существующем таске:
```json
{
  "comment": "FIX RESPONSIBLE USERS",
  "usernames":    [
    "Mike", "Luis"
  ]
}
```
___
`DELETE` Запрос на удаление, доступен только овнеру таска по ID. Например
`localhost:8080/tasks/delte/{id}`
___

`POST` Запрос не регистрацию, доступен всем пользователям `localhost:8080/users/`
```json
{
  "username": "nesquik",
  "password": "Dsd23@34@!s",
  "firstname": "John",
  "lastname": "Colt"
}
```
___
`POST` Запрос на авторизацию, доступен всем пользователям `localhost:8080/users/authentication`
```json
{
  "username": "nesquik",
  "password": "Dsd23@34@!s"
}
```

___

