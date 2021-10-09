<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/9/2021
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add coupon</title>
</head>
<body>
<a href="adminMainMenu" style="float: right;">Back to menu</a>
<p align = "center" style="font-size: 30px;"><b><i>Add coupon</i></b></p>
<form action="setCoupon">
    <Table border="1px" align = "center" style="width: 100%;">
        <thead>
        <th>Code</th>
        <th>Begin date</th>
        <th>Finish date</th>
        <th>Percent</th>
        </thead>
        <tbody>
        <tr>
            <td>
                <input type="text" name="code" style="width: 97%;" placeholder="Enter the code" required>
            </td>
            <td>
                <input type="date" style="width: 98%;" name="beginDate" required>
            </td>
            <td>
                <input type="date" style="width: 98%;" name="finishDate" required>
            </td>
            <td>
                <input type="number" style="width: 97%;" name="percent" required>
            </td>
        </tr>
        </tbody>
    </Table>
    <br>
    <br>
    <input type="submit" style="margin-left: 600px;width: 200px;height: 40px;">
</form>
</body>
</html>