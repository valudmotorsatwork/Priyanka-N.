<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>World Database Presentation</title>
<link rel="stylesheet" href="styles/kendo.common.min.css" />
<link rel="stylesheet" href="styles/kendo.default.min.css" />
<link href="styles/kendo.common.min.css" rel="stylesheet">
<link href="styles/kendo.default.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script>
</head>
<body>
<h3> Welcome </h3>
	<div class="container">
		<div class="row">
			<div class="span12">
				<kendo:grid name="CreateRequest" pageable="true" resizable="true" sortable="true">
					<kendo:grid-filterable mode="row"/>
					<kendo:grid-editable mode="popup"/>
					<kendo:grid-pageable pageSizes="true" refresh="true" buttonCount="3"></kendo:grid-pageable>
				
					<kendo:dataSource pageSize="5">
						<kendo:dataSource-transport>
							<kendo:dataSource-transport-read url="CountryController" />
							<kendo:dataSource-transport-create url="CountryController?action=Create" type="post" />
						</kendo:dataSource-transport>
						<kendo:dataSource-schema>
							<kendo:dataSource-schema-model id="Code">
							<kendo:dataSource-schema-model-fields>
									<kendo:dataSource-schema-model-field name="Name" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="Continent" type="string" >
										<kendo:dataSource-schema-model-field-validation required="true"/>
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="Region" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="Population" type="number">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="Capital" type="number">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="city.Name" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="city.District" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="language.Language" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
								</kendo:dataSource-schema-model-fields>
							
							</kendo:dataSource-schema-model>
						</kendo:dataSource-schema>
					</kendo:dataSource>
					<kendo:grid-columns>
						<kendo:grid-column title="Country Name" field="Name"></kendo:grid-column>
						<kendo:grid-column title="Continent" field="Continent"></kendo:grid-column>
						<kendo:grid-column title="Region" field="Region"></kendo:grid-column>
						<kendo:grid-column title="Population" field="Population" ></kendo:grid-column>
						<kendo:grid-column title="HeadOfState" field="HeadOfState" ></kendo:grid-column>
						<kendo:grid-column title="Capital" field="Capital" ></kendo:grid-column>
						<kendo:grid-column title="City" field="city.Name" template="#: city.Name#"  editor="cityEditor"></kendo:grid-column>
						<kendo:grid-column title="District" field="city.District" template="#: city.District#" editor="districtEditor"></kendo:grid-column>
 						<kendo:grid-column title="Languages" field="language.Language" editor="languageEditor"></kendo:grid-column>
						<kendo:grid-column title="&nbsp;" width="250px">
							<kendo:grid-column-command>
								<kendo:grid-column-commandItem name="edit" />
								<kendo:grid-column-commandItem name="destroy" />
							</kendo:grid-column-command>
						</kendo:grid-column>
					</kendo:grid-columns>
				</kendo:grid>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function cityEditor(container,options)
	{
		$("<input data-text-field='city.Name' data-value-field='city.Name' data-bind='value: "+options.field+"' />")
		.appendTo(container)
		.kendoDropDownList({dataSource:{ transport:{read: "CountryController"} } });
	}
	function languageEditor(container,options)
	{
		$("<input data-text-field='language.Language' data-value-field='language.Language' data-bind='value: "+options.field+"' />")
		.appendTo(container)
		.kendoDropDownList({dataSource:{ transport:{read: "CountryController"} } });
	}
	function districtEditor(container,options)
	{
		$("<input data-text-field='city.District' data-value-field='city.District' data-bind='value: "+options.field+"' />")
		.appendTo(container)
		.kendoDropDownList({dataSource:{ transport:{read: "CountryController"} } });
	}
	</script>
	</body>
</html>