package com.example.weixin.cp.bean.messagebuilder;

import com.example.weixin.common.api.WxConsts;
import com.example.weixin.cp.bean.message.WxCpMessage;

/**
 * 获得消息builder
 * <pre>
 * 用法: WxCustomMessage m = WxCustomMessage.FILE().mediaId(...).toUser(...).build();
 * </pre>
 *
 * @author Daniel Qian
 */
public final class FileBuilder extends BaseBuilder<FileBuilder> {
  private String mediaId;

  public FileBuilder() {
    this.msgType = WxConsts.KefuMsgType.FILE;
  }

  public FileBuilder mediaId(String media_id) {
    this.mediaId = media_id;
    return this;
  }

  @Override
  public WxCpMessage build() {
    WxCpMessage m = super.build();
    m.setMediaId(this.mediaId);
    return m;
  }
}
