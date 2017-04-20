package cn.itcast.shop.user.service;

import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.vo.UserEntity;
import cn.itcast.shop.utils.MailUitls;
import cn.itcast.shop.utils.UUIDUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 业务层代码
 * Created by QY on 2017/3/25.
 */
@Transactional
public class UserServiceImpl implements UserService{
    //注入UserDao
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //按用户名查询用户的方法
    public UserEntity findByUsername(String username){
        return userDao.findByUsername(username);
    }

    @Override
    public void save(UserEntity userEntity) {
        userEntity.setState(0);// 0:代表用户未激活.  1:代表用户已经激活.
        String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
        userEntity.setCode(code);
        userDao.save(userEntity);
        String loginAccount = "351374556@qq.com";
        String userEmail = userEntity.getEmail();
        //发送激活邮件
        MailUitls.sendEmail("smtp.qq.com",loginAccount,"fsxoecznomrzbiha", loginAccount,
                new String[]{ userEmail}, "来自购物天堂传智商城官方激活邮件",
                "<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.3.210:8080/ssh/user_active.action?code="+code+"'>http://192.168.3.210:8080/ssh/user_active.action?code="+code+"</a></h3>",
                "text/html;charset=utf-8");
    }

    /**
     * 根据激活码查询用户
     * @param code 激活码
     * @return
     */
    @Override
    public UserEntity findByCode(String code) {
        return userDao.findByCode(code);
    }
    /**
     * 修改用户状态
     * @param existUser
     */
    @Override
    public void update(UserEntity existUser) {
        userDao.update(existUser);
    }

    /**
     * 用户登录的方法
     * @param user
     * @return
     */
    @Override
    public UserEntity login(UserEntity user) {
        return userDao.login(user);
    }
}
