<?php
include("../RDF_BVO/fourVariableBVO.php");

if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET["Value1"]) && isset($_GET["Value2"])&& isset($_GET["Value3"])&& isset($_GET["Value4"])) 
    {
    $Value1 = $_GET["Value1"];
    $Value2 = $_GET["Value2"];
    $Value3 = $_GET["Value3"];
    $Value4 = $_GET["Value4"];
    updateVariableValues($Value1, $Value2,$Value3,$Value4);
}

// Redirect to the UI
header('Location: ../RDFView.php?ui=fourVariableAppUI');
exit();
?>
