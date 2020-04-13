import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: LeetCode Problem355:设计推特
 * @date: 2020/4/13 18:05
 * @author: Finallap
 * @version: 1.0
 */
public class Problem355 {
    HashMap<Integer, Set<Integer>> followMap = new HashMap<>();
    HashMap<Integer, Set<Tweet>> tweetMap = new HashMap<>();
    AtomicLong atomicGlobalId = new AtomicLong();

    class Tweet {
        public int tweetId;
        public long globalId;

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.globalId = atomicGlobalId.getAndIncrement();
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Problem355() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
            tweetMap.put(userId, new HashSet<>());
        }
        Set<Tweet> tweetSet = tweetMap.get(userId);
        tweetSet.add(new Tweet(tweetId));
        tweetMap.put(userId, tweetSet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!followMap.containsKey(userId)) {
            return result;
        }

        Set<Integer> userSet = followMap.get(userId);
        userSet.add(userId);
        Iterator<Integer> userIter = userSet.iterator();
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>((o1, o2) -> (int) (o2.globalId - o1.globalId));
        while (userIter.hasNext()) {
            int currUserId = userIter.next();
            Set<Tweet> currUserTweetSet = tweetMap.get(currUserId);
            Iterator<Tweet> tweetIter = currUserTweetSet.iterator();
            while (tweetIter.hasNext()) {
                Tweet tweet = tweetIter.next();
                queue.add(tweet);
            }
        }
        int count = 10;
        while (!queue.isEmpty() && count > 0) {
            result.add(queue.poll().tweetId);
            count--;
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
            tweetMap.put(followerId, new HashSet<>());
        }
        if (!followMap.containsKey(followeeId)) {
            followMap.put(followeeId, new HashSet<>());
            tweetMap.put(followeeId, new HashSet<>());
        }
        Set<Integer> followeeSet = followMap.get(followerId);
        followeeSet.add(followeeId);
        followMap.put(followerId, followeeSet);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId))
            return;
        Set<Integer> followeeSet = followMap.get(followerId);
        if (!followeeSet.contains(followeeId))
            return;
        followeeSet.remove(followeeId);
        followMap.put(followerId, followeeSet);
    }

    public static void main(String[] args) {
        Problem355 twitter = new Problem355();
        twitter.postTweet(1, 5);
        List<Integer> list1 = twitter.getNewsFeed(1);
        System.out.println(list1.toString());
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        List<Integer> list2 = twitter.getNewsFeed(1);
        System.out.println(list2.toString());
        twitter.unfollow(1, 2);
        List<Integer> list3 = twitter.getNewsFeed(1);
        System.out.println(list3.toString());
    }
}
