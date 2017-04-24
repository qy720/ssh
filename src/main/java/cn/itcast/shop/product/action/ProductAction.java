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
    private ProductEntity productEntity;

    public ProductEntity getModel() {
        return productEntity;
    }
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //根据商品的ID查询商品的方法
    public String fiandByPid(){
        productEntity = productService.findByPid(productEntity.getPid());
        return "findByPid";
    }
}
