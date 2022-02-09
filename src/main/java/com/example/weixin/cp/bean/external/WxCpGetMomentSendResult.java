package com.example.weixin.cp.bean.external;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.weixin.cp.bean.WxCpBaseResp;
import com.example.weixin.cp.bean.external.moment.CustomerItem;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;

import java.util.List;

/**
 * 企业发表内容到客户的朋友圈 获取客户朋友圈发表后的可见客户列表
 *
 * @author leiin
 * @date 2021-10-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxCpGetMomentSendResult extends WxCpBaseResp {
  private static final long serialVersionUID = -5782811995184523379L;
  @SerializedName("next_cursor")
  private String nextCursor;
  @SerializedName("customer_list")
  private List<CustomerItem> customerList;

  public static WxCpGetMomentSendResult fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpGetMomentSendResult.class);
  }

  public String toJson() {
    return WxCpGsonBuilder.create().toJson(this);
  }
}