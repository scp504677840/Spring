package main.exceptions;

/**
 * 书籍库存更新异常
 */
public class BookStockUpdateException extends RuntimeException {
    public BookStockUpdateException() {
    }

    public BookStockUpdateException(String message) {
        super(message);
    }

    public BookStockUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockUpdateException(Throwable cause) {
        super(cause);
    }

    public BookStockUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
