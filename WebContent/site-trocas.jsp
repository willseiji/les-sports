<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<head>
<title>Free Home Shoppe Website Template | Preview :: w3layouts</title>
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
    
    
    
<link href="css2/easy-responsive-tabs.css" rel="stylesheet" type="text/css" media="all"/>
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
                    <li><a href="site_menu_carrinho.html" style="font-size: 15px">Carrinho</a></li>
					<li><a href="site_meus_pedidos.html" style="font-size: 15px">Meus Pedidos</a></li>
                    <li><a href="site_meus_cupons.html" style="font-size: 15px">Meus Cupons</a></li>
					<li><a href="login.html" style="font-size: 15px">Minha Conta</a></li>
                    
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
				        </ul>
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
	     	<div class="clear"></div>
	     </div>	     
	
    
 <div class="main">
    <div class="content">
        
    	
    	<div class="section group">
			
                <form class="form-horizontal">     
                        <fieldset>
                                        
                        <legend>Código do pedido: ${itensPedido[1]}</legend>
                                    
  									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tabela_itens">
										<thead>
											<tr>
                                                <th>Código do produto</th>
                                                <th>Descrição do Produto</th>
												<th>Qtde</th>
												<th>Preço Unit (R$)</th>
												<th>Subtotal (R$)</th>
												<th>Trocar</th>
                                                <th>Motivo da Troca</th>
                                                <th></th>
                                                
											</tr>
										</thead>
										<tbody>
										<c:forEach var="itensItens" items="${listaItens}">
										  <c:if test="${not empty itensItens}">
															
											<tr class="odd gradeX">
                                                <td>${itensItens[1]}</td>
												<td>${itensItens[2]} ${itensItens[3]} ${itensItens[4]},tam. ${itensItens[5]}, ${itensItens[6]} g</td>
												<td class="center"><input type="number" style ="width: 45px" value="${itensItens[7]}" min="0" max="${itensItens[7]}" id="id_qtde" name="produto" disabled></td>
												<td class="center" name="pc_unit">${itensItens[8]}</td>
                                                <td class="center">R$ ${itensItens[9]}</td>
                                                <td class="center" style="text-align: center"><input type="checkbox" id="checkme" name="checking" onclick = "ativar_troca(this)"></td>
                                                <td class="center"><input type="text" id="troca1" name="texto_troca" disabled></td>
                                                <td style="display:none" name="id_produto">${itensItens[10]}</td>
                                                <td style="display:none" name="qtde_original">${itensItens[7]}</td>
											</tr>
										
										  </c:if>
										</c:forEach>
										</tbody>
									</table>
										<input type="hidden" id="id_json_trocas" name="txt_json_trocas" value="">
										<p style="text-align: right">
                                            
                                            <input type="button" class="btn btn-success" onclick="fazer_troca()" value="Gravar Valores Troca">
                                            
                                            <button type="submit" class="btn btn-success btn-large" onclick="fazer_troca()"
																formaction="CadastrarTroca" name="operacao"
																value="SALVAR" style="color: white">Realizar Troca</button>
                                            
                                            
										</p>
                                    
                        
					                 </fieldset>
					                    <br>
					                    <fieldset>
                                          <legend>Dados Pessoais<a href="site_alterar_cliente.html" style="margin-left: 100px; font-size: 15px">editar contato</a></legend>
                                          
                                        <div style ="width:100%; display=table";>
                                            <div style="table-row">
                                                <div style="width:220px; display: table-cell;">
                                                    <div class="control-group">
                                                        Nome
                                                        <br>
                                                        <span class="input-xlarge uneditable-input" style="width: 200px">${itensCliente[2]}</span>
                                                    </div>
                                                </div>
                                                <div style="width:170px; display: table-cell;">
                                                    <div class="control-group">
                                                        Email
                                                        <br>
                                                        <span class="input-xlarge uneditable-input" style="width: 150px">${itensCliente[7]}</span>
                                                    </div>
                                                </div>
                                                <div style="width:120px; display: table-cell;">
                                                    <div class="control-group">
                                                        Telefone
                                                        <br>
                                                        <span class="input-xlarge uneditable-input" style="width: 100px">${itensCliente[8]}</span>
                                                    </div>
                                                </div>

                                            </div>
                                          </div>
                                    </fieldset>
                                         <br>
                                    <fieldset>
                                        <legend>Endereço<a href="#" style="margin-left: 100px; font-size: 15px">novo endereço</a></legend>
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
										<thead>
											<tr>
												<th>Rua</th>
												<th>Número</th>
                                                <th>Compl.</th>
												<th>Bairro</th>
                                                <th>CEP</th>
												<th>Cidade</th>
                                                <th>UF</th>
                                                <th>Tipo</th>
                                                <th>Ação</th>
                                          	</tr>
										</thead>
										<tbody>
										<c:forEach var="itensEnderecos" items="${listaEnderecos}">
										  <c:if test="${not empty itensEnderecos}">
										
											<tr class="odd gradeX">
                                                <td>${itensEnderecos[1]}</td>
												<td>${itensEnderecos[2]}</td>
                                                <td>${itensEnderecos[3]}</td>
                                                <td>${itensEnderecos[4]}</td>
                                                <td>${itensEnderecos[5]}</td>
                                                <td>${itensEnderecos[6]}</td>
                                                <td>${itensEnderecos[7]}</td>
                                                <td>${itensEnderecos[8]}</td>
												<td><button class="btn btn-warning btn-mini">Editar</button>
                                                    <button class="btn btn-danger btn-mini">Excluir</button>
                                                </td>
                                         	</tr>	
                                         </c:if>
										</c:forEach>				
										</tbody>
				                        </table>
                                        
                                    </fieldset>
                    <br>
                    <fieldset>
                                        
                                         
                            <legend>Histórico</legend>
                                
                                    
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example" style="width: 300px">
										<thead>
											<tr>
												<th>Data</th>
												<th>Status</th>
                                          	</tr>
										</thead>
										<tbody>
											<tr class="odd gradeX">
                                                <td>08/08/2019</td>
                                                <td>COMPRA REALIZADA</td>
											</tr>			
                                            <tr class="odd gradeX">
                                                <td>09/08/2019</td>
                                                <td>PAGTO APROVADO</td>
											</tr>			
                                            <tr class="odd gradeX">
                                                <td>10/08/2019</td>
                                                <td>EM ENTREGA</td>
											</tr>			
										</tbody>
				                  </table>
                        <!-- /block -->
                    
                 </fieldset>
                
                    
            </form>
    
            
 	</div>
    </div>
 
     <div class="footer">
        <div class="copy_right">
				<p>&copy; 2019 William S</a></p>
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
        function ativar_troca(x){
        	var tabela = document.getElementById("tabela_itens");
            var r = x.parentNode.parentNode.rowIndex;
            var checks = document.getElementsByName("checking");
            var qtde = document.getElementsByName("produto");
            var textos = document.getElementsByName("texto_troca");
            if(checks[r-1].checked==true){
                alert("checkBox "+r+" marcado");
                textos[r-1].disabled=false;
                qtde[r-1].disabled=false;
                
            }else{
            	 alert("checkBox não marcado");
                qtde[r-1].disabled=true;
                textos[r-1].disabled=true;
            }
            
    }
    </script>
    
    
    
    <script>
     function fazer_troca(){

    	 alert("troca solicitada: 1 Meiao Branco XL");
         var tabela = document.getElementById("tabela_itens");
         var checks = document.getElementsByName("checking");
         var qtde_item = document.getElementsByName("produto");
		 var preco_unit = document.getElementsByName("pc_unit");
		 var id_prod = document.getElementsByName("id_produto");
		 var qtde_original = document.getElementsByName("qtde_original");
         var qtde_trocada=0;
         var i = 1;

         var json_body='{"trocas":[';
         for(var i=0;i<checks.length;i++){
             alert(i);
			 
            if(checks[i].checked==true){
				
				var qtde_reduzida = parseInt(qtde_item[i].value);
				var qtde_trocada = qtde_original[i].innerHTML-parseInt(qtde_item[i].value);
				var preco = preco_unit[i].innerHTML;
				var id = id_prod[i].innerHTML;
				
				
				alert("qtde_trocada de "+i + ": "+qtde_trocada);
				
				alert("id "+i + ": "+id);

                json_body+='{id:"'+id+'",qtde:"'+qtde_trocada+'",preco:"'+preco+'"}';
                if(i <checks.length-1){
                    json_body+=',';
                }
				else{
                    json_body+=']}';
                }
				
            } 
            document.getElementById("id_json_trocas").value = json_body;

         }
         alert(json_body);
        
    }
    </script>
    
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

