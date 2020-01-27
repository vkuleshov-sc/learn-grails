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
    <style>
    header {
        position: sticky;
        top: 0;
        background: lightgray;
    }

    .logout-button {
        margin: 6px 6px 6px auto;
    }

    .header-container {
        display: flex;
    }

    h1 {
        margin: 0 12px;
    }
    </style>
</head>

<body>
<header>
    <g:if test="${userName}">
        <div class="header-container">
            <h1>Hello, ${userName}!!!</h1>

            <div class="logout-button">
                <g:link action="logout">
                    <button>
                        Log out
                    </button>
                </g:link>
            </div>
        </div>
    </g:if>
    <g:else>
        <h1 style="margin: 0 12px">Hello, stranger...</h1>
    </g:else>
</header>
</body>
</html>
