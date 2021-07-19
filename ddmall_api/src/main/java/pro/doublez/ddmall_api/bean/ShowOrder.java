package pro.doublez.ddmall_api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/19 21:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ShowOrder {
    private long id;
    private long uid;
    private String name;
    private int count;
    private double totalPrice;
}
