package com.example.weixin.builder;

import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.message.WxCpXmlMessage;
import com.example.weixin.cp.bean.message.WxCpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @author Binary Wang(https://github.com/binarywang)
 */
public abstract class AbstractBuilder {
  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public abstract WxCpXmlOutMessage build(String content, WxCpXmlMessage wxMessage, WxCpService service);
}
