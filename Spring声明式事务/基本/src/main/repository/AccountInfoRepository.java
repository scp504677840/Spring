package main.repository;

import main.exceptions.QueryException;
import main.exceptions.UpdateException;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface AccountInfoRepository {
    /**
     * 根据账户Id查询账户余额
     *
     * @param accountId 账户Id
     * @return 账户余额
     */
    BigDecimal getAccountBalanceByAccountId(BigInteger accountId);

    /**
     * 根据账户Id更新账户余额
     *
     * @param accountId 账户Id
     * @param balance   账户余额
     * @return 是否更新成功
     */
    Boolean updateBalanceByAccountId(BigInteger accountId, BigDecimal balance);
}
