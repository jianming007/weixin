package com.example.weixin.cp.api.impl;

import jodd.http.HttpConnectionProvider;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import jodd.http.net.SocketHttpConnectionProvider;
import com.example.weixin.common.bean.WxAccessToken;
import com.example.weixin.common.enums.WxType;
import com.example.weixin.common.error.WxError;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.common.util.http.HttpType;
import com.example.weixin.cp.config.WxCpConfigStorage;
import com.example.weixin.cp.constant.WxCpApiPathConsts;

/**
 * @author someone
 */
public class WxCpServiceJoddHttpImpl extends BaseWxCpServiceImpl<HttpConnectionProvider, ProxyInfo> {
  private HttpConnectionProvider httpClient;
  private ProxyInfo httpProxy;

  @Override
  public HttpConnectionProvider getRequestHttpClient() {
    return httpClient;
  }

  @Override
  public ProxyInfo getRequestHttpProxy() {
    return httpProxy;
  }

  @Override
  public HttpType getRequestType() {
    return HttpType.JODD_HTTP;
  }

  @Override
  public String getAccessToken(boolean forceRefresh) throws WxErrorException {
    if (!this.configStorage.isAccessTokenExpired() && !forceRefresh) {
      return this.configStorage.getAccessToken();
    }

    synchronized (this.globalAccessTokenRefreshLock) {
      HttpRequest request = HttpRequest.get(String.format(this.configStorage.getApiUrl(WxCpApiPathConsts.GET_TOKEN),
        this.configStorage.getCorpId(), this.configStorage.getCorpSecret()));
      if (this.httpProxy != null) {
        httpClient.useProxy(this.httpProxy);
      }
      request.withConnectionProvider(httpClient);
      HttpResponse response = request.send();

      String resultContent = response.bodyText();
      WxError error = WxError.fromJson(resultContent, WxType.CP);
      if (error.getErrorCode() != 0) {
        throw new WxErrorException(error);
      }
      WxAccessToken accessToken = WxAccessToken.fromJson(resultContent);
      this.configStorage.updateAccessToken(accessToken.getAccessToken(), accessToken.getExpiresIn());
    }
    return this.configStorage.getAccessToken();
  }

  @Override
  public void initHttp() {
    if (this.configStorage.getHttpProxyHost() != null && this.configStorage.getHttpProxyPort() > 0) {
      httpProxy = new ProxyInfo(ProxyInfo.ProxyType.HTTP, configStorage.getHttpProxyHost(),
        configStorage.getHttpProxyPort(), configStorage.getHttpProxyUsername(), configStorage.getHttpProxyPassword());
    }

    httpClient = new SocketHttpConnectionProvider();
  }

  @Override
  public WxCpConfigStorage getWxCpConfigStorage() {
    return this.configStorage;
  }
}
