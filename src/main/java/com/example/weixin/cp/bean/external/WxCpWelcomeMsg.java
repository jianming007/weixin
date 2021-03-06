package com.example.weixin.cp.bean.external;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.weixin.cp.bean.external.msg.Attachment;
import com.example.weixin.cp.bean.external.msg.Text;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * 新客户欢迎语.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-08-16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxCpWelcomeMsg implements Serializable {
  private static final long serialVersionUID = 4170843890468921757L;

  @SerializedName("welcome_code")
  private String welcomeCode;

  private Text text;

  private List<Attachment> attachments;

  public String toJson() {
    return WxCpGsonBuilder.create().toJson(this);
  }
}
