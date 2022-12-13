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

