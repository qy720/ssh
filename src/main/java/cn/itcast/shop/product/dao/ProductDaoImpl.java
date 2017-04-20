package cn.itcast.shop.product.dao;

import cn.itcast.shop.product.vo.ProductEntity;
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
        //使用离线条件查询
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
        //查询热门的商品
        criteria.add(Restrictions.eq("is_hot",1));
        //倒序输出
        criteria.addOrder(Order.desc("pdate"));
        //执行查询
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<ProductEntity> list = criteria.getExecutableCriteria(session).list();
        transaction.commit();
        session.close();
        return list;
    }
}
