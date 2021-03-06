package com.example.weixin.cp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.weixin.common.api.WxConsts;
import com.example.weixin.common.util.xml.XStreamCDataConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("xml")
@Data
@EqualsAndHashCode(callSuper = true)
public class WxCpXmlOutNewsMessage extends WxCpXmlOutMessage {
  private static final long serialVersionUID = -5796178637883178826L;

  @XStreamAlias("Articles")
  protected final List<Item> articles = new ArrayList<>();

  @XStreamAlias("ArticleCount")
  protected int articleCount;

  public WxCpXmlOutNewsMessage() {
    this.msgType = WxConsts.XmlMsgType.NEWS;
  }


  public void addArticle(Item item) {
    this.articles.add(item);
    this.articleCount = this.articles.size();
  }

  @XStreamAlias("item")
  @Data
  public static class Item implements Serializable {
    private static final long serialVersionUID = -8672761162722733622L;

    @XStreamAlias("Title")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String title;

    @XStreamAlias("Description")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String description;

    @XStreamAlias("PicUrl")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String picUrl;

    @XStreamAlias("Url")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String url;

  }

}
