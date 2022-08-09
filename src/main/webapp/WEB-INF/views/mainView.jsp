<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 31/07/2022
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Strona główna</h1>

<center>

    <div id="scramble">
        <h2>${mixAlg.scrambleValue}</h2>
    </div>

    <div id="mainstopwatch">
        <div class="mainTime">
            <span id="mainminute">00</span>
            <span id="mainsecond">00</span>
            <span id="milliseconds">00</span>
        </div>

        <br>
            <div id="timeButtons">
                    <form action="/solve/main" method="get">
                        <button id="reset" type="submit" name="reset" value="newScramble">new scramble</button>
                    </form>
                        <button id="start" name="start" value="start">Start</button>
                        <button id="stop" name="stop" value="stop">Stop </button>

            </div>
    </div>
    <div id="addTime">
        <p>Podaj swój czas</p>
        <form:form method="post" action="/solve/add" modelAttribute="timeValue">
            <form:hidden id="timeValue" path="timeValue"></form:hidden>
            <button type="submit">Wyślij</button>
        </form:form>
    </div>

    <a href="/solve/add">Dodaj czas</a>

</center>

<script>
    let [milliseconds,second,minute,] = [0,0,0];
    let timerRef = document.querySelector('.mainTime');
    let int = null;

    document.getElementById('start').addEventListener('click', function(event){
        if(int!==null){
            clearInterval(int);
        }
        int = setInterval(mainTime, 10);
    });

    document.getElementById('stop').addEventListener('click', function (event){
        clearInterval(int);
        let stringDoZapisuWBazie = document.querySelector('div.mainTime').innerHTML;
        console.log(stringDoZapisuWBazie);
        document.getElementById('timeValue').value=stringDoZapisuWBazie;


    });

    document.getElementById('reset').addEventListener('click', function (event){
        clearInterval(int);
        [milliseconds,seconds,minutes,hours] = [0,0,0];
        timerRef.innerHTML = '00 : 00 : 00';
    });

    function mainTime(){
        milliseconds+=10;
        if(milliseconds == 1000){
            milliseconds = 0;
            second++;
            if(second == 60){
                second = 0;
                minute++;
                if(minute == 60){
                    minute = 0;
                }
            }
        }

        let m = minute < 10 ? "0" + minute : minute;
        let s = second < 10 ? "0" + second : second;
        let ms = milliseconds < 10 ? "00" + milliseconds : milliseconds < 100 ? "0" + milliseconds : milliseconds;
        timerRef.innerHTML = m + ' : ' + s + ' : ' + ms;
    }
</script>
</body>
</html>
