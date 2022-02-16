<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<main>
    <div class="container">
        <div id="title" class="h1">Following</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <div class="row">
                <div class="col-sm">
                    <table class="table text-white">
                        <thead>
                        <tr>
                            <th class="h3" scope="col"></th>
                            <th class="h3" scope="col" colspan="3">User</th>
                            <th class="h3" scope="col">Skills Practicing</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${following}" var="following">
                            <tr style="background-color: #6a994e !important">
                                <td>
                      <span class="fa-stack fa-2x">
                        <i class="fa fa-circle fa-stack-2x"></i>
                        <i class="fa ${following.profile_icon} fa-stack-1x text-black"></i>
                      </span>
                                </td>
                                <td colspan="3" class="h4 align-middle">${following.username}</td>
                                <td class="h4 align-middle">${following.skills_practicing}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="../include/footer.jsp"/>