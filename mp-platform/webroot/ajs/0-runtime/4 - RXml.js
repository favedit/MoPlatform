﻿//==========================================================
// <T>配置工具类。</T>
//
// @reference
// @author maochunyang
// @version 1.0.1
//==========================================================
var RXml = new function(){
   var o = this;
   // Attribute
   o.httpActiveX  = false;
   o.httpVendor   = null;
   o.domActiveX   = false;
   o.domVendor    = null;
   // Member
   o.construct    = RXml_construct;
   o.isNode       = RXml_isNode;
   o.newConnect   = RXml_newConnect;
   o.newDocument  = RXml_newDocument;
   o.loadString   = RXml_loadString;
   o.makeNode     = RXml_makeNode;
   o.makeDocument = RXml_makeDocument;
   o.buildNode    = RXml_buildNode;
   o.fromText     = RXml_fromText;
   o.buildText    = RXml_buildText;
   o.unpack       = RXml_unpack;
   // Construct
   o.construct();
   // Register
   RMemory.register('RXml', o);
   return o;
}

//===========================================================
// <T>构造配置工具类。</T>
//
// @method
//===========================================================
function RXml_construct(){
   var o = this;
   var d = window.document;
   //...........................................................
   // 获得请求方式
   if(window.ActiveXObject && !window.XMLHttpRequest){
      var vs = ["MSXml2.XmlHTTP", "Microsoft.XmlHTTP", "MSXml.XmlHTTP", "MSXml3.XmlHTTP"];
      var c = vs.length;
      for(var n = 0; n < c; n++){
         var v = vs[n];
         try{
            r = new ActiveXObject(v);
            o.httpActiveX = true;
            o.httpVendor = v;
            break;
         }catch(e){
            m = e;
         }
      }
   }else if(window.XMLHttpRequest){
      try{
         var r = new XMLHttpRequest();
         o.httpActiveX = false;
      }catch(e){
         m = e;
      }
   }else{
      alert('Unknown http vendor.');
   }
   //...........................................................
   // 获得文档方式
   if(window.ActiveXObject || !window.DOMParser){
      var vs = ["MSXml2.DOMDocument", "Microsoft.XmlDOM", "MSXml.DOMDocument", "MSXml3.XmlDOM"];
      var c = vs.length;
      for(var n = 0; n < c; n++){
         var v = vs[n];
         try{
            var r = new ActiveXObject(v);
            o.domActiveX = true;
            o.domVendor = v;
            break;
         }catch(e){
            m = e;
         }
      }
   }else if(window.DOMParser && d && d.implementation && d.implementation.createDocument){
      try{
         var r = document.implementation.createDocument('', '', null);
         o.domActiveX = false;
      }catch(e){
         m = e;
      }
   }else{
      alert('Unknown dom vendor.');
   }
}

//===========================================================
// 判断是否是一个节点(TNode)类型
//
// @method
// @param n:Node:TNode 节点对象
// @return Boolean 返回Boolean类型
//===========================================================
function RXml_isNode(n){
   return RClass.isName(n, 'TNode');
}

//===========================================================
// <T>创建一个配置链接。</T>
//
// @method
// @return 配置链接
//===========================================================
function RXml_newConnect(){
   var o = this;
   var r = null;
   if(o.httpActiveX){
      r = new ActiveXObject(o.httpVendor);
   }else{
      r = new XMLHttpRequest();
   }
   // Error
   if(!r){
      alert('Create xml connection failure. (message=' + m + ')');
   }
   return r;
}

//===========================================================
// <T>创建一个配置文档。</T>
//
// @method
// @return 配置链接
//===========================================================
function RXml_newDocument(){
   var o = this;
   var r = null;
   if(o.domActiveX){
      r = new ActiveXObject(o.domVendor);
   }else{
      r = document.implementation.createDocument('', '', null);
   }
   // Error
   if(!r){
      alert('Create xml document failure. (message=' + m + ')');
   }
   return r;
}

//===========================================================
// <T>加载一个配置字符串。</T>
//
// @method
// @param n:Node:TNode 节点对象
// @return Boolean 返回Boolean类型
//===========================================================
function RXml_loadString(s){
   var o = this;
   var x = null;
   // 判断浏览器的类型
   if(o.domActiveX){
      x = new ActiveXObject(o.domVendor);
      x.async = false;
      x.loadXML(s);
   }else{
      var p = new DOMParser();
      x = p.parseFromString(s, 'text/xml');
   }
   return x;
}

//===========================================================
// 根据页面中的XML来创建js内的XML树,返回树的根节点
//
// @method
// @param p:document 嵌在页面中的XML
// @see RXml.buildNode
// @return TNode 创建后的目录树的根元素
//===========================================================
function RXml_makeNode(p){
   var o = this;
   if(p.documentElement){
      var d = new TXmlDocument();
      o.buildNode(d, null, p.documentElement);
      return d.node;
   }else if(p.tagName == 'SCRIPT'){
      var s = p.textContent;
      if(!s){
         s = p.text;
      }
      if(s){
         var d = new TXmlDocument();
         var xd = o.loadString(s)
         o.buildNode(d, null, xd.documentElement);
         return d.node;
      }
   }
   return null;
}

//===========================================================
// 根据页面中的XML来创建js内的XML结构，
//
// @method
// @param xdoc:xdoc:document 嵌在页面中的XML
// @see RXml.buildNode
// @return doc XML文件结构
//===========================================================
function RXml_makeDocument(xdoc){
   var doc = new TXmlDocument();
   if(xdoc.documentElement){
      RXml.buildNode(doc, null, xdoc.documentElement);
   }
   return doc;
}

//===========================================================
// 遍历构建XML节点树
//
// @method
// @param doc:TXmlDoc:TXmlDoc JS系统中的XML文件
// @param node:TNode:TNode 父节点
// @param element:element:XML 页面中的XML
// @see RXml.fromText
// @see TXmlDoc.create
//===========================================================
function RXml_buildNode(doc, node, element){
   // Build attributes
   var attrs = null;
   if(element.attributes){
      var len = element.attributes.length;
      if(len > 0){
         attrs = new TMap();
         for(var n = 0; n < len; n++){
            var attr = element.attributes[n];
            if(attr.nodeName){
               attrs.set(attr.nodeName, RXml.fromText(attr.value));
            }
         }
      }
   }
   // Build text
   var text = new TString();
   text.append(element.value);
   var childs = element.childNodes
   if(childs){
      for(var n=0; n<childs.length; n++){
         if(childs[n].nodeType == ENodeType.Text){
            text.append(childs[n].nodeValue);
         }
      }
   }
   // Create node
   var child = doc.create(element.nodeName, attrs, text);
   if(node){
      node.push(child);
   }else{
      doc.node = child;
   }
   // Build child nodes
   if(childs){
      for(var n=0; n<childs.length; n++){
         if(childs[n].nodeType == ENodeType.Node){
            this.buildNode(doc, child, childs[n]);
         }
      }
   }
}

//===========================================================
// 替换所有的换行符
//
// @method
// @param s:string:String XML文本
// @return String  替换后的字符串
//===========================================================
function RXml_fromText(s){
   return (null != s) ? s.replace(/\\n/g, '\n') : s;
}

//===========================================================
// 替换字符串中的转义字符
//
// @method
// @param s:string:String JS系统中的XML文件
// @param v:value:String 父节点
// @return String  替换后的字符串
//
// string, value
//===========================================================
function RXml_buildText(s, v){
   if(null != v){
      v = v.toString();
      for(var n=0; n<v.length; n++){
         var ch = v.charAt(n);
         switch(ch){
            case '<':
               s.append('&lt;');
               break;
            case '>':
               s.append('&gt;');
               break;
            case '"':
               s.append('&quot;');
               break;
            case '&':
               s.append('&amp;');
               break;
            case '\r':
               continue;
            case '\n':
               s.append('\\n');
               break;
            default:
               s.append(ch);
         }
      }
   }
   return s;
}

//===========================================================
// <T>解包节点字符串。</T>
//
// @method
// @param s:string:String 打包字符串
// @return TNode 节点对象
//===========================================================
function RXml_unpack(s, n){
   var o = this;
   if(RString.isEmpty(s)){
      return null;
   }
   if(!n){
      n = new TNode();
   }
   var np = new TAttributes();
   np.unpack(s);
   n.name = np.get('name');
   n.value = np.get('value');
   if(np.contains('attributes')){
      n.attributes().unpack(np.get('attributes'));
   }
   if(np.contains('nodes')){
      var ns = new TStrings();
      ns.unpack(np.get('nodes'));
      for(var i=0; i<ns.count; i++){
         o.unpack(ns.get(i), n.create());
      }
   }
   return n;
}

