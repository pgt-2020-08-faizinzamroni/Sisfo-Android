<?php

require_once 'connect.php';

    $nama = $_POST['name'];
    $kelas = $_POST['kelas'];
    $nim = $_POST['nim'];
    $tempat_lahir = $_POST['tempat'];
    $tanggal_lahir = $_POST['tanggal'];
    $pembimbing = $_POST['pembimbing'];
    $program_studi = $_POST['program'];

    $sql = "UPDATE mahasiswa SET nim='$nim',nama='$nama',program_studi='$program_studi',tempat_lahir='$tempat_lahir',tanggal_lahir='$tanggal_lahir',kelas='$kelas',pembimbing='$pembimbing' WHERE nim = '$nim';";
    $statement = mysqli_prepare($conn, $sql);

   mysqli_stmt_execute($statement);

   $response = array();
   $response["success"] = "Login Sukses!";

   echo json_encode($response);

?>