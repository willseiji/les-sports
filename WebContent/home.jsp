<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="assets/styles.css" rel="stylesheet" media="screen">
<link href="css2/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css2/slider.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">

<script type="text/javascript" src="js2/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js2/move-top.js"></script>
<script type="text/javascript" src="js2/easing.js"></script>
<script src="js2/easyResponsiveTabs.js" type="text/javascript"></script>
<script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>

<script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<div class="header_top">
				<div class="logo">
					<a href="home.jsp"><img src="images2/logo.png"
						alt="" /></a>
				</div>
				<div class="headertop_desc">
					<div class="account_desc">
						<ul>
							<li><a href="site-menu-carrinho.jsp"
								style="font-size: 15px">Carrinho</a></li>
							<li><a href="<%=request.getContextPath()%>/MeusPedidos" style="font-size: 15px">Meus
									Pedidos</a></li>
							<li><a href="<%=request.getContextPath()%>/MeusCupons" style="font-size: 15px">Meus
									Cupons</a></li>
							<li><a
								href="PreAlterarCliente?operacao=PREALTERAR&view=cliente"
								style="font-size: 15px">Minha Conta</a></li>
							<li><a href="login.jsp" style="font-size: 15px">Login</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		
		
		
		<div class="clear"></div>

		<div class="header_bottom2">
			<div class="menu">
				<ul>
					<li class="active"><a href="site_principal.html">Home</a></li>
					<li><a
						href="PesquisarProduto?operacao=PESQUISAR&txt_filtro=Calcados&view=cliente"
						style="font-size: 15px">Cal�ados</a></li>

					</li>
					<li><a href="delivery.html">Roupas</a>
						<ul class="dropdown">
							<li><a href="#">Agasalhos</a></li>
							<li><a href="#">Bermudas</a></li>
							<li><a href="#">Cal�as</a></li>
							<li><a href="#">Cal��es</a></li>
							<li><a href="#">Camisetas</a></li>
							<li><a href="#">Mai�s</a></li>
							<li><a href="#">Sungas</a></li>
							<li><a href="#">Uniformes</a></li>
						</ul></li>
					<li><a href="news.html">Acess�rios</a>
						<ul class="dropdown">
							<li><a href="#">Bolas</a></li>
							<li><a href="#">Bolsas</a></li>
							<li><a href="#">Capacetes</a></li>
							<li><a href="#">Luvas</a></li>
							<li><a href="#">Mochilas</a></li>
							<li><a href="#">�culos</a></li>
							<li><a href="#">Raquetes</a></li>
							<li><a href="#">Tornozeleiras</a></li>
						</ul></li>
					<li><a href="contact.html">Equipamentos</a>
						<ul class="dropdown">
							<li><a href="#">Bicicletas</a></li>
							<li><a href="#">Patins</a></li>
							<li><a href="#">Skate</a></li>
							<li><a href="#">Trampolins</a></li>
						</ul></li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="search_box">
				<form>
					<input type="text" value="Search" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search';}"><input
						type="submit" value="">
				</form>
			</div>
			<div class="clear"></div>
		</div>

		

		<div class="main">
			<div class="content">
				<div class="content_top">
					<div class="heading">
						<h3>Produtos � venda</h3>
					</div>

					<div class="clear"></div>
				</div>
					<form name="ListarProdutos" method="post">
				
				<c:forEach var="itemProdutos" items="${listaProdutos}" varStatus="loopCount">
					<c:if test="${not empty itemProdutos}" >


						<div class="section group">
							<div class="grid_1_of_4 images_1_of_4">
								<a href="preview.html"><img src="/images2/feature-pic1.jpg"
									alt="" /></a>
								<h2>${itemProdutos[2]}</h2>
								<div class="price-details">
									<div class="price-number">
										<p>
											<span class="rupees">${itemProdutos[6]}</span>
										</p>
									</div>
									<div class="add-cart">
										<h4>
											<a href="PreAlterarProduto?operacao=PREALTERAR&txt_IdProduto=<c:out value="${itemProdutos[0]}"/>&view=cliente">Comprar</a>
										</h4>
									</div>
									<div class="clear"></div>
								</div>
							</div>
							
						</div>
						
					</c:if>
				</c:forEach>
				</form>
				

			</div>
			<div class="footer">
				<div class="copy_right">
					<p>
						&copy; 2019 William S</a>
					</p>
				</div>
			</div>
			<script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
			<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

