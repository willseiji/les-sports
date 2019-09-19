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
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
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
                            <li class="dropdown"><a href="home.jsp"	target="_blank">Site</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle">Configurações <b class="caret"></b> </a>
                            </li>
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Usuários <i class="caret"></i></a>
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
                                <div class="muted pull-left">Estoque</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal">
                                                                                  
                                         <fieldset>
                                        <legend>Informações do Estoque</legend>
                                        <div style ="width:100%; display=table";>
                                            <div style="table-row">
                                                <div style="width:120px; display: table-cell;">
                                                    <div class="control-group">
                                                        <p>Código</p>
                                                        <span class="input-xlarge uneditable-input" style="width: 100px">XXX0001</span>
                                                    </div>
                                                </div>
                                                <div style="width:220px; display: table-cell;">
                                                    <div class="control-group">
                                                        <p>Nome</p>
                                                        <span class="input-xlarge uneditable-input" style="width: 200px">Uniforme Barcelona Classic</span>
                                                    </div>
                                                </div>
                                                <div style="width:120px; display: table-cell;">
                                                    <div class="control-group">
                                                        <p>Categoria</p>
                                                        <span class="input-xlarge uneditable-input" style="width: 100px">Roupa</span>
                                                    </div>
                                                </div>
                                                <div style="width:120px; display: table-cell;">
                                                    <div class="control-group">
                                                        <p>Fabricante</p>
                                                        <span class="input-xlarge uneditable-input" style="width: 100px">Nike</span>
                                                    </div>
                                                </div>
                                                <div style="width:170px; display: table-cell;">
                                                    
                                                    <div class="control-group">
                                                        <p>Preço</p>
                                                        <span class="input-xlarge uneditable-input" style="width: 150px">R$ 150,00</span>
                                                    </div>
                                                </div>

                                            </div>
                                            <div style="table-row">
                                                <div style="width: 170px; display: table-cell;">
                                                    <div class="control-group">
                                                        <p>Estoque Mínimo</p>
                                                        <span class="input-xlarge uneditable-input" style="width: 150px">1</span>
                                                    </div>
                                                </div>
                                                <div style="width: 170px; display: table-cell;">
                                                    <div class="control-group">
                                                        <p>Estoque Máximo</p>
                                                        <span class="input-xlarge uneditable-input" style="width: 150px">30</span>
                                                    </div>
                                                </div>
                                                <div style="width: 170px; display: table-cell;">
                                                    <div class="control-group">
                                                        <p>Estoque Atual</p>
                                                        <span class="input-xlarge uneditable-input" style="width: 150px">10</span>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                          </div>
                                    </fieldset>
                                         <br>
                                        <fieldset>
                                            <legend>Nova Movimentação</legend>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Volume</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" id="focusedInput" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Preço de Compra</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" id="focusedInput" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Preço de Venda (R$)</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge uneditable-input" type="text" value="">
                                                  </div>
                                                </div>
                                            </fieldset> 
                                         
                                    <br>
                                              <fieldset>
                                    <legend>Histórico de Movimentação</legend>
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						
										<thead>
											<tr>
                                                <th>Data do Registro</th>
												<th>Preço de Compra</th>
												<th>Preço de Venda</th>
												<th>Volume</th>

											</tr>
										</thead>
										<tbody>
											<tr class="odd gradeX">
                                                <td>11/08/2019</td>
                                                <td>R$ 130,00</td>
                                                <td>R$ 150,00</td>
                                                <td>R$ 10</td>
											</tr>
                                            <tr class="odd gradeX">
                                                <td>11/07/2019</td>
                                                <td>R$ 130,00</td>
                                                <td>R$ 150,00</td>
                                                <td>R$ 10</td>
											</tr>
                                            <tr class="odd gradeX">
                                                <td>11/06/2019</td>
                                                <td>R$ 130,00</td>
                                                <td>R$ 150,00</td>
                                                <td>R$ 10</td>
											</tr>
											
										</tbody>
												</table>
                                         </fieldset>
                                    
                                        <br> 
                                         <fieldset>
                                    <legend>Lista de Estoque</legend>
                                         
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
										<thead>
											<tr>
												<th>Codigo</th>
												<th>Descrição</th>
												<th>Status</th>
												
											</tr>
										</thead>
										<tbody>
											<tr class="odd gradeX">
                                                <td><a style="text-decoration: underline">XXX00000</a></td>
												<td>Bola de Futebol XXXX Penalty</td>
												<td class="center">ATIVO</td>
												
											</tr>
											<tr class="odd gradeX">
                                                <td><a style="text-decoration: underline">XXX00001</a></td>
												<td>Uniforme Barcelona Classic</td>
												<td class="center">ATIVO</td>
											</tr>
                                            <tr class="odd gradeX">
                                                <td><a style="text-decoration: underline">XXX00002</a></td>
												<td>Meiao Branco XL</td>
												<td class="center">ATIVO</td>
											</tr>
                                            <tr class="odd gradeX">
                                                <td><a style="text-decoration: underline">XXX00003</a></td>
												<td>Agasalho Corinthians</td>
												<td class="center">ATIVO</td>
											</tr>
											
										</tbody>
									</table>
                                    
                                        
                                    </fieldset>
                                    
                                         
                                    
                                         
                                    <hr>                                         
                                         
                                         
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