package org.mo.data.statistics;

import org.mo.data.statistics.common.XStatistics;
import org.mo.eng.store.IXmlConfigConsole;

//============================================================
// <T>数据统计控制台。</T>
//============================================================ 
public interface IStatisticsConsole
      extends
         IXmlConfigConsole<XStatistics>
{
   //============================================================
   // <T>获得处理模式。</T>
   //
   // @return 处理模式
   //============================================================
   String processMode();

   //============================================================
   // <T>加载处理。</T>
   //============================================================
   void load();

   //============================================================
   // <T>启动处理。</T>
   //============================================================
   void startup();
}
