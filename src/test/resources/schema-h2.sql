create schema sa;
use sa;

CREATE TABLE customer (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(100) NOT NULL
);

commit;