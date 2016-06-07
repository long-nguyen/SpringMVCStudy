<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Error Page</h1>
<p>Application has encountered an error. Please contact support on
	...</p>
<c:if test="${not empty errMsg}">
	<h2>${errMsg}</h2>
</c:if>
<!--
    Failed URL: ${url}
    Exception:  ${exception.message}
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
    </c:forEach>
    -->