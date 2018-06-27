package main.exceptions;

/**
 * 书籍信息异常
 */
public class BookInfoException extends RuntimeException {
    public BookInfoException() {
    }

    public BookInfoException(String message) {
        super(message);
    }

    public BookInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookInfoException(Throwable cause) {
        super(cause);
    }

    public BookInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
