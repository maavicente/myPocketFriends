

<html style="background-image: url(hackathon.png); background-size: cover " lang="en" xmlns:th="http://www.thymeleaf.org">>
<head>
    <thymeleaf th:replace="header :: header"/>
<body>
<style>
    .input{
        font-size: 2em;
        border-radius: 0.3em;
        padding: 0.2em;
        border: none;
        background: rgba(255, 255, 255, 0.7);
        margin-bottom: 0.3em;
    }
</style>
<div style="    width: 260px;
    margin-left: auto;
    margin-right: auto;">

    <form action="kid/0" method="post">
        <input class="input" type="text" name="username" placeholder="Username">
        <input class="input" type="password" name = "password" placeholder="Password">
        <input type="submit" value="Login" style="height: 1em">
    </form>

</div>
</body>
</html>
