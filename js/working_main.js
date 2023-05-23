let phoneError = false;
let passwordError = false;
let loginData ={}
let orderData={}
$(document).ready(function () { //binding button

    $("#loginbtn").click(function () {
        validatePhone()
        validatePassword()
        if(passwordError&&passwordError){
            requestLogin()
        }
    })
})

function validatePhone() {

    const regex = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
    let phone = $("#phone");
    let phoneVal=phone.val();
    if(phoneVal.length == ""){
        SnackBar({
            message:"Номер телефону не вказаний",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"error"
        });
        phoneError = false;
        return
    }
    if(regex.test(phoneVal)){
        phoneError = true;
        loginData.phone=phoneVal;
    } else  {
        SnackBar({
            message:"Неправильний формат номеру телефону",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"error"
        });
        phoneError = false;
    }

}
function validatePassword() {

    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    let password = $("#password");
    let passwordVal=password.val();
    if(passwordVal.length == ""){
        SnackBar({
            message:"Пароль  не вказаний",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"error"
        });
        passwordError = false;
        return
    }
    if(regex.test(passwordVal)){
        passwordError = true;
        loginData.password=md5(passwordVal);
    } else  {
        SnackBar({
            message:"Формат паролю не правильний. Пароль має містити від 6 до 20 символів, хочаб одну велику або маленьку літеру і одну цифру",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"error"
        });
        passwordError = false;
    }

}
function requestLogin(){
    let request = $.ajax({
        url: "http://localhost:8080/api/employeeLogin",
        type: "POST",
        contentType:"application/json",
        dataType: "html",
        data: JSON.stringify(loginData),
        success : function (){
            setInterval(requestNewOrders ,10000)
        },
        error: (xhr, status, error) => {
            SnackBar({
                message:"Помилка на сервері",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });
        }
    });
}

const mainContainer = $("#mainContainer");
let oldResponse
function requestNewOrders(){
    let request = $.ajax({
        url: "http://localhost:8080/api/getNewOrders",
        type: "POST",
        contentType:"application/json",
        dataType: "html",
        data: JSON.stringify(loginData),
        success : function (response){
            if(oldResponse === response) return
            else oldResponse = response


            SnackBar({
                message:"Запит успішний",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"success"
            });

            mainContainer.hide(1000);
            setTimeout(()=> {
                    mainContainer.html(response)
                    $(".AcceptButton").on("click", function (){
                        let id = $(this).attr("id")
                        let code=id.split("Accept")[0]
                        console.log("Accept")
                        console.log(code)
                        acceptOrder(code)
                    })
                    $(".DenyButton").on("click", function (){
                        let id = $(this).attr("id")
                        let code=id.split("Deny")[0]
                        console.log("Cancel")
                        console.log(code)
                        denyOrder(code)
                    })
                }
                ,1000);
            mainContainer.show(1000);



        },
        error: (xhr, status, error) => {
            SnackBar({
                message:"Помилка на сервері",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });
        }
    });
}
function acceptOrder(code){
    orderData.boxCode=code
    orderData.employeePhone=loginData.phone
    orderData.employeePassword=loginData.password
    let request = $.ajax({
        url: "http://localhost:8080/api/acceptOrder",
        type: "POST",
        contentType:"application/json",
        dataType: "html",
        data: JSON.stringify(orderData),
        success : function (response){
            if(response=="200")
            SnackBar({
                message:"Запит успішний",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"success"
            });
            else SnackBar({
                message:"Помилка на сервері",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });

        },
        error: (xhr, status, error) => {
            SnackBar({
                message:"Помилка на сервері",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });
        }
    });
    $("#"+code+"Container").hide(100)
}
function denyOrder(code){
    orderData.boxCode=code
    orderData.employeePhone=loginData.phone
    orderData.employeePassword=loginData.password
    let request = $.ajax({
        url: "http://localhost:8080/api/denyOrder",
        type: "POST",
        contentType:"application/json",
        dataType: "html",
        data: JSON.stringify(orderData),
        success : function (response){
            if(response=="200")
                SnackBar({
                    message:"Запит успішний",
                    timeout:5000,
                    position:'br',
                    fixed:true,
                    width:"20vw",
                    status:"success"
                });
            else SnackBar({
                message:"Помилка на сервері",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });

        },
        error: (xhr, status, error) => {
            SnackBar({
                message:"Помилка на сервері",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });
        }
    });
    $("#"+code+"Container").hide(100)
}