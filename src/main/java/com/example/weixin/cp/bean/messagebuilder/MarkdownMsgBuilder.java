package com.example.weixin.cp.bean.messagebuilder;

import com.example.weixin.common.api.WxConsts;
import com.example.weixin.cp.bean.message.WxCpMessage;

/**
 * <pre>
 * markdown类型的消息builder
 * Created by Binary Wang on 2019/1/20.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class MarkdownMsgBuilder extends BaseBuilder<MarkdownMsgBuilder> {
  private String content;

  public MarkdownMsgBuilder() {
    this.msgType = WxConsts.KefuMsgType.MARKDOWN;
  }

  public MarkdownMsgBuilder content(String content) {
    this.content = content;
    return this;
  }

  @Override
  public WxCpMessage build() {
    WxCpMessage m = super.build();
    m.setContent(this.content);
    return m;
  }
}
