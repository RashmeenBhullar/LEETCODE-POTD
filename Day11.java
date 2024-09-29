import java.util.*;

class AllOne {
    // Map to store the count of each key
    private Map<String, Integer> key_count;
    // Doubly Linked List Node to store count and set of keys with that count
    private class Bucket {
        int count;
        Set<String> keys;
        Bucket prev, next;
        Bucket(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }
    private Bucket head, tail; // head for minimum, tail for maximum
    // Map to store count to Bucket node
    private Map<Integer, Bucket> count_bucket;

    public AllOne() {
        key_count = new HashMap<>();
        count_bucket = new HashMap<>();
        head = new Bucket(Integer.MIN_VALUE); // Dummy head
        tail = new Bucket(Integer.MAX_VALUE); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Increment the key's count
    public void inc(String key) {
        if (!key_count.containsKey(key)) {
            key_count.put(key, 1);
            if (!count_bucket.containsKey(1)) {
                addBucketAfter(head, new Bucket(1));
            }
            count_bucket.get(1).keys.add(key);
        } else {
            int count = key_count.get(key);
            Bucket currentBucket = count_bucket.get(count);
            int newCount = count + 1;
            key_count.put(key, newCount);
            if (!count_bucket.containsKey(newCount)) {
                addBucketAfter(currentBucket, new Bucket(newCount));
            }
            count_bucket.get(newCount).keys.add(key);
            removeKeyFromBucket(currentBucket, key);
        }
    }

    // Decrement the key's count
    public void dec(String key) {
        int count = key_count.get(key);
        Bucket currentBucket = count_bucket.get(count);
        if (count == 1) {
            key_count.remove(key);
        } else {
            int newCount = count - 1;
            key_count.put(key, newCount);
            if (!count_bucket.containsKey(newCount)) {
                addBucketAfter(currentBucket.prev, new Bucket(newCount));
            }
            count_bucket.get(newCount).keys.add(key);
        }
        removeKeyFromBucket(currentBucket, key);
    }

    // Get the key with the maximum count
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    // Get the key with the minimum count
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    // Helper method to add a bucket after a given bucket
    private void addBucketAfter(Bucket prevBucket, Bucket newBucket) {
        newBucket.prev = prevBucket;
        newBucket.next = prevBucket.next;
        prevBucket.next.prev = newBucket;
        prevBucket.next = newBucket;
        count_bucket.put(newBucket.count, newBucket);
    }

    // Helper method to remove a key from a bucket
    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keys.remove(key);
        if (bucket.keys.isEmpty()) {
            removeBucketFromList(bucket);
            count_bucket.remove(bucket.count);
        }
    }

    // Helper method to remove a bucket from the doubly linked list
    private void removeBucketFromList(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }
}
