package base.exception;

/**
 * 异常信息接口,其他所以业务类的异常(写到 enum 中)都可以实现此接口
 *
 * @author : bamboo
 * @date : 2020-07-15
 */
public interface BaseExceptionCode {
    /**
     * 获取错误码
     * @return
     */
    String getErrorCode();

    /**
     * 获取错误信息
     * @return
     */
    String getErrorMessage();

    /**
     * 其他
     * @return
     */
    String getErrorTips();
}
