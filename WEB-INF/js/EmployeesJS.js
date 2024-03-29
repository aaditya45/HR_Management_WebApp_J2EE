function Employee() {
    this.employeeId = "";
    this.name = "";
    this.designationCode = 0;
    this.designation = "";
    this.dateOfBirth = "";
    this.gender = "";
    this.isIndian = true;
    this.basicSalary = 0;
    this.panNumber = "";
    this.aadharCardNumber = "";
}
var employees = []
var employee

var selectedRow = null
function selectEmployee(row, employeeId) {
    if (row == selectedRow) return
    if (selectedRow != null) {
        selectedRow.style.background = 'white'
        selectedRow.style.color = 'black'
    }
    row.style.background = "#7C7B7B"
    row.style.colot = "white"
    selectedRow = row
    var i
    for (i = 0; i < employees.length; i++) {
        if (employeeId == employees[i].employeeId) {
            break
        }
    }
    var emp = employees[i]
    document.getElementById("detailPanel_emplyeeId").innerHTML = emp.employeeId
    document.getElementById("detailPanel_name").innerHTML = emp.name
    document.getElementById("detailPanel_designation").innerHTML = emp.designation
    document.getElementById("detailPanel_dateOfBirth").innerHTML = emp.dateOfBirth
    document.getElementById("detailPanel_gender").innerHTML = emp.gender
    if (emp.isIndian) {
        document.getElementById("detailPanel_isIndian").innerHTML = "Yes"
    }
    else {
        document.getElementById("detailPanel_isIndian").innerHTML = "No"
    }
    document.getElementById("detailPanel_basicSalary").innerHTML = emp.basicSalary
    document.getElementById("detailPanel_panNumber").innerHTML = emp.panNumber
    document.getElementById("detailPanel_aadharCardNumber").innerHTML = emp.aadharCardNumber
}


function createDynamicRowClickHandler(rowAddress, employeeId){
    return function(){
        selectEmployee(rowAddress, employeeId)
    };
}
function populateEmployeesGridTable() {
    var employeesGridTable = document.getElementById('employeesGridTable')
    var employeeGridTableBody = employeesGridTable.getElementsByTagName('tbody')[0]
    var employeeGridTableBodyRowTemplate = employeeGridTableBody.getElementsByTagName('tr')[0]
    //Remove the row from DOM (Document object Model)
    employeeGridTableBodyRowTemplate.remove()
    var employeesGridTableColumnsTemplateCollection = employeeGridTableBodyRowTemplate.getElementsByTagName('td')
    var cellTemplate
    var k
    var dynamicRow
    var dynamicRowCell
    var placeHolderFor
    for (k = 0; k < employees.length; k++) {
        dynamicRow = employeeGridTableBodyRowTemplate.cloneNode(true)
        console.log(dynamicRow.innerHTML)
        employeeGridTableBody.appendChild(dynamicRow)
        dynamicRowCell = dynamicRow.getElementsByTagName('td')
        for (var i = 0; i < dynamicRowCell.length; i++) {
            cellTemplate = dynamicRowCell[i]
            placeHolderFor = cellTemplate.getAttribute('placeHolderId');
            if (placeHolderFor == null) continue;
            if (placeHolderFor == "serialNumber") cellTemplate.innerHTML = (k + 1);
            if (placeHolderFor == "employeeId") cellTemplate.innerHTML = employees[k].employeeId;
            if (placeHolderFor == "name") cellTemplate.innerHTML = employees[k].name;
            if (placeHolderFor == "designationCode") cellTemplate.innerHTML = employees[k].designationCode;
            if (placeHolderFor == "designation") cellTemplate.innerHTML = employees[k].designation;
            if (placeHolderFor == "dateOfBirth") cellTemplate.innerHTML = employees[k].dateOfBirth;
            if (placeHolderFor == "gender") cellTemplate.innerHTML = employees[k].gender;
            if (placeHolderFor == "isIndian") cellTemplate.innerHTML = employees[k].isIndian;
            if (placeHolderFor == "basicSalary") cellTemplate.innerHTML = employees[k].basicSalary;
            if (placeHolderFor == "panNumber") cellTemplate.innerHTML = employees[k].panNumber;
            if (placeHolderFor == "aadharCardNumber") cellTemplate.innerHTML = employees[k].aadharCardNumber;
            if (placeHolderFor == "editOption") cellTemplate.innerHTML = "<a href='/styletwo/editEmployeeConfirmation?employeeId=" + employees[k].employeeId + "'>Edit</a>";
            if (placeHolderFor == "deleteOption") cellTemplate.innerHTML = "<a href='/styletwo/deleteEmployeeConfirmation?employeeId=" + employees[k].employeeId + "'>Delete</a>";
        }
        dynamicRow.onclick = createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);
    }

}
window.addEventListener('load',populateEmployeesGridTable);
