package net.iampaddy.socks.socket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xpjsk on 2015/9/14.
 */
public class SocketManager {

    private Map<DestKey, SocketPool> sockets;
    private ReentrantLock lock;

    public SocketManager() {
        sockets = new HashMap<>();
        lock = new ReentrantLock();
    }

    public Socket getSocket(DestKey destKey) {
        SocketPool pool = sockets.get(destKey);
        if (pool == null) {
            try {
                lock.lock();
                pool = sockets.get(destKey);
                if (pool == null) {
                    pool = new SocketPool(destKey);
                    pool.init();
                    sockets.put(destKey, pool);
                }
            } finally {
                lock.unlock();
            }
        }
        return pool.getOne();
    }

}