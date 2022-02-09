package com.example.weixin.cp.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.weixin.common.bean.menu.WxMenu;
import com.example.weixin.common.error.WxError;
import com.example.weixin.common.util.json.WxErrorAdapter;
import com.example.weixin.cp.bean.WxCpChat;
import com.example.weixin.cp.bean.WxCpDepart;
import com.example.weixin.cp.bean.WxCpTag;
import com.example.weixin.cp.bean.WxCpUser;

/**
 * 项目中使用的2种序列化方式，
 * 如下第一种： INSTANCE.registerTypeAdapter()方式,
 * 第二种：使用com.google.gson.annotations注解 @SerializedName的方式，构建序列化对象，
 * 推荐使用第二种方式，不要再使用第一种方式做序列化
 * @author Daniel Qian
 */
public class WxCpGsonBuilder {

  private static final GsonBuilder INSTANCE = new GsonBuilder();

  /**
   *
   * */
  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxCpChat.class, new WxCpChatGsonAdapter());
    INSTANCE.registerTypeAdapter(WxCpDepart.class, new WxCpDepartGsonAdapter());
    INSTANCE.registerTypeAdapter(WxCpUser.class, new WxCpUserGsonAdapter());
    INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
    INSTANCE.registerTypeAdapter(WxMenu.class, new WxCpMenuGsonAdapter());
    INSTANCE.registerTypeAdapter(WxCpTag.class, new WxCpTagGsonAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
