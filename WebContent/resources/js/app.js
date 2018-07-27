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

var router = (()=>{ //()는 함수이름이 없잖아 
return { move : x=>{  //파라미터가 있을때는 x 없을때는 () 
	location.href = x[0] + '/'
		+x[1]
		+".do?action=" + x[2]
		+"&page=" + x[3]
}}; //키값과 value 키값은 어자피 스트링이니까 자동으로 먹히게함. 
})(); //이게 (function(){}()) 싱글 쓰레드. 

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
		var _userId, _ssn, _password,_age,_roll,_teamid,_gender; //앞에 _를 붙이면 인스턴스변수
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
		var getMemid = ()=>{return this._userid;}
		var getSsn = ()=>{return this._ssn;}
		var getPassword = ()=>{return this._password;}
		var getAge = ()=>{return this._age;}
		var getGender = ()=>{return this._gender;}
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
				 }
			}
})();

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



var service = (()=>{
	return {
		nullChecker : x=>{
			var j = { //제이슨은 클로져가없음. 
					checker : true, // checker는 string 
					text : '입력하세요' //value는 붙여야함
			};
			for (i in x){
				if(x[i]===''){
					j.text = i + '입력하세요';
					j.checker = false;
				
				}		
			}
			 return j;
		}
	}
})();



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