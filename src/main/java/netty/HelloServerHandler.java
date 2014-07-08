package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by zdsoft on 14-6-23.
 */
public class HelloServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(">>>Hello, i am server!");
        super.channelActive(ctx);
    }
}
