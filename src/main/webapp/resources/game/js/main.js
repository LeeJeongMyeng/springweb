 
 //총알만들기
	// 1. 스페이스바를 누르면 총알 발사
	// 2. 총알이 발사= 총알의 Y값이 --, 총알의 X값은? 스페이스 누른순간의 우주선의 X좌표+30(우주선길이의 반)=중앙
	// 3. 발사된 총알들은 배열에 저장한다.
	// 4. 총알들은 X,Y좌표값이 있어야한다.
	// 5. 총알 배열을 가지고 render그려준다.
	
//적군만들기
	// x,y,init,update
	// 적군은 위치가 랜덤
	// 적군은 밑으로 내려옴
	// 1초마다 하나씩 적군이 생성
	// 적군의 우주선이 바닥에 닿으면 게임오버
	// 적군과 총알이 만나면 우주선이 사라진다 점수 1점획득
	// 
 
// 적군이 죽는다 = 총알이 적군에게 닿는다. ==> 총알의.y<=적군의.y && 총알.x>= 적군.x && 총알.x<=적군.x+적군의 넓이
// 닿았다.
// 총알이 사라짐 적군의 우주선이 없어짐 점수획득

 
 
 let canvers; //도화지
 let ctx; //이미지 그리는것을 도와줄 친구임
 
 //캔버스 세팅
 canvas = document.createElement("canvas");
 ctx = canvas.getContext("2d");
 
 canvas.width = 600;
 canvas.height = 700;
 
 
 
 var game = document.querySelector("#game")
 game.appendChild(canvas);
 
 
 //이미지 이름변수
 let backgroundImage,spaceshipImage,bulletImage,enemyImage,gameoverImage;
 let gameOver=false //true면 게임이 끝남, false면 게임이 안끝남.
 let score=0;
 let name; //기록남기기용 이름
 //우주선 좌표
 let spaceshipX = canvas.width/2-30 //배경의 중앙-사진의 길이반
 let spaceshipY = canvas.height-60 //배경의 높이- 사진의 높이
 
 //이미지 셋팅
 function loadImage(){
	backgroundImage = new Image();
	backgroundImage.src="resources/game/image/background.webp";
	
	spaceshipImage = new Image();
	spaceshipImage.src="resources/game/image/spaceship.png";
	
	bulletImage = new Image();
	bulletImage.src="resources/game/image/bullet.png";
	
	enemyImage = new Image();
	enemyImage.src="resources/game/image/enemy.png";
	
	gameoverImage = new Image();
	gameoverImage.src="resources/game/image/gameover.jpg";	

	
}

//키의 값을 저장
let keysDown={};
function setupkeyboardListener(){
	document.addEventListener("keydown",function(event){ //키가 눌리면 해당값 저장
		keysDown[event.keyCode] = true;
		//console.log("키:",keysDown);
	});
	document.addEventListener("keyup",function(event){ // 키가 떼지면 해당값 삭제
		delete keysDown[event.keyCode]
		
		if(event.keyCode==32){
			createBullet()//총알 생성
		}
		})
}

//====총알만들기=======================================================================
 function createBullet(){ // 총알 생성
	//console.log("총알생성")
	let b = new Bullet();
	b.init()
	console.log("새로운 총알 리스트",bulletList)
	
}
 
 
 let bulletList=[] //총알 저장 리스트
 function Bullet(){
	this.x = 0;
	this.y = 0;
	this.init = function(){
		this.x = spaceshipX+18;
		this.y = spaceshipY;
		this.alive=true // true살아잇음/ false면 죽어잇는 총알
		
		bulletList.push(this)
	}
	this.update = function(){
		this.y -=7;
	}
	
	this.checkhit=function(){
		for(let i=0; i<enemyList.length;i++){
			if(this.y <= enemyList[i].y && this.x>=enemyList[i].x && this.x <=enemyList[i].x+48){
				this.alive =false;
				score++;
				enemyList.splice(i,1);
			}
			if(this.y==-7){
				this.alive=false;
			}
		}
		
	}
}

//=====적군만들기========================================================================
 function generrateRandomValue(min,max){
	let rnum = Math.floor(Math.random()*(max-min+1))+min;
	return  rnum;
}

let enemyList=[]
function enemy(val){
	this.x=0;
	this.y=0;
	this.init=function(){
		this.x=generrateRandomValue(0,canvas.width-48);
		this.y=0;
		enemyList.push(this);
		console.log("dd")
	};
	this.update=function(){
		var val2=0;
		if(val==1){val2=1;}
		else if(val==2){val2=2;}
		else{val2=3;}
		
		this.y+=val2;
		
		if(this.y>=canvas.height-48){ //바닥에 닿는 위치
		 gameOver = true;
		 console.log("gameOver:"+gameOver)
		}
	}
}

function createEnemy(val){
	//setInterval(호출할 함수,반복될시간)
	const interval = setInterval(function(){
		let e = new enemy(val)
		e.init();
		console.log("생성")
	},1000)
}

//=====공통================================================================
function update(){
	if(39 in keysDown){//화살표 누를때마다 우주선의 위치를 옮김
		spaceshipX+=7;
	}else if(37 in keysDown){ 
		spaceshipX-=7;
		}
	
	// 우주선의 최대/최소 위치값을 지정
	if(spaceshipX<=0){
		spaceshipX=0;
	}else if(spaceshipX>=canvas.width-60){
		spaceshipX=canvas.width-60;
	}
	
	// 총알의 y좌표 업데이트하는 함수 호출
	for(let i=0; i<bulletList.length;i++){
		if(bulletList[i].alive){
		bulletList[i].update(); // 총알 올라가게하는거 업데이트 호출
		bulletList[i].checkhit();
		}
	}
	
	for(let i=0; i<enemyList.length; i++){
		enemyList[i].update(); // 적군 내려오게하는거 업데이트 호출
	}
	
	
	}


 
 //이미지 그리기
function render(){
	// drawImage는 이미지를 그려줌
	// 이미지,x,y,이미지길이,이미지높이
	ctx.drawImage(backgroundImage, 0,0, canvas.width, canvas.height);
	// 이미지 그대로 쓸꺼기떄문에 이미지의 길이,높이는x
	ctx.drawImage(spaceshipImage,spaceshipX,spaceshipY);
	ctx.fillText('Score:'+score,20,35);
	ctx.fillStyle="white"
	ctx.font="30px Arial";
	
	for(let i=0; i<bulletList.length; i++){
		if(bulletList[i].alive){
		ctx.drawImage(bulletImage,bulletList[i].x,bulletList[i].y)
		}
	}
	
	for(let i=0; i<enemyList.length; i++){
		ctx.drawImage(enemyImage,enemyList[i].x,enemyList[i].y,48,48);
	}
	
}

function main(){
	if(!gameOver){
	update()//좌표값 업데이트
	render(); // 그러주기
	requestAnimationFrame(main); //다시 메인함수 호출
	}else{
		ctx.drawImage(gameoverImage,160,200)
		var name=prompt("기록을 남기시겠습니까?","")
		if(name!=null){
		$('input[name=name').val(name)
		$('input[name=score').val(score)
		$('#scorefrm').submit();
		}
	}
}


$("button[name=start]").click(function(){
	var val =$(this).val()
	console.log(val)
	$(this).blur();
	var countnum=4;
	var interval=setInterval(function(){
		
		if(countnum>1){
		$('#count').html("<div class='square xyz-in' xyz='fade'>"+(countnum-1)+"</div>")
		}else if(countnum==1) {
		$('#count').html("<div class='square xyz-in' xyz='fade' style='color:red;'>start!!</div>")
		}else{
		$('.square').attr("class","square xyz-out")	
		clearInterval(interval)
		}
		countnum--;
		
	},1000)
	setTimeout(start,6000,val);
})

function start(val){
	
	$('#count').css("display","none");
	loadImage();// 이미지로딩
	setupkeyboardListener();// 키값 호출 및 저장
	createEnemy(val); // 적군 생성
	main(); 
}

//실행시 이미지만보이게해줌

loadImage();// 이미지로딩
render(); // 그러주기







