<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />


<main>
    <div class="container">
        <div id="title" class="h1">EDIT USER</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <form class="row needs-validation" id="registerForm" method="POST" action="/registration/registerSubmit">
                <input type="hidden" name="id" value="${form.id}">
                <div class="col-sm-4 mt-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input
                            id="firstName"
                            type="text"
                            name="firstName"
                            placeholder="Enter Your First Name"
                            pattern="^[A-Za-z]+$"
                            title="Must contain only uppercase and lowercase letters"
                            class="form-control"
                            value="${form.firstName}"
                            required
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input
                            id="lastName"
                            type="text"
                            name="lastName"
                            placeholder="Enter Your Last Name"
                            pattern="^[A-Za-z]+$"
                            title="Must contain only uppercase and lowercase letters"
                            class="form-control"
                            value="${form.lastName}"
                            required
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="email" class="form-label">Email</label>
                    <input
                            id="email"
                            type="email"
                            name="email"
                            placeholder="Enter Your Email"
                            class="form-control"
                            value="${form.email}"
                            required
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="username" class="form-label">Username</label>
                    <input
                            id="username"
                            type="text"
                            name="username"
                            placeholder="Enter a Username with only letters and numbers"
                            pattern="^[A-Za-z0-9]{1,15}$"
                            title="Must only letters and numbers, and is at most 15 characters long"
                            class="form-control"
                            value="${form.username}"
                            required
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="password" class="form-label">Password</label>
                    <input
                            id="password"
                            type="password"
                            name="password"
                            placeholder="Enter Your Password"
                            class="form-control"
                            value="${form.password}"
                            required
                    />
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input
                            id="confirmPassword"
                            type="password"
                            name="confirmPassword"
                            placeholder="Confirm Your Password"
                            class="form-control"
                            value="${form.confirmPassword}"
                            required
                    />
                </div>

                <div class="col-6 col-sm-3 mt-3">
                    <label class="form-label">Gender</label>
                    <div class="form-check mx-3">
                        <input
                                type="radio"
                                id="female"
                                name="gender"
                                value="female"
                                class="form-check-input"
                        <%--                                value="${form.gender}"--%>
                                required
                        />
                        <label for="female" class="form-check-label">Female</label>
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="radio"
                                id="male"
                                name="gender"
                                value="male"
                                class="form-check-input"
                        <%--                                value="${form.gender}"--%>
                                required
                        />
                        <label for="male" class="form-check-label">Male</label>
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="radio"
                                id="non-binary"
                                name="gender"
                                value="non-binary"
                                class="form-check-input"
                        <%--                                value="${form.gender}"--%>
                                required
                        />
                        <label for="non-binary" class="form-check-label"
                        >Non-Binary</label
                        >
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="radio"
                                id="genderOther"
                                name="gender"
                                value="other"
                                class="form-check-input"
                                required
                        />
                        <label for="genderOther" class="form-check-label">Other</label>
                    </div>
                </div>

                <div class="col-6 col-sm-3 mt-3">
                    <label for="DOB" class="form-label">Date of Birth</label>
                    <input
                            type="date"
                            id="DOB"
                            name="DOB"
                            class="form-control"
                            required
                    />
                </div>

                <div class="col-6 col-sm-3 mt-3">
                    <label class="form-label">Skills Practicing</label>

                    <div class="form-check mx-3">
                        <input
                                type="checkbox"
                                id="music"
                                value="Music"
                                name="skillsPracticing"
                                class="form-check-input practice"
                        />
                        <label for="music" class="form-check-label">Music</label>
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="checkbox"
                                id="art"
                                value="Art"
                                name="skillsPracticing"
                                class="form-check-input practice"
                        />
                        <label for="art" class="form-check-label">Art</label>
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="checkbox"
                                id="writing"
                                value="Writing"
                                name="skillsPracticing"
                                class="form-check-input practice"
                        />
                        <label for="writing" class="form-check-label">Writing</label>
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="checkbox"
                                id="other"
                                value="Other"
                                name="skillsPracticing"
                                class="form-check-input practice"
                        />
                        <label for="other" class="form-check-label">Other</label>
                    </div>
                    <input
                            type="button"
                            class="btn btn-primary btn-sm mb-1"
                            onclick="selects()"
                            value="Select All"
                    />
                    <input
                            type="button"
                            class="btn btn-primary btn-sm mb-1"
                            onclick="deSelect()"
                            value="Deselect All"
                    />
                </div>

                <div class="col-6 col-sm-3 mt-3">
                    <label class="form-label">Profile Image</label>
                    <div class="form-check mx-3">
                        <input
                                type="radio"
                                id="musicNote"
                                name="profileImage"
                                value="musicNote"
                                class="form-check-input"
                                required
                        />
                        <label for="musicNote" class="form-check-label"
                        >Music Note <i class="fa fa-music"></i
                        ></label>
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="radio"
                                id="paintbrush"
                                name="profileImage"
                                value="paintbrush"
                                class="form-check-input"
                                required
                        />
                        <label for="paintbrush" class="form-check-label"
                        >Paintbrush <i class="fa fa-paint-brush"></i
                        ></label>
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="radio"
                                id="Laptop"
                                name="profileImage"
                                value="Laptop"
                                class="form-check-input"
                                required
                        />
                        <label for="Laptop" class="form-check-label"
                        >Laptop <i class="fa fa-laptop"></i
                        ></label>
                    </div>
                    <div class="form-check mx-3">
                        <input
                                type="radio"
                                id="pencil"
                                name="profileImage"
                                value="pencil"
                                class="form-check-input"
                                required
                        />
                        <label for="pencil" class="form-check-label"
                        >Pencil <i class="fa fa-pencil"></i
                        ></label>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-sm text-center">
                        <c:forEach var="message" items="${form.errorMessages}" varStatus="status">
                            <span style="color:red">${message}</span><br />
                        </c:forEach>
                        <button class="btn btn-primary" type="submit">Register</button>
                    </div>
                </div>
            </form>
            <br />
            <div class="row">
                <div class="col-sm text-center">
                    <p>
                        Already a registered user? Click
                        <a href="/login.html">here</a> to login!
                    </p>
                </div>
            </div>
        </div>
    </div>
</main>


<jsp:include page="../include/footer.jsp" />