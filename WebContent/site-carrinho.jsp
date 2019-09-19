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
							<li><a href="site_meus_pedidos.html" style="font-size: 15px">Meus
									Pedidos</a></li>
							<li><a href="site_meus_cupons.html" style="font-size: 15px">Meus
									Cupons</a></li>
							<li><a
								href="PreAlterarCliente?txt_NmCodigo=PED00007&operacao=PREALTERAR&view=cliente"
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
						style="font-size: 15px">Calçados</a></li>

					</li>
					<li><a href="delivery.html">Roupas</a>
						<ul class="dropdown">
							<li><a href="#">Agasalhos</a></li>
							<li><a href="#">Bermudas</a></li>
							<li><a href="#">Calças</a></li>
							<li><a href="#">Calções</a></li>
							<li><a href="#">Camisetas</a></li>
							<li><a href="#">Maiôs</a></li>
							<li><a href="#">Sungas</a></li>
							<li><a href="#">Uniformes</a></li>
						</ul></li>
					<li><a href="news.html">Acessórios</a>
						<ul class="dropdown">
							<li><a href="#">Bolas</a></li>
							<li><a href="#">Bolsas</a></li>
							<li><a href="#">Capacetes</a></li>
							<li><a href="#">Luvas</a></li>
							<li><a href="#">Mochilas</a></li>
							<li><a href="#">Óculos</a></li>
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
				<h2>Detalhes do Produto</h2>
				<form name="carrinhoForm" method="post">
				<div class="section group">
					<div class="cont-desc span_1_of_2">
						<div class="product-details">
							<div class="grid images_3_of_2">
								<div id="container">
									<div id="products_example">
										<div id="products">
											<div>
												<a href="#" target="_blank"><img
													src="/les-codigo/WebContent/images2/productslide-10.jpg" alt=" " /></a>
											</div>

										</div>
									</div>
								</div>
							</div>
							<div class="desc span_2_of_2">
								<h2>${itensProduto[2]}</h2>
								<p>Material: ${itensProduto[4]}</p>
								<p>Tamanho: ${itensProduto[5]}</p>
								<p>Peso: ${itensProduto[6]} g</p>
								<p>Fabricante: ${itensProduto[7]}</p>
								<br>
								<div class="price">
									<h4>
										Preço Total: R$ <span id="pc_total"></span>
									</h4>
								</div>
								<div class="available">
									<p>Código : ${itensProduto[1]}</p>
									<p>
										Preço Unitário : R$ <input id="pc_unit"
											value="${itensProduto[8]}" readonly />
									</p>
									<p>
										Quantidade : <input type="number" id="qtdeItens" min="1" value="1"
											onclick="calculate()">
									</p>

								</div>
								
								<input type="hidden" id="inputItens" name="txt_Itens" value="">
								<input type="hidden" id="inputPrecoTotal" name="txt_PrecoTotal" value="">
								<input type="hidden" name="operacao" value="SALVAR">
								<div class="share-desc">
									
									<button type="submit" class="btn btn-primary" formaction="AdicionarCarrinho" onclick="enviarURL()" name ="txt_IdProduto" value=${itensProduto[0]}>Adicionar</button>
										
									<div class="clear"></div>
								</div>

							</div>
							<div class="clear"></div>
						</div>
						<div class="product_desc">
							<div id="horizontalTab">
								<ul class="resp-tabs-list">
									<li>Product Details</li>

									<div class="clear"></div>
								</ul>
								<div class="resp-tabs-container">
									<div class="product-desc">
										<p>${itensProduto[10]}</p>
									</div>
								</div>

							</div>
						</div>
					</div>


				</div>
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
	    $(document).ready(function () {
	        $('#horizontalTab').easyResponsiveTabs({
	            type: 'default', //Types: default, vertical, accordion           
	            width: 'auto', //auto or any width like 600px
	            fit: true   // 100% fit in a container
	        });
	    });
   	</script>

	<script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>

	<script>
        function calculate() {
            var myPc_unit = document.getElementById('pc_unit').value; 
            var myQtde = document.getElementById('qtdeItens').value;
            var myResult = myPc_unit * myQtde;
            document.getElementById('pc_total').innerHTML = myResult;
            
        }
        window.load=calculate();
    </script>
    <script>
    	function enviarURL(){
    		var myPc_unit = document.getElementById('pc_unit').value; 
            var myQtde = document.getElementById('qtdeItens').value;
            var myResult = myPc_unit * myQtde;
            
    		document.getElementById('inputItens').value = myQtde;
            document.getElementById('inputPrecoTotal').value = myResult;
        	}

    </script>
    
    

			<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

