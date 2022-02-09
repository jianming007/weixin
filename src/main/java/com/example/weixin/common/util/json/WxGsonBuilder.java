package com.example.weixin.common.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.weixin.common.bean.WxAccessToken;
import com.example.weixin.common.bean.WxNetCheckResult;
import com.example.weixin.common.bean.menu.WxMenu;
import com.example.weixin.common.bean.result.WxMediaUploadResult;
import com.example.weixin.common.error.WxError;

/**
 * .
 * @author chanjarster
 */
public class WxGsonBuilder {
  private static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxAccessToken.class, new WxAccessTokenAdapter());
    INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
    INSTANCE.registerTypeAdapter(WxMenu.class, new WxMenuGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMediaUploadResult.class, new WxMediaUploadResultAdapter());
    INSTANCE.registerTypeAdapter(WxNetCheckResult.class, new WxNetCheckResultGsonAdapter());

  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
