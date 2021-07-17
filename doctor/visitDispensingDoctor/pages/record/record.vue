<template>
	<view>
		<u-tabs-swiper ref="tabs" :list="list" :is-scroll="false"></u-tabs-swiper>
		
		<script>
			export default {
				data() {
					return {
						list: [{
							name: '待收货'
						}, {
							name: '待付款'
						}],
					}
				}
			}
		</script>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userId:'',
				recordList: [],
				loadModal:false
			}
		},
		methods: {
			getUserId(){
				let _this = this;
				uni.getStorage({
				    key: 'userId',
				    success: function (res) {
				       _this.userId=res.data
						_this.getRecordList()
				    }
				});
			},
			getRecordList() {
				let _this = this;
				_this.loadModal=true
				uni.request({
					url: 'http://172.20.10.8:8886/consult/findByUserId',
					data:{
						id:_this.userId
					},
					success: (res) => {
						_this.recordList = res.data.data;
						for(let i = 0; i < _this.recordList.length; i++){
							uni.request({
								url: 'http://172.20.10.8:8886/doctor/findOne',
								data:{
									id:_this.recordList[i].docId
								},
								success:(res)=>{
									_this.recordList[i].doctorName=res.data.data[0].name
									_this.recordList[i].avatarUrl=res.data.data[0].avatarUrl
								}
							})
							_this.loadModal=false
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

</style>
