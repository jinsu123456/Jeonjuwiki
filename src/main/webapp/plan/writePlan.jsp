<%@page import="vo.AccVO"%>
<%@page import="vo.FoodVO"%>
<%@page import="java.util.List"%>
<%@page import="vo.PlaceVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DBManager dbm = DBManager.getInstance();
	dbm.DBOpen();
	
	String sql = "select * from place";
	dbm.prepStmt(sql);
	dbm.executeQuery();
	
	List<PlaceVO> placeVOlist = new ArrayList<PlaceVO>();
	
	while(dbm.next()){
		PlaceVO placeVO = new PlaceVO(
				dbm.getInt("pno"),
				dbm.getString("pname"),
				dbm.getString("paddr1"),
				dbm.getString("paddr2"),
				dbm.getString("pcontentid"),
				dbm.getString("ptel"),
				dbm.getString("pimg1"),
				dbm.getString("pimg2"),
				dbm.getString("pmapx"),
				dbm.getString("pmapy"),
				dbm.getInt("pmlevel"));
		placeVOlist.add(placeVO);
	}
	
	/* sql = "select * from food";
	dbm.prepStmt(sql);
	dbm.executeQuery();
	
	List<FoodVO> foodVOlist = new ArrayList<FoodVO>();
	
	while(dbm.next()){
		FoodVO foodVO = new FoodVO(
				dbm.getString("fname"),
				dbm.getString("faddr1"),
				dbm.getString("faddr2"),
				dbm.getString("fcontentid"),
				dbm.getString("ftel"),
				dbm.getString("fimg1"),
				dbm.getString("fimg2"),
				dbm.getString("fmapx"),
				dbm.getString("fmapy"),
				dbm.getInt("fmlevel"));
		foodVOlist.add(foodVO);
	}
	
	dbm.dbClosePsmt();
	dbm.dbCloseRs();
	
	sql = "select * from acc";
	dbm.prepStmt(sql);
	dbm.executeQuery();
	
	List<AccVO> accVOlist = new ArrayList<AccVO>();
	
	while(dbm.next()){
		AccVO accVO = new AccVO(
				dbm.getString("aname"),
				dbm.getString("aaddr1"),
				dbm.getString("aaddr2"),
				dbm.getString("acontentid"),
				dbm.getString("atel"),
				dbm.getString("aimg1"),
				dbm.getString("aimg2"),
				dbm.getString("amapx"),
				dbm.getString("amapy"),
				dbm.getInt("amlevel"));
		accVOlist.add(accVO);
	}
	
	dbm.dbClosePsmt();
	dbm.dbCloseRs(); */ 
	
	dbm.dbCloseConn();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 작성하기</title>
<style>
html, body{
	height:100%;
	margin:0;
	overflow:hidden;
}
.writePlanDiv{
	border:1px solid black;
	width:25%;
	height:99.7%;
	display:inline-block;
	float:left;
	margin:0;
}
.divNav{
	border:1px solid black;
	width:100%;
	height:8%;
	margin:0;
	padding:0px;
	text-align:center;
}
.divButton{
	border:1px solid black;
	width:30%;
	height:50%;
	display:inline-block;
	margin-top:10px;
	padding-top:20px;
	text-align:center;
	border-radius:10px;
	background-color:#90b7f8;
}
span{
	font-weight:bold;
}
.dateDiv{
	border:1px solid black;
	width:100%;
	height:8%;
	padding:15px;
	box-sizing: border-box; 
}
.placeNav{
	border:1px solid black;
	width:100%;
	height:8%;
	padding:15px;
	box-sizing:border-box; 
	text-align:center;
}
.placeCateDiv{
	width:100%;
	height:5%;
	margin:0;
	padding:5px;
	text-align:center;
	box-sizing:border-box; 
}
.placeCate{
	border:1px solid black;
	width:20%;
	height:70%;
	display:inline-block;
	margin-top:5px;
	text-align:center;
	border-radius:5px;
	background-color:#90b7f8;
	padding-top:2px;
	margin-right:10px;
	box-sizing:border-box; 
}
.placeList{
	overflow:auto;
	border:1px solid black;
	width:100%;
	height:68%;
	margin:0;
	padding:0px;
	padding-top:10px;
	padding-left:20px;
	box-sizing:border-box; 
}
.place{
	border:1px solid black;
	border-radius:10px;
	width:95%;
	height:15%;
	padding-top:10px;
	padding-left:10px;
	box-sizing:border-box; 
}
.placeImg{
	border:1px solid black;
	border-radius:10px;
	width:20%;
	height:90%;
	box-sizing:border-box;
	display:inline-block;
}
.placeInfo{
	border:1px solid black;
	border-radius:10px;
	width:75%;
	height:90%;
	box-sizing:border-box; 
	display:inline-block;
	padding:5px;
}
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script>
	let placeCate = "추천 장소";

	function selectPlaceCate(obj){
		placeCate = obj.innerHTML;
		$.ajax({
			url : "selectPlaceCate.jsp",
			type : "get",
			data: {placeCate : placeCate},
			success : function(data){
				let html="";
				var jobj = JSON.parse(data.trim());
				for(let i=0; i<jobj.length; i++){
					html += '<div class="place">';
					html += '<div class="placeImg">';
					html += '<img width="80px" src="'+jobj[i].img1+'">';
					html += '</div>';
					html += '<div class="placeInfo">';
					html += '<button>추가하기</button>';
					html += '<p>제목: '+jobj[i].name+'<br>';
					html += '주소: '+jobj[i].addr1+'<br>';
					html += '댓글 및 별점:</p>';
					html += '</div>';
					html += '</div>';
				}
				document.getElementsByClassName("placeList")[0].innerHTML = html;
			},
			error:function(){
				
			}
		});
	}
	function planPlusFn(no){
		let objNo = no;
		console.log(placeCate);
		$.ajax({
			url : "planPlusFn.jsp",
			type : "get",
			data : {objNo : objNo, placeCate : placeCate},
			success : function(data){
				let html = "";
				var jobj = JSON.parse(data.trim());
				html += '<div class="place">';
				html += '<div class="placeImg">';
				html += '<img width="80px" src="'+jobj.img1+'">';
				html += '</div>';
				html += '<div class="placeInfo">';
				html += '<p>제목: '+jobj.name+'<br>';
				html += '주소: '+jobj.addr1+'<br>';
				html += '</div>';
				html += '</div>';	
				document.getElementsByClassName("placePlan")[0].innerHTML += html;
			},
			error:function(){
				
			}
		});
	}
</script>
</head>
<body>
	<div class="writePlanDiv">
		<div class="divNav">
			<div class="divButton"><span>Jeonjuwiki</span></div>
			<div class="divButton"><span>날짜 확인</span></div>
			<div class="divButton"><span>장소 선택</span></div>
		</div>
		<div class="dateDiv">
			<span>전주</span><br>
			<span>2024-01-30(화) ~ 2024-01-31(수)</span>
		</div>
		<div class="placeNav">
			장소 선택 | 찜 한 장소 | 신규장소 등록
		</div>
		<div>
			<input type="text" name="searchValue" placeholder="장소 검색">
			<button>검색</button>
		</div>
		<div class="placeCateDiv">
			<div class="placeCate" onclick="selectPlaceCate(this);">추천 장소</div>
			<div class="placeCate" onclick="selectPlaceCate(this);">관광지</div>
			<div class="placeCate" onclick="selectPlaceCate(this);">식당</div>
			<div class="placeCate" onclick="selectPlaceCate(this);">숙소</div>
		</div>
		<div class="placeList">
		<%
			for(PlaceVO vo : placeVOlist){
		%>
				<div class="place">
				<div class="placeImg">
					<img width="80px" src="<%=vo.getPimg1()%>">
				</div>
				<div class="placeInfo">
					<button onclick="planPlusFn(<%=vo.getPno()%>)">추가하기</button>
					<p>제목: <%= vo.getPname()%><br>
					주소: <%= vo.getPaddr1()%><br>
					댓글 및 별점:</p>
				</div>
				</div>
				
		<%
			}
		%>
		</div>
	</div>
	<div class="writePlanDiv">
		<div>
			<div>
				0 0시간/24시간
			</div>
			<div class="placePlan">
				장소를 선택해 주세요.
			</div>
		</div>
	</div>
</body>
</html>