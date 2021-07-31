-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-07-31 14:21:23.904

-- tables
-- Table: cn_contact
CREATE TABLE cn_contact (
    contact_id serial  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    user_name varchar(50)  NOT NULL,
    email varchar(100)  NOT NULL,
    date_of_birth timestamp  NOT NULL,
    seed varchar(50)  NOT NULL,
    CONSTRAINT cn_contact_pk PRIMARY KEY (contact_id)
);

-- Table: cn_relation
CREATE TABLE cn_relation (
    relation_id serial  NOT NULL,
    acquaintance_date timestamp  NOT NULL,
    contact_id int  NOT NULL,
    user_id int  NOT NULL,
    relation varchar(50)  NOT NULL,
    status smallint  NOT NULL,
    CONSTRAINT cn_relation_pk PRIMARY KEY (relation_id)
);

-- foreign keys
-- Reference: fk_cn_re1 (table: cn_relation)
ALTER TABLE cn_relation ADD CONSTRAINT fk_cn_re1
    FOREIGN KEY (contact_id)
    REFERENCES cn_contact (contact_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: fk_cn_re2 (table: cn_relation)
ALTER TABLE cn_relation ADD CONSTRAINT fk_cn_re2
    FOREIGN KEY (user_id)
    REFERENCES cn_contact (contact_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

