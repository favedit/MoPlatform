<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/public.inc' %>
<jh:define item='&webform.environment' alias='environment'/>
<jh:define item='&webform.formConfig' alias='form_config'/>

<HTML>
<HEAD>
<TITLE>Class Example</TITLE>
<js:css/>
<jh:js/>
</HEAD>
<!-- Script -------------------------------------------------->
<SCRIPT>
var action = '<jh:write item="&#parameter.do"/>';
var form = null;
var toolbar = null;
function doRefresh(){
	fmMain.action = '';
	fmMain.submit();
}
function _load(){
	// Build toolbar
	toolbar = RControl.fromXml(xToolBar, _id_toolbar);
	// Check result
	RConsole.find(FResultConsole).checkService(RXml.makeNode(xResult));
}
</SCRIPT>
<!-- Environment --------------------------------------------->
<XML ID="xEnvironment">
<jh:write item='&environment' format='text'/>
</XML>
<!-- ToolBar ------------------------------------------------->
<XML ID="xToolBar">
<ToolBar width='100%' height='100%'>
	<ToolButton name='btnBack' caption='Back' icon='tool.back' icon_disable='tool.backd'/>
</ToolBar>
</XML>
<!-- Value --------------------------------------------------->
<XML ID="xValue">
<jh:write item='&form_value' format='text'/>
</XML>
<!-- Result --------------------------------------------------->
<XML ID="xResult">
<jh:write item='&page.resultXml' format='text'/>
</XML>
<!-- Body begin ---------------------------------------------->
<jh:body styleclass='bodyMain' scroll='no' onload='_load()'>
<jh:form>
<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' height='100%'>
<TR>
<TD height='24'>
<!-- Toolbar begin ------------------------------------------->
<DIV id='_id_toolbar'></DIV>
<!-- Toolbar end --------------------------------------------->
</TD>
</TR>
<TR><TD height='4'></TD></TR>
<TR><TD style='padding:8' valign='top'>
<!-- Form begin ---------------------------------------------->
	<TABLE width='100%' cellspacing='8' border='0'>
	<TR><TD>
		<TABLE width='100%' border='0' cellspacing='1' cellpadding='4'>
			<TR><TD align='center' valign='middle'>
			<jh:img icon='sys.msg.lmsg'/><jh:img icon='n' width='8'/>Process End
			</TD></TR>
		</TABLE>
	</TD></TR>
	<TR><TD>
		<TABLE width='100%' bgcolor='#94B6FF' border='0' cellspacing='1' cellpadding='0'>
		<TR bgcolor='#FFFFFF'><TD>
		<TABLE width='100%' border='0' cellspacing='4' cellpadding='0'>
			<TR>
			<TD nowrap>Delete is success.</TD>
			</TR>
		</TABLE>
	</TD></TR>
		</TABLE>
		</TD></TR>
		<TR><TD>
		<TABLE width='100%' border='0' cellspacing='0' cellpadding='4'>
		<TR>
		<TD align='center'>
		</TD>
		</TABLE>
	</TD></TR>
	</TABLE>
<!-- Form end ------------------------------------------------>
</TD></TR>
</TABLE>
</jh:form>
</jh:body>
<!-- Body end ------------------------------------------------>
</HTML>
