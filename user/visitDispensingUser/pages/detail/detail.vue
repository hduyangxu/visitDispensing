<template>
	<view>
		<view class="docInfo">
			
				<u-avatar :src="src" mode="circle" size="175" style="margin-left: 30rpx;"></u-avatar>
			
			
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				openId: '',
				src:'http://yuan619.xyz/vd/%E5%8C%BB%E7%94%9F.jpg'
			}
		},
		methods: {
			getOpenId() {
				uni.getStorage({
					key: 'openId',
					success: function(res) {
						console.log(res.data);
					}
				});
			}
		},
		mounted() {
			this.getOpenId()
		}
	}
</script>

<style lang="scss">
	.docInfo{
		margin-top: 10rpx;
		height: 250rpx;
		width: 750rpx;
		background-color: #c8c9cc;
		display: flex;
		flex-direction: row;
		align-items: center;
	}

</style>
