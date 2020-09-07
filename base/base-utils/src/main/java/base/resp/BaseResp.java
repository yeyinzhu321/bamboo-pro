package base.resp;

import com.bamboo.base.exception.BaseException;
import com.bamboo.base.exception.BaseExceptionCode;
import com.bamboo.base.exception.CommonExceptionCode;

/**
 * 通用返回对象
 *
 * @author : bamboo
 * @date : 2020-07-15
 */
public class BaseResp<T> {
    private static final long serialVersionUID = -414005101985309470L;
    private boolean success = false;
    private String respCode;
    private String respMsg;
    private T data;

    public BaseResp() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRespMsg() {
        return this.respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 只返回 respMsg,respCode 默认是 SERVER_ERROR 的 code
     *
     * @param respMsg
     * @return
     */
    public BaseResp<T> fail(String respMsg) {
        this.setSuccess(false);
        this.setRespCode(CommonExceptionCode.SERVER_ERROR.getErrorCode());
        this.setRespMsg(respMsg);
        return this;
    }

    /**
     * 只返回异常 code 的枚举
     *
     * @param errorCode
     * @return
     */
    public BaseResp<T> fail(BaseExceptionCode errorCode) {
        this.setSuccess(false);
        this.setRespCode(errorCode.getErrorCode());
        this.setRespMsg(errorCode.getErrorMessage());
        return this;
    }

    /**
     * 返回 respCode 和 respMsg
     *
     * @param respCode
     * @param respMsg
     * @return
     */
    public BaseResp<T> fail(String respCode, String respMsg) {
        this.setSuccess(false);
        this.setRespCode(respCode);
        this.setRespMsg(respMsg);
        return this;
    }

    /**
     * 返回异常 code 的枚举类,然后还有 appendMsg(拼接在 errorCode 的 msg 后)
     *
     * @param errorCode
     * @param appendMessage
     * @return
     */
    public BaseResp<T> fail(BaseExceptionCode errorCode, String appendMessage) {
        this.setSuccess(false);
        this.setRespCode(errorCode.getErrorCode());
        this.setRespMsg(errorCode.getErrorMessage() + ":" + appendMessage);
        return this;
    }

    /**
     * 返回异常
     *
     * @param baseException
     * @return
     */
    public BaseResp<T> fail(BaseException baseException) {
        this.setSuccess(false);
        this.setRespCode(baseException.getErrorCode());
        this.setRespMsg(baseException.getMessage());
        return this;
    }

    /**
     * 成功返回,只带一个数据
     *
     * @param model
     * @return
     */
    public BaseResp<T> success(T model) {
        this.setSuccess(true);
        this.setData(model);
        return this;
    }

    /**
     * 成功返回,没有数据,只有 respMsg, code 默认是 OK 的 code
     *
     * @param respMsg
     * @return
     */
    public BaseResp<T> success(String respMsg) {
        this.setSuccess(true);
        this.setData(null);
        this.setRespCode(CommonExceptionCode.OK.getErrorCode());
        this.setRespMsg(respMsg);
        return this;
    }

    /**
     * 成功返回 返回 model 和 respMsg
     *
     * @param model
     * @param respMsg
     * @return
     */
    public BaseResp<T> success(T model, String respMsg) {
        this.setRespCode(CommonExceptionCode.OK.getErrorCode());
        this.setRespMsg(respMsg);
        this.setSuccess(true);
        this.setData(model);
        return this;
    }

    /**
     * 成功返回 返回 respCode 和 respMsg
     *
     * @param respCode
     * @param respMsg
     * @return
     */
    public BaseResp<T> success(String respCode, String respMsg) {
        this.setRespCode(respCode);
        this.setRespMsg(respMsg);
        this.setSuccess(true);
        this.setData(null);
        return this;
    }

    /**
     * 成功返回 返回 数据和 respCode 和 respMsg
     *
     * @param model
     * @param respCode
     * @param respMsg
     * @return
     */
    public BaseResp<T> success(T model, String respCode, String respMsg) {
        this.setRespCode(respCode);
        this.setRespMsg(respMsg);
        this.setSuccess(true);
        this.setData(model);
        return this;
    }

    public static <T> BaseResp<T> createSuccessResult(T model) {
        BaseResp<T> rt = new BaseResp();
        return rt.success(model);
    }

    public static <T> BaseResp<T> createSuccessResult(String respMsg) {
        BaseResp<T> rt = new BaseResp();
        return rt.success(respMsg);
    }

    public static <T> BaseResp<T> createSuccessResult(T model, String respCode, String respMsg) {
        BaseResp<T> rt = new BaseResp();
        return rt.success(model, respCode, respMsg);
    }

    public static <T> BaseResp<T> createSuccessResult(String respCode, String respMsg) {
        BaseResp<T> rt = new BaseResp();
        return rt.success(respCode, respMsg);
    }

    public static <T> BaseResp<T> createFailResult(String respMsg) {
        BaseResp<T> rt = new BaseResp();
        return rt.fail(respMsg);
    }

    public static <T> BaseResp<T> createFailResult(BaseExceptionCode errorCode) {
        BaseResp<T> rt = new BaseResp();
        return rt.fail(errorCode);
    }

    public static <T> BaseResp<T> createFailResult(BaseExceptionCode errorCode, String appendMessage) {
        BaseResp<T> rt = new BaseResp();
        return rt.fail(errorCode, appendMessage);
    }

    public static <T> BaseResp<T> createFailResult(String respCode, String respMsg) {
        BaseResp<T> rt = new BaseResp();
        return rt.fail(respCode, respMsg);
    }
}
