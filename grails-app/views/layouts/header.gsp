<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
    header {
        position: sticky;
        top: 0;
        background: lightgray;
    }

    .logout-button {
        margin: 6px 6px 6px 6px;
    }

    .header-container {
        display: flex;
    }

    h1 {
        margin: 0 12px;
    }

    .links-container {
        margin: 6px 6px 6px auto;
    }

    .links-container > a {
        margin: 6px 6px 6px 6px;
    }
    </style>
</head>

<body>
<header>
    <div class="header-container">
        <g:if test="${userName}">
            <h1>Hello, ${userName}!!!</h1>
        </g:if>
        <g:else>
            <h1 style="margin: 0 12px">Hello, stranger...</h1>
        </g:else>
        <div class="links-container">
            <g:link controller="numberFormatter">
                Number Formatter
            </g:link>
            <g:link controller="user" action="list">
                User list
            </g:link>
        </div>
        <g:if test="${userName}">
            <div class="logout-button">
                <button><a href="?lang=en">EN</a></button>
                <button><a href="?lang=de">DE</a></button>
                <g:link controller="user" action="logout">
                    <button>
                        Log out
                    </button>
                </g:link>
            </div>
        </g:if>
    </div>
</header>
</body>
</html>
