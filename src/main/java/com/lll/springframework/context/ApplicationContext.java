package com.lll.springframework.context;

import com.lll.springframework.beans.factory.HierarchicalBeanFactory;
import com.lll.springframework.beans.factory.ListableBeanFactory;
import com.lll.springframework.core.io.ResourceLoader;

/**
 * @author lyf
 * @description 应用上下文
 * @date 2025/11/13 17:31
 **/
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
