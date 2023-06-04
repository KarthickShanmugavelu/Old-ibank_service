INSERT INTO `bank_database`.`beneficiary`
(`ACCOUNT_ID`,
`BENE_ACCOUNT_ID`,
`BENE_IFSCCODE`,
`BENE_NAME`,
`STATUS`)
VALUES
(:account_id,
:bene_account_id,
:bene_ifsccode,
:bene_name,
:status);
