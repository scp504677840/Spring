package main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean的后置处理器
 */
public class BookPostProcessor implements BeanPostProcessor {

    /**
     * init-method 方法之前调用
     *
     * @param bean     IOC传入的Bean
     * @param beanName Bean的名称
     * @return 原Bean或新Bean都可以
     * @throws BeansException Bean异常
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //因为Bean后置处理器的作用于所有Bean，所以可以对指定的Bean做针对性改变。
        //增加过滤条件
        if (beanName.equals("book")) {
            Book book = (Book) bean;
            System.out.println("BookPostProcessor postProcessBeforeInitialization: " + beanName + " --- " + book);
        }
        return bean;
    }

    /**
     * init-method 方法之后调用
     *
     * @param bean     IOC传入的Bean
     * @param beanName Bean的名称
     * @return 原Bean或新Bean都可以
     * @throws BeansException Bean异常
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("book")) {
            //我们也可以重新new出新的Bean
            Book book = new Book();
            book.setName("new Java");
            book.setPrice(123.456);
            System.out.println("BookPostProcessor postProcessAfterInitialization: " + beanName + " --- " + book);
            return book;
        }
        return bean;
    }

    //以下是添加了两个Bean后置处理器，然后在Bean后置处理器实现方法里面加上过滤条件后的处理结果。
    //book : call构造函数
    //book : call setName
    //book : call setPrice
    //postProcessBeforeInitialization: book --- Book{name='Java', price=22.55}
    //BookPostProcessor postProcessBeforeInitialization: book --- Book{name='Java', price=22.55}
    //book : call init
    //postProcessAfterInitialization: book --- Book{name='Java', price=22.55}
    //book : call构造函数
    //book : call setName
    //book : call setPrice
    //BookPostProcessor postProcessAfterInitialization: book --- Book{name='new Java', price=123.456}
    //address : call 构造函数
    //address : call setCity
    //address : call setStreet
    //postProcessBeforeInitialization: address --- Address{city='Shanghai', street='NanJingDongLu'}
    //address : call init
    //postProcessAfterInitialization: address --- Address{city='Shanghai', street='NanJingDongLu'}
    //Book{name='new Java', price=123.456}
    //Address{city='Shanghai', street='NanJingDongLu'}
    //address : call destroy
    //book : call destroy
}
