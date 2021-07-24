<template>
	<view >
		<div style="background: #E0E0E0; width: 100%; height: 100%;">
			<div class="header">药品设置</div>
			<div class="style1">
				<div class="label">药品</div>
				<div class="select"  @click="changeDrug">{{med_selectd.drugName}}</div>
				<div class="icon" @click="changeDrug">
					<u-icon name="arrow-right" color="#999999"></u-icon>
				</div>
			</div>
			<div class="style1">
				<div class="label">剂量({{med_selectd.dose}}{{med_selectd.doseUnit}}/份)</div>
				<div class="counter">
					<u-number-box v-model="dose" @change="doseChange"></u-number-box>
				</div>
			</div>
			<div class="style1">
				<div class="label">频次</div>
				<div class="select" @click="time_show = true">{{use_time_show}}</div>
				<div class="icon" @click="time_show = true">
					<u-icon name="arrow-right" color="#999999"></u-icon>
				</div>
				<u-select v-model="time_show" :list="time_list" @confirm="timeConfirm" mode="single-column"></u-select>
			</div>
			<div class="style1">
				<div class="label" >用法</div>
				<div class="select" @click="method_show = true">{{use_method}}</div>
				<div class="icon" @click="method_show = true">
					<u-icon name="arrow-right" color="#999999"></u-icon>
				</div>
				<u-select v-model="method_show" :list="method_list"  @confirm="methodConfirm" mode="single-column"></u-select>
			</div>
			<div class="style1">
				<div class="label">用药天数(天)</div>
				<div class="counter">
					<u-number-box v-model="days" @change="daysChange"></u-number-box>
				</div>
			</div>
			<div class="style1">
				<div class="label">数量({{med_selectd.packUnit}})</div>
				<div class="counter">
					<u-number-box v-model="total" @change="totalChange"></u-number-box>
				</div>
			</div>
			<div class="style2">
				<div class="blank"></div>
				<textarea class="info" placeholder="请输入备注(选填)" v-model="tip"></textarea>
			</div>
			<div class="style4">
			</div>
			<div class="style3">
				<div class="cancel" @click="cancel">取消</div>
				<div class="comfirm" @click="comfirm">确认</div>
			</div>
		</div>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				med_selectd:'未选择',
				ctlIndex:'',
				use_time_show:'',
				use_time_send:'',
				use_method:'',
				dose: 1,
				days: 1,
				total: 1,
				time_show: false,
				method_show: false,
				time_list:[],
				method_list:[],
				tip:''
			}
		},
		methods: {
			comfirm(){
				let res = {
					dose: this.dose,
					use_time: this.use_time_send,
					days: this.days,
					use_method: this.use_method,
					total: this.total,
					tip : this.tip
				}
				//console.log(res);
				let _this = this;
				uni.setStorage({
				    key: 'medDetail',
				    data: {
						part1:_this.med_selectd,
						part2:res,
						part3:_this.ctlIndex
					},
				    success: function () {
				        console.log('success');
						uni.redirectTo({
							url: '../recipe/recipe'
						})
				    }
				});
			},
			cancel(){
				//console.log(this.tip)
				uni.redirectTo({
					url: '../recipe/recipe'
				})
			},
			changeDrug(){
				uni.redirectTo({
					url: '../addMedicine/addMedicine'
				})
			},
			doseChange(e) {
				this.dose = e.value;
				console.log('dose: ' + this.dose);
				
			},
			daysChange(e) {
				this.days = e.value;
				console.log('days: ' + this.days);
			},
			totalChange(e) {
				this.total = e.value;
				console.log('total: ' + this.total);
			},
			timeConfirm(e) {
				let rtn = {
					value:e[0].value,
					label:e[0].label,
				}
				this.use_time_show=rtn.label;
				this.use_time_send=rtn.value;
				console.log(rtn.value);
			},
			methodConfirm(e) {
				//console.log(e[0]);
				let rtn = {
					id:e[0].value,
					value:e[0].label
				}
				this.use_method=rtn.value;
				console.log(rtn);
			},
			init(){
				let _this = this;
				uni.getStorage({
				    key: 'medDetail',
				    success: function (res) {
				        //console.log(res.data);
						_this.med_selectd = res.data.part1;
						_this.ctlIndex = res.data.part3;
						//console.log(_this.med_selectd.packUnit);
						//console.log(res.data.part3);
				    }
				});
				uni.request({
					url: 'http://47.111.10.102:8886/drug_frequency/findAll',
					data: {},
					success: (res) => {
						//console.log(res.data.data.length);
						for(let i = 0 ; i < res.data.data.length; i++){
							//console.log(res.data.data[i]);
							if(i==0){
								_this.use_time_show = res.data.data[i].itemNameAbbr;
								_this.use_time_send = res.data.data[i].itemName;
							}
							_this.time_list.push({
								value: res.data.data[i].itemName,
								label: res.data.data[i].itemNameAbbr,
							})
						}
					}
				});
				uni.request({
					url: 'http://47.111.10.102:8886/drug_usage/findAll',
					data: {},
					success: (res) => {
						for(let i = 0 ; i < res.data.data.length; i++){
							if(i==0){
								_this.use_method = res.data.data[i].itemName;
							}
							_this.method_list.push({value: i+1,label:res.data.data[i].itemName})
						}
					}
				});
			}
		},
		mounted() {
			this.init();
		}
	}
</script>

<style lang="scss" scoped>
	.header{
		width: 100%;
		height: 72px;
		background: #007AFF;
		color: #FFFFFF;
		line-height: 72px;
		text-align: center;
		font-weight: 500;
		font-size: 16px;
	}
	.style1{
		width: 100%;
		height: 72px;
		border-bottom: 1px solid #C0C0C0;
		background-color: #FFFFFF ;
		line-height: 72px;
		.label{
			color: #999999;
			text-align: left;
			margin-left: 5%;
			width: 30%;
			float: left;
			font-size: 14px;
		}
		.select{
			float: left;
			text-align: right;
			width: 55%;
			font-size: 14px;
		}
		.icon{
			width: 8%;
			line-height: 72px;
			float: right;
		}
		.counter{
			float: right;
			margin-right: 5%;
		}
	}
	.style2{
		width: 100%;
		background-color: #FFFFFF ;
		height: 72px;
		border-bottom: 1px solid #C0C0C0;
		.blank{
			height: 26px;
			width: 100px;
		}
		.info{
			width: 80%;
			height: 30px;
			margin-left: 10%;
			font-size: 14px;
			line-height: 20px;
		}
	}
	.style3{
		width: 100%;
		height: 72px;
		bottom: 0;
		position: fixed;
		.cancel{
			width: 50%;
			height: 72px;
			float: left;
			text-align: center;
			line-height: 72px;
			background: #ffffff;
		}
		.comfirm{
			width: 50%;
			height: 72px;
			float: right;
			text-align: center;
			line-height: 72px;
			background: #007AFF;
			color: #FFFFFF;
		}
	}
	.style4{
		width: 100%;
		height: 72px;
		background-color: #f1f1f1;
	}
</style>