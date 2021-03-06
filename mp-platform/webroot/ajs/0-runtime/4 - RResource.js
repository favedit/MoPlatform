// ============================================================
// RResFace
// ============================================================
var RResource = new function(o){
   if(!o){o=this};
   // Attribute
   o.uriIcon     = '/ars/icon/';
   o.uriImage    = '/ars/img/';
   // Method
   o.iconPath    = RResource_iconPath;
   o.iconUrlPath = RResource_iconUrlPath;
   o.imagePath   = RResource_imagePath;
   // Construct
   RMemory.register('RResource', o);
   return o;
}
var RRes = RResource;
// ------------------------------------------------------------
function RResource_iconPath(path, type){
   var o = this;
   var rc = top.RContext;
   path = RString.nvl(path, 'n').replace(/\./g, '/') + '.' + RString.nvl(type, 'gif');
   if(RString.startsWith(path, '#')){
      path = path.substr(1);
      return rc.context(rc.uriIcon + '/' + path);
   }
   return rc.context('/ars/icon/' + path);
}
// ------------------------------------------------------------
// #sys.icon = root + 
// sys.icon  = 
function RResource_iconUrlPath(path, type){
   var o = this;
   var rc = top.RContext;
   path = RString.nvl(path, 'n').replace(/\./g, '/') + '.' + RString.nvl(type, 'gif');
   if(RString.startsWith(path, '#')){
      path = path.substr(1);
      return 'url(' + rc.context(rc.uriIcon + '/' + path) + ')';
   }
   return 'url(' + rc.context('/ars/icon/' + path) + ')';
}
// ------------------------------------------------------------
// #sys.icon = root + 
// sys.icon  = 
function RResource_imagePath(path, type){
   var o = this;
   var rc = top.RContext;
   path = RString.nvl(path, 'n').replace(/\./g, '/') + '.' + RString.nvl(type, 'gif');
   if(RString.startsWith(path, '#')){
      path = path.substr(1);
      return rc.context(rc.uriImage + '/' + path);
   }
   return rc.context('/ars/img/' + path);
}
// ------------------------------------------------------------
