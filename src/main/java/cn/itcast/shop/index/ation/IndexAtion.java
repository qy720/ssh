package cn.itcast.shop.index.ation;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.category.vo.CategoryEntity;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.ProductEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import java.util.List;

/**
 * 访问首页的Action
 * Created by Administrator on 2017/3/14.
 */
public class IndexAtion extends ActionSupport{
    //注入一级分类的service
    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //注入热门商品service
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 执行的访问首页的方法
     * @return
     */
    public String execute(){
        //查询所有一级分类
        List<CategoryEntity> cList =  categoryService.findAll();
        //将一级分类存入到session
        ActionContext.getContext().getSession().put("cList",cList);

        //查询热门商品
        List<ProductEntity> pList =  productService.findHot();
        //保存到值栈中
        ActionContext.getContext().getValueStack().set("pList",pList);
        return "index";
    }
}
