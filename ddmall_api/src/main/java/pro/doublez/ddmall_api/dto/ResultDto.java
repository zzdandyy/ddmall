package pro.doublez.ddmall_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 14:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResultDto<T> {
    private Integer code;  //返回状态码
    private String msg;   //消息
    private T bean;  //bean
}
