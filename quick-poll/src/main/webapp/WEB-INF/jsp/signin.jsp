<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Fomoland | Login</title>
<!-- meta tags for resposive -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- css links -->


<!-- CDN -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css" />
  <c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" /> 
<link rel="stylesheet" href="/css/main.css" />

 <link rel="stylesheet" type="text/css" href="/css/ionicons.min.css">
<link rel="stylesheet" type="text/css" href="/css/animated_delays.css"> 
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>
	<!-- js links -->
<script type="text/javascript" src="/js/init.js"></script>


</head>
<body class="indigo">
	<nav class="nav_n_shadow indigo darken-1">
		<div class="nav-wrapper container">
			<a class="brand-logo hide-on-med-and-down" href="#"
				data-activates="out-out">
				<!-- Fomoland navbar -->
				<i class="ion-android-menu"></i>
			</a>
			<a href="#" class="icon-touch button-collapse"
				data-activates="out-out">
				<i class="ion-android-menu"></i>
			</a>
		</div>
		<!-- side nav content -->
		<ul id="out-out" class="side-nav indigo">
			<li>
				<a href="#!" class="white-text">
					<i class="ion-ios-information"></i> About
				</a>
			</li>
			<li>
				<a href="#!" class="white-text">
					<i class="ion-ios-help"></i> F.A.Q.
				</a>
				</a>
			</li>
		</ul>
	</nav>
	<div class="container">
		<!-- logo image here -->
		<div class="center" style="height: 400px;">
			<img src="/img/fomoland.png"
				class=" center resposive-img fit_img animated flipInX" />
		</div>
		<div class="center container">
			<h6 class="white-text animated fadeInUp delay_2s">ONLY FOR WOMEN</h6>
		</div>
		<!-- log in button here -->
 		<form action="/signin/facebook" method="post">
			<div class="container">
				<div class="row">
					<div
						class="col s12 m12 l6 xl6 offset-xl3 offset-l3 center animated fadeInUp delay_1s">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<input type="hidden" name="scope" value="public_profile" />
						<button
							class="btn btn-large btn-large-round white red-text waves-effect">
							<i class="ion-social-facebook"></i> LOGIN WITH FACEBOOK
						</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>