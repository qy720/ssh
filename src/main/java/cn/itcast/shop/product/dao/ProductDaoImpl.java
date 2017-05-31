package cn.itcast.shop.product.dao;

import cn.itcast.shop.product.vo.ProductEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
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
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
        //查询热门的商品
        criteria.add(Restrictions.eq("is_hot",1));
        //倒序输出
        criteria.addOrder(Order.desc("pdate"));
        //执行查询,并存储到list
        List<ProductEntity> list = (List<ProductEntity>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
        return list;
    }

    /**
     * 查询最新商品
     * @return
     */
    @Override
    public List<ProductEntity> findNew() {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
        criteria.addOrder(Order.desc("pdate"));
        List<ProductEntity> list = (List<ProductEntity>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
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
        List<ProductEntity> list = (List<ProductEntity>) this.getHibernateTemplate().find(hql,pid);
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据分类id查询商品的个数
     * @param cid
     * @return
     */
    @Override
    public int findCountCid(Integer cid) {
        String hql = "select count(*) from ProductEntity p where p.categorySecondEntity.categoryEntity.cid=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,cid);
        if(list != null && list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    /**
     * 根据分类id查询商品的集合
     * @param cid
     * @param begin
     * @param limit
     * @return
     */
    @Override
    public List<ProductEntity> findByPageCid(Integer cid, int begin, int limit) {
        String hql = "select p from ProductEntity p join p.categorySecondEntity cs join cs.categoryEntity c where cid=?";

        return null;
    }
}
