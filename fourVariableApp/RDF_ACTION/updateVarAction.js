// Action Called Here
function updateVarAction() {
    const newValue1 = document.getElementById('newValue1').value;
    const newValue2 = document.getElementById('newValue2').value;
    const newValue3 = document.getElementById('newValue3').value;
    const newValue4 = document.getElementById('newValue4').value;

    alert("Variables are updated in JSON");
    
    // Connecting Action to the Business Workflow (BW)
    const URLtoBW = "RDF_BW/updateVarBW.php?Value1=" + newValue1 + "&Value2=" + newValue2 +"&Value3=" + newValue3+"&Value4=" + newValue4;
   
    window.location.href = URLtoBW;
}
