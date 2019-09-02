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
                            <a href="menu_produto.jsp"><i class="icon-chevron-right"></i> Produto</a>
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
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="cadastro_produto.jsp">Cadastrar</a></li>
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="dados_produto.jsp">Consultar</a></li>
                                </ul>
                            </div>
                            
                            
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal" name="alterarForm" method="post" >
										                                                                               
                                         <fieldset>
                                        <legend>Dados do Produto</legend>
                                       <div style ="width:100%; display=table">
                                            <div style="table-row">
            	
                                                <div style="width: 200px; margin-right: 20px; display: table-cell;">
                                                	<div class="control-group">
                                                        Código
                                                        <span class="input-xlarge uneditable-input">${itensProduto[1]}</span>
                                                        <input type="hidden" class="form-control" name="txt_Codigo" value='${itensProduto[1]}'>
                                                	</div>
                                                </div>
                                                <div style="width: 200px; margin-right: 20px; display: table-cell;">
                                                	<div class="control-group">
                                                     	Nome
                                                     	<input type="text" class="input-xlarge focused"  name ="txt_NmProduto" id="id_NmProduto" value='${itensProduto[2]}'>
                                                	</div>
                                                </div>
                                                <div style="width: 200px; display: table-cell;">
                                                    <div class="control-group">
                                                        Categoria
                                                        <input type="text" class="input-xlarge focused" name ="txt_Categoria" id="id_Categoria" value='${itensProduto[3]}'>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                            <div style="table-row">
                                            <div style="width: 200px; margin-right: 20px; display: table-cell;">
                                                    <div class="control-group">
                                                        Material
                                                        <input type="text" class="input-xlarge focused" name ="txt_Material" id="id_Material" value='${itensProduto[4]}'>
                                                    </div>
                                                </div>
                                                <div style="width: 200px; margin-right: 20px; display: table-cell;">
                                                    <div class="control-group">
                                                        Tamanho
                                                        <input type="text" class="input-xlarge focused" name ="txt_Tamanho" id="id_Tamanho" value='${itensProduto[5]}'>
                                                    </div>
                                                </div>
                                                <div style="width: 200px; display: table-cell;">
                                                    <div class="control-group">
                                                        Peso (g)
                                                        <input type="text" class="input-xlarge focused" name ="txt_Peso" id="id_Peso" value='${itensProduto[6]}'>
                                                    </div>
                                                </div>
                                                
                                                
                                            </div>
                                            <div style="table-row">
                                            	<div style="width: 200px; margin-right: 20px; display: table-cell;">
                                                    <div class="control-group">
                                                        Fabricante
                                                        <input type="text" class="input-xlarge focused" name ="txt_Fabricante" id="id_Fabricante" value='${itensProduto[7]}'>
                                                    </div>
                                                </div>
                                                <div style="width: 200px; margin-right: 20px; display: table-cell;">
                                                    <div class="control-group">
                                                        Preço
                                                        <span class="input-xlarge uneditable-input">${itensProduto[8]}</span>
                                                    </div>
                                                </div>
                                                <div style="width: 200px; display: table-cell;">
                                                    <div class="control-group">
                                                        Quantidade
                                                        <span class="input-xlarge uneditable-input">${itensProduto[9]}</span>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                            <div style="table-row">
                                                <div style="display: table-cell;">
                                                    <div class="control-group">
                                                    <p>Descrição</p>
                                                        
                                                        <textarea placeholder=" " style="width: 710px; height: 200px" name ="txt_Descricao" id="id_Descricao" >${itensProduto[10]}
                                                            </textarea>
                                                    
                                                    </div>
                                              
                                                </div>
                                                
                                            </div>
                                          </div>
                                    </fieldset>
                                      <fieldset>
                                        <legend>Status</legend>
                                          <div class="control-group">
                                              <label class="control-label">Status</label>
                                              <div class="controls">
                                                  <span class="input-xlarge uneditable-input">${itensProduto[11]}</span>
                                              </div>
                                          </div>
                                          <div class="control-group">
                                                <label class="control-label" for="optionsCheckbox">Inativar Produto</label>
                                                <div class="controls">
                                                <label class="uniform">
                                                  <input class="uniform_on" type="checkbox" value="INATIVO" name ="txt_Status" id="id_Status">
                                                    
                                                </label>
                                            </div>
                                          </div>
                                          <div class="control-group">
                                            <label class="control-label" for="textarea2">Motivo para inativação</label>
                                            <div class="controls">
                                                <textarea placeholder=" " style="width: 300px; height: 50px"></textarea>
                                            </div>
                                            </div>
                                            <button type="submit" class="btn btn-primary"  name="operacao" formaction="AlterarProduto" value="ALTERAR">Atualizar</button>
                                          
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
        var mensagem = '${msg}';
        if (mensagem.length !== 0) {
            alert(mensagem);
        }
    </script>
    
    </body>

</html>