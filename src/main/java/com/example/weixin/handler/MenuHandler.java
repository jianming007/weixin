package com.example.weixin.handler;

import com.example.weixin.common.api.WxConsts.MenuButtonType;
import com.example.weixin.common.session.WxSessionManager;
import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.message.WxCpXmlMessage;
import com.example.weixin.cp.bean.message.WxCpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MenuHandler extends AbstractHandler {

  @Override
  public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage, Map<String, Object> context, WxCpService cpService,
                                  WxSessionManager sessionManager) {

    String msg = String.format("type:%s, event:%s, key:%s",
        wxMessage.getMsgType(), wxMessage.getEvent(),
        wxMessage.getEventKey());
    if (MenuButtonType.VIEW.equals(wxMessage.getEvent())) {
      return null;
    }

    return WxCpXmlOutMessage.TEXT().content(msg)
        .fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName())
        .build();
  }

}
