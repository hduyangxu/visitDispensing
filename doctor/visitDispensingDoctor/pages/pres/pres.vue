<template>
	<view class="wrap">
		<view class="cu-load load-modal" v-if="loadModal">
			<!-- <view class="cuIcon-emojifill text-orange"></view> -->
			<image src="http://yuan619.xyz/vd/load.gif" mode="aspectFit"></image>
			<view class="gray-text">获取信息中</view>
		</view>
		<u-tabs-swiper ref="uTabs" :list="list" active-color="#32ba71" inactive-color="#b0b0b0" :is-scroll="false"
			height="80" :bar-style="barStyle" :current="current" @change="tabsChange" bar-width="360">
		</u-tabs-swiper>
		<swiper :current="swiperCurrent" @transition="transition" @animationfinish="animationfinish"
			style="height:100%;width: 100%;">
			<swiper-item>
				<scroll-view scroll-y style="height: 100%;width: 100%;">
					<view class="pres">
						<view style="display: flex; flex-direction: row;">
							<view class="hospitalName">
								<view style="font-size: 165%;">创业慧康医院</view>
								<view style="font-size: 130%;">处方笺</view>
							</view>
							<view class="tagArea">
								<view class="tag">
									普通药品处方
								</view>
							</view>
						</view>
						<view class="patienceInfo">
							<view>
								姓名&nbsp;{{patienceInfo.name}}&emsp;
								性别&nbsp;{{patienceInfo.gender == 1 ? '男':'女'}}&emsp;&nbsp;&emsp;
								年龄&nbsp;{{patienceInfo.age}}岁&emsp;
								日期&nbsp;{{patienceInfo.finishTime}}
							</view>
							<view>
								身份证号&nbsp;{{patienceInfo.idNumber}}&emsp;
								手机号&nbsp;{{patienceInfo.phone}}
							</view>
						</view>
						<view class="medicineArea">
							<view style="font-size: 120%; padding-top: 10rpx;">
								Rp
							</view>
							<view class="medicine" v-for="(item,index) in medicineList1" :key="index">
								<view style="display: flex; flex-direction: column;">
									<view>{{item.drugName}}</view>
									<view class="medicineInfo">
										用法&nbsp;{{item.dose+item.doseUnit}}/次&nbsp;&nbsp;&nbsp;
										{{item.frequency}}&nbsp;&nbsp;
										{{item.drugUsage}}&nbsp;&nbsp;
										{{item.takeDays}}天
									</view>
								</view>
								<view>
									{{item.quantity}}盒
								</view>
							</view>
						</view>
						<view class="cost">
							药费:<text space="nbsp" style="color: #e68852;">{{' '}}￥{{getCost(medicineList1)}}元</text>
						</view>
						<view class="doctorArea">
							<view class="doctor">
								<view>处方医师：<text space="nbsp">{{' '}}{{doctorName}}</text></view>
								<view>审核医师：</view>
								<view>发药药师：</view>
							</view>
							<view>盖章：</view>
						</view>
						<view class="tip">
							*药师温馨提示：请遵医嘱服药！处方当日有效！
						</view>
					</view>
				</scroll-view>
			</swiper-item>
			<swiper-item>
				<scroll-view scroll-y style="height: 100%;width: 100%;">
					<view class="pres">
						<view style="display: flex; flex-direction: row;">
							<view class="hospitalName">
								<view style="font-size: 165%;">创业慧康医院</view>
								<view style="font-size: 130%;">处方笺</view>
							</view>
							<view class="tagArea">
								<view class="tag">
									特殊药品处方
								</view>
							</view>
						</view>
						<view class="patienceInfo">
							<view>
								姓名&nbsp;{{patienceInfo.name}}&emsp;
								性别&nbsp;{{patienceInfo.gender == 1 ? '男':'女'}}&emsp;&nbsp;&emsp;
								年龄&nbsp;{{patienceInfo.age}}岁&emsp;
								日期&nbsp;{{patienceInfo.finishTime}}
							</view>
							<view>
								身份证号&nbsp;{{patienceInfo.idNumber}}&emsp;
								手机号&nbsp;{{patienceInfo.phone}}
							</view>
						</view>
						<view class="medicineArea">
							<view style="font-size: 120%; padding-top: 10rpx;">
								Rp
							</view>
							<view class="medicine" v-for="(item,index) in medicineList2" :key="index">
								<view style="display: flex; flex-direction: column;">
									<view>{{item.drugName}}</view>
									<view class="medicineInfo">
										用法&nbsp;{{item.dose+item.doseUnit}}/次&nbsp;&nbsp;&nbsp;
										{{item.frequency}}&nbsp;&nbsp;
										{{item.drugUsage}}&nbsp;&nbsp;
										{{item.takeDays}}天
									</view>
								</view>
								<view>
									{{item.quantity}}盒
								</view>
							</view>
						</view>
						<view class="cost">
							药费:<text space="nbsp" style="color: #e68852;">{{' '}}￥{{getCost(medicineList2)}}元</text>
						</view>
						<view class="doctorArea">
							<view class="doctor">
								<view>处方医师：<text space="nbsp">{{' '}}{{doctorName}}</text></view>
								<view>审核医师：</view>
								<view>发药药师：</view>
							</view>
							<view>盖章：</view>
						</view>
						<view class="tip">
							*药师温馨提示：请遵医嘱服药！处方当日有效！
						</view>
					</view>

				</scroll-view>
			</swiper-item>
		</swiper>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				loadModal: false,
				doctorId: '',
				list: [{
					name: '处方1'
				}, {
					name: '处方2'
				}],
				current: 0, // tabs组件的current值，表示当前活动的tab选项
				swiperCurrent: 0, // swiper组件的current值，表示当前那个swiper-item是活动的
				barStyle: {
					"height": "10rpx",
					"border-radius": "0"
				},
				medicineList1: [],
				medicineList2: [],
				consultId: '',
				patienceInfo: {
				},
				presId: [],
				doctorName: '',
			}
		},
		methods: {
			tabsChange(index) {
				this.swiperCurrent = index;
			},
			transition(e) {
				let dx = e.detail.dx;
				this.$refs.uTabs.setDx(dx);
			},
			animationfinish(e) {
				let current = e.detail.current;
				this.$refs.uTabs.setFinishCurrent(current);
				this.swiperCurrent = current;
				this.current = current;
			},
			getPresInfo() {
				let _this = this;
				uni.getStorage({
					key: 'patienceInfo',
					success: function(res) {
						_this.patienceInfo = res.data
						_this.patienceInfo.finishTime = _this.patienceInfo.finishTime.substr(0, 10)
					}
				});
				uni.getStorage({
					key: 'consultId',
					success: function(res) {
						_this.consultId = res.data
						console.log( res.data)
						uni.request({
							url: 'http://47.111.10.102:8886/pres_info/findByConsultId',
							data: {
								id: _this.consultId
							},
							success: (res) => {
								console.log( res.data.data)
								_this.doctorName = res.data.data[0].doctorName
								for (let i = 0; i < res.data.data.length; i++) {
									_this.presId.push(res.data.data[i].id)
								}
								console.log(_this.presId)
								_this.getMedicineInfo();
							}
						})
					}
				});
			},
			getMedicineInfo() {
				let _this = this
				for (let i = 0; i < _this.presId.length; i++) {
					uni.request({
						url: 'http://47.111.10.102:8886/pres_drug/findByPresId',
						data: {
							id: _this.presId[i]
						},
						success: (res) => {
							if (i == 0) {
								_this.medicineList1 = res.data.data
							} else {
								_this.medicineList2 = res.data.data
							}
						}
					})
				}
			},
			getCost(list) {
				let sum = 0
				for (let i = 0; i < list.length; i++) {
					sum += list[i].price * list[i].quantity
				}
				return sum
			}
		},
		computed: {
		},
		mounted() {
			this.getPresInfo()
		}
	}
</script>

<style>
	.wrap {
		height: 100vh;
		background-color: #fff;
		padding: 20rpx;
		font-weight: 500;
	}
	.pres {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: flex-start;
		width: 100%;
	}
	.hospitalName {
		width: 290rpx;
		height: 160rpx;
		margin-left: 210rpx;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
	.tagArea {
		width: 210rpx;
		height: 160rpx;
		display: flex;
		flex-direction: column;
		justify-content: flex-end;
		align-items: flex-end;
	}
	.tag {
		margin-right: 5rpx;
		font-size: 120%;
		border: 3rpx #000000 solid;
		width: 130rpx;
		height: 100rpx;
		display: flex;
		flex-direction: row;
		align-items: center;
		padding-left: 16rpx;
		justify-content: center;
		box-shadow: 5rpx 5rpx 5rpx #888888;
	}
	.patienceInfo {
		width: 100%;
		height: 310rpx;
		margin-top: 80rpx;
		padding-bottom: 210rpx;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		border-bottom: #000000 6rpx solid;
	}
	.medicineArea {
		margin-top: 20rpx;
		display: flex;
		flex-direction: column;
		width: 100%;
		/* background-color: #19BE6B; */
		padding-left: 20rpx;
	}
	.medicine {
		width: 100%;
		display: flex;
		flex-direction: row;
		align-items: center;
		justify-content: space-between;
		margin-top: 20rpx;
	}
	.medicineInfo {
		color: #8c8c8c;
	}
	.cost {
		display: flex;
		flex-direction: row;
		margin-top: 20rpx;
		width: 100%;
		justify-content: flex-end;
	}
	.doctorArea {
		margin-top: 40rpx;
		width: 100%;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: flex-start;
		font-weight: 530;
		/* background-color: #71D5A1; */
		padding-right: 30rpx;
		padding-left: 10rpx;
		font-size: 110%;
	}
	.doctor {
		display: flex;
		flex-direction: column;
	}
	.doctor view {
		margin-top: 7rpx;
	}
	.tip {
		color: #cbcbcb;
		width: 100%;
		margin-top: 50rpx;
		font-size: 80%;
		text-align: center;
	}
</style>