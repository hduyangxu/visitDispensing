<template>
	<view>
		<view class="container">
			<view class="iconAndTitle">
				<view style="text-align: center;">
					<image src="../../static/icon/hospital.png"></image>
				</view>
				<view class="title">爱心医院</view>
			</view>
			<view class="login">
				<view class="button" type="primary" @click="getUserInfo">
					<image mode="aspectFit" style="width: 35rpx; height: 35rpx; margin-right: 10rpx; margin-top: 10px;"
						src="../../static/icon/weixin.png"></image>微信授权登录
				</view>
			</view>

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
			getUserInfo() {
				uni.login({
					provider: 'weixin',
					success: function(loginRes) {
						// 获取用户信息
						uni.getUserInfo({
							provider: 'weixin',
							success: function(infoRes) {
								uni.setStorage({
									key: 'openId',
									data: infoRes.userInfo.openId,
									success: function() {
										console.log('success');
									}
								});
								uni.navigateTo({
									url: '../detail/detail'
								});
							}
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss">
	image {
		width: 200px;
		height: 200px;
	}

	.container {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-content: center;
	}

	.iconAndTitle {
		margin: 30px;
	}

	.title {
		margin-top: 5px;
		text-align: center;
		font-size: 130%;
		color: #666666;
	}

	.login {
		margin-top: 50px;
	}

	.button {
		width: 600rpx;
		height: 100rpx;
		background-color: #0ab906;
		position: relative;
		margin-left: auto;
		margin-right: auto;
		font-size: 18px;
		text-align: center;
		line-height: 100rpx;
		border-radius: 100rpx;
		-webkit-tap-highlight-color: transparent;
		overflow: hidden;
		color: #fff;
	}
</style>
