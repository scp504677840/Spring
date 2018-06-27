package main.exceptions;

/**
 * 账户余额更新异常
 */
public class AccountBalanceUpdateException extends RuntimeException {
    public AccountBalanceUpdateException() {
    }

    public AccountBalanceUpdateException(String message) {
        super(message);
    }

    public AccountBalanceUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountBalanceUpdateException(Throwable cause) {
        super(cause);
    }

    public AccountBalanceUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
