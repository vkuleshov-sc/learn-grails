<%--
  Created by IntelliJ IDEA.
  User: kuleshov
  Date: 1/27/2020
  Time: 3:05 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
    footer {
        display: flex;
        background: lightgray;
    }

    .lang-buttons {
        margin: 6px 24px 6px auto;
    }
    </style>
</head>

<body>
<footer>
    <div class="lang-buttons">
        <g:remoteLink controller="locale" action="setLang" params="[lang: 'en']" onComplete="location.reload()">
            <button>EN</button>
        </g:remoteLink>
        <g:remoteLink controller="locale" action="setLang" params="[lang: 'de']" onComplete="location.reload()">
            <button>DE</button>
        </g:remoteLink>
    </div>
</footer>
</body>
</html>