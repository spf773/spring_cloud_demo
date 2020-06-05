package cn.itcast.order.feign;

import cn.itcast.order.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1.声明需要调用的服务名称
 * @FeignClient
 *  * name : 服务提供者的名称（服务提供者配置文件里配置的名称）
 */
@FeignClient(name = "product-service")
public interface ProductFeignClient {

    /**
     * 2.配置需要调用的微服务接口
     * Feign支持SpringMVC的注解
     * 这里实际上请求的接口地址是：http://product-service/product/" + id
     */
    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id);
}
