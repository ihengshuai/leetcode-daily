/**
 * 	将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 	输入：l1 = [1,2,4], l2 = [1,3,4]
		输出：[1,1,2,3,4,4]
 */

class ListNode {
	constructor(public val: number, public next: ListNode | null) { }
}

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
	if (list1 == null) return list2
	else if (list2 == null) return list1
	else if (list1.val < list2.val) {
		list1.next = mergeTwoLists(list1.next, list2)
		return list1
	}
	else {
		list2.next = mergeTwoLists(list1, list2.next)
		return list2
	}
};

const l4 = new ListNode(4, null)
const l3 = new ListNode(3, l4)
const l2 = new ListNode(2, l3)
const l1 = new ListNode(1, l2)
const ln = new ListNode(7, null)

console.log(mergeTwoLists(null, null))
console.log(mergeTwoLists(l3, l2))
