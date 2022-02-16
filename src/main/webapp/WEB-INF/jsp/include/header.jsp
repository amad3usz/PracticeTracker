<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="page" value="${requestScope['javax.servlet.forward.request_uri']}" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Practice Tracker</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"
    ></script>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Lato:wght@300;900&display=swap"
            rel="stylesheet"
    />
    <link rel="stylesheet" href="../../../pub/css/styles.css" />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
    />
    <script src="../../../pub/js/script.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="/index">Practice Tracker</a>
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link ${page.endsWith('/') ? 'active' : ''} ${page.endsWith('/index') ? 'active' : ''}" aria-current="page" href="/index"
                    >Home</a>
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
                    <a class="nav-link ${page.endsWith('/following') ? 'active' : ''}" href="/user/followingList">Following</a>
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
        </div>
    </div>
</nav>