package org.mo.eng.export.common;

import org.mo.com.xml.IXmlObject;

//============================================================
// <T>对象对象的XML节点基类。</T>
//============================================================
public interface XObjectFace
      extends IXmlObject
{
   // 名称定义
   String NAME = "IObject";

   // 名称的名称定义
   String PTY_NAME = "name";

   // 标签的名称定义
   String PTY_LABEL = "label";

   // 有效性的名称定义
   String PTY_IS_VALID = "is_valid";

   // 描述信息的名称定义
   String PTY_NOTE = "note";

   // 列代码的名称定义
   String PTY_HIDE_CODE = "hide_code";

   //============================================================
   // <T>获得名称的内容。</T>
   //
   // @return 名称
   //============================================================
   String getName();

   //============================================================
   // <T>设置名称的内容。</T>
   //
   // @param value 名称
   //============================================================
   void setName(String value);

   //============================================================
   // <T>获得标签的内容。</T>
   //
   // @return 标签
   //============================================================
   String getLabel();

   //============================================================
   // <T>设置标签的内容。</T>
   //
   // @param value 标签
   //============================================================
   void setLabel(String value);

   //============================================================
   // <T>获得有效性的内容。</T>
   //
   // @return 有效性
   //============================================================
   Boolean getIsValid();

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   void setIsValid(Boolean value);

   //============================================================
   // <T>获得描述信息的内容。</T>
   //
   // @return 描述信息
   //============================================================
   String getNote();

   //============================================================
   // <T>设置描述信息的内容。</T>
   //
   // @param value 描述信息
   //============================================================
   void setNote(String value);

   //============================================================
   // <T>获得列代码的内容。</T>
   //
   // @return 列代码
   //============================================================
   String getHideCode();

   //============================================================
   // <T>设置列代码的内容。</T>
   //
   // @param value 列代码
   //============================================================
   void setHideCode(String value);
}