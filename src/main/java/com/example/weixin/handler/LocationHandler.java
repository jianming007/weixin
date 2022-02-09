package com.example.weixin.handler;

import com.example.weixin.builder.TextBuilder;
import com.example.weixin.common.api.WxConsts;
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
public class LocationHandler extends AbstractHandler {

  @Override
  public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage, Map<String, Object> context, WxCpService cpService,
                                  WxSessionManager sessionManager) {
    if (wxMessage.getMsgType().equals(WxConsts.XmlMsgType.LOCATION)) {
      //TODO 接收处理用户发送的地理位置消息
      try {
        String content = "感谢反馈，您的的地理位置已收到！";
        return new TextBuilder().build(content, wxMessage, null);
      } catch (Exception e) {
        this.logger.error("位置消息接收处理失败", e);
        return null;
      }
    }

    //上报地理位置事件
    this.logger.info("\n上报地理位置，纬度 : {}\n经度 : {}\n精度 : {}",
        wxMessage.getLatitude(), wxMessage.getLongitude(), String.valueOf(wxMessage.getPrecision()));

    //TODO  可以将用户地理位置信息保存到本地数据库，以便以后使用

    return null;
  }

}