

function powerLinks(){
var link = document.getElementById("links");
link.onclick = function(){
alert('O elemento clicado foi o ' );
return false;
}
}

window.onload = powerLinks;