package org.mo.com.io;

import org.mo.com.io.base.MLongStream;

//============================================================
//<T>长整数数据流。</T>
//============================================================
public class FLongStream
      extends MLongStream
{
   //============================================================
   // <T>构造长整数数据流。</T>
   //============================================================
   public FLongStream(){
   }

   //============================================================
   // <T>构造长整数数据流。</T>
   //
   // @param capacity 容量
   //============================================================
   public FLongStream(int capacity){
      super(capacity);
   }
}
