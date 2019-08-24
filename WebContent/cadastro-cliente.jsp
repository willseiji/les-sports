<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>Forms</title>
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
	     	<div class="search_box">
	     		<form>
	     			<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
	     		</form>
	     	</div>
	     	<div class="clear"></div>
	     </div>	     
	
  
    <div class="container-fluid">
        <div class="row-fluid">
            <!--/span-->
            <div class="span9" id="content" style="margin-left: 150px">
                  <!-- morris stacked chart -->
                <h2 style="text-align: center">Cadastro do Cliente</h2>
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
                                        <li><a href="#tab1" data-toggle="tab">Dados Pessoais</a></li>
                                        <li><a href="#tab2" data-toggle="tab">Endereço</a></li>
                                        
                                    </ul>
                                     </div>
                                      </div>
                                    </div>
                                    <div id="bar" class="progress progress-striped active">
                                      <div class="bar"></div>
                                    </div>
                                    <form class="form-horizontal" name="clienteForm" method="post">
                                        
                                    <div class="tab-content">
                                        <div class="tab-pane" id="tab1">
                                            
                                              <fieldset>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Nome</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_NmCliente" id="id_NmCliente" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Data de Nascimento</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_DtNasc" id="id_DtNasc" type="text" placeholder="DD/MM/AAAA">
                                                  </div>
                                                </div>
                                          <div class="control-group">
                                          <label class="control-label" for="select01">Sexo</label>
                                          <div class="controls">
                                            <select name ="txt_Sexo" id="id_Sexo">
                                              <option></option>
                                                <option>Masculino</option>
                                                <option>Feminino</option>
                                              
                                            </select>
                                          </div>
                                        </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">RG</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_RG" id="id_RG" type="text" placeholder="somento numeros">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">CPF</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_CPF" id="id_CPF" type="text" placeholder="somente numeros">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Email</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Email" id="id_Email" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Telefone</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Telefone" id="id_Telefone" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Login</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Login" id="id_Login" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Senha</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Senha" id="id_Senha" type="password" value="">
                                                  </div>
                                                </div>
                                                 <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Repita Senha</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Senha2" id="id_Senha2" type="password" value="">
                                                  </div>
                                                </div>
                                              </fieldset>
                                           
                                        </div>
                                        <div class="tab-pane" id="tab2">
                                           
                                              <fieldset>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Endereço</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Rua" id="id_Rua" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Número</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_EnderecoNum" id="id_EnderecoNum" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Complemento</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Complemento" id="id_Complemento" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Bairro</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Bairro" id="id_Bairro" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">CEP</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_CEP" id="id_CEP" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Cidade</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Cidade" id="id_Cidade" type="text" value="">
                                                  </div>
                                                </div>
                                                <div class="control-group">
                                                  <label class="control-label" for="focusedInput">Estado</label>
                                                  <div class="controls">
                                                    <input class="input-xlarge focused" name ="txt_Estado" id="id_Estado" type="text" value="">
                                                  </div>
                                                </div>
                                                
                                                <div class="control-group">
  								                  <label class="control-label">Tipo de Endereço</label>
  								                  <div class="controls">
  									                 <select name ="txt_TipoEndereco" id="id_TipoEndereco">
                                                        <option value=""></option>
                                                        <option value="end_entrega">Entrega</option>
                                                        <option value="end_cobranca">Cobrança</option>
                                                    </select>
  								                  </div>
  							                   </div>
                                                  
                                                  <div class="control-group">
                                                  <label class="control-label" for="optionsCheckbox">Endereço Principal</label>
                                                  <div class="controls">
                                                    <label class="uniform">
                                                      <input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1">
                                                      
                                                    </label>
                                                  </div>
                                                </div>
                                                    
                                                <div class="form-actions">
                                                    <button type="submit" class="btn btn-primary" name="operacao" formaction="CadastrarCliente" value="SALVAR">Salvar</button>
                                                    <button type="button" class="btn">Cancelar</button>
                                                </div>
                                                
                                                  
                                              </fieldset>
                                                
                                        </div>
                                        
                                  
                                             
                                        <ul class="pager wizard">
                                            <li class="previous first" style="display:none;"><a href="javascript:void(0);">Primeiro</a></li>
                                            <li class="previous"><a href="javascript:void(0);">Anterior</a></li>
                                            <li class="next last" style="display:none;"><a href="javascript:void(0);">Último</a></li>
                                            <li class="next"><a href="javascript:void(0);">Próximo</a></li>
                                            <li class="next finish" style="display:none;"><a href="javascript:;">Fim</a></li>
                                        </ul>
                                    </div>  
                                        </form>
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