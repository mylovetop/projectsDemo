package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by zdsoft on 14-6-23.
 */
public class HelloClient {

    public static void main(String[] args){
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new HelloClientHandler());
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.connect(new InetSocketAddress("localhost", 8080));
    }
}
