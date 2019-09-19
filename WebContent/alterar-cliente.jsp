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
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
<link href="assets/styles.css" rel="stylesheet" media="screen">
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
						<li class="dropdown"><a href="site_principal.html"
							target="_blank">Site</a></li>
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
					<li class="active"><a href="menu_grafico.html"><i
							class="icon-chevron-right"></i> Gráficos</a></li>
				</ul>
			</div>
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
												<div style="width: 200px; display: table-cell;">
													<div class="control-group">
														Status <input type="text" class="input-xlarge focused"
															name="txt_Status" id="id_Status"
															value='${itensCliente[8]}'>
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
		<footer> </footer>
	</div>
	<!--/.fluid-container-->

	<link href="vendors/datepicker.css" rel="stylesheet" media="screen">
	<link href="vendors/uniform.default.css" rel="stylesheet"
		media="screen">
	<link href="vendors/chosen.min.css" rel="stylesheet" media="screen">

	<link href="vendors/wysiwyg/bootstrap-wysihtml5.css" rel="stylesheet"
		media="screen">


	<script src="vendors/jquery-1.9.1.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="vendors/jquery.uniform.min.js"></script>
	<script src="vendors/chosen.jquery.min.js"></script>
	<script src="vendors/bootstrap-datepicker.js"></script>

	<script src="vendors/datatables/js/jquery.dataTables.min.js"></script>
	<script src="vendors/wysiwyg/wysihtml5-0.3.0.js"></script>
	<script src="vendors/wysiwyg/bootstrap-wysihtml5.js"></script>

	<script src="vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

	<script type="text/javascript"
		src="vendors/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="assets/form-validation.js"></script>

	<script src="assets/scripts.js"></script>
	<script src="assets/DT_bootstrap.js"></script>
	    <script>
        var mensagem = '${msg}';
        if (mensagem.length !== 0) {
            alert(mensagem);
        }
    </script>
    
</body>

</html>