package cn.itcast.shop.product.dao;

import cn.itcast.shop.product.vo.ProductEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{
    /**
     * 查询热门商品
     * @return
     */
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

    /**
     * 查询最新商品
     * @return
     */
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

    /**
     * 商品详情
     * @param pid 商品id
     * @return
     */
    @Override
    public ProductEntity findByPid(Integer pid) {
        String hql = "from ProductEntity where pid=?";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,pid);
        List<ProductEntity> list = query.list();
        return list.get(0);
    }
}
