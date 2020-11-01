package cn.itcast.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//激活Feign
@EnableFeignClients
public class OrderApplication {

    /**
     * 注入spring 的RestTemplate ,用来请求http接口
     *
     * @LoadBalanced 是Ribbon提供的负载均衡的注解
     *
     * TODO: 2020/5/17  集成Consul的使用
     * spring cloud 对cosul进行了进一步的处理
     * 向其中集成了Ribbon的支持，所以加上@LoadBalanced注解就可以使用Ribbon
     *@return
     */
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
