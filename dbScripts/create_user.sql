-- Drop user first if they exist
DROP USER if exists 'bank_admin'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'bank_admin'@'localhost' IDENTIFIED BY 'bank_admin';

GRANT ALL PRIVILEGES ON * . * TO 'bank_admin'@'localhost';