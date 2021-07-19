<template>
	<view class="wrap">
		<view class="cu-load load-modal" v-if="loadModal">
			<!-- <view class="cuIcon-emojifill text-orange"></view> -->
			<image src="http://yuan619.xyz/vd/load.gif" mode="aspectFit"></image>
			<view class="gray-text">获取信息中</view>
		</view>
		<u-tabs-swiper ref="uTabs" :list="list" active-color="#32ba71" inactive-color="#b0b0b0" :is-scroll="false"
			height="100" :bar-style="barStyle" :current="current" @change="tabsChange" bar-width="360">
		</u-tabs-swiper>
		<swiper :current="swiperCurrent" @transition="transition" @animationfinish="animationfinish"
			style="height:80%;width: 100%;">
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
								姓名&nbsp;谢健&emsp;
								性别&nbsp;男&emsp;&nbsp;&emsp;
								年龄&nbsp;29岁&emsp;
								日期&nbsp;2019-07-09
							</view>
							<view>
								身份证号&nbsp;330103199910181012&emsp;
								手机号&nbsp;13116776632
							</view>
						</view>
						<view class="medicineArea">
							<view style="font-size: 120%; padding-top: 10rpx;">
								Rp
							</view>
							<view class="medicine">
								<view style="display: flex; flex-direction: column;">
									<view>鼻炎颗粒</view>
									<view class="medicineInfo">
										用法&nbsp;1.00g/次&nbsp;&nbsp;&nbsp;
										bit&nbsp;&nbsp;
										口服
									</view>
								</view>
								<view>
									1.00盒
								</view>
							</view>
						</view>
						<view class="cost">
							药费:<text space="nbsp" style="color: #e68852;">{{' '}}￥0.01元</text>
						</view>
						<view class="doctorArea">
							<view class="doctor">
								<view>处方医师：<text space="nbsp">{{' '}}朱自强</text></view>
								<view>审核医师：</view>
								<view>发药药师：</view>
							</view>
							<view>盖章：</view>
						</view>
						<view class="tip">
							*药师温馨提示：请遵医嘱服药！处方当日有效！
						</view>
						<view></view>
						<view></view>
					</view>
				</scroll-view>
			</swiper-item>
			<swiper-item>
				<scroll-view scroll-y style="height: 100%;width: 100%;">

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
				recordList: [],
				recordList1: [],
				recordList2: []
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
		},

		mounted() {

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
		padding-left: 10rpx;
		justify-content: center;
		box-shadow: 5rpx 5rpx 5rpx #888888;
	}

    .patienceInfo{
		width: 100%;
		height: 310rpx;
		margin-top: 80rpx;
		padding-bottom: 210rpx;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		border-bottom: #000000 6rpx solid;
	}
     
	.medicineArea{
		margin-top: 20rpx;
		display: flex;
		flex-direction: column;
		width: 100%;
		/* background-color: #19BE6B; */
		padding-left: 20rpx;
	}
	
	.medicine{
		width: 100%;
		display: flex;
		flex-direction: row;
		align-items: center;
		justify-content: space-between;
		margin-top: 20rpx;
	}
    
	.medicineInfo{
		color: #8c8c8c;
	}
	
	.cost{
		display: flex;
		flex-direction: row;
		margin-top: 20rpx;
		width: 100%;
		justify-content: flex-end;
	}
    
	.doctorArea{
		margin-top: 40rpx;
		width: 100%;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: flex-start;
		font-weight: 530;
		/* background-color: #71D5A1; */
		padding-right: 30rpx;
		padding-left: 10rpx ;
		font-size: 110%;
	}
	
	.doctor{
		display: flex;
		flex-direction: column;
	}
	.doctor view{
		margin-top: 7rpx;
	}
     
	 
	.tip{
		color: #cbcbcb;
		width: 100%;
		margin-top: 50rpx;
		font-size: 80%;
		text-align: center;
	}
</style>
