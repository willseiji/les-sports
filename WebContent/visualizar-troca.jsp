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
                            <li class="dropdown">
                                <a href="site_principal.html">Site</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle">Configura��es <b class="caret"></b>

                                </a>
                                
                            </li>
                            
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Usu�rios <i class="caret"></i>

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
                            <a href="menu_grafico.html"><i class="icon-chevron-right"></i> Gr�ficos</a>
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
                                    <li style="display: inline" border-right: 1px solid #bbb;><a href="menu_trocas.html">Lista</a></li>
                                    
                                    
                                </ul>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal">
                                         
                                         
                                    
                                         <fieldset>
                                        <legend>Status da Troca</legend>
                                        <div style ="width:100%; display=table";>
                                            <div style="table-row">
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        C�digo
                                                        <span class="input-xlarge uneditable-input">${itens_Troca[1]}</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Data
                                                        <span class="input-xlarge uneditable-input">${itens_Troca[2]}</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        Valor (R$)
                                                        <span class="input-xlarge uneditable-input">${itens_Troca[3]}</span>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                            <div style="table-row">
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                        De
                                                        <span class="input-xlarge uneditable-input" id="status_de">${itens_Troca[4]}</span>
                                                    </div>
                                                </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <div class="control-group">
                                                    Para
                                                    <br>
                                                         <select name="tipo_status" id="status_para">
                                                             <option value=""></option>
                                                            <option value="TROCA APROVADA">TROCA APROVADA</option>
                                                            
                                                        </select>
                                                    </div>
  							                   </div>
                                                <div style="width: 300px; display: table-cell;">
                                                    <br>
                                                    <input type="hidden" id="txt_id" name="txt_id" value="${itens_Troca[0]}">
                                                    <input type="hidden" id="status_input" name="txt_Status" value="">
													
                                                    <button type="submit" class="btn btn-primary"  name="operacao" formaction="AlterarTroca" 
                                                    		value="ALTERAR" onclick="atualizar_status()">Atualizar</button>
                                                </div>
                                            </div>
                                          </div>
                                    </fieldset>
                                    
                                         <fieldset>
                                    <legend>Itens da Troca</legend>
                                         
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
										<thead>
											<tr>
												<th>Cod. Produto</th>
												<th>Produto</th>
												<th>Qtde</th>
												<th>Pre�o Unit</th>
                                                <th>Subtotal</th>
                                                <th>Motivo da Troca</th>
                                                
												
											</tr>
										</thead>
										<tbody>
											<c:forEach var="itensItensTroca" items="${listaItensItensTroca}">
		                         			<c:if test="${not empty itensItensTroca}">
		                         																
                                              <tr class="odd gradeX">
                                              <td><a style="text-decoration: underline">${itensItensTroca[1]}</a></td>
													<td>${itensItensTroca[2]}, ${itensItensTroca[3]}, ${itensItensTroca[4]}, tamanho ${itensItensTroca[5]}, ${itensItensTroca[6]}g</td>
													<td class="center"> ${itensItensTroca[7]}</td>
													<td class="center">R$ ${itensItensTroca[8]}</td>
													<td class="center">R$ ${itensItensTroca[9]}</td>
													<td class="center">${itensItensTroca[10]}</td>
											</tr>
                                            </c:if>
					    	              </c:forEach>
										</tbody>
									</table>
                                        
                                    </fieldset>
                                         <fieldset>
                                                <input type="hidden" id="txt_id" name="txt_IdCliente" value="${itens_Troca[5]}">
                                                <input type="hidden" id="txt_id" name="txt_Total" value="${itens_Troca[3]}">
                                                <button type="submit" class="btn btn-primary"  name="operacao" formaction="CadastrarCupom" 
                                                    		value="SALVAR" >Gerar Cupom</button>
                                                <p class="input-xlarge uneditable-input" id="codigo_cupom"></p>
                                         </fieldset>
                                                
                                    </div>
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
        
        
    <script>
        function atualizar_status(){
            var txt_status_de = document.getElementById("status_de").innerHTML;
            var txt_status_para = document.getElementById("status_para").value;
            document.getElementById("status_input").value=txt_status_para;
        }
    </script>
        
    <script>
        function gerar_cupom(){
            document.getElementById("codigo_cupom").innerHTML="XXX00003";
        }
    </script>
        
    </body>

</html>