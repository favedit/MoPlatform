﻿//==========================================================
// <T>监听器集合管理的工具类。</T>
//
// @tool
// @author maocy
// @version 1.0.1
//==========================================================
function TListeners(){
   var o = this;
   // Attribute
   o.listeners = null;
   // Method
   o.isEmpty   = TListeners_isEmpty;
   o.register  = TListeners_register;
   o.push      = TListeners_push;
   o.process   = TListeners_process;
   o.clear     = TListeners_clear;
   o.dump      = TListeners_dump;
   return o;
}

function TListeners_isEmpty(){
   var ls = this.listeners;
   return ls ? ls.count > 0 : false;
}

//==========================================================
// <T>注册一个监听对象到当前管理器内。</T>
//
// @method
// @param w:owner:Object 处理对象
// @param p:process:Function 处理函数
// @return TListener 监听器
//==========================================================
function TListeners_register(w, p){
   var l = new TListener(w, p);
   this.push(l);
   return l;
}

//==========================================================
// <T>添加一个监听器对象到当前管理器内。</T>
//
// @method
// @param l:listener:TListener 监听器对象
//==========================================================
function TListeners_push(l){
   var o = this;
   // 检查监听器有效性
   if(!l){
      return RMessage.fatal(o, null, 'Listener is null.');
   }
   if(!l.callback){
      return RMessage.fatal(o, null, 'Listener process is null.');
   }
   // 增加监听器
   if(!o.listeners){
      o.listeners = new TList();
   }
   o.listeners.push(l);
}

//==========================================================
// <T>向所有监视器发出调用处理。</T>
//
// @method
// @param s:sender:发出对象
// @param p1:parameter1:Object 参数1
// @param p2:parameter2:Object 参数2
// @param p3:parameter3:Object 参数3
// @param p4:parameter4:Object 参数4
// @param p5:parameter5:Object 参数5
//==========================================================
function TListeners_process(s, p1, p2, p3, p4, p5){
   var ls = this.listeners;
   if(ls){
      var c = ls.count;
      for(var n=0; n<c; n++){
         ls.get(n).process(s, p1, p2, p3, p4, p5);
      }
   }
}

function TListeners_clear(){
   var o = this;
   if(o.listeners){
      o.listeners.clear();
   }
}

//==========================================================
// <T>获得监听器集合管理器的内部信息。</T>
//
// @method
// @return String 内部信息
//==========================================================
function TListeners_dump(d){
   var o = this;
   d = RString.nvlStr(d);
   d.append(RClass.name(o));
   var ls = o.listeners;
   var c = ls.length;
   for(var n=0; n<c; n++){
      d.append('\n   ' + ls[n].dump());
   }
   return d;
}
