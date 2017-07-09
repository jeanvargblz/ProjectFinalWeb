<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Ingreso</title>
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="223918648963-htbfa503sudt64gekqen5617fbu84n05.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>
<meta charset="utf-8">

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="bootstrap/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="navbar.css" rel="stylesheet">

<meta charset=UTF-8>
<title>Registrate</title>
<link rel="stylesheet" type="text/css" href="css/estilo1.css">
<link rel="shortout icon" href="img/logoP.ico" />
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Opciones de Navegación</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="./">Default <span
							class="sr-only">(current)</span></a></li>
					<li><a href="../navbar-static-top/">Static top</a></li>
					<li><a href="../navbar-fixed-top/">Fixed top</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>
	<div class="container">
		<h2>Ingreso</h2>
		<br>
		<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
		<script type="text/javascript">
			function onSignIn(googleUser) {
				// Useful data for your client-side scripts:
				var profile = googleUser.getBasicProfile();
				
				console.log("ID: " + profile.getId()); // Don't send this directly to your server!
				console.log('Full Name: ' + profile.getName());
				console.log('Given Name: ' + profile.getGivenName());
				console.log('Family Name: ' + profile.getFamilyName());
				console.log("Image URL: " + profile.getImageUrl());
				console.log("Email: " + profile.getEmail());

				// The ID token you need to pass to your backend:
				var id_token = googleUser.getAuthResponse().id_token;
				console.log("ID Token: " + id_token);
				var redirectUrl = '/gmail';

				//using jquery to post data dynamically
				var form = $('<form action="' + redirectUrl + '" method="POST">'
						+ '<input type="text" name="id_token" value="'
						+ googleUser.getAuthResponse().id_token
						+ '" />'
						+ '</form>');
				$('body').append(form);
				form.submit();
			};
		</script>
		<br> <a href="http://1-dot-projectfinalweb-20130882.appspot.com"
			onclick="signOut();">Sign out</a>
		<script>
			function signOut() {
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					console.log('User signed out.');
				});
			}
		</script>
	</div>
	<!-- /container -->
<br>
		
	<div id="footer">
		<div id="fleft">
		<a href="http://www.unsa.edu.pe"><img alt="UNSA" src="/img/unsa.png"></a>
		<a href="http://www.ucsm.edu.pe"><img alt="UCSM" src="/img/ucsm.png"></a>
		<a href="http://www.unsp.edu.pe"><img alt="UNSP" src="/img/ucsp.gif"></a>
		<a href="http://www.utpaqp.edu.pe"><img alt="UTP" src="/img/utp.gif"></a>
		<a href="http://www.uap.edu.pe"><img alt="UAP" src="/img/uap.gif"></a>
		</div>
		<div id="fcenter">
		Santa Marta 209 (Frente a la comisaría) - Cercado - Arequipa<br>Teléfono: (054)22-3334 RPC: 959744594 RPM: #948000103
		</div>
		<div id="fright">
		<a href="http://www.facebook.com/academiabryce.pe"><img alt="FACEBOOK" src="/img/fb.png"></a>
		<a href="http://twitter.com/bryceacademia"><img alt="TWITTER" src="/img/tw.ico"></a>
		<a href="http://plus.google.com/112013871280102532906"><img alt="GOOGLE" src="/img/gp.png"></a>
		<a href="http://www.youtube.com/channel/UCf8ZsJCjPgExnOYIJZ--HKQ/featured"><img alt="YOUTUBE" src="/img/yt.png"></a>
		<a href="http://academiabryce.blogspot.com/"><img alt="BLOG" src="/img/bs.png"></a>
		</div>
	</div>
	<div id="final">
		<br><br><br>Copyright ⓒ 2015 Grupo Bryce - All Rights Reserved <br><br> Developments: <strong>Jean Franco Vargas Belizario</strong>
	</div>	
</body>
</html>