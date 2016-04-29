# fasten
Небольшое тестовое приложение для работы с Websocket API

Порядок сборки и установки
1. Создать базу fasten в PostgreSQL
2. Файлы с настройками находятся в каталоге src\resources
   в каталоге db находятся файлы для работы с БД
   initDB.sql		скрипт для создания таблиц в БД
   populateDB.sql	скрипт для заполнения таблиц
   postgres.properties	файл настроек PostreSQL
   в каталоге spring находятся файлы настройки Spring
3. Сборка приложения производится командой
   mvn package
   Результатом сборки является fasten.war
4. Деплой приложения не реализован, т.к. не известно место установки
5. Приложение протестировано на Tomcat 8.x и должно быть запущено по адресу
   http://localhost:8080/fasten
6. Сокет открывается по адресу
   ws://localhost:8080/fasten/echo

Сообщения находятся в двух таблицах
messages	заголовки сообщений
message_data	блок data каждого сообщения
Связь таблиц производится по идентификатору сообщения.
При сохрании сообщения в таблицы пароль пользователя не сохраняется.

Пользователи хранятся в таблице users
Для добавления пользователя нужно изменить файл populateDB.sql
Собственный провайдер авторизации не реализован. 

Единственный пользователь, авторизованный в системе
имя пользователя	p@mail.ru 
пароль			1234


Использованы технологии 
Spring/Spring DATA Jpa/Hibernate/Spring REST
Bootstrap/jQuery


