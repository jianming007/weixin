package com.example.weixin.common.util.http.apache;

import lombok.extern.slf4j.Slf4j;
import com.example.weixin.common.bean.result.WxMinishopImageUploadCustomizeResult;
import com.example.weixin.common.enums.WxType;
import com.example.weixin.common.error.WxError;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.common.util.http.MinishopUploadRequestCustomizeExecutor;
import com.example.weixin.common.util.http.RequestHttp;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.File;
import java.io.IOException;

/**
 * Created by liming1019 on 2021/8/10.
 */
@Slf4j
public class ApacheMinishopMediaUploadRequestCustomizeExecutor extends MinishopUploadRequestCustomizeExecutor<CloseableHttpClient, HttpHost> {
  public ApacheMinishopMediaUploadRequestCustomizeExecutor(RequestHttp requestHttp, String respType) {
    super(requestHttp, respType);
  }

  @Override
  public WxMinishopImageUploadCustomizeResult execute(String uri, File file, WxType wxType) throws WxErrorException, IOException {
    HttpPost httpPost = new HttpPost(uri);
    if (requestHttp.getRequestHttpProxy() != null) {
      RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
      httpPost.setConfig(config);
    }
    if (file != null) {
      HttpEntity entity = MultipartEntityBuilder
        .create()
        .addBinaryBody("media", file)
        .addTextBody("resp_type", this.respType)
        .setMode(HttpMultipartMode.RFC6532)
        .build();
      httpPost.setEntity(entity);
    }
    try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpPost)) {
      String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
      WxError error = WxError.fromJson(responseContent, wxType);
      if (error.getErrorCode() != 0) {
        throw new WxErrorException(error);
      }
      log.info("responseContent: " + responseContent);
      return WxMinishopImageUploadCustomizeResult.fromJson(responseContent);
    } finally {
      httpPost.releaseConnection();
    }
  }
}
