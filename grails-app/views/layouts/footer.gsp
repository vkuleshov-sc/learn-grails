<%--
  Created by IntelliJ IDEA.
  User: kuleshov
  Date: 1/27/2020
  Time: 3:05 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
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