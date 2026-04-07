class ListNode:
     def __init__(self, val = 0, next = None):
         self.val = val
         self.next = next

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
    
    def get(self, index: int) -> int:
        current = self.head
        while(index > 0):
            if(current == None):
                return -1
            else:
                current = current.next
                index -= 1
        if current:
            return current.val
        else:
            return -1

    def insertHead(self, val: int) -> None:
        new_node = ListNode(val)
        new_node.next = self.head
        self.head = new_node

        if(self.tail is None):
            self.tail = self.head

    def insertTail(self, val: int) -> None:
        new_node = ListNode(val)
        if self.tail:
            self.tail.next = new_node
            self.tail = new_node
        else:
            self.head = new_node
            self.tail = new_node

    def remove(self, index: int) -> bool:
        if(index == 0):
            if(self.head):
                current = self.head
                self.head = self.head.next
                current = None
                return True
            else:
                return False

        current = self.head
        while(index > 1):
            if(current is None):
                return False
            else:
                current = current.next
                index -= 1
        
        if current and current.next:
            if current.next == self.tail:
                self.tail = current
            current.next = current.next.next
            return True
        return False

    def getValues(self) -> List[int]:
        linked_list_array = []
        current = self.head
        while(current):
            linked_list_array.append(current.val)
            current = current.next
        return linked_list_array
