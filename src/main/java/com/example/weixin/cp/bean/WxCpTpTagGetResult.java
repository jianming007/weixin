package com.example.weixin.cp.bean;

import com.example.weixin.cp.util.json.WxCpGsonBuilder;

/**
 * 获取标签成员接口响应体
 * @author zhangq <zhangq002@gmail.com>
 * @since 2021/2/14 16:28
 */
public class WxCpTpTagGetResult extends WxCpTagGetResult {
  private static final long serialVersionUID = 9051748686315562400L;

  public static WxCpTpTagGetResult deserialize(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpTpTagGetResult.class);
  }

}