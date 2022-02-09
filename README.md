# weixin

微信demo项目

参考开源框架WxJava做的demo，开源项目地址: https://github.com/Wechat-Group/WxJava

目前只加入了框架common 和 cp两个模块， 项目只做整体分包不做多个模块。

# 测试步骤
    1. 配置 com.example.weixin.config.WxCpAppConfigEnum 中的配置, 多个配置自行添加即可
    2. 配置 com.example.weixin.config.WxCpConfiguration 中的CORPID(企业id) 
    3. 修改 application-test.yml 中的redis配置
    4. 运行 com.example.weixin.DepartmentTests 中的测试方法


# 备注
    1.具体使用方法参考WxJava项目即可, 个人建议多写单元测试跑通自己要用的接口
    2.对于框架细节上会有遗漏, 可能存在问题.
    3.接口序列化请使用com.google.gson.annotations注解 @SerializedName的方式
    4.本项目存在分包不合理
    5.Spring Boot 版本过低, 建议大家使用更高版本