package com.example.weixin.builder;

import com.example.weixin.cp.bean.message.WxCpXmlOutMessage;
import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.message.WxCpXmlMessage;
import com.example.weixin.cp.bean.message.WxCpXmlOutMessage;
import com.example.weixin.cp.bean.message.WxCpXmlOutTextMessage;

/**
 *  @author Binary Wang(https://github.com/binarywang)
 */
public class TextBuilder extends AbstractBuilder {

  @Override
  public WxCpXmlOutMessage build(String content, WxCpXmlMessage wxMessage,
                                 WxCpService service) {
    WxCpXmlOutTextMessage m = WxCpXmlOutMessage.TEXT().content(content)
        .fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName())
        .build();
    return m;
  }

}
