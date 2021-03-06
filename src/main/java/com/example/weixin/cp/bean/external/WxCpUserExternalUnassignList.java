package com.example.weixin.cp.bean.external;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import com.example.weixin.cp.bean.WxCpBaseResp;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * 离职员工外部联系人列表
 *
 * @author yqx
 * @date 2020/3/15
 */
@Getter
@Setter
public class WxCpUserExternalUnassignList extends WxCpBaseResp {

  @SerializedName("info")
  private List<UnassignInfo> unassignInfos;

  @SerializedName("is_last")
  private boolean isLast;

  @Getter
  @Setter
  public static class UnassignInfo implements Serializable {
    private static final long serialVersionUID = -4301684507150486556L;

    /**
     * 离职成员userid
     */
    @SerializedName("handover_userid")
    private String handoverUserid;

    /**
     * 外部联系人userid
     */
    @SerializedName("external_userid")
    private String externalUserid;

    /**
     * 成员离职时间
     */
    @SerializedName("dimission_time")
    private Long dimissionTime;
  }

  public static WxCpUserExternalUnassignList fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpUserExternalUnassignList.class);
  }
}
