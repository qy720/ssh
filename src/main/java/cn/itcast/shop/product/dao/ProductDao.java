package cn.itcast.shop.product.dao;

import cn.itcast.shop.product.vo.ProductEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
public interface ProductDao {
    public List<ProductEntity> findHot();

    public List<ProductEntity> findNew();

    public ProductEntity findByPid(Integer pid);

    public int findCountCid(Integer cid);

    public List<ProductEntity> findByPageCid(Integer cid, int begin, int limit);
}
