<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
    <my:Module name="EMPLOYEE" />
    <jsp:include page="/MasterPageTopSection.jsp" />
    <link rel="stylesheet" type="text/css" href="/styletwo/css/Employees.css">
    <script src="/styletwo/js/EmployeesJS.js"></script>

    <div class="employee-grid">
        <h2>Employee</h2>
        <table border='1' id="employeesGridTable" class="table table-sm">
            <thead >
                <tr>
                    <th colspan='6' class="employee-grid-header">
                        <a href='/styletwo/EmployeeAddForm.jsp'>Add Employee</a>
                    </th>
                </tr>
                <tr style="cursor:pointer;">
                    <th style='width:60px;text-align:center'>S.No.</th>
                    <th style='width:200px;text-align:center'>Id.</th>
                    <th style='width:200px;text-align:center'>Name</th>
                    <th style='width:200px;text-align:center'>Designation</th>
                    <th style='width:100px;text-align:center'>Edit</th>
                    <th style='width:100px;text-align:center'>Delete</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style='text-align:right' placeHolderId='serialNumber'></td>
                    <td placeHolderId="employeeId"></td>
                    <td placeHolderId="name"></td>
                    <td placeHolderId="designation"></td>
                    <td style='text-align:center' placeHolderId="editOption"></td>
                    <td style='text-align:center' placeHolderId="deleteOption"></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div style='border:2px solid black;margin: 5px;height: 24vh;'>
        <label style='background: gray;color: white;padding-right: 5px;padding-left: 5px;margin: 1px;'>Details</label>
        <table border='0' width='100%'>
            <tr>
                <td>Employee Id: <span id='detailPanel_emplyeeId' style='margin-right:30px'></span></td>
                <td>Name : <span id='detailPanel_name' style='margin-right:30px'></span></td>
                <td>Designation : <span id='detailPanel_designation' style='margin-right:30px'></span>
                </td>
            </tr>
            <tr>
                <td>Date of Birth : <span id='detailPanel_dateOfBirth' style='margin-right:30px'></span>
                </td>
                <td>Gender : <span id='detailPanel_gender' style='margin-right:30px'></span></td>
                <td>Is Indian : <span id='detailPanel_isIndian' style='margin-right:30px'></span></td>
            </tr>
            <tr>
                <td>Basic salary : <span id='detailPanel_basicSalary' style='margin-right:30px'></span>
                </td>
                <td>Pan Number : <span id='detailPanel_panNumber' style='margin-right:30px'></span></td>
                <td>Aadhar card Number : <span id='detailPanel_aadharCardNumber' style='margin-right:30px'></span></td>
            </tr>
        </table>
    </div>

    <jsp:include page="/MasterPageBottomSection.jsp" />