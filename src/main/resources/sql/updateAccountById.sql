UPDATE `bank_database`.`accounts`
SET
`ACCOUNT_NAME` = :account_name,
`PHONE` = :phone,
`EMAIL` = :email,
`STATUS` = :status
WHERE `ACCOUNT_ID` = :id;
