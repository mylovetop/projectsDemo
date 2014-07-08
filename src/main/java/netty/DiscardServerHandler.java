package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by zdsoft on 14-7-8.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

       //服务器显示 从客户端返回的信息
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf in = (ByteBuf)msg;
//        try {
//            while (in.isReadable()){
//                System.out.print((char)in.readByte());
//                System.out.flush();
//            }
//            ctx.write(msg);
//            ctx.flush();
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
//    }


    //回写给客户端
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
