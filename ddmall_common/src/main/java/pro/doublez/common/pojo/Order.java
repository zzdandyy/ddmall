package pro.doublez.common.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/13 12:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Order {
    public static final String TABLENAME = "tb_order";

    //订单状态
    public static final Integer CANCEL = -1;
    public static final Integer NEW = 0;
    public static final Integer PAY = 1;

    //订单类型
    public static final Integer COMMON = 1;
    public static final Integer SECKILL = 2;

    private long id;
    private int uid;
    private long gid;
    private int count;
    private double totalPrice;
    private int status;
    private int form;
}
