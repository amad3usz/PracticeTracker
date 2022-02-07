<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp" />


<main>
    <div class="container">
        <div id="title" class="h1">Search</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <div class="row">
                <div class="col-sm text-center">

                    <form method="get" action="/userList/userList">
                        <input type="text" name="search" value="${searchInput}">
                        <button type="submit">Search</button>
                    </form>


                        <c:if test="${ userListKey != null || userListKey.id != ''}">
<%--                            not sure what to do here to not show this if the resulting --%>
                            <table>
                                <tr>
                                    <td><b>Id</b></td>
                                    <td><b>Username</b></td>
                                    <td><b>Email</b></td>
                                    <td><b>First Name</b></td>
                                    <td><b>Last Name</b></td>
                                    <td><b>Password</b></td>
                                    <td><b>Password</b></td>
                                </tr>
                                <c:forEach items="${userListKey}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.username}</td>
                                        <td>${user.email}</td>
                                        <td>${user.firstName}</td>
                                        <td>${user.lastName}</td>
                                        <td>${user.password}</td>
                                        <td><a href="/editUserList/registerEdit?id=${user.id}">Edit</a></td>
                                    </tr>

                                </c:forEach>
                            </table>
                        </c:if>
                        <c:if test="${userListKey  == null}">
                            <p>Input the username you are searching for.</p>
                        </c:if>



                </div>
            </div>
        </div>
    </div>
</main>


<jsp:include page="../include/footer.jsp" />