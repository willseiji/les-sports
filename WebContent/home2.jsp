<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="assets/styles.css" rel="stylesheet" media="screen">
<link href="css2/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css2/slider.css" rel="stylesheet" type="text/css" media="all"/>
            <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">

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
				<a href="site_principal.html"><img src="images2/logo.png" alt="" /></a>
			</div>
            <div class="headertop_desc">
			<div class="account_desc">
				<ul>
                    <li><a href="site_menu_carrinho.html" style="font-size: 15px">Carrinho</a></li>
					<li><a href="site_meus_pedidos.html" style="font-size: 15px">Meus Pedidos</a></li>
                    <li><a href="site_meus_cupons.html" style="font-size: 15px">Meus Cupons</a></li>
					<li><a href="PreAlterarCliente?txt_NmCodigo=PED00007&operacao=PREALTERAR&view=cliente" style="font-size: 15px">Minha Conta</a></li>
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
			    	<li><a href="PesquisarProduto?operacao=PESQUISAR&txt_filtro=Calcados&view=cliente" style="font-size: 15px">Calçados</a></li>
                        
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
				        </ul>
					</li>
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
				        </ul>
                    </li>
			    	<li><a href="contact.html">Equipamentos</a>
                        <ul class="dropdown">
                            <li><a href="#">Bicicletas</a></li>
                            <li><a href="#">Patins</a></li>
                            <li><a href="#">Skate</a></li>
				            <li><a href="#">Trampolins</a></li>
				        </ul>
                    </li>
			    	<div class="clear"></div>
     			</ul>
	     	</div>
	     	<div class="search_box">
	     		<form>
	     			<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
	     		</form>
	     	</div>
	     	<div class="clear"></div>
	     </div>	     
	
   
    
    
 <div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>Produtos à venda</h3>
    		</div>
    		
    		<div class="clear"></div>
    	</div>
	      <div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview.html"><img src="images2/feature-pic1.jpg" alt="" /></a>
					 <h2>Agasalho Corinthians </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$300,00</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="site_carrinho.html">Comprar</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
					 
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="images2/feature-pic2.jpg" alt="" /></a>
					 <h2>Luvas de Goleiro </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$100,00</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="site_carrinho.html">Comprar</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				    
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="images2/feature-pic3.jpg" alt="" /></a>
					 <h2>Tênis Nike </h2>
					 <div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$250,00</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="site_carrinho.html">Comprar</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="images2/feature-pic4.jpg" alt="" /></a>
					 <h2>Raquete Tênis </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$140,00</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="site_carrinho.html">Comprar</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>				     
				</div>
              
              <div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview.html"><img src="images2/feature-pic5.jpg" alt="" /></a>
					 <h2>Chuteira Nike</h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$230,00</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="site_carrinho.html">Comprar</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
					 
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="images2/feature-pic6.jpg" alt="" /></a>
					 <h2>Uniforme Barcelona </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$125,00</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="preview.html">Comprar</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				    
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="images2/feature-pic7.jpg" alt="" /></a>
					 <h2>Luvas de Boxe Adidas </h2>
					 <div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$90,00</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="site_carrinho.html">Comprar</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="images2/feature-pic8.jpg" alt="" /></a>
					 <h2>Bola de Fut. Adams </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$50,00</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="site_carrinho.html">Comprar</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>				     
				</div>
              
              
			</div>
		
 
</div>
   <div class="footer">
        <div class="copy_right">
				<p>&copy; 2019 William S</a></p>
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

