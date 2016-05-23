/**
 * Created by Phyllis Peng on 5/23/2016.
 */
var con=0;
var approve="";
function signin(){
    alert("signIn");
};

function userRole(){
    alert("in userRole");
    var x = document.getElementsByName("userroles").valueOf();
    alert("now you signed in as a " +x);
};


function submitmsg(){
    con = con+1
    var name=document.getElementById("name").value;

    var addr=document.getElementById("addr").value;
    var salary=document.getElementById("salary").value;
    var amount=document.getElementById("amount").value;
    var term=document.getElementById("terms").value;

    if (amount <5000 && salary>1000){
        approve = "Approve";

    }else if(amount >= 5000 && salary <=1000){
        approve="Decline";
    }else{
        approve="Refer";
    }

    var elem = document.createElement('div');
    var str= "No.:"+con+"            "    +
            "Amount: "+amount+"            "+
            "Term: "+term+"            "+
            "Status: "+approve+"            "

        ;
     addr="";
     salary="";
     amount="";
     term="";

    document.getElementById("history").innerHTML =
        elem.innerHTML = str;


};
