package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;



/**
 * Created by zdsoft on 14-6-23.
 */
public class HelloServer {

    public static void main(String[] args){
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(parentGroup, childGroup).channel(NioServerSocketChannel.class).childHandler(
                    new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HelloServerHandler());
                        }
                    }
            ).option(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = serverBootstrap.bind(8080).sync();
            f.channel().closeFuture().sync();

        }catch (Exception e){

        }finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}
