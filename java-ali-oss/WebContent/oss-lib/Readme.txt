阿里云计算开放服务软件开发工具包Java版
Aliyun OSS SDK for Java

版权所有 （C）阿里云计算有限公司

Copyright (C) Alibaba Cloud Computing
All rights reserved.

http://www.aliyun.com

环境要求：
- J2SE Development Kit (JDK) 6.0或以上版
- Apache Commons （Codec、HTTP Client和Logging）、JDOM等第三方软件包（已包含在SDK的下载压缩包中）。
- 必须注册有Aliyun.com用户账户，并开通OSS服务。

2.7.0更新日志：
- 添加：支持`processObject`接口
- 修复：`doesObjectExist`使用[GetObjectMeta](https://help.aliyun.com/document_detail/31985.html)实现
- 修复：`createUdfApplication`去掉 ***IoOptimized*** 字段
- 修复：`createSymlink`无法设置链接文件的元信息
- 修复：`uploadFile`默认没有设置*ContentType*
