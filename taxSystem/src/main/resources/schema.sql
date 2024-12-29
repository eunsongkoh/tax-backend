DROP TABLE IF EXISTS PItems;
DROP TABLE IF EXISTS Purchases;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
    UserId INT IDENTITY PRIMARY KEY,             
    UserName VARCHAR(20) NOT NULL UNIQUE,      
    Email VARCHAR(255) NOT NULL UNIQUE,        
    PasswordHash VARCHAR(255) NOT NULL
);

CREATE TABLE Purchases (
    Pid INT IDENTITY PRIMARY KEY,               
    UserId INT NOT NULL,                         
    Total DECIMAL(10, 2) NOT NULL,               
    FOREIGN KEY (UserId) REFERENCES Users(UserId) ON DELETE CASCADE 
);


CREATE TABLE PItems (
    ItemId INT IDENTITY PRIMARY KEY,             
    Pid INT NOT NULL,                           
    Price DECIMAL(10, 2) NOT NULL,               
    ItemName VARCHAR(255) NOT NULL,        
    Quantity INT NOT NULL,     
    FOREIGN KEY (Pid) REFERENCES Purchases(Pid) ON DELETE CASCADE 
);