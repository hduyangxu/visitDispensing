<template>
	<view class="wrap">
		<view class="button1" @click="toDetail">
			问诊配药
		</view>
		<view class="button2" @click="toRecord">
			查看记录
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			toDetail(){
				uni.navigateTo({
					url: '../detail/detail'
				})
			},
			toRecord(){
				uni.navigateTo({
					url: '../record/record'
				})
			}
			
		}
	}
</script>

<style>
.wrap{
	height:100vh;
	width: 750rpx;
	background-color: #ffffff;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.button1{
	width: 350rpx;
	height: 350rpx;
	line-height: 350rpx;
	text-align: center;
	background-color: #18B566;
	margin: 100rpx;
	border-radius: 20rpx;
}
.button2{
	width: 350rpx;
	height: 350rpx;
	line-height: 350rpx;
	text-align: center;
	background-color: #0081FF;
	margin: 100rpx;
	border-radius: 20rpx;
}
</style>
