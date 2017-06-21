package cn.itcast.shop.category.dao;

import cn.itcast.shop.category.vo.CategoryEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

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
        List<CategoryEntity> list = (List<CategoryEntity>) this.getHibernateTemplate().find(hql);
        if(list != null && list.size()>0){
            return list;
        }
        return null;
    }
}
