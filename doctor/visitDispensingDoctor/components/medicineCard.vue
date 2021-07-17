<template>
   	<view class="wrap">
   		<view class="left">
			<view style="display: flex; flex-direction: row; line-height: 30rpx;" >
				{{drugName}}<u-icon name="info-circle-fill" color="#cccccc" size="28"></u-icon><text space="nbsp">{{dose}}</text>
			</view>
			<view>
				{{factorName}}
			</view>
		</view>
   		<view>
			{{unit}}
		</view>
   	</view>
   </template>
   <script>
   	export default {
   		data() {
   			return{
				
			}
   		},
		methods: {

		},
		props: {
		    unit: {
				type: String,
				default:'盒'
			},
			dose:{
				type: String,
				default:"  0.2g",
			},
		    drugName:{
				type: String,
				default:'肠炎宁片'
			},
		    factorName:{
				type: String,
				default:'江西康恩贝中药有限公司'
			}
		  },
   	}
   </script>
   <style lang="scss">
   	.wrap {
   		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		width: 750rpx;
		padding: 25rpx 30rpx 25rpx 30rpx;
		height: 130rpx;
		background-color: #ffffff;
		margin-bottom: 3rpx;
   	}
	.left{
		display: flex;
		flex-direction: column;
		height: 100%;
		justify-content: space-between;
		align-items: flex-start;
	}

	
   </style>
   
