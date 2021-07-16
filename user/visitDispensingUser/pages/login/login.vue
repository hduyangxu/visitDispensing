<template>
	<view>
		<view class="container">
			<view class="iconAndTitle">
				<view style="text-align: center;">
					<image src="../../static/icon/hospital.png"></image>
				</view>
				<view class="title">爱心医院</view>
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
									url: 'http://172.20.10.8:8886/user/add', //仅为示例，并非真实接口地址。
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
												data: res.data.data.id,
												success: function() {
													console.log('已存储userId');
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
