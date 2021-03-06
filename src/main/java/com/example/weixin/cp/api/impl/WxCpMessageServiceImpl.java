package com.example.weixin.cp.api.impl;

import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.cp.api.WxCpMessageService;
import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.message.*;
import com.example.weixin.cp.constant.WxCpApiPathConsts.Message;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;

/**
 * 消息推送接口实现类.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-08-30
 */
@RequiredArgsConstructor
public class WxCpMessageServiceImpl implements WxCpMessageService {
  private final WxCpService cpService;

  @Override
  public WxCpMessageSendResult send(WxCpMessage message) throws WxErrorException {
    Integer agentId = message.getAgentId();
    if (null == agentId) {
      message.setAgentId(this.cpService.getWxCpConfigStorage().getAgentId());
    }

    return WxCpMessageSendResult.fromJson(this.cpService.post(this.cpService.getWxCpConfigStorage()
      .getApiUrl(Message.MESSAGE_SEND), message.toJson()));
  }

  @Override
  public WxCpMessageSendStatistics getStatistics(int timeType) throws WxErrorException {
    return WxCpMessageSendStatistics.fromJson(this.cpService.post(this.cpService.getWxCpConfigStorage().getApiUrl(Message.GET_STATISTICS),
      WxCpGsonBuilder.create().toJson(ImmutableMap.of("time_type", timeType))));
  }

  @Override
  public WxCpLinkedCorpMessageSendResult sendLinkedCorpMessage(WxCpLinkedCorpMessage message) throws WxErrorException {
    Integer agentId = message.getAgentId();
    if (null == agentId) {
      message.setAgentId(this.cpService.getWxCpConfigStorage().getAgentId());
    }

    return WxCpLinkedCorpMessageSendResult.fromJson(this.cpService.post(this.cpService.getWxCpConfigStorage()
      .getApiUrl(Message.LINKEDCORP_MESSAGE_SEND), message.toJson()));
  }
}
