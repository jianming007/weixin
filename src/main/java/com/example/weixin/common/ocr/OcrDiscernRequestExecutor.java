package com.example.weixin.common.ocr;

import com.example.weixin.common.enums.WxType;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.common.util.http.RequestExecutor;
import com.example.weixin.common.util.http.RequestHttp;
import com.example.weixin.common.util.http.ResponseHandler;

import java.io.File;
import java.io.IOException;

/**
 * .
 *
 * @author zhayueran
 * @date 2019/6/27 15:06
 */
public abstract class OcrDiscernRequestExecutor<H, P> implements RequestExecutor<String, File> {
  protected RequestHttp<H, P> requestHttp;

  public OcrDiscernRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  @Override
  public void execute(String uri, File data, ResponseHandler<String> handler, WxType wxType) throws WxErrorException, IOException {
    handler.handle(this.execute(uri, data, wxType));
  }

  public static RequestExecutor<String, File> create(RequestHttp requestHttp) {
    switch (requestHttp.getRequestType()) {
      case APACHE_HTTP:
        return new OcrDiscernApacheHttpRequestExecutor(requestHttp);
      default:
        return null;
    }
  }
}
