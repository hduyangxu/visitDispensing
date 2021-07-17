<template>
	<view>
		<view class="wrap">
			<u-form :label-style="labelStyle">
				<u-form-item label="姓名" label-width="auto" :required="true">
					<u-input v-model="form.name" :border="true" type="text" border-color="#000000" placeholder="请填写" />
				</u-form-item>
				<u-form-item label="身份证号" label-width="auto" :required="true">
					<u-input v-model="form.id" :border="true" type="number" border-color="#000000" placeholder="请填写" />
				</u-form-item>
				<u-form-item label="性别" label-width="auto" :required="true">
					<u-input v-model="form.sex" type="select" :border="true" @click="showSex = true"
						border-color="#000000" placeholder="请选择" />
					<u-action-sheet :list="sexList" v-model="showSex" @click="actionSheetCallback"></u-action-sheet>
				</u-form-item>
				<u-form-item label="出生日期" label-width="auto" :required="true">
					<u-input v-model="form.birth" type="select" :border="true" @click="showDate=true"
						border-color="#000000" placeholder="请选择" />
					<u-calendar v-model="showDate" mode="date" @change="change"></u-calendar>
				</u-form-item>
				<u-form-item label="手机号" label-width="auto" :required="true">
					<u-input v-model="form.number" type="number" :border="true" border-color="#000000"
						placeholder="请填写" />
				</u-form-item>
			</u-form>
			<view class="submit">
				<view class="button" type="primary" @click="save">
					保存
				</view>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					sex: '',
					name: '',
					id: '',
					birth: '',
					age: '',
					number: '',
				},
				showSex: false,
				showDate: false,
				labelStyle: {
					"width": "130rpx",
					"display": "flex",
					"justify-content": "flex-end"
				},
				sexList: [{
						text: '男'
					},
					{
						text: '女'
					},
				],
			}
		},
		methods: {
			actionSheetCallback(index) {
				this.form.sex = this.sexList[index].text;
			},
			save() {
				let _this = this;
				uni.setStorage({
					key: 'patienceInfo',
					data: _this.form,
					success: function() {
						console.log('patienceInfo成功保存');
						var pages = getCurrentPages();
						var currPage = pages[pages.length - 1]; //当前页面
						var prevPage = pages[pages.length - 2]; //上一个页面
						prevPage.$vm.form.age=_this.form.age
						prevPage.$vm.form.gender=_this.form.sex == '男' ? 1 : 2
						prevPage.$vm.form.name=_this.form.name 
						prevPage.$vm.form.phone=_this.form.number 
						prevPage.$vm.form.id_number=_this.form.id 
						prevPage.$vm.patienceInfo=_this.form.name + " " + _this.form.sex + " " + _this.form.age + "岁"
						uni.navigateBack();
					}
				});
			},
			change(e) {
				this.form.birth = e.result;
				let nowDate = new Date();
				this.form.age = nowDate.getFullYear() - e.year + 1;
			},
			loadPatienceInfo() {
				let _this = this
				uni.getStorage({
					key: 'patienceInfo',
					success: function(res) {
						console.log("获取到缓存中的patienceInfo")
						_this.form = res.data
					}
				});
			}
		},
		mounted() {
			this.loadPatienceInfo()
		}
	}
</script>

<style>
	body {
		height: 100%;
		background-color: #ffffff;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	.wrap {
		padding: 80rpx;
	}

	.uForm {
		align-items: flex-end;
		justify-content: end;
	}

	.uForm u-form-item {
		width: 50%;
	}

	.submit {
		margin-top: 100rpx;
		margin-bottom: 10rpx;
	}

	.button {
		width: 600rpx;
		height: 90rpx;
		background-color: #169bd5;
		position: relative;
		margin-left: auto;
		margin-right: auto;
		font-size: 18px;
		text-align: center;
		line-height: 100rpx;
		border-radius: 20rpx;
		-webkit-tap-highlight-color: transparent;
		overflow: hidden;
		color: #fff;
	}
</style>
