package pro.doublez.ddmall_api.utils;

import io.jsonwebtoken.Claims;
import pro.doublez.ddmall_api.constant.StatusCode;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/18 20:41
 */
public class TokenUtil {
    public static int getUid(String jwt){
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(jwt);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new BaseException(StatusCode.USERERROR, "登录状态异常，重新登录");
        }
        return Integer.parseInt(userId);
    }

    public static String getUidStr(String jwt){
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(jwt);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new BaseException(StatusCode.USERERROR, "登录状态异常，重新登录");
        }
        return userId;
    }
}
