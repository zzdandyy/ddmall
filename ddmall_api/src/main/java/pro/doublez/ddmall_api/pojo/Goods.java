package pro.doublez.ddmall_api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/12 15:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Goods {
    //数据库和表
    public static final String TABLENAME = "goods_tb_goods";
    //商品状态
    public static final int DELETE = -2;  // 逻辑删除
    public static final int NOPUTAWAY = -1; // 下架
    public static final int NEWLY = 0; //新增
    public static final int PUTAWAY = 1; //上架
    //商品库存
    public static final int MAXCOUNT = 100000;

    private long id;
    private String name;
    private double price;
    private int count;
    private int status;
}
