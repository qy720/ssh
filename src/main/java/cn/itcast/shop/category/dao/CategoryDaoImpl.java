package cn.itcast.shop.category.dao;

import cn.itcast.shop.category.vo.CategoryEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {
    /**
     * 查询所有一级分类
     * @return
     */
    @Override
    public List<CategoryEntity> findAll() {
        String hql = "from CategoryEntity";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<CategoryEntity> list = query.list();
        if(list != null && list.size()>0){
            return list;
        }
        return null;
    }
}
