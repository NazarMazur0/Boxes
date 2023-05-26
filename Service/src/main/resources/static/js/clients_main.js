const mainContainer = $("#mainContainer")
const loginbtn = $("#loginbtn")
const emailInput = $("#email")
const codeArea=$("#codeArea")
const codeInput=$("#code")
let oldResponse
let emailError = false
let emailVal
let codeVal
let codeError = false
let loginData={}

$(document).ready(function () { //binding button
    codeArea.hide()
    loginbtn.click(function () {
        validateEmail()
        if(emailError){
            requestEmailLogin()
        }
    })
})

function validateEmail(){


    let regex = /^([_\-\.0-9a-zA-Z]+)@([_\-\.0-9a-zA-Z]+)\.([a-zA-Z]){2,7}$/;
     emailVal = emailInput.val()
    if(emailVal.length==" "){
        SnackBar({
            message:"Email не вказаний",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"error"
        })
        emailError = false;
    }
    else
    if (regex.test(emailVal)) {
        emailError = true;
        loginData.email=emailVal
    }
    else{
        SnackBar({
            message:"Неправильний формат email",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"error"
        })
        emailError = false;
    }


}

function requestEmailLogin(){
    let request = $.ajax({
        url: window.location.origin+"/api/clientLogin",
        type: "POST",
        contentType:"text/plain",
        dataType: "html",
        data:emailVal,
        success : callbackEmailLogin ,
        error: (xhr, status, error) => {
            SnackBar({
                message:"Помилка на сервері",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            })
        }
    })
}
function callbackEmailLogin(response){
    if(response=="200"){

        SnackBar({
            message:"Лист надіслано",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"success"
        })

        emailInput.prop("disabled",true)
        emailInput.addClass("border border-3 border-success")
        loginbtn.hide(350)
        loginbtn.unbind()
        setTimeout(function (){loginbtn.removeClass("btn-primary")
            loginbtn.addClass("btn-success")
            loginbtn.html("Вхід")},350)
        setTimeout(function (){
            loginbtn.show(350)
            codeArea.show(350)
        },100)
        loginbtn.click(function (){
            validateCode()
            requestEmailCodeLogin()
        })
    } else {
        SnackBar({
            message:"Email не знайдено",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"error"
        })
    }

}
function validateCode(){

             codeVal = Number(codeInput.val());

            if (isNaN(codeVal)) {
                SnackBar({
                    message:"Неправильний формат коду",
                    timeout:5000,
                    position:'br',
                    fixed:true,
                    width:"20vw",
                    status:"error"
                })
                codeError=false

            } else {

                codeError=true
                loginData.code=codeVal
            }



}
function requestEmailCodeLogin(){
    let request = $.ajax({
        url: window.location.origin+"/api/clientLoginWithCode",
        type: "POST",
        contentType:"application/json",
        dataType: "html",
        data:JSON.stringify(loginData),
        success : callbackEmailCodeLogin ,
        error: (xhr, status, error) => {
            SnackBar({
                message:"Помилка на сервері",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            })
        }
    })
}
function callbackEmailCodeLogin(response){
    if(response=="200"){
        SnackBar({
        message:"Вхід здійснено",
        timeout:5000,
        position:'br',
        fixed:true,
        width:"20vw",
        status:"success"
    });
        mainContainer.hide(350)
        let request = $.ajax({
            url: window.location.origin+"/api/getClientOrders",
            type: "POST",
            contentType:"application/json",
            dataType: "html",
            data:JSON.stringify(loginData),
            success : callbackGetOrders ,
            error: (xhr, status, error) => {
                SnackBar({
                    message:"Помилка на сервері",
                    timeout:5000,
                    position:'br',
                    fixed:true,
                    width:"20vw",
                    status:"error"
                })
            }
        })
    }
    else {
        codeInput.val("")
        SnackBar({
            message:"Код не правильний",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"error"
        });
    }

}
function callbackGetOrders(response){
    mainContainer.html(response)
    mainContainer.show(350)
}
