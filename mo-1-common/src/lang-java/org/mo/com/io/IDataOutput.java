package org.mo.com.io;

//============================================================
// <T>数据输出流接口。</T>
//============================================================
public interface IDataOutput
      extends
         IOutput
{
   //============================================================
   // <T>向字节流中写入一个布尔值。</T>
   // <P>占用一个字节，为1表示真，为0表示假。</P>
   //
   // @param value 布尔值
   //============================================================
   void writeBoolean(boolean value);

   //============================================================
   // <T>向字节流中写入一个有符号整数。</T>
   //
   // @param value 有符号整数
   //============================================================
   void writeInt(int value);

   //============================================================
   // <T>向字节流中写入一个有符号8位整数。</T>
   //
   // @param value 有符号8位整数
   //============================================================
   void writeInt8(byte value);

   //============================================================
   // <T>在字节流中写入一个有符号16位整数。</T>
   //
   // @param value 有符号16位整数
   //============================================================
   void writeInt16(short value);

   //============================================================
   // <T>在字节流中写入一个有符号32位整数。</T>
   //
   // @param value 有符号32位整数
   //============================================================
   void writeInt32(int value);

   //============================================================
   // <T>在字节流中写入一个有符号64位整数。</T>
   //
   // @param value 有符号64位整数
   //============================================================
   void writeInt64(long value);

   //============================================================
   // <T>向字节流中写入一个无符号8位整数。</T>
   //
   // @param value 无符号8位整数
   //============================================================
   void writeUint8(byte value);

   //============================================================
   // <T>向字节流中写入一个无符号16位整数。</T>
   //
   // @param value 无符号16位整数
   //============================================================
   void writeUint16(short value);

   //============================================================
   // <T>向字节流中写入一个无符号32位整数。</T>
   //
   // @param value 无符号32位整数
   //============================================================
   void writeUint32(int value);

   //============================================================
   // <T>向字节流中写入一个无符号64位整数。</T>
   //
   // @param value 无符号64位整数
   //============================================================
   void writeUint64(long value);

   //============================================================
   // <T>向字节流中写入一个32位浮点数。</T>
   //
   // @param value 32位浮点数
   //============================================================
   void writeFloat(float value);

   //============================================================
   // <T>向字节流中写入一个64位浮点数。</T>
   //
   // @param value 64位浮点数
   //============================================================
   void writeDouble(double value);

   //============================================================
   // <T>向字节流中写入一个8位字符串。</T>
   //
   // @param pValue 字符串
   // @param length 长度
   //============================================================
   void writeString(String value);
}
