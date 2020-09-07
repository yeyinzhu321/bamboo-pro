package base.exception;
import java.util.Map;

/**
 * 基础异常,所以的业务异常都可以继承这个类，进行自己个性化的定制个性
 *
 * @author : bamboo
 * @date : 2020-07-15
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -3962157388406613297L;
    private String errorCode;
    private String errorTips;
    private Map<String, String> errorFieldMap;
    private BaseExceptionCode baseErrorCode;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(String errorCode, String message, String errorTips) {
        super(message);
        this.errorCode = errorCode;
        this.errorTips = errorTips;
    }

    public BaseException(BaseExceptionCode baseErrorCode, String message) {
        super(message);
        this.baseErrorCode = baseErrorCode;
    }

    public BaseException(BaseExceptionCode baseErrorCode, String message, String errorTips) {
        super(message);
        this.baseErrorCode = baseErrorCode;
        this.errorTips = errorTips;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(BaseExceptionCode baseErrorCode) {
        this.baseErrorCode = baseErrorCode;
    }

    public BaseException(BaseExceptionCode baseErrorCode, String message, Throwable cause) {
        super(message, cause);
        this.baseErrorCode = baseErrorCode;
    }

    public BaseException(String errorCode, String message, String errorTips, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorTips = errorTips;
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(BaseExceptionCode baseErrorCode, Throwable cause) {
        super(cause);
        this.baseErrorCode = baseErrorCode;
    }

    public BaseException(BaseExceptionCode baseErrorCode, Map<String, String> errorFieldMap) {
        this.baseErrorCode = baseErrorCode;
        this.errorFieldMap = errorFieldMap;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorTips() {
        return this.errorTips;
    }

    public BaseExceptionCode getBaseErrorCode() {
        return this.baseErrorCode;
    }

    public boolean hasFlashErrorCode() {
        return this.baseErrorCode != null;
    }
}
