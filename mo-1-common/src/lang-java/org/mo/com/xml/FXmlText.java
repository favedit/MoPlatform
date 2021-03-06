package org.mo.com.xml;

//============================================================
// <T>XML文本节点。</T>
//============================================================
public class FXmlText
      extends FXmlNode
{
   //============================================================
   // <T>构造XML文本节点。</T>
   //============================================================
   public FXmlText(){
      _typeCd = EXmlNode.Text;
   }

   //============================================================
   // <T>构造XML文本节点。</T>
   //
   // @parma name 名称
   //============================================================
   public FXmlText(String name){
      super(name);
      _typeCd = EXmlNode.Text;
   }
}
