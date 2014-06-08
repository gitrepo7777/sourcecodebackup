var req;
function validateUsername() {
	var username = document.getElementById("userName");
	if (username.value.length == 0)
	   return;
	   
	var url = "rrh/users/" + escape(username.value) +"/";
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	req.open("Get", url, true);
	req.onreadystatechange = usernameCallback;
	req.send(null);
}
function usernameCallback() {
	if (req.readyState == 4) {
		if (req.status == 200) {
			var jsonData = req.responseText;
            var myJSONObject = eval("(" + jsonData + ")");
            var un = myJSONObject.userName;
            var username = document.getElementById("userName");
            if (username.value == un) {
                alert("Warning: " + username.value + " exists already. Choose another username.");
                username.value = "";
                username.focus();
		      }
		}
	}
}

function updateDivisions() {
	var labSel = document.getElementById("lab");
	var url = "rrh/divisions/?labID=" + escape(labSel.value);
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	req.open("Get", url, true);
	req.onreadystatechange = updateDivisionsCallback;
	req.send(null);
}
function updateDivisionsCallback() {
	if (req.readyState == 4) {
		if (req.status == 200) {
			var jsonData = req.responseText;
            var divisionsData = eval("(" + jsonData + ")");
            var divisionSel = document.getElementById("division");
            var length = divisionSel.length;
            for (var b = 0; b < length; b++) {
                divisionSel.options[b] = null;
            }
            for (var a = 0; a < divisionsData.length; a++) {
                divisionSel.options[a] = new Option(divisionsData[a].name, divisionsData[a].ID);
            }
            divisionSel.disabled = "";
		}
	}
}
