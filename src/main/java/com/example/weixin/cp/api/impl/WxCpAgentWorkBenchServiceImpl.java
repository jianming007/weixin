package com.example.weixin.cp.api.impl;

import com.google.gson.JsonObject;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.cp.api.WxCpAgentWorkBenchService;
import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.WxCpAgentWorkBench;
import lombok.RequiredArgsConstructor;

import static com.example.weixin.cp.constant.WxCpApiPathConsts.WorkBench.*;

/**
 * @author songshiyu
 * @date : create in 11:24 2020/9/28
 * @description: 工作台自定义展示实现
 */
@RequiredArgsConstructor
public class WxCpAgentWorkBenchServiceImpl implements WxCpAgentWorkBenchService {
  private final WxCpService mainService;

  @Override
  public void setWorkBenchTemplate(WxCpAgentWorkBench wxCpAgentWorkBench) throws WxErrorException {
    final String url = String.format(this.mainService.getWxCpConfigStorage().getApiUrl(WORKBENCH_TEMPLATE_SET));
    this.mainService.post(url, wxCpAgentWorkBench.toTemplateString());
  }

  @Override
  public String getWorkBenchTemplate(Long agentId) throws WxErrorException {
    final String url = String.format(this.mainService.getWxCpConfigStorage().getApiUrl(WORKBENCH_TEMPLATE_GET));
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("agentid", agentId);
    return this.mainService.post(url, jsonObject.toString());
  }

  @Override
  public void setWorkBenchData(WxCpAgentWorkBench wxCpAgentWorkBench) throws WxErrorException {
    final String url = String.format(this.mainService.getWxCpConfigStorage().getApiUrl(WORKBENCH_DATA_SET));
    this.mainService.post(url, wxCpAgentWorkBench.toUserDataString());
  }
}
