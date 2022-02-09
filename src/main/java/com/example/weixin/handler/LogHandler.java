package com.example.weixin.handler;

import com.example.weixin.common.session.WxSessionManager;
import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.message.WxCpXmlMessage;
import com.example.weixin.cp.bean.message.WxCpXmlOutMessage;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class LogHandler extends AbstractHandler {
  @Override
  public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage, Map<String, Object> context, WxCpService cpService,
                                  WxSessionManager sessionManager) {
    this.logger.info("\n接收到请求消息，内容：{}", WxCpGsonBuilder.create().toJson(wxMessage));
    return null;
  }

}
