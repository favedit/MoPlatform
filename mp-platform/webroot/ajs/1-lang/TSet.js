﻿//============================================================
// TSet
//============================================================
function TSet(){
   var o = this;
   // Method
   o.contains = TSet_contains;
   return o;
}

//============================================================
// source, value
//============================================================
function TSet_contains(s, v){
   return RString.contains(s, v);
}

