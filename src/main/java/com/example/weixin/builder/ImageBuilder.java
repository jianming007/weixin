package com.example.weixin.builder;

import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.message.WxCpXmlMessage;
import com.example.weixin.cp.bean.message.WxCpXmlOutImageMessage;
import com.example.weixin.cp.bean.message.WxCpXmlOutMessage;


/**
 *  @author Binary Wang(https://github.com/binarywang)
 */
public class ImageBuilder extends AbstractBuilder {

  @Override
  public WxCpXmlOutMessage build(String content, WxCpXmlMessage wxMessage,
                                 WxCpService service) {

    WxCpXmlOutImageMessage m = WxCpXmlOutMessage.IMAGE().mediaId(content)
        .fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName())
        .build();

    return m;
  }

}
