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
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Admin Panel</a>
				<div class="nav-collapse collapse">
					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" role="button"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="icon-user"></i> Admin <i class="caret"></i>

						</a>
							<ul class="dropdown-menu">
								<li><a tabindex="-1" href="#">Profile</a></li>
								<li class="divider"></li>
								<li><a tabindex="-1" href="login.html">Logout</a></li>
							</ul></li>
					</ul>
					<ul class="nav">
						<li class="active"><a href="#">Dashboard</a></li>
						<li class="dropdown"><a href="home.jsp"	target="_blank">Site</a></li>
						<li class="dropdown"><a href="#" data-toggle="dropdown"
							class="dropdown-toggle">Configurações <b class="caret"></b>
						</a></li>
						<li class="dropdown"><a href="#" role="button"
							class="dropdown-toggle" data-toggle="dropdown">Usuários <i
								class="caret"></i>
						</a>
							<ul class="dropdown-menu">
								<li><a tabindex="-1" href="#">User List</a></li>
								<li><a tabindex="-1" href="#">Search</a></li>
								<li><a tabindex="-1" href="#">Permissions</a></li>
							</ul></li>
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
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="cadastro-produto.jsp">Cadastrar</a></li>
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="menu-produto.jsp">Consultar</a></li>
                                </ul>
                         
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal" name="produtoForm" method="post" >
                                      <fieldset>
                                        <legend>Cadastro de Produto</legend>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">Nome</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" name ="txt_NmProduto" id="id_NmProduto" type="text" value=" ">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="select01">Categoria</label>
                                          <div class="controls">
                                            <select name ="txt_Categoria" id="id_Categoria">
                                              <option></option>
                                              <option>Calçados</option>
                                              <option>Roupas</option>
                                              <option>Acessórios</option>
                                              <option>Equipamentos</option>
                                            </select>
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">Material</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" name ="txt_Material" id="id_Material" type="text" value=" ">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">Tamanho</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" name ="txt_Tamanho" id="id_Tamanho" type="text" value=" ">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">Peso (g)</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" name ="txt_Peso" id="id_Peso" type="text" value=" ">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">Fabricante</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" name ="txt_Fabricante" id="id_Fabricante" type="text" value=" ">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">Preco</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" name ="txt_Preco" id="id_Preco" type="text" value=" ">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">Quantidade</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" name ="txt_Quantidade" id="id_Quantidade" type="text" value=" ">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="fileInput">Inserir imagem</label>
                                          <div class="controls">
                                            <input class="input-file uniform_on" id="fileInput" type="file">
                                          </div>
                                        </div>
                                        
                                        <div class="control-group">
                                          <label class="control-label" for="textarea2">Descrição</label>
                                          <div class="controls">
                                            <textarea placeholder=" " name ="txt_Descricao" id="id_Descricao" style="width: 710px; height: 200px"></textarea>
                                          </div>
                                        </div>
                                                                                
                                        
                                        <div class="form-actions">
                                          <button type="submit" class="btn btn-primary" formaction="CadastrarProduto" name="operacao" value="SALVAR">Salvar</button>
                                          <button type="reset" class="btn">Cancelar</button>
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
        </div>

            <hr>
            <div class="footer">
        <div class="copy_right">
				<p>&copy; 2019 William S</p>
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