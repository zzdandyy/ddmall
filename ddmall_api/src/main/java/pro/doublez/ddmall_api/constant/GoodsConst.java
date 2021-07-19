package pro.doublez.ddmall_api.constant;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/12 17:21
 */
public class GoodsConst {
    //商品库存
    public static final int MAXCOUNT = 100000;

    //商品状态
    public static final int DELETE = -2;  // 逻辑删除
    public static final int NOPUTAWAY = -1; // 下架
    public static final int NEWLY = 0; //新增
    public static final int PUTAWAY = 1; //上架
}
