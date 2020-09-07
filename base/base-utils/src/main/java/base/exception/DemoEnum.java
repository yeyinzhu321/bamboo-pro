package base.exception;

/**
 * @author : bamboo
 * @date : 2020-07-15
 */
public enum DemoEnum implements BaseExceptionCode{
    OK("200000", "请求成功"),
    SERVER_ERROR("500000", "后台小哥哥正在努力解决中.....")
    ;
    private final String errorCode;

    private final String errorMessage;

    DemoEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public String getErrorTips() {
        return null;
    }
}
