package cn.itcast.shop.product.dao;

import cn.itcast.shop.product.vo.ProductEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
public interface ProductDao {
    public List<ProductEntity> findHot();
}
