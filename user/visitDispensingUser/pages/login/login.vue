<template>
	<view>
		<view class="container">
			<view class="iconAndTitle">
				<view style="text-align: center;">
					<!-- <image src="../../static/icon/hospital.png"></image> -->
					<u-avatar :src="src" size="500"></u-avatar>
				</view>
				<view class="title">
					<view style="margin-top: 10rpx; margin-right: 10rpx;"><u-icon name="http://yuan619.xyz/vd/%E9%A6%96%E9%A1%B5.png" :size="40"></u-icon></view>
					<view>慧康医院</view>
					</view>
				
			</view>
			<u-toast ref="uToast" />
			<view class="cu-load load-modal" v-if="loadModal">
				<!-- <view class="cuIcon-emojifill text-orange"></view> -->
				<image src="http://yuan619.xyz/vd/load.gif" mode="aspectFit"></image>
				<view class="gray-text">请稍后</view>
			</view>
			<view class="login">
				<view class="button" type="primary" @click="getUserInfo">
					<view style="padding-top: 7rpx;">
						<image mode="aspectFit" style="width: 40rpx; height: 40rpx; margin-right: 10rpx;"
							src="../../static/icon/weixin.png">
					</view>
					</image>微信授权登录
				</view>
			</view>

		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				loadModal: false,
				src:"../../static/icon/hospital.png"

			}
		},
		methods: {
			showToast1() {
				this.$refs.uToast.show({
					title: '登录成功',
					type: 'success',
					url: 'pages/main/main',
					duration:1000
				})
			},
			showToast2() {
				this.$refs.uToast.show({
					title: '连接超时',
					type: 'error',
					duration:1000
				})
			},
			getUserInfo() {
				let _this = this
				_this.loadModal = true
				uni.login({
					provider: 'weixin',
					success: function(loginRes) {
						// 获取用户信息
						uni.getUserInfo({
							provider: 'weixin',
							success: function(infoRes) {
								uni.request({
									url: 'http://47.111.10.102:8886/user/add', //仅为示例，并非真实接口地址。
									header: {
										'Content-Type': 'application/x-www-form-urlencoded'
									},
									data: {
										"open_id": infoRes.userInfo.openId
									},
									method: "POST",
									success: (res) => {
										_this.loadModal = false
										if (res.data.code != '200') {
											_this.showToast2()
										} else {
											uni.setStorage({
												key: 'userId',
												data: res.data.data[0].id,
												success: function() {
													console.log('userId为'+res.data.data[0].id)
												}
											});
											_this.showToast1()
										}
									}
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

	body {
		background-color: #ffffff;
		height: 100vh;
		width: 750rpx;
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
		margin-top: 30rpx;
		height: 50rpx;
		text-align: center;
		display: flex;
		flex-direction: row;
		align-items: center;
		justify-content: center;
		font-size: 130%;
		font-weight: 550;
		color: #666666;
	}

	.login {
		margin-top: 50px;
	}

	.button {
		display: flex;
		flex-direction: row;
		width: 600rpx;
		height: 100rpx;
		background-color: #0ab906;
		position: relative;
		margin-left: auto;
		margin-right: auto;
		font-size: 18px;
		align-content: center;
		justify-content: center;
		line-height: 100rpx;
		border-radius: 100rpx;
		-webkit-tap-highlight-color: transparent;
		overflow: hidden;
		color: #fff;
	}
</style>
