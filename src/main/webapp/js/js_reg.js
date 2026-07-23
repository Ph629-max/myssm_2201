//1、定义全局变量
var objForm = objMp = objCode = objCode2 = objPwd = objRepwd = objConfirm = null;

window.onload = function () {
    //2、初始化变量。将html元素转成DOM对象
    objForm = $("#myform");
    objMp = $("#mp");
    objCode = $("#code");
    objCode2 = $("#code2");
    objPwd = $("#pwd");
    objRepwd = $("#repwd");
    objAlert = $("#alert");
    objMp.focus();

    //3、给DOM对象设置监听器
    objMp.blur(checkMp);
    objCode.blur(checkCode);
    objCode2.blur(checkCode2);
    objPwd.blur(checkPwd);
    objRepwd.blur(checkRepwd);

    //表单设置提交事件监听器。onsubmit事件属于form表单，而不是submit提交按钮。
    objForm.submit(function (evt) {
        var e = evt || window.event;
        if (!checkSubmit()) {
            //当输入内容有任意一项没有达到要求，则阻止表单默认的提交行为。
            e.preventDefault();
        }
    });
};

//input表单验证的公用的回调函数
function checkInput(regExp, objInput, strAlert) {
    var flag = regExp.test(objInput.val());
    if (!flag) {
        objAlert.html("❌ " + strAlert );
    } else {
        objAlert.html("");
    }
    return flag;
}

function checkMp() {
    var regExp = /^1[356789]\d{9}$/;
    console.log("--------------------------------");
    return checkInput(regExp, objMp," 手机号码输入不正确!");
}

function checkCode() {
    var regExp = /^[A-Za-z1-9]{4}$/;
    return checkInput(regExp, objCode, " 验证码输入不正确!");
}

function checkCode2() {
    var regExp = /^\d{4,10}$/;
    return checkInput(regExp, objCode2, " 手机验证码输入不正确!");
}

function checkPwd() {
    var regExp = /^(\d+[A-Za-z]\w*|[A-Za-z]+\d\w*)$/;
    return checkInput(regExp, objPwd, " 密码输入不正确!");
}

function checkRepwd() {
    if (objRepwd.val() != objPwd.val()) {
        objAlert.html("❌ 密码输入不一致！");
    } else {
        objAlert.html("");
        return true;
    }
}

//表单提交需要对每个输入项进行验证，只要有任何一项有错误，就返回false
function checkSubmit() {
    //检验手机号码
    if (!checkMp()) return false;
    //检验图形验证码
    if (!checkCode()) return false;
    //检验手机验证码
    if (!checkCode2()) return false;
    //检验密码
    if (!checkPwd()) return false;
    //检验重复密码
    if (!checkRepwd()) return false;
    return true;
}