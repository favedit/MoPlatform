package org.mo.web.protocol.context;

import org.mo.com.lang.IAttributes;
import org.mo.com.lang.IRelease;
import org.mo.com.message.FMessages;
import org.mo.logic.session.ISqlSessionContext;
import org.mo.web.core.container.common.FWebContainerCollection;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.common.FWebUploadFiles;

//============================================================
// <T>网页环境接口。</T>
//============================================================
public interface IWebContext
      extends
         IRelease
{
   //============================================================
   // <T>获得网页会话。</T>
   //
   // @return 网页会话
   //============================================================
   IWebSession session();

   //============================================================
   // <T>获得页面设置。</T>
   //
   // @return 页面设置
   //============================================================
   FPageConfig pageConfig();

   //============================================================
   // <T>获得页面状态。</T>
   //
   // @return 页面状态
   //============================================================
   IPageStatus pageStatus();

   //============================================================
   // <T>获得环境路径。</T>
   //
   // @return 环境路径
   //============================================================
   String contextPath();

   //============================================================
   // <T>获得环境路径。</T>
   //
   // @param uri 相对路径
   // @return 环境路径
   //============================================================
   String contextPath(String uri);

   //============================================================
   // <T>获得环境标签。</T>
   //
   // @return 环境标签
   //============================================================
   String contextTag();

   //============================================================
   // <T>获得环境标签。</T>
   //
   // @param uri 相对路径
   // @return 环境标签
   //============================================================
   String contextTag(String uri);

   //============================================================
   // <T>获得远程地址。</T>
   //
   // @return 远程地址
   //============================================================
   String remoteAddress();

   //============================================================
   // <T>获得远程主机。</T>
   //
   // @return 远程主机
   //============================================================
   String remoteHost();

   //============================================================
   // <T>获得远程端口。</T>
   //
   // @return 远程端口
   //============================================================
   int remotePort();

   //============================================================
   // <T>获得远程用户。</T>
   //
   // @return 远程用户
   //============================================================
   String remoteUser();

   //============================================================
   // <T>获得远程路径。</T>
   //
   // @return 远程路径
   //============================================================
   String requestPath();

   //============================================================
   // <T>获得请求相对地址。</T>
   //
   // @return 请求相对地址
   //============================================================
   String requestUri();

   //============================================================
   // <T>设置请求相对地址。</T>
   //
   // @param requestUri 请求相对地址
   //============================================================
   void setRequestUri(String requestUri);

   //============================================================
   // <T>获得请求全地址。</T>
   //
   // @return 请求全地址
   //============================================================
   String requestUrl();

   //============================================================
   // <T>获得请求字符串。</T>
   //
   // @return 请求字符串
   //============================================================
   String queryString();

   //============================================================
   // <T>获得头信息集合。</T>
   //
   // @return 头信息集合
   //============================================================
   IAttributes heads();

   //============================================================
   // <T>根据名称获得头信息。</T>
   //
   // @param name 名称
   // @return 头信息
   //============================================================
   String head(String sName);

   //============================================================
   // <T>获得参数集合。</T>
   //
   // @return 参数集合
   //============================================================
   IAttributes parameters();

   //============================================================
   // <T>根据名称获得参数信息。</T>
   //
   // @param name 名称
   // @return 参数信息
   //============================================================
   String parameter(String name);

   //============================================================
   // <T>获得COOKIE信息集合。</T>
   //
   // @return COOKIE信息集合
   //============================================================
   IAttributes cookies();

   //============================================================
   // <T>根据名称获得COOKIE信息。</T>
   //
   // @param name 名称
   // @return COOKIE信息
   //============================================================
   String cookie(String name);

   //============================================================
   // <T>测试COOKIE是否发生变更。</T>
   //
   // @return 是否变更
   //============================================================
   boolean testCookieChanged();

   //============================================================
   // <T>判断是否含有文件。</T>
   //
   // @return 是否含有
   //============================================================
   boolean hasFile();

   //============================================================
   // <T>获得文件集合。</T>
   //
   // @return 文件集合
   //============================================================
   FWebUploadFiles files();

   //============================================================
   // <T>获得网络应答。</T>
   //
   // @return 网络应答
   //============================================================
   IWebResponse response();

   //============================================================
   // <T>根据名称获得属性。</T>
   //
   // @param name 名称
   // @return 属性
   //============================================================
   Object attribute(String name);

   //============================================================
   // <T>根据名称设置属性。</T>
   //
   // @param name 名称
   // @param value 属性
   //============================================================
   void setAttribute(String name,
                     Object value);

   //============================================================
   // <T>获得容器集合。</T>
   //
   // @return 容器集合
   //============================================================
   FWebContainerCollection containers();

   //============================================================
   // <T>获得SQL环境。</T>
   //
   // @return SQL环境
   //============================================================
   ISqlSessionContext sqlContext();

   //============================================================
   // <T>检查是否含有消息。</T>
   //
   // @return 是否含有
   //============================================================
   boolean hasMessages();

   //============================================================
   // <T>获得消息集合。</T>
   //
   // @return 消息集合
   //============================================================
   FMessages messages();

   //============================================================
   // <T>检查是否定义了当前别称。</T>
   //
   // @param alias 别称
   // @return 是否定义
   //============================================================
   boolean hasDefine(String alias);

   //============================================================
   // <T>给指定对象定义一个别称。</T>
   //
   // @param alias 别称
   // @param item 对象
   //============================================================
   void define(String alias,
               Object item);

   //============================================================
   // <T>根据别称移除一个定义。</T>
   //
   // @param alias 别称
   //============================================================
   void undefine(String alias);

   //============================================================
   // <T>解析图标路径。</T>
   //
   // @param source 来源
   // @return 图标路径
   //============================================================
   String parseIconPath(String source);

   //============================================================
   // <T>解析图片路径。</T>
   //
   // @param source 来源
   // @return 图片路径
   //============================================================
   String parseImagePath(String source);

   //   String env(String name);
   //
   //   void setEnv(String name,
   //               String value);
   //
   //   void setRequestUri(String requestUri);
   //
   //   ISqlSessionContext sqlContext();
}
