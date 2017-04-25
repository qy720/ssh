package cn.itcast.shop.product.action;

import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.ProductEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品的对象
 * Created by Administrator on 2017/4/20.
 */
public class ProductAction extends ActionSupport implements ModelDriven<ProductEntity> {
    private ProductEntity productEntity = new ProductEntity();

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public ProductEntity getModel() {
        return productEntity;
    }
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //根据商品的ID查询商品的方法
    public String findByPid(){
        int id = productEntity.getPid();
        productEntity = productService.findByPid(id);
        return "findByPid";
    }
}
