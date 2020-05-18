package redis;

import io.lettuce.core.*;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import io.lettuce.core.support.ConnectionPoolSupport;
import junit.framework.TestCase;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;

/**
 * @description: TestLettuce
 * @date: 2020/5/17 18:51
 * @author: Finallap
 * @version: 1.0
 */
public class TestLettuce {
    private RedisClient client;
    private StatefulRedisConnection<String, String> connection;

    @Before
    public void before() {
        ClientResources resources = DefaultClientResources.create();
        RedisURI redisURI = RedisURI.builder().// <1> 创建单机连接的连接信息
                withHost("localhost").
                withPassword("").
                withPort(6379).
                withTimeout(Duration.of(10, ChronoUnit.SECONDS)).
                build();
        client = RedisClient.create(resources, redisURI);// <2> 创建客户端
//        client = RedisClient.create(redisURI);
        client.setOptions(ClientOptions.builder().
                autoReconnect(true).
                build());
        connection = client.connect();// <3> 创建线程安全的连接
    }

    @After
    public void after() {
        connection.close();
        client.shutdown();
    }

    @Test
    public void testGetSet() {
        RedisCommands<String, String> redisCommands = connection.sync();// <4> 创建同步命令
        SetArgs setArgs = SetArgs.Builder.nx().ex(10);
        String result = redisCommands.set("name", "throwable", setArgs);
        TestCase.assertEquals("OK", result);
        result = redisCommands.get("name");
        TestCase.assertEquals("throwable", result);
        redisCommands.del("name");
    }

    @Test
    public void testSync() {
        RedisCommands<String, String> redisCommands = connection.sync();
        String pong = redisCommands.ping();
        TestCase.assertEquals("PONG", pong);
    }

    @Test
    public void testAsync() throws ExecutionException, InterruptedException {
        RedisAsyncCommands<String, String> commands = connection.async();
        RedisFuture<String> future = commands.ping();
        TestCase.assertEquals("PONG", future.get());
    }

    @Test
    public void testAsync1() throws ExecutionException, InterruptedException {
        RedisAsyncCommands<String, String> commands = connection.async();
        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        RedisFuture<String> future = commands.set("name", "throwable", setArgs);
        future.thenAccept(value -> System.out.println(value));
        future.get();
    }

    @Test
    public void testUseConnectionPool() throws Exception {
        RedisURI redisURI = RedisURI.builder().
                withHost("localhost").
                withPassword("").
                withPort(6379).
                withTimeout(Duration.of(10, ChronoUnit.SECONDS)).
                build();
        RedisClient client = RedisClient.create(redisURI);
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        GenericObjectPool<StatefulRedisConnection<String, String>> pool =
                ConnectionPoolSupport.createGenericObjectPool(client::connect, poolConfig);

        try (StatefulRedisConnection<String, String> connection = pool.borrowObject()) {
            RedisCommands<String, String> commands = connection.sync();
            SetArgs setArgs = SetArgs.Builder.nx().ex(5);
            String result = commands.set("name", "throwable", setArgs);
            TestCase.assertEquals("OK", result);
            result = commands.get("name");
            TestCase.assertEquals("throwable", result);
            commands.del("name");
        }

        pool.close();
        client.shutdown();
    }
}
