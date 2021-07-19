package pro.doublez.gateway.filter;

import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import pro.doublez.gateway.util.JwtUtil;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

@Component  //开启这个就开启了鉴权
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getURI().getPath();
        HttpHeaders headers = request.getHeaders();
        if(Pattern.matches("/common/.*", path)){
            //公共资源
            return chain.filter(exchange);
        }
        if(Pattern.matches("/shopping/.*", path) || Pattern.matches("/personal/.*", path)){
            //需要用户权限
            String token = headers.getFirst("user-token");
            if(token==null || "".equals(token)){
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
            try {
                Claims claims = JwtUtil.parseJWT(token);
            } catch (Exception e){
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
            return chain.filter(exchange);
        }
        if(Pattern.matches("/management/.*", path)){
            //需要管理员权限
            String token = headers.getFirst("admin-token");
            if(token==null || "".equals(token)){
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
            try {
                JwtUtil.parseJWT(token);
            } catch (Exception e){
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
            return chain.filter(exchange);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
