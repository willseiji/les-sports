<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <title>Forms</title>
    
    <!-- Bootstrap -->
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
			    	<li><a href="about.html">Cal�ados</a>
                        <ul class="dropdown">
                            <li><a href="#">Botas</a></li>
                            <li><a href="#">Chuteiras</a></li>
                            <li><a href="#">Meias</a></li>
				            <li><a href="#">T�nis</a></li>
				        </ul>
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
				        </ul>
					</li>
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
	
   
    
    
    <div class="container-fluid" style="width: 1400px">
        <div class="row-fluid">
            
            
            <div class="span9" id="content">
                  <!-- morris stacked chart -->
                <h2>Checkout</h2>
                 <!-- wizard -->
                <div class="row-fluid section">
                     <!-- block -->
                    <div class="block">
                        <div class="navbar navbar-inner block-header">
                            
                        </div>
                        <div class="block-content collapse in">
                            <div class="span12">
                                <div id="rootwizard">
                                    <div class="navbar">
                                      <div class="navbar-inner">
                                        <div class="container">
                                    <ul>
                                        
                                        <li><a href="#tab1" data-toggle="tab">Cliente</a></li>
                                        <li><a href="#tab2" data-toggle="tab">Endere�o de Entrega</a></li>
                                        <li><a href="#tab3" data-toggle="tab">Pedido</a></li>
                                        <li><a href="#tab4" data-toggle="tab">Forma de Pagamento</a></li>
                                        <li><a href="#tab5" data-toggle="tab">Finalizar Compra</a></li>
                                    </ul>
                                     </div>
                                      </div>
                                    </div>
                                    <div id="bar" class="progress progress-striped active">
                                      <div class="bar"></div>
                                    </div>
                                    <div class="tab-content">
                                        <div class="tab-pane" id="tab1">
                                            <form class="form-horizontal">
                                              <fieldset>
                                                <div class="control-group">
                                                  <label class="control-label">Nome</label>
                                                  <div class="controls">
                                                    <span class="input-xlarge uneditable-input">${itensCliente[1]}</span>
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Sexo</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">${itensCliente[2]}</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Dt Nascimento</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">${itensCliente[3]}</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">RG</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">${itensCliente[4]}</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">CPF</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">${itensCliente[5]}</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Email</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">${itensCliente[6]}</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Telefone</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">${itensCliente[7]}</span>
                                                    </div>
                                                </div>
                                                                                                  
                                              </fieldset>
                                                
                                            </form>
                                        </div>
                                        <div class="tab-pane" id="tab2">
                                            <form class="form-horizontal">
                                              <fieldset>
                                                <div class="control-group">
                                                  <label class="control-label">Endere�o</label>
                                                  <div class="controls">
                                                    <span class="input-xlarge uneditable-input">Avenida Jose da Silva</span>
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Numero</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">1000</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Complemento</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">apto 52</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Bairro</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">Bela Vista</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">CEP</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">XXXXX-XXX</span>
                                                    </div>
                                                </div>
                                                  <div class="control-group">
                                                    <label class="control-label">Cidade</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">S�o Paulo</span>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Estado</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">SP</span>
                                                    </div>
                                                </div>
                                                <div style="margin-left: 100px">
                                                    <input type="button" value="mudar endere�o" onclick="menu_enderecos()">
                                                </div>
                                                                                                  
                                              </fieldset>
                                                <br>
                                    <div id="menu-lista-endereco" style="display: none">
                                                        <fieldset>
                                        <legend>Endere�o<a href="#" style="margin-left: 100px; font-size: 15px">novo endere�o</a></legend>
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
										<thead>
											<tr>
												<th>Rua</th>
												<th>N�mero</th>
                                                <th>Compl.</th>
												<th>Bairro</th>
                                                <th>CEP</th>
												<th>Cidade</th>
                                                <th>UF</th>
                                                <th>Tipo</th>
                                                <th>Op��o</th>
                                          	</tr>
										</thead>
										<tbody>
										<c:forEach var="itemEndereco" items="${listaEnderecos}">
											<c:if test="${not empty itemEndereco}">
										
											<tr class="odd gradeX">
                                                <td>${itemEndereco[1]}</td>
												<td>${itemEndereco[2]}</td>
                                                <td>${itemEndereco[3]}</td>
                                                <td>${itemEndereco[4]}</td>
                                                <td>${itemEndereco[5]}</td>
                                                <td>${itemEndereco[6]}</td>
                                                <td>${itemEndereco[7]}</td>
                                                <td>${itemEndereco[8]}</td>
												<td><input type="radio" name="opt_endereco">
                                                </td>
                                         	</tr>
                                         	</c:if>
                            		</c:forEach>					
										</tbody>
				                        </table>
                                        
                                    </fieldset>
                                        </div>
                                            </form>
                                        </div>
                                          <div class="tab-pane" id="tab3">
                                           <form class="form-horizontal">
                                              <fieldset>
                                                <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                            <thead>
                                                <tr>
                                                    <th>Cod. Produto</th>
                                                    <th>Descri��o do Produto</th>
                                                    <th>Qtde</th>
                                                    <th>Pre�o Unit</th>
                                                    <th>Subtotal</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="itemItem" items="${listaItens}">
											<c:if test="${not empty itemItem}">
										
                                                <tr class="odd gradeX">
                                                    <td>${itemItem[1]}</td>
                                                    <td>${itemItem[2]} ${itemItem[3]} ${itemItem[4]} ${itemItem[5]} ${itemItem[6]}g</td>
                                                    <td class="center">${itemItem[7]}</td>
                                                    <td class="center">R$ ${itemItem[8]}</td>
                                                    <td class="center">R$ ${itemItem[9]}</td>

                                                </tr>
                                                </c:if>
                            				</c:forEach>					
                                            </tbody>
									   </table>
                                        </fieldset>
                                        <div id="bottom-cart">
                                            <div id="product" style="margin-left: 500px">
                                                <h4>Total do Pedido</h4>
                                                <p>Subtotal: R$ ${itensValor[0]}</p>
                                                <p>Frete:    R$ ${itensValor[1]}</p>
                                                <p>Desconto: R$ ${itensValor[2]}</p>
                                                <hr>
                                                <p><strong>Total:    <span style="font-size: 20px">R$ ${itensValor[3]}</span></strong></p>

                                            </div>
                                        </div>
                                    </form>
                                </div>
                                        <div class="tab-pane" id="tab4">
                                            <form class="form-horizontal" action="">
                                                
                                                <fieldset>
                                                <div class="control-group">
                                                  <label class="control-label">Total: R$</label>
                                                  <div class="controls">
                                                    <input id="id_total" value="${itensValor[3]}" readonly>
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Valores</label>
                                                    <div class="controls">
                                                        <p><input  style="width: 40px" id="id_qtde" type="number" min="1" max="12" value="1" onclick="calcular_parcelas()">
                                                            <span> x </span>
                                                            <strong>R$ <span id="id_parcelas"></span></strong>
                                                        </p>
                                                    </div>
                                                    
                                                </div>
                                            </fieldset>
                                                
                                              <fieldset>
                                                <div class="control-group">
                                                  <!--label class="control-label" for="optionsCheckbox">Cart�o de Cr�dito</label-->
                                                  <div class="controls">
                                                        <input type="radio" id="radio-boleto" name="pagto" value="Boleto" checked onclick="mudarPgto(this)"/>Boleto
                                                        <input type="radio" id="radio-cartao" name="pagto" value="Cartao"   onclick="mudarPgto(this)"/>Cart�o
                                                  </div>
                                                </div>
                                                </fieldset>
                                                <hr>
                                        <div id="menu-boleto">
                                            <fieldset>
                                                <legend>Boleto</legend>
                                                <div class="controls">
                                                    <input placeholder="adicione CPF (Somente numeros)">
                                                </div>
                                            </fieldset>
                                            
                                        </div>
                                                
                                                
                                                  
                                        <div id="menu-cartao" style ="display: none">          
                                            
                                            
                                            <fieldset>
                                              <legend>Cart�o de Cr�dito</legend>
                                                <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                                <thead>
                                                <tr>
                                                    <th>Bandeira</th>
                                                    <th>Nr do cart�o</th>
                                                    <th>Valor da Parcela (R$)</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr class="odd gradeX">
                                                    <td>Mastercard</td>
                                                    <td>####-####-####-1234</td>
                                                    <td class="center"><input type="text" id="id_valor_parcela"></td>

                                                </tr>
                                                </tbody>
                                                </table>    
                                                <div>
                                                    <input type="button" value="Adicionar Cart�o" onclick="add_cartao()">
                                                    <input style="margin-left: 400px" type="button" onclick="atualizar_parcelas()" value="Atualizar"/>
                                                </div>
                                                
                                                
                                        </fieldset>
                                            <br>
                                            <br>  
                                        <div id="novo-cartao" style="display: none">
                                            
                                        <fieldset>
                                            <legend>Lista de Cart�es Cadastrados<a href="form_cadastro_cartao.html" style="margin-left: 100px; font-size: 15px">adicionar novo cart�o</a></legend>
                                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tabela-cartoes">
										<thead>
											<tr>
												<th>Bandeira</th>
												<th>Nr do cart�o</th>
												<th>Dt Venc.</th>
												<th>Nome do Titular</th>
                                                <th>Incluir</th>
												<th>A��o</th>
											</tr>
										</thead>
										<tbody>
											<tr class="odd gradeX">
                                                <td>Mastercard</td>
												<td class="center">####-####-####-1234</td>
												<td class="center">05/22</td>
                                                <td class="center">Joao da Silva</td>
                                                <td class="center"><input type="checkbox"></td>
                                                <td>
                                                    <button class="btn btn-warning btn-mini">Editar</button>
                                                    <button class="btn btn-danger btn-mini" value="Excluir" onclick="deleteRow(this)">Excluir</button>
                                                </td>
											</tr>
											<tr class="odd gradeX">
                                                <td>VISA</td>
                                                <td class="center">####-####-####-3344</td>
												<td class="center">05/20</td>
                                                <td class="center">Joao da Silva</td>
                                                <td class="center"><input type="checkbox"></td>
                                                <td>
                                                    <button class="btn btn-warning btn-mini">Editar</button>
                                                    <button class="btn btn-danger btn-mini" value="Excluir" onclick="deleteRow(this)">Excluir</button>
                                                </td>
                                                
											</tr>
                                            
										</tbody>
									</table>
										<p style="text-align: right">
                                            
                                            <button type="button" class="btn btn-success">Salvar</button>
										</p>
                                            
                                        </fieldset>
                                                      
                                            
                                        
                                        </div>
                                            </div>          
                                                
                                            </form>
                                        </div>
                                        <div class="tab-pane" id="tab5">
                                            <form class="form-horizontal">
                                              <fieldset>
                                                  <div class="control-group">
                                                  <label class="control-label">C�digo do Pedido</label>
                                                  <div class="controls">
                                                    <span class="input-xlarge uneditable-input">XXXXXX-XXX</span>
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label">Data do Pedido</label>
                                                    <div class="controls">
                                                        <span class="input-xlarge uneditable-input">12/08/2019</span>
                                                    </div>
                                                </div>
                                                  <div class="control-group">
                                                  <label class="control-label">Total</label>
                                                  <div class="controls">
                                                    <span class="input-xlarge uneditable-input">${itensValor[3]}</span>
                                                  </div>
                                                </div>
                                                
                                                  <p style="text-align: center">
                                                  	<button type="submit" class="btn btn-success btn-large" formaction ="CadastrarPedido" 
                                                  		name="operacao" value="SALVAR" style="color: white">Finalizar Compra</button>
                                                          
                                                  </p>
                                                                                                  
                                              </fieldset>
                                                
                                            </form>
                                        </div>
                                        
                                        
                                        
                                        <ul class="pager wizard">
                                            <li class="previous first" style="display:none;"><a href="javascript:void(0);">Primeiro</a></li>
                                            <li class="previous"><a href="javascript:void(0);">Anterior</a></li>
                                            <li class="next last" style="display:none;"><a href="javascript:void(0);">�ltimo</a></li>
                                            <li class="next"><a href="javascript:void(0);">Pr�ximo</a></li>
                                            <li class="next finish" style="display:none;"><a href="javascript:;">Fim</a></li>
                                        </ul>
                                    </div>  
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /block -->
                </div>
            <!-- /wizard -->


            </div>
        </div>
        <hr>
        
    
         <div class="footer">
        <div class="copy_right">
				<p>&copy; 2019 William S</a></p>
		   </div>
    </div>
    <!--/.fluid-container-->
    <link href="vendors/datepicker.css" rel="stylesheet" media="screen">
    <link href="vendors/uniform.default.css" rel="stylesheet" media="screen">
    <link href="vendors/chosen.min.css" rel="stylesheet" media="screen">

    <link href="vendors/wysiwyg/bootstrap-wysihtml5.css" rel="stylesheet" media="screen">

    <script src="vendors/jquery-1.9.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="vendors/jquery.uniform.min.js"></script>
    <script src="vendors/chosen.jquery.min.js"></script>
    <script src="vendors/bootstrap-datepicker.js"></script>

    <script src="vendors/wysiwyg/wysihtml5-0.3.0.js"></script>
    <script src="vendors/wysiwyg/bootstrap-wysihtml5.js"></script>

    <script src="vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

<script type="text/javascript" src="vendors/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="assets/form-validation.js"></script>

<script src="assets/scripts.js"></script>
    
    <script>
	    function mudarPgto(radio) { 
	        if (radio.checked && radio.id === "radio-boleto") {
	            document.getElementById("menu-boleto").style.display = "inline";
	            document.getElementById("menu-cartao").style.display = "none";
	            document.getElementById("radio-boleto").checked=true;
	            document.getElementById("radio-cartao").checked=false;
	            
	            
	        }if (radio.checked &&radio.id === "radio-cartao") {
	            document.getElementById("menu-boleto").style.display = "none";
	            document.getElementById("menu-cartao").style.display = "inline";
	            document.getElementById("radio-boleto").checked=false;
	            document.getElementById("radio-cartao").checked=true;
	            
	        }
	    }
	</script>
    
    <script>
        function menu_enderecos(){
            document.getElementById("menu-lista-endereco").style.display = "inline";
        }
    </script>
    
    <script>
        function add_cartao(){
            document.getElementById("novo-cartao").style.display = "inline";
        }
    </script>
    
    <script>
        function calcular_parcelas(){
            var myTotal = document.getElementById('id_total').value; 
            var myQtde = document.getElementById('id_qtde').value;
            var myResult = myTotal/myQtde;
            document.getElementById('id_parcelas').innerHTML = myResult.toFixed(2);
        }
        window.load = calcular_parcelas();
    </script>
    
    <script>
        function atualizar_parcelas(){
            var valorParcela = document.getElementById('id_parcelas').innerText;
            document.getElementById('id_valor_parcela').value = valorParcela;
        }
        window.load = atualizar_parcelas();
    </script>
    
    <script>
jQuery(document).ready(function() {   
   FormValidation.init();
});


    $(function() {
        $(".datepicker").datepicker();
        $(".uniform_on").uniform();
        $(".chzn-select").chosen();
        $('.textarea').wysihtml5();

        $('#rootwizard').bootstrapWizard({onTabShow: function(tab, navigation, index) {
            var $total = navigation.find('li').length;
            var $current = index+1;
            var $percent = ($current/$total) * 100;
            $('#rootwizard').find('.bar').css({width:$percent+'%'});
            // If it's the last tab then hide the last button and show the finish instead
            if($current >= $total) {
                $('#rootwizard').find('.pager .next').hide();
                $('#rootwizard').find('.pager .finish').show();
                $('#rootwizard').find('.pager .finish').removeClass('disabled');
            } else {
                $('#rootwizard').find('.pager .next').show();
                $('#rootwizard').find('.pager .finish').hide();
            }
        }});
        $('#rootwizard .finish').click(function() {
            alert('Finished!, Starting over!');
            $('#rootwizard').find("a[href*='tab1']").trigger('click');
        });
    });
    </script>
</body>

</html>