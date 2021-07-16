<template>
	<view>
		<view class="search">
			<u-search placeholder="搜索药品" input-align="center" v-model="keyword" shape="square" :show-action="false">
			</u-search>
		</view>
		<view class="searchNum">
			搜索结果({{searchNum}}条)
		</view>
		<view>

		</view>
		<view class="cu-load load-modal" v-if="loadModal">
			<!-- <view class="cuIcon-emojifill text-orange"></view> -->
			<image src="http://yuan619.xyz/vd/load.gif" mode="aspectFit"></image>
			<view class="gray-text">加载中...</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				loadModal: false,
				keyword: '',
				searchNum: 20,
				allMedicine: [],
				partMedicine: []
			}
		},
		methods: {
			getInfo() {
				let _this = this;
				_this.loadModal = true;
				uni.request({
					url: 'http://172.20.10.8:8886/drug/findAll', //仅为示例，并非真实接口地址。
					success: (res) => {
						console.log(res.data);
						_this.loadModal = false
					}
				});
			},

		},
		mounted() {
			getInfo();
		}
	}
</script>

<style>
	.search {
		width: 750rpx;
		height: 90rpx;
		background-color: #ffffff;
		padding: 15rpx;
	}

	,
	.searchNum {
		
	}
</style>
