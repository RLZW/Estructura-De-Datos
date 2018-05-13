package mx.itesm.cem.ordenamientos;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ExercisesTest {

    private static final List<String> stringListEmpty = Arrays
            .asList();
    private static final List<Integer> integerListEmpty = Arrays
            .asList();
    private static final List<Double> doubleListEmpty = Arrays
            .asList();

    private static final List<Double> doubleList = Arrays
            .asList(0.3115440775732701, 0.26535561491023296,
                    0.5482633610326869, 0.1261965127933492,
                    0.5281938098544279, 0.2498792562954667,
                    0.7161109655440545, 0.8709930814574389);

    private static final List<Double> doubleListSorted = Arrays
            .asList(0.1261965127933492, 0.2498792562954667,
                    0.26535561491023296, 0.3115440775732701,
                    0.5281938098544279, 0.5482633610326869,
                    0.7161109655440545, 0.8709930814574389);

    private static final List<String> stringList = Arrays
            .asList("Fili", "Kili", "Oin", "Gloin",
                    "Thorin", "Dwalin", "Balin", "Bifur",
                    "Bofur", "Bombur", "Dori", "Nori",
                    "Ori");

    private static final List<String> stringListSorted = Arrays
            .asList("Balin", "Bifur", "Bofur", "Bombur",
                    "Dori", "Dwalin", "Fili", "Gloin",
                    "Kili", "Nori", "Oin", "Ori", "Thorin");

    private static final List<Integer> integerList = Arrays
            .asList(780, 560, 726, 524, 794, 454, 628, 335,
                    786, 992, 559, 798, 427, 382, 900, 391,
                    981, 432, 963, 727, 863, 861, 38, 567,
                    29, 805, 711, 926, 902, 97, 469, 644,
                    687, 605, 503, 530, 145, 161, 425, 417,
                    410, 963, 729, 899, 57, 366, 600, 721,
                    536, 125, 491, 192, 961, 749, 785, 271,
                    660, 646, 73, 894, 74, 574, 993, 239,
                    384, 347, 390, 695, 469, 965, 685, 865,
                    605, 518, 572, 380, 895, 625, 410, 804,
                    681, 190, 351, 889, 155, 389, 289, 984,
                    950, 694, 953, 222, 372, 752, 367, 771,
                    386, 645, 614, 93, 386, 21, 444, 123,
                    332, 236, 227, 57, 896, 321, 428, 978,
                    726, 598, 516, 539, 316, 461, 288, 930,
                    806, 480, 197, 111, 206, 86, 875, 254,
                    936, 156, 566, 719, 244, 662, 133, 860,
                    654, 445, 479, 755, 37, 57, 208, 383,
                    502, 794, 538, 742, 760, 355, 52, 530,
                    128, 359, 298, 847, 794, 660, 721, 84,
                    498, 225, 296, 60, 511, 427, 905, 118,
                    542, 572, 708, 334, 377, 648, 983, 327,
                    127, 578, 756, 113, 936, 737, 950, 982,
                    905, 317, 372, 745, 83, 169, 134, 552,
                    850, 198, 707, 680, 977, 599, 276, 714);

    private static final List<Integer> integerListSorted = Arrays
            .asList(21, 29, 37, 38, 52, 57, 57, 57, 60, 73,
                    74, 83, 84, 86, 93, 97, 111, 113, 118,
                    123, 125, 127, 128, 133, 134, 145, 155,
                    156, 161, 169, 190, 192, 197, 198, 206,
                    208, 222, 225, 227, 236, 239, 244, 254,
                    271, 276, 288, 289, 296, 298, 316, 317,
                    321, 327, 332, 334, 335, 347, 351, 355,
                    359, 366, 367, 372, 372, 377, 380, 382,
                    383, 384, 386, 386, 389, 390, 391, 410,
                    410, 417, 425, 427, 427, 428, 432, 444,
                    445, 454, 461, 469, 469, 479, 480, 491,
                    498, 502, 503, 511, 516, 518, 524, 530,
                    530, 536, 538, 539, 542, 552, 559, 560,
                    566, 567, 572, 572, 574, 578, 598, 599,
                    600, 605, 605, 614, 625, 628, 644, 645,
                    646, 648, 654, 660, 660, 662, 680, 681,
                    685, 687, 694, 695, 707, 708, 711, 714,
                    719, 721, 721, 726, 726, 727, 729, 737,
                    742, 745, 749, 752, 755, 756, 760, 771,
                    780, 785, 786, 794, 794, 794, 798, 804,
                    805, 806, 847, 850, 860, 861, 863, 865,
                    875, 889, 894, 895, 896, 899, 900, 902,
                    905, 905, 926, 930, 936, 936, 950, 950,
                    953, 961, 963, 963, 965, 977, 978, 981,
                    982, 983, 984, 992, 993);

    @Test
    public void testSelectionSort() {
        assertEquals(stringListEmpty,
                Exercises.selectionSort(stringListEmpty));
        assertEquals(doubleListSorted,
                Exercises.selectionSort(doubleList));
        assertEquals(doubleListSorted,
                Exercises.selectionSort(doubleListSorted));
        assertEquals(stringListSorted,
                Exercises.selectionSort(stringList));
        assertEquals(stringListSorted,
                Exercises.selectionSort(stringListSorted));
        assertEquals(integerListSorted,
                Exercises.selectionSort(integerList));
        assertEquals(integerListSorted,
                Exercises.selectionSort(integerListSorted));
    }

    @Test
    public void testBucketSort() {
        List<Integer> a = Arrays.asList(84, 44, 30, 74, 57,
                62, 28, 3, 8, 17, 29, 90, 42, 83, 24, 65, 6,
                14, 48, 25);
        List<Integer> aSorted = Arrays.asList(3, 6, 8, 14,
                17, 24, 25, 28, 29, 30, 42, 44, 48, 57, 62,
                65, 74, 83, 84, 90);
        assertEquals(aSorted, Exercises.bucketSort(a));
        assertEquals(aSorted, Exercises.bucketSort(aSorted));
        assertEquals(integerListEmpty,Exercises.bucketSort(integerListEmpty));
    }

    @Test
    public void testBogoSort() {
        List<Integer> a = Arrays.asList(57, 62, 17, 3, 8,
                17, 29, 90);
        List<Integer> aSorted = Arrays.asList(3, 8, 17, 17,
                29, 57, 62, 90);
        assertEquals(aSorted, Exercises.bogoSort(a));
        assertEquals(aSorted, Exercises.bogoSort(aSorted));
        assertEquals(doubleListSorted,
                Exercises.bogoSort(doubleList));
        assertEquals(doubleListSorted,
                Exercises.bogoSort(doubleListSorted));
        assertEquals(stringListEmpty,
                Exercises.bogoSort(stringListEmpty));
        assertEquals(doubleListEmpty,
                Exercises.bogoSort(doubleListEmpty));
    }

    @Test
    public void testQuickSort() {
        assertEquals(stringListEmpty,
                Exercises.quickSort(stringListEmpty));
        assertEquals(doubleListSorted,
                Exercises.quickSort(doubleList));
        assertEquals(doubleListSorted,
                Exercises.quickSort(doubleListSorted));
        assertEquals(stringListSorted,
                Exercises.quickSort(stringList));
        assertEquals(stringListSorted,
                Exercises.quickSort(stringListSorted));
        assertEquals(integerListSorted,
                Exercises.quickSort(integerList));
        assertEquals(integerListSorted,
                Exercises.quickSort(integerListSorted));
    }
}