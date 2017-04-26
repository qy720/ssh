package cn.itcast.shop.product.service;

import cn.itcast.shop.product.dao.ProductDao;
import cn.itcast.shop.product.vo.ProductEntity;
import cn.itcast.shop.utils.PageUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Transactional
public class ProductServiceImpl implements ProductService{
    //注入productDao
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<ProductEntity> findHot() {
        return productDao.findHot();
    }

    @Override
    public List<ProductEntity> findNew() {
        return productDao.findNew();
    }

    @Override
    public ProductEntity findByPid(Integer pid) {
        return productDao.findByPid(pid);
    }

    @Override
    public PageUtils<ProductEntity> findByPageCid(Integer cid, int page) {
        PageUtils<ProductEntity> pageUtils = new PageUtils<ProductEntity>();
        //设置当前页数
        pageUtils.setPage(page);
        //设置每页记录数
        int limit = 8;
        pageUtils.setLimit(limit);
        //设置总记录数
        int totalCount = 0;
        totalCount = productDao.findCountCid(cid);
        pageUtils.setTotalCount(totalCount);
        //设置总页数
        int totalPage = 0;
        totalPage = (int) Math.ceil(totalCount/limit);
        /*if(totalCount % limit ==0){
            totalPage = totalCount/limit;
        }else {
            totalPage = totalCount/limit+1;
        }
        int i = totalCount % limit == 0 ? totalPage = totalCount / limit : (totalPage = totalCount / limit + 1);*/
        pageUtils.setTotalPage(totalPage);
        //每页显示数据集合的查询
        int begin = (page-1)*limit;
        List<ProductEntity> list =productDao.findByPageCid(cid,begin,limit);
        pageUtils.setList(list);
        return pageUtils;
    }
}
