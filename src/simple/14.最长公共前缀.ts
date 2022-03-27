/**
 * 	编写一个函数来查找字符串数组中的最长公共前缀。
		如果不存在公共前缀，返回空字符串 ""。

		示例 1：
		输入：strs = ["flower","flow","flight"]
		输出："fl"

		示例 2：
		输入：strs = ["dog","racecar","car"]
		输出：""
		解释：输入不存在公共前缀。
 */

/**
 * 	横向扫描
 * 	复杂度分析
		时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
		空间复杂度：O(1)。使用的额外空间复杂度为常数。
 */
function longestCommonPrefix1(strs: Array<string>): string {
	if (!strs || !strs.length) return ''
	let prefix = strs[0]
	for (let i = 1; i < strs.length; i++) {
		prefix = getLongestTwoCommonPrefix(prefix, strs[i])
		if (!prefix.length) break
	}
	return prefix
};

/**
 * 	复杂度分析
		时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
		空间复杂度：O(1)。使用的额外空间复杂度为常数。
 */
function longestCommonPrefix2(strs: Array<string>): string {
	if (!strs || !strs.length) return ''
	let prefix = ''
	wrap: for (let i = 0; i < strs[0].length; i++) {
		const c = strs[0].charAt(i)
		for (let j = 1; j < strs.length; j++) {
			if (strs[j].charAt(i) !== c || i == strs[j].length) break wrap;
		}
		prefix += c
	}
	return prefix
}

function getLongestTwoCommonPrefix(str1: string, str2: string): string {
	const len = Math.min(str1.length, str2.length)
	let i = 0
	while (i < len && str1.charAt(i) === str2.charAt(i)) i++
	return str1.substring(0, i)
}

console.log(longestCommonPrefix1(['asdffgdhtgd', 'asdghsdhg', 'agdfg']))
console.log(longestCommonPrefix2(['asdffgdhtgd', 'asdghsdhg', 'agdfg']))
