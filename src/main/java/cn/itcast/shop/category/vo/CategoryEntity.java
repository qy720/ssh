package cn.itcast.shop.category.vo;

import cn.itcast.shop.categorysecond.vo.CategorySecondEntity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/18.
 */
public class CategoryEntity implements Serializable{
    private int cid;
    private String cname;
    private Set<CategorySecondEntity> categorySecondEntities;
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public Set<CategorySecondEntity> getCategorySecondEntities() {
        return categorySecondEntities;
    }
    public void setCategorySecondEntities(Set<CategorySecondEntity> categorySecondEntities) {
        this.categorySecondEntities = categorySecondEntities;
    }
}
