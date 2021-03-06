/*******************************************************************************
 * <T>按键导向页面操作的控制台。</T>
 * 
 * @tool
 * @author maocy
 * @version 1.0.1
 ******************************************************************************/
function FButtonFormConsole(o) {
   o = RClass.inherits(this, o, FConsole);
   // Attribute
   o.scope = EScope.Global;
   o.window = null;
   // Method
   o.find = FButtonFormConsole_find;
   return o;
}
RConsole.register(new TConsole(EScope.Page, FKeyConsole, true));
// ------------------------------------------------------------
function FButtonFormConsole_find() {
   var o = this;
   if (!o.window) {
      o.window = top.RControl.create('FButtonFormWindow');
   }
   return o.window;
}
