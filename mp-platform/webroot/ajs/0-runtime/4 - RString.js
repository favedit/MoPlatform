﻿//==========================================================
// <T>各种字符串处理的工具类。</T>
//
// @tool
// @author maocy
// @version 1.0.1
//==========================================================
var RString = new function(){
   var o = this;
   // Attribute
   o.EMPTY        = '';
   o.SPACE        = '   ';
   o.PAD          = ' ';
   o.TRIM         = ' \t\r\n';
   o.LOWER        = 'abcdefghijklmnopqrstuvwxyz';
   o.UPPER        = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
   o.CodeLowerA   = 'a'.charCodeAt(0);
   o.CodeLowerZ   = 'z'.charCodeAt(0);
   o.CodeUpperA   = 'A'.charCodeAt(0);
   o.CodeUpperZ   = 'Z'.charCodeAt(0);
   // Method
   o.isEmpty      = RString_isEmpty;
   o.isBlank      = RString_isBlank;
   o.isAnsi       = RString_isAnsi;
   o.isDbcs       = RString_isDbcs;
   o.isPattern    = RString_isPattern;
   o.inChars      = RString_inChars;
   o.contains     = RString_contains;
   o.equals       = RString_equals;
   o.startsWith   = RString_startsWith;
   o.endsWith     = RString_endsWith;
   o.findChars    = RString_findChars;
   o.inRange      = RString_inRange;
   o.nvl          = RString_nvl;
   o.nvlStr       = RString_nvlStr;
   o.firstUpper   = RString_firstUpper;
   o.firstLower   = RString_firstLower;
   o.firstLine    = RString_firstLine;
   o.format       = RString_format;
   o.repeat       = RString_repeat;
   o.pad          = RString_pad;
   o.lpad         = RString_lpad;
   o.rpad         = RString_rpad;
   o.trim         = RString_trim;
   o.ltrim        = RString_ltrim;
   o.rtrim        = RString_rtrim;
   o.mid          = RString_mid;
   o.toLine       = RString_toLine;
   o.toLower      = RString_toLower;
   o.toUpper      = RString_toUpper;
   o.split        = RString_split;
   o.splitTwo     = RString_splitTwo;
   o.splitParts   = RString_splitParts;
   o.splitPattern = RString_splitPattern;
   o.remove       = RString_remove;
   o.removeChars  = RString_removeChars;
   // Construct
   RMemory.register('RString', o);
   return o;
}

//==========================================================
// <T>判断字符串是否为空。</T>
//
// @method
// @param v:value:String 字符串
// @return Boolean
//    <L value='true'>为空</L>
//    <L value='false'>非空</L>
//==========================================================
function RString_isEmpty(v){
   return (null == v) ? true : !(v.length);
}

//==========================================================
// <T>判断字符串不包含开始和结尾的空格，是否为空。</T>
//
// @method
// @param v:value:String 字符串
// @return Boolean
//    <L value='true'>为空</L>
//   <L value='false'>非空</L>
//==========================================================
function RString_isBlank(v){
   return (null == v) ? true : !(v.trim().length);
}

//==========================================================
// <T>判断字符串是否为ANSI编码。</T>
// <P>字符串内每一个字符编码在256之下，为ANSI编码的判断标准。</P>
//
// @method
// @param v:value:String 字符串
// @return Boolean
//    <L value='true'>是</L>
//    <L value='false'>否</L>
//==========================================================
function RString_isAnsi(v){
   if(null != v){
      var c = v.length;
      for(var n=0; n<c; n++){
         if(v.charCodeAt(n) > 255){
            return false;
         }
      }
      return true;
   }
   return false;
}

//==========================================================
// <T>判断字符串是否为DBCS编码。</T>
// <P>字符串内每一个字符编码在255之上，为DBCS编码的判断标准。</P>
//
// @method
// @param v:value:String 字符串
// @return Boolean
//    <L value='true'>是</L>
//    <L value='false'>否</L>
//==========================================================
function RString_isDbcs(v){
   if(null == v){
      var c = v.length;
      for(var n=0; n<c; n++){
         if(value.charCodeAt(n) < 256){
            return false;
         }
      }
      return true;
   }
   return false;
}

//==========================================================
// <T>判断字符串是否和指定模板相匹配。</T>
// <P>特定字符表示一个范围内容
//    <L value='$a'>所有小写字符(abcdefghijklmnopqrstuvwxyz)</L>
//    <L value='$A'>所有大写字符(ABCDEFGHIJKLMNOPQRSTUVWXYZ)</L>
//    <L value='$i'>所有整数字符(0123456789)</L>
//    <L value='$n'>所有整数字符(0123456789-)</L>
//    <L value='$f'>所有浮点数字符(0123456789-.)</L>
// </P>
//
// @method
// @param v:value:String 字符串
// @param p:parttern:String 模板字符串
// @return Boolean
//    <L value='true'>匹配</L>
//    <L value='false'>不匹配</L>
//==========================================================
function RString_isPattern(v, p){
   if(null != v){
      var o = this;
      // 展开模板内容
      if(null == p){
         p = '$a$A$f';
      }
      p = p.replace(/\a/g, o.LOWER);
      p = p.replace(/\A/g, o.UPPER);
      p = p.replace(/\f/g, RFloat.NUMBER);
      p = p.replace(/\n/g, RInt.NUMBER);
      // 检查匹配
      var c = v.length;
      for(var n=0; n<c; n++){
         if(-1 == p.indexOf(v.charAt(n))){
            return false;
         }
      }
      return true;
   }
   return false;
}

//==========================================================
// <T>判断字符串是否和指定模板相匹配。</T>
// <P>特定字符表示一个范围内容
//   <L value='$a'>所有小写字符(abcdefghijklmnopqrstuvwxyz)</L>
//    <L value='$A'>所有大写字符(ABCDEFGHIJKLMNOPQRSTUVWXYZ)</L>
//    <L value='$i'>所有整数字符(0123456789)</L>
//    <L value='$n'>所有整数字符(0123456789-)</L>
//    <L value='$f'>所有浮点数字符(0123456789-.)</L>
// </P>
//
// @method
// @param v:value:String 字符串
// @param p:parttern:String 模板字符串
// @return Boolean
//    <L value='true'>匹配</L>
//    <L value='false'>不匹配</L>
//==========================================================
function RString_inChars(v, p){
   var o = this;
   var b = o.findChars(p, v);
   if(-1 != b){
      return true;
   }
   return false;
}

//==========================================================
// <T>检查字符串内是否包含特定字符串。</T>
//
// @method
// @param v:value:String 字符串
// @param s:search:String 特定字符串
// @return Boolean
//    <L value='true'>包含</L>
//    <L value='false'>不包含</L>
//==========================================================
function RString_contains(v, s){
   return (null != v && null != s) ? (-1 != v.toString().indexOf(s)) : false;
}

//==========================================================
// <T>判断两个字符串是否相等。</T>
//
// @method
// @param s:source:String 源字符串
// @param t:target:String 目标字符串
// @param f:boolean:Boolean 是否忽略大小写(默认为忽略大小写)
// @return Boolean
//    <L value='true'>相等</L>
//==========================================================
function RString_equals(s, t, f){
   if(null == s || null == t){
      return false;
   }
   // 强制转换为字符串
   s += '';
   t += '';
   // 比较相同
   return f ? (s == t) : (s.toLowerCase()==t.toLowerCase());
}

//==========================================================
// <T>判断字符串是否以特定字符串开始。</T>
//
// @method
// @param v:value:String 字符串
// @param s:search:String 特定字符串
// @return Boolean
//    <L value='true'>是</L>
//    <L value='false'>否</L>
//==========================================================
function RString_startsWith(v, s){
   if(null == s){
      return true;
   }
   return (null != v) ? (0 == v.indexOf(s)) : false;
}

//==========================================================
// <T>判断字符串是否以特定字符串结束。</T>
//
// @method
// @param v:value:String 字符串
// @param s:search:String 特定字符串
// @return Boolean
//    <L value='true'>是</L>
//    <L value='false'>否</L>
//==========================================================
function RString_endsWith(v, s){
   if(null == s){
      return true;
   }
   var n = (null != v) ? v.indexOf(s) : -1;
   return (-1 != n) ? (n == (v.length - s.length)) : false;
}

//==========================================================
// <T>在字符串中查找指定字符列表。</T>
//
// @method
// @param v:value:String 字符串
// @param s:search:String 字符列表
// @return Integer 位置索引
//==========================================================
function RString_findChars(v, s){
   if(null != v && null != s){
      var c = v.length;
      for(var n=0; n<c; n++){
         if(-1 != s.indexOf(v.charAt(n))){
            return n;
         }
      }
   }
   return -1;
}

//==========================================================
// <T>判断指定字符串是否在一个字符串数组中含有。</T>
//
// @method
// @param v:value:String 源字符串
// @param rs:ranges:String[] 字符串数组
// @param f:boolean:Boolean 是否忽略大小写(默认为忽略大小写)
// @return Boolean
//    <L value='true'>含有</L>
//    <L value='false'>不含有</L>
//==========================================================
function RString_inRange(v, rs, f){
   if(v && rs){
      if(!f){
         v = v.toLowerCase();
      }
      var c = rs.length;
      for(var n=0; n<c; n++){
         var r = rs[n];
         if(null != r){
            if(f && (v == r)){
               return true;
            }else if(!f && (v == r.toLowerCase())){
               return true;
            }
         }
      }
   }
   return false;
}

//==========================================================
// <T>返回一个不为空的字符串。</T>
//
// @method
// @param v:value:String 字符串
// @param d:default:String 缺省字符串
// @return Boolean 非空字符串
//==========================================================
function RString_nvl(v, d){
   if('string' == typeof(v)){
      if(v.length > 0){
         return v;
      }
   }
   return (null != d) ? d : this.EMPTY;
}

//==========================================================
// <T>返回一个不为空的字符串对象。</T>
//
// @method
// @param v:value:String 字符串对象
// @return Boolean 非空字符串对象
//==========================================================
function RString_nvlStr(v){
   if(!v){
      v = new TString();
   }
   return v;
}

//==========================================================
// <T>将字符串的首字符变为大写。</T>
//
// @method
// @param v:value:String 字符串
// @return String 首字母是大写的字符串
//==========================================================
function RString_firstUpper(v){
   return (null != v) ? v.charAt(0).toUpperCase() + v.substr(1) : v;
}

//==========================================================
// <T>将字符串的首字符变为小写。</T>
//
// @method
// @param v:value:String 字符串
// @return String 首字母是小写的字符串
//==========================================================
function RString_firstLower(){
   return (null != v) ? v.charAt(0).toLowerCase() + v.substr(1) : v;
}

//==========================================================
// <T>获得字符串中第一行字符串。</T>
//
// @method
// @param v:value:String 字符串
// @return String 第一行字符串
//==========================================================
function RString_firstLine(v){
   if(v){
      var n = Math.min(v.indexOf('\r'), v.indexOf('\n'));
      if(-1 != n){
         return v.substr(0, n);
      }
      return v;
   }
   return '';
}

//==========================================================
// <T>格式化一个字符串内容，将参数中{x}内容替换为参数内容。</T>
//
// @method
// @param s:value:String 字符串
// @param p:parameters:Object... 参数字符
// @return String 格式化后的字符串
//==========================================================
function RString_format(s, p){
   var a = arguments;
   var c = a.length;
   for(var n=1; n<c; n++){
      var p = a[n];
      if('function' == typeof(p)){
         p = RMethod.name(p);
      }else if(null == p){
         p = '';
      }
      s = s.replace('{' + (n-1) + '}', p);
   }
   return s;
}

//==========================================================
// <T>获得重复指定次数的字符串。</T>
//
// @method
// @param v:value:String 字符串
// @param c:count:Integer 重复的次数
// @return String 重复后的字符串
//==========================================================
function RString_repeat(v, c){
   return new Array(c+1).join(v);
}

//==========================================================
// <T>通过追加空格使字符串对齐指定长度，字符串内容位于对齐后字符串的中间位置。</T>
//
// @method
// @param v:value:String 字符串
// @param l:length:Integer 对齐后长度
// @param p:pad:String 补齐字符(默认为空格字符)
// @return Boolean 补齐长度的字符串
//==========================================================
function RString_pad(v, l, p){
   v = (null != v) ? v.toString() : this.EMPTY;
   var n = l - v.length;
   if(n > 0){
      if(null == p){
         p = this.PAD;
      }
      var r = (n%2 == 0) ? n/2 : (n-1)/2;
      return new Array(r+1).join(p) + v + new Array(n-r+1).join(p);
   }
   return v;
}

//==========================================================
// <T>通过在左边追加空格使字符串对齐指定长度。</T>
//
// @method
// @param v:value:String 字符串
// @param l:length:Integer 对齐后长度
// @param p:pad:String 补齐字符(默认为空格字符)
// @return Boolean 补齐长度的字符串
//==========================================================
function RString_lpad(v, l, p){
   var o = this;
   v = (null != v) ? v.toString() : o.EMPTY;
   var n = l - v.length;
   if(n > 0){
      if(null == p){
         p = o.PAD;
      }
      var a = new Array(n);
      a[a.length] = v;
      return a.join(p);
   }
   return v;
}

//==========================================================
// <T>通过在右边追加空格使字符串对齐指定长度。</T>
//
// @method
// @param v:value:String 字符串
// @param l:length:Integer 对齐后长度
// @param p:pad:String 补齐字符(默认为空格字符)
// @return Boolean 补齐长度的字符串
//==========================================================
function RString_rpad(v, l, p){
   var o = this;
   v = (null != v) ? v.toString() : o.EMPTY;
   var n = l - v.length;
   if(n > 0){
      if(null == p){
         p = o.PAD;
      }
      return v + new Array(n + 1).join(p);
   }
   return v;
}

//==========================================================
// <T>去掉字符串开始和结尾的空格字符和非显示字符。</T>
//
// @method
// @param v:value:String 字符串对象
// @param ts:trims:String 要去除的字符串
// @return String 去掉开始和结尾的空格和非显示字符的字符串
//==========================================================
function RString_trim(v, ts){
   var o = this;
   v = o.nvl(v);
   ts = o.nvl(ts, o.TRIM);
   var l = 0;
   var r = v.length - 1;
   for(; l<r; l++){
      if(-1 == ts.indexOf(v.charAt(l))){
         break;
      }
   }
   for(; r>=l; r--){
      if(-1 == ts.indexOf(v.charAt(r))){
         break;
      }
   }
   if(0 != l || r != v.length-1){
      return v.substring(l, r + 1);
   }
   return v;
}

//==========================================================
// <T>去掉字符串开始的空格字符和非显示字符。</T>
//
// @method
// @param v:value:String 字符串对象
// @param ts:trims:String 要去除的字符串
// @return String 去掉开始的空格和非显示字符的字符串
//==========================================================
function RString_ltrim(v, ts){
   var o = this;
   v = o.nvl(value);
   ts = o.nvl(trims, o.TRIM);
   var l = 0;
   var r = v.length - 1;
   for(; l<r; l++){
      if(-1 == ts.indexOf(v.charAt(l))){
         break;
      }
   }
   if(0 != l){
      return v.substring(l, r + 1);
   }
   return v;
}

//==========================================================
// <T>去掉字符串结尾的空格字符和非显示字符。</T>
//
// @method
// @param v:value:String 字符串对象
// @param ts:trims:String 要去除的字符串
// @return String 去掉结尾的空格和非显示字符的字符串
//==========================================================
function RString_rtrim(v, ts){
   var o = this;
   v = o.nvl(v);
   ts = o.nvl(ts, o.TRIM);
   var r = v.length - 1;
   for(; r>=0; r--){
      if(-1 == ts.indexOf(v.charAt(r))){
         break;
      }
   }
   if(r != v.length-1){
      return v.substring(0, r + 1);
   }
   return v;
}

//==========================================================
// <T>从字符串中截取开始字符串到结束字符串中间的部分字符串。</T>
// <P>开始字符串不存在的话，从字符串开始位置截取。</B>
// 结束字符串不存在的话，截取到字符串的最终位置。</P>
//
// @method
// @param v:value:String 字符传对象
// @param s:start:String 起始字符串
// @param e:end:String 结束字符串
// @return String 截取后的部分字符串
//==========================================================
function RString_mid(v, s, e){
   if(null != v){
      var l = 0;
      var r = v.length;
      if(null != s){
         l = v.indexOf(s);
         l = (-1 == l) ? 0 : l + s.length;
      }
      if(null != e){
         r = v.indexOf(e, l);
         r = (-1 == r) ? v.length : r;
      }
      return v.substring(l, r);
   }
}

//==========================================================
// <T>将字符串中的控制字符转换为一行可以存储的字符串。</T>
//
// @method
// @param v:value:String 字符串
// @return String 行字符串
//==========================================================
function RString_toLine(v){
   return v.replace(/\n/g, '\\n').replace(/\r/g, '\\r').replace(/\t/g, '\\t')
}

//==========================================================
// <T>在字符串转化为小写字符串。</T>
//
// @method
// @param v:value:String 字符串
// @return String 小写字符串
//==========================================================
function RString_toLower(v){
   return (null != v) ? v.toLowerCase() : this.EMPTY;
}

//==========================================================
// <T>在字符串转化为大写字符串。</T>
//
// @method
// @param v:value:String 字符串
// @return String 大写字符串
//==========================================================
function RString_toUpper(v){
   return v ? v.toUpperCase() : this.EMPTY;
}

//==========================================================
// <T>把一个字符串分割为字符串数组。</T>
//
// @method
// @param v:value:String 字符串
// @param p:split:String 分割字符串
// @return String 分割后的字符串数组
//==========================================================
function RString_split(s, p){
   return (s && p) ? s.split(p) : null;
}

//==========================================================
// <T>把一个字符串分割为两个字符串的数组。</T>
//
// @method
// @param v:value:String 字符串
// @param p:split:String 分割字符
// @return String 分割后的字符串数组
//==========================================================
function RString_splitTwo(s, p){
   if(s && p){
      var r = new Array();
      var n = s.indexOf(p);
      if(-1 == n){
         r.push(s);
      }else{
         r.push(s.substring(0, n));
         r.push(s.substring(n+p.length));
      }
      return r;
   }
   return null;
}

//==========================================================
//<T>从字符串中截取与匹配字符相等的子字符串组。</T>
//
//@method
//@param s:string:String 字符串
//@param p:value:Array 要截取的参照字符的组合
//@return Array 截取的字符数组
//==========================================================
function RString_splitParts(s, p){
   var b=new Array();
   var k=0;
   for(var i=0;i<s.length;i++){
      for(var j in p){
         if(RString.startsWith(p[j],s.charAt(i))){
            if(RString.equals(s.substr(i,p[j].length),p[j])){
               b[k++]=p[j];
               i=i+p[j].length - 1;
               break;
            }
         }
      }
   }
   return b;
}

//==========================================================
//<T>从字符串中截取与匹配字符相等的子字符串组。</T>
//
//@method
//@param s:string:String 字符串
//@param p:value:Array 要截取的参照字符的组合
//@return Array 截取的字符数组
//==========================================================
function RString_splitPattern(s, p){
   var r = new Array();
   if(s){
      var sl = s.length;
      var pl = p.length;
      var t = '';
      for(var n=0; n<sl; n++){
         var v = false;
         for(var i=0; i<pl; i++){
            var f = p[i];
            if(0 == s.indexOf(f)){
               if(t.length){
                  r[r.length] = t;
                  t = '';
               }
               r[r.length] = f;
               s = s.substring(f.length);
               v = true;
               break;
            }
         }
         if(!v){
            t += s.charAt(0);
            s = s.substring(1);
         }
      }
   }
   return r;
}

//==========================================================
// <T>删除字符串中的指定字符。</T>
//
// @method
// @param s:source:String 源字符串
// @param t:target:String 目标字符串
// @return String 删除后的字符串
//==========================================================
function RString_remove(s, t){
   return s.replace(t, '');
}

//==========================================================
// <T>删除字符串中的指定字符集合。</T>
//
// @method
// @param v:value:String 字符串
// @param s:value:String 字符集合
// @return String 删除后的字符串
//==========================================================
function RString_removeChars(v, s){
   if(null != v){
      var c = v.length;
      var r = new Array();
      for(var n=0; n<c; n++){
         var a = v.charAt(n);
         if(-1 != s.indexOf(a)){
            continue;
         }
         r[r.length] = a;
      }
      return r.join('');
   }
   return v;
}
