<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
<my:Module name='HOME' />
<my:Module name='Employee' />
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean'/>
<jsp:setProperty name='employeeBean' property='*' />
<jsp:forward page='/addEmployee'/>