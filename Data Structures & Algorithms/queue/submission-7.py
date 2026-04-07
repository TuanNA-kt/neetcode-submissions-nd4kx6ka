class ListNode:
    def __init__(self, val, prev = None, next = None):
        self.val = val
        self.next = next
        self.prev = prev

class Deque:
    
    def __init__(self):
        self.head = self.tail = None

    def isEmpty(self) -> bool:
        if(self.head == self.tail == None):
            return True
        else: 
            return False

    def append(self, value: int) -> None:
        if(self.head is None):
            self.head = self.tail = ListNode(value)
        else:
            self.tail.next = ListNode(value, self.tail, None)
            self.tail = self.tail.next

    def appendleft(self, value: int) -> None:
        if(self.head is None):
            self.head = self.tail = ListNode(value)
        else:
            self.head.prev = ListNode(value, None, self.head)
            self.head = self.head.prev

    def pop(self) -> int:
        if(self.head is None and self.tail is None):
            return -1

        if(self.head == self.tail):
            value = self.head.val
            self.head = self.tail = None
            return value

        value = self.tail.val
        self.tail.prev.next = None
        self.tail = self.tail.prev
        return value

    def popleft(self) -> int:
        if(self.head is None):
            return -1

        if(self.head == self.tail):
            value = self.head.val
            self.head = self.tail = None
            return value

        value = self.head.val
        self.head.next.prev = None
        self.head = self.head.next
        self.head.prev = None
        return value
