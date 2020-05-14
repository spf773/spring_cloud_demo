package cn.itcast.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan("cn.itcast.product.entity")//扫描实体类
@SpringBootApplication
//激活EurekaClient(下面两个注解任选其一即刻)，新版本中不写注解也行
@EnableEurekaClient
//@EnableDiscoveryClient
public class Product2Application {

    public static void main(String[] args) {
        SpringApplication.run(Product2Application.class);
    }
}
