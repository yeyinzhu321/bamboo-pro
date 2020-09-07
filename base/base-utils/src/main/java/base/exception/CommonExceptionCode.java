package base.exception;

import com.google.common.collect.ImmutableMap;

/**
 *
 * @author : bamboo
 * @date : 2020-07-15
 */
public enum CommonExceptionCode implements BaseExceptionCode {
    OK("200000", "请求成功"),
    SERVER_ERROR("500001", "服务端异常, 请稍后再试");

    private final String errorCode;
    private final String errorMessage;
    private static final ImmutableMap<String, CommonExceptionCode> CACHE;

    CommonExceptionCode(String errorCode, String errorMessage) {
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

    static {
        ImmutableMap.Builder<String, CommonExceptionCode> builder = ImmutableMap.builder();
        CommonExceptionCode[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            CommonExceptionCode statusCode = var1[var3];
            builder.put(statusCode.errorCode, statusCode);
        }

        CACHE = builder.build();
    }
}
