package pro.doublez.ddmall_api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/15 21:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SeckillGoods {
    public static final String TABLENAME = "tb_seckill_goods";

    private long id;
    private String name;
    private double price;
    private int count;
    private Date startTime;
    private Date endTime;
}
