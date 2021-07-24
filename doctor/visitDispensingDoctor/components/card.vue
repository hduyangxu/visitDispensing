<template>
	<view class="wrap">
		<view class="cardTop">
			<view>
				申请时间：{{time}}
			</view>
			<view class="valueStyle">
				{{status==0?'待完成':'已完成'}}
			</view>
		</view>
		<view class="cardMiddle">
			<view style="display: flex; align-items: center; justify-content: center;">
				<u-avatar :src="src" mode="circle" size="100"></u-avatar>
			</view>
			<view class="middleColumn">
				<view>
					<text space="nbsp">{{name+' '}}{{" "}}</text>{{sex==1?'男':'女'}}&nbsp;&nbsp;&nbsp;&nbsp;{{age}}岁
				</view>
				<view class="confineLine">
					药品需求:<text style="color: #000000;">{{' '}}{{drugs}}</text>
				</view>
			</view>
			<view style="display: flex; flex-direction: row; align-content:center; justify-content: center;">
				<u-icon name="arrow-right" size="40" color="#d3d3d3"></u-icon>
			</view>
		</view>
		<view class="cardBottom">
			<view class="button" v-show="status=='1'" @click="toPres">
				查看处方
			</view>
			<view class="button" v-show="status=='0'" @click="toDetail">
				完成接诊
			</view>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				src: 'http://yuan619.xyz/vd/29.png'
			}
		},
		methods: {
			toDetail() {
				let _this = this
				uni.setStorage({
					key: 'consult',
					data: _this.consult,
					success: function() {
						console.log('consult为' + _this.consult)
					}
				});
				uni.navigateTo({
					url: '../patientDetail/patientDetail'
				})
			},
			toPres(){
				let _this = this
				uni.setStorage({
					key: 'consultId',
					data: _this.consultId,
					success: function() {
						console.log('consultId为'+_this.consultId)
					}
				});
				uni.setStorage({
					key: 'patienceInfo',
					data: _this.consult,
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
			time: {
				type: String,
				default: '2021-05-24 11:26'
			},
			status: {
				type: String,
				default: '0',
			},
			name: {
				type: String,
				default: '谢健'
			},
			sex: {
				type: Number,
				default: 1
			},
			age: {
				type: Number,
				default: 21
			},
			consult: {
				type: Object,
				// required:true
			},
			drugs: {
				type: String,
				default: '大力丸、伸腿瞪眼丸、复方板蓝根颗粒、仙丹一味'
			},
			consultId:{
				type:Number,
				default:1
			}
		},
	}
</script>
<style lang="scss">
	.wrap {
		display: flex;
		flex-direction: column;
		width: 100%;
		padding: 20rpx 40rpx 20rpx 40rpx;
		height: 350rpx;
		background-color: #ffffff;
		margin-top: 10rpx;
		color: #7e7e7e;
	}

	.cardTop {
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		padding-bottom: 15rpx;
		border-bottom: 2rpx solid #e6e6e6;
	}

	.cardMiddle {
		display: flex;
		flex-direction: row;
		height: 200rpx;
		padding: 30rpx 0rpx 30rpx 0rpx;
		border-bottom: 1rpx solid #f3f4f7;
		overflow: hidden;
		text-overflow: ellipsis;
	}

	.middleColumn {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		padding: 13rpx 0rpx 13rpx 0rpx;
		width: 70%;
		margin-left: 30rpx;
	}

	.confineLine {
		colof: #999;
		overflow: hidden;
		word-break: break-all;
		/* break-all(允许在单词内换行。) */
		text-overflow: ellipsis;
		/* 超出部分省略号 */
		display: -webkit-box;
		/** 对象作为伸缩盒子模型显示 **/
		-webkit-box-orient: vertical;
		/** 设置或检索伸缩盒对象的子元素的排列方式 **/
		-webkit-line-clamp: 1;
		/** 显示的行数 **/
	}

	.cardBottom {
		color: #b3b3b3;
		display: flex;
		flex-direction: row;
		align-items: center;
		justify-content: flex-end;
		padding-top: 20rpx;
	}

	.button {
		color: #52c5ae;
		height: 100%;
		border-radius: 10rpx;
		padding: 0rpx 10rpx 0rpx 10rpx;
		font-weight: 500;
		border: 2rpx #52c5ae solid;
	}

	.valueStyle {
		color: #f7aa47;
		font-weight: bold;
	}
</style>
