// function createQuiz(){
//
//   var myAnswerList = [];
//   myAnswerList[0] = new Answer(["y1","c1","h1","m1","k1"]);
//   myAnswerList[1] = new Answer(["y2","c2","h2","m2","k2"]);
//
//   var myQuestionList = [];
//   myQustionList[0] = new Question("A murder occurred! What's your first reaction?", myAnswerList, 0);
//
//   var myQuiz = new Quiz("Which Sufering's Symphony Character Are You?", myQuestionList);
// }

var quiz = [];
var currentQuiz;
var yAnswers;
var cAnswers;
var hAnswers;
var mAnswers;
var kAnswers;
var yTotalAns=5;
var cTotalAns=5;
var hTotalAns=5;
var mTotalAns=5;
var kTotalAns=5;

function init(){

    yAnswers=0;
    cAnswers=0;
    hAnswers=0;
    mAnswers=0;
    kAnswers=0;
    currentQuiz=0;
    document.getElementById("pgQuiz").style.display = "none";
    document.getElementById("quizResults").style.display="none";

}

function loadQuiz(){
    var Question1={qID:"1",questiontext:"A murder occurred! What's your first reaction?",answer1:"A m-murder?!",answer2:"I hope it's not (insert name here)...!",answer3:"The cuprit won't get away with this!",answer4:"No! I...failed to stop it...",answer5:"Stupid half-and-half slimeball, making us do this...!", yAns:"1",cAns:"2",hAns:"3",mAns:"4", kAns:"5", asked:"false"};
    var Question2={qID:"2",questiontext:"What are you doing during the invesigations?",answer1:"I'd answer questions as best as i could, but I'd be too shaken up to actually search for clues.",answer2:"I'd be upset, but that wouldn't stop me from doing all that I can to look for evidence!",answer3:"I'd be searching for clues full force, there's no way the killer will get away with this!",answer4:"I would give it my all searching for clues, I WILL avenge our friend!",answer5:"I'd be off on my own collecting clues but I would mostly be questioning people who weren't on the scene.", yAns:"1",cAns:"2",hAns:"3",mAns:"4",kAns:"5",asked:"false"};
    var Question3={qID:"3",questiontext:"Do you have any particular hobbies?",answer1:"I do enjoy gardening and maybe a little whittling.",answer2:"I like to sew in my spare time, I make a lot of the clothes I wear.",answer3:"I don't necessarily have a lot of time, but I do like to sketch sometimes to relax.",answer4:"I have quite a few hobbies but I'm particularly attracted to ones involving music.",answer5:"I like to play video games in my spare time.",yAns:"1",cAns:"2",hAns:"3",mAns:"4",kAns:"5",asked:"false"};
    var Question4={qID:"4",questiontext:"Are you an introvert, an extrovert or ambivert?",answer1:"Introvert",answer2:"Extrovert",answer3:"Ambivert", yAns:"3",cAns:"2",hAns:"3",mAns:"1",kAns:"1",asked:"false"};
    var Question5={qID:"5",questiontext:"Are you particularly trusting of people?",answer1:"I don't necessarily trust people of the opposite gender very much, but otherwise yes.",answer2:"I'm very cautious when it comes to giving people my trust, but you can't really tell at first. Once you get to know me, however, you can see the difference between how I treat people I trust with people I don't.",answer3:"No but most people can't tell since I'm very good at hiding it.",answer4:"Not at first, no. But I am if they prove to me that I can trust them.",answer5:"Nope, and I don't even kind of hide it. Very few people have my trust and I plan to keep it that way.",yAns:"1",cAns:"2",hAns:"3",mAns:"4",kAns:"5",asked:"false"};

    quiz[0]=Question1;
    quiz[1]=Question2;
    quiz[2]=Question3;
    quiz[3]=Question4;
    quiz[4]=Question5;


}

function checkAnswer(){
  var answer=document.getElementsByName("answer");
  var selectAnswer = 0;

  for(var i=0;i<answer.length; i++){
    if(answer[i].checked){
      selectAnswer = answer[i].value;
    }
  }
    if(selectAnswer==""){
      alert("You haven't chosen an answer");
      return false;
    }
    else{
      if(quiz[currentQuiz].yAns==selectAnswer){
        yAnswers++;

      } else{
        if(quiz[currentQuiz].cAns==(selectAnswer)){
        cAnswers++;
      } else{
        if(quiz[currentQuiz].hAns==(selectAnswer)){
        hAnswers++;
      } else{
        if(quiz[currentQuiz].mAns==(selectAnswer)){
        mAnswers++;
      } else{
        if(quiz[currentQuiz].kAns==(selectAnswer)) {
        kAnswers++;

      }
    }}}}}
    quiz[currentQuiz].asked="true";
    nextQuestion();

}

function nextQuestion(){
  document.getElementById("OptAnswer1").checked=false;
  document.getElementById("OptAnswer2").checked=false;
  document.getElementById("OptAnswer3").checked=false;
  document.getElementById("OptAnswer4").checked=false;
  document.getElementById("OptAnswer5").checked=false;

  var numberAsked=0;

  for(var i=4;i>=0;i--){
    if(quiz[i].asked=="true"){
      numberAsked++;
    } else{
      currentQuiz=i;
    }

  }
  if(numberAsked==5){
    ResultsInfo();
  } else{
    if(numberAsked==3){
      document.getElementById("question").innerHTML=quiz[currentQuiz].questiontext;
      document.getElementById("answerPos1").innerHTML=quiz[currentQuiz].answer1;
      document.getElementById("answerPos2").innerHTML=quiz[currentQuiz].answer2;
      document.getElementById("answerPos3").innerHTML=quiz[currentQuiz].answer3;
      document.getElementById("answerPos4").style.display="none";
      document.getElementById("answerPos5").style.display="none";
    } else{

    document.getElementById("question").innerHTML=quiz[currentQuiz].questiontext;
    document.getElementById("answerPos1").innerHTML=quiz[currentQuiz].answer1;
    document.getElementById("answerPos2").innerHTML=quiz[currentQuiz].answer2;
    document.getElementById("answerPos3").innerHTML=quiz[currentQuiz].answer3;
    document.getElementById("answerPos4").innerHTML=quiz[currentQuiz].answer4;
    document.getElementById("answerPos5").innerHTML=quiz[currentQuiz].answer5;
    document.getElementById("answerPos4").style.display="inline";
    document.getElementById("answerPos5").style.display="inline";
  }

  }
}

function resetQuiz(){
  init();
  document.getElementById("pgMainMenu").style.display = "inline";
}

function startQuiz(){
  document.getElementById("pgMainMenu").style.display="none";
  document.getElementById("pgQuiz").style.display="inline";
  loadQuiz();
  nextQuestion();
}

function ResultsInfo(){
  document.getElementById("pgQuiz").style.display="none";
  document.getElementById("quizResults").style.display="block";

  if(yAnswers>=3){
    document.getElementById("characterRes").innerHTML ="Yuuki Shimizu";
    document.getElementById("characterPic").src ="images/yuuki.png";
    document.getElementById("resultDesc").innerHTML ="You are outwardly very confidant, and are nice to those the same gender as you, but are more harsh and bossy towards those of the opposite gender. If you were in the killing game, you would be shaken up each time a body is discovered, but would still try to help as best you can by answering questions.";
  } else{
    if(cAnswers>=3){
    document.getElementById("characterRes").innerHTML ="Chou Yamashita";
    document.getElementById("characterPic").src ="images/chou.jpg";
    document.getElementById("resultDesc").innerHTML ="You are very into pop culture and fashion, choosing to be unique with bright fun colors or crazy patterns. If you were in the killing game, you would be upset by any body discovery announcement, but you get especially upset if it was someone you were close to. This dosn't stop you from searching for clues at the crime scene, however. You likely have some big secret about yourself that nobody knows.";
  } else {
    if(hAnswers>=3){
    document.getElementById("characterRes").innerHTML ="Haruto Kudo";
    document.getElementById("characterPic").src ="images/haruto.png";
    document.getElementById("resultDesc").innerHTML ="You are very calm and collected in stressful situations and are very loyal to your friends. If you were in the killing game, you would be one of the biggest helps towards catching the culprit, often giving helpful input or finding extremely important evidence. You most likely have a secret side of you that you don't let people see.";
  } else{
    if(mAnswers>=3){
    document.getElementById("characterRes").innerHTML ="Michiru Tsukino";
    document.getElementById("characterPic").src ="images/michiru.jpg";
    document.getElementById("resultDesc").innerHTML ="You are usually very shy and cautious at first, but when push comes to shove, you're the first one up to the plate to protect those you care about. If you were in the killing game, you would be the protagonist of the story: aways first to lead investigations, trying to get to know all of your classmates and befriending them, and blame yourself for every murder that occurs because you weren't able to stop it from happening. You are likely confused about what you want to do in life, but don't worry. Something is definitely coming soon, and you'll realize your purpose!";
  } else{
    if(kAnswers>=3){
    document.getElementById("characterRes").innerHTML ="Keiko Moto";
    document.getElementById("characterPic").src ="images/keiko.png";
    document.getElementById("resultDesc").innerHTML ="You are usually the cool friend of the bunch and are confidan in what you believe in. If you were in the killing game, you would be upset with Monokoro rather than the culprit, blaming him for the killing game happening in the first place. You often appear cold and aloof at first, but are actually very friendly and loyal once people get to now you.";
  }
}}}}
  document.getElementById("characterRes").style.display="block";
  document.getElementById("characterPic").style.display="block";
  document.getElementById("resultDesc").style.display ="block";
}
