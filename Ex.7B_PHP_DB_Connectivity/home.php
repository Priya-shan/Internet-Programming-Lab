<html>
    <body>
    <?php
        error_reporting(0);
        $error = array();
        if (isset($_POST["submit-btn"])) {
            $uname=$_POST["usr"];
            $pw=$_POST["pw"];
            $conn=new mysqli("localhost","root","","login");
            if($conn->connect_error){
                die("connection failed : ".$conn->connect_error);
            }
            $sql="SELECT password from student where username='".$uname."'";
            $result=$conn->query($sql);
            if($result->num_rows>0){
                while($row=$result->fetch_assoc()){
                    $crtpw=$row["password"];
                }
            }
            else{
                echo "0 results";
            }
            if(strcmp($pw,$crtpw)==0){
                echo "<h2>login successful....Welcome Champ !!!</h2>";
            }
            else{
                echo "<h2>login not successful</h2>";
            }

        }
        ?>
    </body>
</html>