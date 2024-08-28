<!-- Connecting BVO to UI -->
<?php 
    include "RDF_BVO/fourVariableBVO.php";
    $variables = getdataBVO();
?>
<!-- Ends -->

<!-- The UI -->

<h2 style="text-align: center; font-family: 'Arial', sans-serif; color: #4A4A4A; font-weight: 600; margin-bottom: 20px;">Contact Details</h2>
<form>
    <table class="section" style="width: 100%; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
        <tr>
            <td style="padding: 10px; vertical-align: top;">
                <label for="newValue1" style="font-weight: 600; color: #333; display: block; margin-bottom: 5px;">Your Address</label>
                <input type="text" id="newValue1" name="newValue1" style="width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ccc; box-shadow: inset 0 2px 4px rgba(0,0,0,0.1); transition: border-color 0.3s;">
            </td>
        </tr>
        <tr>
            <td style="padding: 10px; vertical-align: top;">
                <label for="newValue2" style="font-weight: 600; color: #333; display: block; margin-bottom: 5px;">Pin Code</label>
                <input type="number" id="newValue2" name="newValue2" style="width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ccc; box-shadow: inset 0 2px 4px rgba(0,0,0,0.1); transition: border-color 0.3s;">
            </td>
        </tr>
        <tr>
            <td style="padding: 10px; vertical-align: top;">
                <label for="newValue3" style="font-weight: 600; color: #333; display: block; margin-bottom: 5px;">Mobile NO</label>
                <input type="number" id="newValue3" name="newValue3" style="width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ccc; box-shadow: inset 0 2px 4px rgba(0,0,0,0.1); transition: border-color 0.3s;">
            </td>
        </tr>
        <tr>
            <td style="padding: 10px; vertical-align: top;">
                <label for="newValue4" style="font-weight: 600; color: #333; display: block; margin-bottom: 5px;">Email ID</label>
                <input type="email" id="newValue4" name="newValue4" style="width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ccc; box-shadow: inset 0 2px 4px rgba(0,0,0,0.1); transition: border-color 0.3s;">
            </td>
        </tr>
        <tr>
            <td style="text-align: center; padding: 20px;">
                <button type="button" onclick="updateVarAction()" style="background-color: #007bff; color: white; padding: 12px 25px; border-radius: 5px; border: none; font-size: 16px; font-weight: 600; cursor: pointer; transition: background-color 0.3s;">
                    Update Details
                </button>
            </td>
        </tr>
    </table>
</form>

<h2 style="font-family: 'Arial', sans-serif; color: #4A4A4A; font-weight: 600; margin-top: 30px;">Current Values from the Database</h2>
<h3 style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #555;">Value 1: <?php echo $variables['Value1']; ?></h3>
<h3 style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #555;">Value 2: <?php echo $variables['Value2']; ?></h3>
<h3 style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #555;">Value 3: <?php echo $variables['Value3']; ?></h3>
<h3 style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #555;">Value 4: <?php echo $variables['Value4']; ?></h3>

<script src="RDF_ACTION/updateVarAction.js"></script>

