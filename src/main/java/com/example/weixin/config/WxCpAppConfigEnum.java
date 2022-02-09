package com.example.weixin.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 企业微信应用配置,
 * 企业微信中不同的应用会有不同的agentId和secret值
 * @author wangjianming
 */
@Getter
@AllArgsConstructor
public enum WxCpAppConfigEnum {
    /** 通讯录, 通讯录不需要agentId 此处只要不和其它地方重复就行*/
    CONTACT(1001,"","","");

    /**
     * 设置企业微信应用的AgentId
     */
    private Integer agentId;

    /**
     * 设置企业微信应用的Secret
     */
    private String secret;

    /**
     * 设置企业微信应用的token
     */
    private String token;

    /**
     * 设置企业微信应用的EncodingAESKey
     */
    private String aesKey;



}
