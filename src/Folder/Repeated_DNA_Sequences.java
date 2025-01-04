class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();

        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<s.length()-9;i++){
            String str = s.substring(i,i+10);
            if(map.containsKey(str)){
                set.add(str);
            }else{
                map.put(str,1);
            }
        }
        List<String> list = new ArrayList<>(set);
        return list;
    }
}