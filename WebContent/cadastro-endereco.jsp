<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<head>
<title>Free Home Shoppe Website Template | Preview :: w3layouts</title>
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



<link href="css2/easy-responsive-tabs.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="stylesheet" href="css/global.css">

<script src="js2/slides.min.jquery.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<div class="header_top">
				<div class="logo">
					<a href="home.jsp"><img src="images2/logo.png" alt="" /></a>
				</div>
				<div class="headertop_desc">
					<div class="account_desc">
						<ul>
							<li><a href="site_menu_carrinho.html"
								style="font-size: 15px">Carrinho</a></li>
							<li><a href="site_meus_pedidos.html" style="font-size: 15px">Meus
									Pedidos</a></li>
							<li><a href="site_meus_cupons.html" style="font-size: 15px">Meus
									Cupons</a></li>
							<li><a href="login.html" style="font-size: 15px">Minha
									Conta</a></li>

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
					<li><a href="about.html">Calçados</a>
						<ul class="dropdown">
							<li><a href="#">Botas</a></li>
							<li><a href="#">Chuteiras</a></li>
							<li><a href="#">Meias</a></li>
							<li><a href="#">Tênis</a></li>
						</ul></li>
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
			<div class="clear"></div>
		</div>


		<div class="main">
			<div class="content">


				<div class="section group">

					<form class="form-horizontal">
						<fieldset>
							<div class="control-group">
								<label class="control-label" for="focusedInput">Rua</label>
								<div class="controls">
									<input class="input-xlarge focused" name="txt_Rua" id="id_Rua"
										type="text" value="">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput">Número</label>
								<div class="controls">
									<input class="input-xlarge focused" name="txt_EnderecoNum"
										id="id_EnderecoNum" type="text" value="">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput">Complemento</label>
								<div class="controls">
									<input class="input-xlarge focused" name="txt_Complemento"
										id="id_Complemento" type="text" value="">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput">Bairro</label>
								<div class="controls">
									<input class="input-xlarge focused" name="txt_Bairro"
										id="id_Bairro" type="text" value="">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput">CEP</label>
								<div class="controls">
									<input class="input-xlarge focused" name="txt_CEP" id="id_CEP"
										type="text" value="">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput">Cidade</label>
								<div class="controls">
									<input class="input-xlarge focused" name="txt_Cidade"
										id="id_Cidade" type="text" value="">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput">Estado</label>
								<div class="controls">
									<input class="input-xlarge focused" name="txt_Estado"
										id="id_Estado" type="text" value="">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Tipo de Endereço</label>
								<div class="controls">
									<select name="txt_TipoEndereco" id="id_TipoEndereco">
										<option value=""></option>
										<option value="entrega">Entrega</option>
										<option value="cobranca">Cobrança</option>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="optionsCheckbox">Endereço
									Principal</label>
								<div class="controls">
									<label class="uniform"> <input class="uniform_on"
										type="checkbox" id="optionsCheckbox" value="option1">

									</label>
								</div>
							</div>

							<div class="form-actions">
								<button type="submit" class="btn btn-primary" name="operacao"
									formaction="CadastrarEndereco" value="SALVAR">Salvar</button>
								<button type="button" class="btn">Cancelar</button>
							</div>


						</fieldset>


					</form>


				</div>
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


			<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

