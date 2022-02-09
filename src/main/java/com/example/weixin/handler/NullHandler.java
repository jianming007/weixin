package com.example.weixin.handler;

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
public class NullHandler extends AbstractHandler {

  @Override
  public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage, Map<String, Object> context, WxCpService cpService,
                                  WxSessionManager sessionManager) {
    return null;
  }

}
