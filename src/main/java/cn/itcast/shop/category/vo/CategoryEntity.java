package cn.itcast.shop.category.vo;

import cn.itcast.shop.categorysecond.vo.CategorySecondEntity;
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
    private int cid;
    private String cname;
    /*@OneToMany(mappedBy = "categoryEntity")
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<CategorySecondEntity> categorySecondEntities = new HashSet<CategorySecondEntity>();

    public Set<CategorySecondEntity> getCategorySecondEntities() {
        return categorySecondEntities;
    }

    public void setCategorySecondEntities(Set<CategorySecondEntity> categorySecondEntities) {
        this.categorySecondEntities = categorySecondEntities;
    }*/

    @Id
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (cid != that.cid) return false;
        if (cname != null ? !cname.equals(that.cname) : that.cname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        return result;
    }
}
