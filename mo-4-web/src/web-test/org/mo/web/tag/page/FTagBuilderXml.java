package org.mo.web.tag.page;

import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.web.tag.util.FTagBuilder;

public class FTagBuilderXml
{

   public static void main(String[] args){
      String path = "D:/Workspace/mylife/webroot/WEB-INF";
      try{
         RAop.configConsole().loadFile("D:/Workspace/mylife/src/home/application.xml");
         FTagBuilder builder = new FTagBuilder();

         builder.buildFromFile(path + "/config/web.tag/html.xml");
         builder.saveToFile(path + "/html.tld");

         builder.buildFromFile(path + "/config/web.tag/control.xml");
         builder.saveToFile(path + "/control.tld");

         builder.buildFromFile(path + "/config/web.tag/system.xml");
         builder.saveToFile(path + "/system.tld");

         RAop.release();
      }catch(Exception e){
         RLogger.find(FTagBuilderXml.class).error(null, "main", e);
      }
   }

}
