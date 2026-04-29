class RangeNode:
    def __init__(self, start: int, end: int):
        self.start = start
        self.end = end
        self.left = None
        self.right = None
        

class MyCalendar:
    def __init__(self):
        self.root = None

    def book(self, startTime: int, endTime: int) -> bool:
        node = RangeNode(startTime, endTime)
        if(self.root is None):
            self.root = node
            return True
        cur = self.root
        while(cur is not None):
            if startTime >= cur.end:
                if(cur.right is not None):
                    cur = cur.right
                else:
                    cur.right = node
                    return True
            elif endTime <= cur.start:
                if(cur.left is not None):
                    cur = cur.left
                else:
                    cur.left = node
                    return True
            else:
                return False
        



# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(startTime,endTime)