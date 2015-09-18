package net.iampaddy.socks.acceptor;

import io.netty.buffer.ByteBuf;
import net.iampaddy.socks.SocksServer;

/**
 * Description here
 *
 * @author paddy.xie
 */
public class InVMAcceptor implements Acceptor {
    @Override
    public void accept() {
        SocksServer server = new SocksServer();
        server.startup();
    }

    @Override
    public void close() {

    }

    @Override
    public void closeImmediately() {

    }

    @Override
    public int read(ByteBuf buffer) {
        return 0;
    }

    @Override
    public int read(byte[] buffer) {
        return 0;
    }

    @Override
    public void writeByte(byte b) {

    }

    @Override
    public void writeBytes(byte[] buffer) {

    }

    @Override
    public void writeBytes(byte[] buffer, int offset, int length) {

    }

    @Override
    public void writeAndFlush(ByteBuf buffer) {

    }

    @Override
    public void flush() {

    }
}
