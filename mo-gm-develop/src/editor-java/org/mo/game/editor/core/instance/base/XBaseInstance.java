package org.mo.game.editor.core.instance.base;

import org.mo.com.lang.FMultiString;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.lang.face.AName;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlObject;
import org.mo.com.xml.IXmlObject;
import org.mo.game.editor.core.instance.common.XObjectFace;

//============================================================
// <T>实例对象的XML节点基类。</T>
//============================================================
public abstract class XBaseInstance
      extends FXmlObject
      implements
         XObjectFace
{
   // 名称定义
   public static final String NAME = "Instance";

   //============================================================
   // <T>获得名称定义。</T>
   //
   // @return 名称定义
   //============================================================
   public String name(){
      return NAME;
   }

   //============================================================
   // <T>判断是否指定名称。</T>
   //
   // @param name 名称
   // @return 是否指定
   //============================================================
   public static boolean isName(String name){
      return NAME.equals(name);
   }

   //============================================================
   // <T>判断是否指定实例。</T>
   //
   // @param xobject 对象
   // @return 是否指定
   //============================================================
   public static boolean isInstance(IXmlObject xobject){
      return NAME.equals(xobject.name());
   }

   // 名称的名称定义
   public static final String PTY_NAME = "name";

   // 标签的名称定义
   public static final String PTY_LABEL = "label";

   // 有效性的名称定义
   public static final String PTY_IS_VALID = "is_valid";

   // 注释的名称定义
   public static final String PTY_NOTE = "note";

   // 代码号的名称定义
   public static final String PTY_CODE = "code";

   // 衍生类的名称定义
   public static final String PTY_IS_CLASS = "is_class";

   // 封装类的名称定义
   public static final String PTY_IS_FINAL = "is_final";

   // 源名称的名称定义
   public static final String PTY_SOURCE_NAME = "source_name";

   // 父名称的名称定义
   public static final String PTY_PARENT_NAME = "parent_name";

   // 封装父的名称定义
   public static final String PTY_PARENT_FINAL = "parent_final";

   // 实体类型的名称定义
   public static final String PTY_ENTITY_TYPE = "entity_type";

   // 代码类型的名称定义
   public static final String PTY_SOURCE_TYPE = "source_type";

   // 目标类型的名称定义
   public static final String PTY_TARGET_TYPE = "target_type";

   // 代码值的名称定义
   public static final String PTY_CODE_VALUE = "code_value";

   // 属性可的名称定义
   public static final String PTY_IS_PROPERTY = "is_property";

   // 属性分组的名称定义
   public static final String PTY_PROPERTY_GROUP = "property_group";

   // 名称的定义
   @AName("name")
   protected String _name;

   // 标签的定义
   @AName("label")
   protected String _label;

   // 有效性的定义
   @AName("is_valid")
   protected Boolean _isValid = Boolean.FALSE;

   // 注释的定义
   @AName("note")
   protected FMultiString _note = new FMultiString();

   // 代码号的定义
   @AName("code")
   protected String _code;

   // 衍生类的定义
   @AName("is_class")
   protected String _isClass;

   // 封装类的定义
   @AName("is_final")
   protected String _isFinal;

   // 源名称的定义
   @AName("source_name")
   protected String _sourceName;

   // 父名称的定义
   @AName("parent_name")
   protected String _parentName;

   // 封装父的定义
   @AName("parent_final")
   protected String _parentFinal;

   // 实体类型的定义
   @AName("entity_type")
   protected String _entityType;

   // 代码类型的定义
   @AName("source_type")
   protected String _sourceType;

   // 目标类型的定义
   @AName("target_type")
   protected String _targetType;

   // 代码值的定义
   @AName("code_value")
   protected String _codeValue;

   // 属性可的定义
   @AName("is_property")
   protected String _isProperty;

   // 属性分组的定义
   @AName("property_group")
   protected String _propertyGroup;

   //============================================================
   // <T>获得名称的内容。</T>
   //
   // @return 名称
   //============================================================
   public String getName(){
      return _name;
   }

   //============================================================
   // <T>设置名称的内容。</T>
   //
   // @param value 名称
   //============================================================
   public void setName(String value){
      _name = value;
   }

   //============================================================
   // <T>获得标签的内容。</T>
   //
   // @return 标签
   //============================================================
   public String getLabel(){
      return _label;
   }

   //============================================================
   // <T>设置标签的内容。</T>
   //
   // @param value 标签
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>获得有效性的内容。</T>
   //
   // @return 有效性
   //============================================================
   public Boolean getIsValid(){
      return _isValid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setIsValid(Boolean value){
      _isValid = value;
   }

   //============================================================
   // <T>获得注释的内容。</T>
   //
   // @return 注释
   //============================================================
   public String getNote(){
      return _note.get();
   }

   //============================================================
   // <T>设置注释的内容。</T>
   //
   // @param value 注释
   //============================================================
   public void setNote(String value){
      _note.set(value);
   }

   //============================================================
   // <T>获得代码号的内容。</T>
   //
   // @return 代码号
   //============================================================
   public String getCode(){
      return _code;
   }

   //============================================================
   // <T>设置代码号的内容。</T>
   //
   // @param value 代码号
   //============================================================
   public void setCode(String value){
      _code = value;
   }

   //============================================================
   // <T>获得衍生类的内容。</T>
   //
   // @return 衍生类
   //============================================================
   public String getIsClass(){
      return _isClass;
   }

   //============================================================
   // <T>设置衍生类的内容。</T>
   //
   // @param value 衍生类
   //============================================================
   public void setIsClass(String value){
      _isClass = value;
   }

   //============================================================
   // <T>获得封装类的内容。</T>
   //
   // @return 封装类
   //============================================================
   public String getIsFinal(){
      return _isFinal;
   }

   //============================================================
   // <T>设置封装类的内容。</T>
   //
   // @param value 封装类
   //============================================================
   public void setIsFinal(String value){
      _isFinal = value;
   }

   //============================================================
   // <T>获得源名称的内容。</T>
   //
   // @return 源名称
   //============================================================
   public String getSourceName(){
      return _sourceName;
   }

   //============================================================
   // <T>设置源名称的内容。</T>
   //
   // @param value 源名称
   //============================================================
   public void setSourceName(String value){
      _sourceName = value;
   }

   //============================================================
   // <T>获得父名称的内容。</T>
   //
   // @return 父名称
   //============================================================
   public String getParentName(){
      return _parentName;
   }

   //============================================================
   // <T>设置父名称的内容。</T>
   //
   // @param value 父名称
   //============================================================
   public void setParentName(String value){
      _parentName = value;
   }

   //============================================================
   // <T>获得封装父的内容。</T>
   //
   // @return 封装父
   //============================================================
   public String getParentFinal(){
      return _parentFinal;
   }

   //============================================================
   // <T>设置封装父的内容。</T>
   //
   // @param value 封装父
   //============================================================
   public void setParentFinal(String value){
      _parentFinal = value;
   }

   //============================================================
   // <T>获得实体类型的内容。</T>
   //
   // @return 实体类型
   //============================================================
   public String getEntityType(){
      return _entityType;
   }

   //============================================================
   // <T>设置实体类型的内容。</T>
   //
   // @param value 实体类型
   //============================================================
   public void setEntityType(String value){
      _entityType = value;
   }

   //============================================================
   // <T>获得代码类型的内容。</T>
   //
   // @return 代码类型
   //============================================================
   public String getSourceType(){
      return _sourceType;
   }

   //============================================================
   // <T>设置代码类型的内容。</T>
   //
   // @param value 代码类型
   //============================================================
   public void setSourceType(String value){
      _sourceType = value;
   }

   //============================================================
   // <T>获得目标类型的内容。</T>
   //
   // @return 目标类型
   //============================================================
   public String getTargetType(){
      return _targetType;
   }

   //============================================================
   // <T>设置目标类型的内容。</T>
   //
   // @param value 目标类型
   //============================================================
   public void setTargetType(String value){
      _targetType = value;
   }

   //============================================================
   // <T>获得代码值的内容。</T>
   //
   // @return 代码值
   //============================================================
   public String getCodeValue(){
      return _codeValue;
   }

   //============================================================
   // <T>设置代码值的内容。</T>
   //
   // @param value 代码值
   //============================================================
   public void setCodeValue(String value){
      _codeValue = value;
   }

   //============================================================
   // <T>获得属性可的内容。</T>
   //
   // @return 属性可
   //============================================================
   public String getIsProperty(){
      return _isProperty;
   }

   //============================================================
   // <T>设置属性可的内容。</T>
   //
   // @param value 属性可
   //============================================================
   public void setIsProperty(String value){
      _isProperty = value;
   }

   //============================================================
   // <T>获得属性分组的内容。</T>
   //
   // @return 属性分组
   //============================================================
   public String getPropertyGroup(){
      return _propertyGroup;
   }

   //============================================================
   // <T>设置属性分组的内容。</T>
   //
   // @param value 属性分组
   //============================================================
   public void setPropertyGroup(String value){
      _propertyGroup = value;
   }

   //============================================================
   // <T>内部获得内容置信息。</T>
   //
   // @param name 名称
   // @return 内容
   //============================================================
   public String innerGet(String name){
      if(RString.isEmpty(name)){
         return null;
      }else if(PTY_NAME.equalsIgnoreCase(name)){
         return getName();
      }else if(PTY_LABEL.equalsIgnoreCase(name)){
         return getLabel();
      }else if(PTY_IS_VALID.equalsIgnoreCase(name)){
         return RBoolean.toString(getIsValid());
      }else if(PTY_NOTE.equalsIgnoreCase(name)){
         return getNote();
      }else if(PTY_CODE.equalsIgnoreCase(name)){
         return getCode();
      }else if(PTY_IS_CLASS.equalsIgnoreCase(name)){
         return getIsClass();
      }else if(PTY_IS_FINAL.equalsIgnoreCase(name)){
         return getIsFinal();
      }else if(PTY_SOURCE_NAME.equalsIgnoreCase(name)){
         return getSourceName();
      }else if(PTY_PARENT_NAME.equalsIgnoreCase(name)){
         return getParentName();
      }else if(PTY_PARENT_FINAL.equalsIgnoreCase(name)){
         return getParentFinal();
      }else if(PTY_ENTITY_TYPE.equalsIgnoreCase(name)){
         return getEntityType();
      }else if(PTY_SOURCE_TYPE.equalsIgnoreCase(name)){
         return getSourceType();
      }else if(PTY_TARGET_TYPE.equalsIgnoreCase(name)){
         return getTargetType();
      }else if(PTY_CODE_VALUE.equalsIgnoreCase(name)){
         return getCodeValue();
      }else if(PTY_IS_PROPERTY.equalsIgnoreCase(name)){
         return getIsProperty();
      }else if(PTY_PROPERTY_GROUP.equalsIgnoreCase(name)){
         return getPropertyGroup();
      }
      return null;
   }

   //============================================================
   // <T>内部设置内容置信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   public void innerSet(String name, String value){
      if(RString.isEmpty(name)){
         return;
      }else if(PTY_NAME.equalsIgnoreCase(name)){
         setName(value);
      }else if(PTY_LABEL.equalsIgnoreCase(name)){
         setLabel(value);
      }else if(PTY_IS_VALID.equalsIgnoreCase(name)){
         setIsValid(RBoolean.parse(value));
      }else if(PTY_NOTE.equalsIgnoreCase(name)){
         setNote(value);
      }else if(PTY_CODE.equalsIgnoreCase(name)){
         setCode(value);
      }else if(PTY_IS_CLASS.equalsIgnoreCase(name)){
         setIsClass(value);
      }else if(PTY_IS_FINAL.equalsIgnoreCase(name)){
         setIsFinal(value);
      }else if(PTY_SOURCE_NAME.equalsIgnoreCase(name)){
         setSourceName(value);
      }else if(PTY_PARENT_NAME.equalsIgnoreCase(name)){
         setParentName(value);
      }else if(PTY_PARENT_FINAL.equalsIgnoreCase(name)){
         setParentFinal(value);
      }else if(PTY_ENTITY_TYPE.equalsIgnoreCase(name)){
         setEntityType(value);
      }else if(PTY_SOURCE_TYPE.equalsIgnoreCase(name)){
         setSourceType(value);
      }else if(PTY_TARGET_TYPE.equalsIgnoreCase(name)){
         setTargetType(value);
      }else if(PTY_CODE_VALUE.equalsIgnoreCase(name)){
         setCodeValue(value);
      }else if(PTY_IS_PROPERTY.equalsIgnoreCase(name)){
         setIsProperty(value);
      }else if(PTY_PROPERTY_GROUP.equalsIgnoreCase(name)){
         setPropertyGroup(value);
      }
   }

   //============================================================
   // <T>加载设置信息。</T>
   //
   // @param config 设置信息
   // @param type 类型
   //============================================================
   public void loadConfig(FXmlNode config, EXmlConfig type){
      super.loadConfig(config, type);
      if(EXmlConfig.Full == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            _note.unpack(config.get(PTY_NOTE));
         }
         if(config.contains("code")){
            setCode(config.get(PTY_CODE));
         }
         if(config.contains("is_class")){
            setIsClass(config.get(PTY_IS_CLASS));
         }
         if(config.contains("is_final")){
            setIsFinal(config.get(PTY_IS_FINAL));
         }
         if(config.contains("source_name")){
            setSourceName(config.get(PTY_SOURCE_NAME));
         }
         if(config.contains("parent_name")){
            setParentName(config.get(PTY_PARENT_NAME));
         }
         if(config.contains("parent_final")){
            setParentFinal(config.get(PTY_PARENT_FINAL));
         }
         if(config.contains("entity_type")){
            setEntityType(config.get(PTY_ENTITY_TYPE));
         }
         if(config.contains("source_type")){
            setSourceType(config.get(PTY_SOURCE_TYPE));
         }
         if(config.contains("target_type")){
            setTargetType(config.get(PTY_TARGET_TYPE));
         }
         if(config.contains("code_value")){
            setCodeValue(config.get(PTY_CODE_VALUE));
         }
         if(config.contains("is_property")){
            setIsProperty(config.get(PTY_IS_PROPERTY));
         }
         if(config.contains("property_group")){
            setPropertyGroup(config.get(PTY_PROPERTY_GROUP));
         }
      }else if(EXmlConfig.Simple == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            setNote(config.get(PTY_NOTE));
         }
         if(config.contains("code")){
            setCode(config.get(PTY_CODE));
         }
         if(config.contains("is_class")){
            setIsClass(config.get(PTY_IS_CLASS));
         }
         if(config.contains("is_final")){
            setIsFinal(config.get(PTY_IS_FINAL));
         }
         if(config.contains("source_name")){
            setSourceName(config.get(PTY_SOURCE_NAME));
         }
         if(config.contains("parent_name")){
            setParentName(config.get(PTY_PARENT_NAME));
         }
         if(config.contains("parent_final")){
            setParentFinal(config.get(PTY_PARENT_FINAL));
         }
         if(config.contains("entity_type")){
            setEntityType(config.get(PTY_ENTITY_TYPE));
         }
         if(config.contains("source_type")){
            setSourceType(config.get(PTY_SOURCE_TYPE));
         }
         if(config.contains("target_type")){
            setTargetType(config.get(PTY_TARGET_TYPE));
         }
         if(config.contains("code_value")){
            setCodeValue(config.get(PTY_CODE_VALUE));
         }
         if(config.contains("is_property")){
            setIsProperty(config.get(PTY_IS_PROPERTY));
         }
         if(config.contains("property_group")){
            setPropertyGroup(config.get(PTY_PROPERTY_GROUP));
         }
      }else if(EXmlConfig.Value == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            setNote(config.get(PTY_NOTE));
         }
         if(config.contains("code")){
            setCode(config.get(PTY_CODE));
         }
         if(config.contains("is_class")){
            setIsClass(config.get(PTY_IS_CLASS));
         }
         if(config.contains("is_final")){
            setIsFinal(config.get(PTY_IS_FINAL));
         }
         if(config.contains("source_name")){
            setSourceName(config.get(PTY_SOURCE_NAME));
         }
         if(config.contains("parent_name")){
            setParentName(config.get(PTY_PARENT_NAME));
         }
         if(config.contains("parent_final")){
            setParentFinal(config.get(PTY_PARENT_FINAL));
         }
         if(config.contains("entity_type")){
            setEntityType(config.get(PTY_ENTITY_TYPE));
         }
         if(config.contains("source_type")){
            setSourceType(config.get(PTY_SOURCE_TYPE));
         }
         if(config.contains("target_type")){
            setTargetType(config.get(PTY_TARGET_TYPE));
         }
         if(config.contains("code_value")){
            setCodeValue(config.get(PTY_CODE_VALUE));
         }
         if(config.contains("is_property")){
            setIsProperty(config.get(PTY_IS_PROPERTY));
         }
         if(config.contains("property_group")){
            setPropertyGroup(config.get(PTY_PROPERTY_GROUP));
         }
      }else if(EXmlConfig.Default == type){
         if(RString.isEmpty(getCode())){
            if(config.contains("code")){
               setCode(config.get(PTY_CODE));
            }
         }
         if(RString.isEmpty(getIsClass())){
            if(config.contains("is_class")){
               setIsClass(config.get(PTY_IS_CLASS));
            }
         }
         if(RString.isEmpty(getIsFinal())){
            if(config.contains("is_final")){
               setIsFinal(config.get(PTY_IS_FINAL));
            }
         }
         if(RString.isEmpty(getSourceName())){
            if(config.contains("source_name")){
               setSourceName(config.get(PTY_SOURCE_NAME));
            }
         }
         if(RString.isEmpty(getParentName())){
            if(config.contains("parent_name")){
               setParentName(config.get(PTY_PARENT_NAME));
            }
         }
         if(RString.isEmpty(getParentFinal())){
            if(config.contains("parent_final")){
               setParentFinal(config.get(PTY_PARENT_FINAL));
            }
         }
         if(RString.isEmpty(getEntityType())){
            if(config.contains("entity_type")){
               setEntityType(config.get(PTY_ENTITY_TYPE));
            }
         }
         if(RString.isEmpty(getSourceType())){
            if(config.contains("source_type")){
               setSourceType(config.get(PTY_SOURCE_TYPE));
            }
         }
         if(RString.isEmpty(getTargetType())){
            if(config.contains("target_type")){
               setTargetType(config.get(PTY_TARGET_TYPE));
            }
         }
         if(RString.isEmpty(getCodeValue())){
            if(config.contains("code_value")){
               setCodeValue(config.get(PTY_CODE_VALUE));
            }
         }
         if(RString.isEmpty(getIsProperty())){
            if(config.contains("is_property")){
               setIsProperty(config.get(PTY_IS_PROPERTY));
            }
         }
         if(RString.isEmpty(getPropertyGroup())){
            if(config.contains("property_group")){
               setPropertyGroup(config.get(PTY_PROPERTY_GROUP));
            }
         }
      }
   }

   //============================================================
   // <T>保存设置信息。</T>
   //
   // @param config 设置信息
   // @param type 类型
   //============================================================
   public void saveConfig(FXmlNode config, EXmlConfig type){
      config.setName(NAME);
      super.saveConfig(config, type);
      if(EXmlConfig.Full == type){
         if(RString.isNotEmpty(getName())){
            config.set(PTY_NAME, getName());
         }
         if(RString.isNotEmpty(getLabel())){
            config.set(PTY_LABEL, getLabel());
         }
         if(RBoolean.parse(getIsValid())){
            config.set(PTY_IS_VALID, RBoolean.toString(getIsValid()));
         }
         String note = _note.pack().toString();
         if(RString.isNotEmpty(note)){
            config.set(PTY_NOTE, note);
         }
         if(RString.isNotEmpty(getCode())){
            config.set(PTY_CODE, getCode());
         }
         if(RString.isNotEmpty(getIsClass())){
            config.set(PTY_IS_CLASS, getIsClass());
         }
         if(RString.isNotEmpty(getIsFinal())){
            config.set(PTY_IS_FINAL, getIsFinal());
         }
         if(RString.isNotEmpty(getSourceName())){
            config.set(PTY_SOURCE_NAME, getSourceName());
         }
         if(RString.isNotEmpty(getParentName())){
            config.set(PTY_PARENT_NAME, getParentName());
         }
         if(RString.isNotEmpty(getParentFinal())){
            config.set(PTY_PARENT_FINAL, getParentFinal());
         }
         if(RString.isNotEmpty(getEntityType())){
            config.set(PTY_ENTITY_TYPE, getEntityType());
         }
         if(RString.isNotEmpty(getSourceType())){
            config.set(PTY_SOURCE_TYPE, getSourceType());
         }
         if(RString.isNotEmpty(getTargetType())){
            config.set(PTY_TARGET_TYPE, getTargetType());
         }
         if(RString.isNotEmpty(getCodeValue())){
            config.set(PTY_CODE_VALUE, getCodeValue());
         }
         if(RString.isNotEmpty(getIsProperty())){
            config.set(PTY_IS_PROPERTY, getIsProperty());
         }
         if(RString.isNotEmpty(getPropertyGroup())){
            config.set(PTY_PROPERTY_GROUP, getPropertyGroup());
         }
      }else if(EXmlConfig.Simple == type){
         if(RString.isNotEmpty(getName())){
            config.set(PTY_NAME, getName());
         }
         if(RString.isNotEmpty(getLabel())){
            config.set(PTY_LABEL, getLabel());
         }
         if(RBoolean.parse(getIsValid())){
            config.set(PTY_IS_VALID, RBoolean.toString(getIsValid()));
         }
         if(RString.isNotEmpty(getNote())){
            config.set(PTY_NOTE, getNote());
         }
         if(RString.isNotEmpty(getCode())){
            config.set(PTY_CODE, getCode());
         }
         if(RString.isNotEmpty(getIsClass())){
            config.set(PTY_IS_CLASS, getIsClass());
         }
         if(RString.isNotEmpty(getIsFinal())){
            config.set(PTY_IS_FINAL, getIsFinal());
         }
         if(RString.isNotEmpty(getSourceName())){
            config.set(PTY_SOURCE_NAME, getSourceName());
         }
         if(RString.isNotEmpty(getParentName())){
            config.set(PTY_PARENT_NAME, getParentName());
         }
         if(RString.isNotEmpty(getParentFinal())){
            config.set(PTY_PARENT_FINAL, getParentFinal());
         }
         if(RString.isNotEmpty(getEntityType())){
            config.set(PTY_ENTITY_TYPE, getEntityType());
         }
         if(RString.isNotEmpty(getSourceType())){
            config.set(PTY_SOURCE_TYPE, getSourceType());
         }
         if(RString.isNotEmpty(getTargetType())){
            config.set(PTY_TARGET_TYPE, getTargetType());
         }
         if(RString.isNotEmpty(getCodeValue())){
            config.set(PTY_CODE_VALUE, getCodeValue());
         }
         if(RString.isNotEmpty(getIsProperty())){
            config.set(PTY_IS_PROPERTY, getIsProperty());
         }
         if(RString.isNotEmpty(getPropertyGroup())){
            config.set(PTY_PROPERTY_GROUP, getPropertyGroup());
         }
      }else if(EXmlConfig.Value == type){
         String sName = getName();
         if(RString.isNotEmpty(sName)){
            config.set(PTY_NAME, sName);
         }
         String sLabel = getLabel();
         if(RString.isNotEmpty(sLabel)){
            config.set(PTY_LABEL, sLabel);
         }
         Boolean bIsValid = getIsValid();
         if(RBoolean.parse(bIsValid)){
            config.set(PTY_IS_VALID, RBoolean.toString(bIsValid));
         }
         String sNote = getNote();
         if(RString.isNotEmpty(sNote)){
            config.set(PTY_NOTE, sNote);
         }
         String sCode = getCode();
         if(RString.isNotEmpty(sCode)){
            config.set(PTY_CODE, sCode);
         }
         String sIsClass = getIsClass();
         if(RString.isNotEmpty(sIsClass)){
            config.set(PTY_IS_CLASS, sIsClass);
         }
         String sIsFinal = getIsFinal();
         if(RString.isNotEmpty(sIsFinal)){
            config.set(PTY_IS_FINAL, sIsFinal);
         }
         String sSourceName = getSourceName();
         if(RString.isNotEmpty(sSourceName)){
            config.set(PTY_SOURCE_NAME, sSourceName);
         }
         String sParentName = getParentName();
         if(RString.isNotEmpty(sParentName)){
            config.set(PTY_PARENT_NAME, sParentName);
         }
         String sParentFinal = getParentFinal();
         if(RString.isNotEmpty(sParentFinal)){
            config.set(PTY_PARENT_FINAL, sParentFinal);
         }
         String sEntityType = getEntityType();
         if(RString.isNotEmpty(sEntityType)){
            config.set(PTY_ENTITY_TYPE, sEntityType);
         }
         String sSourceType = getSourceType();
         if(RString.isNotEmpty(sSourceType)){
            config.set(PTY_SOURCE_TYPE, sSourceType);
         }
         String sTargetType = getTargetType();
         if(RString.isNotEmpty(sTargetType)){
            config.set(PTY_TARGET_TYPE, sTargetType);
         }
         String sCodeValue = getCodeValue();
         if(RString.isNotEmpty(sCodeValue)){
            config.set(PTY_CODE_VALUE, sCodeValue);
         }
         String sIsProperty = getIsProperty();
         if(RString.isNotEmpty(sIsProperty)){
            config.set(PTY_IS_PROPERTY, sIsProperty);
         }
         String sPropertyGroup = getPropertyGroup();
         if(RString.isNotEmpty(sPropertyGroup)){
            config.set(PTY_PROPERTY_GROUP, sPropertyGroup);
         }
      }else if(EXmlConfig.Default == type){
         String sCode = getCode();
         if(RString.isNotEmpty(sCode)){
            config.set(PTY_CODE, sCode);
         }
         String sIsClass = getIsClass();
         if(RString.isNotEmpty(sIsClass)){
            config.set(PTY_IS_CLASS, sIsClass);
         }
         String sIsFinal = getIsFinal();
         if(RString.isNotEmpty(sIsFinal)){
            config.set(PTY_IS_FINAL, sIsFinal);
         }
         String sSourceName = getSourceName();
         if(RString.isNotEmpty(sSourceName)){
            config.set(PTY_SOURCE_NAME, sSourceName);
         }
         String sParentName = getParentName();
         if(RString.isNotEmpty(sParentName)){
            config.set(PTY_PARENT_NAME, sParentName);
         }
         String sParentFinal = getParentFinal();
         if(RString.isNotEmpty(sParentFinal)){
            config.set(PTY_PARENT_FINAL, sParentFinal);
         }
         String sEntityType = getEntityType();
         if(RString.isNotEmpty(sEntityType)){
            config.set(PTY_ENTITY_TYPE, sEntityType);
         }
         String sSourceType = getSourceType();
         if(RString.isNotEmpty(sSourceType)){
            config.set(PTY_SOURCE_TYPE, sSourceType);
         }
         String sTargetType = getTargetType();
         if(RString.isNotEmpty(sTargetType)){
            config.set(PTY_TARGET_TYPE, sTargetType);
         }
         String sCodeValue = getCodeValue();
         if(RString.isNotEmpty(sCodeValue)){
            config.set(PTY_CODE_VALUE, sCodeValue);
         }
         String sIsProperty = getIsProperty();
         if(RString.isNotEmpty(sIsProperty)){
            config.set(PTY_IS_PROPERTY, sIsProperty);
         }
         String sPropertyGroup = getPropertyGroup();
         if(RString.isNotEmpty(sPropertyGroup)){
            config.set(PTY_PROPERTY_GROUP, sPropertyGroup);
         }
      }
   }
}