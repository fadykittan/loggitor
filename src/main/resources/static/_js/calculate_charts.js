function showBarChart() {
	var t = document.getElementById("chart1");
	t.innerHTML="<canvas id='barChart' width='200' height='200'></canvas>";
	
	var ctx = document.getElementById("barChart").getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ "BLM", "CLM", "KLM", "BLM1", "CLM1" ],
			datasets : [ {
				label : 'Defects by app',
				data : [ 12, 19, 3, 5, 20 ],
				backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)' ],
				borderColor : [ 'rgba(255,99,132,1)', 'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)' ],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});

}


function HideBarChart(){
	var t = document.getElementById("chart1");
	t.innerHTML="";
}



function showPieChart() {
	var t = document.getElementById("chart2");
	t.innerHTML="<canvas id='PieChart' width='200' height='200'></canvas>";
	
	var ctx = document.getElementById("PieChart").getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'pie',
		data : {
			labels : [ "BLM", "CLM", "KLM", "BLM1", "CLM1" ],
			datasets : [ {
				label : 'Defects by app',
				data : [ 12, 19, 3, 5, 20 ],
				backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)' ],
				borderColor : [ 'rgba(255,99,132,1)', 'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)' ],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});

}



function HidePieChart(){
	var t = document.getElementById("chart2");
	t.innerHTML="";
}


