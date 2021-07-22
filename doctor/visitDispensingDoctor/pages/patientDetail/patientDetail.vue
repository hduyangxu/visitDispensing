<template>
	<view>
		<view class="part1">
			<view style="width: 20%; margin-left: 4%; color: #999999;">申请时间 :</view>
			<view style="width: 61%;">{{date}}</view>
			<view style="width: 15%; color: #ff9900; font-weight: 600;">{{state.info}}</view>
		</view>
		<view class="part2">
			<view style="width: 20%; margin-left: 4%; color: #999999;">问诊认 :</view>
			<view style="width: 70%; text-align: right;">{{pacientInfo}}</view>
		</view>
		<view class="part3">
			<view style="width: 20%; margin-left: 4%; color: #999999; height: 80rpx;">所需药品</view>
			<view style="width: 92%; margin-left: 4%; display: flex; flex-direction: row;  flex-wrap: wrap">
				<view style="border: 2rpx solid #1ab394; line-height: 40rpx; 
				border-radius: 20rpx; color: #1ab394; font-style:italic;
				margin-right: 10rpx; margin-bottom: 10rpx;" v-for="(item,index) in medList">
					<p style="margin: 0rpx 15rpx 0rpx 15rpx;">{{item}}</p>
				</view>
			</view>
		</view>
		<view class="part4">
			<view style="width: 20%; margin-left: 4%; color: #999999;">历史诊断</view>
			<view style="width: 70%; text-align: right;">{{illness}}</view>
		</view>
		<view class="part5">
			<view style="width: 20%; margin-left: 4%; color: #999999; height: 80rpx;">病情描述 :</view>
			<view
				style="width: 92%; margin-left: 4%; line-height: 50rpx; display: flex; flex-direction: row;  flex-wrap: wrap">
				<view style=" margin-bottom: 20rpx ;">{{des}}</view>
			</view>
		</view>
		<view class="part6">
			<view style="width: 20%; margin-left: 4%; color: #999999; height: 80rpx;">病情图片</view>
			<view style="width: 92%; margin-left: 4%; display: flex; flex-direction: row;  flex-wrap: wrap">
				<view v-for="(item,index) in src" style="width: 30%; height: 200rpx; 
				margin-left: 3%; margin-bottom: 40rpx;">
					<u-image width="100%" height="200rpx" :src="src[index]" @tap="_previewImage(src[index])"
						mode="aspectFill">
					</u-image>
				</view>
			</view>
		</view>
		<view class="part7">
			<view class="dark" v-show="state.value != 1" @click="recipeChenge">处方</view>
			<view class="dark" v-show="state.value == 1" @click="recipeCheck">查看处方</view>
			<view class="light" v-show="state.value != 1" @click="finish">完成接诊</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				consult: {},
				pacientId: '',
				state: {
					value: '',
					info: ''
				},
				date: '',
				pacientInfo: '',
				medList: [],
				illness: '',
				des: '',
				src: [

				]
			}
		},
		methods: {
			_previewImage(image) {
				var imgArr = [];
				imgArr.push(image);
				//预览图片
				uni.previewImage({
					urls: imgArr,
					current: imgArr[0]
				});
			},
			recipeChenge() {
				uni.navigateTo({
					url: '../recipe/recipe'
				})
			},
			recipeCheck() {

			},
			finish() {
				let _this = this;
				uni.request({
					url: 'http://47.111.10.102:8886/consult/finish',
					data: {
						id: _this.pacientId
					},
					header: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					method:'POST',
					success: (res) => {
						console.log(res)
						uni.navigateTo({
							url: '../record/record'
						})
					}
				});
			},
			init() {
				let _this = this;
				uni.getStorage({
					key: 'consult',
					success: function(res) {
						_this.consult = res.data;

						_this.pacientId = _this.consult.id;
						console.log(_this.pacientId);

						_this.medList = _this.consult.drugs.split('、');
						//console.log(_this.consult.gender);

						let sex = _this.consult.gender == 1 ? '男' : '女';
						_this.pacientInfo = _this.consult.name + '  ' + sex + '  ' + _this.consult.age + '岁';

						_this.date = _this.consult.createTime;

						_this.illness = _this.consult.diag;

						_this.des = _this.consult.des;

						_this.src = _this.consult.pics.split(',');

						_this.state.value = _this.consult.status;
						_this.state.info = _this.consult.status == 1 ? '已完成' : '未完成'
					}
				});
			}

		},
		mounted() {
			this.init();
		}
	}
</script>

<style lang="scss" scoped>
	.part1 {
		width: 100%;
		height: 80rpx;
		background: #ffffff;
		display: flex;
		line-height: 80rpx;
	}

	.part2 {
		width: 100%;
		height: 80rpx;
		background: #ffffff;
		display: flex;
		line-height: 80rpx;
		margin-top: 20rpx;
		border-bottom: 1rpx solid #dddddd;
	}

	.part3 {
		width: 100%;
		background: #ffffff;
		line-height: 80rpx;
	}

	.part4 {
		width: 100%;
		height: 80rpx;
		background: #ffffff;
		display: flex;
		line-height: 80rpx;
		margin-top: 20rpx;
		border-bottom: 1rpx solid #dddddd;
	}

	.part5 {
		width: 100%;
		background: #ffffff;
		line-height: 80rpx;
	}

	.part6 {
		margin-top: 20rpx;
		width: 100%;
		background: #ffffff;
		line-height: 80rpx;
	}

	.part7 {
		width: 100%;
		height: 120rpx;
		bottom: 0;
		position: fixed;
		display: flex;
		flex-direction: row;

		.light {
			height: 120rpx;
			float: left;
			text-align: center;
			line-height: 120rpx;
			background: #eeeeee;
			flex: 1;
		}

		.dark {
			height: 120rpx;
			float: right;
			text-align: center;
			line-height: 120rpx;
			background: #1ab394;
			color: #FFFFFF;
			flex: 1;
		}
	}
</style>
