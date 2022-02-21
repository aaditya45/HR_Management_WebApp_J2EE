<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <td>S no.</td>
                <td>Designations</td>
            </tr>
        </thead>
        <tbody>
            <my:Designations>
                <tr>
                    <td>${serialNumber}</td>
                    <td>${designationBean.title}</td>
                </tr>
            </my:Designations>
        </tbody>
    </table>
</body>
</html>