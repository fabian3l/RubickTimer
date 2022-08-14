
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="timeValue" type="java"--%>
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
<h1>Main Site</h1>
<a href="/solve/all">All Solves</a>

<center>

    <div id="scramble">
        <h2>${mixAlg.scrambleAlg}</h2>
    </div>

    <div id="mainstopwatch">
        <div class="mainTime">
            <span id="mainminute">00:</span>
            <span id="mainsecond">00.</span>
            <span id="milliseconds">00</span>
        </div>

        <br>
            <div id="timeButtons">
                    <form action="/solve/main" method="get">
                        <button id="reset" type="submit" name="reset" value="newScramble">new scramble</button>
                    </form>
                        <button id="start" name="start" value="start">Start</button>

                        <form:form method="post" action="/solve/add" modelAttribute="timeValue">
                            <form:hidden id="solveTime" path="timeValue"></form:hidden>
                             <button id="stop" name="stop" value="stop" type="submit">Stop</button>
                        </form:form>

            </div>
    </div>
    <div id="statistic">
        <table>
            <tr>
                <td>Best time: </td>
                <td>${bestSolve}</td>
            </tr>
            <tr>
                <td>Average of all: </td>
                <td>${averageSolve}</td>
            </tr>
                <td>Worst time: </td>
                <td>${worstSolve}</td>
        </table>
        </table>

    </div>


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
        if(stringDoZapisuWBazie.includes('<span id="milliseconds">00</span>') &&
            stringDoZapisuWBazie.includes('<span id="mainsecond">00.</span>') &&
            stringDoZapisuWBazie.includes('<span id="mainminute">00:</span>')){
            document.getElementById('solveTime').value = "00:00.000";
        }else{
            document.getElementById('solveTime').value = stringDoZapisuWBazie;
        }

    });

    document.getElementById('reset').addEventListener('click', function (event){
        clearInterval(int);
        [milliseconds,seconds,minutes,hours] = [0,0,0];
        timerRef.innerHTML = '00:00.00';
    });

    function mainTime(){
        milliseconds+=10;
        if(milliseconds === 1000){
            milliseconds = 0;
            second++;
            if(second === 60){
                second = 0;
                minute++;
                if(minute === 60){
                    minute = 0;
                }
            }
        }

        let m = minute < 10 ? "0" + minute : minute;
        let s = second < 10 ? "0" + second : second;
        let ms = milliseconds < 10 ? "00" + milliseconds : milliseconds < 100 ? "0" + milliseconds : milliseconds;
        timerRef.innerHTML = m + ':' + s + '.' + ms;
    }
</script>
</body>
</html>
