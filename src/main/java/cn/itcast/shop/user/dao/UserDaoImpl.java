package cn.itcast.shop.user.dao;

import cn.itcast.shop.user.vo.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 用户模块持久层代码
 * Created by QY on 2017/3/25.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
    //按照名称查询是否有该用户
    public UserEntity findByUsername(String username){
       String hql = "from UserEntity where username=?";
        /*Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,username);
        List<UserEntity> list = query.list();
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;*/
        List<UserEntity> list = (List<UserEntity>) getHibernateTemplate().find(hql,username);
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 注册新用户
     * @param userEntity
     */
    @Override
    public void save(UserEntity userEntity) {
        /*Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userEntity);
        transaction.commit();
        session.close();*/
        this.getHibernateTemplate().save(userEntity);
    }

    /**
     * 根据激活码查询用户
     * @param code
     * @return
     */
    @Override
    public UserEntity findByCode(String code) {
        String hql = "from UserEntity where code=?";
        /*Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,code);
        List<UserEntity> list = query.list();*/
        List<UserEntity> list = (List<UserEntity>) this.getHibernateTemplate().find(hql,code);
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 修改用户状态
     * @param existUser
     */
    @Override
    public void update(UserEntity existUser) {
        /*Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(existUser);
        tx.commit();
        session.close();*/
        this.getHibernateTemplate().update(existUser);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public UserEntity login(UserEntity user) {
        String hql = "from UserEntity where username=? and password=? and state=?";
        /*Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,user.getUsername());
        query.setParameter(1,user.getPassword());
        query.setParameter(2,1);*/
        List<UserEntity> list = (List<UserEntity>) this.getHibernateTemplate().find(hql,user.getName(),user.getPassword(),1);
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
