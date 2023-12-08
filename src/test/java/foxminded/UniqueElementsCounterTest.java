package foxminded;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UniqueElementsCounterTest {
    private UniqueElementsCounter uniqueElementsCounter;

    @BeforeEach
    void setUpIntegerDivisionVariable() {
        uniqueElementsCounter = new UniqueElementsCounter();
    }

    @Test
    void countUniqueElements_when_null_thenIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> uniqueElementsCounter.countUniqueElements(null), "null is not allowed!");
    }

    @Test
    void countUniqueElements_when_emptyString_then_emptyString(){
        //given
        String expected = "";
        //when
        String actual = uniqueElementsCounter.countUniqueElements("");
        //then
        assertEquals(expected, actual);
    }

    @Test
    void countUniqueElements_when_1WhiteSpace_then_1WhiteSpace(){
        //given
        String expected = "' ' - 1\n";
        //when
        String actual = uniqueElementsCounter.countUniqueElements(" ");
        //then
        assertEquals(expected, actual);
    }

    @Test
    void countUniqueElements_when_3WhiteSpace_then_3WhiteSpace(){
        //given
        String expected = "' ' - 3\n";
        //when
        String actual = uniqueElementsCounter.countUniqueElements("   ");
        //then
        assertEquals(expected, actual);
    }

    @Test
    void countUniqueElements_when_aabb_then_a_2_b2(){
        //given
        String expected = "'a' - 2\n" +
                          "'b' - 2\n";
        //when
        String actual = uniqueElementsCounter.countUniqueElements("aabb");
        //then
        assertEquals(expected, actual);
    }

    @Test
    void countUniqueElements_when_abc_then_a_1_b1_c1(){
        //given
        String expected = "'a' - 1\n" +
                "'b' - 1\n" +
                "'c' - 1\n";
        //when
        String actual = uniqueElementsCounter.countUniqueElements("abc");
        //then
        assertEquals(expected, actual);
    }

    @Test
    void countUniqueElements_when_helloWorld_thenhelowrld(){
        //given
        String expected = "'h' - 1\n" +
                          "'e' - 1\n" +
                          "'l' - 3\n" +
                          "'o' - 2\n" +
                          "' ' - 1\n" +
                          "'w' - 1\n" +
                          "'r' - 1\n" +
                          "'d' - 1\n" +
                          "'!' - 1\n";
        //when
        String actual = uniqueElementsCounter.countUniqueElements("hello world!");
        //then
        assertEquals(expected, actual);
    }
}