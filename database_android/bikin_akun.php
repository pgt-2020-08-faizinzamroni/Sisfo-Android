<?php

require_once 'connect.php';

    $password = $_POST['password'];
    $nim = $_POST['nim'];

    $sql = "INSERT INTO mahasiswa(nim, nama, jenis_kelamin, program_studi, tempat_lahir, tanggal_lahir, tahun_masuk, status, kelas, password, pembimbing, jabatan) VALUES ('$nim', '', '', '', '', '', '', '1', '', '$password', '', '');";
    $statement = mysqli_prepare($conn, $sql);

   mysqli_stmt_execute($statement);

   $response = array();
   $response["success"] = "Akun Berhasil Dibuat!";

   echo json_encode($response);

?>