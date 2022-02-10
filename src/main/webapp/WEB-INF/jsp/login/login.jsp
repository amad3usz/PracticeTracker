<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<main>
    <div class="container">
        <div id="title" class="h1">LOGIN</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <form action="/login/loginSecurityPost" method="POST">
                <div class="form-group row">
                    <div class="col-sm">
                        <label for="username" class="form-label">Username</label>
                        <input
                                id="username"
                                type="text"
                                name="username"
                                placeholder="Enter Your Username"
                                pattern="^[A-Za-z0-9]{1,15}$"
                                title="Must contain any assortment of letters and numbers, and is at most 15 characters long"
                                class="form-control"
                                required
                        />
                    </div>

                    <div class="col-sm">
                        <label for="password" class="form-label">Password</label>
                        <input
                                id="password"
                                type="password"
                                name="password"
                                placeholder="Enter Your Password"
                                class="form-control"
                                required
                        />
                    </div>
                    <p style="color:#ff0000">${errorMessage}</p>
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
                            <a href="/registration/register">here</a> to sign up!
                        </p>
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>


<jsp:include page="../include/footer.jsp" />