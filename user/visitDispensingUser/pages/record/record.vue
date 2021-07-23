<template>
	<view>
		<card v-for="(item,index) in recordList" :key="index" :time="item.createTime" :status="item.status"
			:doctorName="item.doctorName" :patienceName="item.name" :sickStatus="item.des" :consultId="item.id"
			:patienceInfo="item"></card>
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
				userId:'',
				recordList: [],
				loadModal:false,
				doctorName:''
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
				 _this.getRecordList()
			},
			getRecordList() {
				let _this = this;
				_this.loadModal=true
				uni.request({
					url: 'http://47.111.10.102:8886/consult/findByUserId',
					data:{
						id:_this.userId
					},
					success: (res) => {
						console.log(res.data.data)
						_this.recordList = res.data.data;
						if(_this.recordList==undefined){
							_this.loadModal=false
							return;
						}
						for(let i = 0; i < _this.recordList.length; i++){
							uni.request({
								url: 'http://47.111.10.102:8886/doctor/findOne',
								data:{
									id:_this.recordList[i].docId
								},
								success:(res)=>{
									_this.recordList[i].doctorName=res.data.data[0].name
									_this.doctorName=res.data.data[0].name
										console.log(_this.recordList[i].doctorName)
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
