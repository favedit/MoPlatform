//==========================================================
// 边框的样式
//
// @enum
// @history 091105 创建
//==========================================================
function EBorderStyleFace(){
   var o = this;
   //..........................................................
   // @member
   o.Readonly = 1;
   o.Edit     = 2;
   o.Hover    = 3;
   return o;
}
//==========================================================
var EBorderStyle = new EBorderStyleFace();
