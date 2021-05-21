/**
 * 
 */
 
 
 function sendIdAndPlace(id){
  
  var place = document.getElementById(id + "select").value;
 
 location.href = location.origin + "/GeoLink3D/tools-registry/takeAwayTool?id=" + id + "&place=" + place;
 }
 
function sendSerialNoAndPlace(id){

var serial = document.getElementById(id + "serial").innerText;
var place = document.getElementById(id + "select").value;

location.href = location.origin + "/GeoLink3D/tools-registry/bringBackTool?serial=" + serial + "&place=" + place;
}