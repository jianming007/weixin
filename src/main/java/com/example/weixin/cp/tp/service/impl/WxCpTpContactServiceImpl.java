package com.example.weixin.cp.tp.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.cp.bean.WxCpTpContactSearch;
import com.example.weixin.cp.bean.WxCpTpContactSearchResp;
import com.example.weixin.cp.tp.service.WxCpTpContactService;
import com.example.weixin.cp.tp.service.WxCpTpService;

import static com.example.weixin.cp.constant.WxCpApiPathConsts.Tp.CONTACT_SEARCH;

/**
 * @author uianz
 * @description
 * @since 2020/12/23 下午 02:39
 */
@RequiredArgsConstructor
public class WxCpTpContactServiceImpl implements WxCpTpContactService {

  private final WxCpTpService mainService;

  @Override
  public WxCpTpContactSearchResp contactSearch(WxCpTpContactSearch wxCpTpContactSearch) throws WxErrorException {
    String responseText =
      mainService.post(mainService.getWxCpTpConfigStorage().getApiUrl(CONTACT_SEARCH) + "?provider_access_token=" + mainService.getWxCpProviderToken(), wxCpTpContactSearch.toJson());
    return WxCpTpContactSearchResp.fromJson(responseText);
  }

}
