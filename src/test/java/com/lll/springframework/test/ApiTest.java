package com.lll.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.lll.springframework.aop.AdvisedSupport;
import com.lll.springframework.aop.MethodMatcher;
import com.lll.springframework.aop.TargetSource;
import com.lll.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.lll.springframework.aop.framework.Cglib2AopProxy;
import com.lll.springframework.aop.framework.JdkDynamicAopProxy;
import com.lll.springframework.aop.framework.ReflectiveMethodInvocation;
import com.lll.springframework.beans.PropertyValue;
import com.lll.springframework.beans.PropertyValues;
import com.lll.springframework.beans.factory.config.BeanDefinition;
import com.lll.springframework.beans.factory.config.BeanReference;
import com.lll.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.lll.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.lll.springframework.context.support.ClassPathXmlApplicationContext;
import com.lll.springframework.core.io.DefaultResourceLoader;
import com.lll.springframework.core.io.Resource;
import com.lll.springframework.test.bean.IUserService;
import com.lll.springframework.test.bean.UserDao;
import com.lll.springframework.test.bean.UserService;
import com.lll.springframework.test.bean.UserServiceInterceptor;
import com.lll.springframework.test.common.MyBeanFactoryPostProcessor;
import com.lll.springframework.test.common.MyBeanPostProcessor;
import com.lll.springframework.test.event.CustomerEvent;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author lyf
 * @description
 * @date 2025/11/11 17:15
 **/
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @BeforeEach
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_BeanFactory() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取 Bean 对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    @Test
    public void test_classPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/CLeiYF/simple-spring-framework/blob/main/src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件 & 注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean 实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean 实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取 Bean 对象调用
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println(result);
    }

    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println(result);
    }

    @Test
    public void test_prototype() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取 Bean 对象的调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + "十六进制哈希： " + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }

    @Test
    public void test_event() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomerEvent(applicationContext, 123L, "成功"));
        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_proxy_class() {
        IUserService userService = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserService.class}, (proxy, method, args) -> "你被代理了");
        String result = userService.queryUserInfo();
        System.out.println(result);
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* com.lll.springframework.test.bean.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.lll.springframework.test.bean.IUserService.*(..))"));

        // 代理对象(JDK)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println(proxy_jdk.queryUserInfo());

        // 代理对象(Cglib)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println(proxy_cglib.register("zeus"));
    }

    @Test
    public void test_proxy_method() {
        // 目标对象(可以替换成任何的目标对象)
        Object targetObj = new UserService();

        // AOP 代理
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* com.lll.springframework.test.bean.IUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin By AOP");
                            System.out.println("方法名称：" + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });

        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
