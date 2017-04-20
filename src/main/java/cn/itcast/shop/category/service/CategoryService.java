package cn.itcast.shop.category.service;

import cn.itcast.shop.category.vo.CategoryEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public interface CategoryService {

    public List<CategoryEntity> findAll();
}
