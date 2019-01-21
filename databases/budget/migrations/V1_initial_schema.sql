CREATE TABLE users (
  id         BIGINT(20) NOT NULL AUTO_INCREMENT,
  name       VARCHAR,

  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;