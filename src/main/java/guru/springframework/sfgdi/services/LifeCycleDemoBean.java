package guru.springframework.sfgdi.services;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.MessageFormat;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        System.out.println("## The BeanFactory has been !!!SET!!!");
    }

    @Override
    public void setBeanName(String beanName) {

        System.out.println(MessageFormat.format("## My Bean Name is: {0}", beanName));
    }

    @Override
    public void destroy() throws Exception {

        System.out.println("## The LifeCycleBean has been !!!TERMINATED!!!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("## The LifeCycleBean has its !!!PROPERTIES SET!!!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## ApplicationContext has been !!!SET!!!");

    }

    @PostConstruct
    public void postConstruct(){

        System.out.println("## The PostConstruct annotated method has been !!!CALLED!!!");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("## The PreDestroy annotated method has been !!!CALLED!!!");
    }

    public void beforeInit(){
        System.out.println("## -- BeforeInit called by !!!BEAN POST PROCESSOR!!!");
    }

    public void afterInit(){
        System.out.println("## -- AfterInit called by !!!BEAN POST PROCESSOR!!!");
    }
}
