<?php
session_start();
require_once 'connect.php';
    $response = array();
    $pass = $_POST['password'];
    $nimm = $_POST['nim'];
    $_SESSION["nimnya"] = "$nimm";
 
    $sql = "SELECT * FROM mahasiswa WHERE nim = '$nimm';";
    $statement = mysqli_prepare($conn, $sql);

    $query = mysqli_query($conn, $sql);

    $baris = mysqli_fetch_assoc($query);

    mysqli_stmt_execute($statement);

   if($baris['password'] == $pass){
   $response["kon"] = "1";
   $response["success"] = "Login Sukses!";
}else{
   $response["kon"] = "2";
   $response["success"] = "Login Gagal!";
}
   echo json_encode($response);
?>