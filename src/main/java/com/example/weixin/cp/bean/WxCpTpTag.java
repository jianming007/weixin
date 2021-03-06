package com.example.weixin.cp.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;

/**
 *
 * @author zhangq <zhangq002@gmail.com>
 * @since 2021-02-14 16:15 16:15
 */
@Data
public class WxCpTpTag implements Serializable {

  private static final long serialVersionUID = 581740383760234134L;

  @SerializedName("tagid")
  private String tagId;

  @SerializedName("tagname")
  private String tagName;

  public static WxCpTpTag deserialize(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpTpTag.class);
  }
}
