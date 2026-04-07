class DynamicArray:
    
    def __init__(self, capacity: int):
        if(capacity > 0):
            self.capacity = capacity
            self.array = [None] * capacity
            self.length = 0

    def get(self, i: int) -> int:
        return self.array[i]

    def set(self, i: int, n: int) -> None:
        self.array[i] = n

    def pushback(self, n: int) -> None:
        if(self.length == self.capacity):
            self.resize()
        self.array[self.length] = n 
        self.length += 1


    def popback(self) -> int:
        result = self.array[self.length-1]
        self.array[self.length - 1] = None
        self.length -= 1
        return result

    def resize(self) -> None:
        self.capacity *= 2
        new_array = [None] * (self.capacity)
        new_array[:self.length] = self.array[:]
        self.array = new_array

    def getSize(self) -> int:
        return self.length
    
    def getCapacity(self) -> int:
        return self.capacity
