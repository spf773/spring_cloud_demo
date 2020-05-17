package cn.itcast.product.controller;

import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {


//    @Value("${spring.cloud.client.ip-address}")
//    private String ip;
//
//    @Value("${server.port}")
//    private String port;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        Product product = productService.findById(id);
//        product.setProductName("你访问的地址：" + ip + ":" + port);
        return product;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Product product){
        productService.save(product);
        return "添加成功";
    }
}
