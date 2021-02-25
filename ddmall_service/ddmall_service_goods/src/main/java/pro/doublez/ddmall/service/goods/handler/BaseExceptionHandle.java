package pro.doublez.ddmall.service.goods.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;

/*
统一异常处理类
 */

@ControllerAdvice //声明该类是一个增强类
public class BaseExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,"当前系统繁忙，请您稍后重试");
    }
}
