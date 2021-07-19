package pro.doublez.ddmall_api.utils;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 15:28
 */
//自定义异常类
public class BaseException extends RuntimeException {

    private Integer code;

    public BaseException(Integer code,String msg) {
        super(msg);
        setCode(code);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
