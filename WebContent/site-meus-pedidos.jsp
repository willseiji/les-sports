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
					<a href="site_principal.html"><img src="images2/logo.png"
						alt="" /></a>
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




		<div class="container-fluid" style="width: 1400px">
            <div class="row-fluid">
                <!--/span-->
                <div class="span9" id="content">
                      <!-- morris stacked chart -->
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Pedidos</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                         
                                 <fieldset>
                                    <legend>Meus Pedidos</legend>
                                        
  									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="myTable">
										<thead>
											<tr>
												<th>Cod.Pedido</th>
												<th>Cliente</th>
												<th>Data Pedido</th>
												<th>Valor Total</th>
												<th>Status</th>
												<th>A��o</th>
											</tr>
										</thead>
										<c:forEach var="itensPedido" items="${listaPedidos}">
											<c:if test="${not empty itensPedido}">
											<tr class="odd gradeX"  onclick="myFunctionName(this)">
											<td style="display:none" id="id_pedido">${itensPedido[0]}</td>
                                                <td><a style="text-decoration: underline"><span id="id_codigo">${itensPedido[1]}</span></a></td>
                                                <td>${itensPedido[2]}</td>
                                                <td>${itensPedido[3]}</td>
												<td>${itensPedido[4]}</td>
												<td>${itensPedido[5]}</td>
												<input type="hidden" id="myInputPedido" name="txt_IdPedido" value="">
												<input type="hidden" name="view" value="cliente">
												<td><button type  ="submit" class="btn btn-warning btn-mini" name="operacao" formaction="PreAlterarPedido" id="bttAlterar"
												 
                                    			value="PREALTERAR">Visualizar</button>
                                                    
                                                </td>
											</tr>
											
                            			</c:if>
                            		</c:forEach>
									</table>
                                         </fieldset>
                                         
                                         
            
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>


                </div>
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

	<script>
        function myFunctionName(x) {
            var myTable = document.getElementById('myTable');
            var r = x.rowIndex;
            var codPedido = myTable.rows[r].cells[0].innerText;
            document.getElementById("myInputPedido").value = codPedido;
            
        }
    </script>
    <script>
        var mensagem = '${msg}';
        if (mensagem.length !== 0) {
            alert(mensagem);
        }
    </script>
    
        
        
    

			<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

