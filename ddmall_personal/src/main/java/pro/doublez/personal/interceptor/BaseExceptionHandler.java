package pro.doublez.personal.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.doublez.ddmall_api.constant.StatusCode;
import pro.doublez.ddmall_api.dto.ResultDto;
import pro.doublez.ddmall_api.utils.BaseException;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 15:38
 */
//用户异常处理类
@ControllerAdvice()
public class BaseExceptionHandler {
    //自定义的异常
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public ResultDto<Boolean> error(BaseException e) {
        return new ResultDto<>(e.getCode(), e.getMessage(), false);
    }

    //未知异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDto<Boolean> error(Exception e) {
        e.printStackTrace();
        return new ResultDto<>(StatusCode.ERROR, e.getLocalizedMessage(), false);
    }
}
