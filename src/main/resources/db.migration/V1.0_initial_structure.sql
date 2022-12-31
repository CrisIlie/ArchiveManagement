CREATE TABLE box (
                id int NOT NULL AUTO_INCREMENT,
                boxType varchar(255) DEFAULT NULL,
                clientBoxCode varchar(255) DEFAULT NULL,
                clientName varchar(255) DEFAULT NULL,
                departmentName varchar(255) DEFAULT NULL,
                boxSummary varchar(255) DEFAULT NULL,
                nomenclatureId varchar(10) DEFAULT NULL,
                beginningDate datetime(6)  DEFAULT NULL,
                endDate datetime(6)  DEFAULT NULL,
                storageTime int DEFAULT NULL,
                PRIMARY KEY (id)
);

CREATE TABLE client (
                     id int NOT NULL AUTO_INCREMENT,
                     clientName varchar(255) DEFAULT NULL,
                     address varchar(255) DEFAULT NULL,
                     clientEmail varchar(255) DEFAULT NULL,
                     PRIMARY KEY (id)
);

CREATE TABLE department (
                     id int NOT NULL AUTO_INCREMENT,
                     departmentName varchar(255) DEFAULT NULL,
                     PRIMARY KEY (id)
);

CREATE TABLE document (
                     id int NOT NULL AUTO_INCREMENT,
                     documentTitle varchar(255) DEFAULT NULL,
                     documentDescription varchar(255) DEFAULT NULL,
                     documentDepartment varchar(255) DEFAULT NULL,
                     PRIMARY KEY (id)
);

CREATE TABLE emptyBox (
                     id int NOT NULL AUTO_INCREMENT,
                     boxType varchar(255) DEFAULT NULL,
                     stock int(10) DEFAULT NULL,
                     PRIMARY KEY (id)
);

CREATE TABLE user (
                 id int NOT NULL AUTO_INCREMENT,
                 userName varchar(255) DEFAULT NULL,
                 userEmail varchar(255) DEFAULT NULL,
                 PRIMARY KEY (id)
);