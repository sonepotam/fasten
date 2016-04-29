DROP TABLE IF EXISTS messages_data CASCADE;
DROP TABLE IF EXISTS messages CASCADE;

DROP TABLE IF EXISTS users CASCADE;


drop sequence if EXISTS messages_seq;

create sequence messages_seq start with 1;

create TABLE users(
  username VARCHAR(250),
  password VARCHAR(20),
  email    VARCHAR(50) PRIMARY KEY ,
  enabled  BOOLEAN
);


create TABLE messages(
  id INTEGER PRIMARY KEY DEFAULT nextval( 'messages_seq'),
  sequence_id VARCHAR(250),
  message_type INTEGER
);



CREATE TABLE messages_data (
  message_id INTEGER,
  fieldname  VARCHAR(50),
  fieldvalue VARCHAR(250),
  PRIMARY KEY ( message_id, fieldname),
  FOREIGN KEY (message_id) REFERENCES messages(id) on DELETE CASCADE
);
