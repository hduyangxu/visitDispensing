<template>
	<view>
		<view class="wrap">
			<view>
				<u-toast ref="uToast" />
			</view>
			<view class="bar">
				<view class="barItem">
					<image src="http://yuan619.xyz/vd/yi.png"></image>
					<view style="font-size:110%;font-weight: 550;">快速问诊</view>
					<view style="font-size:85%; color: #9e9e9e;">医生全天在线</view>
				</view>
				<view class="barItem" @click="toDetail()">
					<image src="http://yuan619.xyz/vd/sheng.png"></image>
					<view style="font-size:110%;font-weight: 550;">复诊配药</view>
					<view style="font-size:85%; color: #9e9e9e;">线上快捷配药</view>
				</view>
				<view class="barItem" @click="toRecord()">
					<image src="http://yuan619.xyz/vd/jie.png"></image>
					<view style="font-size:110%;font-weight: 550;">配药记录</view>
					<view style="font-size:85%; color: #9e9e9e;">快速查看处方</view>
				</view>
			</view>
			<view class="module">
				<u-grid :col="4" :border="false">
					<u-grid-item>
						<u-icon name="http://yuan619.xyz/vd/1%20%281%29.png" :size="80"></u-icon>
						<view class="grid-text">名医义诊</view>
					</u-grid-item>
					<u-grid-item>
						<u-icon name="http://yuan619.xyz/vd/1%20%282%29.png" :size="80"></u-icon>
						<view class="grid-text">药剂配取</view>
					</u-grid-item>
					<u-grid-item>
						<u-icon name="http://yuan619.xyz/vd/1%20%283%29.png" :size="80"></u-icon>
						<view class="grid-text">医疗工具</view>
					</u-grid-item>
					<u-grid-item>
						<u-icon name="http://yuan619.xyz/vd/1%20%284%29.png" :size="80"></u-icon>
						<view class="grid-text">电话急诊</view>
					</u-grid-item>
				</u-grid>
				<u-grid :col="4" :border="false">
					<u-grid-item>
						<u-icon name="http://yuan619.xyz/vd/1%20%285%29.png" :size="80"></u-icon>
						<view class="grid-text">手术查询</view>
					</u-grid-item>
					<u-grid-item>
						<u-icon name="http://yuan619.xyz/vd/1%20%286%29.png" :size="80"></u-icon>
						<view class="grid-text">外用药品</view>
					</u-grid-item>
					<u-grid-item>
						<u-icon name="http://yuan619.xyz/vd/1%20%287%29.png" :size="80"></u-icon>
						<view class="grid-text">温度测量</view>
					</u-grid-item>
					<u-grid-item>
						<u-icon name="http://yuan619.xyz/vd/1%20%288%29.png" :size="80"></u-icon>
						<view class="grid-text">医疗用具</view>
					</u-grid-item>
				</u-grid>
			</view>
<!-- 			<view class="toutiao">
				<image src="http://yuan619.xyz/toutiao1.png" mode="aspectFit"></image>
			</view> -->
		</view>
		<u-tabbar v-model="current" height="55px" :list="list" :mid-button="true" :before-switch="onlyMain"
			active-color="#54d882" inactive-color="#c0c0c0"></u-tabbar>
	</view>

</template>

<script>
	export default {
		data() {
			return {
				list: [{
						iconPath: "http://yuan619.xyz/vd/%E9%A6%96%E9%A1%B5.png",
						selectedIconPath: "http://yuan619.xyz/vd/%E9%A6%96%E9%A1%B5.png",
						text: '首页',
						customIcon: false,
					},
					{
						iconPath: "http://yuan619.xyz/vd/%E8%8D%AF%E5%93%81.png",
						text: '药品',
						customIcon: false,
					},
					{
						iconPath: "http://yuan619.xyz/vd/%E9%97%AE%E8%AF%8A2.png",
						selectedIconPath: "http://yuan619.xyz/vd/%E9%97%AE%E8%AF%8A2.png",
						text: '问诊',
						midButton: true,
						customIcon: false,
					},
					{
						iconPath: "http://yuan619.xyz/vd/%E7%96%AB%E8%8B%97.png",
						text: '疫苗',
						customIcon: false,
					},
					{
						iconPath: "http://yuan619.xyz/vd/%E6%88%91%E7%9A%84.png",
						text: '我的',
						isDot: false,
						customIcon: false,
					},
				],
				current: 0,
			}
		},
		methods: {
			toDetail() {
				uni.navigateTo({
					url: '../detail/detail'
				})
			},
			toRecord() {
				uni.navigateTo({
					url: '../record/record'
				})
			},
			onlyMain(index) {
				if (index == 0) return true;
				else {
					this.showToast()
					return false;
				}
			},
			showToast() {
				this.$refs.uToast.show({
					title: '功能待开发',
					type: 'warning',
				})
			}

		}
	}
</script>

<style>
	.wrap {
		width: 750rpx;
		background-color: #ffffff;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		background-image: url('http://yuan619.xyz/%E8%83%8C%E6%99%AF1.png');
		background-repeat: no-repeat;
		background-size: 750rpx;
	}

	.grid-text {
		margin-top: 5rpx;
		color: #838383;
	}

	.bar {
		height: 250rpx;
		width: 700rpx;
		display: flex;
		flex-direction: row;
		background-color: #ffffff;
		border-radius: 10rpx;
		margin-top: 420rpx;
		box-shadow: 15rpx 15rpx 10rpx #eff1f3, -15rpx 0rpx 10rpx #eff1f3;
	}

	.barItem {
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 250rpx;
		height: 100%;
		justify-content: center;
	}

/* 	.toutiao {
		background-color: #ffffff;
		display: flex;
		width: 100%;
		height: 120rpx;
		justify-content: center;
		align-items: center;
		margin-top: 20rpx;
	} */

	.barItem view {
		margin-bottom: 10rpx;
	}

	.bar view image {
		height: 120rpx;
		margin-bottom: 15rpx;
		width: 120rpx;
	}

	.button1 {
		width: 350rpx;
		height: 350rpx;
		line-height: 350rpx;
		text-align: center;
		background-color: #18B566;
		margin: 100rpx;
		border-radius: 20rpx;
	}

	.button2 {
		width: 350rpx;
		height: 350rpx;
		line-height: 350rpx;
		text-align: center;
		background-color: #0081FF;
		margin: 100rpx;
		border-radius: 20rpx;
	}

	.module {
		margin-top: 60rpx;
		/* height: rpx; */
		width: 100%;
		/* background-color: #19BE6B; */
	}
</style>
