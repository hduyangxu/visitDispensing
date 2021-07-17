<template>
   	<view class="wrap">
   		<view class="cardTop">
			<u-cell-item :value="status==0?'待完成':'已完成'" :arrow="false" :value-style="valueStyle">
				<view slot="title" style="display: flex; flex-direction: row;">
					<view style="color: #949494;">问诊时间：</view>
					<view>{{time}}</view>
				</view>
			</u-cell-item>
		</view>
		<view class="cardMiddle">
			<view style="display: flex; align-items: center; justify-content: center;">
			    <u-avatar :src="src" mode="circle" size="115" style="margin-left: 20rpx;"></u-avatar>
			</view>
			<view class="middleColumn">
				<view style="display: flex;flex-direction: row; line-height: 40rpx;">
					<view style="font-size: 125%;margin-right: 20rpx;font-weight: 550; color: #000000;">{{doctorName}}</view>
					<view>在线云诊室</view>
				</view>
				<view>就诊人:&nbsp;&nbsp;{{patienceName}}</view>
				<view>病情&nbsp;&nbsp;{{sickStatus}}</view>
			</view>
		</view>
		<view class="cardBottom">
			<view style="display: flex; flex-direction: row; line-height: 50rpx;">
				<view style="margin-left: 10rpx; margin-right: 10rpx; margin-top: 6rpx;">
					<u-icon size="32" name="http://yuan619.xyz/vd/medicine.png"></u-icon>
				</view>
				<view style="font-size: 110%;">
					复诊配药
				</view>
			</view>
			<view class="button" v-show="status==1" @click="toPres">
				查看处方
			</view>
		</view>
   	</view>
   </template>
   <script>
   	export default {
   		data() {
   			return {
				valueStyle:{
					"color":'#f7aa47',
					"font-weight": "bold"
				}
   			}
   		},
		methods: {
			toPres(){
				let _this = this
				uni.setStorage({
					key: 'consultId',
					data: _this.consultId,
					success: function() {
						console.log('consultId为'+_this.consultId)
					}
				});
				uni.navigateTo({
					url: '../pages/pres/pres'
				})
			}

		},
		props: {
		    time: {
				type: String,
				default:'2021-05-24 11:26'
			},
			status:{
				type: Number,
				default:0,
			},
		    doctorName:{
				type: String,
				default:'朱自强'
			},
		    patienceName:{
				type: String,
				default:'张伟'
			},
		    sickStatus:{
				type: String,
				default:'333333333'
			},
			consultId:{
				type:Number,
				required:true
			},
			src:{
				type:String,
				default:'http://yuan619.xyz/vd/%E5%8C%BB%E7%94%9F.jpg'
			}
		  },
   	}
   </script>
   <style lang="scss">
   	.wrap {
   		display: flex;
		flex-direction: column;
		width: 100%;
		padding: 0rpx 20rpx 20rpx 20rpx;
		background-color: #ffffff;
		margin-top: 5rpx;
		color: #7e7e7e;
   	}
	.cardMiddle{
		display: flex;
		flex-direction: row;
		padding: 30rpx 0rpx 30rpx 0rpx;
		height: 200rpx;
		border-bottom: 1rpx solid #f3f4f7;
	}
	.middleColumn{
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		margin-left: 20rpx;
	}
	.cardBottom{
		color: #b3b3b3;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		margin-top: 25rpx;
		height: 50rpx;
	}
	.button{
		color: #52c5ae;
		height: 100%;
		border-radius: 10rpx;
		padding: 0rpx 10rpx 0rpx 10rpx;
		font-weight: 600;
		border: 4rpx #52c5ae solid;
	}
	
   </style>
   
