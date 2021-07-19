package pro.doublez.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/16 16:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    public static final String TABLENAME = "user_tb_user";

    private Integer id;
    private String username;
    private String password;
}
