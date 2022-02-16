
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="page" value="${requestScope['javax.servlet.forward.request_uri']}" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<footer class="footer mt-auto py-1 fixed-bottom bg-light">
    <ul class="nav justify-content-center border-bottom pb-1 mb-1">
        <li class="nav-item">
            <a href="/index" class="nav-link px-2 ${page.endsWith('/') ? 'active' : ''}">Home</a>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link ${page.endsWith('/registerEdit') ? 'active' : ''}" href="/registration/registerEdit">Edit Account</a>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <a class="nav-link ${page.endsWith('/register') ? 'active' : ''}" href="/registration/register">Register</a>
            </sec:authorize>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link" href="/login/logout">Logout</a>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <td><a class="nav-link ${page.endsWith('/login') ? 'active' : ''}" href="/login/login">Login</a></td>
            </sec:authorize>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link ${page.endsWith('/profile') ? 'active' : ''}" href="/user/myProfile">Profile</a>
            </sec:authorize>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link ${page.endsWith('/userList/userList') ? 'active' : ''}" href="/user/userList">Search</a>
            </sec:authorize>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link ${page.endsWith('/following') ? 'active' : ''}" href="/user/followinglist">Following</a>
            </sec:authorize>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link ${page.endsWith('/inputHistory') ? 'active' : ''}" href="/user/inputHistory">Entries</a>
            </sec:authorize>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link ${page.endsWith('/dataEntry') ? 'active' : ''}" href="/user/dataEntry">Record!</a>
            </sec:authorize>
        </li>



    </ul>
    <p class="text-center navbar-brand">&#169; 2022 Practice Tracker</p>
</footer>
</body>
</html>