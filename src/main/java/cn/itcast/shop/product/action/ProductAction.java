package cn.itcast.shop.product.action;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.category.vo.CategoryEntity;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.ProductEntity;
import cn.itcast.shop.utils.PageUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 商品的对象
 * Created by Administrator on 2017/4/20.
 */
public class ProductAction extends ActionSupport implements ModelDriven<ProductEntity> {
    //接受当前页数
    private int page;

    public void setPage(int page) {
        this.page = page;
    }

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
        PageUtils<ProductEntity> pageUtils = productService.findByPageCid(cid,page);//根据一级分类查询商品，带分页的查询
        //将PageUtils存入到值栈中
        ActionContext.getContext().getValueStack().set("pageUtil",pageUtils);
        return "findByCid";
    }

}
