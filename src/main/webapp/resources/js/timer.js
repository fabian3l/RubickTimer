let [milliseconds,second,minute,] = [0,0,0];
let timerRef = document.querySelector('.mainTime');
let int = null;

document.getElementById('start').addEventListener('click', function(event){
    if(int!==null){
        clearInterval(int);
    }
    int = setInterval(mainTime,100);
});

document.getElementById('stop').addEventListener('click', function (event){
    clearInterval(int);

});

document.getElementById('reset').addEventListener('click', function (event){
    clearInterval(int);
    [milliseconds,seconds,minutes,hours] = [0,0,0];
    timerRef.innerHTML = '00 : 00 : 00';
});

function mainTime(){
    milliseconds+=1;
    if(milliseconds == 100){
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