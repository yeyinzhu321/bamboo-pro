package base.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 模拟的一个业务异常类,其他的业务异常类都可以参考这个来写
 *
 * @author : bamboo
 * @date : 2020-07-15
 */
@Slf4j
public class DemoException extends BaseException {
    private static final long serialVersionUID = 8098049294209874435L;

    public DemoException(String errorCode, String message) {
        super(errorCode, message);
    }

    public DemoException(Throwable cause) {
        super(cause);
    }

    public DemoException(BaseExceptionCode maintainerErrorCodeEnum) {
        super(maintainerErrorCodeEnum.getErrorCode(), maintainerErrorCodeEnum.getErrorMessage());
    }

    public DemoException(String message) {
        super(message);
    }

    public static void createFailResult(BaseExceptionCode baseExceptionCode) {
        throw new DemoException(baseExceptionCode);
    }

    public static void createFailResult(String errorCode, String errorMsg) {
        throw new DemoException(errorCode, errorMsg);
    }

    public static void failBuild(Boolean isSuccess, BaseExceptionCode baseExceptionCode) {
        if (isSuccess) {
            throw new DemoException(baseExceptionCode);
        }
    }

    public static void failBuild(Boolean isSuccess, BaseExceptionCode baseExceptionCode, String message) {
        if (isSuccess) {
            StringBuilder info = Objects.nonNull(message)
                    ? new StringBuilder(baseExceptionCode.getErrorMessage()).append(",").append(message)
                    : new StringBuilder(baseExceptionCode.getErrorMessage()).append(" ");
            log.info(info.toString());
            throw new DemoException(baseExceptionCode);
        }
    }
}