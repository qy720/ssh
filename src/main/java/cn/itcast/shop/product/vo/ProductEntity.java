package cn.itcast.shop.product.vo;

import cn.itcast.shop.categorysecond.vo.CategorySecondEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/20.
 */
@Entity
@Table(name = "product", schema = "shop")
public class ProductEntity {
    @Id
    @Column(name = "pid")
    public Integer pid;
    @Column(name = "pname")
    public String pname;
    @Column(name = "market_price")
    public Double market_price;
    @Column(name = "shop_price")
    public Double shop_price;
    @Column(name = "image")
    public String image;
    @Column(name = "pdesc")
    public String pdesc;
    @Column(name = "is_hot")
    public Integer is_hot;
    @Column(name = "pdate")
    public Date pdate;
    //二级分类的外键:使用二级分类的对象
    @ManyToOne(targetEntity = CategorySecondEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "csid",updatable = false)
    private CategorySecondEntity categorySecondEntity;

    public CategorySecondEntity getCategorySecondEntity() {
        return categorySecondEntity;
    }

    public void setCategorySecondEntity(CategorySecondEntity categorySecondEntity) {
        this.categorySecondEntity = categorySecondEntity;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Double market_price) {
        this.market_price = market_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }
}
