<?php
session_start();
require_once 'connect.php';
    $response = array();
     $nimm = $_SESSION['nimnya'];
 
    $sql = "SELECT * FROM mahasiswa WHERE nim = '1702058';";
    $statement = mysqli_prepare($conn, $sql);

    $query = mysqli_query($conn, $sql);

    mysqli_stmt_execute($statement);
  while($baris = mysqli_fetch_assoc($query)){
$data = array();
array_push($data, $baris);
}
$response['data'] = $data;
  echo json_encode($response);
mysqli_close($conn);

?>