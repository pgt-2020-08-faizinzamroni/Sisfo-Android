<?php
session_start();
require_once 'connect.php';
    $nim = $_SESSION['nimnya'];
    $mat= $_POST['matkul'];
    $sem= $_POST['semester'];
    $a= $_POST['a'];
    $b = $_POST['b'];
    $c = $_POST['c'];
    $d = $_POST['d'];
    $e = $_POST['e'];

 $sql1 ="UPDATE $sem SET status_mk = '1' WHERE nim = '$nim';";
   $statement1 = mysqli_prepare($conn, $sql1);

   mysqli_stmt_execute($statement1);

    $sql = "INSERT INTO evaluasi_dosen(id, nama, mata_kuliah, tahun, nim, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, b1, b2, b3, b4, b5, b6, b7, b8, b9, c1, c2, c3, c4, d1, d2, d3, d4, d5, d6) VALUES (NULL,'','$mat','','$nim','$a','$b','$c','$d','$e','','','','','','','','','','','','','','','','','','','','','','','','','');";
    $statement = mysqli_prepare($conn, $sql);
   
   mysqli_stmt_execute($statement);

  

   $response = array();
   $response["success"] = "Data Berhasil Dimasukkan!";

   echo json_encode($response);

?>