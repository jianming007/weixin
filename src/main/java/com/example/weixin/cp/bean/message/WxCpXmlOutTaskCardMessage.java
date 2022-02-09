package com.example.weixin.cp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.weixin.common.api.WxConsts;
import com.example.weixin.common.util.xml.XStreamReplaceNameConverter;

@XStreamAlias("xml")
@Data
@EqualsAndHashCode(callSuper = false)
public class WxCpXmlOutTaskCardMessage extends WxCpXmlOutMessage {
  private static final long serialVersionUID = 7028014900972827324L;

  @XStreamAlias("TaskCard")
  @XStreamConverter(value = XStreamReplaceNameConverter.class)
  private String replaceName;

  public WxCpXmlOutTaskCardMessage() {
    this.msgType = WxConsts.XmlMsgType.UPDATE_TASKCARD;
  }

}
