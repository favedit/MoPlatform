package org.mo.com.lang;

//============================================================
// <T>名称内容对集合接口。</T>
//
// @type N 名称类型
// @type V 内容类型
//============================================================
public interface IPairs<N, V>
      extends
         IMap<N, V>
{
   //============================================================
   // <T>获得总数。</T>
   //
   // @return 总数
   //============================================================
   @Override
   int count();

   //============================================================
   // <T>获得指定索引位置的数据名称。</T>
   //
   // @param index 索引位置
   // @return 数据名称
   //============================================================
   @Override
   N name(int index);

   //============================================================
   // <T>获得指定索引位置的数据内容。</T>
   //
   // @param index 索引位置
   // @return 数据内容
   //============================================================
   @Override
   V value(int index);
}
