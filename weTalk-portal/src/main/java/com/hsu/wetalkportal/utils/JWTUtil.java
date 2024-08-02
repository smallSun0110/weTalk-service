package com.hsu.wetalkportal.utils;

import com.alibaba.fastjson.JSONObject;
import com.hsu.wetalkportal.entity.token.TokenData;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//注册组件
@Component
@Slf4j
public class JWTUtil {

    //创建对象主体
    private static final String CLAIM_KEY_SUBJECT = "subject";
    //创建创建时间
    private static final String CLAIM_KEY_CREATED = "created";
    //测试密钥
    private static final String SECRET = "2a3b4c5d6e7f8g9h0i1j2k3l4m5n6o7p8q9r0s1t123";


    /**
     * 根据用户信息生成token
     *
     * @param authData
     * @param tokenValid
     * @return
     */
    public static String createToken(TokenData authData, int tokenValid) {
        HashMap<String, Object> claims = new HashMap<>();
        String userJsonStr = JSONObject.toJSONString(authData);
        claims.put(CLAIM_KEY_SUBJECT, userJsonStr);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return createToken(claims, tokenValid, SECRET);
    }

    /**
     * 根据负载生成jwt token
     *
     * @param claims
     * @param tokenValid
     * @param secret
     * @return
     */
    private static String createToken(Map<String, Object> claims, int tokenValid, String secret) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, tokenValid * 60);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    public static TokenData getTokenData(String token) {
        Claims claims = getClaimsFromToken(token, SECRET);
        String userJsonStr = claims.get(CLAIM_KEY_SUBJECT).toString();
        TokenData authData = JSONObject.parseObject(userJsonStr, TokenData.class);
        return authData;
    }

    /**
     * 从token中获取负载jwt
     *
     * @param token
     * @param secret
     * @return
     */
    private static Claims getClaimsFromToken(String token, String secret) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw e;
        } catch (UnsupportedJwtException e) {
            throw e;
        } catch (MalformedJwtException e) {
            throw e;
        } catch (SignatureException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return claims;
    }




}

