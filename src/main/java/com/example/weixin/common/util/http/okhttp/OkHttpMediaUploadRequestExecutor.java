package com.example.weixin.common.util.http.okhttp;

import com.example.weixin.common.bean.result.WxMediaUploadResult;
import com.example.weixin.common.enums.WxType;
import com.example.weixin.common.error.WxError;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.common.util.http.MediaUploadRequestExecutor;
import com.example.weixin.common.util.http.RequestHttp;
import okhttp3.*;

import java.io.File;
import java.io.IOException;

/**
 * .
 *
 * @author ecoolper
 * @date 2017/5/5
 */
public class OkHttpMediaUploadRequestExecutor extends MediaUploadRequestExecutor<OkHttpClient, OkHttpProxyInfo> {
  public OkHttpMediaUploadRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public WxMediaUploadResult execute(String uri, File file, WxType wxType) throws WxErrorException, IOException {

    RequestBody body = new MultipartBody.Builder()
      .setType(MediaType.parse("multipart/form-data"))
      .addFormDataPart("media",
        file.getName(),
        RequestBody.create(MediaType.parse("application/octet-stream"), file))
      .build();
    Request request = new Request.Builder().url(uri).post(body).build();

    Response response = requestHttp.getRequestHttpClient().newCall(request).execute();
    String responseContent = response.body().string();
    WxError error = WxError.fromJson(responseContent, wxType);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    }
    return WxMediaUploadResult.fromJson(responseContent);
  }

}
