package cn.itcast.shop.categorysecond.vo;

import cn.itcast.shop.category.vo.CategoryEntity;
import cn.itcast.shop.product.vo.ProductEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/25.
 */
public class CategorySecondEntity implements Serializable{
    private Integer csid;
    private String csname;
    private CategoryEntity categoryEntity;
    //配置商品集合
    private Set<ProductEntity> productEntities = new HashSet<ProductEntity>();
    public Set<ProductEntity> getProductEntities() {
        return productEntities;
    }
    public void setProductEntities(Set<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
    public Integer getCsid() {
        return csid;
    }
    public void setCsid(Integer csid) {
        this.csid = csid;
    }
    public String getCsname() {
        return csname;
    }
    public void setCsname(String csname) {
        this.csname = csname;
    }
    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }
    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
