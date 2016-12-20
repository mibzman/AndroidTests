<?php 
//http://localhost:8080/sample1/webservice2.php?json={%22UserName%22:1,%22FullName%22:2}
//$json=$_GET ['json'];
$json = file_get_contents('php://input');
$obj = json_decode($json);

//echo $json;


//Save
$con = mysql_connect('localhost','dcsoft6_ChatUser','R47kBF4(=EB7') or die('Cannot connect to the DB');
mysql_select_db('dcsoft6_test',$con);

  /* grab the posts from the db */
  //$query = "SELECT post_title, guid FROM wp_posts WHERE post_author = $user_id AND post_status = 'publish' ORDER BY ID DESC LIMIT $number_of_posts";
  $query = "update  dcsoft6_test.userstricolin set personaje = " .$obj->{'Personaje'}. ", color = " .$obj->{'Color'}. " where iduserstricolin = " .$obj->{'Iduserstricolin'}. ";";

if (mysql_query( $query))
$ban = true;
else
$ban = false;


mysql_close($con);
//
  //$posts = array($json);
  $posts = array(5);
    header('Content-type: application/json');
	
	if ($ban)
    echo json_encode("Usuario Modificado");
	else
	echo json_encode("No se pudo Modificar");
?>
