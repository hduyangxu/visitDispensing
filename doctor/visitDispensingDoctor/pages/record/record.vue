<template>
	<view class="wrap">
		<view class="cu-load load-modal" v-if="loadModal">
			<!-- <view class="cuIcon-emojifill text-orange"></view> -->
			<image src="http://yuan619.xyz/vd/load.gif" mode="aspectFit"></image>
			<view class="gray-text">获取信息中</view>
		</view>
		<u-tabs-swiper ref="uTabs" :list="list" active-color="#87cbc3" inactive-color="#b0b0b0" :is-scroll="false"
			height="100" :bar-style="barStyle" :current="current" @change="tabsChange" bar-width="360">
		</u-tabs-swiper>
		<swiper :current="swiperCurrent" @transition="transition" @animationfinish="animationfinish"
			style="height: 100%;width: 100%;">
			<swiper-item>
				<scroll-view scroll-y style="height: 100%;width: 100%;">
					<card v-for="(item,index) in recordList1" :key="index" :name="item.name" :age="item.age"
						:sex="item.gender" :drugs="item.drugs" :consultId="item.id" :time="item.createTime"
						:status="item.status"></card>
				</scroll-view>
			</swiper-item>
			<swiper-item>
				<scroll-view scroll-y style="height: 100%;width: 100%;">
					<card v-for="(item,index) in recordList2" :key="index" :name="item.name" :age="item.age"
						:sex="item.gender" :drugs="item.drugs" :consultId="item.id" :time="item.createTime"
						:status="item.status"></card>
				</scroll-view>
			</swiper-item>
		</swiper>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				loadModal: false,
				doctorId: '',
				list: [{
					name: '待完成'
				}, {
					name: '已完成'
				}],
				current: 0, // tabs组件的current值，表示当前活动的tab选项
				swiperCurrent: 0, // swiper组件的current值，表示当前那个swiper-item是活动的
				barStyle: {
					"height": "10rpx",
					"border-radius": "0"
				},
				recordList: [],
				recordList1: [],
				recordList2: []
			}
		},
		methods: {
			tabsChange(index) {
				this.swiperCurrent = index;
			},
			// swiper-item左右移动，通知tabs的滑块跟随移动
			transition(e) {
				let dx = e.detail.dx;
				this.$refs.uTabs.setDx(dx);
			},
			// 由于swiper的内部机制问题，快速切换swiper不会触发dx的连续变化，需要在结束时重置状态
			// swiper滑动结束，分别设置tabs和swiper的状态
			animationfinish(e) {
				let current = e.detail.current;
				this.$refs.uTabs.setFinishCurrent(current);
				this.swiperCurrent = current;
				this.current = current;
			},
			getUserId() {
				let _this = this;
				// uni.getStorage({
				// 	key: 'doctorId',
				// 	success: function(res) {
				// 		_this.doctorId = res.data
				// 		_this.getRecordList()
				// 	}
				// });
				_this.doctorId = 1;
				_this.getRecordList()
			},
			getRecordList() {
				let _this = this;
				_this.loadModal = true
				uni.request({
					url: 'http://172.20.10.8:8886/consult/findByDoctorId',
					data: {
						id: _this.doctorId
					},
					success: (res) => {
						// console.log(res.data.data)
						_this.recordList = res.data.data;
						for (let i = 0; i < _this.recordList.length; i++) {
							let drugsNumber = _this.recordList[i].drugIds.split(',')
							_this.recordList[i].drugs = ''
							for (let j = 0; j < drugsNumber.length; j++) {
								uni.request({
									url: 'http://172.20.10.8:8886/drug/findById',
									data: {
										id: drugsNumber[j]
									},
									success: (res) => {
										if (j != 0) {
											_this.recordList[i].drugs += '、'
										}
										_this.recordList[i].drugs += res.data.data[0].drugName
										console.log(_this.recordList[i].drugs)
										if (j == drugsNumber.length - 1) {
											if (_this.recordList[i].status == 0) {
												_this.recordList1.push(_this.recordList[i])
												console.log(_this.recordList1);
											} else {
												_this.recordList2.push(_this.recordList[i])
											}
											if (i == _this.recordList.length - 1) {
												_this.loadModal = false
												_this.recordList1.sort(function(a, b) {
													return a.id < b.id
												})
												_this.recordList2.sort(function(a, b) {
													return a.id < b.id
												})
											}
										}
									}
								})
							}
						}
					},
				});
			}
		},
		mounted() {
			this.getUserId()
		}
	}
</script>

<style>
	.wrap {
		height: 100vh;
	}
</style>
