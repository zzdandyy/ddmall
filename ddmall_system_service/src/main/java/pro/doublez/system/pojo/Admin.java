package pro.doublez.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/16 17:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Admin {
    public static final String TABLENAME = "system_tb_admin";

    private Integer id;
    private String adminname;
    private String password;
}
