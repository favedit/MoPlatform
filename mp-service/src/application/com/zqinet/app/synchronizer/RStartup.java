package com.zqinet.app.synchronizer;

import org.mo.com.logging.ELoggerLevel;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.system.RApplication;
import org.mo.core.aop.RAop;
import org.mo.data.synchronizer.ISynchronizerConsole;
import org.mt.core.aop.RAopTest;

//============================================================
// <T>数据同步启动器。</T>
//============================================================
public class RStartup
{

   // 日志输出接口
   private final static ILogger _logger = RLogger.find(RStartup.class);

   //============================================================
   // <T>启动处理。</T>
   //============================================================
   public static void main(String[] args){
      try{
         // 关联参数
         RApplication.linkArgements(args);
         // 获得设置
         String homeOption = RApplication.findArgement("-home", "D:/ZW-Platform.WK/mp-service/src/config");
         String configOption = RApplication.findArgement("-config", "application-synchronizer-local.xml");
         // 设置日志
         String loggerOption = RApplication.findArgement("-logger");
         if("info".equals(loggerOption)){
            RLogger.setFlags(ELoggerLevel.NO_DEBUG.value());
         }
         // 加载设置文件
         String configFileName = homeOption + "/" + configOption;
         RAop.configConsole().loadFile(configFileName);
         // 获得同步器控制台
         ISynchronizerConsole console = RAop.find(ISynchronizerConsole.class);
         // 加载设置
         console.load();
         // 启动处理
         console.startup();
         // 释放资源
         RAop.release();
      }catch(Exception e){
         _logger.error(RAopTest.class, "main", e);
      }
   }
}
