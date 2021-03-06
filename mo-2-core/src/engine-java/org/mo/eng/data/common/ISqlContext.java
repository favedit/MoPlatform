package org.mo.eng.data.common;

import org.mo.com.data.ISqlConnect;
import org.mo.core.context.IContext;

//============================================================
// <T>数据环境接口。</T>
//============================================================
public interface ISqlContext
      extends
         IContext,
         ISqlConnect
{
   //============================================================
   // <T>获得默认名称。</T>
   //
   // @return 默认名称
   //============================================================
   String defaultName();

   //============================================================
   // <T>设置默认名称。</T>
   //
   // @param defaultName 默认名称
   //============================================================
   void setDefaultName(String defaultName);

   //============================================================
   // <T>回滚处理。</T>
   //============================================================
   void rollback();
}
