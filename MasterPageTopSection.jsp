<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
<my:Guard>
    <jsp:forward page="/LoginForm.jsp"/>
</my:Guard>
<jsp:useBean id="administratorBean" scope="request" class="com.thinking.machines.hr.beans.AdministratorBean" />
    <!DOCTYPE html>
    <html lang='en'>

    <head>
        <meta charset='UTF-8'>
        <title>Style Two</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/styletwo/css/styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/2b699f61f9.js" crossorigin="anonymous"></script>
    </head>

    <body>
        <!--main content box starts-->
        <div class="main-container">
            <!--header content box starts-->
            <div class="header">
                <!--<a href='/styleone/index.html'><img src='https://thinkingmachines.in/assets/images/logo/tm.png' class="logo"></a>-->
                <div class="brand-name"> <span>Human Resource</span></div>
                <div class="user-name">
                    <i class="fa-regular fa-user"></i>
                    ${username}&nbsp;
                    <a href='/styletwo/logout' style="text-decoration: none;color: red;margin: 5px;">Logout <i class="fa fa-sign-out"></i></a>
                </div>
            </div>
            <!--mid box content box starts-->
            <div class="content">
                <!--left panel Starts-->
                <div class='content-left-panel'>
                    <my:If condition='${module == DESIGNATION}'>
                        <b>Designation</b><br>
                    </my:If>
                    <my:If condition='${module != DESIGNATION}'>
                        <a href="/styletwo/Designations.jsp">Designation</a><br>
                    </my:If>
                    <my:If condition='${module == EMPLOYEE}'>
                        <b>Employee</b><br>
                    </my:If>
                    <my:If condition='${module != EMPLOYEE}'>
                        <a href="/styletwo/Employees.jsp">Employee</a><br>
                    </my:If>
                    <my:If condition='${module == HOME}'>
                        <b>Home</b><br>
                    </my:If>
                    <my:If condition='${module != HOME}'>
                        <a href="/styletwo/index.jsp">Home</a><br>
                    </my:If>
                </div>
                <!--Left panel ends-->
                <!--right panel Starts-->
                <div class="content-right-panel">