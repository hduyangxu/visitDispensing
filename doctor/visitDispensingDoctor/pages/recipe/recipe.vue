<template>
	<view style="height: 100vh;">
		<u-tabs-swiper ref="uTabs" :list="list" active-color="#87cbc3" inactive-color="#b0b0b0" :is-scroll="false"
			height="100" :bar-style="barStyle" :current="current" @change="tabsChange" bar-width="360">
		</u-tabs-swiper>
		<swiper :current="swiperCurrent" @transition="transition" @animationfinish="animationfinish"
			style="width: 100%; height: 100%;">
			<swiper-item>
				<view class="part1">
					<view style="width: 20%; margin-left: 4%; color: #999999; height: 80rpx;">所需药品</view>
					<view style="width: 92%; margin-left: 4%; display: flex; flex-direction: row;  flex-wrap: wrap">
						<view style="line-height: 40rpx; color: #3399ff;
						margin-right: 5rpx; margin-top: 20rpx;" 
						v-for="(item,index) in medList"><p style="margin: 0rpx 5rpx 0rpx 5rpx;">{{item}}</p></view>
					</view>
				</view>
				<scroll-view scroll-y style="height: 100%;width: 100%;">
				<view v-for="(itemo,indexo) in ctlMedDetail">
				<view class="part2"></view>
				<view class="part3">
					<view class="inside3_1">
						<view class="inside3_1_1">							<view style="flex:1;  display: flex; flex-direction: row;" >
								<view style="margin-top: 15rpx; margin-left: 30%;">
									<u-image  width="50rpx" height="50rpx" src="/static/drug.png"></u-image>
								</view>
								<view style=" margin-left: 5%;" @click="typeShow(indexo)">{{ctlMedDetail[indexo].type}}</view>
							</view>
							<view style="flex:1; text-align: center; color: #3399ff;"
							@click="addDrug(indexo)">+新增药品</view>					
						</view>
						<view v-for="(itemi,indexi) in ctlMedDetail[indexo].list" class="inside3_1_2">
							<view style="width: 65%; display: flex; flex-direction: column; flex-wrap: wrap;">
								<view style="width: 100%; flex-wrap: wrap;">
									<p style="margin: 30rpx 10rpx 10rpx 20rpx; font-weight: 600;">{{itemi.name}}</p>
								</view>
								<view>
									<p style="margin: 10rpx 10rpx 10rpx 20rpx;">{{itemi.size}}</p>
								</view>
								<view>
									<p style="margin: 10rpx 10rpx 30rpx 20rpx; color: #999999;">{{itemi.use}}</p>
								</view>
							</view>
							<view style="width: 20%;"><p style="margin: 30rpx 0rpx 0rpx 10rpx;">{{itemi.number}}</p></view>
							<view @click="deleteDrog(indexo,indexi)" style="width: 15%; margin-top: 30rpx;"><u-icon name="trash" color="#ff0000" size="35"></u-icon></view>
						</view>
					</view>
				</view>
				<view class="part2"></view>
				</view>
				<view style="height: 200rpx; width: 100%;"></view>
				</scroll-view>
			</swiper-item>
			<swiper-item>
				<scroll-view scroll-y style="height: 100%;width: 100%;">
				<view v-for="(itemo,indexo) in finMedDetail" >
					<view class="part2"></view>
					<view class="part3">
						<view class="inside3_1">
							<view class="inside3_1_1">
								<view style="flex:1;  display: flex; flex-direction: row;" >
									<view style="margin-top: 15rpx; margin-left: 30%;">
										<u-image  width="50rpx" height="50rpx" src="/static/drug.png"></u-image>
									</view>
									<view style=" margin-left: 5%;" >{{finMedDetail[indexo].type}}</view>
								</view>	
								<view style="flex:1; text-align: center; color: #3399ff;"
								@click="">药品列表</view>					
							</view>
							<view v-for="(itemi,indexi) in finMedDetail[indexo].list" class="inside3_1_2">
								<view style="width: 75%; display: flex; flex-direction: column; flex-wrap: wrap;">
									<view style="width: 100%; flex-wrap: wrap;">
										<p style="margin: 30rpx 10rpx 10rpx 20rpx; font-weight: 600;">{{itemi.name}}</p>
									</view>
									<view>
										<p style="margin: 10rpx 10rpx 10rpx 20rpx;">{{itemi.size}}</p>
									</view>
									<view>
										<p style="margin: 10rpx 10rpx 30rpx 20rpx; color: #999999;">{{itemi.use}}</p>
									</view>
								</view>
								<view style="width: 25%;" ><p style="margin: 30rpx 0rpx 0rpx 10rpx;">{{itemi.number}}</p></view>
							</view>
						</view>
					</view>
					<view class="part2"></view>
				</view>
				</scroll-view>
			</swiper-item>
		</swiper>
		<view class="part4" v-show="current == 0">
			<view class="light"  @click="addDrugList">+新增处方</view>
			<view class="dark"  @click="submitList">提交处方</view>
		</view>
		<u-select v-model="type_show" :list="type_list" @confirm="typeConfirm" mode="single-column"></u-select>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				loadModal: false,
				doctorId: '',
				list: [{
					name: '待完成'
				}, {
					name: '已完成'
				}],
				current: 0, // tabs组件的current值，表示当前活动的tab选项
				swiperCurrent: 0, // swiper组件的current值，表示当前那个swiper-item是活动的
				barStyle: {
					"height": "10rpx",
					"border-radius": "0"
				},
				
				ctlIndex:'',  
				type_show:false,
				type_list:[
					{value: '1',label: '西方药'},
					{value: '2',label: '中方药'}
				],
				//data
				medIdList:[],
				medList:[],
				ctlMedDetail:[
					{	
						num:'1',
						type:'西方药',
						list:[
						]
					},
					
				],
				finMedDetail:[
					{
						type:'西方药',
						list:[]
					},
				]
			}
		},
		methods: {
			tabsChange(index) {
				this.swiperCurrent = index;
			},
			// swiper-item左右移动，通知tabs的滑块跟随移动
			transition(e) {
				let dx = e.detail.dx;
				this.$refs.uTabs.setDx(dx);
			},
			// 由于swiper的内部机制问题，快速切换swiper不会触发dx的连续变化，需要在结束时重置状态
			// swiper滑动结束，分别设置tabs和swiper的状态
			animationfinish(e) {
				let current = e.detail.current;
				this.$refs.uTabs.setFinishCurrent(current);
				this.swiperCurrent = current;
				this.current = current;
			},
			submitList(){
				let _this = this;
				let theConsult;
				let theDoctor;
				console.log(this.ctlMedDetail[0].list[0]);
				uni.getStorage({
					key: 'consult',
					success: function(res) {
						theConsult = res.data;
						//console.log(theConsult.docId)
						uni.request({
							url: 'http://47.111.10.102:8886/doctor/findOne',
							data: {
								id: theConsult.docId
							},
							success: (res) => {
								theDoctor = res.data.data[0];
								//console.log(theDoctor.name);
								for(let i = 0 ;i < _this.ctlMedDetail.length; i++){
									uni.request({
										url: 'http://47.111.10.102:8886/pres_info/add',//
										data: {
											consult_id : theConsult.id,
											doctor_id : theDoctor.id,
											doctor_name : theConsult.name,
											type : 1,
											user_id : theConsult.userId,
										},
										header: {
											'Content-Type': 'application/x-www-form-urlencoded'
										},
										method:'POST',
										success: (res) => {
											console.log(res.data.data);
											//console.log(_this.ctlMedDetail);
											for(let j = 0 ;j < _this.ctlMedDetail[i].list.length; j++){
												console.log('add no.'+i+' '+j)
												uni.request({
													url: 'http://47.111.10.102:8886/pres_drug/add',//
													data: {
														dose : _this.ctlMedDetail[i].list[j].dose,
														dose_unit : _this.ctlMedDetail[i].list[j].dose_unit,
														drug_name : _this.ctlMedDetail[i].list[j].name,
														drug_usage : _this.ctlMedDetail[i].list[j].drug_usage,
														frequency : _this.ctlMedDetail[i].list[j].frequency,
														pres_id : res.data.data.id,
														price : _this.ctlMedDetail[i].list[j].price,
														quantity : _this.ctlMedDetail[i].list[j].quantity,
														remark : _this.ctlMedDetail[i].list[j].remark,
														take_days : _this.ctlMedDetail[i].list[j].take_days
													},
													header: {
														'Content-Type': 'application/x-www-form-urlencoded'
													},
													method:'POST',
													success: (res) => {
														console.log('add');
													}
												});
											}
										}
									});
								}
							}
						});
					}
				});
				uni.setStorage({
				    key: 'medDetail',
				    data: {},
				    success: function () {
				        console.log('clear medDetail');
						uni.navigateTo({
							url: '../patientDetail/patientDetail'
						})
				    }
				});
			},
			addDrugList(){
				if(this.ctlMedDetail.length == 1)
				this.ctlMedDetail.push({	
					num:this.ctlMedDetail.length+1,
					type:'西方药',
					list:[]
				});
			},
			addDrug(indexo){
				console.log(indexo);
				let _this = this;
				uni.setStorage({
				    key: 'medDetail',
				    data: {
						part3 : indexo
					},
				    success: function () {
				        console.log('success');
						_this.saveMedList()
						uni.navigateTo({
							url: '../addMedicine/addMedicine'
						})
				    }
				});
			},
			deleteDrog(indexo,indexi){
				console.log(indexo+"    "+indexi);
				this.ctlMedDetail[indexo].list.splice(indexi, 1);
				
				if(this.ctlMedDetail[indexo].list.length == 0){
					if(indexo == 0 ){
						this.ctlMedDetail[0].list=[];
					}
					else{
						this.ctlMedDetail.splice(indexo,1);
					}
				}
				
			},
			typeShow(indexo){
				this.type_show = true;
				console.log(indexo);
				this.ctlIndex = indexo;
			},
			typeConfirm(e) {
				console.log(e[0].label);
				this.ctlMedDetail[this.ctlIndex].type = e[0].label;
			},
			saveMedList(){
				let _this = this;
				uni.setStorage({
				    key: 'finMedList',
				    data: _this.ctlMedDetail,
				    success: function () {
				        console.log('success');
				    }
				});
			},
			init(){
				let _this = this;
				uni.getStorage({
				    key: 'consult',
				    success: function (res) {
						_this.consult = res.data;
						_this.medList = _this.consult.drugs.split('、');
						_this.medIdList = _this.consult.drugIds;
						//console.log(_this.medIdList);
				    }
				});
			},
			init2(){
				let _this = this;
				uni.getStorage({
				    key: 'finMedList',
				    success: function (res) {
						_this.ctlMedDetail = res.data;
				    }
				});
			},
			init3(){
				let _this = this;
				uni.getStorage({
				    key: 'medDetail',
				    success: function (res) {
						if(JSON.stringify(res.data) != "{}"){
							/*console.log(res.data.part1);
							console.log(res.data.part2);
							console.log(res.data.part3);*/
							let addItem = {
								name: res.data.part1.drugName,
								size:'剂量 : '+res.data.part2.dose+'*'+res.data.part1.dose+res.data.part1.doseUnit+'/次',
								use:'用法 : '+res.data.part2.use_time+' '+res.data.part2.use_method,
								number:res.data.part2.total+res.data.part1.packUnit,
								dose  : res.data.part1.dose,
								dose_unit : res.data.part1.doseUnit,
								drug_usage : res.data.part2.use_method,
								frequency : res.data.part2.use_time,
								price : res.data.part1.price,
								quantity : res.data.part2.total,
								remark : res.data.part2.tip,
								take_days : res.data.part2.days,
							}
							//console.log(addItem.dose+' '+addItem.take_days);
							_this.ctlMedDetail[res.data.part3].list.push(addItem);
						}
				    }
				});
			},
			init4(){
				let _this = this;
				uni.getStorage({
				    key: 'consult',
				    success: function (res) {
						//console.log(res.data.id);
						uni.request({
							url: 'http://47.111.10.102:8886/pres_info/findByConsultId',
							data: {
								id: res.data.id
							},
							success: (res) => {
								for(let i = 0 ; i < res.data.data.length ; i++){
									if (i!=0){
										_this.finMedDetail.push({
											type:'西方药',
											list:[]
										});
									}
									//console.log(res.data.data[i].id);
									uni.request({
										url: 'http://47.111.10.102:8886/pres_drug/findByPresId',
										data: {
											id: res.data.data[i].id
										},
										success: (res) => {
											//console.log(res.data.data);
											for(let j = 0 ; j < res.data.data.length ; j++){
												_this.finMedDetail[i].list.push({
													id:  res.data.data[j].id,
													name: res.data.data[j].drugName,
													size:res.data.data[j].dose+res.data.data[j].doseUnit ,
													use:'用法 : '+res.data.data[j].frequency+' '+res.data.data[j].drugUsage,
													number:res.data.data[j].quantity+'盒'
												});
											}
										}
									});
								}
							}
						});
				    }
				});
			}
		},
		mounted(){
			this.init();
			this.init2();
			this.init3();
			this.init4();
		}
	}
</script>

<style lang="scss" scoped>
	.part1{
		width: 100%;
		background: #ffcc99;
		display: flex;
		flex-direction: row;
		line-height: 80rpx;
	}
	.part2{
		width: 100%;
		background:#ffffff;
		height: 40rpx;
	}
	.part3{
		width: 100%;
		background:#ffffff;
		margin-top: 0;
		.inside3_1{
			width: 90%;
			margin-left: 5%;
			border: 4rpx solid #eeeeee;
			border-radius: 20rpx;
			.inside3_1_1{
				height: 100rpx;
				display: flex;
				flex-direction: row;
				background: #eeeeee;
				line-height: 100rpx;
			}
			.inside3_1_2{
				width:100%;
				display: flex;
				flex-direction: row;
				border-top: 4rpx solid #eeeeee;
			}
		}
	}
	.part4{
		width: 100%;
		height: 120rpx;
		bottom: 0;
		position: fixed;
		display: flex;
		flex-direction:row;
		.light{
			height: 120rpx;
			float: left;
			text-align: center;
			line-height: 120rpx;
			background: #eeeeee;
			flex: 1;
		}
		.dark{
			height: 120rpx;
			float: right;
			text-align: center;
			line-height: 120rpx;
			background: #1ab394;
			color: #FFFFFF;
			flex: 2;
		}
	}
</style>
