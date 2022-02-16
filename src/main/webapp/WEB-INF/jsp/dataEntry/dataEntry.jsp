<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="../include/header.jsp" />

<main>
    <div class="container">
        <div id="title" class="h1">INPUT SESSION</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <form:form method="POST" action="/user/dataEntrySubmit" modelAttribute="form">
                <div class="form-group row">
                    <div class="col-lg">
                        <label for="Date" class="form-label">Date of Session:
                        <form:input
                                id="Date"
                                type="date"
                                cssClass="form-control form-control-lg"
                                required="true"
                                path="date"
                        /></label>

                    </div>
                    <div class="col-lg">
                        <label
                        >Session Type:</label>
                            <form:select
                                    class="form-control form-control-lg dropdown"
                                    list="sessionType"
                                    name="mySession"
                                    required="true"
                                    path="sessionId"

                            >
                        <c:forEach items="${session}" var="s">
                            <form:option value="${s.sessionId}" label="${s.sessionType}"/>
                        </c:forEach>
                        </form:select>
                    </div>
                    <div class="col-lg">
                        <label
                        >Name of New Session:
                        <form:input
                                id="newSession"
                                type="text"
                                cssClass="form-control form-control-lg"
                                path="sessionName"
                        /></label>
                        </datalist>
                    </div>
                    <div class="col-lg">
                        <label
                        >Time Spent in Minutes:
                            <form:input
                                    id="time"
                                    type="number"
                                    class="form-control form-control-lg"
                                    name="myTime"
                                    path="time"
                            /></label>
                    </div>
                    <div class="col-lg">
                        <label for="rating">Session Rating: </label>
                        <form:select
                                id="rating"
                                cssClass="form-control form-control-lg dropdown"
                                path="rating"
                        ></label>
                        <form:option value="5" label="★★★★★"/>
                        <form:option value="4" label="★★★★"/>
                        <form:option value="3" label="★★★"/>
                        <form:option value="2" label="★★"/>
                        <form:option value="1" label="★"/>
                        </form:select>
                    </div>
                </div>
                <br />
                <div class="form-group row">
                    <div class="col">
                        <label for="notes" class="form-label">Session Notes:</label>
                        <form:textarea
                                class="form-control form-control-lg"
                                id="notes"
                                rows="4"
                                path="notes"
                                />
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="col-sm text-center">
                        <c:forEach var="message" items="${form.errorMessages}" varStatus="status">
                            <span style="color:red">${message}</span><br/>
                        </c:forEach>
                        <button class="btn btn-primary" type="submit">
                            Record Your Session
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</main>

<jsp:include page="../include/footer.jsp" />