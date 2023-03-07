package com.simpleboot.utils;

import com.simpleboot.entity.User;
import com.simpleboot.entity.UserDetail;
import com.simpleboot.service.SimpleUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    @Autowired
    private static SimpleUserService service;
    private static final Key KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(Base64.encodeBase64String("abcdefghijklmnopqrstuvwxyz=akfbsjfsdkvbxckvhsdkgfnskdgv234324hsdkfsdkjfadsfdsfsdf12313124".getBytes(StandardCharsets.UTF_8))));
    private static final long EXPIRATION_TIME = 60L * 1000L * 60L ;
    private static final long RENEWAL_TIME = 60L * 1000L * 5L;

    public static String createTokenAndStore(User user) {
        UserDetail userDetail = new UserDetail();
        userDetail.setUser(user);
        String token = createtoken(userDetail);
        return token;
    }

    public static String createtoken(UserDetail userDetail) {
        String compact = Jwts.builder()
                .setId(String.valueOf(userDetail.getUserId()))
                .setIssuedAt(new Date())
                .setSubject(userDetail.getUser().getUserName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(KEY, SignatureAlgorithm.ES512)
                .compact();
        return compact;
    }

    public static String getHeaderToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (StringUtils.isNotEmpty(header) && header.startsWith("Authorization")) {
            return header.replace("Authorization", "");
        }
        return "";
    }
    public static UserDetail getUserDetail(String token){
        Claims claims = parseToken(token);
        return getUserDetail(claims);
    }
    public static UserDetail getUserDetail(Claims claims){
        verifyToken(claims);
        User user = service.selectSimpleUserById(Long.valueOf(claims.getId()));
        if (user == null) {
            throw new RuntimeException("用户已未登录");
        }
        UserDetail userDetail = new UserDetail();
        userDetail.setUser(user);
        return userDetail;
    }

    private static void verifyToken(Claims claims) {
        if (new Date().compareTo(claims.getExpiration()) > 0) {
            throw new RuntimeException("token强制过期，需要重新登陆");
        }
        if (claims.getExpiration().getTime() -  System.currentTimeMillis() > RENEWAL_TIME) {
//            redisUtil.expire(REDIS_AUTH_PREFIX + claims.getId(), 30, TimeUnit.MINUTES);
        }
    }

    private static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .requireIssuer("user")
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}