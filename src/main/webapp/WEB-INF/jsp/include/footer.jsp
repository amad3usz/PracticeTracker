
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="page" value="${requestScope['javax.servlet.forward.request_uri']}" />
<footer class="footer mt-auto py-1 fixed-bottom bg-light">
    <ul class="nav justify-content-center border-bottom pb-1 mb-1">
        <li class="nav-item">
            <a href="/index" class="nav-link px-2 ${page.endsWith('/') ? 'active' : ''}">Home</a>
        </li>
        <li class="nav-item">
            <a href="/registration/register" class="nav-link px-2 ${page.endsWith('/registration/register') ? 'active' : ''}">Register</a>
        </li>
        <li class="nav-item">
            <a href="/login" class="nav-link px-2 ${page.endsWith('/login') ? 'active' : ''}">Login</a>
        </li>
        <li class="nav-item">
            <a href="/profile" class="nav-link px-2">My Profile</a>
        </li>
        <li class="nav-item">
            <a href="/followingList" class="nav-link px-2">Following</a>
        </li>
        <li class="nav-item">
            <a href="/search" class="nav-link px-2">Search</a>
        </li>
        <li class="nav-item">
            <a href="/inputHistory" class="nav-link px-2">Entries</a>
        </li>
        <li class="nav-item">
            <a href="/dataEntry" class="nav-link px-2">Record!</a>
        </li>
    </ul>
    <p class="text-center navbar-brand">&#169; 2022 Practice Tracker</p>
</footer>
</body>
</html>