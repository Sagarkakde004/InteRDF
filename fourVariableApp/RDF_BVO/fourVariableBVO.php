<?php
function getdataBVO() {
    $filePath = 'RDF_DATA/fourVariableData.json';
    if (!file_exists($filePath)) {
        return [
            'Value1' => 'No Value1 found',
            'Value2' => 'No Value2 found',
            'Value3' => 'No Value3 found',
            'Value4' => 'No Value4 found'
        ];
    }
    $json = file_get_contents($filePath);
    $data = json_decode($json, true);
    return [
        'Value1' => $data['Value1'] ?? 'No Value1 found',
        'Value2' => $data['Value2'] ?? 'No Value2 found',
        'Value3' => $data['Value3'] ?? 'No Value3 found',
        'Value4' => $data['Value4'] ?? 'No Value3 found'
    ];
}

function updateVariableValues($Value1, $Value2,$Value3,$Value4) {
    $filePath = '../RDF_DATA/fourVariableData.json';
    $data = [
        'Value1' => $Value1,
        'Value2' => $Value2,
        'Value3' => $Value3,
        'Value4' => $Value4
    ];
    return file_put_contents(
        $filePath, json_encode($data, JSON_PRETTY_PRINT)
    );
}
?>
