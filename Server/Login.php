<?php


$con = mysqli_connect("localhost", "id2147763_flo", "79835458", "id2147763_test");

$username = $_POST["username"];
$password = $_POST["password"];

$statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?");
mysqli_stmt_bind_param($statement,"ss", $username, $password);
mysqli_stmt_execute($statement);

mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement, $userId, $username, $email, $employeeNumber, $password);

$response = array();
$response["success"] = false;

while(mysqli_stmt_fetch($statement))
{
    $response["success"] = true;

    $response["username"] = $username;
    $response["email"] = $email;
    $response["employeeNumber"] = $employeeNumber;
    $response["password"] = $password;

}

echo json_encode($response);

?>