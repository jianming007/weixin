package com.example.weixin.cp.api;

import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.cp.bean.message.*;

/**
 * 消息推送接口.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020 -08-30
 */
public interface WxCpMessageService {
  /**
   * <pre>
   * 发送消息
   * 详情请见: https://work.weixin.qq.com/api/doc/90000/90135/90236
   * </pre>
   *
   * @param message 要发送的消息对象
   * @return the wx cp message send result
   * @throws WxErrorException the wx error exception
   */
  WxCpMessageSendResult send(WxCpMessage message) throws WxErrorException;

  /**
   * <pre>
   * 查询应用消息发送统计
   * 请求方式：POST（HTTPS）
   * 请求地址：https://qyapi.weixin.qq.com/cgi-bin/message/get_statistics?access_token=ACCESS_TOKEN
   *
   * 详情请见: https://work.weixin.qq.com/api/doc/90000/90135/92369
   * </pre>
   *
   * @param timeType 查询哪天的数据，0：当天；1：昨天。默认为0。
   * @return 统计结果
   * @throws WxErrorException the wx error exception
   */
  WxCpMessageSendStatistics getStatistics(int timeType) throws WxErrorException;

  /**
   * <pre>
   * 互联企业的应用支持推送文本、图片、视频、文件、图文等类型。
   *
   * 请求地址：https://qyapi.weixin.qq.com/cgi-bin/linkedcorp/message/send?access_token=ACCESS_TOKEN
   * 文章地址：https://work.weixin.qq.com/api/doc/90000/90135/90250
   * </pre>
   *
   * @param message 要发送的消息对象
   * @return the wx cp message send result
   * @throws WxErrorException the wx error exception
   */
  WxCpLinkedCorpMessageSendResult sendLinkedCorpMessage(WxCpLinkedCorpMessage message) throws WxErrorException;
}
