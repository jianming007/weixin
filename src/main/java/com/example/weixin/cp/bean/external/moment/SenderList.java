package com.example.weixin.cp.bean.external.moment;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SenderList {
  @SerializedName("user_list")
  private List<String> userList;
  @SerializedName("department_list")
  private List<String> departmentList;
}
