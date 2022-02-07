<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp"/>

<main>
    <div class="container">
        <div id="title" class="h1">LOGIN</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >

            <div class="row">
                <div class="col-sm text-center">
                    <p>Hello ${loggedInUser}!</p>
                    <a href="/logout" methods="GET">LOGOUT</a>
                </div>
            </div>

        </div>
    </div>
</main>


<jsp:include page="../include/footer.jsp"/>

