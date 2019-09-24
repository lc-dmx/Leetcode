class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
        int bucketNumber = (max - min) / bucketSize + 1;
        Bucket[] buckets = new Bucket[bucketNumber];

        for (int i = 0; i < bucketNumber; i++) {
            buckets[i] = new Bucket();
        }

        for (int num : nums) {
            int bucketIdx = (num - min) / bucketSize;
            buckets[bucketIdx].used = true;
            buckets[bucketIdx].min = Math.min(num, buckets[bucketIdx].min);
            buckets[bucketIdx].max = Math.max(num, buckets[bucketIdx].max);
        }

        int prevBucketMax = min, maxGap = 0;
        for (Bucket bucket : buckets) {
            if (!bucket.used) {
                continue;
            }
            maxGap = Math.max(maxGap, bucket.min - prevBucketMax);
            prevBucketMax = bucket.max;
        }
        return maxGap;
    }
}
class Bucket {
    boolean used = false;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
}
