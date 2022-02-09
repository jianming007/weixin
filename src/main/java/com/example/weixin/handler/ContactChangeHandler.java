package com.example.weixin.handler;

import com.example.weixin.builder.TextBuilder;
import com.example.weixin.common.session.WxSessionManager;
import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.message.WxCpXmlMessage;
import com.example.weixin.cp.bean.message.WxCpXmlOutMessage;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 通讯录变更事件处理器.
 *
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class ContactChangeHandler extends AbstractHandler {

  @Override
  public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage, Map<String, Object> context, WxCpService cpService,
                                  WxSessionManager sessionManager) {
    String content = "收到通讯录变更事件，内容：" + WxCpGsonBuilder.create().toJson(wxMessage);
    this.logger.info(content);

    return new TextBuilder().build(content, wxMessage, cpService);
  }

}
