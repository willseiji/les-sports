<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    
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
    
    
    
<link href="css2/easy-responsive-tabs.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" href="css/global.css">
    
<script src="js2/slides.min.jquery.js"></script>

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

        <div class="container-fluid" style="width: 1400px">
            <div class="row-fluid">
                <!--/span-->
                <div class="span9" id="content">
				<!-- morris stacked chart -->
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<ul
								style="list-style-type: none; margin: 0; padding: 0; overflow: hidden;">
								<li style="display: inline" border-right: 1pxsolid #bbb;><a
									href="cadastro_cliente.jsp">Cadastrar</a></li>
								<li style="display: inline" border-right: 1pxsolid #bbb;><a
									href="dados_cliente.jsp">Consultar</a></li>
							</ul>
						</div>


						<div class="block-content collapse in">
							<div class="span12">
								<form class="form-horizontal" name="alterarForm" method="post">

									<fieldset>
										<legend>Dados do Cliente</legend>
										<div style="width: 100%;">
											<div style="">

												<div
													style="width: 200px; margin-right: 20px; display: table-cell;">
													<div class="control-group">
														Código <span class="input-xlarge uneditable-input">${itensCliente[0]}</span>
														<input type="hidden" class="form-control"
															name="txt_Codigo" value='${itensCliente[0]}'>
													</div>
												</div>
												<div
													style="width: 200px; margin-right: 20px; display: table-cell;">
													<div class="control-group">
														Nome <span class="input-xlarge uneditable-input">${itensCliente[1]}</span>
													</div>
												</div>
												<div style="width: 200px; display: table-cell;">
													<div class="control-group">
														Dt Nascimento <span class="input-xlarge uneditable-input">${itensCliente[2]}</span>
													</div>
												</div>

											</div>
											<div style="">
												<div
													style="width: 200px; margin-right: 20px; display: table-cell;">
													<div class="control-group">
														Sexo <span class="input-xlarge uneditable-input">${itensCliente[3]}</span>
													</div>
												</div>
												<div
													style="width: 200px; margin-right: 20px; display: table-cell;">
													<div class="control-group">
														RG <span class="input-xlarge uneditable-input">${itensCliente[4]}</span>
													</div>
												</div>
												<div style="width: 200px; display: table-cell;">
													<div class="control-group">
														CPF <span class="input-xlarge uneditable-input">${itensCliente[5]}</span>
													</div>
												</div>


											</div>
											<div style="">
												<div
													style="width: 200px; margin-right: 20px; display: table-cell;">
													<div class="control-group">
														Email <span class="input-xlarge uneditable-input">${itensCliente[6]}</span>
													</div>
												</div>
												<div
													style="width: 200px; margin-right: 20px; display: table-cell;">
													<div class="control-group">
														Telefone <span class="input-xlarge uneditable-input">${itensCliente[7]}</span>
													</div>
												</div>

											</div>
									</fieldset>
									<fieldset>
									<legend>Endereços do Cliente</legend>
										<table cellpadding="0" cellspacing="0" border="0"
											class="table table-striped table-bordered" id="myTable">
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
													<th>Ações</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="itemEndereco" items="${listaEnderecos}">
		                         				<c:if test="${not empty itemEndereco}">
						                         <tr onclick="myFunctionName(this)">
						                         <td style="display:none;" name="txt_IdEndereco" id="id_Endereco">${itemEndereco[0]}</td>  
							                          <td >${itemEndereco[1]}</td>
						                              <td >${itemEndereco[2]}</td>
						                              <td >${itemEndereco[3]}</td>
						                              <td >${itemEndereco[4]}</td>
						                              <td >${itemEndereco[5]}</td>
						                              <td >${itemEndereco[6]}</td>
						                              <td >${itemEndereco[7]}</td>
						                              <td >${itemEndereco[8]}</td>
						                              <input type="hidden" id="myInputEndereco" name="txt_IdEndereco" value="">
						                              <td><button type  ="submit" class="btn btn-warning btn-mini" name="operacao" formaction="ExcluirEndereco" id="bttAlterar" 
                                    			value="EXCLUIR">Excluir</button></td>
						                         </tr>
								               	</c:if>
					    	                </c:forEach>
					    	                </tbody>
	   	            						</table>
	   	            						
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
            
        </div>
              <div class="footer">
                <div class="copy_right">
				<p>&copy; 2019 William S</a></p>
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

        <script src="vendors/datatables/js/jquery.dataTables.min.js"></script>
        <script src="vendors/wysiwyg/wysihtml5-0.3.0.js"></script>
        <script src="vendors/wysiwyg/bootstrap-wysihtml5.js"></script>

        <script src="vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

	<script type="text/javascript" src="vendors/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="assets/form-validation.js"></script>
        
	<script src="assets/scripts.js"></script>
        
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
        
        <script>
        function myFunctionName(x) {
            var myTable = document.getElementById('myTable');
            var r = x.rowIndex;
            var idEndereco = myTable.rows[r].cells[0].innerText;
            document.getElementById("myInputEndereco").value = idEndereco;
            alert(idEndereco);
        }
        </script>
    </body>

</html>