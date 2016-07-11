<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City Table</title>
<link rel="stylesheet" href="styles/kendo.common.min.css" />
<link rel="stylesheet" href="styles/kendo.default.min.css" />
<link href="styles/kendo.common.min.css" rel="stylesheet">
<link href="styles/kendo.default.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<kendo:grid name="Table" pageable="true" resizable="true">
					<kendo:grid-editable mode="popup" />
					<kendo:grid-pageable pageSizes="true" refresh="true"
						buttonCount="3" />
					<kendo:grid-toolbar>
						<kendo:grid-toolbarItem name="create" />
					</kendo:grid-toolbar>

					<kendo:dataSource pageSize="5">
						<kendo:dataSource-transport>
							<kendo:dataSource-schema total="Total" data="Data" />
							<kendo:dataSource-transport-read url="DD" />
							<kendo:dataSource-transport-update url="DD?update" type="post" />
							<kendo:dataSource-transport-create url="DD?create" type="post" />
							<kendo:dataSource-transport-destroy url="DD?destroy" type="post" />
						</kendo:dataSource-transport>
						<kendo:dataSource-schema>
							<kendo:dataSource-schema-model id="id">
								<kendo:dataSource-schema-model-fields>
									<kendo:dataSource-schema-model-field name="name">
										<kendo:dataSource-schema-model-field-validation
											required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="district">
										<kendo:dataSource-schema-model-field-validation
											required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="countrycode">
										<kendo:dataSource-schema-model-field-validation
											required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="population">
										<kendo:dataSource-schema-model-field-validation
											required="true" />
									</kendo:dataSource-schema-model-field>
								</kendo:dataSource-schema-model-fields>
							</kendo:dataSource-schema-model>
						</kendo:dataSource-schema>
					</kendo:dataSource>
					<kendo:grid-columns>
						<kendo:grid-column title="Name" field="name"></kendo:grid-column>
						<kendo:grid-column title="District" field="district"></kendo:grid-column>
						<kendo:grid-column title="CountryCode" field="countrycode"></kendo:grid-column>
						<kendo:grid-column title="Population" field="population"></kendo:grid-column>
						<kendo:grid-column>
							<kendo:grid-column-command>
								<kendo:grid-column-commandItem name="edit"></kendo:grid-column-commandItem>
								<kendo:grid-column-commandItem name="destroy"></kendo:grid-column-commandItem>

							</kendo:grid-column-command>
						</kendo:grid-column>
					</kendo:grid-columns>
				</kendo:grid>
			</div>
		</div>
	</div>
</body>
</html>