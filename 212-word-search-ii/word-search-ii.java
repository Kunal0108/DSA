class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        //pull all words into Trie
        for(String word : words) {
            insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        //start depth first search from every cell
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void insert(String word) {
        TrieNode current = root;

        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {

        //out of bounds
        if(row < 0 || row >= board.length ||
           col < 0 || col >= board[0].length) {
            return;
        }

        char c = board[row][col];

        //already visited
        if(c == '#') {
            return;
        } 

        //no word starts with this path
        if(node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];

        //found a complete word
        if(node.word != null) {
            result.add(node.word);

            //prevent duplicate result
            node.word = null;
        }

        //mark current cell as visited
        board[row][col] = '#';

        //go up
        dfs(board, row - 1, col, node);

        //go down
        dfs(board, row + 1, col, node);

        //go left
        dfs(board, row, col - 1, node);

        //go right
        dfs(board, row, col + 1, node);

        //backtrack: restore the cell
        board[row][col] = c;
    }


}