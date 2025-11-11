package cn.itedus.lottery.test;

import cn.itedus.lottery.domain.support.ids.policy.SnowFlake;
import org.testng.annotations.Test;

public class SnowflakeIdWorkerTest {

    @Test
    public void testGenerateId() {
        SnowFlake idWorker = new SnowFlake();
        idWorker.init();

        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }
    }
}
