<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
<my:Guard>
    <jsp:forward page="/LoginForm.jsp"/>
</my:Guard>
<my:Module name="DESIGNATION"/>
<my:FormResubmitted> <!--if form is resubmitted, it will get fired-->
    <jsp:forward page='/notifyFormResubmission'/>
</my:FormResubmitted>
<jsp:useBean id="designationBean" scope="request" class="com.thinking.machines.hr.beans.DesignationBean"/>
<jsp:setProperty name="designationBean" property="*"/>
<jsp:forward page='/addDesignation'/>