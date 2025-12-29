class Solution {
    public int sumSubarrayMins(int[] arr) {
     int n = arr.length;
     int mod = 1000000007;
     int left[] = new int[n];
     int right[] = new int[n];
     Stack<Integer> st = new Stack<>();
//  previous smaller element (left)
    for(int i=0;i<n;i++){
        while(!st.isEmpty() && arr[st.peek()]>arr[i]){
            st.pop();
        }
        left[i] = st.isEmpty()?i+1:i-st.peek();
        st.push(i);
     }
     st.clear();
    //  next smaller element or equal
    for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
            st.pop();
        }
        right[i] = st.isEmpty()? n-i:st.peek()-i;
        st.push(i);
    }
    // calcuate answer
    long ans = 0;
    for(int i=0;i<n;i++){
        ans = ( ans + (long)arr[i]*left[i]*right[i])%mod;
    }
    return (int)ans;
    }
}