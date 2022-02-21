<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
<my:Guard>
    <jsp:forward page="/LoginForm.jsp"/>
</my:Guard>
<my:Module name="EMPLOYEE"/>
<my:FormResubmitted> <!--if form is resubmitted, it will get fired-->
    <jsp:forward page='/notifyFormResubmission'/>
</my:FormResubmitted>
<jsp:useBean id="employeeBean" scope="request" class="com.thinking.machines.hr.beans.EmployeeBean"/>
<jsp:setProperty name="employeeBean" property="*"/>
<jsp:forward page='/deleteDesignationConfirmation'/>