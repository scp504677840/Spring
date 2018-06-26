package main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean的后置处理器
 */
public class MyPostProcessor implements BeanPostProcessor {

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
        System.out.println("postProcessBeforeInitialization: " + beanName + " --- " + bean);
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
        System.out.println("postProcessAfterInitialization: " + beanName + " --- " + bean);
        return bean;
    }
}
