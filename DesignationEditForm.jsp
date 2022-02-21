<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
    <my:Module name='DESIGNATION' />
    <jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
    <jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />

<jsp:include page="/MasterPageTopSection.jsp"/>
                        <center>
                            <h2>Designation(Edit Module)</h2>
                            <span class='error'>
                                <jsp:getProperty name='errorBean' property='error' />
                            </span>
                            <form method='post' action='/styletwo/UpdateDesignation.jsp'
                                onsubmit='return validateForm(this)'>
                                Designation
                                <input type='hidden' id='code' name='code' value='${designationBean.code}'>
                                <input type='text' id='title' name='title' maxlength='35' size='36'
                                    value='${designationBean.title}'>
                                <span id='titleErrorSection' style='color:red'></span><br>
                                <button style="margin:10px;" class="btn btn-outline-success" type='submit'>Update</button>
                                <button style="margin:10px;" class="btn btn-outline-danger" type='Button' onclick='cancelAdditionForm()'>Cancel</button>
                            </form>
                        </center>
                            
                            <jsp:include page="/MasterPageBottomSection.jsp"/>