package cn.itcast.shop.user.dao;

import cn.itcast.shop.user.vo.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * 用户模块持久层代码
 * Created by QY on 2017/3/25.
 */
public interface UserDao{
    //按照名称查询是否有该用户
    public UserEntity findByUsername(String username);
    //注册用户
    public void save(UserEntity userEntity);

    public UserEntity findByCode(String code);

    public void update(UserEntity existUser);

    public UserEntity login(UserEntity user);
}
