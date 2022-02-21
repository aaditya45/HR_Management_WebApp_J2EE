<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
<my:Module name="DESIGNATION"/>    
<jsp:include page="/MasterPageTopSection.jsp" />
    <b>Designation</b><br>
    <table border='1' class="table table-sm">
        <thead>
            <tr>
                <th colspan='4' style='text-align:right;padding:5px;'><a href='/styletwo/DesignationAddForm.jsp'>Add Designation</a></th>
            </tr>
            <tr>
                <th style='width:60px;text-align:center;'>S.No.</th>
                <th style='width:400px;text-align:center;'>Designation</th>
                <th style='width:100px;text-align:center;'>Edit</th>
                <th style='width:100px;text-align:center;'>Delete</th>
            </tr>
        </thead>
        <tbody>
            <my:EntityList populatorClass="com.thinking.machines.hr.bl.DesignationBL" populatorMethod="getAll" name='designationBean'>
                <tr>
                    <td style='text-align:right'>${serialNumber}.</td>
                    <td>${designationBean.title}</td>
                    <td style='text-align:center'><a href='/styletwo/editDesignation?code=${designationBean.code}'>Edit</a></td>
                    <td style='text-align:center'><a href='/styletwo/designationDeleteConfirmation?code=${designationBean.code}'>Delete</a></td>
                </tr>
            </my:EntityList>
        </tbody>
    </table>
    <jsp:include page="/MasterPageBottomSection.jsp" />