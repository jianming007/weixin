package com.example.weixin.cp.bean.external.moment;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class VisibleRange implements Serializable {
  @SerializedName("sender_list")
  private SenderList senderList;
  @SerializedName("external_contact_list")
  private ExternalContactList externalContactList;
}
