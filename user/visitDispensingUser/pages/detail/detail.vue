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
							border-color="#eeb57f" style="margin-top: 10rpx;" />
					</view>
				</view>
				<view>
					{{doctorSubject}}
				</view>
			</view>
			<view class="changeDoctor">
				<view style="color: #dedede;" @click="changeDoctor">更换医生 <u-icon name="arrow-right"
						style="margin-left: 10rpx;"></u-icon>
				</view>
			</view>
		</view>
		<view class="wrap">
			<u-form ref="uForm" :border-bottom="false">
				<u-form-item label="问诊人" label-width="auto" :required='required' :border-bottom="false">
					<u-input inputAlign="right" :disabled="true" v-model="patienceInfo" placeholder="点击下方选择信息" />
				</u-form-item>
				<u-cell-item icon="account" title="填写您的身份信息" :arrow="true" arrow-direction="right" @click="toInfo">
				</u-cell-item>
				<u-form-item label="确诊诊断" label-width="auto" :required='required'>
					<u-select v-model="show" :list="sickList" @confirm="confirm"></u-select>
					<u-input inputAlign="right" :disabled="true" @click="show=true" v-model="form.diag"
						placeholder="选择病症" />
				</u-form-item>
				<view class="medicine">
					<view>
						<u-form-item label="所需药品" label-width="auto" :required='required' :border-bottom="false">
							<u-cell-item value="添加药品" :arrow="true" arrow-direction="right" :border-bottom="false"
								@click="selectMedicine">
							</u-cell-item>
						</u-form-item>
					</view>
					<view class="medicineList">
						<u-tag style="margin: 10rpx;" v-for="(item,index) in medicineList" :key="index"
							:text="item.name" mode="plain" closeable bg-color="#e5f7f1" color="#82bca4"
							close-color="red" border-color="#e5f7f1" @close="removeFromMedcineList(index)" />
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
				<u-input v-model="form.des" type="textarea" :autoHeight="true" />
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
					<u-upload width="180" height="180" ref="uUpload" :action="action" @on-uploaded="handleUpload()"
						@on-choose-complete="handleProgress()"></u-upload>
				</view>
				<view style="color: #b2b2b2; font-size: 90%; margin-top: 30rpx;">
					<text space="emsp">
						{{text}}
					</text>
				</view>
			</view>
		</view>
		<view class="submit">
			<view class="button" type="primary" @click="submit">
				提交
			</view>
		</view>
		<view>
			<u-toast ref="uToast" />
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					age: '',
					des: '',
					diag: '',
					doc_id: '',
					drug_ids: '',
					gender: '',
					id_number: '',
					name: '',
					phone: '',
					pics: 'none',
					user_id: ''
				},
				required: true,
				False: false,
				uploadSuccess: true,
				openId: '',
				src: 'http://yuan619.xyz/vd/%E5%8C%BB%E7%94%9F.jpg',
				doctorName: '请选择',
				doctorLevel: '请选择',
				doctorSubject: '',
				sickness: '',
				patienceInfo: '',
				medicineList: [],
				imgList: '',
				text: '  请上传病情照片、化验单、检查资料、报告单、药品处方单，若为皮肤问题，建议对准患处拍摄。照片仅自己和医生可见',
				describe: '从昨天晚上开始腹泻，头晕眼花，伴有呕吐症状，体温39°C',
				show: false,
				sickList: [{
						value: '1',
						label: '霍乱'
					},
					{
						value: '2',
						label: '感冒'
					}
				],
				action: 'http://47.111.10.102:8886/qiniu/image'
			}
		},
		methods: {
			getUserId() {
				let _this = this;
				uni.getStorage({
					key: 'userId',
					success: function(res) {
						console.log(res)
						_this.form.user_id = res.data
					}
				});
			},
			removeFromMedcineList(index) {
				this.medicineList.splice(index, 1)
			},
			confirm(e) {
				this.form.diag = e[0].label
			},
			toInfo() {
				uni.navigateTo({
					url: '../patienceInfo/patienceInfo'
				});
			},
			uploadDetail() {

			},
			changeDoctor() {
				uni.navigateTo({
					url: '../selectDoctor/selectDoctor'
				});
			},
			showToast() {
				this.$refs.uToast.show({
					title: '请等待图片上传',
					type: 'error'
				})
			},
			showToast01() {
				this.$refs.uToast.show({
					title: '未选择医生',
					type: 'error'
				})
			},
			showToast02() {
				this.$refs.uToast.show({
					title: '病症未选择',
					type: 'error'
				})
			},
			showToast03() {
				this.$refs.uToast.show({
					title: '药品未选择',
					type: 'error'
				})
			},
			showToast04() {
				this.$refs.uToast.show({
					title: '未描述病情',
					type: 'error'
				})
			},
			showToast05() {
				this.$refs.uToast.show({
					title: '请上传病情照片',
					type: 'error'
				})
			},
			showToast06() {
				this.$refs.uToast.show({
					title: '身份信息未填写',
					type: 'error'
				})
			},
			showToast2() {
				this.$refs.uToast.show({
					title: '提交成功',
					type: 'success',
					url: 'pages/main/main',
					duration: 1000
				})
			},
			selectMedicine() {
				uni.navigateTo({
					url: '../addMedicine/addMedicine'
				});
			},
			handleUpload() {
				console.log('图片上传成功')
				this.uploadSuccess = true;
			},
			handleProgress() {
				console.log('图片上传中')
				this.uploadSuccess = false;
			},
			submit() {
				if (!this.uploadSuccess) {
					this.showToast()
					return;
				}
				if (this.form.doc_id == '') {
					this.showToast01()
					return;
				}
				if (this.patienceInfo == '') {
					this.showToast06()
					return;
				}
				if (this.medicineList.length == 0) {
					this.showToast03()
					return;
				}
				if (this.form.diag == '') {
					this.showToast02()
					return;
				}
				if (this.form.des == '') {
					this.showToast04()
					return;
				}
				let files = [];
				let _this = this;
				// this.$refs.uUpload.upload();
				files = _this.$refs.uUpload.lists.filter(val => {
					return val.progress == 100;
				})
				if (files.length != 0) {
					_this.form.pics = '';
				}
				for (let i = 0; i < files.length; i++) {
					if (i != 0) {
						_this.form.pics += ','
					}
					console.log(files[i].response.data)
					_this.form.pics += files[i].response.data;
				}
				for (let i = 0; i < _this.medicineList.length; i++) {
					if (i != 0) {
						_this.form.drug_ids += ','
					}
					_this.form.drug_ids += _this.medicineList[i].drug_id;
				}
				if (_this.form.pics == "none") {
					this.showToast05()
					return;
				}
				// console.log(_this.form)
				uni.request({
					url: 'http://47.111.10.102:8886/consult/add',
					header: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					data: _this.form,
					method: "POST",
					success: (res) => {
						_this.showToast2()
					}
				});
			}
		},
		mounted() {
			this.getUserId();
		},
		onShow() {
			console.log("docId为" + this.form.doc_id)
		}

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
		border-radius: 10rpx;
	}
</style>
