class Solution {
    public Set<Character> toSortedSet(String s){
        Set<Character> set = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2){
                if(o1==o2) return 0;
                else if(o1>o2) return 1;
                else return -1;
            }
        });
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        System.out.println(String.valueOf(set));
        return set;
    }

    public String removeDuplicateLetters(String s) {
        for(char c: toSortedSet(s)){
            System.out.println(c);
            String suffix = s.substring(s.indexOf(c));
            if(toSortedSet(s).equals(toSortedSet(suffix))){
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
            }
        }
        return "";
    }
}