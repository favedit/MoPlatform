﻿//==========================================================
// <T>加载函数监听的工具类。</T>
//
// @tool
// @author maocy
// @version 1.0.1
//==========================================================
function TLoaderListener(){
   var o = this;
   // Attribute
   o.invoke = null;
   o.ids    = new TArray();
   // Method
   o.check  = TLoaderListener_check;
   return o;
}

//==========================================================
// <T>从已加载的列表中，检查自己需要的标识是否已经全部加载。</T>
//
// @method
// @param loaded:TArray 已加载列表
// @return Boolean
//   <L value='true'>全部加载</L>
//   <L value='false'>未全部加载</L>
//==========================================================
function TLoaderListener_check(l){
   var s = this.ids;
   if(!s.isEmpty()){
      var c = s.length;
      for(var n=0; n<c; n++){
         if(!l.contains(s.get(n))){
            return false;
         }
      }
   }
   return true;
}
