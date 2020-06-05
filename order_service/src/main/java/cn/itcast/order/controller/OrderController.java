package cn.itcast.order.controller;

import cn.itcast.order.entity.Product;
import cn.itcast.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * Feign中本身已经集成了Ribbon依赖和自动配置，因此我们不需要引入依赖，也不需要在注册 RestTemplate 对象
     * Feign组件会实现Ribbon的负载均衡
     */
    @Autowired
    private ProductFeignClient productFeignClient;

//    @Autowired
//    private RestTemplate restTemplate;

    /**
     * 注入DiscoveryClient:
     *      SpringCloud提供的获取元数据的工具类
     *      调用方法获取服务的元数据信息
     */
//    @Autowired
//    private DiscoveryClient discoveryClient;


    /**
     * 基于Ribbon的形式进行远程调用
     * 1.使用@LoadBalanced 声明RestTemplate（在启动类里）
     * 2.使用服务名称代替ip和端口
     * @param id
     * @return
     */
//    @RequestMapping("/buy/{id}")
//    public Product findById(@PathVariable("id") Long id){
//
////        Product product = restTemplate.getForObject("http://product-service/product/" + id,Product.class);
//        // TODO: 2020/5/17 测试consul
//        Product product = restTemplate.getForObject("http://product-service/product/" + id,Product.class);
//        return product;
//    }

    /**
     * 测试Feign组件
     * @param id
     * @return
     */
    @RequestMapping("/find/{id}")
    public Product find(@PathVariable("id") Long id){
        Product product = productFeignClient.findById(id);
        return product;
    }


    /**
     *
     * @param id
     * @return
     */
//    @RequestMapping("/buy/{id}")
//    public Product findById(@PathVariable("id") Long id){
//        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
//        ServiceInstance serviceInstance = instances.get(0);
//
//        Product product = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/" + id,Product.class);
//        return product;
//    }

}
