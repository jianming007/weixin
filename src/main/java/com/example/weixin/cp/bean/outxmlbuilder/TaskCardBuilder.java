package com.example.weixin.cp.bean.outxmlbuilder;

import com.example.weixin.cp.bean.message.WxCpXmlOutTaskCardMessage;

/**
 * 任务卡片消息builder
 *
 * @author tao zhang
 */
public final class TaskCardBuilder extends BaseBuilder<TaskCardBuilder, WxCpXmlOutTaskCardMessage> {

  private String replaceName;

  public TaskCardBuilder replaceName(String replaceName) {
    this.replaceName = replaceName;
    return this;
  }

  @Override
  public WxCpXmlOutTaskCardMessage build() {
    WxCpXmlOutTaskCardMessage m = new WxCpXmlOutTaskCardMessage();
    setCommon(m);
    m.setReplaceName(this.replaceName);
    return m;
  }

}
