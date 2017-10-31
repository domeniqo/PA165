<%-- 
    Document   : podoli
    Created on : 31.10.2017, 16:40:23
    Author     : xmlynka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<fmt:message var="title" key="podoli.title"/>
<my:pagetemplate title="${title}">
    <jsp:attribute name="head">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/mystyle.css"/>
    </jsp:attribute>
<jsp:attribute name="body">
    <c:out value="${author}"/>
</jsp:attribute>
</my:pagetemplate>
