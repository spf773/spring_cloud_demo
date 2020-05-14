package cn.itcast;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableUserBean
public class TestApplication {

    /**
     * 加载顺序
     * 加载spring容器 --> @EnableUserBean --> @Import(UserImportSelector.class) --> selectImports方法 --> UserConfiguration.class
     * --> 返回Bean --> 输出打印
     *
     * @param args
     */
    public static void main(String[] args) {
        //加载spring容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestApplication.class);
        User bean = ac.getBean(User.class);
        System.out.println("bean.toString() = " + bean.toString());
    }
}
