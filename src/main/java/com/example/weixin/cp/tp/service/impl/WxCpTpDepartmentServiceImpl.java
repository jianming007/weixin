package com.example.weixin.cp.tp.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.common.util.json.GsonHelper;
import com.example.weixin.common.util.json.GsonParser;
import com.example.weixin.cp.api.impl.WxCpDepartmentServiceImpl;
import com.example.weixin.cp.bean.WxCpTpDepart;
import com.example.weixin.cp.tp.service.WxCpTpDepartmentService;
import com.example.weixin.cp.tp.service.WxCpTpService;
import com.example.weixin.cp.util.json.WxCpGsonBuilder;

import java.util.List;

import static com.example.weixin.cp.constant.WxCpApiPathConsts.Department.*;

/**
 * @author uianz
 * @description corp from {@link WxCpDepartmentServiceImpl )}
 * 唯一不同在于获取部门列表时需要传对应企业的accessToken
 * @since 2020/12/23 下午 02:39
 */
@RequiredArgsConstructor
public class WxCpTpDepartmentServiceImpl implements WxCpTpDepartmentService {
  private final WxCpTpService mainService;

  @Override
  public Long create(WxCpTpDepart depart) throws WxErrorException {
    String url = this.mainService.getWxCpTpConfigStorage().getApiUrl(DEPARTMENT_CREATE);
    String responseContent = this.mainService.post(url, depart.toJson());
    JsonObject tmpJsonObject = GsonParser.parse(responseContent);
    return GsonHelper.getAsLong(tmpJsonObject.get("id"));
  }

  @Override
  public void update(WxCpTpDepart group) throws WxErrorException {
    String url = this.mainService.getWxCpTpConfigStorage().getApiUrl(DEPARTMENT_UPDATE);
    this.mainService.post(url, group.toJson());
  }

  @Override
  public void delete(Long departId) throws WxErrorException {
    String url = String.format(this.mainService.getWxCpTpConfigStorage().getApiUrl(DEPARTMENT_DELETE), departId);
    this.mainService.get(url, null);
  }

  @Override
  public List<WxCpTpDepart> list(Long id, String corpId) throws WxErrorException {
    String url = this.mainService.getWxCpTpConfigStorage().getApiUrl(DEPARTMENT_LIST);
    url += "?access_token=" + this.mainService.getWxCpTpConfigStorage().getAccessToken(corpId);
    if (id != null) {
      url += "&id=" + id;
    }
    String responseContent = this.mainService.get(url, null);
    JsonObject tmpJsonObject = GsonParser.parse(responseContent);
    return WxCpGsonBuilder.create()
      .fromJson(tmpJsonObject.get("department"),
        new TypeToken<List<WxCpTpDepart>>() {
        }.getType()
      );
  }

  @Override
  public List<WxCpTpDepart> list(String corpId) throws WxErrorException {
    return list(null, corpId);
  }
}
