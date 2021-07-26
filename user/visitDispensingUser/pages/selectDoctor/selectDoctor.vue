<template>
	<view>
		<doctorCard v-for="(item,index) in doctorList" :key="index" :id="item.id" :name="item.name" :level="item.level"
			:dept="item.dept" :org="item.org" @click.native="select(index)" :src="item.avatarUrl"></doctorCard>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				doctorList: [],
			}
		},
		methods: {
			getRecordList() {
				let _this = this;
				uni.request({
					url: 'http://47.111.10.102:8886/doctor/getAll',
					success: (res) => {
						_this.doctorList = res.data.data
					},
				});
			},
			select(index) {
				let _this = this;
				var pages = getCurrentPages();
				var currPage = pages[pages.length - 1]; //当前页面
				var prevPage = pages[pages.length - 2]; //上一个页面
				prevPage.$vm.doctorLevel = _this.doctorList[index].level;
				prevPage.$vm.doctorName = _this.doctorList[index].name;
				prevPage.$vm.doctorSubject = _this.doctorList[index].dept;
				prevPage.$vm.form.doc_id = _this.doctorList[index].id;
				prevPage.$vm.src = _this.doctorList[index].avatarUrl;
				uni.navigateBack()
			}
		},
		mounted() {
			this.getRecordList()
		}
	}
</script>

<style>

</style>
