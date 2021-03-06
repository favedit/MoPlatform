﻿//============================================================
// XML发送接收工具类
//
// @tool
// @author maochunyang
// @version 1.0.1
//============================================================
function TRange(x, y, w, h){
   var o = this;
   // Attribute
   o.x         = x;
   o.y         = y;
   o.width     = w;
   o.height    = h;
   // Method
   o.dump      = TRange_dump;
   return o;
}

function TRange_reset(){
   var o = this;
   o.left = 0;
   o.top = 0;
   o.right = 0;
   o.bottom = 0;
}

//============================================================
// 指定矩形坐标类
//
// @method
// @param rect:rectangle:rectangle 矩形对象
//============================================================
function TRange_assign(rect){
   this.left = rect.left;
   this.top = rect.top;
   this.right = rect.right;
   this.bottom = rect.bottom;
}

//============================================================
// 指定当前矩形的四个坐标
//
// @method
//============================================================
function TRange_set(left, top, right, bottom){
   this.left = left;
   this.top = top;
   this.right = right;
   this.bottom = bottom;
}
//============================================================
// 设定边框的位置
//
// @method
//============================================================
function TRange_setBounds(left, top, width, height){
   var o = this;
   o.left = left;
   o.top = top;
   o.right = o.left + width - 1;
   o.bottom = o.top + height - 1;
}

//============================================================
// 取得宽度
//
// @method
//============================================================
function TRange_width(){
   return this.right - this.left + 1;
}

//============================================================
// 设定矩形宽度
//
// @method
// @param width:width:Integer 设置的宽度
//============================================================
function TRange_setWidth(width){
   if(width){
      this.right = this.left + width - 1;
   }
}

//============================================================
// 得到矩形的高度
//
// @method
//============================================================
function TRange_height(){
   return this.bottom - this.top + 1;
}

//============================================================
// 设定矩形的高度
//
// @method
//============================================================
function TRange_setHeight(height){
   if(height){
      this.bottom = this.top + height - 1;
   }
}

//============================================================
// 把矩形移动到某个位置
//
// @method
// @param x:xPosition:Integ
//============================================================
function TRange_move(x, y){
   this.left += x;
   this.top += y;
   this.right += x;
   this.bottom += y;
}

//============================================================
// 放大指定的大小
//
// @method
//============================================================
function TRange_inc(border){
   var n = RInt.nvl(border, 1);
   this.left -= n;
   this.top -= n;
   this.right += n;
   this.bottom += n;
}

//============================================================
// 把矩形缩小指定的宽度和高度
//
// @method
//============================================================
function TRange_dec(border){
   var n = RInt.nvl(border, 1);
   this.left += n;
   this.top += n;
   this.right -= n;
   this.bottom -= n;
}
//============================================================
// <T>获得调试信息。</T>
//
// @method
//============================================================
function TRange_dump(d){
   var o = this;
   d = RString.nvlStr(d);
   d.append(RClass.name(o));
   d.append(' [', o.x, ',', o.y, '-', o.width, ',', o.height, '] ');
   return d;
}
