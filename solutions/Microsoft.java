public class Microsoft {
    public static void main(String[] args){
        Microsoft microsoft = new Microsoft();
        String s = "asfl";
        int ans = microsoft.swapPalindrome(s);
        // System.out.println("hello");
        System.out.println(ans);
    }

    // minimun adjacent letter swap to make string palindrome, if impossible return -1;
    public int swapPalindrome(String str){
        // check if it is possible
        char[] arr = str.toCharArray();
        int[] freq = new int[26];
        for(char c : arr){
            freq[c - 'a'] ++;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 != 0){
                count++;
            }
            if(count > 1){
                return -1;
            } 
        }
        
        count = 0;

        int p1 = 0, p2 = arr.length - 1;
        while(p1 < p2){
            if(arr[p1] == arr[p2]){
                p1++;
                p2--;
            }else{
                // find a char == arr[p1]
                int p3 = p2;
                while(p3 > p1 && arr[p3] != arr[p1]){
                    p3--;
                }
                if(p3 == p1){// did not find the char, then arr[p1] will be the pivot
                    swap(arr, p1, p1 + 1);
                    count += 1;
                }else{
                    while(p3 < p2){
                        swap(arr, p3, p3 + 1);
                        p3++;
                        count ++;
                    }
                    p1++; p2--;
                }
            }
        }
        return count;
    }
    private void swap(char[] chars, int k, int i) {
        char temp = chars[k];
        chars[k] = chars[i];
        chars[i] = temp;
    }
}
