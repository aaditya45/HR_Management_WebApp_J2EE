function validateEmployee(frm) {
    var valid = true
    var firstInvalidComponent = null
    var name = frm.name.value.trim()
    var nameErrorSection = document.getElementById('nameErrorSection')
    nameErrorSection.innerHTML = ' '
    if (name.length == 0) {
        nameErrorSection.innerHTML = '  Name Required'
        firstInvalidComponent = frm.name
        valid = false
    }
    var designationCode = frm.designationCode.value
    var designationCodeErrorSection = document.getElementById('designationCodeErrorSection')
    designationCodeErrorSection.innerHTML = ' '
    if (designationCode == -1) {
        designationCodeErrorSection.innerHTML = '  Please Select a designation'
        valid = false
        if (firstInvalidComponent == null) firstInvalidComponent = designationCode
    }
    var dateOfBirthErrorSection = document.getElementById('dateOfBirthErrorSection')
    dateOfBirthErrorSection = ' '
    if (frm.dateOfBirth.value.length == 0) {
        dateOfBirthErrorSection.innerHTML = '  Please select the date of birth'
        valid = false
        if (firstInvalidComponent == null) firstInvalidComponent = frm.dateOfBirth
    }
    var genderErrorSection = document.getElementById('genderErrorSection')
    genderErrorSection = ' '
    if (frm.gender[0].checked == false && frm.gender[1].checked == false) {
        genderErrorSection.innerHTML = '  Please select a gender'
        valid = false
    }
    var basicSalaryErrorSection = document.getElementById('basicSalaryErrorSection')
    basicSalaryErrorSection.innerHTML = ' '
    if (frm.basicSalary.value.trim().length == 0) {
        basicSalaryErrorSection.innerHTML = '  Please Enter Basic Salary'
        valid = false
        if (firstInvalidComponent == null) firstInvalidComponent = frm.basicSalary
    } else {
        var v = '1234567890.'
        var e = 0
        var isBasicSalaryValid = true
        while (e < frm.basicSalary.value.trim().length) {
            if (v.indexOf(frm.basicSalary.value.trim().charAt(e)) == -1) {
                basicSalaryErrorSection.innerHTML = '  Invalid basic Salary'
                valid = false
                if (firstInvalidComponent == null) firstInvalidComponent = frm.basicSalary
                isBasicSalaryValid = false
                break
            }
            e++
        }
    }
    if (isBasicSalaryValid) {
        var dot = frm.basicSalary.value.trim().indexOf('.')
        if (dot != -1) {
            var numberOfFractions = frm.basicSalary.value.trim().length - (dot + 1)
            if (numberOfFractions > 2) {
                basicSalaryErrorSection.innerHTML = '  Please Fill only two digits after .'
                valid = false
                if (firstInvalidComponent == null) firstInvalidComponent = frm.basicSalary
            }
        }
    }
    var panNumber = frm.panNumber.value.trim();
    var panNumberErrorSection = document.getElementById('panNumberErrorSection');
    panNumberErrorSection.innerHTML = '';
    if (panNumber.length == 0) {
        panNumberErrorSection.innerHTML = 'PAN Number required';
        valid = false;
        if (firstInvalidComponent == null) firstInvalidComponent = frm.panNumber;
    }
    var aadharCardNumber = frm.aadharCardNumber.value.trim();
    var aadharCardNumberErrorSection = document.getElementById('aadharCardNumberErrorSection');
    aadharCardNumberErrorSection.innerHTML = '';
    if (aadharCardNumber.length == 0) {
        aadharCardNumberErrorSection.innerHTML = ' Aadhar Card Number required';
        valid = false;
        if (firstInvalidComponent == null) firstInvalidComponent = frm.aadharCardNumber;
    }
    if (!valid) firstInvalidComponent.focus()
    return valid
}
function cancelButton() {
    document.getElementById('cancelAdditionForm').submit();
}