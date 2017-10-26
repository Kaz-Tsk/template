
function reservedate()
    {
        var str = document.getElementById('datepicker').value;
        var p1=/土/;
        var p2=/日/;
        var select = document.getElementById('reserveTime');
        var opt;
		if(str.match(p1 || p2)){
			for(var i =9; i < 19; i++){
				opt = document.createElement('option');
				opt.setAttribute('value',i+':00');
				opt.innerHTML = i+":00";
				select.appendChild(opt);
			}
		}else{
			for(var i =10; i < 20; i++){
				opt = document.createElement('option');
				opt.setAttribute('value',i+':00');
				opt.innerHTML = i+":00";
				select.appendChild(opt);
			}
		}
}