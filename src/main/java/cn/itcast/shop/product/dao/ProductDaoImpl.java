package cn.itcast.shop.product.dao;

import cn.itcast.shop.product.vo.ProductEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

    @Override
    public List<ProductEntity> findHot() {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ProductEntity.class);
        //查询热门的商品
        criteria.add(Restrictions.eq("is_hot",1));
        //倒序输出
        criteria.addOrder(Order.desc("pdate"));
        //查询出十条数据
        criteria.setFirstResult(0);
        criteria.setMaxResults(10);
        //执行查询,并存储到list
        List<ProductEntity> list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public List<ProductEntity> findNew() {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ProductEntity.class);
        criteria.addOrder(Order.desc("pdate"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(10);
        List<ProductEntity> list = criteria.list();
        session.close();
        return list;
    }
}
