INSERT INTO `bank_database`.`transactions`
(`Account_Id`,
`Date`,
`Type`,
`Amount`,
`Status`,
`Remarks`)
VALUES
(:account_id,
 :dateValue,
 :type,
 :amount,
 :status,
 :remarks);
