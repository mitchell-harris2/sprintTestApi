
drop table customer;
CREATE TABLE if not exists customer (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(100) NOT NULL
);

commit;