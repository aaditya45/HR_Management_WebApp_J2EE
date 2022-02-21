<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
<jsp:useBean id="designationBean" scope="request" class="com.thinking.machines.hr.beans.DesignationBean" />
<jsp:useBean id="errorBean" scope="request" class="com.thinking.machines.hr.beans.ErrorBean" />
<my:Module name="DESIGNATION"/>
<jsp:include page="/MasterPageTopSection.jsp" />
<script src="/styletwo/js/DesignationAddForm.js"></script>
<center>
    <b>Designation(Add Module)</b><br><br>
    <span class="error">
        <jsp:getProperty name='errorBean' property='error' />
    </span>
    <form method='post' action='/styletwo/AddDesignation.jsp' onsubmit='return validateDesignation(this)'>
        <my:FormID/>
        Designation <input type='text' id='title' name='title' maxlength='35' size='35'
            value="${designationBean.title}"><span id='titleErrorSection' class="error"></span><br>
        <center>
            <button type='submit' class="btn btn-outline-success" style="margin: 10px;">Add</button>
            <button type='button' onclick='cancelButton()' class="btn btn-outline-danger" style="margin: 10px;">Cancel</button>
        </center> 
    </form>    
</center>
<form id='cancelAdditionForm' action='/styletwo/Designations.jsp'></form>
<jsp:include page="/MasterPageBottomSection.jsp" />