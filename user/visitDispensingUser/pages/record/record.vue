<template>
	<view>
		<card v-for="(item,index) in recordList" :key="index" :time="item.time" :status="item.status"
			:doctorName="item.doctorName" :patienceName="item.patienceName" :sickStatus="item.sickStatus"></card>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				recordList: [],
			}
		},
		methods: {
			getRecordList() {
				this.recordList.push({
					"time": "2022-07-18 11:26",
					"doctorName": 'aaa',
					"patienceName": 'aaa',
					"status": 1,
					"sickStatus": "asdasdsadsad"
				},
				{
					"time": "2022-07-18 11:26",
					"doctorName": 'aaa',
					"patienceName": 'aaa',
					"status": 0,
					"sickStatus": "asdasdsadsad"
				},
				{
					"time": "2022-07-18 11:26",
					"doctorName": 'aaa',
					"patienceName": 'aaa',
					"status": 1,
					"sickStatus": "asdasdsadsad"
				},
				{
					"time": "2022-07-18 11:26",
					"doctorName": 'aaa',
					"patienceName": 'aaa',
					"status": 1,
					"sickStatus": "asdasdsadsad"
				})
			}
		},
		mounted() {
			this.getRecordList()
		}
	}
</script>

<style>

</style>
