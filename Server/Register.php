<?php

$con = mysqli_connect("localhost", "id2147763_flo", "79835458", "id2147763_test");

$username = $_POST["username"];
$email = $_POST["email"];
$employeeNuner = $_POST["employeeNumber"];
$password = $_POST["password"];

$statement = mysqli_prepare($con, "INSERT INTO user (username, email, employeeNumber, password) VALUES (?, ?, ?, ?)");
mysqli_stmt_bind_param($statement, "ssss", $username, $email, $employeeNuner, $password);
mysqli_stmt_execute($statement);

$response = array();
$response["success"] = true;

echo json_encode($response);
?>