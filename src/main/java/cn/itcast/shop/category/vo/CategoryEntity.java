package cn.itcast.shop.category.vo;

import cn.itcast.shop.categorysecond.vo.CategorySecondEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/18.
 */
@Entity
@Table(name = "category", schema = "shop", catalog = "")
public class CategoryEntity {
    @Id
    @Column(name = "cid")
    private int cid;

    @Column(name = "cname")
    private String cname;

    @OneToMany(targetEntity = CategorySecondEntity.class,cascade=CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "cid",updatable = false)
    @OrderBy("csid")
    private Set<CategorySecondEntity> categorySecondEntities = new HashSet<CategorySecondEntity>();

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
