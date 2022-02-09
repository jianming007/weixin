package com.example.weixin.cp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.weixin.common.api.WxConsts;
import com.example.weixin.common.util.xml.XStreamCDataConverter;

@XStreamAlias("xml")
@Data
@EqualsAndHashCode(callSuper = false)
public class WxCpXmlOutTextMessage extends WxCpXmlOutMessage {
  private static final long serialVersionUID = 2569239617185930232L;

  @XStreamAlias("Content")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String content;

  public WxCpXmlOutTextMessage() {
    this.msgType = WxConsts.XmlMsgType.TEXT;
  }

}
