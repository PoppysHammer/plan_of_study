import org.example.ServiceLocatorFactory;
import org.example.factory.PayFactory;
import org.example.service.impl.AliPayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;

@SpringBootTest(classes = {ServiceLocatorFactory.class})
public class TestServiceLocator implements ApplicationContextAware {

    @Resource
    private PayFactory payFactory;

    private ApplicationContext applicationContext;

    @Test
    public void test1() {
        abc("ali");
        abc("wx");

    }

    public void abc(String payChannel) {
        payFactory.getPay(payChannel + "PayService").pay();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
