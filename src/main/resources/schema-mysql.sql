-- MySQL production schema for Paperless Office
CREATE TABLE IF NOT EXISTS student (
  st_id VARCHAR(50) PRIMARY KEY,
  stNameEn VARCHAR(100),
  stNameBn VARCHAR(100),
  fatherNameEn VARCHAR(100),
  fatherNameBn VARCHAR(100),
  mobile VARCHAR(30),
  session VARCHAR(50),
  eduEmail VARCHAR(150) UNIQUE,
  personalEmail VARCHAR(150),
  password VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS teacher (
  id VARCHAR(50) PRIMARY KEY,
  nameEn VARCHAR(100),
  nameBn VARCHAR(100),
  mobile VARCHAR(30),
  designation VARCHAR(100),
  email VARCHAR(150) UNIQUE,
  dept VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
