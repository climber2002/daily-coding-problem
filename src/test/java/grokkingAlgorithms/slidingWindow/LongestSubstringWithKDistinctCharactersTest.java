package grokkingAlgorithms.slidingWindow;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LongestSubstringWithKDistinctCharactersTest {
    @Test
    public void test() {
        assertEquals(4, LongestSubstringWithKDistinctCharacters.getResult("araaci", 2));
        assertEquals(2, LongestSubstringWithKDistinctCharacters.getResult("araaci", 1));
        assertEquals(5, LongestSubstringWithKDistinctCharacters.getResult("cbbebi", 3));
    }
}
