var login;
var password;

function getUserBdd(name) {
	getUserGeneric(name, "v1/user/");
}

function getUserGeneric(name, url) {
	$.getJSON(url + name, function(data) {
		afficheUser(data);
	});
}

function getForAll() {
	getSecure("v1/secure/who");
}

function getByAnnotation() {
	getSecure("v1/secure/byannotation");
}

function getSecure(url) {
	if($("#userlogin").val() != "") {
		$.ajax
		({
			type: "GET",
			url: url,
			dataType: 'json',
			beforeSend : function(req) {
				req.setRequestHeader("Authorization", "Basic " + btoa($("#userlogin").val() + ":" + $("#passwdlogin").val()));
			},
			success: function (data) {
				console.log(data);
				if(data.id != -1 && data.isadmin == 1){
					console.log("connexion :OK");
					$("#login").hide();
					$("#admin").show();
					getCleanersList();
					getStockList();
					getCommandList();
				}else{
					console.log("connexion : err");
					$("#error").show();
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('error: ' + textStatus);
			}
		});
	} else {
		$.getJSON(url, function(data) {
			afficheUser(data);
		});
	}
}

function getCleanersList(){
	$.ajax
	({
		type: "GET",
		url: "v1/cleaner",
		dataType: 'json',
		beforeSend : function(req) {
		},
		success: function (data) {
			console.log("getCleanersList success");
			var table = $("#table-cleaners")
			
			for(i=0; i<data.length; i++){
				var ligne = "<tr><td>"+data[i].nom+"</td><td>"+data[i].prenom+"</td><td>"+data[i].disponible+"</td><td>"+data[i].nbCommandes+"</td><td>"+data[i].location+"</td></tr>";
				$("#table-cleaners").append(ligne);
			}
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('error get cleaners list: ' + textStatus);
			
		}
	});
	
}

function getStockList(){
	$.ajax
	({
		type: "GET",
		url: "v1/produit",
		dataType: 'json',
		beforeSend : function(req) {
		},
		success: function (data) {
			console.log("getStockList success");
			var table = $("#table-stock")
			
			for(i=0; i<data.length; i++){
				var ligne = "<tr><td>"+data[i].type+"</td><td>"+data[i].marque+"</td><td>"+data[i].quantite+"</td></tr>";
				$("#table-stock").append(ligne);
			}
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('error get stock list: ' + textStatus);
			
		}
	});
	
}

function getCommandList(){
	$.ajax
	({
		type: "GET",
		url: "v1/commande",
		dataType: 'json',
		beforeSend : function(req) {
		},
		success: function (data) {
			console.log("getCommandList success");
			console.log(data);
			var table = $("#table-cmd")
			
			for(i=0; i<data.length; i++){
				var carData = getCarInfo(data[i].idCar);
				var ligne = "<tr><td>"+data[i].id+"</td><td>"+data[i].date+"</td><td>"+data[i].adresse+"</td><td>"+carData.immatriculation+"</td><td>"+"voiture n°" +data[i].idCar+"</td><td>"+data[i].termine+"</td></tr>";
				$("#table-cmd").append(ligne);
			}
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('error get stock list: ' + textStatus);
			
		}
	});
	
}
function getCarInfo(id){
	var carData;
	$.ajax
	({
		async: false,
		type: "GET",
		url: "v1/car/"+id,
		dataType: 'json',
		beforeSend : function(req) {
		},
		success:function (data) {
			console.log("getCarData " + id + " success");
			carData = data;
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('error get car data : ' + id+" " + textStatus);
			
		}
	});
	return carData;
}


function simulate(){
	$("#login").hide();
	$("#admin").show();
	getCleanersList();
	getStockList();
	getCommandList();

}

function postUserBdd(login, pwd) {
	postUserGeneric( login, pwd, "v1/user/");
}

function postUserGeneric(login, pwd, url) {
	console.log("postUserGeneric " + url )
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"nom" : "toto",
			"prenom" : "toto",
			"dob" : new Date(),
			"email" : "sfg@fzsegfzs.szefg",
			"tel" : "05215954",
			"isAdmin" : 0,
			"login" : login,
			"password" : pwd,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			console.log("OK !");
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
}

function postAdminBdd(login, pwd) {
	console.log("postAdminBdd " + "v1/user/" )
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/user/",
		dataType : "json",
		data : JSON.stringify({
			"nom" : "admin",
			"prenom" : "admin",
			"dob" : new Date(),
			"email" : "admin@admin.com",
			"tel" : "",
			"isAdmin" : 1,
			"login" : login,
			"password" : pwd,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			console.log("OK !");
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
}

function listUsersBdd() {
	listUsersGeneric("v1/user/");
}

function listUsersGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListUsers(data)
	});
}

function afficheUser(data) {
	console.log(data);
	$("#reponse").html(data.id + " : <b>" + data.alias + "</b> (" + data.name + ")");
}

function afficheListUsers(data) {
	var html = '<ul>';
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		html = html + "<li>"+ data[index].name + "</li>";
	}
	html = html + "</ul>";
	$("#reponse").html(html);
}