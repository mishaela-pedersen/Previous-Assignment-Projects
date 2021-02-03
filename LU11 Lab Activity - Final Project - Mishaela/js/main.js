//This is the main JavaScript file for the index.html page.

var sprite = document.getElementById("sprite");
var flipVar = 0;

function flipGraphic(){
  switch(flipVar){
    case 0:
      flipVar = 1;
      document.getElementById("sprite").src = "images/frame1.png"
      break;
    case 1:
      flipVar = 0;
      document.getElementById("sprite").src = "images/frame2.png";
      break;
  }

// var i;
// for(i=0; i<acc.length;i++){
//   acc[i].addEventListener("click",function(){
//     this.classList.toggle("active");
//     var panel = this.nextElementSibling;
//     if(panel.style.display==="block"){
//       panel.style.display="none";
//     } else {
//       panel.style.display="block"
//     }
//   });
// }
function openAccordion(){
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].onclick = function toggleAcc(){

        this.classList.toggle("active");
        this.nextElementSibling.classList.toggle("show");

  }
}

}
