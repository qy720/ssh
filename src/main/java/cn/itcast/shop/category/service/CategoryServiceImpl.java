package cn.itcast.shop.category.service;

import cn.itcast.shop.category.dao.CategoryDao;
import cn.itcast.shop.category.vo.CategoryEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
public class CategoryServiceImpl implements CategoryService{
    //注入categoryDao
    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * 查询所有一级分类
     * @return
     */
    @Override
    public List<CategoryEntity> findAll() {

        return categoryDao.findAll();
    }
}
