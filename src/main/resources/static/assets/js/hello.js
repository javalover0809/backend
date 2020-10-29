alert("你好啊,唐国洁，要加油啊！你一定能改变世界！")
var connection = new RTCMultiConnection();
alert(connection)



var connection = new RTCMultiConnection();

// this line is VERY_important
connection.socketURL = 'https://rtcmulticonnection.herokuapp.com:443/';

// if you want audio+video conferencing
connection.session = {
    audio: true,
    video: true
};

connection.openOrJoin('your-room-id');


alert("你一定能影响世界！！！")
   
