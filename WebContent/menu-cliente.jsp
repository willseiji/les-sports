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
        <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
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
                            <li class="dropdown">
                                <a href="site_principal.html" target="_blank">Site</a>
                            </li>
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
                            <a href="menu_dados_cliente.html"><i class="icon-chevron-right"></i> Cliente</a>
                        </li>
                        <li class="active">
                            <a href="menu_dados_produto.html"><i class="icon-chevron-right"></i> Produto</a>
                        </li>
                        <li class="active">
                            <a href="menu_pedidos.html"><i class="icon-chevron-right"></i> Pedidos</a>
                        </li>
                        <li class="active">
                            <a href="menu_trocas.html"><i class="icon-chevron-right"></i> Trocas</a>
                        </li>
                        <li class="active">
                            <a href="menu_estoque.html"><i class="icon-chevron-right"></i> Estoque</a>
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
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="menu_cliente.jsp">Consultar</a></li>
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="alterar_cliente.jsp">Alterar</a></li>
                                </ul>
                            </div>
                            
                            <form name="PesquisarClientes" method="post">
		                        <div class="input-group h2" width="400px" style="text-align: right">
		                            <input type="text" class="form-control" name="txt_filtro" id="txt_filtro" 
		                                   placeholder="cliente" value="">
		                            <span class="input-group-btn">
		                                <button type="submit" class="btn btn-primary" 
		                                        formaction="PesquisarCliente" name="operacao" value="PESQUISAR">
		                                    Pesquisar
		                                </button>
		                            </span>
		                        </div>
		                    </form>
		                    
                            
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal">
                                    <fieldset>
                                        <legend>Lista de Clientes</legend>
                                         
                        <div class="row-fluid">
                        <!-- block -->
                        <div class="block" style="text-align: right">
                            <div class="navbar navbar-inner block-header">
                                
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    
  									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
										<thead>
											<tr>
												<th>Codigo</th>
												<th>Nome</th>
												<th>Email</th>
												<th>Status</th>
												<th>Ação</th>
											</tr>
										</thead>
										<c:forEach var="itemClientes" items="${listaClientes}">
											<c:if test="${not empty itemClientes}">
											<tr class="odd gradeX" onclick="myFunctionName(this)">
											
                                                <td><a style="text-decoration: underline">${itemClientes[0]}</a></td>
                                                <td>${itemClientes[1]}</td>
                                                <td>${itemClientes[2]}</td>
												<td>${itemClientes[3]}</td>
												<input type="hidden" id="myInputCliente" name="txt_NmCodigo" value="">
												<td><button type  ="submit" class="btn btn-warning btn-mini" name="operacao" formaction="PreAlterarCliente" id="bttAlterar" 
                                    			value="PREALTERAR">Visualizar</button>
                                                    
                                                </td>
											</tr>
											
                            			</c:if>
                            		</c:forEach>
									</table>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                                         </fieldset>
                                         
                                         
                                      <fieldset>
                                        <legend>Dados Pessoais</legend>
                                        <div style ="width:100%; display=table";>
                                            <div style="table-row">
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Codigo
                                                        <span class="input-xlarge uneditable-input">XXXXXXX</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Nome
                                                        <span class="input-xlarge uneditable-input">Joao da Silva</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Sexo
                                                        <span class="input-xlarge uneditable-input">Masculino</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style="table-row">
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Data de Nascimento
                                                        <span class="input-xlarge uneditable-input">01/01/2000</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        RG
                                                        <span class="input-xlarge uneditable-input">11.111.111-1</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        CPF
                                                        <span class="input-xlarge uneditable-input">111.111.111-11</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style="table-row">
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Telefone
                                                        <span class="input-xlarge uneditable-input">(11)91111-11111</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Email
                                                        <span class="input-xlarge uneditable-input">joao.silva@gmail.com</span>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                          </div>
                                    </fieldset>
                                    <fieldset>
                                        <legend>Endereço</legend>
                                        <div style ="width:100%; display=table";>
                                            <div style="table-row">
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Endereco
                                                        <span class="input-xlarge uneditable-input">Avenida José da Silva</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Numero
                                                        <span class="input-xlarge uneditable-input">1000</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Complemento
                                                        <span class="input-xlarge uneditable-input">apto 52</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style="table-row">
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Bairro
                                                        <span class="input-xlarge uneditable-input">Bela Vista</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Cidade
                                                        <span class="input-xlarge uneditable-input">São Paulo</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Estado
                                                        <span class="input-xlarge uneditable-input">SP</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style="table-row">
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        CEP
                                                        <span class="input-xlarge uneditable-input">XXXXX-XXX</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Tipo de Endereco
                                                        <span class="input-xlarge uneditable-input">Entrega</span>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                          </div>
                                      </fieldset>
                                      <fieldset>
                                        <legend>Status</legend>
                                          <div class="control-group">
                                            <select class="span6 m-wrap" name="status">
                                                <option value="">Selecionar Status</option>
                                                <option value="Category 1">ATIVO</option>
                                                <option value="Category 2">INATIVO</option>
                                            </select>
                                          <button type="submit" class="btn btn-primary">Atualizar</button>
                                          </div>
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
        <script src="assets/DT_bootstrap.js"></script>
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
            var codCliente = myTable.rows[r].cells[0].innerText;
            document.getElementById("myInputCliente").value = codCliente;
        }
    </script>
    </body>

</html>