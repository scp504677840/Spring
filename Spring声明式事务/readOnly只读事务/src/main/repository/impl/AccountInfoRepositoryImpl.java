package main.repository.impl;

import main.exceptions.AccountBalanceException;
import main.exceptions.AccountBalanceUpdateException;
import main.exceptions.QueryException;
import main.exceptions.UpdateException;
import main.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository("accountInfoRepository")
public class AccountInfoRepositoryImpl implements AccountInfoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据账户Id查询账户余额
     *
     * @param accountId 账户Id
     * @return 账户余额
     */
    @Override
    public BigDecimal getAccountBalanceByAccountId(BigInteger accountId) {
        String sql = "select balance from account_info where id = ?";
        Object[] args = new Object[]{accountId};
        BigDecimal balance;
        try {
            balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, args);
        } catch (DataAccessException e) {
            throw new AccountBalanceException(e);
        }
        return balance;
    }

    /**
     * 根据账户Id更新账户余额
     *
     * @param accountId 账户Id
     * @param balance   账户余额
     * @return 是否更新成功
     */
    @Override
    public Boolean updateBalanceByAccountId(BigInteger accountId, BigDecimal balance) {
        String sql = "update account_info set balance = ? where id = ?";
        Object[] args = new Object[]{balance, accountId};
        try {
            int update = jdbcTemplate.update(sql, args);
            if (update > 0) {
                return Boolean.TRUE;
            }
        } catch (DataAccessException e) {
            throw new AccountBalanceUpdateException(e);
        }
        return Boolean.FALSE;
    }
}
