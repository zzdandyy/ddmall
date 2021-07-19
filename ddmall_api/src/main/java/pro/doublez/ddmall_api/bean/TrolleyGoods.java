package pro.doublez.ddmall_api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/18 20:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TrolleyGoods {
    private long id;
    private String name;
    private double totalPrice;
    private int num;
}
