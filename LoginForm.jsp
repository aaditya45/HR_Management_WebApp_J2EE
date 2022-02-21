<jsp:useBean id="errorBean" class="com.thinking.machines.hr.beans.ErrorBean" scope="request" />
<jsp:useBean id="administratorBean" class="com.thinking.machines.hr.beans.AdministratorBean" scope="request" />

<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset='UTF-8'>
    <title>Style Two</title>
    <link rel="stylesheet" type="text/css" href="/styletwo/css/styles.css">
</head>

<body>
    <!--main content box starts-->
    <div class="main-container">
        <!--header content box starts-->
        <div class="header">
            <!--<a href='/styleone/index.html'><img src='https://thinkingmachines.in/assets/images/logo/tm.png'
                    class="logo"></a>-->
            <div class="brand-name"><span>Human Resource</span></div>
        </div>
        <!--mid box content box starts-->
        <div class="content">
            <center>
                <div class="card">
                    <center>
                        <h2>Login Page</h2><br>
                        <td colspan="2"><span class="error">${errorBean.error}</span></td>
                        <form action="/styletwo/Login.jsp" method="post">
                            <table>
                                <tr>
                                    <td>Username</td>
                                    <td><input style="padding:5px;" type="text" id="userName" name="username"></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input style="padding:5px;" type="password" id="password" name="password"></td>
                                </tr>
                                <tr>
                                    <td colspan='2'><button type="submit" id="btn">LogIn</button></td>
                                </tr>
                            </table>
                        </form>
                    </center>
                </div>
            </center>
                


            <jsp:include page="/MasterPageBottomSection.jsp" />