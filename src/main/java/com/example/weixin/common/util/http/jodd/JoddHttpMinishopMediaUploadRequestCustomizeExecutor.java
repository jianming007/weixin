package com.example.weixin.common.util.http.jodd;

import jodd.http.HttpConnectionProvider;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import lombok.extern.slf4j.Slf4j;
import com.example.weixin.common.bean.result.WxMinishopImageUploadCustomizeResult;
import com.example.weixin.common.enums.WxType;
import com.example.weixin.common.error.WxError;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.common.util.http.MinishopUploadRequestCustomizeExecutor;
import com.example.weixin.common.util.http.RequestHttp;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author liming1019
 * @date 2021/8/10
 */
@Slf4j
public class JoddHttpMinishopMediaUploadRequestCustomizeExecutor extends MinishopUploadRequestCustomizeExecutor<HttpConnectionProvider, ProxyInfo> {
  public JoddHttpMinishopMediaUploadRequestCustomizeExecutor(RequestHttp requestHttp, String respType) {
    super(requestHttp, respType);
  }

  @Override
  public WxMinishopImageUploadCustomizeResult execute(String uri, File file, WxType wxType) throws WxErrorException, IOException {
    HttpRequest request = HttpRequest.post(uri);
    if (requestHttp.getRequestHttpProxy() != null) {
      requestHttp.getRequestHttpClient().useProxy(requestHttp.getRequestHttpProxy());
    }
    request.withConnectionProvider(requestHttp.getRequestHttpClient());
    request.form("media", file);
    HttpResponse response = request.send();
    response.charset(StandardCharsets.UTF_8.name());

    String responseContent = response.bodyText();
    WxError error = WxError.fromJson(responseContent, wxType);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    }
    log.info("responseContent: " + responseContent);

    return WxMinishopImageUploadCustomizeResult.fromJson(responseContent);
  }
}
