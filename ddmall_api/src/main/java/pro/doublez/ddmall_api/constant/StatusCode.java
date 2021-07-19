package pro.doublez.ddmall_api.constant;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 14:41
 */
public class StatusCode {

    public static final int OK=20000;//成功
    public static final int ERROR =40000;//未知异常
    public static final int USERERROR = 40001; //用户异常
    public static final int ADMINERROR =40002; //管理员异常
    public static final int GOODSERROR =40003; //商品异常
    public static final int SHOPPINGERROR =40004; //购物车异常
    public static final int ORDERERROR =40005; //订单异常
    public static final int SECKILLERROR =40006; //秒杀异常

}
