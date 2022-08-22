function deleteCookie() {
	setCookie("gioHangCookie", '', 0)
	document.getElementById("soLuongSanPham").innerHTML = 0;
}

function setCookie(cname, cvalue, exdays) {
	var value = cvalue;
	if(value.indexOf("&") == -1){
		const d = new Date();
		if(value.indexOf(":") == -1){
			d.setTime(d.getTime() + (0 * 24 * 60 * 60 * 1000));
		}else {
			d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
		}
		let expires = "expires=" + d.toUTCString();
		document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
		return ""
	}
	const myArray = value.split("&");
	const d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	let expires = "expires=" + d.toUTCString();
	document.cookie = cname + "=" + value + ";" + expires + ";path=/";
}

function checkCookie() {
	let gioHang = getCookie("gioHangCookie");
	console.log(gioHang);
	if (gioHang != "") {
		alert("Welcome again " + gioHang);
	} else {
		alert("Welcome again NULL");
	}
}

function getCookie(cname) {
	let name = cname + "=";
	let decodedCookie = decodeURIComponent(document.cookie);
	let ca = decodedCookie.split(';');
	
	for (let i = 0; i < ca.length; i++) {
		let c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

function themGioHang(maSanPham, soLuong){
	var gioHang = getCookie("gioHangCookie");
	if(gioHang == ""){
		setCookie("gioHangCookie", maSanPham + ":" + soLuong, 1);
		document.getElementById("soLuongSanPham").innerHTML = 1;
	}
	else {
		var hashGioHang = gioHang.split("&");
		for (let i = 0; i < hashGioHang.length; i++) {
			
			var hashSanPham = hashGioHang[i].split(":")
			if(hashSanPham[0] == maSanPham){
				
				let kqSL = parseInt(hashSanPham[1]) + parseInt(soLuong)
				let chuoiKQ = maSanPham + ":" + kqSL;
				let result = gioHang.replace(hashGioHang[i], chuoiKQ);
				console.log(result)
				setCookie("gioHangCookie", result, 1);
				document.getElementById("soLuongSanPham").innerHTML = hashGioHang.length;
				return ""
			}
		}
		var gioHangNew = gioHang + "&" + maSanPham + ":" + soLuong; 
		setCookie("gioHangCookie", gioHangNew, 1);
		document.getElementById("soLuongSanPham").innerHTML = hashGioHang.length+1;
	}            
}

function getSoLuongSanPhamGioHang(){
	var gioHang = getCookie("gioHangCookie");
	if(giohang != ""){
		var hashGioHang = gioHang.split("&");
		document.getElementById("soLuongSanPham").innerHTML = hashGioHang.length;
	} else {
		document.getElementById("soLuongSanPham").innerHTML = 0;
	}
}

function getSoLuongSanPham(){
	var gioHang = getCookie("gioHangCookie");
	if(giohang != ""){
		var hashGioHang = gioHang.split("&");
		console.log(hashGioHang.length)
		return hashGioHang.length
	} else {
		console.log(0)
		return 0
	}
}
