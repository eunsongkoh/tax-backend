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
    pid INT IDENTITY PRIMARY KEY,               
    userId INT NOT NULL,                         
    total DECIMAL(10, 2) NOT NULL,               
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE 
);


CREATE TABLE PItems (
    itemid INT IDENTITY PRIMARY KEY,             
    pid INT NOT NULL,                           
    price DECIMAL(10, 2) NOT NULL,               
    itemName VARCHAR(255) NOT NULL,             
    FOREIGN KEY (pid) REFERENCES purchases(pid) ON DELETE CASCADE 
);