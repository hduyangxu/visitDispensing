(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/patienceInfo/patienceInfo"],{"2ede":function(e,n,t){"use strict";(function(e){Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var t={data:function(){return{form:{sex:"",name:"",id:"",birth:"",age:"",number:""},showSex:!1,showDate:!1,labelStyle:{width:"130rpx",display:"flex","justify-content":"flex-end"},sexList:[{text:"男"},{text:"女"}]}},methods:{actionSheetCallback:function(e){this.form.sex=this.sexList[e].text},save:function(){var n=this;e.setStorage({key:"patienceInfo",data:n.form,success:function(){console.log("patienceInfo成功保存");var t=getCurrentPages(),o=(t[t.length-1],t[t.length-2]);o.$vm.form.age=n.form.age,o.$vm.form.gender="男"==n.form.sex?1:2,o.$vm.form.name=n.form.name,o.$vm.form.phone=n.form.number,o.$vm.form.id_number=n.form.id,o.$vm.patienceInfo=n.form.name+" "+n.form.sex+" "+n.form.age+"岁",e.navigateBack()}})},change:function(e){this.form.birth=e.result;var n=new Date;this.form.age=n.getFullYear()-e.year+1},loadPatienceInfo:function(){var n=this;e.getStorage({key:"patienceInfo",success:function(e){console.log("获取到缓存中的patienceInfo"),n.form=e.data}})}},mounted:function(){this.loadPatienceInfo()}};n.default=t}).call(this,t("543d")["default"])},5734:function(e,n,t){"use strict";t.r(n);var o=t("ded5"),u=t("7443");for(var r in u)"default"!==r&&function(e){t.d(n,e,(function(){return u[e]}))}(r);t("9a75");var i,a=t("f0c5"),c=Object(a["a"])(u["default"],o["b"],o["c"],!1,null,null,null,!1,o["a"],i);n["default"]=c.exports},7443:function(e,n,t){"use strict";t.r(n);var o=t("2ede"),u=t.n(o);for(var r in o)"default"!==r&&function(e){t.d(n,e,(function(){return o[e]}))}(r);n["default"]=u.a},"802c":function(e,n,t){},"935d":function(e,n,t){"use strict";(function(e){t("cfbe");o(t("66fd"));var n=o(t("5734"));function o(e){return e&&e.__esModule?e:{default:e}}e(n.default)}).call(this,t("543d")["createPage"])},"9a75":function(e,n,t){"use strict";var o=t("802c"),u=t.n(o);u.a},ded5:function(e,n,t){"use strict";t.d(n,"b",(function(){return u})),t.d(n,"c",(function(){return r})),t.d(n,"a",(function(){return o}));var o={uForm:function(){return t.e("uview-ui/components/u-form/u-form").then(t.bind(null,"4c08"))},uFormItem:function(){return Promise.all([t.e("common/vendor"),t.e("uview-ui/components/u-form-item/u-form-item")]).then(t.bind(null,"afe0"))},uInput:function(){return Promise.all([t.e("common/vendor"),t.e("uview-ui/components/u-input/u-input")]).then(t.bind(null,"84ab"))},uActionSheet:function(){return t.e("uview-ui/components/u-action-sheet/u-action-sheet").then(t.bind(null,"9ce2"))},uCalendar:function(){return t.e("uview-ui/components/u-calendar/u-calendar").then(t.bind(null,"0714"))}},u=function(){var e=this,n=e.$createElement;e._self._c;e._isMounted||(e.e0=function(n){e.showSex=!0},e.e1=function(n){e.showDate=!0})},r=[]}},[["935d","common/runtime","common/vendor"]]]);