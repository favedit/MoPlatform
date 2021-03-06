<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/public.inc' %>

<HTML>
<HEAD>
<TITLE>资源: <jh:write source='&page.resourceId'/> 中华料理 - 存储</TITLE>
<je:css/>
<je:js/>
<jh:js src='/ajs/4-ctl.window/FPageTab.js' />
<jh:js src='/ajs/4-ctl.window/FPageBar.js' />
<jh:js src='/ajs/logic/FLgSpliter.js' />
</HEAD>

<!-- Script -------------------------------------------------->
<SCRIPT>
var action = 'update';
var form = null;
var toolbar = null;
var pagebar = null;
function doRefresh() {
   fmMain.action = '';
   fmMain.submit();
}
function doInsert() {
   form.doAction('insertAction');
}
function doUpload() {
	var uri = '<jh:context/>/apl/logic/resource/StoreUpload.wa';
	RHtml.popup(uri, 440, 260);
}
function doPage(sender){
	fmMain.action = sender.page;
	fmMain.submit();
}
function doDelete(){
   form.doAction('deleteAction');
}
function doClose(){
   this.close();
}
function _load(){
	toolbar = RControl.fromXml(xToolBar, _id_toolbar);
	// split
	var cs = RClass.create(FLgSpliter);
	cs.link(id_split, id_left);
}
</SCRIPT>
<!-- Form ---------------------------------------------------->
<XML ID="xToolBar">
<ToolBar width='100%'>
	<ToolButton name='insertFoldor' label='新建文件夹' icon='tool.refresh' icon_disable='tool.refreshd' method='doInsert'/>
	<ToolButtonSplit/>
	<ToolButton name='upload' label='上传文件' icon='tool.insert' icon_disable='tool.insertd' action='doUpload()'/>
	<ToolButton name='download' label='下载文件' icon='tool.update' icon_disable='tool.updated' action='doDownload()'/>
	<ToolButtonSplit/>
	<ToolButton name='close' label='关闭' icon='tool.action' icon_disable='tool.actiond' action='doClose()'/>
</ToolBar>
</XML>
<BODY onload='_load()' scroll='no' style='margin:0;padding:0' bgcolor="#2cc8e7">
<jh:form>
<table width="100%" height='100%' border="0" cellpadding="0" cellspacing="0">
   <tr>
      <td height="1" bgcolor="#00CCFF" id='_id_toolbar'></td>
   </tr>
   <tr>
      <td bgcolor='#FFFFFF' style='border-left:1 solid #1f8ba1; border-right:1 solid #1f8ba1'>
			<table width="100%" height='100%' border="0" cellpadding="0" cellspacing="0">
         <tr>
            <td id='id_left' width="200">Tree</td>
            <td id='id_split' width="3" bgcolor="#00CCFF"></td>
            <td>Body</td>
         </tr>
      </table></td>
   </tr>
</table>
</jh:form>
</BODY>
</HTML>