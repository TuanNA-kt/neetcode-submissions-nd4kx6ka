class TrieNodeDict:
    def __init__(self):
        self.word = False
        self.child_map = {}

class WordDictionary:

    def __init__(self):
        self.root = TrieNodeDict()

    def addWord(self, word: str) -> None:
        cur = self.root
        for c in word:
            if (c not in cur.child_map):
                cur.child_map[c] = TrieNodeDict()
            cur = cur.child_map[c]
        cur.word = True

    def search(self, word: str) -> bool:
        word_stack = [self.root]
        
        for c in word:
            new_word_stack = []
            while (word_stack):
                word_node = word_stack.pop()
                if (c ==  '.'):
                    for child_node in word_node.child_map.values():
                        new_word_stack.append(child_node)
                elif (c in word_node.child_map):
                    new_word_stack.append(word_node.child_map[c])
            if (not new_word_stack):
                return False
            else: word_stack = new_word_stack

        for word in word_stack:
            if(word.word): return True
        return False
    
    def dfs_search(self, word: str, i: int) -> bool:
        cur = root

        for i in range(j, len(word)):
            c = word[i]
            if c == ".":
                for child in cur.child_map.values():
                    if dfs_search(word, i):
                        return True
                    else:
                        return False

            if c in child_map:
                if dfs_search(word, i):
                    return True
            else: return False

            
        return cur.word
        

