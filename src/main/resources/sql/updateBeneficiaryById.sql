UPDATE `bank_database`.`beneficiary`
SET
`ACCOUNT_ID` =:account_id,
`BENE_ACCOUNT_ID` =:bene_account_id,
`BENE_IFSCCODE` =:bene_ifsccode,
`BENE_NAME` =:bene_name,
`STATUS` =:status
WHERE `ACCOUNT_ID` = :id;
