var trans=document.getElementById("transpic");
var oImg=trans.getElementsByTagName("img")[0];
var oli=trans.getElementsByTagName("li");
var arr=["/PostGraduate/Images/homepage_1.jpg","/PostGraduate/Images/homepage_2.jpg",
         "/PostGraduate/Images/homepage_3.jpg","/PostGraduate/Images/homepage_4.jpg"];


function ManualPlay() {
    for(var i=0;i<oli.length;i++){
        oli[i].index=i;
        oli[i].onmouseover=function () {
            oImg.src=arr[this.index];
            for(var i=0;i<oli.length;i++){
                oli[i].className='';
            }
            this.className='active';
        }
    }
}
ManualPlay();

function AutoPlay() {
    var timer =setInterval(autoPlay,2000);
    for(var i=0;i<oli.length;i++){
        oImg.onmouseover = function(){
            clearInterval(timer);
        };
        oImg.onmouseout = function(){
            timer = setInterval(autoPlay,2000);
        };
    }
    var index=0;
    function autoPlay(){
        if(index<oli.length-1){
            index++;
        }else{
            index=0;
        }
        oImg.src=arr[index];
        for(var i = 0;i<oli.length;i++){
            oli[i].className = "";
        }
        oli[index].className = "active";
    }
}
AutoPlay();

