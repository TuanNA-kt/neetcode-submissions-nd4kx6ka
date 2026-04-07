class PrefixTree:
    class TrieNode:
        def __init__(self):
            self.nodes = {}
            self.word = False
    
    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for c in word:
            if c not in cur.nodes:
                cur.nodes[c] = self.TrieNode()
            cur = cur.nodes[c]
        cur.word = True

    def search(self, word: str) -> bool:
        cur = self.root
        for c in word:
            if(c in cur.nodes):
                cur = cur.nodes[c]
            else: return False
        if(cur.word): 
            return True
        else: return False

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for c in prefix:
            if(c in cur.nodes):
                cur = cur.nodes[c]
            else: return False
        return True
        