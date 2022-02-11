<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp" />


<main>
    <div class="container">
        <div id="title" class="h1">SUCCESS</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <div class="row">
                <div class="col-sm text-center">
                        <sec:authorize access="isAuthenticated()">
                            <p>You have successfully updated your account!</p>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <p>You have successfully registered!</p>
                            <p>
                                Click
                                <a href="/login">here</a> to login!
                            </p>
                        </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</main>


<jsp:include page="../include/footer.jsp" />