package cn.itcast.shop.product.service;

import cn.itcast.shop.product.dao.ProductDao;
import cn.itcast.shop.product.vo.ProductEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Transactional
public class ProductServiceImpl implements ProductService{
    //注入productDao
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<ProductEntity> findHot() {
        return productDao.findHot();
    }
}
