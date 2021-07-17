<template>
	<view>
		<card v-for="(item,index) in recordList" :key="index" :time="item.time" :status="item.status"
			:doctorName="item.doctorName" :patienceName="item.patienceName" :sickStatus="item.sickStatus" :consultId="item.consultId"></card>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userId:'',
				recordList: [],
			}
		},
		methods: {
			getUserId(){
				let _this = this;
				uni.getStorage({
				    key: 'userId',
				    success: function (res) {
				       _this.userId=res.data
					   	console.log(_this.userId);
						_this.getRecordList()
				    }
				});
			},
			getRecordList() {
				let _this = this;
				console.log(_this.userId)
				uni.request({
					url: 'http://172.20.10.8:8886/consult/findByUserId',
					data:{
						id:_this.userId
					},
					success: (res) => {
						_this.recordList = res.data.data;
						console.log(_this.recordList)
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
