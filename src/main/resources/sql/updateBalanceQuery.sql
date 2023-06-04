UPDATE `bank_database`.`account_balance`
SET
`Balance` = :newBalance
WHERE `Account_Id` = :account_id;
