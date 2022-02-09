package com.example.weixin.common.bean.ocr;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import com.example.weixin.common.util.json.WxGsonBuilder;

import java.io.Serializable;

/**
 * @author Theo Nie
 */
@Data
public class WxOcrImgSize implements Serializable {
  private static final long serialVersionUID = 5234409123551074168L;

  @SerializedName("w")
  private int w;
  @SerializedName("h")
  private int h;

  @Override
  public String toString() {
    return WxGsonBuilder.create().toJson(this);
  }
}
