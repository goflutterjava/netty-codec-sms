package io.github.protocol.codec.smpp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SmppEnquireLinkCodecTest {

    private final SmppDecoder decoder = new SmppDecoder();


    @Test
    public void case1() {
        SmppHeader header = new SmppHeader(SmppConst.ENQUIRE_LINK_ID, 0);
        ChannelHandlerContext ctx = Mockito.mock(ChannelHandlerContext.class);
        Mockito.when(ctx.alloc()).thenReturn(ByteBufAllocator.DEFAULT);
        ByteBuf byteBuf = SmppEncoder.INSTANCE.doEncode(ctx, new SmppEnquireLink(header));
        SmppEnquireLink smppEnquireLink = (SmppEnquireLink) decoder.decode(byteBuf);
        Assertions.assertEquals(0, byteBuf.readableBytes());
    }
}
