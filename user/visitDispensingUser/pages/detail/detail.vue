<template>
	<view>
		<view class="docInfo">
			<u-avatar :src="src" mode="circle" size="150" style="margin-left: 30rpx;"></u-avatar>
			<view class="doctorNameColumn">
				<view class="nameAndLevel">
					<view style="font-size: 130%; font-weight: bold;">
						{{doctorName}}
					</view>
					<view style="margin-left: 8rpx;">
						<u-tag :text="doctorLevel" mode="plain" size="mini" shape="circle" color="#eeb57f"
							border-color="#eeb57f" style="margin-top: 10rpx;"/>
					</view>
				</view>
				<view>
					{{doctorSubject}}
				</view>
			</view>
			<view class="changeDoctor">
				<view style="color: #dedede;">更换医生 <u-icon name="arrow-right" style="margin-left: 10rpx;"></u-icon>
				</view>
			</view> 
		</view>
		<view class="wrap">
			<u-form ref="uForm" :border-bottom="false">
				<u-form-item label="问诊人" label-width="auto" :required='required' :border-bottom="false">
					<u-input inputAlign="right" :disabled="true" v-model="patienceInfo" placeholder="点击下方选择信息" />
				</u-form-item>
				<u-cell-item icon="account" title="填写您的身份信息" :arrow="true" arrow-direction="right" @click="toInfo"></u-cell-item>
				<u-form-item label="确诊诊断" label-width="auto" :required='required'>
					<u-select v-model="show" :list="sickList" @confirm="confirm"></u-select>
					<u-input inputAlign="right" :disabled="true" @click="show=true" v-model="sickness" placeholder="选择病症" />
				</u-form-item>
				<view class="medicine">
					<view>
						<u-form-item label="所需药品" label-width="auto" :required='required' :border-bottom="false">
							<u-cell-item value="添加药品" :arrow="true" arrow-direction="right" :border-bottom="false">
							</u-cell-item>
						</u-form-item>
					</view>
					<view class="medicineList">
						<u-tag style="margin: 10rpx;" v-for="(item,index) in medicineList" :key="index" :text="item" mode="plain"
							closeable bg-color="#e5f7f1" color="#82bca4" close-color="red" border-color="#e5f7f1"
							@close="removeFromMedcineList" />
					</view>
				</view>

			</u-form>

		</view>
		<view class="describe">
			<view style="display: flex; flex-direction: row;"> 
				<view style="height: 40rpx; width: 10rpx; background-color: #44b878; border-radius: 10rpx;"></view>
				<view style="color: red; margin-left: 20rpx;">*</view>
				<view>病情描述</view>
			</view>
			<view
				style="margin-left: 43rpx; margin-top: 15rpx; padding: 30rpx 0rpx 30rpx 0rpx; border-top: solid #f3f4f7 1rpx;">
				<u-input v-model="describe" type="textarea" :autoHeight="true" />
			</view>
		</view>
		<view class="describe">
			<view style="display: flex; flex-direction: row;">
				<view style="height: 40rpx; width: 10rpx; background-color: #44b878; border-radius: 10rpx;"></view>
				<view style="color: red; margin-left: 20rpx;"></view>
				<view>病情照片</view>
			</view>
			<view
				style="display: flex; flex-direction: column; margin-left: 43rpx; margin-top: 20rpx; padding: 30rpx 0rpx 30rpx 0rpx; border-top: solid #f3f4f7 1rpx;">
				<view>
					<u-upload width="160" height="160"></u-upload>
				</view>
				<view style="color: #b2b2b2; font-size: 90%; margin-top: 30rpx;">
					<text space="emsp">
						{{text}}
					</text>
				</view>
			</view>
		</view>
		<view class="submit">
			<view class="button" type="primary" @click="uploadDetail">
				提交
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				required:true,
				False:false,
				openId: '',
				src: 'http://yuan619.xyz/vd/%E5%8C%BB%E7%94%9F.jpg',
				doctorName: '朱自强',
				doctorLevel: '实习医生',
				doctorSubject: '呼吸内科',
				sickness:'',
				form: {},
				patienceInfo: '',
				medicineList: ['111', '222'],
				text: '  请上传病情照片、化验单、检查资料、报告单、药品处方单，若为皮肤问题，建议对准患处拍摄。照片仅自己和医生可见',
				describe: '从昨天晚上开始腹泻，头晕眼花，伴有呕吐症状，体温39°C',
				show: false,
				sickList: [
					{
						value: '1',
						label: '霍乱'
					},
					{
						value: '2',
						label: '感冒'
					}
				],
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
			},
			removeFromMedcineList(index) {
				this.medicineList.splice(index, 1)
			},
			confirm(e){
				this.sickness=e[0].label
			},
			toInfo(){
				uni.navigateTo({
					url: '../patienceInfo/patienceInfo'
				});
			},
			uploadDetail(){
				
			}
		},
		mounted() {
			this.getOpenId();
		},
	
	}
</script>

<style lang="scss">
	body {
		background-color: #f2f2f2;
	}

	.docInfo {
		margin-top: 10rpx;
		height: 200rpx;
		width: 750rpx;
		background-color: #FFFFFF;
		display: flex;
		flex-direction: row;
		align-items: center;
	}

	.doctorNameColumn {
		height: 50%;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		margin-left: 20rpx;
	}

	.nameAndLevel {
		display: flex;
		flex-direction: row;
	}

	.changeDoctor {
		width: 40%;
		display: flex;
		justify-content: flex-end;
	}

	.wrap {
		padding: 30rpx;
		margin-top: 10rpx;
		background-color: #FFFFFF;
	}

	.medicine {
		display: flex;
		flex-direction: column;
	}

	.medicineList {
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
	}

	.describe {
		margin-top: 20rpx;
		background-color: #FFFFFF;
		padding: 30rpx 45rpx 30rpx 3rpx;
	}

	.submit {
		margin-top: 20rpx;
		margin-bottom: 10rpx;
	}

	.button {
		width: 720rpx;
		height: 90rpx;
		background-color: #2abd6c;
		position: relative;
		margin-left: auto;
		margin-right: auto;
		font-size: 18px;
		text-align: center;
		line-height: 100rpx;
		-webkit-tap-highlight-color: transparent;
		overflow: hidden;
		color: #fff;
	}
</style>
