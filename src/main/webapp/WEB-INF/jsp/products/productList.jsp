<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vets">
    <h2>Veterinarians</h2>

    <table id="productTable" class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
           
            <th>Price</th>
            <th>Product Type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>
                    <c:out value="${product.id}"></c:out>
                </td>
                <td>
                    <c:out value="${product.name}"/>
                </td>
                
                <td>
                    <c:out value="${product.price}$"></c:out>
                </td>
                <td>
                    <c:out value="${product.productType.getName()} "></c:out>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <sec:authorize access="hasAuthority('admin')">
		<a class="btn btn-default" href='<spring:url value="/product/create" htmlEscape="true"/>'>Add Owner</a>
	</sec:authorize>
</petclinic:layout>
