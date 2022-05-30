<html>
<h1>
	<?php
	error_reporting(0);
	$error = array();
	function cleaninput($input)
	{
		foreach ($input as $key => $value) {
			$value = trim($value);
			$value = stripslashes($value);
			$value = htmlspecialchars($value);
		}
		return $input;
	}
	function validateinput($input)
	{
		if (!array_key_exists("gender", $input)) {
			$error["gender"] = "*Gender cannot be left blank";
		}
		if (!array_key_exists("hobby", $input)) {
			$error["hobby"] = "*Hobby cannot be left blank";
		}

		foreach ($input as $key => $value) {
			switch ($key) {
				case "usr":
					if (empty($value))
						$error["usr"] = "*Name cannot be left blank";

					break;

				case "email":
					if (!filter_var($value, FILTER_VALIDATE_EMAIL))
						$error["email"] = "*Email cannot be left blank";
					break;

				case "edu":
					if ($value == "--")
						$error["edu"] = "*Education cannot be empty";

					break;

				case "comment":
					if ($value=="")
						$error["comment"] = "*Comment cannot be left blank";
					break;
			}
		}
		//var_dump($error);
		return $error;
	}
	if (isset($_POST["submit-btn"])) {
		//var_dump($_POST);
		$cleandata = cleaninput($_POST);
		$error = validateinput($cleandata);
	}
	?>
</h1>

<body>
	<form action="main.php" method="post">
		<label>Enter name</label>
		<input type="text" name="usr"><br>
		<div style="color:red"><?php echo $error["usr"]; ?></div>

		<label>Enter email</label>
		<input type="text" name="email"><br>
		<div style="color:red"><?php echo $error["email"]; ?></div>

		<label for="edu">Education</label>
		<select id="edu" name="edu">
			<option value="--">--</option>
			<option value="hsc">HSC</option>
			<option value="sslc">SSLC</option>
			<option value="dip">Diplomo</option>
			<option value="be">B.E</option>
		</select>
		<div style="color:red"><?php echo $error["edu"]; ?></div>

		<label for="gender">Gender</label>
		<input type="radio" id="gender" name="gender" value="male">
		<label for="male">Male</label>
		<input type="radio" id="gender" name="gender" value="female">
		<label for="female">Female</label>
		<input type="radio" id="gender" name="gender" value="none">
		<label for="none">None</label>
		<div style="color:red"><?php echo $error["gender"]; ?></div>

		<label for="hobbies">Hobbies</label>
		<input type="checkbox" id="hobby" name="hobby" value="drawing">
		<label for="vehicle1">Drawing</label>
		<input type="checkbox" id="hobby" name="hobby" value="singing">
		<label for="vehicle2">Singing</label>
		<input type="checkbox" id="hobby" name="hobby" value="dancing">
		<label for="vehicle3">Dancing</label>
		<div style="color:red"><?php echo $error["hobby"]; ?></div>

		<label for="comment">Comment</label>
		<br>
		<textarea rows="4" cols="30" name="comment"></textarea>
		<div style="color:red"><?php echo $error["comment"]; ?></div>
		<br><br>
		<input type="submit" value="Register" name="submit-btn">
	</form>
</body>

</html>