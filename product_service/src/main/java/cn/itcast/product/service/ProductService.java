package cn.itcast.product.service;

import cn.itcast.product.entity.Product;

public interface ProductService {

    /**
     * 保存
     * @param product
     */
    void save(Product product);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product findById(Long id);

    /**
     * 修改
     * @param product
     */
    void update(Product product);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);
}
