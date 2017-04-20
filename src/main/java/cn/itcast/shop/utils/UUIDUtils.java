package cn.itcast.shop.utils;

import java.util.UUID;

/**
 * 生成随机字符串类
 * Created by Administrator on 2017/4/12.
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
