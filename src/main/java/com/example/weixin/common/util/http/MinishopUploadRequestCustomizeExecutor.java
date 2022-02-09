package com.example.weixin.common.util.http;

import com.example.weixin.common.bean.result.WxMinishopImageUploadCustomizeResult;
import com.example.weixin.common.enums.WxType;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.common.util.http.apache.ApacheMinishopMediaUploadRequestCustomizeExecutor;
import com.example.weixin.common.util.http.jodd.JoddHttpMinishopMediaUploadRequestCustomizeExecutor;
import com.example.weixin.common.util.http.okhttp.OkHttpMinishopMediaUploadRequestCustomizeExecutor;

import java.io.File;
import java.io.IOException;

public abstract class MinishopUploadRequestCustomizeExecutor<H, P> implements RequestExecutor<WxMinishopImageUploadCustomizeResult, File> {
  protected RequestHttp<H, P> requestHttp;
  protected String respType;

  public MinishopUploadRequestCustomizeExecutor(RequestHttp requestHttp, String respType) {
    this.requestHttp = requestHttp;
    this.respType = respType;
  }

  @Override
  public void execute(String uri, File data, ResponseHandler<WxMinishopImageUploadCustomizeResult> handler, WxType wxType) throws WxErrorException, IOException {
    handler.handle(this.execute(uri, data, wxType));
  }

  public static RequestExecutor<WxMinishopImageUploadCustomizeResult, File> create(RequestHttp requestHttp, String respType) {
    switch (requestHttp.getRequestType()) {
      case APACHE_HTTP:
        return new ApacheMinishopMediaUploadRequestCustomizeExecutor(requestHttp, respType);
      case JODD_HTTP:
        return new JoddHttpMinishopMediaUploadRequestCustomizeExecutor(requestHttp, respType);
      case OK_HTTP:
        return new OkHttpMinishopMediaUploadRequestCustomizeExecutor(requestHttp, respType);
      default:
        return null;
    }
  }
}
