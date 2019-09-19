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
                    <li><a href="site-menu-carrinho.jsp"
								style="font-size: 15px">Carrinho</a></li>
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
        <h2> Carrinho de Compras</h2>
    	
    	<div class="section group">
			
                <form class="form-horizontal">     
                          <fieldset>
                                        
                                         
                        <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    
  									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="myTable">
										<thead>
											<tr>
												<th>Cod. Produto</th>
												<th>Descrição do Produto</th>
												<th>Qtde</th>
												<th>Preço Unit (R$)</th>
												<th>Subtotal (R$)</th>
                                                <th style="width:50px">Ação</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="itemCarrinho" items="${listaCarrinho}">
											<c:if test="${not empty itemCarrinho}">
										
											<tr class="odd gradeX" id="produto1"  onclick="calculate_row(this)">
                                                <td><a style="text-decoration: underline">${itemCarrinho[3]}</a></td>
												<td>${itemCarrinho[4]} ${itemCarrinho[5]}</td>
												<td class="center"><input id="qtde1" type="number" style=" width: 40px" value="${itemCarrinho[1]}" min="1" /></td>
												<td class="center">${itemCarrinho[6]}</td>
                                                <td class="center"></td>
                                                <td class="center"><input type=button" class="btn btn-danger" value="Excluir" onclick="deleteRow(this)"><i class="icon-remove icon-white"></i></td>
											</tr>
											
											</c:if>
                            			</c:forEach>
										</tbody>
									</table>
										<p style="text-align: right">
                                            <button type="button" class="btn btn-warning" onclick="deletar_tabela()">Esvaziar carrinho</button>
                                            <button type="button" class="btn btn-info" onclick="calcular_subtotal()" >Atualizar valores</button>
                                            <button type="button" class="btn btn-success"><a href="home.jsp" style= "color:white">Continuar Comprando</a></button>
										</p>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                 </fieldset>
                <div id="bottom-cart">
                    <div id="product">
                        <h4>Calcular Frete</h4>
                        <p>informe seu CEP</p>
                        <p><input id="codigo_frete"></p>
                        <p><input type="button" class="btn" onclick="calcular_frete()" value="Calcular Frete"></p>
                        <p>Valor do Frete: R$ <span id="valor_frete"></span></p>
                    </div>
                    <div id="product">
                        <h4>Cupom de Desconto</h4>
                        <p>informe seu cupom de desconto</p>
                        <p><input id="codigo_cupom"></p>
                        <p><input type="button" class="btn" value="Usar Cupom" id="buscar_cupom"  ></p>
                        <p>Valor do Cupom: R$ <span id="valor_desconto" value="0"></span></p>
                        <p>Status: R$ <span id="valor_status" value=""></span></p>
                    </div>
                    <div id="product">
                        <h4>Total do Pedido</h4>
                        <p>Subtotal:  R$ <span id="id_subtotal"></span></p>
                        <p>Frete:     R$ <span id="id_frete">0</span></p>
                        <p>Desconto: -R$ <span id="id_desconto">0</span></p>
                        <hr>
                        <p><strong>Total:    <span style="font-size: 20px" id="id_total"></span></strong></p>
                        <input type="hidden" id="id_valorSubTotal" name="txt_valorSubTotal" value="">
                        <input type="hidden" id="id_valorFrete" name="txt_valorFrete" value="">
                        <input type="hidden" id="id_valorDesconto" name="txt_valorDesconto" value="">
                        <input type="hidden" id="id_valorTotal" name="txt_valorTotal" value="">
                        <div>
                            <p ><button type="button" style="text-align: right" class="btn btn-success btn-large" onclick="calcular_total()"/>Atualizar Total</p></div>
                        <p><button type="submit" class="btn btn-success btn-large" formaction ="SalvarMenuCart" style="color: white">Finalizar Pedido</button>
                        </p>
                    </div>
                        
                </div>
    
                    
            </form>
            
	    <script type="text/javascript">
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion           
            width: 'auto', //auto or any width like 600px
            fit: true   // 100% fit in a container
        });
    });
   </script>		
   
 	
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
    
    

    <script>
        function calculate_row() {
            var myTable = document.getElementById("myTable");
            
            var totalRow = myTable.getElementsByTagName("tr").length;
            for (var r = 1; r < totalRow; r++) { 
                var qtde = myTable.rows[r].cells[2].firstChild.value;
                var pc_unit = myTable.rows[r].cells[3].innerText;
                var resultado = qtde*pc_unit;
                myTable.rows[r].cells[4].innerHTML=resultado;    
            }
            
        }
        window.load=calculate_row();
    </script>


    <script>
        function calcular_subtotal() {
            var myTable = document.getElementById("myTable");
            var totalRow = myTable.getElementsByTagName("tr").length;
            var subtotal=0;
            for (var i = 1; i < totalRow; i++) { 
                valor= myTable.rows[i].cells[4].innerText;
                subtotal+=parseFloat(valor);
            }
            document.getElementById('id_subtotal').innerHTML = parseFloat(subtotal);
        }
        window.load=calcular_subtotal();
    </script>
    
    <script>
        function calcular_total() {
            var subtotal = parseFloat(document.getElementById("id_subtotal").innerHTML);
            var frete = parseFloat(document.getElementById("id_frete").innerHTML);
            var desconto = parseFloat(document.getElementById("id_desconto").innerHTML);
            var total = subtotal+frete-desconto;
            
            document.getElementById('id_total').innerHTML = total;
            document.getElementById('id_valorSubTotal').value = subtotal;
            document.getElementById('id_valorFrete').value = frete;
            document.getElementById('id_valorDesconto').value = desconto;
            document.getElementById('id_valorTotal').value = total;
        }
        window.load=calcular_total();
    </script>
    
    <script>
        function deletar_tabela() {
            var myTable = document.getElementById("myTable");
            var totalRow = myTable.rows.length;
            $("tbody").children().remove()
            
        }
    </script>
    
    
    <script>
        function deleteRow(r) {
            var i = r.parentNode.parentNode.rowIndex;
            document.getElementById("myTable").deleteRow(i);
        }
    </script>
    
    <script type="text/javascript">
		$(document).ready(function() {			
			$('#buscar_cupom').click(function(event){
/*				$.ajax({
						url:'./ServletDesconto',
						data:{
								cod_cupom: $('#codigo_cupom').val()
							},
						//contentType:'application/json',
						//dataType:'json',
						type:'POST',
						sucess:function(data){
							var valorCupom=data;
							var statusCupom="sucesso";
							//console.log("sucesso");
							//var dadosCupom=JSON.parse(cupom);
							//var valorCupom = dadosCupom.valor;
							//var statusCupom = dadosCupom.condicao;
							alert("sucesso");
							alert("cupom");
							document.GetElementById("valor_desconto").value = valorCupom;
							document.GetElementById("valor_status").value = statusCupom;
							
						},
						error: function(){
							console.log("fracasso");
							alert("erro no ajax");
						}
				});
			});
		});
				*/
				
				var codigo = $('#codigo_cupom').val();
				//var desconto_acumulado = $('#id_desconto').innerHTML;
				//var desconto_acumulado = $('#id_desconto').val();
				$.post('ServletDesconto',{
					cod_cupom:codigo
				},function(cupom){
					
					$('#valor_desconto').text(cupom);
					$('#id_desconto').text(cupom);
					
					//var desconto= parseDouble(cupom);
					//var desconto_acumulado = parseFloat(document.getElementById('id_desconto').innerHTML);
					//var desconto_final = valor_desconto+desconto_acumulado
					
		            //document.getElementById('id_desconto').innerHTML = "33";
					
					
					//$('#valor_status').text(cupom);
					 
					//var desconto_total = parseFloat(responseText)+13;

				//	$('#valor_desconto').text("valor");
					//$('#id_desconto').text(desconto_total.toString());
				
				});
			});
		});
			
	</script>
    
    <script>
        function calcular_frete() {
            var cupom = document.getElementById("codigo_frete").value;
            if(cupom==null||cupom=="")
            	var valor_frete=0;
            else
            	var valor_frete=10;
            
            document.getElementById('valor_frete').innerHTML = valor_frete;
            document.getElementById('id_frete').innerHTML = valor_frete;

        }
    </script>
    
    
    
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

