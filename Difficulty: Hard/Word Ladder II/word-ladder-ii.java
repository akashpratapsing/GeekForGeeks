// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String beginWord,
                                                      String endWord,
                                                      String[] wordList) {
        // Code here
        Set<String> set = new HashSet<>();
        for (String word : wordList){
            set.add(word);
        }

        Queue<ArrayList<String>> q = new LinkedList<>();
        q.offer(new ArrayList<>(List.of(beginWord)));

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while (!q.isEmpty()){
            ArrayList<String> list = q.poll();

            if (list.size() > level){
                level++;
                for (String it: usedOnLevel){
                    set.remove(it);
                }
                usedOnLevel.clear();
            }

            String word = list.get(list.size() - 1);

            if (word.equals(endWord)){
                if (ans.size() == 0){
                    ans.add(list);
                }else if (ans.get(0).size() == list.size()){
                    ans.add(list);
                }
            }

            for (int i = 0; i < word.length(); i++){
                for (char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArr = word.toCharArray();
                    replacedCharArr[i] = ch;

                    String replacedWord = new String(replacedCharArr);

                    if (set.contains(replacedWord)){
                        list.add(replacedWord);
                        
                        ArrayList<String> temp = new ArrayList<>(list);
                        q.offer(temp);

                        usedOnLevel.add(replacedWord);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        return ans;
    }
}