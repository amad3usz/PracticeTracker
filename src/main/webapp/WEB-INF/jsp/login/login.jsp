<jsp:include page="../include/header.jsp" />


<%--<body>--%>

<%--<form method="GET" action="/loginSubmit">--%>
<%--    username: <input type="text" name="username">--%>
<%--    <br>--%>
<%--    password: <input type="password" name="password">--%>
<%--    <br>--%>
<%--    <button type="submit">submit</button>--%>
<%--</form>--%>
<%--</body>--%>

<main>
    <div class="container">
        <div id="title" class="h1">LOGIN</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <form action="/loginSubmit">
                <div class="form-group row">
                    <div class="col-sm">
                        <label for="username" class="form-label">Username</label>
                        <input
                                id="username"
                                type="text"
                                name="usernameLogin"
                                placeholder="Enter Your Username"
                                pattern="^[A-Za-z0-9]{1,15}$"
                                title="Must contain any assortment of letters and numbers, and is at most 15 characters long"
                                class="form-control"
                                required
                        />
                        <p style="color:#ff0000">${errorMessage}</p>
                    </div>

                    <div class="col-sm">
                        <label for="password" class="form-label">Password</label>
                        <input
                                id="password"
                                type="password"
                                name="passwordLogin"
                                placeholder="Enter Your Password"
                                class="form-control"
                                required
                        />
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="col-sm text-center">
                        <button class="btn btn-primary" type="submit">Login</button>
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="col-sm text-center">
                        <p>
                            Not a registered user? Click
                            <a href="/register.html">here</a> to sign up!
                        </p>
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>


<jsp:include page="../include/footer.jsp" />