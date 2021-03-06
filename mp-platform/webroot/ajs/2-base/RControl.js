//===========================================================
// 控件的管理创建类
//
// @reference
// @author maochunyang
// @version 1.0.1
//===========================================================
var RControl = new function(o){
   if(!o){o=this;}
   // Attribute
   o.inMoving           = false;
   o.inSizing           = false;
   o.inDesign           = false;
   /// @attribute TList 存放所有的控件
   o.instances          = new TList();
   o.events             = new TMap();
   o.controls           = new TMap();
   // Member
   o.innerbuild         = RControl_innerbuild;
   o.build              = RControl_build;
   o.innerCreate        = RControl_innerCreate;
   o.create             = RControl_create;
   o.linkEvent          = RControl_linkEvent;
   o.attachEvent        = RControl_attachEvent;
   o.find               = RControl_find;
   o.fromNode           = RControl_fromNode;
   o.fromXml            = RControl_fromXml;
   o.toNode             = RControl_toNode;
   o.toXml              = RControl_toXml;
   o.store              = RControl_store;
   o.htmlControl        = RControl_htmlControl;
   o.psDesign           = RControl_psDesign;
   o.psMode             = RControl_psMode;
   o.isInfo             = RControl_isInfo;
   o.isGroup            = RControl_isGroup;
   o.newInstance        = RControl_newInstance;
   o.newInstanceByName  = RControl_newInstance;
   // Construct
   RMemory.register('RControl', o);
   return o;
}
// ------------------------------------------------------------
function RControl_innerbuild(ctl, cfg){
   if(ctl){
      var rs = ctl.loadConfig(cfg);
      ctl.construct();
      // Build child
      if(cfg.nodes){
         var child = true;
         if(rs && EStatus.Stop == rs){
            child = false;
         }
         if(child){
            var nodes = cfg.nodes;
            for(var n=0; n<nodes.count; n++){
               var node = nodes.get(n);
               var obj = ctl.createChild(node);
               if(obj){
                  this.innerbuild(obj, node);
                  ctl.push(obj);
               }
            }
         }
      }
   }
}

//===========================================================
// 表格列表类，
//
// @method
// @param ctl:control:FControl 控件对象
// @version 1.0.1
//===========================================================
function RControl_build(ctl, cfg){
   this.innerbuild(ctl, cfg);
   ctl.initialize();
   ctl.build();
}

//===========================================================
// <T>根据XML配置信息创建当前组件，并递归创建所有子节点。</T>
//
// @method
// @param p:parent:FComponent 父组件
// @param x:config:TNode 控件的配置信息
// @param m:mode:EMode 工作模式
// @return Object 控件对象
//===========================================================
function RControl_innerCreate(p, x, m){
   p._emode = m;
   if(RClass.isClass(p, MConfig)){
      if(EStatus.Stop == p.loadConfig(x)){
         return;
      }
   }
   // Build child
   var ns = x.nodes;
   if(ns){
      for(var i=0; i<ns.count; i++){
         var n = ns.get(i);
         var c = p.createChild(n);
         if(c){
            c.parent = p;
            this.innerCreate(c, n, m);
            p.push(c);
         }
      }
   }
}

//===========================================================
// 通过TNode节点来生成对应的控件
// 控件构造顺序：
// <OL>
// <L title='Construct'>单个实例的类构造</L>
// <L title='Initialize'>当前对象和所有子对象进行初始化</L>
// <L title='Build'>当前控件和所有子控件进行建立可视化框架</L>
// <L title='setPanel'>将当前控件放在地板上，成为可见控件</L>
// </OL>
//
// @method
// @param x:config:TNode TNode类型的节点
// @param hPanel:hPanel:HTML 生成控件后要放置的位置HTML
// @param m:mode:EMode 工作模式
// @return Object 控件对象
//===========================================================
function RControl_create(x, hPanel, m){
   var o = null;
   if(RClass.isClass(x, TNode)){
      if(x){
         // 节点对象(TNode)的处理
         if(x.name == 'CellEdit'){
            RControl.newInstance(FCellEdit);
         }else{
             o = RClass.createByName('F' + x.name);
             this.innerCreate(o, x, m);
         }
         o._emode = m;
         this.instances.push(o);
      }
   }else{
      // 类对象(Class)的处理
      o = RClass.create(x);
      o._emode = m;
   }
   // 实例存在的处理
   if(o){
      // 初始化
      if(x.name != 'CellEdit'){
         o.psInitialize();
         // 构建对象
         o.psBuild();
         // 设置父容器对象
         o.setPanel(hPanel);
      }
   }
   return o;
}
// ------------------------------------------------------------
// tc:targetControl:FControl
// sc:senderControl:FControl
// n:name:String 注册过的事件名称
// h:html:HTML 注册过的事件名称
// m:method:Function 即时处理函数
function RControl_linkEvent(tc, sc, n, h, m){
   var o = this;
   var p = tc[n];
   if(!RMethod.isEmpty(p) || m){
      // 获得注册过的事件对象
      var a = RClass.find(tc.constructor).annotation(EAnnotation.Event, n);
      // 复制当前注册事件
      var e = new a.constructor();
      e.name = a.name;
      e.source = tc;
      e.sender = sc;
      e.hSource = h;
      // 设置立即回调事件
      e.ohProcess = m;
      // 设置队列回调事件
      e.onProcess = p;
      e.process = REvent.onProcess;
      // 存储事件
      REvent.find(h).push(e.type, e);
      // 关联事件处理到HTML元素上
      h[e.handle] = REvent.ohEvent;
      RHtml.link(h, '_plink', tc);
      return e;
   }
}
// ------------------------------------------------------------
function RControl_attachEvent(c, n, h, m){
   var o = this;
   var p = c[n];
   if(!RMethod.isEmpty(p) || m){
      // 获得注册过的事件对象
      var a = RClass.find(c.constructor).annotation(EAnnotation.Event, n);
      // 复制当前注册事件
      var e = new a.constructor();
      e.name = a.name;
      e.source = c;
      e.hSource = h;
      // 设置立即回调事件
      e.ohProcess = m;
      // 设置队列回调事件
      e.onProcess = p;
      e.process = REvent.onProcess;
      // 存储事件
      REvent.find(h).push(e.type, e);
      // 关联事件处理到HTML元素上
      h[e.handle] = REvent.ohEvent;
      RHtml.link(h, '_plink', c);
      return e;
   }
}
// ------------------------------------------------------------
function RControl_find(c){
   var o = this;
   var r = null;
   if(c){
      if(c.constructor == Function){
         c = RMethod.name(c);
      }else if(c.constructor != String){
         RMsg.fatal(o, null, 'Param invlid (class={0})', c);
      }
      var cs = o.controls;
      var r = cs.get(c);
      if(!r){
         r = new TControl(c);
         cs.set(c, r);
      }
   }
   return r;
}

//===========================================================
// 通过加载XML TNode节点来生成对应的控件
//
// @method
// @param config:config:TNode  从页面中的XML解析而成的TNode类型的节点
// @param hPanel:hPanel:HTML   生成控件后要放置的位置
// @return Object 控件对象
//===========================================================
function RControl_fromNode(x, h){
   if(x){
      return this.create(x, h);
   }
}

//===========================================================
// <T>从页面中加载XML生成对象。</T>
//
// @method
// @param xml:xml:XML  从页面中的XML
// @param hPanel:hPanel:HTML   生成控件后要放置的位置
// @return Object 控件对象
//===========================================================
function RControl_fromXml(xml, hPanel, mode){
   var c = null;
   var x = RXml.makeNode(xml);
   if(x){
      c = this.create(x, hPanel, mode);
   }
   return c;
}

//===========================================================
// <T>获得控件的配置节点。</T>
//
// @method
// @return TNode 配置节点
//===========================================================
function RControl_toNode(){
}

//===========================================================
// <T>获得控件的配置字符串。</T>
//
// @method
// @return String 配置字符串
//===========================================================
function RControl_toXml(){
}

//===========================================================
// 表格列表类，
//
// @refencene
// @author maochunyang
// @version 1.0.1
//===========================================================
function RControl_store(o, type){
   var x = new TNode();
   x.name = RClass.name(o).substr(1);
   if(RClass.isClass(o, FContainer)){
      o.storeConfig(x);
   }else{
      o.saveConfig(x);
   }
   return x;
}

//===========================================================
// 表格列表类，
//
// @refencene
// @author maochunyang
// @version 1.0.1
//===========================================================
// element, class
function RControl_htmlControl(e, c){
   if(c){
      while(e){
         var o = RHtml.findLink(e, 'control');
         if(o && RClass.isClass(o, c)){
            return o;
         }
         e = e.parentElement;
      }
   }else{
      while(e){
         var o = RHtml.findLink(e, 'control');
         if(o){
            return o;
         }
         e = e.parentElement;
      }
   }
   return null;
}

//===========================================================
// 表格列表类，
//
// @refencene
// @author maochunyang
// @version 1.0.1
//===========================================================
// action
function RControl_psDesign(action, mode, flag, params){
   var cs = this.instances;
   if(cs && cs.count){
      var l = cs.count;
      for(var n=0; n<l; n++){
         cs.get(n).psDesign(action, mode, flag, params);
      }
   }
}
// ------------------------------------------------------------
function RControl_psMode(action, mode, flag, params){
   var cs = this.instances;
   if(cs && cs.count){
      var l = cs.count;
      for(var n=0; n<l; n++){
         cs.get(n).psMode(action, mode, flag, params);
      }
   }
}

// ------------------------------------------------------------
function RControl_isInfo(v){
   return v ? (0 == v.indexOf('C#')) : false;
}

//------------------------------------------------------------
function RControl_isGroup(v){
   return v ? (0 == v.indexOf('G#')) : false;
}

//------------------------------------------------------------
function RControl_newInstance(f){
   var o = this;
   if(o.controls){
     var n = RMethod.name(f);
      var c = o.controls.get(n);
      if(!c){
         var c = new TControl(n);
         o.controls.set(n, c);
      }
   }
   return c.newInstance(n);
}

// ------------------------------------------------------------
function RControl_newInstanceByName(n){
   return;
}