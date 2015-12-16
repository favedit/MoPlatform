<%@ include file='/apl/public.inc' %>
<jh:define item='&page.webform' alias='form'/>
<jh:define item='&page.webformfields' alias='fields'/>

<HTML>
<HEAD>
<TITLE>Welcome</TITLE>
<js:css />
</HEAD>
<!------------------------------------------------------------>
<STYLE>
.toolbarButton {color:#666666; background-color:#DDDDDD;
      padding-top:0; padding-left:16; padding-bottom:0; padding-right:16; }
</STYLE>
<SCRIPT language='javascript'>
function selConsole(name){
   fmMain.action = '?do=showConsole&name=' + name;
   fmMain.target = 'frmBody';
   fmMain.submit();
}
</SCRIPT>
<!------------------------------------------------------------>
<BODY style='margin:0; padding-right:6; padding-bottom:6' scroll='no'>

<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' height='100%'>
   <TR>
      <TD style='border:1 solid #999999' valign='top'>

<TABLE border='0' cellpadding="4" cellspacing='0'>
   <TR><TD>Name</TD><TD><jh:item source='&form.name'/></TD></TR>
   <TR><TD>driver</TD><TD><jh:item source='&console.driver'/></TD></TR>
   <TR><TD>url</TD><TD><jh:item source='&console.url'/></TD></TR>
   <TR><TD>user</TD><TD><jh:item source='&console.user'/></TD></TR>
   <TR><TD>active_time_limit</TD><TD><jh:item source='&console.active_time_limit'/></TD></TR>
</TABLE>

<HR>

<TABLE border='0' cellpadding="4" cellspacing='0'>
   <jh:loop item='&fields' alias='field'>
   <TR>
      <TD><js:img icon='sys-form-field'/></TD>
      <TD><jh:item source='&field.name'/></A></TD>
      <TD><jh:item source='&field.type'/></A></TD>
      <TD><jh:item source='&field.dataset'/></A></TD>
      <TD><jh:item source='&field.deleteAble'/></A></TD>
      <TD><jh:item source='&field.form'/></A></TD>
   </TR>
   </jh:loop>
</TABLE>

      </TD>
   </TR>
</TABLE>

</BODY>

</HTML>

