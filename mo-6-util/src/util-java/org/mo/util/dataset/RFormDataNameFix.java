package org.mo.util.dataset;

import org.mo.com.io.RFile;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.util.data.RDataImport;

public class RFormDataNameFix
{

   private final static ILogger _logger = RLogger.find(RDataImport.class);

   public static void main(String[] args){
      try{
         String config = "D:/Workspace/eUIS/webroot/WEB-INF/config/design.webform";
         for(String fileName : RFile.listAllFile(config)){
            if(fileName.endsWith(".xml")){
               boolean isChanged = false;
               FXmlDocument xdoc = new FXmlDocument(fileName);
               // Node
               for(FXmlNode node : xdoc.root().allNodes()){
                  if(node.isName("Column")){
                     node.setName("ColumnEdit");
                     isChanged = true;
                  }
               }
               if(isChanged){
                  System.out.println(fileName);
                  xdoc.store();
               }
            }
         }
      }catch(Exception e){
         _logger.error(null, "main", e);
      }
   }
}
