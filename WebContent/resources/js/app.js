/*초기버전 	var router = (function (){
		var move = function (x){ //function안에는 this가 없다..
			 console.log('중복 테스트 성공'); 
			 alert('클릭 테스트 성공!!');  //자바스크립트의 syso
			"${ctx}/" jsp에서 움직이는애임 
			location.href = x[0] + '/'
				 			+x[1]
			 				+".do?action=" + x[2]
			 				+"&page=" + x[3]
		};
		return { move : move }; //키값과 value
	}()); //이게 (function(){}()) 싱글 쓰레드. 
*/
/* 두번째 버전 var service = (()=>{
	return {
		loginValidation : x=>{
			if(x[0]===''){
				 alert("Please provide your name!");
				 return false;
			}else if(x[1]===''){
				alert("Please provide your password");
				 return false;
			}else{
				return true;
			}
		} //파라미터가 없으니까 (). 근데 x를 주고 안써도 되니까 걍 default로 x를 줘버림
	};
})();*/



var member = (()=>{ //파라미터 봉쇄해놨음. 보안걸림.  클로져를 걸어둔 객체. 
		var _userId, _ssn, _password,_age,_roll,_teamId,_gender,_subject; //앞에 _를 붙이면 인스턴스변수
		var setUserid = (userId)=>{this._userId = userId;}
		var setSsn = (ssn)=>{this._ssn = ssn;}
		var setPassword = (password)=>{this._password = password;}
		var setAge = x=>{
			var date = new Date().getFullYear(); //오늘날짜 뽑아짐. 올해연도. 
			this._age = parseInt(date)-1899-parseInt(x.substring(0,2));
			}
		var setGender = x=>{
			var gender = "";
			if(Number(x.substring(7,8))%2==0){
				gender = "여자";
			}else{
				gender = "남자";
			};
			this._gender = gender;
			}
		var setRoll = (roll)=>{this._roll = roll;}
		var setTeamId = (teamId)=>{this._teamId = teamId;}
		var setSubject = (subject)=>{this._subject = subject;}
		var getMemid = ()=>{return this._userid;}
		var getSsn = ()=>{return this._ssn;}
		var getPassword = ()=>{return this._password;}
		var getAge = ()=>{return this._age;}
		var getGender = ()=>{return this._gender;}
		var getRoll = ()=>{return this._roll;}
		var getSubject = ()=>{return this._subject;}
		var getTemaId = ()=>{return this.teamId;}
			return{ //여기서부터 열려있는거 
				setUserid : setUserid,
				setSsn : setSsn,
				setPassword : setPassword,
				setAge : setAge,
				setGender : setGender,
				getMemid : getMemid,
				getSsn : getSsn,
				getPassword : getPassword,
				getAge : getAge,
				getGender : getGender,
				join : x=>{
					member.setUserid(x.userid);
					 member.setPassword(x.password);
					 member.setSsn(x.ssn);
					member.setAge(x.ssn);
					member.setGender(x.ssn);
				 },
				update : x=>{
					member.setPassword(x.oldPass+"/"+x.newPass);
					member.setTeamId(x.teamId);
					member.setRoll(x.roll);
				}
			}
})();


var service = (()=>{
	return {
		nullChecker : x=>{
			var j = { //제이슨은 클로져가없음. 
					checker : true, // checker는 string 
					text : '입력하세요' //value는 붙여야함
			};
			for (var i in x){
				if(x[i]===''){
					j.text = i + '입력하세요';
					j.checker = false;
					//return j;
				}		
			}
			 return j;
		},
		addClass : (dom,cName)=>{
			var arr = cName.split(" ");
			if (arr.indexOf(cName) == -1){
				dom.className += " " + cName;
			}
		}
	}
})();

"use strict";
var router = (()=>{ //()는 함수이름이 없잖아 
return { move : x=>{  //파라미터가 있을때는 x 없을때는 () 
	alert(x.context+x.domain+x.action+x.page);
	location.href = 
		x.context + '/'
		+x.domain
		+".do?action=" + x.action
		+"&page=" + x.page
}}; //키값과 value 키값은 어자피 스트링이니까 자동으로 먹히게함. 
})(); //이게 (function(){}()) 싱글 쓰레드. 


var admin = (()=>{
	return{
		check : x=>{
			var isAdmin = confirm('관리자입니까'); //윈도우의 객체.앞이 생략.윈도우가 객체로 만드는것을 bom
				//function이고 객체다는 교과서
			if(isAdmin){
				var password = prompt('관리자 비번을 입력 바랍니다');
				if(password == 1){
					router.move({context: x,
						domain : 'admin',
						action: 'list',
						page: 'main'})
			}
				else{
				alert('관리자만 접근이 허용됩니다')
			}	
			}
			},
			main : x=>{
				service.addClass(
						 document.getElementById('searchBox'),
						 'width80pt center'
					);
					service.addClass(
							document.getElementById('searchWord'),
							'width80px floatRight'
					);
					service.addClass(
							document.getElementById('searchOption'),
							'floatRight '
					);
					service.addClass(
							document.getElementById('searchBtn'),
							'floatRight '
					);
					service.addClass(
							document.getElementById('contentBoxTab'),
							'width90pt center marginTop30px '
					);
					service.addClass(
							document.getElementById('contentBoxMeta'),
							'bgColorYellow '
					);
				
					for(var i of document.querySelectorAll('.username')){
						service.addClass(
								i,
								'cursor fontColorBlue'
								);
							i.style.color = 'blue';
							i.style.cursor = 'pointer';
							i.addEventListener('click',function(){
							location.href= x+'/admin.do?action=retrieve&page=memberDetail&userid='
								+this.getAttribute('id');
						})
					};
					
					//카운트
					/*for(var k of document.querySelectorAll('.pagenumbers')){
						service.addClass(
								k,
								'cursor fontColorBlue'
								);
						k.style.color = 'blue';
						k.addEventListener('click',function(){
							location.href= x+'/admin.do?action=count&page=main&pagenumber=page_'
							+this.getAttribute('id');
						})
					};*/
					
					
					//All List의 과거 
					/* var x = document.querySelectorAll('.username'); //위에 classname 
					for(i in x){
						x[i].style.color = 'blue';
						x[i].style.cursor = 'pointer';
						x[i].addEventListener('click',function(){
							alert('클릭'+this.getAttribute('id')); 
							//자바에서 this는 필드. 여기서는 this가 x[i]를 지칭.근데 function안이 아닌데 this가 어떡해 지칭하는가?
							//리턴이 스칼라개념으로 움직인다. 
							//저 위에 x인 집합체로 잡으면 this를 못잡는데..? callback함수(클릭이후 호출하는함수) this는 최초 object
							//그니까 x[i]가 최초의 함수임 
						location.href='${ctx}/admin.do?action=retrieve&page=memberDetail&userid='
								+this.getAttribute('id')
						});
					}*/
					
					//써치
					document.getElementById("searchBtn")
					.addEventListener('click',function (){
						alert('써치함수 진입함');
						location.href = (document.getElementById('searchOption').value==='userid')? 
								x+'/admin.do?action=retrieve&page=memberDetail&userid='
								+ document.getElementById('searchWord').value
									: 
									x+'/admin.do?action=search&page=main&&searchOption='
									+ document.getElementById('searchOption').value
									+'&searchWord='
									+ document.getElementById('searchWord').value
									;
					});

			}
	};})();




/*var setNode = (()=>{
	return { json : x=>{ 
		node.setAttribute('type',x.type);
		node.setAttribute('name',x.name);
		node.setAttribute('value',x.value);
	}};
})();*/



/*var member = (()=> {
	   var _memberId,_ssn,_pass,_name,_age,_teamId,_gender,_roll;      
	   var setMemberId = (memberId)=> {
	      if(memberId.length>=2){
	         this._memberId = memberId;
	      }else{
	         alert('아이디는 2자 이상입력 하세요.');
	      }
	   }
	   var setSsn = (ssn)=> {
	      var flag = false;
	      if(ssn.substring(7,8)==7 || ssn.substring(7,8)==8){

	      }else if(parseInt(ssn.substring(2,4))<=0 
	            || parseInt(ssn.substring(2,4))>=13){
	         
	      }else if(parseInt(ssn.substring(4,6))<=0 
	            || parseInt(ssn.substring(4,6))>=32){
	         
	      }else if(ssn.substring(6,7)==="-"){
	         flag = true;
	      }
	      if(flag){
	         this._ssn = ssn;
	      }else{
	         alert('잘못된 주민번호');
	      }
	   }
	   var setName = (name)=> {this._name = name;}
	   var setPass = (pass)=> {this._pass = pass;}
	   var setAge = x=> {
	      this._age = (new Date().getFullYear())-parseInt('19'+x.substring(0,2));
	      }
	   var setTeamId = (teamId )=> {this._teamId = teamId;}
	   var setRoll = (roll)=> {this._roll = roll;}
	   var setGender = x=> {
	      var gender;
	      if(parseInt(x.substring(7,8)) % 2 == 1){
	         gender = '남';
	      }else{
	         gender = '여';
	      }
	      this._gender = gender;
	      }
	   var getMemberId = ()=> {return this._memberId;}
	   var getSsn =  ()=> {return this._ssn;}
	   var getPass =  ()=> {return this._pass;}
	   var getName =  ()=> {return this._name;}
	   var getTeamId =  ()=> {return this._teamId;}
	   var getSsn =  ()=> {return this._ssn;}
	   var getRoll =  ()=> {return this._roll;}
	   var getAge =  ()=> {return this._age;}
	   var getGender =  ()=> {return this._gender;}
	   return {
	   //memberId,teamId,name,ssn,roll,pass,age,gender;
	      setMemberId : setMemberId,
	      setSsn : setSsn,
	      setPass : setPass,
	      setAge : setAge,
	      setTeamId : setTeamId,
	      setName : setName,
	      setGender : setGender,
	      setRoll : setRoll,
	      
	      getMemberId : getMemberId,
	      getSsn : getSsn,
	      getPass : getPass,
	      getAge : getAge,
	      getTeamId : getTeamId,
	      getName : getName,
	      getGender : getGender,
	      getRoll : getRoll,
	      join : x=>{
	    	  member.setMemid(x.userid);
				 member.setPassword(x.password);
				 member.setSsn(x.ssn);
				 member.setAge(x.ssn);
				 member.setGender(x.ssn);
	      }
	   }
	})();
*/



/*loginValidation : x=>{*/
				/*	if(x[0]===''){
						 alert("Please provide your name!");
						 return false;
					}else if(x[1]===''){
						alert("Please provide your password");
						 return false;
					}else{
						return true;
					}*/
				/*}*/


		/*this.loginValidation = function (){ //anonymous function
			if(this.memId===""){
				 alert("Please provide your name!" );
				 return false;
			}else if(this.password===""){
				alert("Please provide your password");
				 return false;
			}else{
				return true;
			}
		}
		this.joinValidation = function (){
			return false;
		}*/
/*	};*/
	
/*	(function (){})(); // Goofy
	(function(){}());  // groovy
*/	// 이건 var member = new Member랑 같은 맥락임