package com.example.weixin.cp.bean.external;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import com.example.weixin.common.util.json.WxGsonBuilder;
import com.example.weixin.cp.bean.WxCpBaseResp;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangxm129
 */
@Getter
@Setter
public class WxCpUserExternalTagGroupList extends WxCpBaseResp {
  private static final long serialVersionUID = -3349321791821450679L;

  @SerializedName("tag_group")
  private List<TagGroup> tagGroupList;

  @Getter
  @Setter
  public static class TagGroup implements Serializable {
    private static final long serialVersionUID = -4301684507150486556L;

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("group_name")
    private String groupName;

    @SerializedName("create_time")
    private Long createTime;

    @SerializedName("order")
    private Long order;

    @SerializedName("deleted")
    private Boolean deleted;


    @SerializedName("tag")
    private List<Tag> tag;

    @Getter
    @Setter
    public static class Tag implements Serializable {
      private static final long serialVersionUID = -4301684507150486556L;

      /**
       * 客户群ID
       */
      @SerializedName("id")
      private String id;

      @SerializedName("name")
      private String name;

      @SerializedName("create_time")
      private Long createTime;

      @SerializedName("order")
      private Long order;

      @SerializedName("deleted")
      private Boolean deleted;

    }
  }

  public String toJson() {
    return WxGsonBuilder.create().toJson(this);
  }

  public static WxCpUserExternalTagGroupList fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpUserExternalTagGroupList.class);
  }
}
