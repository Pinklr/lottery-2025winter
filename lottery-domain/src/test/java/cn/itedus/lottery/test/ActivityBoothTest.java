package cn.itedus.lottery.test;

import cn.itedus.lottery.interfaces.ActivityBooth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActivityBoothTest {

    @Autowired
    private ActivityBooth activityBooth;

    @Test
    void testBeanInjection() {
        assert activityBooth != null;
        System.out.println("ActivityBooth Bean 注入成功！");
    }
}
