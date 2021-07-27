<template>
	<view class="wrap">
		<view class="cardMiddle">
			<view style="display: flex; align-items: center; justify-content: center;">
				<u-avatar :src="src" mode="circle" size="115" style="margin-left: 20rpx;"></u-avatar>
			</view>
			<view class="middleColumn">
				<view style="display: flex;flex-direction: row; line-height: 40rpx;">
					<view style="font-size: 125%;margin-right: 20rpx;font-weight: 550; color: #000000;">{{name}}</view>
					<view style="margin-bottom: 5rpx;">
						<u-tag :text="level" mode="plain" size="mini" shape="circle" color="#eeb57f"
							border-color="#eeb57f" />
					</view>
				</view>
				<view>所属医院:&nbsp;&nbsp;{{org}}</view>
				<view>医生科室:&nbsp;&nbsp;{{dept}}</view>
			</view>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				valueStyle: {
					"color": '#f7aa47',
					"font-weight": "bold"
				}
			}
		},
		methods: {
			toPres() {
				let _this = this
				uni.setStorage({
					key: 'consultId',
					data: _this.consultId,
					success: function() {
						console.log('consultId为' + _this.consultId)
					}
				});
				uni.setStorage({
					key: 'patienceInfo',
					data: _this.patienceInfo,
					success: function() {
						console.log("病人信息已存储")
						uni.navigateTo({
							url: '../pres/pres'
						})
					}
				});
			}

		},
		props: {
			id: {
				type: Number,
				default: 4
			},
			level: {
				type: String,
				default: "实习医生",
			},
			name: {
				type: String,
				default: '朱自强'
			},
			dept: {
				type: String,
				default: '呼吸内科'
			},
			org: {
				type: String,
				default: '爱心医院'
			},
			src: {
				type: String,
				default: "http://yuan619.xyz/vd/%E5%8C%BB%E7%94%9F.jpg"
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
		margin-top: 10rpx;
		color: #7e7e7e;
	}

	.cardMiddle {
		display: flex;
		flex-direction: row;
		height: 200rpx;
		border-bottom: 1rpx solid #f3f4f7;
	}

	.middleColumn {
		display: flex;
		flex-direction: column;
		justify-content: center;
		margin-left: 20rpx;
	}
</style>
