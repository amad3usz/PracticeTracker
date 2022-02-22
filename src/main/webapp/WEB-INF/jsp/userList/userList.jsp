<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp"/>


<main>
    <div class="container">
        <div id="title" class="h1">Search</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <div class="row">
                <div class="col-sm text-center">

                    <form method="get" action="/user/userList"><div class="row justify-content-center">
                        <div class="col-4">
                            <input class="form-control form-control-lg" type="text" name="search" value="${searchInput}">
                        </div>
                        <div class="col-2">
                            <button class="btn-primary btn-lg" type="submit">Search</button>
                        </div>
                    </div>


                    </form>

                    <table class="table text-white">
                        <thead>
                        <tr>
                            <th class="h3" scope="col"> </th>
                            <th class="h3" scope="col">
                                Username
                            </th>
                            <th class="h3" scope="col" colspan="3">Name</th>
                        </tr>
                        </thead>
                        <c:forEach items="${userListKey}" var="user">
                            <tr style="background-color: #6a994e !important">
                                <td><span class="fa-stack fa-2x">
                        <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa ${user.profileIcon} fa-stack-1x text-black"></i></span></td>
                                <td class="h4 align-middle"><a class="text-white"
                                                               href="/user/profile?id=${user.id}">${user.username}</a>
                                </td>
                                <td colspan="3" class="h4 align-middle"><a class="text-white"
                                                                           href="/user/profile?id=${user.id}">${user.firstName} ${user.lastName}</a>
                                </td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <c:if test="${userListKey  == null}">
                        <p>Input the username you are searching for.</p>
                    </c:if>


                </div>
            </div>
        </div>
    </div>
</main>


<jsp:include page="../include/footer.jsp"/>