/**
 * 	给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
		有效字符串需满足：
		左括号必须用相同类型的右括号闭合。
		左括号必须以正确的顺序闭合。
		 
		示例 1：
		输入：s = "()"
		输出：true

		示例 2：
		输入：s = "()[]{}"
		输出：true

		示例 3：
		输入：s = "(]"
		输出：false
 */

const bracketMap: { [prop: string]: number } = {
	'(': -1,
	')': 1,
	'[': -2,
	']': 2,
	'{': -3,
	'}': 3
}

/**
 * 	复杂度分析
		时间复杂度：O(n)，其中 nn 是字符串 s 的长度。
		空间复杂度：O(n+∣Σ∣)，其中 ∣Σ∣ 表示字符集，本题中字符串只包含 6 种括号，∣Σ∣ = 6。
		栈中的字符数量为 O(n)，而哈希表使用的空间为 O(∣Σ∣)，相加即可得到总空间复杂度。
 */

function isValidBracket(s: string): boolean {
	if (!s || s.length % 2) return false
	const stack: Array<string> = []
	let i = 0
	while (i < s.length) {
		if (bracketMap[s[i]] < 0) {
			stack.push(s[i])
		} else {
			const last = stack.pop()
			if (bracketMap[s[i]] + bracketMap[last!] != 0) return false
		}
		i++
	}
	return !stack.length
};

console.log(isValidBracket('(]'))
