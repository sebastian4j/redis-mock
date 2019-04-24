package com.sebastian.redis.mock;

import ai.grakn.redismock.RedisServer;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sebastián Ávila A.
 */
public class MockRedisTest {

    private static RedisServer server = null;

    @BeforeClass
    public static void init() throws IOException {
        server = RedisServer.newRedisServer(6000);
        server.start();
    }

    @AfterClass
    public static void close() {
        server.stop();
        server = null;
    }

    @Test
    public void test() {
        Assertions.assertThat(server.getBindPort()).isPositive();
    }
}
