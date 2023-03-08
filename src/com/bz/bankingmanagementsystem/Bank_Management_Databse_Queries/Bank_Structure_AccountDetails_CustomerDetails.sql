create database Banking_Management;

use Banking_Management;

create table CustomerDetails(
Id int auto_increment primary key,
firstName varchar(50) not null,
middleName varchar(50),
lastName varchar(50) not null,
mobileNumber long
);

create table AccountDetails(
Id int auto_increment primary key,
accountNumber bigint not null unique,
accountType varchar(50),
balance int,
branchCode int not null,
customerID int not null,
pinNumber int(4),
foreign key(customerID) references CustomerDetails(Id)
);

drop table CustomerDetails;
drop table AccountDetails;

insert into CustomerDetails(firstName, middleName, lastName, mobileNumber) values
("Ram","Kumar","Charan",7889455615),
("Rashmika","","Mandana",9878455623),
("Alia","Bhatt","Kapoor",9800004565),
("Rabindra","Nath","Tagore",7889478988);

insert into AccountDetails(accountNumber, accountType, balance, branchCode, customerID,pinNumber) values 
(140004500012, "Saving", 4565000, 150045, 1,7898),
(560002300078, "Current", 12002300, 450123, 2,7898),
(650004500078, "Current", 12002300, 450123, 4,7898),
(780009800078, "Current", 12002300, 650041, 3,7898),
(780009800075, "Saving", 12002300, 650041, 3,7898),
(650004500079, "Saving", 12002300, 450123, 4,7898),
(140004500013, "Current", 12002300, 150045, 1,7898);


select * from AccountDetails,CustomerDetails where AccountDetails.customerID = CustomerDetails.Id;
