<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../include/header.jsp"/>


<main>
    <div class="container">
        <div id="title" class="h1">EDIT USER</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <form:form class="row needs-validation" id="registerForm" method="post"
                       action="/registration/registerSubmit" modelAttribute="form">
                <input type="hidden" name="id" value="${form.id}">
                <div class="col-sm-4 mt-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <form:input
                            id="firstName"
                            type="text"
                            path="firstName"
                            placeholder="Enter Your First Name"
                            pattern="^[A-Za-z]+$"
                            title="Must contain only uppercase and lowercase letters"
                            class="form-control"
                            required="true"
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <form:input
                            id="lastName"
                            type="text"
                            path="lastName"
                            placeholder="Enter Your Last Name"
                            pattern="^[A-Za-z]+$"
                            title="Must contain only uppercase and lowercase letters"
                            class="form-control"
                            required="true"
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="email" class="form-label">Email</label>
                    <form:input
                            id="email"
                            type="email"
                            path="email"
                            placeholder="Enter Your Email"
                            class="form-control"
                            required="true"
                    />

                </div>
                <div class="col-sm-4 mt-3">
                    <label for="username" class="form-label">Username</label>
                    <form:input
                            id="username"
                            type="text"
                            path="username"
                            placeholder="Enter a Username with only letters and numbers"
                            pattern="^[A-Za-z0-9]{1,15}$"
                            title="Must only letters and numbers, and is at most 15 characters long"
                            class="form-control"
                            required="true"
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="password" class="form-label">Password</label>
                    <form:input
                            id="Password"
                            type="password"
                            path="password"
                            placeholder="Enter Your Password"
                            class="form-control"
                            required="true"
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <form:input
                            id="confirmPassword"
                            type="password"
                            path="confirmPassword"
                            placeholder="Confirm Your Password"
                            class="form-control"
                            required="true"
                    />
                </div>

                <div class="col-6 col-sm-3 mt-3">
                    <label class="form-label">Gender</label>
                    <div class="form-check mx-3">
                        <form:radiobutton
                                path="gender"
                                id="female"
                                name="gender"
                                value="female"
                                class="form-check-input"
                                required="true"
                        />
                        <label for="female" class="form-check-label">Female</label>
                    </div>
                    <div class="form-check mx-3">
                        <form:radiobutton
                                path="gender"
                                id="male"
                                name="gender"
                                value="male"
                                class="form-check-input"
                                required="true"
                        />
                        <label for="male" class="form-check-label">Male</label>
                    </div>
                    <div class="form-check mx-3">
                        <form:radiobutton
                                path="gender"
                                id="non-binary"
                                name="gender"
                                value="non-binary"
                                class="form-check-input"
                                required="true"
                        />
                        <label for="non-binary" class="form-check-label"
                        >Non-Binary</label
                        >
                    </div>
                    <div class="form-check mx-3">
                        <form:radiobutton
                                path="gender"
                                id="other"
                                name="gender"
                                value="other"
                                class="form-check-input"
                                required="true"
                        />
                        <label for="other" class="form-check-label">Other</label>
                    </div>
                </div>

                <div class="col-6 col-sm-3 mt-3">
                    <label for="DOB" class="form-label">Date of Birth</label>
                    <form:input
                            id="Date"
                            type="date"
                            cssClass="form-control form-control-lg"
                            required="true"
                            path="DOB"
                    />
                </div>

                <div class="col-6 col-sm-3 mt-3">
                    <label class="form-label">Skills Practicing</label>
                    <form:input
                            id="skillsPracticing"
                            type="text"
                            path="skillsPracticing"
                            placeholder="Enter the skill(s) you are practicing"
                            class="form-control"
                            required="true"
                    />
                </div>

                <div class="col-6 col-sm-3 mt-3">
                    <label class="form-label">Profile Icon</label>
                    <div class="form-check mx-3">
                        <form:radiobutton
                                path="profileIcon"
                                id="musicNote"
                                value="fa-music"
                                class="form-check-input"
                                required="true"
                        />
                        <label for="musicNote" class="form-check-label"
                        >Music Note <i class="fa fa-music"></i
                        ></label>
                    </div>
                    <div class="form-check mx-3">
                        <form:radiobutton
                                path="profileIcon"
                                id="paint-brush"
                                value="fa-paint-brush"
                                class="form-check-input"
                                required="true"
                        />
                        <label for="paint-brush" class="form-check-label"
                        >Paintbrush <i class="fa fa-paint-brush"></i
                        ></label>
                    </div>
                    <div class="form-check mx-3">
                        <form:radiobutton
                                path="profileIcon"
                                id="Laptop"
                                value="fa-laptop"
                                class="form-check-input"
                                required="true"
                        />
                        <label for="Laptop" class="form-check-label"
                        >Laptop <i class="fa fa-laptop"></i
                        ></label>
                    </div>
                    <div class="form-check mx-3">
                        <form:radiobutton
                                path="profileIcon"
                                id="pencil"
                                value="fa-pencil"
                                class="form-check-input"
                                required="true"
                        />
                        <label for="pencil" class="form-check-label"
                        >Pencil <i class="fa fa-pencil"></i
                        ></label>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-sm text-center">
                        <c:forEach var="message" items="${form.errorMessages}" varStatus="status">
                            <span style="color:red">${message}</span><br/>
                        </c:forEach>
                        <button class="btn btn-primary" type="submit">Submit</button>
                    </div>
                </div>
            </form:form>
            <br/>
        </div>
    </div>
</main>


<jsp:include page="../include/footer.jsp"/>