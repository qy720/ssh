package cn.itcast.shop.product.service;

import cn.itcast.shop.product.vo.ProductEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
public interface ProductService {

   public List<ProductEntity> findHot();

   public List<ProductEntity> findNew();

   public ProductEntity findByPid(Integer pid);
}
