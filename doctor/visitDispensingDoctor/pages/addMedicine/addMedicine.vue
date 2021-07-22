<template>
	<view>
		<view class="search">
			<u-search placeholder="搜索药品" input-align="center" v-model="keyword" shape="square" :show-action="false"
				@change="filterMedicine">
			</u-search>
		</view>
		<view class="searchNum">
			搜索结果({{searchNum}}条)
		</view>
		<view>
			<medicineCard v-for="(item,index) in partMedicine" :key="index" :drugName="item.drugName"
				:unit="item.packUnit" :dose="space+item.dose+item.doseUnit" :factorName="item.factorName" @click.native = "select(index)"></medicineCard>
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
				space:'  ',
				searchNum: 0,
				allMedicine: [],
				partMedicine: [],
				ctlIndex:''
			}
		},
		methods: {
			getInfo() {
				let _this = this;
				_this.loadModal = true;
				uni.request({
					url: 'http://47.111.10.102:8886/drug/findAll',
					success: (res) => {
						//console.log(res)
						_this.allMedicine = res.data.data;
						_this.partMedicine = res.data.data;
						_this.searchNum = res.data.data.length
						_this.loadModal = false
					}
				});
			},
			filterMedicine() {
				let _this = this
				let allList = _this.allMedicine;
				let partList = [];
				if (this.keyword == '') {
					partList = allList;
				} else {
					for (let i = 0; i < allList.length; i++) {
						if (allList[i].pinyinCode.indexOf(this.keyword) != -1 || allList[i].tradeName.indexOf(this
								.keyword) != -1) {
							partList.push(allList[i])
						}
					}
				}
				_this.partMedicine = partList;
				_this.searchNum = partList.length;
			},
			select(index){
				//console.log(this.partMedicine[index].drugName);
				let _this = this;
				uni.setStorage({
				    key: 'medDetail',
				    data: {
						part1:_this.partMedicine[index],
						part3:_this.ctlIndex
					},
				    success: function () {
				        console.log('success');
						uni.navigateTo({
							url: '../medCtl/medCtl'
						})
				    }
				});
			},
			init(){
				let _this = this;
				uni.getStorage({
				    key: 'medDetail',
				    success: function (res) {
				        console.log(res.data.part3);
						_this.ctlIndex = res.data.part3;
				    }
				});
			}
		},
		mounted() {
			this.getInfo();
			this.init();
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
		background-color: #f1f5f6;
		height: 68rpx;
		padding: 15rpx;
		display: flex;
		flex-direction: row;
		align-content: center;

	}
</style>
