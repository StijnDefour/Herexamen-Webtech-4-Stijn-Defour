<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>


<title>Joke</title>
</head>

<body>

<h1>Create Joke</h1>
<br/>
<form method=POST action='joke_post'>
 	<div>
		<label for='voorNaam'>Voornaam : </label>
   		<input type='text' class='form-control' name='voorNaam' id='voorNaam'>
 	</div>
	<div>
		<label for='achterName'>Achternaam : </label>
   		<input type='text' class='form-control' name='achterName' id='achterName'>
   	</div>
	    	
	<input type=SUBMIT value='Save'>
</form>

<br/><br/>

</body>
</html>