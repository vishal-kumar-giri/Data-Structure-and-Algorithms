class Solution {

    int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {

        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        mergeSort(prefix, 0, prefix.length - 1, lower, upper);

        return count;
    }

    private void mergeSort(long[] arr, int left, int right, int lower, int upper) {

        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, lower, upper);
        mergeSort(arr, mid + 1, right, lower, upper);

        countPairs(arr, left, mid, right, lower, upper);

        merge(arr, left, mid, right);
    }

    private void countPairs(long[] arr, int left, int mid, int right,
                            int lower, int upper) {

        int low = mid + 1;
        int high = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (low <= right && arr[low] - arr[i] < lower)
                low++;

            while (high <= right && arr[high] - arr[i] <= upper)
                high++;

            count += high - low;
        }
    }

    private void merge(long[] arr, int left, int mid, int right) {

        long[] temp = new long[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }
}