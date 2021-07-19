package pro.doublez.order.pojo;


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
    public static final int CANCEL = -1;
    public static final int NEW = 0;
    public static final int PAY = 1;

    //订单类型
    public static final int COMMON = 1;
    public static final int SECKILL = 2;

    private long id;
    private int uid;
    private long gid;
    private int count;
    private double totalPrice;
    private int status;
    private int form;
}
