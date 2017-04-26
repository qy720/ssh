package cn.itcast.shop.categorysecond.vo;

import cn.itcast.shop.category.vo.CategoryEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/25.
 */
@Entity
@Table(name = "categorysecond",schema = "shop",catalog = "")
public class CategorySecondEntity {
    @Id
    @Column(name = "csid")
    private Integer csid;
    @Column(name = "csname")
    private String csname;
    @ManyToOne(targetEntity =CategoryEntity.class,cascade={CascadeType.ALL})//一对多关联关系
    @JoinColumn(name = "cid",updatable = false)
    private CategoryEntity categoryEntity;

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
