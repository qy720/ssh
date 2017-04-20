package cn.itcast.shop.user.service;

import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.vo.UserEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务层代码
 * Created by QY on 2017/3/25.
 */
public interface UserService {
    //按用户名查询用户的方法
    public UserEntity findByUsername(String username);

    public void  save(UserEntity userEntity);

    public UserEntity findByCode(String code);

    public void update(UserEntity existUser);

    public UserEntity login(UserEntity user);
}
