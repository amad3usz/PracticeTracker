<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<div
        class="modal fade"
        id="FriendModal"
        tabindex="-1"
        aria-labelledby="friendModalLabel"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="friendModalLabel">Modal title</h5>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
            </div>
            <div class="modal-body">
                <p id="friendAddRemove"></p>
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                    Close
                </button>
            </div>
        </div>
    </div>
</div>
<main>
    <div class="container">
        <div id="title" class="h1">${user.username}</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <div class="row">
                <div class="col-sm text-center">
                    <p class="h1">${user.firstName} ${user.lastName}</p>
                    <span class="fa-stack fa-5x">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa ${user.profileIcon} fa-stack-1x text-black"></i>
              </span>
                </div>
            </div>
            <div class="row">
                <div class="col-sm h3">
                    I'm currently working on...<br/>
                    ${user.skillsPracticing}
                </div>
                <div class="col-sm h3 text-center">

                    <c:choose>

                        <c:when test="${user1 != user2}">
                            <c:choose>
                                <c:when test="${exists}">
                                    Following<br/>
                                </c:when>
                                <c:otherwise>
                                    Not Following<br/>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${exists}">
                                    <a href="/user/unfollow?id=${user.id}">
                                        <i class="fa-solid fa-user-minus text-black"></i></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/user/follow?id=${user.id}">
                                        <i class="fa fa-user-plus text-black"></i></a>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            This is you!
                        </c:otherwise>

                    </c:choose>

                </div>
            </div>
            <div class="row">
                <div class="col-sm h3 text-center">My 3 Most Recent Sessions</div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <table class="table text-white">
                        <thead>
                        <tr>
                            <th class="h3" scope="col">Date</th>
                            <th class="h3" scope="col" colspan="3">Session Name</th>
                            <th class="h3" scope="col">Time Spent</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach begin="0" end="2" items="${userSession}" var="userSession">
                            <tr style="background-color: #6a994e !important">
                                <td>${userSession.date}</td>
                                <td colspan="3">${userSession.sessionName}</td>
                                <td>${userSession.time} minutes</td>
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