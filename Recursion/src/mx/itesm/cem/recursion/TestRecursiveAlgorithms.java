package mx.itesm.cem.recursion;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class TestRecursiveAlgorithms {

    @Test
    public void testGcd() {
        assertEquals(3, RecursiveAlgorithms.gcd(6, 15));
        assertEquals(42, RecursiveAlgorithms.gcd(42, 42));
        assertEquals(1, RecursiveAlgorithms.gcd(97, 23));
        assertEquals(1, RecursiveAlgorithms.gcd(1, 8));
        assertEquals(20, RecursiveAlgorithms.gcd(40, 100));
        assertEquals(2, RecursiveAlgorithms.gcd(1000, 666));
    }

    @Test
    public void testPow() {
        assertEquals(1, RecursiveAlgorithms.pow(100, 0));
        assertEquals(100, RecursiveAlgorithms.pow(100, 1));
        assertEquals(1, RecursiveAlgorithms.pow(1, 1000));
        assertEquals(10000,
                RecursiveAlgorithms.pow(100, 2));
        assertEquals(125, RecursiveAlgorithms.pow(5, 3));
        assertEquals(1073741824,
                RecursiveAlgorithms.pow(2, 30));
    }

    @Test
    public void testMax() {
        List<Integer> empty = Arrays.asList();
        List<Integer> a = Arrays.asList(16, 23, 4, 42, 8,
                15);
        List<Integer> b = Arrays.asList(-16, -23, -4, -42,
                -8, -15);
        List<Integer> c = Arrays.asList(780, 560, 726, 524,
                794, 454, 628, 335, 786, 992, 559, 798, 427,
                382, 900, 391, 981, 432, 963, 727, 863, 861,
                38, 567, 29, 805, 711, 926, 902, 97, 469,
                644, 687, 605, 503, 530, 145, 161, 425, 417,
                410, 963, 729, 899, 57, 366, 600, 721, 536,
                125, 491, 192, 961, 749, 785, 271, 660, 646,
                73, 894, 74, 574, 993, 239, 384, 347, 390,
                695, 469, 965, 685, 865, 605, 518, 572, 380,
                895, 625, 410, 804, 681, 190, 351, 889, 155,
                389, 289, 984, 950, 694, 953, 222, 372, 752,
                367, 771, 386, 645, 614, 93, 386, 21, 444,
                123, 332, 236, 227, 57, 896, 321, 428, 978,
                726, 598, 516, 539, 316, 461, 288, 930, 806,
                480, 197, 111, 206, 86, 875, 254, 936, 156,
                566, 719, 244, 662, 133, 860, 654, 445, 479,
                755, 37, 57, 208, 383, 502, 794, 538, 742,
                760, 355, 52, 530, 128, 359, 298, 847, 794,
                660, 721, 84, 498, 225, 296, 60, 511, 427,
                905, 118, 542, 572, 708, 334, 377, 648, 983,
                327, 127, 578, 756, 113, 936, 737, 950, 982,
                905, 317, 372, 745, 83, 169, 134, 552, 850,
                198, 707, 680, 977, 599, 276, 714);
        assertEquals(Integer.MIN_VALUE,
                RecursiveAlgorithms.max(empty));
        assertEquals(42, RecursiveAlgorithms.max(a));
        assertEquals(-4, RecursiveAlgorithms.max(b));
        assertEquals(993, RecursiveAlgorithms.max(c));
    }

    @Test
    public void testConsecutiveAddition() {
        assertEquals(75, RecursiveAlgorithms
                .consecutiveAddition(10, 15));
        assertEquals(5050, RecursiveAlgorithms
                .consecutiveAddition(1, 100));
        assertEquals(0, RecursiveAlgorithms
                .consecutiveAddition(6, 5));
        assertEquals(42, RecursiveAlgorithms
                .consecutiveAddition(42, 42));
    }

    @Test
    public void testToBinary() {
        assertEquals("", RecursiveAlgorithms.toBinary(0));
        assertEquals("1", RecursiveAlgorithms.toBinary(1));
        assertEquals("101",
                RecursiveAlgorithms.toBinary(5));
        assertEquals("11111",
                RecursiveAlgorithms.toBinary(31));
        assertEquals("100000",
                RecursiveAlgorithms.toBinary(32));
        assertEquals("1010011010",
                RecursiveAlgorithms.toBinary(666));
        assertEquals("1010101010101",
                RecursiveAlgorithms.toBinary(5461));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(RecursiveAlgorithms.isPalindrome(""));
        assertTrue(RecursiveAlgorithms.isPalindrome("a"));
        assertTrue(RecursiveAlgorithms.isPalindrome("ana"));
        assertTrue(RecursiveAlgorithms
                .isPalindrome("Anita lava la tina."));
        assertTrue(RecursiveAlgorithms
                .isPalindrome("La moral, claro, mal."));
        assertTrue(RecursiveAlgorithms.isPalindrome(
                "¿Subo tu auto o tu autobus?"));
        assertTrue(RecursiveAlgorithms.isPalindrome(
                "A mama Roma le aviva el amor a papa, "
                        + "y a papa Roma le aviva el "
                        + "amor a mama."));
        assertFalse(RecursiveAlgorithms.isPalindrome("la"));
        assertFalse(RecursiveAlgorithms
                .isPalindrome("Yo no hago yoga hoy."));
        assertFalse(RecursiveAlgorithms.isPalindrome(
                "Anita no quiere lavar la tina."));
    }
}