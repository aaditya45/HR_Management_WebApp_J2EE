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
employee = new Employee()
employee.employeeId = "A100006";
employee.name = "Abhir Padhye";
employee.designationCode = 17;
employee.designation = "Cloud Engineer";
employee.dateOfBirth = "23/04/0016";
employee.gender = "M";
employee.isIndian = true;
employee.basicSalary = 1400000.00;
employee.panNumber = "QPG055";
employee.aadharCardNumber = "55165";
employees[0] = employee;
employee = new Employee()
employee.employeeId = "A100003";
employee.name = "Jyoti Yadav";
employee.designationCode = 2;
employee.designation = "Clerk";
employee.dateOfBirth = "30/08/2001";
employee.gender = "F";
employee.isIndian = true;
employee.basicSalary = 600000.00;
employee.panNumber = "VVJ734";
employee.aadharCardNumber = "10125";
employees[1] = employee;
employee = new Employee()
employee.employeeId = "A100004";
employee.name = "Kushagrah mishra";
employee.designationCode = 13;
employee.designation = "Director";
employee.dateOfBirth = "23/05/2001";
employee.gender = "M";
employee.isIndian = true;
employee.basicSalary = 800000.00;
employee.panNumber = "RVJ734";
employee.aadharCardNumber = "40125";
employees[2] = employee;
employee = new Employee()
employee.employeeId = "A100005";
employee.name = "Rajneesh RJ Barfa";
employee.designationCode = 1;
employee.designation = "Manager";
employee.dateOfBirth = "21/01/0026";
employee.gender = "M";
employee.isIndian = true;
employee.basicSalary = 950000.00;
employee.panNumber = "RPL034";
employee.aadharCardNumber = "89635";
employees[3] = employee;
employee = new Employee()
employee.employeeId = "A100002";
employee.name = "Sachin Sonu Patel";
employee.designationCode = 5;
employee.designation = "Wrestler";
employee.dateOfBirth = "24/08/0020";
employee.gender = "M";
employee.isIndian = true;
employee.basicSalary = 300000.00;
employee.panNumber = "GNJ734";
employee.aadharCardNumber = "54125";
employees[4] = employee;
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