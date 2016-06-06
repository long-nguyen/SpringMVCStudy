<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="<c:url value="/scripts/jquery.1.12.4.min.js" />"></script>
<script src="<c:url value="/scripts/jquery.autocomplete.min.js" />"></script>
<link href="<c:url value="/styles/common.css" />" rel="stylesheet">
</head>
<body>
  <h2>Spring MVC + jQuery + Autocomplete example</h2>

  <div>
	<input type="text"  id="w-input-search" value="">
	<span>
	  <button id="button-id" type="button">Search</button>
	</span>
  </div>
	
  <script>
  $(document).ready(function() {
	$('#w-input-search').autocomplete({
		serviceUrl: '${pageContext.request.contextPath}/getTags',
		paramName: "",
		delimiter: ",",
	  	transformResult: function(response) {
		return {      	
		  //must convert json to javascript object before process
		  suggestions: $.map($.parseJSON(response), function(item) {
		      return { value: item.tagName, data: item.id };
		   })
		 };
		}
	 });		
  });
  </script>
	
</body>
</html>