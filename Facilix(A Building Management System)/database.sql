USE master;

-- Create the database
CREATE DATABASE Facilix;
GO

-- Use the newly created database
USE Facilix;
GO

-- Create Users table
CREATE TABLE Users (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50) NOT NULL,
    Email NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    Phone NVARCHAR(50) NULL
);

-- Create Admins table
CREATE TABLE Admins (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50) NOT NULL,
    Email NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    Phone NVARCHAR(50) NULL
);

-- Create Flats table
CREATE TABLE Flats (
    Id INT IDENTITY(101,1) PRIMARY KEY,
    OwnerUserId INT, -- Foreign key referencing Users table
    ResidentUserId INT, -- Foreign key referencing Users table (nullable)
);

-- Create Utility_Bills table
CREATE TABLE Utility_Bills (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    FlatId INT, -- Foreign key referencing Flats table
    Water_Bill DECIMAL(18, 2),
    Gas_Bill DECIMAL(18, 2),
    IssuedDate DATE
);

-- Create Electrics_Bills table
CREATE TABLE Electrics_Bills (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    FlatId INT, -- Foreign key referencing Flats table
    IssuedDate DATE,
    BillAmount DECIMAL(18, 2)
);

-- Create Service_Charges table
CREATE TABLE Service_Charges (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    FlatId INT, -- Foreign key referencing Flats table
    LiftBill DECIMAL(18, 2),
    SecurityBill DECIMAL(18, 2),
    CommonElecBill DECIMAL(18, 2),
    GeneratorExpenses DECIMAL(18, 2),
    IssuedDate DATE
);

INSERT INTO Admins (Username, Email, Password, Phone)
VALUES
    ('susan_admin', 'susan.admin@example.com', 'Admin@Manager1', '111-111-1111'),
    ('robert_admin', 'robert.admin@example.com', 'Admin@HR2023', '222-222-2222'),
    ('linda_admin', 'linda.admin@example.com', 'Admin@Finance123', '333-333-3333'),
    ('daniel_admin', 'daniel.admin@example.com', 'Admin@Maintain', '444-444-4444'),
    ('jennifer_admin', 'jennifer.admin@example.com', 'Admin@Security', '555-555-5555'),
    ('william_admin', 'william.admin@example.com', 'Admin@IT2023', '666-666-6666'),
    ('maria_admin', 'maria.admin@example.com', 'Admin@Marketing', '777-777-7777'),
    ('joseph_admin', 'joseph.admin@example.com', 'Admin@Ops', '888-888-8888'),
    ('patricia_admin', 'patricia.admin@example.com', 'Admin@Legal567', '999-999-9999'),
    ('thomas_admin', 'thomas.admin@example.com', 'Admin@Support!', '000-000-0000');

INSERT INTO Users (Username, Email, Password, Phone)
VALUES
    ('johndoe', 'john.doe@example.com', 'securepass1', '123-456-7890'),
    ('marysmith', 'mary.smith@example.com', 'mypassword2', '987-654-3210'),
    ('davidjones', 'david.jones@example.com', 'pass1234', '555-555-5555'),
    ('emilybrown', 'emily.brown@example.com', '12345678', '999-888-7777'),
    ('michaelwilson', 'michael.wilson@example.com', 'mypass5', '444-333-2222'),
    ('oliviadavis', 'olivia.davis@example.com', 'mysecretpass', '777-666-5555'),
    ('williamjohnson', 'william.johnson@example.com', 'password123', '111-222-3333'),
    ('sophiagarcia', 'sophia.garcia@example.com', 'passw0rd', '222-333-4444'),
    ('jamesmartinez', 'james.martinez@example.com', '1234pass', '888-999-0000'),
    ('avalopez', 'ava.lopez@example.com', 'myp@ssw0rd', '666-777-8888');

INSERT INTO Flats (OwnerUserId, ResidentUserId)
VALUES
    (1, 1),
    (2, 2),
    (2, 3),
    (3, 3),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (9, 9);

INSERT INTO Utility_Bills (FlatId, Water_Bill, Gas_Bill, IssuedDate)
VALUES
    (101, 50.00, 30.00, '2023-07-01'),
    (102, 60.00, 35.00, '2023-07-01'),
    (101, NULL, NULL, '2023-06-01'),
    (102, NULL, NULL, '2023-06-01'),
    (101, 58.00, 36.00, '2023-05-01'),
    (102, 53.00, 33.00, '2023-05-01'),
    (103, 56.00, 34.00, '2023-05-01'),
    (101, NULL, NULL, '2023-04-01'),
    (102, 51.00, 30.00, '2023-04-01'),
    (103, 65.00, 37.00, '2023-04-01');

INSERT INTO Electrics_Bills (FlatId, IssuedDate, BillAmount)
VALUES
    (101, '2023-07-01', 50.00),
    (102, '2023-07-01', 60.00),
    (101, '2023-06-01', 55.00),
    (102, '2023-06-01', 52.00),
    (101, '2023-05-01', 58.00),
    (102, '2023-05-01', 53.00),
    (103, '2023-05-01', 56.00),
    (101, '2023-04-01', 54.00),
    (102, '2023-04-01', 51.00),
    (103, '2023-04-01', 57.00);

INSERT INTO Service_Charges (FlatId, LiftBill, SecurityBill, CommonElecBill, GeneratorExpenses, IssuedDate)
VALUES
    (101, 50.00, 30.00, 40.00, 20.00, '2023-07-01'),
    (102, 60.00, 35.00, 45.00, 25.00, '2023-07-01'),
    (101, 55.00, 32.00, 42.00, 22.00, '2023-06-01'),
    (102, 48.00, 28.00, 38.00, 18.00, '2023-06-01'),
    (101, 65.00, 37.00, 49.00, 27.00, '2023-05-01'),
    (102, 52.00, 31.00, 41.00, 21.00, '2023-05-01'),
    (103, 57.00, 33.00, 44.00, 23.00, '2023-05-01'),
    (101, 46.00, 27.00, 36.00, 16.00, '2023-04-01'),
    (102, 53.00, 29.00, 39.00, 19.00, '2023-04-01'),
    (103, 64.00, 36.00, 47.00, 26.00, '2023-04-01');

-- Create relationships
ALTER TABLE Flats
ADD CONSTRAINT FK_Flats_OwnerUserId FOREIGN KEY (OwnerUserId) REFERENCES Users (Id);

ALTER TABLE Flats
ADD CONSTRAINT FK_Flats_ResidentUserId FOREIGN KEY (ResidentUserId) REFERENCES Users (Id);

ALTER TABLE Utility_Bills
ADD CONSTRAINT FK_Utility_Bills_FlatId FOREIGN KEY (FlatId) REFERENCES Flats (Id);

ALTER TABLE Electrics_Bills
ADD CONSTRAINT FK_Electrics_Bills_FlatId FOREIGN KEY (FlatId) REFERENCES Flats (Id);

ALTER TABLE Service_Charges
ADD CONSTRAINT FK_Service_Charges_FlatId FOREIGN KEY (FlatId) REFERENCES Flats (Id);
