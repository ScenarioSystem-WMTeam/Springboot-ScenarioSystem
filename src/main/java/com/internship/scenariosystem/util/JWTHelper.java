package com.internship.scenariosystem.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.internship.scenariosystem.model.Manage;

//生成令牌
public class JWTHelper {
    public static String createJwtToken(Manage manage){
        String token = JWT.create().withAudience(manage.getManage_id().toString()).sign(Algorithm.HMAC256(manage.getManage_password()));
        return token;
    }

}
