package cn.itcast.shop.product.action;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.category.vo.CategoryEntity;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.ProductEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 商品的对象
 * Created by Administrator on 2017/4/20.
 */
public class ProductAction extends ActionSupport implements ModelDriven<ProductEntity> {

    private ProductEntity productEntity = new ProductEntity();

    public ProductEntity getProductEntity() {
        return productEntity;
    }
    //接受一级分类的cid
    private Integer cid;

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    //注入一级分类的service
    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
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
        productEntity = productService.findByPid(productEntity.getPid());
        return "findByPid";
    }

    //根据分类的id查询商品
    public String findByCid(){

        return "findByCid";
    }

}
