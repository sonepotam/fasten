DELETE FROM USERS;
DELETE FROM MESSAGES;

ALTER SEQUENCE MESSAGES_seq RESTART WITH 1;


INSERT into USERS( username, password, email, enabled) values( 'pavel', '1234', 'p@mail.ru', true);

commit;