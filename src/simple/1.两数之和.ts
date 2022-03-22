/**
 * 	给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
		你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
		你可以按任意顺序返回答案。

		示例 1：
		输入：nums = [2,7,11,15], target = 9
		输出：[0,1]
		解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

		示例 2：
		输入：nums = [3,2,4], target = 6
		输出：[1,2]

		示例 3：
		输入：nums = [3,3], target = 6
		输出：[0,1]
 */

/**
 * 	小结：
 * 		hashTable
 * 		暴力递归
 */

// 1. 暴力枚举
/**
 * 	复杂度分析:
			时间复杂度：O(N^2)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
			空间复杂度：O(1)。
 */
function twoSum(nums: Array<number>, target: number): Array<number> {
	if (nums.length < 2) return []

	const res = []
	for (let i = 0; i < nums.length - 1; i++) {
		for (let j = i + 1; j < nums.length; j++) {
			if (nums[i] + nums[j] == target) {
				res.push(i, j)
				break
			}
		}
	}
	return res
}

// 2.hashTable
/**
 * 	复杂度分析:
			时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
			空间复杂度：O(1)。
 */
function twoSumForHashTable(nums: Array<number>, target: number): Array<number> {
	if (nums.length < 2) return []
	const res = [], hashTable: { [prop: number]: number } = {}
	for (let i = 0; i < nums.length; i++) {
		if (hashTable[target - nums[i]] !== undefined) {
			res.push(hashTable[target - nums[i]], i)
			break
		}
		hashTable[nums[i]] = i
	}
	return res
}

console.log(twoSum([4, -1, 6, 0], -1))
console.log(twoSumForHashTable([4, -1, 6, 0], -1))
