<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8" />
        <title>Forms</title>
        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="assets/styles.css" rel="stylesheet" media="screen">
        <!-->script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script-->
    </head>
    
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Admin Panel</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> Admin <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">Profile</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="login.html">Logout</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav">
                            <li class="active">
                                <a href="#">Dashboard</a>
                            </li>
                            <li class="dropdown"><a href="home.jsp"	target="_blank">Site</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle">Configurações <b class="caret"></b>

                                </a>
                                
                            </li>
                            
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Usuários <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">User List</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Search</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Permissions</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        
                        <li class="active">
                            <a href="menu-cliente.jsp"><i class="icon-chevron-right"></i> Cliente</a>
                        </li>
                        <li class="active">
                            <a href="menu-produto.jsp"><i class="icon-chevron-right"></i> Produto</a>
                        </li>
                        <li class="active">
                            <a href="menu-pedido.jsp"><i class="icon-chevron-right"></i> Pedidos</a>
                        </li>
                        <li class="active">
                            <a href="menu-trocas.jsp"><i class="icon-chevron-right"></i> Trocas</a>
                        </li>
                        <li class="active">
                            <a href="menu-estoque.jsp"><i class="icon-chevron-right"></i> Estoque</a>
                        </li>
                        <li class="active">
                            <a href="menu_grafico.html"><i class="icon-chevron-right"></i> Gráficos</a>
                        </li>
                    </ul>
                </div>
                <!--/span-->
                <div class="span9" id="content">
                      <!-- morris stacked chart -->
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <ul style="list-style-type: none;
								  margin: 0;
								  padding: 0;
								  overflow: hidden;
								  ">
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="menu-pedido.jsp">Menu</a></li>
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="visualizar-pedido.jsp">Visualizar</a></li>
                                </ul>
                            </div>
                            
                            
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal" name="alterarForm" method="post" >
										                                                                               
                            		<fieldset>
										<legend>Status do Pedido</legend>
										<div style="width: 100%;";>
											<div style="">
												<div style="width: 300px; display: table-cell;">
													<div class="control-group">
														Código <span class="input-xlarge uneditable-input">${itensPedido[1]}</span>
													</div>
												</div>

											</div>
											<div style="">
												<div style="width: 300px; display: table-cell;">
													<div class="control-group">
														De <span class="input-xlarge uneditable-input" id="status_de">${itensPedido[7]}</span>
													</div>
												</div>
												<div style="width: 300px; display: table-cell;">
													<div class="control-group">
														Para <br> <select name="tipo_endereco" id="status_para">
															<option value="LIBERADO P/ ENTREGA">LIBERADO P/ ENTREGA</option>
															<option value="EM ESPERA">EM ESPERA</option>
														</select>
													</div>
												</div>
												<div style="width: 300px; display: table-cell;">
													<br>
													<input type="hidden" id="txt_id" name="txt_id" value="${itensPedido[0]}">
													<input type="hidden" id="status_input" name="txt_Status" value="">
													<button type="submit" formaction="AlterarPedido"  name="operacao"
																				value="ALTERAR" onclick="atualizar_status()">Atualizar</button></td>
												</div>
											</div>
										</div>
									</fieldset>

									<fieldset>
										<legend>Itens do Pedido</legend>

										<table cellpadding="0" cellspacing="0" border="0"
											class="table table-striped table-bordered" id="example">
											<thead>
												<tr>
													<th>Codigo</th>
													<th>Descrição</th>
													<th>Qtde</th>
													<th>Preço Unit</th>
													<th>Subtotal</th>
													<th>Em troca</th>

												</tr>
											</thead>
											<tbody>
											<c:forEach var="itensItem" items="${listaItens}">
		                         				<c:if test="${not empty itensItem}">
						                    
												<tr class="odd gradeX">
													<td><a style="text-decoration: underline">${itensItem[1]}</a></td>
													<td>${itensItem[2]}, ${itensItem[3]}, ${itensItem[4]}, tamanho ${itensItem[5]}, ${itensItem[6]}g</td>
													<td class="center">${itensItem[7]}</td>
													<td class="center">R$ ${itensItem[8]}</td>
													<td class="center">R$ ${itensItem[9]}</td>
													<td class="center">Não</td>
												</tr>
											</c:if>
					    	                </c:forEach>

											</tbody>
										</table>

										<div id="bottom-cart">
											<div id="product" style="margin-left: 500px">
												<p>SUBTOTAL: R$ ${itensPedido[3]}</p>
												<p>FRETE: ${itensPedido[4]}</p>
												<p>DESCONTO: R$ ${itensPedido[5]}</p>
												<hr>
												<p>
													TOTAL: <strong>R$ ${itensPedido[6]}</strong>
												</p>

											</div>
										</div>

									</fieldset>

									<fieldset>
										<legend>Dados do Cliente</legend>
										<div style="width: 100%;";>
			                                <div style="table-row">
          									<div style="width: 120px; display: table-cell;">
													<div class="control-group">
														Codigo <br> <span
															class="input-xlarge uneditable-input"
															style="width: 100px">${itensCliente[1]}</span>
													</div>
												</div>
												<div style="width: 220px; display: table-cell;">
													<div class="control-group">
														Nome <br> <span class="input-xlarge uneditable-input"
															style="width: 200px">${itensCliente[2]}</span>
													</div>
												</div>
												<div style="width: 220px; display: table-cell;">
													<div class="control-group">
														Sexo <br> <span class="input-xlarge uneditable-input"
															style="width: 200px">${itensCliente[3]}</span>
													</div>
												</div>
			                                 </div>
                                            <div style="table-row">
          
												<div style="width: 220px; display: table-cell;">
													<div class="control-group">
														Dt Nascimento <br> <span class="input-xlarge uneditable-input"
															style="width: 200px">${itensCliente[4]}</span>
													</div>
												</div>
												<div style="width: 120px; display: table-cell;">
													<div class="control-group">
														RG <br> <span class="input-xlarge uneditable-input"
															style="width: 100px">${itensCliente[5]}</span>
													</div>
												</div>
												<div style="width: 120px; display: table-cell;">
													<div class="control-group">
														CPF <br> <span class="input-xlarge uneditable-input"
															style="width: 100px">${itensCliente[6]}</span>
													</div>
												</div>
			                                 </div>
                                            <div style="table-row">
          
												<div style="width: 170px; display: table-cell;">
													<div class="control-group">
														Email <br> <span
															class="input-xlarge uneditable-input"
															style="width: 150px">${itensCliente[7]}</span>
													</div>
												</div>
												<div style="width: 120px; display: table-cell;">
													<div class="control-group">
														Telefone <br> <span
															class="input-xlarge uneditable-input"
															style="width: 100px">${itensCliente[8]}</span>
													</div>
												</div>
                                 			
											</div>
										</div>
									</fieldset>
									<fieldset>
									<legend>Endereços do Cliente</legend>
										<table cellpadding="0" cellspacing="0" border="0"
											class="table table-striped table-bordered" id="example">
											<thead>
												<tr>
													<th>Rua</th>
													<th>Numero</th>
													<th>Complemento</th>
													<th>Bairro</th>
													<th>CEP</th>
													<th>Cidade</th>
													<th>Estado</th>
													<th>Tipo</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="itemEndereco" items="${listaEnderecos}">
		                         				<c:if test="${not empty itemEndereco}">
						                         <tr>
						                         <td style="display:none;" name="txt_IdEndereco" id="id_Endereco">${itemEndereco[0]}</td>
						                              <td >${itemEndereco[1]}</td>
						                              <td >${itemEndereco[2]}</td>
						                              <td >${itemEndereco[3]}</td>
						                              <td >${itemEndereco[4]}</td>
						                              <td >${itemEndereco[5]}</td>
						                              <td >${itemEndereco[6]}</td>
						                              <td >${itemEndereco[7]}</td>
						                              <td >${itemEndereco[8]}</td>
						                              
						                         </tr>
								               	</c:if>
					    	                </c:forEach>
					    	                </tbody>
	   	            						</table>
	   	            						
	   	            						<button type="submit" class="btn btn-primary"  name="operacao" formaction="AlterarCliente" value="ALTERAR">Atualizar</button>
									</fieldset>
                                         
                                    </form>

                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>


                </div>
            </div>
            <hr>
            <footer>
                
            </footer>
        </div>
        <!--/.fluid-container-->
        
        
	<script type="text/javascript" src="vendors/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="assets/form-validation.js"></script>
        
	<script src="assets/scripts.js"></script>
        <script src="assets/DT_bootstrap.js"></script>
   <script>
/*
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
        */
        </script>
        
            <script>
        function atualizar_status(){
            var txt_status_de = document.getElementById("status_de").innerHTML;
            var txt_status_para = document.getElementById("status_para").value;
            document.getElementById("status_input").value=txt_status_para;   
        }
    </script>
        
        
    </body>

</html>