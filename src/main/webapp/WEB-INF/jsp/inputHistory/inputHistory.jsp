<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="../include/header.jsp" />

<main>
    <div class="container">
        <div id="title" class="h1">My Entries</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <div class="row">
                <div class="col-sm">
                    <table class="table text-white">
                        <thead>
                        <tr>
                            <th class="h3 twenty" scope="col">Date</th>
                            <th class="h3 sixty" scope="col" colspan="3">
                                Session Name
                            </th>
                            <th class="h3 twenty" scope="col">Time Spent</th>
                        </tr>
                        </thead>
<c:forEach items="${userSession}" var="userSession">
                        <tr>
                            <td>${userSession.date}</td>
                            <td colspan="3">${userSession.session_name}</td>
                            <td>${userSession.time} minutes</td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                Notes: ${userSession.notes}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1">Rating:
                                <c:if test = "${userSession.rating == 5}">★★★★★</c:if>
                                <c:if test = "${userSession.rating == 4}">★★★★</c:if>
                                <c:if test = "${userSession.rating == 3}">★★★</c:if>
                                <c:if test = "${userSession.rating == 2}">★★</c:if>
                                <c:if test = "${userSession.rating == 1}">★</c:if></td>
                            <td colspan="3">Session Type: ${userSession.session_id}  ${userSession.session_type}</td>



<%----%>
                            <td>
                                <a class="btn btn-primary"  role="button" href="/user/dataEntryEdit?id=${userSession.id}">Edit</a>
                                <a class="btn btn-danger deleteEntry" role="button" href="/user/deleteEntry?id=${userSession.id}">Delete</a></td>
                        </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="../include/footer.jsp" />