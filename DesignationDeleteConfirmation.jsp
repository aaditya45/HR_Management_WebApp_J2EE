<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
<my:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationDeleteConfirmation.js'></script>

<center>
    <h2>Designation(Delete Module)</h2>
    <span class='error'>
        <jsp:getProperty name='errorBean' property='error' />
    </span>
    <form method='post' action='/styletwo/DeleteDesignation.jsp'>
        <my:FormID/>
        Designation
        <b>${designationBean.title}</b><br><br>
        Are you sure you want to delete this designation ?<br><br>
        <input type='hidden' id='code' name='code' value='${designationBean.code}'>
        <span id='titleErrorSection' style='color:red'></span><br>
        <button class='btn btn-outline-success' type='submit'>Yes</button>
        <button class="btn btn-outline-danger" type='Button' onclick='cancelDeletion()'>No</button>
    </form>
</center>
<form id='cancelDeletionForm' action="/styletwo/Designations.jsp"></form>
<jsp:include page="/MasterPageBottomSection.jsp" />