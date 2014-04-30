package com.zqinet.logic.data.logger;

import org.mo.com.lang.*;
import org.mo.com.collections.*;
import org.mo.com.data.*;
import org.mo.data.logic.*;

//============================================================
// <T>角色登陆日志逻辑。</T>
//============================================================
public class FLoggerLoginLogic extends FLogicDataset
{
   // 的定义。
   public final static FLogicTable Table = new FLogicTable("LOG_ROLE_LOGIN");

   // 字段对象标识的定义。
   public final static FLogicField FieldOuid = new FLogicField("OUID");

   // 字段有效性的定义。
   public final static FLogicField FieldOvld = new FLogicField("OVLD");

   // 字段唯一标识的定义。
   public final static FLogicField FieldUniqueId = new FLogicField("UNIQUE_ID");

   // 字段账号ID的定义。
   public final static FLogicField FieldAccountId = new FLogicField("ACCOUNT_ID");

   // 字段角色ID的定义。
   public final static FLogicField FieldRoleId = new FLogicField("ROLE_ID");

   // 字段操作时间的定义。
   public final static FLogicField FieldOpTime = new FLogicField("OP_TIME");

   // 字段当前角色所在的地图ID的定义。
   public final static FLogicField FieldMapId = new FLogicField("MAP_ID");

   // 字段角色名称的定义。
   public final static FLogicField FieldRoleLabel = new FLogicField("ROLE_LABEL");

   // 字段职业ID的定义。
   public final static FLogicField FieldMetierTid = new FLogicField("METIER_TID");

   // 字段当前等级的定义。
   public final static FLogicField FieldRoleLevel = new FLogicField("ROLE_LEVEL");

   // 字段登陆IP的定义。
   public final static FLogicField FieldLoginIp = new FLogicField("LOGIN_IP");

   // 字段操作类型的定义。
   public final static FLogicField FieldOpType = new FLogicField("OP_TYPE");

   // 字段退出类型的定义。
   public final static FLogicField FieldLeaveReason = new FLogicField("LEAVE_REASON");

   // 字段登陆的标志的定义。
   public final static FLogicField FieldLoginFlag = new FLogicField("LOGIN_FLAG");

   // 字段存盘标志的定义。
   public final static FLogicField FieldSaveFlag = new FLogicField("SAVE_FLAG");

   // 字段参数1的定义。
   public final static FLogicField FieldParam1 = new FLogicField("PARAM1");

   // 字段参数2的定义。
   public final static FLogicField FieldParam2 = new FLogicField("PARAM2");

   // 字段创建用户标识的定义。
   public final static FLogicField FieldCreateUserId = new FLogicField("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static FLogicField FieldCreateDate = new FLogicField("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static FLogicField FieldUpdateUserId = new FLogicField("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static FLogicField FieldUpdateDate = new FLogicField("UPDATE_DATE");

   // 字段是否已经发送的定义。
   public final static FLogicField FieldIsSend = new FLogicField("IS_SEND");

   //============================================================
   // <T>构造角色登陆日志逻辑单元。</T>
   //============================================================
   public FLoggerLoginLogic(){
   }

   //============================================================
   // <T>构造角色登陆日志逻辑单元。</T>
   //
   // @param connection 链接
   //============================================================
   public FLoggerLoginLogic(ISqlConnection connection){
      _connection = connection;
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param recordId 记录编号
   // @return 数据单元
   //============================================================
   public FLoggerLoginUnit find(long recordId){
      // 检查记录编号
      if(0 == recordId){
         return null;
      }
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      sql.append(" WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      FRow row = _connection.find(sql.toString());
      if(null == row){
         return null;
      }
      // 获得数据
      FLoggerLoginUnit unit = new FLoggerLoginUnit();
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据条件获得一个数据单元。</T>
   //
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   public FLoggerLoginUnit serach(String whereSql){
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      sql.append(" WHERE ");
      sql.append(whereSql);
      // 执行命令
      FRow row = _connection.find(sql.toString());
      // 获得数据
      if(null == row){
         return null;
      }
      FLoggerLoginUnit unit = new FLoggerLoginUnit();
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @return 数据单元集合
   //============================================================
   public FLoggerLoginUnit[] fetch(String whereSql){
      return fetch(whereSql, null, 0);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @return 数据单元集合
   //============================================================
   public FLoggerLoginUnit[] fetch(String whereSql, String orderSql){
      return fetch(whereSql, orderSql, 0);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @param limitCount 限制条数
   // @return 数据单元集合
   //============================================================
   public FLoggerLoginUnit[] fetch(String whereSql, String orderSql, int limitCount){
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      if(!RString.isEmpty(whereSql)){
         sql.append(" WHERE ");
         sql.append(whereSql);
      }
      if(!RString.isEmpty(orderSql)){
         sql.append(" ORDER BY ");
         sql.append(orderSql);
      }
      if(limitCount > 0){
         sql.append(" LIMIT ");
         sql.append(limitCount);
      }
      // 执行命令
      FDataset dataset = _connection.fetchDataset(sql.toString());
      int count = dataset.count();
      // 获得数据
      FLoggerLoginUnit[] units = new FLoggerLoginUnit[count];
      for(int n = 0; n < count; n++){
         FLoggerLoginUnit unit = new FLoggerLoginUnit();
         unit.load(dataset.get(n));
         units[n] = unit;
      }
      return units;
   }

   //============================================================
   // <T>根据条件获得全部数据单元集合。</T>
   //
   // @return 数据单元集合
   //============================================================
   public FLoggerLoginUnit[] fetchAll(){
      return fetch(null);
   }

   //============================================================
   // <T>插入一个数据单元。</T>
   //
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   public boolean doInsert(FLoggerLoginUnit unit){
      // 生成命令
      FSql sql = new FSql("INSERT INTO ");
      sql.append(Table.name());
      sql.append("(");
      sql.append("`OVLD`");
      sql.append(",`UNIQUE_ID`");
      sql.append(",`ACCOUNT_ID`");
      sql.append(",`ROLE_ID`");
      sql.append(",`OP_TIME`");
      sql.append(",`MAP_ID`");
      sql.append(",`ROLE_LABEL`");
      sql.append(",`METIER_TID`");
      sql.append(",`ROLE_LEVEL`");
      sql.append(",`LOGIN_IP`");
      sql.append(",`OP_TYPE`");
      sql.append(",`LEAVE_REASON`");
      sql.append(",`LOGIN_FLAG`");
      sql.append(",`SAVE_FLAG`");
      sql.append(",`PARAM1`");
      sql.append(",`PARAM2`");
      sql.append(",`CREATE_USER_ID`");
      sql.append(",`CREATE_DATE`");
      sql.append(",`UPDATE_USER_ID`");
      sql.append(",`UPDATE_DATE`");
      sql.append(",`IS_SEND`");
      sql.append(") VALUES(");
      sql.append(unit.ovld());
      sql.append(',');
      sql.append(unit.uniqueId());
      sql.append(',');
      sql.append(unit.accountId());
      sql.append(',');
      sql.append(unit.roleId());
      sql.append(',');
      if(unit.opTime().isEmpty()){
         sql.append("NULL");
      }else{
         sql.append("STR_TO_DATE('");
         sql.append(unit.opTime().format());
         sql.append("','%Y%m%d%H%i%s')");
      }
      sql.append(',');
      sql.append(unit.mapId());
      sql.append(',');
      if(RString.isEmpty(unit.roleLabel())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.roleLabel()));
         sql.append('\'');
      }
      sql.append(',');
      sql.append(unit.metierTid());
      sql.append(',');
      sql.append(unit.roleLevel());
      sql.append(',');
      if(RString.isEmpty(unit.loginIp())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.loginIp()));
         sql.append('\'');
      }
      sql.append(',');
      sql.append(unit.opType());
      sql.append(',');
      sql.append(unit.leaveReason());
      sql.append(',');
      sql.append(unit.loginFlag());
      sql.append(',');
      sql.append(unit.saveFlag());
      sql.append(',');
      if(RString.isEmpty(unit.param1())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.param1()));
         sql.append('\'');
      }
      sql.append(',');
      if(RString.isEmpty(unit.param2())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.param2()));
         sql.append('\'');
      }
      sql.append(',');
      sql.append(unit.isSend());
      sql.append(",0,NOW(),0,NOW())");
      // 执行命令
      long recordId = _connection.executeInsertSql(sql.toString());
      unit.setOuid(recordId);
      return true;
   }

   //============================================================
   // <T>更新一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   public boolean doUpdate(FLoggerLoginUnit unit, long recordId){
      // 检查记录编号
      if(0 == recordId){
         throw new FFatalError("Record id is empty. (record_id={1})", recordId);
      }
      // 生成命令
      FSql sql = new FSql("UPDATE ");
      sql.append(Table.name());
      sql.append(" SET OVLD=");
      sql.append(unit.ovld());
      if(unit.isUniqueIdChanged()){
         sql.append(",`UNIQUE_ID`=");
         sql.append(unit.uniqueId());
      }
      if(unit.isAccountIdChanged()){
         sql.append(",`ACCOUNT_ID`=");
         sql.append(unit.accountId());
      }
      if(unit.isRoleIdChanged()){
         sql.append(",`ROLE_ID`=");
         sql.append(unit.roleId());
      }
      if(unit.isOpTimeChanged()){
         sql.append(",`OP_TIME`=");
         if(unit.opTime().isEmpty()){
            sql.append("NULL");
         }else{
            sql.append("STR_TO_DATE('");
            sql.append(unit.opTime().format());
            sql.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isMapIdChanged()){
         sql.append(",`MAP_ID`=");
         sql.append(unit.mapId());
      }
      if(unit.isRoleLabelChanged()){
         sql.append(",`ROLE_LABEL`=");
         if(RString.isEmpty(unit.roleLabel())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.roleLabel()));
            sql.append("'");
         }
      }
      if(unit.isMetierTidChanged()){
         sql.append(",`METIER_TID`=");
         sql.append(unit.metierTid());
      }
      if(unit.isRoleLevelChanged()){
         sql.append(",`ROLE_LEVEL`=");
         sql.append(unit.roleLevel());
      }
      if(unit.isLoginIpChanged()){
         sql.append(",`LOGIN_IP`=");
         if(RString.isEmpty(unit.loginIp())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.loginIp()));
            sql.append("'");
         }
      }
      if(unit.isOpTypeChanged()){
         sql.append(",`OP_TYPE`=");
         sql.append(unit.opType());
      }
      if(unit.isLeaveReasonChanged()){
         sql.append(",`LEAVE_REASON`=");
         sql.append(unit.leaveReason());
      }
      if(unit.isLoginFlagChanged()){
         sql.append(",`LOGIN_FLAG`=");
         sql.append(unit.loginFlag());
      }
      if(unit.isSaveFlagChanged()){
         sql.append(",`SAVE_FLAG`=");
         sql.append(unit.saveFlag());
      }
      if(unit.isParam1Changed()){
         sql.append(",`PARAM1`=");
         if(RString.isEmpty(unit.param1())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.param1()));
            sql.append("'");
         }
      }
      if(unit.isParam2Changed()){
         sql.append(",`PARAM2`=");
         if(RString.isEmpty(unit.param2())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.param2()));
            sql.append("'");
         }
      }
      if(unit.isCreateUserIdChanged()){
         sql.append(",`CREATE_USER_ID`=");
         sql.append(unit.createUserId());
      }
      if(unit.isIsSendChanged()){
         sql.append(",`IS_SEND`=");
         sql.append(unit.isSend());
      }
      sql.append(",UPDATE_USER_ID=0,UPDATE_DATE=NOW()");
      sql.append(" WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      return _connection.executeSql(sql.toString());
   }

   //============================================================
   // <T>删除一个数据单元。</T>
   //
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   public boolean doDelete(long recordId){
      // 生成命令
      FSql sql = new FSql("DELETE FROM ");
      sql.append(Table.name());
      sql.append("WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      return _connection.executeSql(sql.toString());
   }
}