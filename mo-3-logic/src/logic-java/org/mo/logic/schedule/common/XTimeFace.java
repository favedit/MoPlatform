package org.mo.logic.schedule.common;

import org.mo.com.xml.IXmlObject;

//============================================================
// <T>计划时间对象的XML节点基类。</T>
//============================================================
public interface XTimeFace
      extends IXmlObject
{
   // 名称定义
   String NAME = "ITime";

   // 执行时间的名称定义
   String PTY_EXECUTE_TIME = "execute_time";

   // 计划状态的名称定义
   String PTY_STATUE_CD = "statue_cd";

   // 时间类型的名称定义
   String PTY_TYPE_CD = "type_cd";

   // 时间间隔的名称定义
   String PTY_INTERVAL = "interval";

   // 执行标识的名称定义
   String PTY_DAY_FLAG = "day_flag";

   // 执行标识的名称定义
   String PTY_WEEK_FLAG = "week_flag";

   // 执行标识的名称定义
   String PTY_MONTH_FLAG = "month_flag";

   // 更新时间的名称定义
   String PTY_UPDATE_DATE = "update_date";

   //============================================================
   // <T>获得执行时间的内容。</T>
   //
   // @return 执行时间
   //============================================================
   String getExecuteTime();

   //============================================================
   // <T>设置执行时间的内容。</T>
   //
   // @param value 执行时间
   //============================================================
   void setExecuteTime(String value);

   //============================================================
   // <T>获得计划状态的内容。</T>
   //
   // @return 计划状态
   //============================================================
   String getStatueCd();

   //============================================================
   // <T>设置计划状态的内容。</T>
   //
   // @param value 计划状态
   //============================================================
   void setStatueCd(String value);

   //============================================================
   // <T>获得时间类型的内容。</T>
   //
   // @return 时间类型
   //============================================================
   String getTypeCd();

   //============================================================
   // <T>设置时间类型的内容。</T>
   //
   // @param value 时间类型
   //============================================================
   void setTypeCd(String value);

   //============================================================
   // <T>获得时间间隔的内容。</T>
   //
   // @return 时间间隔
   //============================================================
   String getInterval();

   //============================================================
   // <T>设置时间间隔的内容。</T>
   //
   // @param value 时间间隔
   //============================================================
   void setInterval(String value);

   //============================================================
   // <T>获得执行标识的内容。</T>
   //
   // @return 执行标识
   //============================================================
   String getDayFlag();

   //============================================================
   // <T>设置执行标识的内容。</T>
   //
   // @param value 执行标识
   //============================================================
   void setDayFlag(String value);

   //============================================================
   // <T>获得执行标识的内容。</T>
   //
   // @return 执行标识
   //============================================================
   String getWeekFlag();

   //============================================================
   // <T>设置执行标识的内容。</T>
   //
   // @param value 执行标识
   //============================================================
   void setWeekFlag(String value);

   //============================================================
   // <T>获得执行标识的内容。</T>
   //
   // @return 执行标识
   //============================================================
   String getMonthFlag();

   //============================================================
   // <T>设置执行标识的内容。</T>
   //
   // @param value 执行标识
   //============================================================
   void setMonthFlag(String value);

   //============================================================
   // <T>获得更新时间的内容。</T>
   //
   // @return 更新时间
   //============================================================
   String getUpdateDate();

   //============================================================
   // <T>设置更新时间的内容。</T>
   //
   // @param value 更新时间
   //============================================================
   void setUpdateDate(String value);
}