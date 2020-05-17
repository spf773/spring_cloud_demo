package cn.itcast.order.controller;

import cn.itcast.order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

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
    @RequestMapping("/buy/{id}")
    public Product findById(@PathVariable("id") Long id){

//        Product product = restTemplate.getForObject("http://product-service/product/" + id,Product.class);
        // TODO: 2020/5/17 测试consul
        Product product = restTemplate.getForObject("http://product-service/product/" + id,Product.class);
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
