var dat1 = [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4];
var chart1;
$(document).ready(function(){
  chart1 = new Highcharts.Chart({
    chart: {renderTo: 'informacion_estadistica'},
    series: [{data: dat1}]
  });
});

