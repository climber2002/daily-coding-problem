package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a set X of positive integers and target integer T, is there a subset of elements in X that add up to T ?
 */
public class SubsetSum {
  public static Set<Set<Integer>> getSubsets(Set<Integer> set, Integer sum) {
    Set<Set<Integer>> result = new HashSet<>();
    backtrack(sum, set, new HashSet<>(), result);
    return result;
  }

  private static void backtrack(int n, Set<Integer> remaining, Set<Integer> currentSubset, Set<Set<Integer>> result) {
//    System.out.println("n: " + n);
//    System.out.println("remaining: " + Arrays.toString(remaining.toArray(new Integer[0])));
//    System.out.println("currentSubset: " + Arrays.toString(currentSubset.toArray(new Integer[0])));
//    System.out.println("result: " + Arrays.toString(result.stream().map(set -> Arrays.toString(set.toArray(new Integer[0]))).toArray()));
//    System.out.println("");

    if(n == 0) {
      result.add(new HashSet<>(currentSubset));
      return;
    }

    if(n < 0 || remaining.size() == 0) {
      return;
    }

    Integer randomInt = remaining.iterator().next();
//    System.out.println("randomInt: " + randomInt);
//    System.out.println("");
    remaining.remove(randomInt);

    currentSubset.add(randomInt);
    backtrack(n - randomInt, new HashSet<>(remaining), currentSubset, result);
    currentSubset.remove(randomInt);

    backtrack(n, new HashSet<>(remaining), currentSubset, result);
  }

}
