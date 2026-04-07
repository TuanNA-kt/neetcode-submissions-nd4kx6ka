class Solution:
    def isValid(self, s: str) -> bool:
        my_dict = {'(' : ')', '{' : '}', '[' : ']'}
        stack = []
        for char in s:
            if(char in my_dict):
                stack.append(char)
            else:
                
                if(stack and my_dict[stack[-1]] == char):
                    stack.pop()
                else:
                    return False

        return not stack

                
        